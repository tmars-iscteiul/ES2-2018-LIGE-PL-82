package data.results;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import utilities.Paths;

/**
 * Serves as an optimizer, filtering JMetal's results in order, and showing the most relevant ones, given a count. Also filters by top numberOfResults.
 * @author skner
 *
 */
public abstract class ResultsOptimizer {

	public static void optimize(String problemName, int numberOfResults) {
		int max_results = numberOfResults;

		File resultsFile = 
				new File(Paths.EXPERIMENTS_FOLDER + problemName + Paths.REFERENCE_FRONTS + problemName + ".rf");

		File solutionsFile = 
				new File(Paths.EXPERIMENTS_FOLDER + problemName + Paths.REFERENCE_FRONTS + problemName + ".rs");

		TreeMap<Double,Integer> scores = new TreeMap<Double,Integer>();

		try {
			Scanner s = new Scanner(resultsFile);
			double score;
			int n = 0;
			while (s.hasNextLine()) {
				String nextLine = s.nextLine();
				String[] valuesStr = nextLine.split(" ");
				double[] values = new double[valuesStr.length];

				for (int i = 0; i < valuesStr.length; i++) {
					values[i] = Double.parseDouble(valuesStr[i]);
				}

				score = distance(values);
				scores.put(score, n);

				n++;
			}
			s.close();
			
			if (n <= max_results)
				max_results = n;

			Set<?> set = scores.entrySet();
			Iterator<?> iterator = set.iterator();
			int[] topResults = new int[max_results];

			n = 0;
			
			while(iterator.hasNext()) {
				if (n >= max_results)
					break;
				
				@SuppressWarnings("unchecked")
				Map.Entry<Double,Integer> value = (Entry<Double, Integer>)iterator.next();
				topResults[n] = (int)value.getValue();
				
				n++;
			}

			List<String> topLines = new ArrayList<String>();
			List<String> topSolutions = new ArrayList<String>();

			s = new Scanner(resultsFile);
			n = 0;
			while (s.hasNextLine()) {
				String nextLine = s.nextLine();

				if (exists(n,topResults)) {
					topLines.add(nextLine);
				}

				n++;
			}
			s.close();

			s = new Scanner(solutionsFile);
			n = 0;
			while (s.hasNextLine()) {
				String nextLine = s.nextLine();

				if (exists(n,topResults)) {
					topSolutions.add(nextLine);
				}

				n++;
			}
			s.close();

			File topResultsFile = new File(Paths.EXPERIMENTS_FOLDER + problemName + Paths.REFERENCE_FRONTS + problemName + "_top.rf");
			File topSolutionsFile = new File(Paths.EXPERIMENTS_FOLDER + problemName + Paths.REFERENCE_FRONTS + problemName + "_top.rs");
			FileWriter resultsWriter;
			FileWriter solutionsWriter;

			try {
				resultsWriter = new FileWriter(topResultsFile);
				solutionsWriter = new FileWriter(topSolutionsFile);

				for (String line : topLines)
					resultsWriter.write(line + '\n');

				for (String solution : topSolutions)
					solutionsWriter.write(solution + '\n');

				resultsWriter.close();
				solutionsWriter.close();
			} catch (IOException e) {
				System.out.println("Cannot record in the file.");
			}

		} catch (FileNotFoundException e) {
			System.out.println("Cannot open results .rf file.");
		}
	}

	private static boolean exists(int n, int[] topResults) {
		for (int i = 0; i < topResults.length; i++)
			if (topResults[i] == n) return true;

		return false;
	}

	private static double distance(double[] values) {
		double distance = 0;

		for (int i = 0; i < values.length; i++)
			distance += Math.pow(values[i], 2);

		return Math.sqrt(distance);
	}

	public static void main(String[] args) {
		ResultsOptimizer.optimize("antiSpamProblem", 10);
	}
}

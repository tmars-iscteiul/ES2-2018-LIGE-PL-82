package data.jmetal.problems;

import java.io.IOException;

public class OptimizationProcess {
	
/* O conjunto de algoritmos adequados a cada tipo de problema est�o indicados aqui */
	String[] AlgorithsForDoubleProblemType = new String[]{"NSGAII","SMSEMOA","GDE3","IBEA","MOCell","MOEAD","PAES","RandomSearch"};
	String[] AlgorithsForIntegerProblemType = new String[]{"NSGAII","SMSEMOA","MOCell","PAES","RandomSearch"};
	String[] AlgorithsForBinaryProblemType = new String[]{"NSGAII","SMSEMOA","MOCell","MOCH","PAES","RandomSearch","SPEA2"};	

	public static void main(String[] args) {
		try {

/* Dever�o ser comentadas ou retiradas de coment�rio as linhas 
   correspondentes �s simula��es que se pretendem executar */
			ExperimentsDouble.main(null);
//			ExperimentsInteger.main(null);
//			ExperimentsBinary.main(null);

/* As simula��es com ExternalViaJAR no nome tem as fun��es de avalia��o 
   implementadas em .JAR externos que s�o invocados no m�todo evaluate() 
   As simula��es que executam .jar externos s�o muito mais demoradas, 
   maxEvaluations e INDEPENDENT_RUNS tem por isso valores mais baixos */
			ExperimentsDoubleExternalViaJAR.main(null);
//			ExperimentsIntegeExternalViaJAR.main(null);
//			ExperimentsBinaryExternalViaJAR.main(null);		
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
}

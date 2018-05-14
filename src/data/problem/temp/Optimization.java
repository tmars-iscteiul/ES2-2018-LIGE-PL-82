package data.problem.temp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Optimization {
	@JsonProperty("optimizerSelection") private String optimizerSelection;
	@JsonProperty("coralReefOptimization") private boolean coralReefOptimization;
	@JsonProperty("diferencialEvolution") private boolean diferencialEvolution;
	@JsonProperty("cmaes") private boolean cmaes;
	@JsonProperty("ees") private boolean ees;
	@JsonProperty("nees") private boolean nees;
	@JsonProperty("gga") private boolean gga;
	@JsonProperty("ssga") private boolean ssga;
	@JsonProperty("pwo2007") private boolean pwo2007;
	@JsonProperty("pwo2011") private boolean pwo2011;
	@JsonProperty("abyss") private boolean abyss;
	@JsonProperty("cellde") private boolean cellde;
	@JsonProperty("dmopso") private boolean dmopso;
	@JsonProperty("dmopsom") private boolean dmopsom;
	@JsonProperty("gde3") private boolean gde3;
	@JsonProperty("gwasfga") private boolean gwasfga;
	@JsonProperty("ibea") private boolean ibea;
	@JsonProperty("mocell") private boolean mocell;
	@JsonProperty("mochc") private boolean mochc;
	@JsonProperty("moead") private boolean moead;
	@JsonProperty("cmoead") private boolean cmoead;
	@JsonProperty("moeaddd") private boolean moeaddd;
	@JsonProperty("moeaddra") private boolean moeaddra;
	@JsonProperty("moeadstm") private boolean moeadstm;
	@JsonProperty("mombi") private boolean mombi;
	@JsonProperty("mombi2") private boolean mombi2;
	@JsonProperty("nsgaii") private boolean nsgaii;
	@JsonProperty("nsgaiim") private boolean nsgaiim;
	@JsonProperty("ssnsgaii") private boolean ssnsgaii;
	@JsonProperty("nsgaiii") private boolean nsgaiii;
	@JsonProperty("omopso") private boolean omopso;
	@JsonProperty("paes") private boolean paes;
	@JsonProperty("pesa2") private boolean pesa2;
	@JsonProperty("randomsearch") private boolean randomsearch;
	@JsonProperty("smpso") private boolean smpso;
	@JsonProperty("smpsom") private boolean smpsom;
	@JsonProperty("smsemoa") private boolean smsemoa;
	@JsonProperty("spea2") private boolean spea2;
	@JsonProperty("wasfga") private boolean wasfga;
	
	public Optimization(String optimizerSelection, boolean coralReefOptimization, boolean diferencialEvolution,
			boolean cmaes, boolean ees, boolean nees, boolean gga, boolean ssga, boolean pwo2007, boolean pwo2011,
			boolean abyss, boolean cellde, boolean dmopso, boolean dmopsom, boolean gde3, boolean gwasfga, boolean ibea,
			boolean mocell, boolean mochc, boolean moead, boolean cmoead, boolean moeaddd, boolean moeaddra,
			boolean moeadstm, boolean mombi, boolean mombi2, boolean nsgaii, boolean nsgaiim, boolean ssnsgaii,
			boolean nsgaiii, boolean omopso, boolean paes, boolean pesa2, boolean randomsearch, boolean smpso,
			boolean smpsom, boolean smsemoa, boolean spea2, boolean wasfga) {
		super();
		this.optimizerSelection = optimizerSelection;
		this.coralReefOptimization = coralReefOptimization;
		this.diferencialEvolution = diferencialEvolution;
		this.cmaes = cmaes;
		this.ees = ees;
		this.nees = nees;
		this.gga = gga;
		this.ssga = ssga;
		this.pwo2007 = pwo2007;
		this.pwo2011 = pwo2011;
		this.abyss = abyss;
		this.cellde = cellde;
		this.dmopso = dmopso;
		this.dmopsom = dmopsom;
		this.gde3 = gde3;
		this.gwasfga = gwasfga;
		this.ibea = ibea;
		this.mocell = mocell;
		this.mochc = mochc;
		this.moead = moead;
		this.cmoead = cmoead;
		this.moeaddd = moeaddd;
		this.moeaddra = moeaddra;
		this.moeadstm = moeadstm;
		this.mombi = mombi;
		this.mombi2 = mombi2;
		this.nsgaii = nsgaii;
		this.nsgaiim = nsgaiim;
		this.ssnsgaii = ssnsgaii;
		this.nsgaiii = nsgaiii;
		this.omopso = omopso;
		this.paes = paes;
		this.pesa2 = pesa2;
		this.randomsearch = randomsearch;
		this.smpso = smpso;
		this.smpsom = smpsom;
		this.smsemoa = smsemoa;
		this.spea2 = spea2;
		this.wasfga = wasfga;
	}
	
	public Optimization() {
		
	}

	public String getOptimizerSelection() {
		return optimizerSelection;
	}

	public void setOptimizerSelection(String optimizerSelection) {
		this.optimizerSelection = optimizerSelection;
	}

	public boolean isCoralReefOptimization() {
		return coralReefOptimization;
	}

	public void setCoralReefOptimization(boolean coralReefOptimization) {
		this.coralReefOptimization = coralReefOptimization;
	}

	public boolean isDiferencialEvolution() {
		return diferencialEvolution;
	}

	public void setDiferencialEvolution(boolean diferencialEvolution) {
		this.diferencialEvolution = diferencialEvolution;
	}

	public boolean isCmaes() {
		return cmaes;
	}

	public void setCmaes(boolean cmaes) {
		this.cmaes = cmaes;
	}

	public boolean isEes() {
		return ees;
	}

	public void setEes(boolean ees) {
		this.ees = ees;
	}

	public boolean isNees() {
		return nees;
	}

	public void setNees(boolean nees) {
		this.nees = nees;
	}

	public boolean isGga() {
		return gga;
	}

	public void setGga(boolean gga) {
		this.gga = gga;
	}

	public boolean isSsga() {
		return ssga;
	}

	public void setSsga(boolean ssga) {
		this.ssga = ssga;
	}

	public boolean isPwo2007() {
		return pwo2007;
	}

	public void setPwo2007(boolean pwo2007) {
		this.pwo2007 = pwo2007;
	}

	public boolean isPwo2011() {
		return pwo2011;
	}

	public void setPwo2011(boolean pwo2011) {
		this.pwo2011 = pwo2011;
	}

	public boolean isAbyss() {
		return abyss;
	}

	public void setAbyss(boolean abyss) {
		this.abyss = abyss;
	}

	public boolean isCellde() {
		return cellde;
	}

	public void setCellde(boolean cellde) {
		this.cellde = cellde;
	}

	public boolean isDmopso() {
		return dmopso;
	}

	public void setDmopso(boolean dmopso) {
		this.dmopso = dmopso;
	}

	public boolean isDmopsom() {
		return dmopsom;
	}

	public void setDmopsom(boolean dmopsom) {
		this.dmopsom = dmopsom;
	}

	public boolean isGde3() {
		return gde3;
	}

	public void setGde3(boolean gde3) {
		this.gde3 = gde3;
	}

	public boolean isGwasfga() {
		return gwasfga;
	}

	public void setGwasfga(boolean gwasfga) {
		this.gwasfga = gwasfga;
	}

	public boolean isIbea() {
		return ibea;
	}

	public void setIbea(boolean ibea) {
		this.ibea = ibea;
	}

	public boolean isMocell() {
		return mocell;
	}

	public void setMocell(boolean mocell) {
		this.mocell = mocell;
	}

	public boolean isMochc() {
		return mochc;
	}

	public void setMochc(boolean mochc) {
		this.mochc = mochc;
	}

	public boolean isMoead() {
		return moead;
	}

	public void setMoead(boolean moead) {
		this.moead = moead;
	}

	public boolean isCmoead() {
		return cmoead;
	}

	public void setCmoead(boolean cmoead) {
		this.cmoead = cmoead;
	}

	public boolean isMoeaddd() {
		return moeaddd;
	}

	public void setMoeaddd(boolean moeaddd) {
		this.moeaddd = moeaddd;
	}

	public boolean isMoeaddra() {
		return moeaddra;
	}

	public void setMoeaddra(boolean moeaddra) {
		this.moeaddra = moeaddra;
	}

	public boolean isMoeadstm() {
		return moeadstm;
	}

	public void setMoeadstm(boolean moeadstm) {
		this.moeadstm = moeadstm;
	}

	public boolean isMombi() {
		return mombi;
	}

	public void setMombi(boolean mombi) {
		this.mombi = mombi;
	}

	public boolean isMombi2() {
		return mombi2;
	}

	public void setMombi2(boolean mombi2) {
		this.mombi2 = mombi2;
	}

	public boolean isNsgaii() {
		return nsgaii;
	}

	public void setNsgaii(boolean nsgaii) {
		this.nsgaii = nsgaii;
	}

	public boolean isNsgaiim() {
		return nsgaiim;
	}

	public void setNsgaiim(boolean nsgaiim) {
		this.nsgaiim = nsgaiim;
	}

	public boolean isSsnsgaii() {
		return ssnsgaii;
	}

	public void setSsnsgaii(boolean ssnsgaii) {
		this.ssnsgaii = ssnsgaii;
	}

	public boolean isNsgaiii() {
		return nsgaiii;
	}

	public void setNsgaiii(boolean nsgaiii) {
		this.nsgaiii = nsgaiii;
	}

	public boolean isOmopso() {
		return omopso;
	}

	public void setOmopso(boolean omopso) {
		this.omopso = omopso;
	}

	public boolean isPaes() {
		return paes;
	}

	public void setPaes(boolean paes) {
		this.paes = paes;
	}

	public boolean isPesa2() {
		return pesa2;
	}

	public void setPesa2(boolean pesa2) {
		this.pesa2 = pesa2;
	}

	public boolean isRandomsearch() {
		return randomsearch;
	}

	public void setRandomsearch(boolean randomsearch) {
		this.randomsearch = randomsearch;
	}

	public boolean isSmpso() {
		return smpso;
	}

	public void setSmpso(boolean smpso) {
		this.smpso = smpso;
	}

	public boolean isSmpsom() {
		return smpsom;
	}

	public void setSmpsom(boolean smpsom) {
		this.smpsom = smpsom;
	}

	public boolean isSmsemoa() {
		return smsemoa;
	}

	public void setSmsemoa(boolean smsemoa) {
		this.smsemoa = smsemoa;
	}

	public boolean isSpea2() {
		return spea2;
	}

	public void setSpea2(boolean spea2) {
		this.spea2 = spea2;
	}

	public boolean isWasfga() {
		return wasfga;
	}

	public void setWasfga(boolean wasfga) {
		this.wasfga = wasfga;
	}
	
	
}

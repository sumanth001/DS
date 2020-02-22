package com.syara.greedyAlgo;

import java.util.Comparator;

public class CompareList implements Comparator<KnapSackProblem>{

	@Override
	public int compare(KnapSackProblem o1, KnapSackProblem o2) {
		// TODO Auto-generated method stub
		if(o1.getProfbyweig()<o2.getProfbyweig()) {
			return 1;
		}
		else if(o1.getProfbyweig()==o2.getProfbyweig()) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
}

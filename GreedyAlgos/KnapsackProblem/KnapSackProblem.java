package com.syara.greedyAlgo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
Author : Kammal Shetty Sai Sumanth.

Problem is more about making a decision.
You have bag which can hold x amount of capacity. And there are array of elements
each element has a some profit and weight associated to it. You need to choose the elements such
that sum of the choosen element doesn't exceed x and you should able to make maximum profit..

Here what we gonna do..
we will calculate profit / weight for each element and based on those value we will sort the list.
Then we will iterate the list till we have reached our bagcapacity.

we are assuming that bag capacity is 15Kgs

*/
public class KnapSackProblem   {

public String element;
public int profit;
public float weight;
public float profbyweig;


	
	
public String getElement() {
	return element;
}




public void setElement(String element) {
	this.element = element;
}




public int getProfit() {
	return profit;
}




public void setProfit(int profit) {
	this.profit = profit;
}




public float getWeight() {
	return weight;
}




public void setWeight(float weight) {
	this.weight = weight;
}




public float getProfbyweig() {
	return profbyweig;
}




public void setProfbyweig(float profbyweig) {
	this.profbyweig = profbyweig;
}




public static void main(String[] args) {

		/*
		 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 * Scanner scan = new Scanner(System.in); int n = scan.nextInt();
		 */
	
	// dummy values for test
	String [] ele = {"J1","J2","J3", "J4","J5","J6","J7"};
	int[] prof = {10,5,15,7,6,18,3};
	float[] wei = {2,3,5,7,1,4,1};
	
	List<KnapSackProblem> knapList = new ArrayList<KnapSackProblem>();
	
	
	//adding elements to the list;
	for(int i=0;i<ele.length;i++) {
		KnapSackProblem nap = new KnapSackProblem();
		nap.setElement(ele[i]);
		nap.setProfit(prof[i]);
		nap.setWeight(wei[i]);
		nap.setProfbyweig(prof[i]/wei[i]);
		knapList.add(nap);
	}

	
	//sorting the list in descending order
	knapList=knapList.stream().sorted(new CompareList()).collect(Collectors.toList());
	
	float bagCapacity = 0;
	float totalProfit =0;
	
	for(KnapSackProblem nap : knapList) {
		
		
		//	System.out.println(nap.getWeight());
			if(bagCapacity +nap.getWeight() >15) {   //assume bagcapacity is 15
 				bagCapacity=15;
			 float  profCal= 15-(bagCapacity +nap.getWeight())+nap.getWeight();
			 totalProfit += nap.getProfit()/nap.getWeight() *profCal;
			 break;
			}
			else{
				bagCapacity +=nap.getWeight();
				totalProfit +=nap.getProfit();
			}
		
		
	}
	
	System.out.println(bagCapacity +" " +totalProfit);
	 
	
}


	
}


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SuperSoda {
//the runtime for this algorithm is O(N*M) where M is the size of the sodaSizes array. 
  public static double minimalSodaCost(int[] sodaSizes, double[] costs, int n) {
	  PriorityQueue<Double> heap = new PriorityQueue<Double>();
	  double[] table = new double[n+1];
	  
	  
	  
	  table[0]=0;
	  
	  for(int i = 1 ;i < table.length; i++){
				 
		 for(int j =sodaSizes.length-1; j>=0;j--){
			 
			if(i==sodaSizes[j]){
				System.out.println("dfd");
				heap.add(costs[j]);
				
			}
			
			else if(i>sodaSizes[j]){
								
				heap.add(table[sodaSizes[j]]+table[i-sodaSizes[j]]);
				
			}
			 
		 }
		 table[i] = heap.poll();
		 heap.clear;
		 System.out.println("cost at "+ i + " is " + table[i]);
	  }
	  
    return table[n];
  }
//The runtime for this algorithm is O(N*M) where N is the final size of the arrayList and M is the size of the sodaSizes array
  public static int maximumSodaNumber(int[] sodaSizes, double[] costs, double cost) {
	  PriorityQueue<Double> heap = new PriorityQueue<Double>();
	  ArrayList<Double> table = new ArrayList<Double>();
	  
	  table.add(0,0.0);
	  //the ineffecient method
	  /*int count =0;;
	  while(true){
		  
		  double minCost = minimalSodaCost(sodaSizes,costs,count);
		  if(minCost<=cost){
			  heap.add(count);
		  }
		  if(minCost>cost){
			  break;
		  }
		  
		  count++;
	  }*/
	  
	  //the efficient method
	  
	  for(int i = 1 ;i < table.size()+1; i++){
			 System.out.println(i);
			 for(int j =sodaSizes.length-1; j>=0;j--){
				 
				if(i==sodaSizes[j] || (i<costs[j]&&i>costs[j])){
					System.out.println("dfd");
					heap.add(costs[j]);
					
				}
				
				else if(i>sodaSizes[j]){
					
					heap.add(table.get(sodaSizes[j])+table.get(i-sodaSizes[j]));
					
				}
				 
			 }
			 table.add(heap.poll());
			 heap.clear();
			 if(table.get(i)>cost){
				 return i-1;
			 }
			 
		 System.out.println("max at "+ i + " is " + table.get(i));
	  }
	 //else returns the size of the table, shouldn't happen though
    return table.size();
  }

  public static int[] minimalSodaCostCombinations(int[] sodaSizes, double[] costs, int n) {
	  PriorityQueue<Double> heap = new PriorityQueue<Double>();
	  double[] table = new double[n+1];
	  ArrayList<int[]> table2 = new ArrayList<int[]>();
	  table[0]=0;
	  int[] cost0 = {0,0,0,0,0};
	  table2.add(0,cost0);
	  
	  for(int i = 1 ;i < table.length; i++){
				 
		 for(int j =sodaSizes.length-1; j>=0;j--){
			 
			if(i==sodaSizes[j]){
				System.out.println("dfd");
				heap.add(costs[j]);
				
			}
			
			else if(i>sodaSizes[j]){
				
				heap.add(table[sodaSizes[j]]+table[i-sodaSizes[j]]);
				
			}
			 
		 }
		 table[i] = heap.poll();
		 heap.clear();
		 System.out.println("cost at "+ i + " is " + table[i]);
		 int[] tmp = new int[sodaSizes.length];
		 
		 for(int j =sodaSizes.length-1;j>=0;j--){
			 if(i==sodaSizes[j]){
				 for(int k=0;k<tmp.length-1;k++){
					 tmp[k]=0;
				 }
				 tmp[j]=1;
				 break;
			 }
			 else if(i>sodaSizes[j]){
				 
				 tmp[j]=table2.get(sodaSizes[j])[j]+table2.get(i-sodaSizes[j])[j];
				 
				 if(tmp[j]>sodaSizes[j+1]){
					 tmp[j]=tmp[j]-sodaSizes[j+1];
					 tmp[j+1]=tmp[j+1]+1;
				 }
				 
			 }
		 }
		 
		 for(int j =0;j<tmp.length-1;j++){
			 
		 }
			 
		 table2.add(tmp);
		 System.out.println(Arrays.toString(table2.get(i)));
	  }
	  
	  for(int i=0;i<table.length-1;i++){
		  int[] tmp = new int[sodaSizes.length];
		  for(int j=0;j<=tmp.length-1;j++){
			tmp[j]=tmp[j-i];
		 }
		  table2.add(tmp);
	  }
	  
	  return table2.get(n);
	  

  }
//tester

  public static void main(String[] args) {
    int[] sodaSizes = new int[] { 1, 6, 12, 25, 36 };
    double[] costs = new double[] { 0.8, 4, 7.5, 14, 20 };
    //System.out.println(minimalSodaCost(sodaSizes, costs,28));
    //System.out.println(maximumSodaNumber(sodaSizes, costs, 56));
    System.out.println(Arrays.toString(minimalSodaCostCombinations(sodaSizes, costs, 15)));
  }
}

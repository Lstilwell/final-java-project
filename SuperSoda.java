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
	  
	  
	  /*for(int i =0; i < sodaSizes[1]; i++){
		  table[i] = costs[0]*i;
		  System.out.println(table[i]);
	  }*/
	  
	  table[0]=0;
	  
	  for(int i = 1 ;i < table.length; i++){
				 
		 for(int j =sodaSizes.length-1; j>=0;j--){
			 //System.out.println(i);
			 //System.out.println(sodaSizes[j]);
			 
				 //System.out.println(j);
			 
			if(i==sodaSizes[j]){
				System.out.println("dfd");
				heap.add(costs[j]);
				
			}
			
			else if(i>sodaSizes[j]){
				//System.out.println("i is " + i + " j is "+sodaSizes[j]);
				//System.out.println(table[i/sodaSizes[j]]);
				
				heap.add(table[sodaSizes[j]]+table[i-sodaSizes[j]]);
				
			}
			 
		 }
		 table[i] = heap.poll();
		 heap.clear();
		 System.out.println("cost at "+ i + " is " + table[i]);
	  }
	  
    return table[n];
  }
//The runtime for this algorithm is O(N*M) where N is the final size of the arrayList and M is the size of the sodaSizes array
  public static int maximumSodaNumber(int[] sodaSizes, double[] costs, double cost) {
	  PriorityQueue<Double> heap = new PriorityQueue<Double>();
	  ArrayList<Double> table = new ArrayList<Double>();
	  //double[] table = new double[sodaSizes[sodaSizes.length-1]];
	  
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
				 //System.out.println(i);
				 //System.out.println(sodaSizes[j]);
				 
					 //System.out.println(j);
				 
				if(i==sodaSizes[j] || (i<costs[j]&&i>costs[j])){
					System.out.println("dfd");
					heap.add(costs[j]);
					
				}
				
				else if(i>sodaSizes[j]){
					//System.out.println("i is " + i + " j is "+sodaSizes[j]);
					//System.out.println(table[i/sodaSizes[j]]);
					
					
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
			 //System.out.println(i);
			 //System.out.println(sodaSizes[j]);
			 
				 //System.out.println(j);
			 
			if(i==sodaSizes[j]){
				System.out.println("dfd");
				heap.add(costs[j]);
				
			}
			
			else if(i>sodaSizes[j]){
				//System.out.println("i is " + i + " j is "+sodaSizes[j]);
				//System.out.println(table[i/sodaSizes[j]]);
				
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

		 
	  /*Comparator<arrayObject> comparator = new costComparator();
	  PriorityQueue<arrayObject> heap = new PriorityQueue<arrayObject>(comparator);
	  ArrayList<int[]> table = new ArrayList<int[]>();
	  int[] table2 = new int[n];
	  
	  
	  
	  /*for(int i =0; i < sodaSizes[1]; i++){
		  table[i] = costs[0]*i;
		  System.out.println(table[i]);
	  }*/
	  
	 /* int[] cost0 = {0,0,0,0,0};
	  int[] cost1 = {1,0,0,0,0};
	  
	  table.add(0,cost0);
	  //table.add(1, cost1);
	  
	  System.out.println(Arrays.toString(table.get(0)));
	  int[] countArray = new int[sodaSizes.length];
	  for(int i =0; i< countArray.length-1;i++){
		  countArray[i]=0;
	  }
	  
	 
	  for(int i =1 ;i <= n; i++){
		 
		 //System.out.println(i);
		
				 
		 for(int j =sodaSizes.length-1; j>=0;j--){
			 //System.out.println(i);
			 
			 
				// System.out.println(j);
			 
			if(i==sodaSizes[j]){
				System.out.println("dfd");
				for(int k =0; k<j;k++){
					countArray[k]=0;
				}
				for(int k = countArray.length-1;k>j;k--){
					countArray[k]=0;
				}
				countArray[j] = countArray[j]+1;
				arrayObject toAdd = new arrayObject(countArray,costs);
				heap.add(toAdd);
				
				break;
			}
			
			else if(i>sodaSizes[j]){
				//System.out.println("i is " + i + " j is "+sodaSizes[j]);
				//System.out.println(table[i/sodaSizes[j]]);
				//System.out.println("ddsfsdf");
				//heap.add(table[sodaSizes[j]]+table[i-sodaSizes[j]]);
				
				int[] refArray = table.get(sodaSizes[j]);
				//System.out.println(Arrays.toString(table.get(sodaSizes[j])));
				
				
				
				int[] refArray2 = table.get(i-sodaSizes[j]);
				//System.out.println(Arrays.toString(table.get(i-sodaSizes[j])));
				
				
				
					
				
				
				arrayObject ref1 = new arrayObject(refArray,costs);
				int[] ref3 = ref1.addArray(ref1.combination, refArray2, sodaSizes);
				heap.add(new arrayObject(ref3,costs));
				//arrayObject test = new arrayObject(table[i-1].combination,costs);
				//countArray[0] = (i%sodaSizes[j]);
				//countArray[j] = i/sodaSizes[j];
				//arrayObject toAdd = new arrayObject(countArray,costs);
				//heap.add(toAdd);
				
			}
				 
			
			 
			
			
			
			 
			 
		 }
		 table.add(i,heap.peek().combination);
		 for(int z=0;z<table.size();z++){
			 System.out.print(Arrays.toString(table.get(z)));
			 
		 }
		 System.out.println("");
		 //toReturn = heap.poll().combination;
		 if(i==n){
			 while(!heap.isEmpty()){
				System.out.print(Arrays.toString(heap.poll().combination));
				 System.out.println("");
			 }
		 }
		 heap.clear();
		 System.out.println("cost at "+ i + " is " + Arrays.toString(table.get(i)));
		 
    
  }
	  
	  /*for(int i =0;i<toReturn.length-1;i++){
		  for(int k = toReturn.length-1;k>i;k--){
			  if(toReturn[i]>sodaSizes[k]){
				 
					  toReturn[k]=toReturn[k] + (toReturn[i]/sodaSizes[k]);
					  toReturn[i] = toReturn[i]%sodaSizes[k];
				  
				  
			  }
		  }
	  }*/
	  
	
	  
	
	  
  
/*public static class costComparator implements Comparator<arrayObject>{
	
		@Override
		public int compare(int[] o1, int[] o2) {
			double cost1 =0;
			double cost2 =0;
			
			for (int i =0;i<o1.combination.length;i++){
				
				cost1 = (cost1+(o1.combination[i]*o1.costs[i]));
				
			}
			for (int i =0;i<o2.combination.length;i++){
				
				cost2 = (cost2+(o2.combination[i]*o2.costs[i]));
			}
			//System.out.println(cost1+" "+cost2);
			if(cost1>cost2){
				return 1;
			}
			if ( cost1<cost2){
				
				return -1;
			}
			else{
				
				return 0;
			}
		}
}*/
private static class arrayObject{
	  int[] combination;
	  
	  double[] costs;
	  
	  public arrayObject(int[] combination, double[] costs){
		  
		  this.costs = costs;
		  this.combination = combination;
	  }
	  
	  public int[] addArray(int[] array1, int[] array2,int[] sodaSizes){
		  int[] sum = new int[array1.length];
		  System.out.println("array1 "+Arrays.toString(array1));
		  System.out.println("array2 "+Arrays.toString(array2));
		  
		  for(int i=0;i<sum.length;i++){
			  sum[i]=array1[i]+array2[i];
		  }
		  //System.out.println(Arrays.toString(sum));
		  for(int i=0;i<sodaSizes.length-1;i++){
			  if(sum[i]>=sodaSizes[i+1]){
				  sum[i+1]=sum[i+1]+(sum[i]/sodaSizes[i+1]);
				  sum[i]=sum[i]%sodaSizes[i+1];
			  }
			  break;
		  }
		  //System.out.println(Arrays.toString(sum));
		return sum;
		  
	  }
}
		  
	  

  public static void main(String[] args) {
    int[] sodaSizes = new int[] { 1, 6, 12, 25, 36 };
    double[] costs = new double[] { 0.8, 4, 7.5, 14, 20 };
    //System.out.println(minimalSodaCost(sodaSizes, costs,28));
    //System.out.println(maximumSodaNumber(sodaSizes, costs, 56));
    System.out.println(Arrays.toString(minimalSodaCostCombinations(sodaSizes, costs, 15)));
  }
}
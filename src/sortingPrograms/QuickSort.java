package sortingPrograms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class QuickSort {
	 static String fileName = "src/temp6.txt"; 
	 
	 	private int[] array;
	    private int[] tempMergArr;
	    private int length;
	    
	 public static void main(String a[]){
		
		 QuickSort quickSort = new QuickSort();
		 int[] arrayInt = new int[10000000] ;
		 try {
             // FileReader reads text files in the default encoding.
             FileReader fileReader = 
                 new FileReader(fileName);

             // Always wrap FileReader in BufferedReader.
             BufferedReader bufferedReader = 
                 new BufferedReader(fileReader);
             
             String line;
             String[] var = null;
            
			while((line = bufferedReader.readLine()) != null) {
				//ListNum.add((Inteline.split(" "));
				 var = line.split(" ");
				
             }   
			for (int i=0;i<var.length;i++){
				//System.out.println(var[i]+" ");
				arrayInt[i] =  Integer.parseInt(var[i]);
			}
			int[] sortedArray = new int[10000000];
			 long lStartTime = System.currentTimeMillis();
			 quickSort.sort(arrayInt);
			 long lEndTime = System.currentTimeMillis();
		     long difference = lEndTime - lStartTime;
		     System.out.println("Elapsed milliseconds: " + difference);
//			for (int i =0; i<sortedArray.length;i++){
//			//System.out.println(sortedArray[i]);	
//			}
			
			
		
             // Always close files.
             bufferedReader.close();         
         }
         catch(FileNotFoundException ex) {
             System.out.println(
                 "Unable to open file '" + 
                 fileName + "'");                
         }
         catch(IOException ex) {
             System.out.println(
                 "Error reading file '" 
                 + fileName + "'");                  
             // Or we could just do this: 
             // ex.printStackTrace();
         }
     }
	 
	   
	 // Code For Quick Sort
	 
	 
	 public void sort(int[] inputArr) {
         
	        if (inputArr == null || inputArr.length == 0) {
	            return;
	        }
	        this.array = inputArr;
	        length = inputArr.length;
	        quickSort(0, length - 1);
	    }
	 
	    private void quickSort(int lowerIndex, int higherIndex) {
	         
	        int i = lowerIndex;
	        int j = higherIndex;
	        // calculate pivot number, I am taking pivot as middle index number
	        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
	        // Divide into two arrays
	        while (i <= j) {
	            /**
	             * In each iteration, we will identify a number from left side which
	             * is greater then the pivot value, and also we will identify a number
	             * from right side which is less then the pivot value. Once the search
	             * is done, then we exchange both numbers.
	             */
	            while (array[i] < pivot) {
	                i++;
	            }
	            while (array[j] > pivot) {
	                j--;
	            }
	            if (i <= j) {
	                exchangeNumbers(i, j);
	                //move index to next position on both sides
	                i++;
	                j--;
	            }
	        }
	        // call quickSort() method recursively
	        if (lowerIndex < j)
	            quickSort(lowerIndex, j);
	        if (i < higherIndex)
	            quickSort(i, higherIndex);
	    }
	 
	    private void exchangeNumbers(int i, int j) {
	        int temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	    }	 
}
 
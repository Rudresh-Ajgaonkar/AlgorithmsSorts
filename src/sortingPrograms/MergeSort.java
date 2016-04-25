package sortingPrograms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MergeSort {
	 static String fileName = "src/temp6.txt"; 
	 static String fileName2 = "src/MergSort6.txt"; 
	 
	 	private int[] array;
	    private int[] tempMergArr;
	    private int length;
	    
	 public static void main(String a[]){
		 ArrayList<Integer> ListNum;	
		 MergeSort mergeSort = new MergeSort();
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
             ListNum = new ArrayList<Integer>();
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
			 mergeSort.sort(arrayInt);
			 long lEndTime = System.currentTimeMillis();
		     long difference = lEndTime - lStartTime;
		     System.out.println("Elapsed milliseconds: " + difference);

		 	FileWriter fileWriter =
	                new FileWriter(fileName2);

	            // Always wrap FileWriter in BufferedWriter.
	            BufferedWriter bufferedWriter =
	                new BufferedWriter(fileWriter);
	            	bufferedWriter.write("This is the result For Merge Sort Sort for 1000000 Input Numbers");
	            	bufferedWriter.newLine();
	            	bufferedWriter.newLine();
	            	bufferedWriter.newLine();
	            	
	            for (int i=0; i<sortedArray.length;i++){
					  bufferedWriter.write(String.valueOf(sortedArray[i]));
			            bufferedWriter.write(" ");	
				}
	            
			
		
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
	 
	   
	 public void sort(int inputArr[]) {
	        this.array = inputArr;
	        this.length = inputArr.length;
	        this.tempMergArr = new int[length];
	        doMergeSort(0, length - 1);
	    }
	 
	    private void doMergeSort(int lowerIndex, int higherIndex) {
	         
	        if (lowerIndex < higherIndex) {
	            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
	            // Below step sorts the left side of the array
	            doMergeSort(lowerIndex, middle);
	            // Below step sorts the right side of the array
	            doMergeSort(middle + 1, higherIndex);
	            // Now merge both sides
	            mergeParts(lowerIndex, middle, higherIndex);
	        }
	    }
	 
	    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
	 
	        for (int i = lowerIndex; i <= higherIndex; i++) {
	            tempMergArr[i] = array[i];
	        }
	        int i = lowerIndex;
	        int j = middle + 1;
	        int k = lowerIndex;
	        while (i <= middle && j <= higherIndex) {
	            if (tempMergArr[i] <= tempMergArr[j]) {
	                array[k] = tempMergArr[i];
	                i++;
	            } else {
	                array[k] = tempMergArr[j];
	                j++;
	            }
	            k++;
	        }
	        while (i <= middle) {
	            array[k] = tempMergArr[i];
	            k++;
	            i++;
	        }
	 
	    } 
}
 
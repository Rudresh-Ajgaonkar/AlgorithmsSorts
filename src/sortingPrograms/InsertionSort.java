package sortingPrograms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class InsertionSort {
	 static String fileName = "src/temp1.txt"; 
	 static String fileName2 = "src/Insertion1Result.txt";
	 
	 public static void main(String a[]){
		 ArrayList<Integer> ListNum;	
		 int[] arrayInt = new int[100];
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
			int[] sortedArray = new int[100];
			sortedArray = doInsertionSort(arrayInt);
			
			// Sorted Array to be printed Back to a file named "InsertionResult.txt"
			
			FileWriter fileWriter =
	                new FileWriter(fileName2);

	            // Always wrap FileWriter in BufferedWriter.
	            BufferedWriter bufferedWriter =
	                new BufferedWriter(fileWriter);
	            	bufferedWriter.write("This is the result For Insertion Sort for 100000 Input Numbers");
	            	bufferedWriter.newLine();
	            	bufferedWriter.newLine();
	            	bufferedWriter.newLine();
	            	
	            for (int i=0; i<sortedArray.length;i++){
					  bufferedWriter.write(String.valueOf(sortedArray[i]));
			            bufferedWriter.write(" ");	
				}
	            
			
             // Always close files.
	         bufferedWriter.close();   
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
	 
	 
	 // Insertion Sort Functions
	  public static int[] doInsertionSort(int[] input){
		  long lStartTime = System.nanoTime();
	        int temp;
	        for (int i = 1; i < input.length; i++) {
	            for(int j = i ; j > 0 ; j--){
	                if(input[j] < input[j-1]){
	                    temp = input[j];
	                    input[j] = input[j-1];
	                    input[j-1] = temp;
	                }
	            }
	        }
	        long lEndTime = System.nanoTime();
	        long difference = lEndTime - lStartTime;
	        System.out.println("Elapsed milliseconds: " + difference);
	        return input;   
	    }
	  
	  // Insertion Sort Ends Here
	 
	  
	  
}
 
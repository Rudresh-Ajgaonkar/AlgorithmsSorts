package sortingPrograms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/** Class RadixSort **/
public class RadixSort 
{   static String fileName2 = "src/RadixSort1.txt";
    /** Radix Sort function **/
    public static void sort(int[] a)
    {
        int i, m = a[0], exp = 1, n = a.length;
        int[] b = new int[10];
        for (i = 1; i < n; i++)
            if (a[i] > m)
                m = a[i];
        while (m / exp > 0)
        {
            int[] bucket = new int[10];
 
            for (i = 0; i < n; i++)
                bucket[(a[i] / exp) % 10]++;
            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];
            for (i = n - 1; i >= 0; i--)
                b[--bucket[(a[i] / exp) % 10]] = a[i];
            for (i = 0; i < n; i++)
                a[i] = b[i];
            exp *= 10;        
        }
    }    
   
    // main method
    
    public static void main(String[] args) {
    	String fileName = "src/temp1.txt"; 
    	
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
			int[] a1=new int[var.length];
			for (int i=0;i<var.length;i++){
				//System.out.println(var[i]+" ");
				a1[i] =  Integer.parseInt(var[i]);
			}        
        
			long lStartTime = System.currentTimeMillis();
		
			sort(a1);
			 long lEndTime = System.currentTimeMillis();
		     long difference = lEndTime - lStartTime;
		     System.out.println("Elapsed milliseconds: " + difference);

		 	FileWriter fileWriter =
	                new FileWriter(fileName2);

	            // Always wrap FileWriter in BufferedWriter.
	            BufferedWriter bufferedWriter =
	                new BufferedWriter(fileWriter);
	            	bufferedWriter.write("This is the result For Radix Sort for 100 Input Numbers");
	            	bufferedWriter.newLine();
	            	bufferedWriter.newLine();
	            	bufferedWriter.newLine();
	            	
	            for (int i=0; i<a1.length;i++){
					  bufferedWriter.write(String.valueOf(a1[i]));
			            bufferedWriter.write(" ");	
				}
		     bufferedReader.close();   
    	}catch(FileNotFoundException ex) {
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
        
}
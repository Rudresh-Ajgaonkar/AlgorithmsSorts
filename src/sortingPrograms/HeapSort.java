package sortingPrograms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HeapSort 
{
    private static int[] a;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;
    private static String fileName2 = "HeapSort6.txt";
    
    public static void buildheap(int []a){
        n=a.length-1;
        for(int i=n/2;i>=0;i--){
            maxheap(a,i);
        }
    }
    
    public static void maxheap(int[] a, int i){ 
        left=2*i;
        right=2*i+1;
        if(left <= n && a[left] > a[i]){
            largest=left;
        }
        else{
            largest=i;
        }
        
        if(right <= n && a[right] > a[largest]){
            largest=right;
        }
        if(largest!=i){
            exchange(i,largest);
            maxheap(a, largest);
        }
    }
    
    public static void exchange(int i, int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t; 
        }
    
    public static void sort(int []a0){
        a=a0;
        buildheap(a);
        
        for(int i=n;i>0;i--){
            exchange(0, i);
            n=n-1;
            maxheap(a, 0);
        }
    }
    
    public static void main(String[] args) {
    	String fileName = "src/temp6.txt"; 
    	
    	
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
	            	bufferedWriter.write("This is the result For Heap Sort for 1000000 Input Numbers");
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
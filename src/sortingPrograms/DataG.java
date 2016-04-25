package sortingPrograms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataG {
    public static void main(String [] args) {

        // The name of the file to open.
        String fileName = "src/temp6.txt";

        try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            long c ;
			Random t = new Random();
			for ( c = 1; c <= 10000000; c++) {
				int x = t.nextInt(1000);
				//System.out.println(c + "  "+x);
			
            // Note that write() does not automatically
            // append a newline character.
				
            bufferedWriter.write(String.valueOf(x));
            bufferedWriter.write(" ");
			}
			System.out.println(c);
         
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
}
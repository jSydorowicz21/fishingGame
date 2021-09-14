import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class saveGame {

	public void loadVariable(String[] variableData) throws IOException {

		
        File file = new File("save.txt");
        if (file.exists()){
            Scanner in = new Scanner(file);
            //loop for reading variables
            for(int i = 0; i < 11; i++) {
                // Skips lines in save file that are not useful
                in.next();
                in.next();
                // Checks if modified variable is title as method of storage is different.
                if(i == 9) {
                    variableData[i] = in.next() + " " + in.next() + " " + in.next();
                }
                // goes to reading variable normally
                else {
                    variableData[i] = in.next();
                }
            }
            in.close();
        }
	}
	
	public void saveVariable(String[] variableName, String[] variableData) throws IOException {
		
		File file = new File("save.txt");
		
		// Checks if file does not exist. If it does not, it creates it
        if (!file.exists()) {
            FileWriter fWriter = new FileWriter(file);
            PrintWriter pWriter = new PrintWriter(fWriter);
            fWriter.close();
            pWriter.close();
        }
        

        try (Writer writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("save.txt"), "utf-8"))) { // sets the output where to write
                   
                for(int i = 0; i < 11; i++) {
                    writer.write(variableName[i] + " = " +  variableData[i] +  "\n"); // writes
                }
            writer.close();
        }
        

        catch (IOException e) {
            
        }

	}
	
	public void clearFile() throws IOException {
		
		File file = new File("save.txt");
		
		PrintWriter writer = new PrintWriter(file);
		writer.print("");
		writer.close();
	}

}
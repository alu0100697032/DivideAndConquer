/**
 * File name:WriteOutputFile.java
 * Package name: clases
 * Proyect name: daa_ramMachine
 */
package global;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class WriteFile {
	/**
	 * Constructor: WriteOutputFile
	 */
	public WriteFile() {
		
	}
	/**
	 * write
	 */
	public void write(String fileName, String output) {
		try {

			File outputFile = new File(fileName);

			if (!outputFile.exists()) {
				outputFile.createNewFile();
			}

			FileWriter fw = new FileWriter(outputFile.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(output);
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

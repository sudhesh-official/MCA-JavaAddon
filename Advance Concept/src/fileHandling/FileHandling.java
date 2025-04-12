package fileHandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileHandling {
	
	String FileName = "C:\\Users\\rsudh\\OneDrive\\Desktop\\MCA\\Advance Concept\\src\\fileHandling\\test.txt";
	
	public void WriteHelloWorld(){
		FileWriter f = null;
		try {
			f = new FileWriter(FileName);
			BufferedWriter bw = new BufferedWriter(f);
			bw.write("Hello World...");
			bw.newLine();
			bw.close();
			bw = null;	
			System.out.println("File write completed.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ReadFile() {
		FileReader r = null;
		BufferedReader br = null;
		try {
			r = new FileReader(FileName);
			br = new BufferedReader(r);
			String data = br.readLine();
			System.out.println(data);
			r.close();
			br.close();
			System.out.println("File Read Successfully...");
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
		} 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

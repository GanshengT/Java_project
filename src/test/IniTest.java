package test;


import java.io.*;
import java.util.*;

public class IniTest {
	public static void main(String[] args) throws IOException {
		List<String> commandString = new ArrayList<>();
		File f = new File("eval/test.ini");
		FileInputStream in = new FileInputStream(f);
		InputStreamReader inr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(inr);
		String lineCommand =null;
		while((lineCommand = br.readLine()) != null) {
			System.out.println(lineCommand);
			commandString.add(lineCommand);
            
		}
		//System.out.println(commandString.size());
		for(String line: commandString) {
			String[] command = line.split(" ");
			System.out.println(command.length);
		}
	}
}

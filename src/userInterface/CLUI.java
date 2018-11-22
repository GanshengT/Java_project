package userInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import myUberSystem.MyUber;

public class CLUI {
	
	MyUber myUber;
	
	public static void main(String[] args) throws IOException {
		CLUI myUberCLUI = new CLUI();
		System.out.println(myUberCLUI.readCommand()[1]);
		
	}
	
	public String[] readCommand() throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String command = br.readLine();
		//List<String> commandLine = new ArrayList<>();	
		return command.split(" ");
	}
	
	/**
	 * Tan: addCustomer
	 * 		addDriver
	 * 		addCarDriver
	 * 		addDriver
	 * 		setDriverstatus
	 * 		displaystate
	 * 		simRide i
	 * 
	 * Gezheng:
	 * ini, setup
	 * moveCar
	 * moveCustomer
	 * ask4price
	 * simRide
	 * display drivers
	 * displaycustomer
	 * totalcashed
	 * run test
	 * 
	 */

}


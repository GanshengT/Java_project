package userInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import Cars.BerlineCar;
import Cars.Car;
import Cars.StandardCar;
import Cars.VanCar;
import myUberSystem.Customer;
import myUberSystem.Driver;
import myUberSystem.MyUber;

public class CLUI {
	
	MyUber myUber;
	BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		CLUI myUberCLUI = new CLUI();
		// System.out.println(myUberCLUI.readCommand()[1]);
		
	}
	
	public String[] readCommand() throws IOException {
		String command = br.readLine();
		//List<String> commandLine = new ArrayList<>();	
		return command.split(" ");
	}
	
	protected void addCustomer(String customerName, String customerSurname) throws NoSuchFieldException {
		myUber.getListOfCustomer().add(new Customer(customerName,customerSurname));
		System.out.println(myUber.getListOfCustomer());
		
	}
	
	/**
	 * sub-function that used to generate driver
	 * @param driverName
	 * @param driverSurname
	 */
	protected Driver driverGeneration(String driverName, String driverSurname) {
		Driver newDriver = new Driver(driverName, driverSurname, true);
		Car.nonAssignedDrivers.add(newDriver);
		myUber.getListOfDriver().add(newDriver);
		return newDriver;
	}
	
	protected void addCarDriver(String driverName, String driverSurname, String carType) {
		// we add one driver so evidently this driver is the car's owner.
		driverGeneration(driverName, driverSurname);
		if (carType == "berline") {
			BerlineCar newcar = new BerlineCar(myUber.getAreaUsed());
			newcar.AssignDriver();
			myUber.getListOfBerlineCar().add(newcar);
			myUber.getListOfCar().add(newcar);
			}
		else if (carType == "standard") {
			StandardCar newcar = new StandardCar(myUber.getAreaUsed());
			newcar.AssignDriver();
			myUber.getListOfStandardCar().add(newcar);
			myUber.getListOfCar().add(newcar);
			
		}
		else if (carType =="van") {
			VanCar newcar = new VanCar(myUber.getAreaUsed());
			newcar.AssignDriver();
			myUber.getListOfVanCar().add(newcar);
			myUber.getListOfCar().add(newcar);
		}
		else {
			System.out.println("please enter the carType among berline, standard and van");
		}
		printInfoCarDriver();
	}
	
	/**
	 * used to tell user updated infomation
	 */
	protected void printInfoCarDriver() {
		System.out.println("car information");
		for(Car car: myUber.getListOfCar() ) {
		System.out.println(car.getIdCar());
		System.out.println("its owners");
		System.out.println(car.getOwners());
	}
		System.out.println("driver info");
		for (Driver driver: myUber.getListOfDriver()) {
			System.out.println(driver.getDriverId());
		}
	}
	
	//carID is a String
	protected boolean addDriver(String driverName, String driverSurname, String carID) {
		Driver newDriver = driverGeneration(driverName,driverSurname);
		for (Car car : myUber.getListOfCar()) {
			if (car.getIdCar()==carID) {
				car.getOwners().add(newDriver);
				return true;
			}
			
		}
		System.out.println("no such car");
		return false;
	}
	
	/**
	 * a function that use name and surname to search driver
	 * might return multiple ID that have same name and same surname
	 * then interact with user
	 * @param driverName
	 * @param driverSurname
	 * @param status
	 */
	protected Driver[] findDriverByName(String driverName, String driverSurname) {
		List<Driver> 
		for (Driver driver:myUber.getListOfDriver()) {
			if (driver.getName()==driverName) {
				if(driver.getSurName()==driverSurname) {
					
				}
			}
		}
	}
	
	protected void setDriverStatus(String driverName, String driverSurname, String status) {
		
	}
	/**
	 * Tan: addCustomer
	 * 		addDriver
	 * 		addCarDriver
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


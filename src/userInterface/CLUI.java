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
import otherTools.GPSLocation;

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
	 * @throws IOException 
	 */
	protected Driver findDriverByName(String driverName, String driverSurname) throws IOException {
		List<Driver> foundDriver= new ArrayList<>();
		for (Driver driver:myUber.getListOfDriver()) {
			if (driver.getName()==driverName) {
				if(driver.getSurName()==driverSurname) {
					foundDriver.add(driver);
				}
			}
		}
		if(foundDriver.isEmpty()==true) {
			System.out.println("no such driver");
		}
		if(foundDriver.size()>1) {
			System.out.println("there are more than one driver statisfy searching criterium, please select the driver by typing the ID");
			for(Driver driver: foundDriver) {
			System.out.println(driver.getDriverId()+"name and surname"+driver.getName()+" "+driver.getSurName());
		}}
		String[] selectID = readCommand();
		for(Driver driver: foundDriver) {
			if(Integer.toString(driver.getDriverId())==selectID[0]) {
				return driver;
			}
		}
		return null;
	}
	
	protected void setDriverStatus(String driverName, String driverSurname, String status) throws IOException {
		Driver driver = findDriverByName(driverName, driverSurname);
		driver.setStatus(status);		
	}
	
	/**
	 * display summary information of the current state of the system,
including the list of cars (with their position), the list of drivers (with their status,
their statistics, etc), the list of customers (with their position, their statistics, etc).
output: the list of car the list of drivers the list of customers (with their relevant
information).
difficulties : to manage the sout format
!!!!get customer's position!!!
	 */
	protected void displayState() {
		System.out.println("Car information");
		for (Car car:myUber.getListOfCar()) {
			System.out.println(car.getIdCar()+"its position: "+car.getCarLocation());
		}
		System.out.println("Driver infomation");
		for (Driver driver : myUber.getListOfDriver()) {
			System.out.println("DriverID: "+driver.getDriverId()+"status: "+driver.getStatus()+"occupied rate: "+driver.getOccupiedRate()+
					"average mark: " +driver.getAverageMark());
		}
		System.out.println("Customers infomation");
		for(Customer customer : myUber.getListOfCustomer()) {
			System.out.println("customer's ID "+customer.getIdNum()+"customer's name and surname"+customer.getName()+customer.getSurName()+
					"ride number: "+customer.getRideNum()+ "location: "+customer.getGpsStart()+"consumming money: "+customer.getOnCarMoney());
		}
	}
	
	/**
	 * Initialize myUber system.
	 * @param nStandardCars The number of Standard car in the initialized myUber system.
	 * @param nBerlinCars The number of Berline car in the initialized myUber system.
	 * @param nVanCars The number of van car in the initialized myUber system.
	 * @param nCustomers The number of customer in the initialized myUber system.
	 */
	protected void setup(String nStandardCars, String nBerlinCars, String nVanCars, String nCustomers) {
		this.myUber = new MyUber(nStandardCars, nBerlinCars, nVanCars, nCustomers);
		System.out.println("Your system myUber has been set up.");
	}
	/**
	 * We use this method to change a car's current situation.
	 * @param carID The car ID in String, like"Standard1"
	 * @param xPos The longitude coordinate that we want to set the car to.
	 * @param yPos The latitude coordinate that we want set the car to.
	 */
	protected void moveCar(String carID, String xPos, String yPos) {
		try {
			Car carToMove = this.myUber.getCarMap().get(carID);
			GPSLocation des = new GPSLocation(Double.parseDouble(xPos),Double.parseDouble(yPos));
			carToMove.setCarLocation(des);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("You can not move this car because of some unknown error.");
		}finally {
			for(Car car: myUber.getListOfCar()) {
				System.out.println(car.getIdCar() + " is situated at " + "longitude "+car.getCarLocation().getLongitude()
																	+ ", latitude "+car.getCarLocation().getLatitude());
			}
		}
	}
	/**
	 * We use this method to change a customer's current/start location.
	 * @param custID The custID in String type, like "1", "2"
	 * @param xPos The longitude coordinate that we want to set the customer to.
	 * @param yPos The latitude coordinate that we want set the car to.
	 */
	protected void moveCustomer(String custID, String xPos, String yPos) {
		try {
			Customer custToMove = this.myUber.getCustomerMap().get(custID);
			GPSLocation desC = new GPSLocation(Double.parseDouble(xPos),Double.parseDouble(yPos));
			custToMove.setGpsStart(desC);
			
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("You can not move this customer because of some unknown error.");
		}finally {
			for(Customer c:myUber.getListOfCustomer()) {
				System.out.println("Customer "+c.getIdNum()+" is at longitude "+c.getGpsStart().getLongitude()
					+", latitude "+c.getGpsStart().getLatitude());
			}
		}
	}
	
	/**
	 * Method to return a list of prices matching 4 kinds of ride. 
	 * @param custID Id of the customer who wants to ask for a new ride.
	 * @param xPos Destination longitude coordination.
	 * @param yPos Destination latitude coordination.
	 * @param time The start hour of this asked ride. We use 0-23 as input number. If time < 0, it means regarding system time as ride beginning time.
	 */
	protected void ask4pricer(String custID, String xPos, String yPos, String time) {
		Customer customer = myUber.getCustomerMap().get(custID);
		Double x = Double.parseDouble(xPos);
		Double y = Double.parseDouble(yPos);
		Integer startHH = Integer.parseInt(time);
		customer.askForPrice(x, y, startHH);
	}
	
	/** 
	 * Method to sort and display all drivers according to a specific policy.
	 * @param sortpolicy There are two choices for the "sortpolicy". If sortpolicy = "mostappreciated", we use average mark to sort our drivers, if sortpolicy = "mostoccupied", we use occupied-ratio to sort them.
	 */
	protected void displayDrivers(String sortpolicy) {
		myUber.displayDrivers(sortpolicy);
	}
	
	/**
	 * Method to sort and display all customers according to a specific policy.
	 * @param sortpolicy There are two choices for the "sortpolicy". If sortpolicy = "mostfrequent", we use total amount of rides each customer has taken to sort, if sortpolicy = "mostcharged", we use the total amount of money each customer has spent in our system to sort.
	 */
	protected void diaplayCustomers(String sortpolicy) {
		myUber.displayCustomers(sortpolicy);
	}
	
	/**
	 * Method to display the total amount of money cashed by all drivers in myUber system.
	 */
	protected void totalCashed() {
		myUber.totalCashed();
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
	 * ini
	 * setup [done]
	 * moveCar [done]
	 * moveCustomer [done]
	 * ask4price [done]
	 * simRide
	 * display drivers [done]
	 * displaycustomer [done]
	 * totalcashed [done]
	 * run test
	 * 
	 */

}


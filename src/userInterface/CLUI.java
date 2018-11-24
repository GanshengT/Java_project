package userInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import Cars.BerlineCar;
import Cars.Car;
import Cars.StandardCar;
import Cars.VanCar;
import Rides.Ride;
import myUberSystem.Customer;
import myUberSystem.Driver;
import myUberSystem.MyUber;
import otherTools.GPSLocation;
import otherTools.LocationUtils;

public class CLUI {
	
	MyUber myUber;
	BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	//private BufferedReader brOfIni;
	
	public static void main(String[] args) throws IOException, NoSuchFieldException {
		CLUI myUberCLUI = new CLUI();
		System.out.println("welcome to my Uber, please input your command");
		boolean readSucceed = false;
		boolean continueCommand = true;
		while(continueCommand == true) {
			continueCommand =false;
		while (readSucceed == false) {
			myUberCLUI.commandMatching(myUberCLUI.readCommand());
		}
		System.out.println("do you want to continue? Y/N");
		if(myUberCLUI.yesOrNo()==true) {
			continueCommand = true;
		}
		}
		
		// System.out.println(myUberCLUI.readCommand()[1]);
		
	}
	
	public boolean yesOrNo() throws IOException {
		String yesNo = br.readLine();
		if (yesNo =="Y") {
			return true;
		}
		else return false;
	}
	
	public String[] readCommand() throws IOException {
		String command = br.readLine();
		//List<String> commandLine = new ArrayList<>();	
		return command.split(" ");
	}
	
	public boolean commandMatching (String[] stringLine) throws IOException, NoSuchFieldException {
		String[] command = stringLine;
		if (command[0]=="init") {
			if (command.length != 2) {
				System.out.println("init syntax not right");
				return false;
			}else {
				this.init(command[1]);
				return true;
			}
		}
		else if (command[0] == "setup") {
			if(command.length != 5) {
				System.out.println("setup syntext not right");
				return false;
			}else {
				this.setup(command[1], command[2], command[3], command[4]);
				return true;
			}
		}
		else if(command[0] == "addCustomer") {
			if(command.length != 3) {
				System.out.println("addCustomer syntext not right");
				return false;
			}else {
				this.addCustomer(command[1], command[2]);
				return true;
			}
		}
		else if(command[0] == "addCarDriver") {
			if(command.length != 4) {
				System.out.println("addCarDriver syntext not right");
				return false;
			}else {
				this.addCarDriver(command[1], command[2], command[3]);
				return true;
			}
		}
		else if(command[0] == "addDriver") {
			if(command.length != 4) {
				System.out.println("addDriver syntext not right");
				return false;
			}else {
				this.addDriver(command[1], command[2], command[3]);
				return true;
			}
		}
		else if(command[0] == "setDriverStatus") {
			if(command.length != 4) {
				System.out.println("setDriverStatus syntext not right");
				return false;
			}else {
				this.setDriverStatus(command[1], command[2], command[3]);
				return true;
			}
		}
		else if(command[0] == "moveCar") {
			if(command.length != 4) {
				System.out.println("moveCar syntext not right");
				return false;
			}else {
				this.moveCar(command[1], command[2], command[3]);
				return true;
			}
		}
		else if(command[0] == "moveCustomer") {
			if(command.length != 4) {
				System.out.println("moveCustomer syntext not right");
				return false;
			}else {
				this.moveCustomer(command[1], command[2], command[3]);
				return true;
			}
		}
		else if(command[0] == "displayState") {
			if(command.length != 1) {
				System.out.println("displayState syntext not right");
				return false;
			}else {
				this.displayState();
				return true;
			}
		}
		else if(command[0] == "ask4price") {
			if(command.length != 5) {
				System.out.println("ask4price syntext not right");
				return false;
			}else {
				this.ask4price(command[1], command[2], command[3], command[4]);
				return true;
			}
		}
		else if(command[0] == "simRide") {
			if(command.length != 9) {
				System.out.println("simRide syntext not right");
				return false;
			}else {
				this.simRide(command[1], command[2], command[3], command[4], command[5], command[6], command[7], command[8]);
				return true;
			}
		}
		else if(command[0] == "simRide_i") {
			if(command.length != 4) {
				System.out.println("simRide_i syntext not right");
				return false;
			}else {
				this.simRide_i(command[1], command[2], command[3]);
				return true;
			}
		}
		else if(command[0] == "displayDrivers") {
			if(command.length != 2) {
				System.out.println("displayDrivers syntext not right");
				return false;
			}else {
				this.displayDrivers(command[1]);
				return true;
			}
		}
		else if(command[0] == "displayCustomers") {
			if(command.length != 2) {
				System.out.println("displayCustomers syntext not right");
				return false;
			}else {
				this.displayCustomers(command[1]);
				return true;
			}
		}
		else if(command[0] == "totalCashed") {
			if(command.length != 1) {
				System.out.println("totalCashed syntext not right");
				return false;
			}else {
				this.totalCashed();
				return true;
			}
		}
		return false;
	}
	
	

	protected void init(String filename) throws IOException, NoSuchFieldException {
		List<String> initCommandList = new ArrayList<>();
		File f = new File(filename);
		FileInputStream in = new FileInputStream(f);
		InputStreamReader inr = new InputStreamReader(in);
		BufferedReader brOfIni = new BufferedReader(inr);
		String lineCommand =null;
		Boolean judgement;
		while((lineCommand = brOfIni.readLine()) != null) {
			System.out.println(lineCommand);
			initCommandList.add(lineCommand);
		}
		//System.out.println(commandString.size());
		for(String line: initCommandList) {
			String[] commandInit = line.split(" ");
			judgement = commandMatching(commandInit);
			//System.out.println(command[0]);
		}
		this.displayState();
	}
	
	protected void addCustomer(String customerName, String customerSurname) throws NoSuchFieldException {
		myUber.addCustomer(customerName, customerSurname);
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
			myUber.addBerlineCar();
			}
		else if (carType == "standard") {
			myUber.addStandardCar();
		}
		else if (carType =="van") {
			myUber.addVanCar();
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
		myUber.displayDrivers("mostappreciated");
		myUber.displayDrivers("mostoccupied");
		System.out.println("Customers infomation");
		for(Customer customer : myUber.getListOfCustomer()) {
			System.out.println("customer's ID "+customer.getIdNum()+"customer's name and surname"+customer.getName()+customer.getSurName()+
					"ride number: "+customer.getRideNum()+ "location: "+customer.getGpsStart()+"consumming money: "+customer.getOnCarMoney());
		}
		myUber.displayCustomers("mostfrequent");
		myUber.displayCustomers("mostcharged");
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
	protected void ask4price(String custID, String xPos, String yPos, String time) {
		Customer customer = myUber.getCustomerMap().get(custID);
		Double x = Double.parseDouble(xPos);
		Double y = Double.parseDouble(yPos);
		Integer startHH = Integer.parseInt(time);
		customer.askForPrice(x, y, startHH);
	}
	
	private void simRide_i(String string, String string2, String string3) {
		// TODO Auto-generated method stub
		
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
	protected void displayCustomers(String sortpolicy) {
		myUber.displayCustomers(sortpolicy);
	}
	
	/**
	 * Method to display the total amount of money cashed by all drivers in myUber system.
	 */
	protected void totalCashed() {
		myUber.totalCashed();
	}
	
	/**
	 * Method to execute a ride automatically, and print out the state of ride.
	 * @param customerID To indicate the customer who wants to do this order.
	 * @param passengerNum To indicate the number of passengers for this new ride.
	 * @param xPos The longitude coordinate of ride destination.
	 * @param yPos The latitude coordinate of ride destination.
	 * @param timeHH Ride beginning hour.
	 * @param timeMM Ride beginning minute.
	 * @param rideType Ride type. Choices: "uberx", "uberblack", "ubervan", "uberpool".
	 * @param driverMark Customer's evaluation for this ride(driver). From 1 to 5. 
	 */
	protected void simRide(String customerID, String passengerNum, String xPos, String yPos, String timeHH, String timeMM, String rideType, String driverMark) {
		Customer customer = myUber.getCustomerMap().get(customerID);
		Ride simRide = customer.createANewRideAuto(Integer.parseInt(passengerNum),Double.parseDouble(xPos), Double.parseDouble(yPos), Integer.parseInt(timeHH), Integer.parseInt(timeMM), rideType);
		myUber.driverAllocation(simRide);
		customer.aboard();
		myUber.RideFinished(simRide, Integer.parseInt(driverMark));
		System.out.println("The current ride is a "+simRide.getRideType()+" ride, it is "+simRide.getState());
		System.out.println("For this ride, the dirver ID is: "+simRide.getDriver().getDriverId()+", the car ID is: "+simRide.getCar().getIdCar()
								+", the customer is Customer "+simRide.getCustomer().getIdNum()+".");
		System.out.println("The ride length is "+simRide.getLength()+"km, the traffic state is "+simRide.getTrafficState()
							+", and the cost is "+simRide.getPriceToPay()+".");
		System.out.println("This ride began at "+simRide.getStartTime().getTime()+", the end time is "+simRide.getEndTime().getTime()
							+", and the duration is "+simRide.getDuration()+"min.");
		
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


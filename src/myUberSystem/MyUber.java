package myUberSystem;
import java.io.*;
import java.util.*;
import org.ini4j.*;
import org.junit.platform.commons.util.CollectionUtils;

import Cars.BerlineCar;
import Cars.Car;
import Cars.CreateBerlineCar;
import Cars.CreateCar;
import Cars.CreateStandardCar;
import Cars.CreateVanCar;
import Cars.StandardCar;
import Cars.VanCar;
import Rides.Ride;
import Rides.RideUberPool;
import otherTools.GPSLocation;
import otherTools.LocationUtils;
import otherTools.MyTime;

/**
 * This is the main class of our project. 
 * We instance this class in order to obtain a MyUber system(object).
 * @author gaelle
 *
 */
public class MyUber  {
	/**
	 * We use these attributes to initialize myUber system.
	 */
	private int numStandardCar;
	private int numBerlineCar;
	private int numVanCar;
	private int numDriver;
	private int numCustomer;
	private double totalCashed = 0.0;
	private Ini ini;
	private AreaUsed areaUsed;
	private String[] customerNameList =new String[numCustomer];
	private String[] customerSurnameList = new String[numCustomer];
	private String[] driverNameList =new String[numDriver];
	private String[] driverSurnameList = new String[numDriver];
	private String[] driverOwnershipListString = new String[numDriver];
	private Boolean[] driverOwnershipList = new Boolean[numDriver];
 	private List<Car> listOfCar = new ArrayList<>();
	private List<Car> listOfStandardCar = new ArrayList<>();
	private List<Car> listOfBerlineCar = new ArrayList<>();
	private List<Car> listOfVanCar = new ArrayList<>();
	private List<Driver> listOfDriver = new ArrayList<>();
	private List<Boolean> listOfOwnership = new ArrayList<>();
	private List<Customer> listOfCustomer = new ArrayList<>();
	
	/**
	 * Attributes for ride's request operations.
	 */
	private List<BookOfRide> bookOfRideList = new ArrayList<>();
	private List<Ride> poolRequest = new ArrayList<>();
	private List<Ride> listOfRide = new ArrayList<>();
	private CreateCar createStandardCar = new CreateStandardCar();
	private CreateCar createBerlineCar = new CreateBerlineCar();
	private CreateCar createVanCar = new CreateVanCar();
	private Map<String, Car> carMap = new HashMap<String, Car>();
	private Map<String, Customer> customerMap = new HashMap<String, Customer>();
	
	
	/**
	 * Constructor
	 * We use an ".ini" file to initialize myUber system.
	 * @param iniFileName
	 * @throws InvalidFileFormatException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public MyUber(String iniFileName) throws InvalidFileFormatException, FileNotFoundException, IOException {
		this.ini = new Ini(new FileReader(new File(iniFileName)));
		Ini.Section section = ini.get("case1");
		this.numCustomer = Integer.parseInt(section.get("customerNumber"));
		this.numStandardCar = Integer.parseInt(section.get("standardCarNumber"));
		this.numBerlineCar = Integer.parseInt(section.get("berlineCarNumber"));
		this.numVanCar = Integer.parseInt(section.get("vanCarNumber"));
		this.numDriver = Integer.parseInt(section.get("driverNumber"));
		this.areaUsed = new AreaUsed(new GPSLocation(Double.parseDouble(section.get("longitude")),Double.parseDouble(section.get("latitude"))),
									Double.parseDouble(section.get("radius"))) ; 
		this.customerNameList =section.getAll("customername", String[].class);
		this.customerSurnameList =section.getAll("customersurname", String[].class);
		this.driverNameList =section.getAll("drivername", String[].class);
		this.driverSurnameList =section.getAll("driversurname", String[].class);
		this.driverOwnershipList = section.getAll("ownership", Boolean[].class);
		this.driverOwnershipListString = section.getAll("ownership", String[].class);
		//System.out.println(driverOwnershipList[6]);
		this.initialisation();

	}
	
	public MyUber(String nStandardCars, String nBerlinCars, String nVanCars, String nCustomers) {
		this.numCustomer = Integer.parseInt(nCustomers);
		this.numStandardCar = Integer.parseInt(nStandardCars);
		this.numBerlineCar = Integer.parseInt(nBerlinCars);
		this.numVanCar = Integer.parseInt(nVanCars);
		this.numDriver = this.numStandardCar + this.numBerlineCar + this.numVanCar;
		this.areaUsed = new AreaUsed(new GPSLocation(48.85, 23.33),40.00) ; 
		this.setup_initialisation();
		
	}
	
	public void createStandardCarList(){
		for(int j = 0;j<numStandardCar; j++) {
			listOfCar.add(0,createStandardCar.createCarMethod(areaUsed));
			listOfStandardCar.add(listOfCar.get(0));
			this.carMap.put(listOfCar.get(0).getIdCar(), listOfCar.get(0));
		}
		}
	
	public void createBerlineCarList(){
		for(int j = 0;j<numBerlineCar; j++) {
			listOfCar.add(0,createBerlineCar.createCarMethod(areaUsed));
			listOfBerlineCar.add(listOfCar.get(0));
			this.carMap.put(listOfCar.get(0).getIdCar(), listOfCar.get(0));
		}
	}	
	
	public void createVanCarList(){
		for(int j = 0;j<numVanCar; j++) {
			listOfCar.add(0,createVanCar.createCarMethod(areaUsed));
			listOfVanCar.add(listOfCar.get(0));
			this.carMap.put(listOfCar.get(0).getIdCar(), listOfCar.get(0));
		}
	}
	
	public void assignDriver(List<Driver> listOfDriver) {
		Car.nonAssignedDrivers.addAll(listOfDriver);
		//Collections.copy(Car.nonAssignedDrivers , listOfDriver);
		for(Car car : listOfCar) {
			car.AssignDriver();
		}
	}
	
	public void createDriverList(){
		for(int i = 0; i<numDriver; i++) {
			//System.out.println(i);
			//System.out.println(driverNameList[0]);
			//System.out.println(driverOwnershipList[i]);
			//System.out.println(this.listOfDriver.size()+"driverlist");
			//System.out.println(listOfDriver.get(i).getOwnership());
			
			//listOfDriver.add(new Driver(driverNameList[i],driverSurnameList[i],driverOwnershipList[i]));
			listOfDriver.add(new Driver("driver"+(i+1)+"name","driver"+(i+1)+"surname",true));
		}

	}
	
	public void createCostomerList(){
		for(int i = 0; i<numCustomer;i++) {
			/*
			Customer customer = new Customer(customerNameList[i],customerSurnameList[i]);
			customer.setGpsStart(LocationUtils.GetRandomLocation(this.areaUsed.getCenter(),this.areaUsed.getRadius()));
			listOfCustomer.add(customer);
			*/
			Customer customer = new Customer("customer"+(i+1)+"name","customer"+(i+1)+"surname");
			customer.setGpsStart(LocationUtils.GetRandomLocation(this.areaUsed.getCenter(),this.areaUsed.getRadius()));
			listOfCustomer.add(customer);	
			customerMap.put(Integer.toString(customer.getIdNum()), customer);
		}
	}
	
	public void stringToBoolean() {
		for(int i=0;i<numDriver;i++) {
			//System.out.println(i);
			//System.out.println(driverOwnershipListString[i]);
			this.driverOwnershipList[i] = Boolean.parseBoolean(driverOwnershipListString[i]);
			//System.out.println(driverOwnershipList[i]);
		}
	}
	
	/**
	 * Main method to do an initialization through a .ini file.
	 */
	public void initialisation() {
		this.stringToBoolean();
		this.createCostomerList();
		this.createDriverList();
		//System.out.println(listOfDriver+"listofdriver");
		this.createStandardCarList();
		this.createBerlineCarList();
		this.createVanCarList();
		this.assignDriver(listOfDriver);
		
	}
	
	/**
	 * The main method in the setup method of CLUI to create a new MyUber System according to 4 principal numbers.
	 */
	public void setup_initialisation() {
		this.createCostomerList();
		this.createDriverList();
		this.createStandardCarList();
		this.createBerlineCarList();
		this.createVanCarList();
		this.assignDriver(listOfDriver);
	}
	
	/**
	 * Method to distribute driver to a ride
	 * @param ride
	 */
	public void driverAllocation(Ride ride) {
		if (ride.getRideType() == "uberPool") {
			this.poolRequest.add(0,ride);
			//this.listOfRide.add(ride);
			if(poolRequest.size()>=2) {
				OUT:
				for(int i = poolRequest.size()-1;i>=0;i--) {
					for(int j = poolRequest.size()-2;j >= 0; j--) {
						if(poolRequest.get(i).getPassengerNum()+poolRequest.get(j).getPassengerNum()<=4) {
							Ride newRideUberPool = new RideUberPool(poolRequest.get(i),poolRequest.get(j));
							this.listOfRide.add(newRideUberPool);
							this.searchDriver(newRideUberPool);
							newRideUberPool.calculateLowestRideCost(newRideUberPool.getCar());
							newRideUberPool.setDurationMin(Ride.calculateDuration(newRideUberPool.getLength(), Ride.getTrafficSpeedMap().get(newRideUberPool.getTrafficState())));
							newRideUberPool.setDurationMin2(Ride.calculateDuration(newRideUberPool.getLength2(), Ride.getTrafficSpeedMap().get(newRideUberPool.getTrafficState())));
							newRideUberPool.setEndTime(newRideUberPool.returnEndTime(newRideUberPool.getStartTime()));
							newRideUberPool.setEndTime2(newRideUberPool.returnEndTime(newRideUberPool.getStartTime2()));
							newRideUberPool.getCustomer().setCurrentRide(newRideUberPool);
							newRideUberPool.getCustomer2().setCurrentRide(newRideUberPool);
							newRideUberPool.getDriver().setOnARideTime(newRideUberPool.getDriver().getOnARideTime()+newRideUberPool.getDurationMin()+newRideUberPool.getDurationMin2());
							poolRequest.remove(i);
							poolRequest.remove(j);
							break OUT;
						}else {
							continue;
						}
					}
				}
			}
		}
		else {
			this.listOfRide.add(ride);
			this.searchDriver(ride);
			ride.getDriver().setOnARideTime(ride.getDuration()+ride.getDriver().getOnARideTime());
		}
		/**
		 * search nearest driver
		 */	
	}
	
	/**
	 * Sorting a list of a specific type cars according to the distance between the car and the customer(s) of this ride.
	 * Then return this list for the nest allocation task.
	 * @param ride
	 * @return
	 */
	public List<Car> sortByDistance(Ride ride) {
		List<Car> listSorted = new ArrayList<>();
		if (ride.getRideType()=="uberX") {
			listSorted = this.getListOfStandardCar();
			for (Car car:listSorted) {
				car.calculateDistance(ride);
			}
			Collections.sort(listSorted);
		}
		else if(ride.getRideType()=="uberBlack") {
			listSorted = this.getListOfBerlineCar();
			for (Car car:listSorted) {
				car.calculateDistance(ride);
			}
			Collections.sort(listSorted);
		}
		else if(ride.getRideType()=="uberVan") {
			listSorted = this.getListOfVanCar();
			for (Car car:listSorted) {
				car.calculateDistance(ride);
			}
			Collections.sort(listSorted);
		}
		else if(ride.getRideType()=="uberPool") {
			listSorted = this.getListOfStandardCar();
			for (Car car: listSorted) {
				ride.calculateLowestRideCost(car);
				double cost = ride.getCost();
				car.setDistanceForSort((int) (cost));
			}
			Collections.sort(listSorted);
		}
		else {
			System.out.println("type not right");
		}
		return listSorted;
	}
	
	/**
	 * Setting driver and car for a ride.
	 * Then changing ride and driver's states.
	 * @param ride
	 */
	public void searchDriver(Ride ride) {
		List<Car> carListToNotify = this.sortByDistance(ride);
		System.out.println(ride.getRideType());
		for (Car car : carListToNotify) {
			System.out.println(car.getIdCar());
			System.out.println(car.getCurrentDriver());
			System.out.println(this.getDriverObject(car.getCurrentDriver()).getStatus());
			if (this.getDriverObject(car.getCurrentDriver()).getStatus()== "on-duty") {
			Boolean acceptOrNot = this.getDriverObject(car.getCurrentDriver()).acceptRequest(); //We change driver's state in acceptRequest method.
			//System.out.println("if succeed");
			if (acceptOrNot == true) {
				BookOfRide	bookOfRide = new BookOfRide(car.getCurrentDriver(), car.getIdCar(), ride.getCustomer().getIdNum(), ride.getStartPosition(),
						ride.getEndPosition(), ride.getLength(), ride.getStartTime(),ride.getEndTime());
				ride.setDriver(this.getDriverObject(car.getCurrentDriver()));
				ride.setCar(car);
				System.out.println(ride.getDriver().getDriverId()+" accept this ride.");
				this.bookOfRideList.add(bookOfRide);
				ride.setState("confirmed");
				break;
			}
			else {
				System.out.println("this driver "+car.getCurrentDriver()+" refuse this ride.");
				continue;
			}
			}
			else {
				continue;
			}
		}
		if (ride.getDriver()==null) {
		System.out.println("no car available");
	}
	}
	
	public Driver getDriverObject(int id) {
		for (Driver driver : this.getListOfDriver() ) {
			if (driver.getDriverId() == id) {
			return driver;	
			}}
	return this.listOfDriver.get(1);
	}
	
	/**
	 * When a ride is finished, we use this method to change car's, driver's, customer's and ride's state.
	 * At the same time, we update the total ride number and money cashed for the customer and the driver.
	 * Then we give the car and the customer in this ride a new GPS location for the next ride.
	 * We also change the driver's state after a ride(from on-a-ride to on-duty or take a break or offline).
	 * We need to manually change a driver's status from off-duty to on-duty/
	 * @param ride
	 * @return
	 */
	public double RideFinished(Ride ride, int mark) {
		if(ride.getRideType() == "uberPool") {
			ride.getCustomer().setRideNum(ride.getCustomer().getRideNum()+1);
			ride.getCustomer().setOnCarMoney(ride.getCustomer().getOnCarMoney()+ride.price());
			ride.getCustomer().setCurrentRide(null);
			ride.getCustomer().setGpsStart(LocationUtils.GetRandomLocation(this.areaUsed.getCenter(), this.areaUsed.getRadius()));
			
			ride.getCustomer2().setRideNum(ride.getCustomer2().getRideNum()+1);
			ride.getCustomer2().setOnCarMoney(ride.getCustomer2().getOnCarMoney()+ride.price2());
			ride.getCustomer2().setCurrentRide(null);
			ride.getCustomer2().setGpsStart(LocationUtils.GetRandomLocation(this.areaUsed.getCenter(), this.areaUsed.getRadius()));
			
			ride.getDriver().setMoneyCashed(ride.getDriver().getMoneyCashed()+ride.price()+ride.price2());
		}else {
			ride.getCustomer().setRideNum(ride.getCustomer().getRideNum()+1);
			ride.getCustomer().setOnCarMoney(ride.getCustomer().getOnCarMoney()+ride.getPriceToPay());
			ride.getCustomer().setCurrentRide(null);
			ride.getCustomer().setGpsStart(LocationUtils.GetRandomLocation(this.areaUsed.getCenter(), this.areaUsed.getRadius()));
			
			ride.getDriver().setMoneyCashed(ride.getDriver().getMoneyCashed()+ride.price());
		}
		
		ride.getDriver().setRideNum(ride.getDriver().getRideNum()+1);
		ride.getDriver().askMark(mark);
		ride.getCar().setDistanceForSort(0);
		ride.getCar().setCarLocation(LocationUtils.GetRandomLocation(this.areaUsed.getCenter(), this.areaUsed.getRadius()));
		ride.setState("completed");
		
		double randomNum = Math.random();
		if(randomNum<=0.33) {
		ride.getDriver().setStatus("off-duty");
		/**
		 * time unit is second
		 */
	
	}
		/**
		 * offline
		 */
		else if(randomNum <= 0.66) {
			ride.getDriver().setStatus("offline");
			//System.out.println(ride.getCar().getIdCar());
			//System.out.println(ride.getCar().getIdCar()+" ride get car");
			ride.getCar().changeDriver();
			
		}
		else {
			ride.getDriver().setStatus("on-duty");
		}
		
		return 0;
		
		
	}
	
	/**
	 * We use this method to print out a list of drivers sorted by a specific policy.
	 * @param sortPolicy
	 */
	public void displayDrivers(String sortPolicy) {
	List<Driver> appreciatedDriverList = new ArrayList<>();
	List<Driver> occupiedDriverList = new ArrayList<>();
	appreciatedDriverList.addAll(this.listOfDriver);
	occupiedDriverList.addAll(this.listOfDriver);
	if(sortPolicy.equals("mostappreciated")) {
		Collections.sort(appreciatedDriverList,new Comparator<Driver>(){
            public int compare(Driver arg0, Driver arg1) {
                return arg0.getAverageMark().compareTo(arg1.getAverageMark());
            }
        });
		for (Driver driver : appreciatedDriverList) {
			System.out.printf("Driver"+driver.getDriverId()+"'s average mark is: %.3f\n", driver.getAverageMark());
		}
	}
	else if(sortPolicy.equals("mostoccupied")) {
		for (Driver driver:occupiedDriverList) {
			if(driver.getStatus().equals("offline") || driver.getStatus().equals("off-duty")) {
			    driver.setOccupiedRate(driver.getOnARideTime()/(driver.getOndutyTime()*10000));
			}else {
				MyTime timeNow = new MyTime();
				driver.setOccupiedRate(driver.getOnARideTime()/((driver.getOndutyTime()+timeNow.timeMinus(driver.getStartOnduty()))*10000));
			}
		}
		Collections.sort(occupiedDriverList,new Comparator<Driver>(){
            public int compare(Driver arg0, Driver arg1) {
                return arg0.getOccupiedRate().compareTo(arg1.getOccupiedRate());
            }
        });
		for (Driver driver : occupiedDriverList) {
			System.out.printf("Driver"+driver.getDriverId()+"'s occupied ratio is: %.3f\n", driver.getOccupiedRate());
		}		
	}
	else {
		System.out.println("please input 'mostoccupied' or 'mostappreciated'.");
	}	
}
	
	/**
	 * We use this method to sort drivers and write down a list of drivers sorted by a specific policy.
	 * @param sortPolicy
	 * @param bw
	 */
	public void displayDrivers(String sortPolicy, BufferedWriter bw) {
		List<Driver> appreciatedDriverList = new ArrayList<>();
		List<Driver> occupiedDriverList = new ArrayList<>();
		appreciatedDriverList.addAll(this.listOfDriver);
		occupiedDriverList.addAll(this.listOfDriver);
		try {
		if(sortPolicy.equals("mostappreciated")) {
			Collections.sort(appreciatedDriverList,new Comparator<Driver>(){
	            public int compare(Driver arg0, Driver arg1) {
	                return arg0.getAverageMark().compareTo(arg1.getAverageMark());
	            }
	        });
			bw.write("displayDrivers by appreciated level:\r\n");
			for (Driver driver : appreciatedDriverList) {
				bw.write("Driver"+driver.getDriverId()+"'s average mark is: "+driver.getAverageMark()+".\r\n");
			}
		}
		else if(sortPolicy.equals("mostoccupied")) {
			for (Driver driver:occupiedDriverList) {
				if(driver.getStatus().equals("offline") || driver.getStatus().equals("off-duty")) {
				    driver.setOccupiedRate(driver.getOnARideTime()/(driver.getOndutyTime()*10000));
				}else {
					MyTime timeNow = new MyTime();
					driver.setOccupiedRate(driver.getOnARideTime()/(10000*(driver.getOndutyTime()+timeNow.timeMinus(driver.getStartOnduty()))));
				}
			}
			Collections.sort(occupiedDriverList,new Comparator<Driver>(){
	            public int compare(Driver arg0, Driver arg1) {
	                return arg0.getOccupiedRate().compareTo(arg1.getOccupiedRate());
	            }
	        });
			bw.write("displayDrivers by occupied level:\r\n");
			for (Driver driver : occupiedDriverList) {
				bw.write("Driver"+driver.getDriverId()+"'s occupied ratio is: "+driver.getOccupiedRate()+".\r\n");
			}		
		}
		else {
			bw.write("displayDrivers failed.\r\n");
		}	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * We use this method to print out a list of customer sorted by a specific policy.
	 * @param sortPolicy
	 */
	public void displayCustomers(String sortPolicy) {
	List<Customer> frequentCustomerList = new ArrayList<>();
	List<Customer> chargedCustomerList = new ArrayList<>();
	frequentCustomerList.addAll(this.listOfCustomer);
	chargedCustomerList.addAll(this.listOfCustomer);
	if(sortPolicy.equals("mostfrequent")) {
		Collections.sort(frequentCustomerList,new Comparator<Customer>(){
            public int compare(Customer arg0, Customer arg1) {
                return arg0.getRideNum().compareTo(arg1.getRideNum());
            }
        });
		for (Customer customer : frequentCustomerList) {
			System.out.println("Customer"+customer.getIdNum()+" has taken "+customer.getRideNum()+" rides.");
		}
	}
	else if(sortPolicy.equals("mostcharged")) {
		Collections.sort(chargedCustomerList,new Comparator<Customer>(){
            public int compare(Customer arg0, Customer arg1) {
                return arg0.getOnCarMoney().compareTo(arg1.getOnCarMoney());
            }
        });
		for (Customer customer : chargedCustomerList) {
			System.out.println("Customer"+customer.getIdNum()+" has spent "+customer.getOnCarMoney()+" euros in this system.");
		}		
	}
	else {
		System.out.println("please input 'mostcharged or 'mostfrequent'.");
	}
	
	
	
}
	
	/**
	 * Method to sort customers and write down the result 
	 * @param sortPolicy
	 * @param bw
	 */
	public void displayCustomers(String sortPolicy, BufferedWriter bw) {
		List<Customer> frequentCustomerList = new ArrayList<>();
		List<Customer> chargedCustomerList = new ArrayList<>();
		frequentCustomerList.addAll(this.listOfCustomer);
		chargedCustomerList.addAll(this.listOfCustomer);
		if(sortPolicy.equals("mostfrequent")) {
			Collections.sort(frequentCustomerList,new Comparator<Customer>(){
	            public int compare(Customer arg0, Customer arg1) {
	                return arg0.getRideNum().compareTo(arg1.getRideNum());
	            }
	        });
			try {
				bw.write("displayCustomers by frequency:\r\n");
				for (Customer customer : frequentCustomerList) {
					bw.write("Customer"+customer.getIdNum()+" has taken "+customer.getRideNum()+" rides.\r\n");
				}}catch(Exception e) {
					e.printStackTrace();
			}
		}
		else if(sortPolicy.equals("mostcharged")) {
			Collections.sort(chargedCustomerList,new Comparator<Customer>(){
	            public int compare(Customer arg0, Customer arg1) {
	                return arg0.getOnCarMoney().compareTo(arg1.getOnCarMoney());
	            }
	        });
			try {
				bw.write("displayCustomers by charged level:\r\n");
				for (Customer customer : chargedCustomerList) {
					bw.write("Customer"+customer.getIdNum()+" has spent "+customer.getOnCarMoney()+" euros in this system.\r\n");
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				bw.write("displayCustomers failed.\r\n");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * We use this method to calculate the total money cashed by all of the drivers in our system.
	 */
	public void totalCashed() {
		for(Driver driver: this.listOfDriver) {
			this.totalCashed += driver.getMoneyCashed();
		}
		System.out.println("The total amount of mont cashed by all drivers in our system is : "+this.totalCashed);
	}
	
	/**
	 * We use this method to calculate the total money cashed by all of the drivers in our system and write down the result.
	 */
	public void totalCashed(BufferedWriter bw) {
		for(Driver driver: this.listOfDriver) {
			this.totalCashed += driver.getMoneyCashed();
		}
		try {
			bw.write("\r\ntotalCashed:\r\nThe total amount of mont cashed by all drivers in our system is : "+this.totalCashed);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * add customer, this function will be used in CLI
	 * @param customerName
	 * @param customerSurname
	 * @throws NoSuchFieldException
	 */
	public void addCustomer(String customerName, String customerSurname) throws NoSuchFieldException {
		Customer customer =new Customer(customerName,customerSurname);
		customer.setGpsStart(LocationUtils.GetRandomLocation(this.getAreaUsed().getCenter(),this.getAreaUsed().getRadius()));
		this.getListOfCustomer().add(customer);
		this.getCustomerMap().put(Integer.toString(customer.getIdNum()),customer);}
	
	
	//multimorphisme why do I need convert
	public void addBerlineCar() {
	BerlineCar newcar =  (BerlineCar) createBerlineCar.createCarMethod(areaUsed);
	newcar.AssignDriver();
	this.getListOfBerlineCar().add(newcar);
	this.getListOfCar().add(newcar);
	this.getCarMap().put(newcar.getIdCar(),newcar);
	}
	
	
	public void addStandardCar() {
		StandardCar newcar = (StandardCar) createStandardCar.createCarMethod(areaUsed);
		newcar.AssignDriver();
		this.getListOfStandardCar().add(newcar);
		this.getListOfCar().add(newcar);
		this.getCarMap().put(newcar.getIdCar(), newcar);
	}
	
	public void addVanCar() {
		VanCar newcar = (VanCar) createVanCar.createCarMethod(areaUsed);
		newcar.AssignDriver();
		this.getListOfVanCar().add(newcar);
		this.getListOfCar().add(newcar);
		this.getCarMap().put(newcar.getIdCar(), newcar);
	}
	
	/**
	 * getter and setter
	 * @return
	 */
	public int getNumStandardCar() {
		return numStandardCar;
	}

	public void setNumStandardCar(int numStandardCar) {
	this.numStandardCar = numStandardCar;
	}

	public int getNumBerlineCar() {
		return numBerlineCar;
	}

	public void setNumBerlineCar(int numBerlineCar) {
		this.numBerlineCar = numBerlineCar;
	}

	public int getNumVanCar() {
		return numVanCar;
	}

	public void setNumVanCar(int numVanCar) {
		this.numVanCar = numVanCar;
	}

	public int getNumDriver() {
		return numDriver;
	}

	public void setNumDriver(int numDriver) {
		this.numDriver = numDriver;
	}

	public int getNumCustomer() {
		return numCustomer;
	}

	public void setNumCustomer(int numCustomer) {
		this.numCustomer = numCustomer;
	}

	public Ini getIni() {
		return ini;
	}

	public void setIni(Ini ini) {
		this.ini = ini;
	}

	public AreaUsed getAreaUsed() {
		return areaUsed;
	}

	public void setAreaUsed(AreaUsed areaUsed) {
		this.areaUsed = areaUsed;
	}

	public String[] getCustomerNameList() {
		return customerNameList;
	}

	public void setCustomerNameList(String[] customerNameList) {
		this.customerNameList = customerNameList;
	}

	public String[] getCustomerSurnameList() {
		return customerSurnameList;
	}

	public void setCustomerSurnameList(String[] customerSurnameList) {
		this.customerSurnameList = customerSurnameList;
	}

	public String[] getDriverNameList() {
		return driverNameList;
	}

	public void setDriverNameList(String[] driverNameList) {
		this.driverNameList = driverNameList;
	}

	public String[] getDriverSurnameList() {
		return driverSurnameList;
	}

	public void setDriverSurnameList(String[] driverSurnameList) {
		this.driverSurnameList = driverSurnameList;
	}

	public Boolean[] getDriverOwnershipList() {
		return driverOwnershipList;
	}

	public void setDriverOwnershipList(Boolean[] driverOwnershipList) {
		this.driverOwnershipList = driverOwnershipList;
	}

	public List<Car> getListOfCar() {
		return listOfCar;
	}

	public void setListOfCar(List<Car> listOfCar) {
		this.listOfCar = listOfCar;
	}

	public List<Car> getListOfStandardCar() {
		return listOfStandardCar;
	}

	public void setListOfStandardCar(List<Car> listOfStandardCar) {
		this.listOfStandardCar = listOfStandardCar;
	}

	public List<Car> getListOfBerlineCar() {
		return listOfBerlineCar;
	}

	public void setListOfBerlineCar(List<Car> listOfBerlineCar) {
		this.listOfBerlineCar = listOfBerlineCar;
	}

	public List<Car> getListOfVanCar() {
		return listOfVanCar;
	}

	public void setListOfVanCar(List<Car> listOfVanCar) {
		this.listOfVanCar = listOfVanCar;
	}

	public List<Driver> getListOfDriver() {
		return listOfDriver;
	}

	public void setListOfDriver(List<Driver> listOfDriver) {
		this.listOfDriver = listOfDriver;
	}

	public List<Boolean> getListOfOwnership() {
		return listOfOwnership;
	}

	public void setListOfOwnership(List<Boolean> listOfOwnership) {
		this.listOfOwnership = listOfOwnership;
	}

	public List<Customer> getListOfCustomer() {
		return listOfCustomer;
	}

	public void setListOfCustomer(List<Customer> listOfCustomer) {
		this.listOfCustomer = listOfCustomer;
	}

	public List<BookOfRide> getBookOfRideList() {
		return bookOfRideList;
	}

	public void setBookOfRideList(List<BookOfRide> bookOfRideList) {
		this.bookOfRideList = bookOfRideList;
	}

	public List<Ride> getPoolRequest() {
		return poolRequest;
	}

	public void setPoolRequest(List<Ride> poolRequest) {
		this.poolRequest = poolRequest;
	}

	public List<Ride> getListOfRide() {
		return listOfRide;
	}

	public void setListOfRide(List<Ride> listOfRide) {
		this.listOfRide = listOfRide;
	}

	
	public double getTotalCashed() {
		return totalCashed;
	}

	
	public void setTotalCashed(double totalCashed) {
		this.totalCashed = totalCashed;
	}

	public Map<String, Car> getCarMap() {
		return carMap;
	}

	public void setCarMap(Map<String, Car> carMap) {
		this.carMap = carMap;
	}

	public Map<String, Customer> getCustomerMap() {
		return customerMap;
	}

	public void setCustomerMap(Map<String, Customer> customerMap) {
		this.customerMap = customerMap;
	}
	
	
}

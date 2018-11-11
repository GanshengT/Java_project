package firstPart;
import java.io.*;
import java.util.*;
import org.ini4j.*;

public class MyUber {
	private int numStandardCar;
	private int numBerlineCar;
	private int numVanCar;
	private int numDriver;
	private int numCustomer;
	private Ini ini;
	//private GPSLocation centerLocation;
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
	 * the create car method might not be used
	 * @return
	 */
	
	
	public void createStandardCarList(){

		CreateCar createStandardCar = new CreateStandardCar();
		for(int j = 0;j<numStandardCar; j++) {
			listOfCar.add(createStandardCar.createCarMethod(areaUsed));
			listOfStandardCar.add(createStandardCar.createCarMethod(areaUsed));
		}
	}
	
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

	public void createBerlineCarList(){

		CreateCar createBerlineCar = new CreateBerlineCar();
		for(int j = 0;j<numBerlineCar; j++) {
			listOfCar.add(createBerlineCar.createCarMethod(areaUsed));
			listOfBerlineCar.add(createBerlineCar.createCarMethod(areaUsed));
		}
	}	
	
	public void createVanCarList(){

		CreateCar createVanCar = new CreateVanCar();
		for(int j = 0;j<numVanCar; j++) {
			listOfCar.add(createVanCar.createCarMethod(areaUsed));
			listOfVanCar.add(createVanCar.createCarMethod(areaUsed));
		}
	}
	
	public void assignDriver(List<Driver> listOfDriver) {
		Car.setNonAssignedDrivers(listOfDriver);
		for(Car car : listOfCar) {
			car.AssignDriver(listOfDriver);
		}
	}
	
	public void createDriverList(){
		for(int i = 0; i<numDriver; i++) {
			//System.out.println(i);
			//System.out.println(driverNameList[0]);
			//System.out.println(driverOwnershipList[i]);
			listOfDriver.add(new Driver(driverNameList[i],driverSurnameList[i],driverOwnershipList[i]));
			//System.out.println(listOfDriver.get(i).getOwnership());
		}

	}
	
	/**
	 * generate customers 
	 */
	public void createCostomerList(){
		for(int i = 0; i<numCustomer;i++) {
			listOfCustomer.add(new Customer(customerNameList[i],customerSurnameList[i]));
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
	
	public void initialisation() {
		this.stringToBoolean();
		this.createCostomerList();
		this.createDriverList();
		this.createStandardCarList();
		this.createBerlineCarList();
		this.createVanCarList();
		this.assignDriver(listOfDriver);
	}
	/***
	public static List<Ride> returnListOfRide(Customer customer, int passengerNumRequested, double desLongtude, double desLatitude, Mytime startTime){
		Ride rideX = new RideUberX(customer, passengerNumRequested, desLongtude, desLatitude, startTime);
		Ride rideBlack = new RideUberX(customer, passengerNumRequested, desLongtude, desLatitude, startTime);
		Ride rideVan = new RideUberVan(customer, passengerNumRequested, desLongtude, desLatitude, startTime);
		Ride ridePool = new RideUber
		
	}
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
	
	public static void main(String[] args) throws InvalidFileFormatException, FileNotFoundException, IOException {
		MyUber myUber = new MyUber("my_uber.ini");
		System.out.println(myUber.getNumBerlineCar());
	}
	
}

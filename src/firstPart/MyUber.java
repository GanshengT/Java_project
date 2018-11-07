package firstPart;
import java.io.*;
import java.util.*;
import org.dtools.ini.*;
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
	
	public List<Car> createBerlineCarList(){

		CreateCar createBerlineCar = new CreateBerlineCar();
		for(int j = 0;j<numBerlineCar; j++) {
			listOfCar.add(createBerlineCar.createCarMethod(areaUsed));
			listOfBerlineCar.add(createBerlineCar.createCarMethod(areaUsed));
		}
		return listOfBerlineCar;
	}	
	
	public List<Car> createVanCarList(){

		CreateCar createVanCar = new CreateVanCar();
		for(int j = 0;j<numVanCar; j++) {
			listOfCar.add(createVanCar.createCarMethod(areaUsed));
			listOfVanCar.add(createVanCar.createCarMethod(areaUsed));
		}
		return listOfVanCar;
	}
	
	public void assignDriver(List<Driver> listOfDriver) {
		Car.setNonAssignedDrivers(listOfDriver);
		for(Car car : listOfCar) {
			car.AssignDriver(listOfDriver);
		}
	}
	
	public List<Driver> createDriverList(){
		for(int i = 0; i<numDriver;i++) {
			listOfDriver.add(new Driver(driverNameList[i],driverSurnameList[i],));
		}
		return listOfDriver;
	}
	
	/**
	 * generate customers 
	 */
	public void createCostomerList(){
		for(int i = 0; i<numCustomer;i++) {
			listOfCustomer.add(new Customer(customerNameList[i],customerSurnameList[i]));
		}
	}
	
	public void initialisation() {
		this.createCostomerList();
		this.createDriverList();
		this.createStandardCarList();
		this.createBerlineCarList();
		this.createVanCarList();
		this.assignDriver(listOfDriver);
	}
	
	public MyUber(String iniFileName) throws InvalidFileFormatException, FileNotFoundException, IOException {
		this.ini = new Ini(new FileReader(new File(iniFileName)));
		Ini.Section section = ini.get("case1");
		this.numCustomer = Integer.parseInt(section.get("customerNumber"));
		this.numStandardCar = Integer.parseInt(section.get("standardCarNumber"));
		this.numBerlineCar = Integer.parseInt(section.get("berlineCarNumber"));
		this.numVanCar = Integer.parseInt(section.get("vanCarNumber"));
		this.areaUsed = new AreaUsed(new GPSLocation(Double.parseDouble(section.get("longitude")),Double.parseDouble(section.get("latitude"))),
									Double.parseDouble(section.get("radius"))) ; 
		this.customerNameList =section.getAll("customername", String[].class);
		this.customerSurnameList =section.getAll("customersurname", String[].class);
		this.driverNameList =section.getAll("drivername", String[].class);
		this.driverSurnameList =section.getAll("driversurname", String[].class);
		
		this.initialisation();
	}
	
}

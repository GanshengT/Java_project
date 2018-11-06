package firstPart;
import java.util.*;

public class MyUber {
	private int numStandardCar;
	private int numBerlineCar;
	private int numVanCar;
	private int numDriver;
	private int numCustomer;
	//private GPSLocation centerLocation;
	private AreaUsed areaUsed;
	private String[] nameList =new String[numCustomer];
	private String[] surnameList = new String[numCustomer];
	
	private List<Car> listOfCar = new ArrayList<>();
	private List<Car> listOfStandardCar = new ArrayList<>();
	private List<Car> listOfBerlineCar = new ArrayList<>();
	private List<Car> listOfVanCar = new ArrayList<>();
	
	private List<Driver> listOfDriver = new ArrayList<>();
	private List<Customer> listOfCustomer = new ArrayList<>();
	
	
	/**
	 * the create car method might not be used
	 * @return
	 */
	public List<Car> createStandardCarList(){

		CreateCar createStandardCar = new CreateStandardCar();
		for(int j = 0;j<numStandardCar; j++) {
			listOfCar.add(createStandardCar.createCarMethod(areaUsed));
		}
		return listOfStandardCar;
	}
	
	public List<Car> createBerlineCarList(){

		CreateCar createBerlineCar = new CreateBerlineCar();
		for(int j = 0;j<numBerlineCar; j++) {
			listOfCar.add(createBerlineCar.createCarMethod(areaUsed));
		}
		return listOfBerlineCar;
	}	
	
	public List<Car> createVanCarList(){

		CreateCar createVanCar = new CreateVanCar();
		for(int j = 0;j<numVanCar; j++) {
			listOfCar.add(createVanCar.createCarMethod(areaUsed));
		}
		return listOfVanCar;
	}
	
	public List<Driver> createDriverList(){
		
		
		return listOfDriver;
		
	}
	
	/**
	 * generate customers 
	 */
	public List<Customer> createCostomerList(){
		for(int i = 0; i<numCustomer;i++) {
			listOfCustomer.add(new Customer(nameList[i],surnameList[i]));
		}
		return listOfCustomer;
	}
	
	
}

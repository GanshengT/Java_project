package firstPart;
import java.io.*;
import java.util.*;
import org.ini4j.*;
import org.junit.platform.commons.util.CollectionUtils;

public class MyUber  {
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
	private List<BookOfRide> bookOfRideList = new ArrayList<>();
	private List<Ride> poolRequest = new ArrayList<>();
	private List<Ride> listOfRide = new ArrayList<>();
	private CreateCar createStandardCar = new CreateStandardCar();
	private CreateCar createBerlineCar = new CreateBerlineCar();
	private CreateCar createVanCar = new CreateVanCar();
	

	
	

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
	
	public void createStandardCarList(){
		for(int j = 0;j<numStandardCar; j++) {
			listOfCar.add(0,createStandardCar.createCarMethod(areaUsed));
			listOfStandardCar.add(listOfCar.get(0));
		}
		}
	
	public void createBerlineCarList(){
		for(int j = 0;j<numBerlineCar; j++) {
			listOfCar.add(0,createBerlineCar.createCarMethod(areaUsed));
			listOfBerlineCar.add(listOfCar.get(0));
		}
	}	
	
	public void createVanCarList(){
		for(int j = 0;j<numVanCar; j++) {
			listOfCar.add(0,createVanCar.createCarMethod(areaUsed));
			listOfVanCar.add(listOfCar.get(0));
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
			listOfDriver.add(new Driver(driverNameList[i],driverSurnameList[i],driverOwnershipList[i]));
			//System.out.println(this.listOfDriver.size()+"driverlist");
			//System.out.println(listOfDriver.get(i).getOwnership());
		}

	}
	
	public void createCostomerList(){
		for(int i = 0; i<numCustomer;i++) {
			Customer customer = new Customer(customerNameList[i],customerSurnameList[i]);
			customer.setGpsStart(LocationUtils.GetRandomLocation(this.areaUsed.getCenter(),this.areaUsed.getRadius()));
			listOfCustomer.add(customer);
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
		//System.out.println(listOfDriver+"listofdriver");
		this.createStandardCarList();
		this.createBerlineCarList();
		this.createVanCarList();
		this.assignDriver(listOfDriver);
	}
	
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
							newRideUberPool.getDriver().setOnARideTime(newRideUberPool.getDurationMin()+newRideUberPool.getDurationMin2());
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
			ride.getDriver().setOnARideTime((ride.getDuration()));
		}
		/**
		 * search nearest driver
		 */	
	}
	
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
				car.setDistanceFromCustomer((int) (cost));
			}
			Collections.sort(listSorted);
		}
		else {
			System.out.println("type not right");
		}
		return listSorted;
	}
		
	public void searchDriver(Ride ride) {
		List<Car> carListToNotify = this.sortByDistance(ride);
		System.out.println(ride.getRideType());
		for (Car car : carListToNotify) {
			System.out.println(car.getIdCar());
			System.out.println(car.getCurrentDriver());
			System.out.println(this.getDriverObject(car.getCurrentDriver()).getStatus());
			if (this.getDriverObject(car.getCurrentDriver()).getStatus()== "on-duty") {
			Boolean acceptOrNot = this.getDriverObject(car.getCurrentDriver()).acceptRequest();
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
	 * manulelly change status offduty to onduty
	 * @param ride
	 * @return
	 */
	public double RideFinished(Ride ride) {
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
		ride.getDriver().askMark(5);
		ride.getCar().setDistanceFromCustomer(0);
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
			System.out.println(ride.getCar().getIdCar()+" ride get car");
			ride.getCar().changeDriver();
			
		}
		else {
			ride.getDriver().setStatus("on-duty");
		}
		
		return 0;
		
		
	}
		
	public void displayDrivers(String sortPolicy) {
	List<Driver> appreciatedDriverList = new ArrayList<>();
	List<Driver> occupiedDriverList = new ArrayList<>();
	appreciatedDriverList.addAll(this.listOfDriver);
	occupiedDriverList.addAll(this.listOfDriver);
	if(sortPolicy == "mostappreciated") {
		Collections.sort(appreciatedDriverList,new Comparator<Driver>(){
            public int compare(Driver arg0, Driver arg1) {
                return arg0.getAverageMark().compareTo(arg1.getAverageMark());
            }
        });
		for (Driver driver : appreciatedDriverList) {
			System.out.println(driver.getDriverId());
		}
	}
	else if(sortPolicy == "mostoccupied") {
		for (Driver driver:occupiedDriverList) {
			driver.setOccupiedRate(driver.getOnARideTime()/driver.getOndutyTime());
		}
		Collections.sort(occupiedDriverList,new Comparator<Driver>(){
            public int compare(Driver arg0, Driver arg1) {
                return arg0.getOccupiedRate().compareTo(arg1.getOccupiedRate());
            }
        });
		for (Driver driver : occupiedDriverList) {
			System.out.println(driver.getDriverId());
		}		
	}
	else {
		System.out.println("please input 'mostoccupied' or 'mostappreciated'.");
	}
}

	public void displayCustomers(String sortPolicy) {
	List<Customer> frequentCustomerList = new ArrayList<>();
	List<Customer> chargedCustomerList = new ArrayList<>();
	frequentCustomerList.addAll(this.listOfCustomer);
	chargedCustomerList.addAll(this.listOfCustomer);
	if(sortPolicy == "mostfrequent") {
		Collections.sort(frequentCustomerList,new Comparator<Customer>(){
            public int compare(Customer arg0, Customer arg1) {
                return arg0.getRideNum().compareTo(arg1.getRideNum());
            }
        });
		for (Customer customer : frequentCustomerList) {
			System.out.println(customer.getIdNum());
		}
	}
	else if(sortPolicy == "mostcharged") {
		Collections.sort(chargedCustomerList,new Comparator<Customer>(){
            public int compare(Customer arg0, Customer arg1) {
                return arg0.getOnCarMoney().compareTo(arg1.getOnCarMoney());
            }
        });
		for (Customer customer : chargedCustomerList) {
			System.out.println(customer.getIdNum());
		}		
	}
	else {
		System.out.println("please input 'mostcharged or 'mostfrequent'.");
	}
}

	public void totalCashed() {
		for(Driver driver: this.listOfDriver) {
			this.totalCashed += driver.getMoneyCashed();
		}
		System.out.println("The total amount of mont cashed by drivers is : "+this.totalCashed);
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

	
}

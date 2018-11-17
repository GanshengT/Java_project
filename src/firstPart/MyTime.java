package firstPart;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


public class MyTime {
/**
 * yyyy :year
 * MM: month
 * dd: day
 * HH: hour
 * mm: minute
 * ss:second
 */
	public static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private int yyyy;
	private int MM;
	private int dd;
	private int HH;
	private int mm;
	private int ss;
	
	
	/**
	 * input a new MyTime, output the difference between this two time
	 * use to calculate onduty time
	 * the unit is second
	 * @param otherTime
	 * @return
	 */
	public long timeMinus(MyTime otherTime) {
	long second = 0;
	second = 24*3600*(otherTime.dd - this.dd)+3600*(otherTime.HH - this.HH)+60*(otherTime.mm - this.mm)+otherTime.ss-this.ss;
	return second;
	}

	/**
	 * the first constructor is used for user-defined time in order to facilitate the test
	 * @param HH
	 * @param mm
	 * @param ss
	 */
	public MyTime(int HH, int mm, int ss) {
		Calendar calendar = Calendar.getInstance();	
		this.yyyy = calendar.get(1);
		this.MM = calendar.get(2);
		this.dd = calendar.get(3);
		this.HH = HH;
		this.mm = mm;
		this.ss = ss;
	}
	
	/**
	 * second constructor read the system time
	 */
	public  MyTime() {
		Calendar calendar = Calendar.getInstance();
		this.yyyy = calendar.get(1);
		this.MM = calendar.get(2);
		this.dd = calendar.get(3);
		this.HH = calendar.get(Calendar.HOUR_OF_DAY);
		this.mm = calendar.get(Calendar.MINUTE);
		this.ss = calendar.get(Calendar.SECOND);
	}
	
	
	/**
	 * setter and getter
	 * @return
	 */
	public static String getTIME_FORMAT() {
		return TIME_FORMAT;
	}

	public static void setTIME_FORMAT(String tIME_FORMAT) {
		TIME_FORMAT = tIME_FORMAT;
	}

	public int getYyyy() {
		return yyyy;
	}

	public void setYyyy(int yyyy) {
		this.yyyy = yyyy;
	}

	public int getMM() {
		return MM;
	}

	public void setMM(int mM) {
		MM = mM;
	}

	public int getDd() {
		return dd;
	}

	public void setDd(int dd) {
		this.dd = dd;
	}

	public int getHH() {
		return HH;
	}

	public void setHH(int hH) {
		HH = hH;
	}

	public int getMm() {
		return mm;
	}

	public void setMm(int mm) {
		this.mm = mm;
	}

	public int getSs() {
		return ss;
	}

	public void setSs(int ss) {
		this.ss = ss;
	}

	/**
	 * addTime to calculate the time after adding a duration
	 * the unit of duration is second. 
	 * add second!! not millis
	 * @param durationS
	 */
	public void addTime(double durationS) {
		Calendar cal=java.util.Calendar.getInstance();
		cal.set(this.yyyy, this.MM, this.dd, this.HH, this.mm, this.ss);  
		cal.add(java.util.Calendar.SECOND,(int) durationS); 
		this.yyyy = cal.get(Calendar.YEAR);
		this.MM = cal.get(Calendar.MONTH)+1;
		this.dd = cal.get(Calendar.DAY_OF_MONTH);
		this.HH = cal.get(Calendar.HOUR_OF_DAY);
		this.mm = cal.get(Calendar.MINUTE);
		this.ss = cal.get(Calendar.SECOND);		
	}
	


	/**
	 * advised get latter time method
	 * advantage: shorter, code reuse, normal thinking is to substract two time
	 * public static MyTime getLaterTime(MyTime mytime1, MyTime mytime2) {
	 * if(mytime1.timeMinus(mytime2>=0){
	 * return mytime1	 
	 * }
	 * else{
	 * return mytime2}}
	 * @param mytime1
	 * @param mytime2
	 * @return
	 */
	public static MyTime getLaterTime(MyTime mytime1, MyTime mytime2) {
		if(mytime1.getYyyy() == mytime2.getYyyy()) {
			if(mytime1.getMM() == mytime2.getMM()) {
				if(mytime1.getDd() == mytime2.getDd()) {
					if(mytime1.getHH() == mytime2.getHH()) {
						if(mytime1.getMm() == mytime2.getMm()) {
							if(mytime1.getSs() == mytime2.getSs()) {
								return mytime1;
							}else if(mytime1.getSs() > mytime2.getSs()) {
								return mytime1;
							}else {
								return mytime2;
							}
						}else if(mytime1.getMm() > mytime2.getMm()) {
							return mytime1;
						}else {
							return mytime2;
						}
					}else if(mytime1.getHH() > mytime2.getHH()) {
						return mytime1;
					}else {
						return mytime2;
					}
				}else if(mytime1.getDd() > mytime2.getDd()) {
					return mytime1;
				}else {
					return mytime2;
				}
			}else if(mytime1.getMM() > mytime2.getMM()) {
				return mytime1;
			}else {
				return mytime2;
			}
		}else if(mytime1.getYyyy() > mytime2.getYyyy()) {
			return mytime1;
		}else {
			return mytime2;
		}
	}
	


}


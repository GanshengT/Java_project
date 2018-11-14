package firstPart;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


public class MyTime {

	public static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private int yyyy;
	private int MM;
	private int dd;
	private int HH;
	private int mm;
	private int ss;
	
	/**
	 * compare two time
	 */
	public static String getInterval(String st, String ed) {
		SimpleDateFormat myFormatter = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		long day = 0;
		long second = 0;
		long millisSecond = 0;
		try {
			java.util.Date startDate = myFormatter.parse(st);
			java.util.Date endDate = myFormatter.parse(ed);
			day = (endDate.getTime() - startDate.getTime())
					/ (24 * 60 * 60 * 1000);
			second = (endDate.getTime() - startDate.getTime())/(1000);
			millisSecond = (endDate.getTime() - startDate.getTime());
		} catch (Exception e) {
			return "";
		}
		return day + "";
	}

	public MyTime(int HH, int mm, int ss) {
		Calendar calendar = Calendar.getInstance();	
		this.yyyy = calendar.get(1);
		this.MM = calendar.get(2);
		this.dd = calendar.get(3);
		this.HH = HH;
		this.mm = mm;
		this.ss = ss;
	}
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
	 * add second!! not millis
	 * @param durationS
	 */
	public void addTime(double durationS) {
		/**
		 * if (durationMillisS <= 1000) {
		 *
			this.ss+=0;
		}
		else if(this.ss + durationMillisS/1000 > 60) {
			this.ss = this.ss  + durationMillisS/1000 - 60;
			this.mm = 
					
		}
		*/
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
	 * date format to number and the inverse
	 * @param longStr
	 * @return
	 */
	public static String millis2Time(String longStr) {
		long seconds = Long.parseLong(longStr);
		long millis = seconds * 1000;
		Date date = new Date(millis);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
				Locale.FRANCE);
		sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		String formattedDate = sdf.format(date);
		return formattedDate;
	}
	public static long time2Millis(String date) {
		Date dateFormat = null;
		try {
			dateFormat = new SimpleDateFormat(TIME_FORMAT).parse(date);
		} catch (ParseException e) {
			System.out.println(e.toString());
		}
		Long dateLong = dateFormat.getTime(); 
		return dateLong;
	}
	
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
	
	public static void main(String[] args) {
		MyTime myTime = new MyTime(23,32,10);
		myTime.addTime(1800);
		System.out.println(myTime.getHH());
		System.out.println(myTime.getMm()); 
		System.out.println(myTime.getSs());
	}

	
}

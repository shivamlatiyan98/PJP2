package calculator;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;

public class Functionality {
	private Hashtable data;

	public Functionality(Hashtable da) {
		this.data = da;

	}

	public static int objectoInteger(Object o) {
		return Integer.parseInt(o.toString());
	}

	public String execute() throws ParseException {
		int option = objectoInteger(data.get("option"));
		String answer = "Error";

		//System.out.println("option" + option);
		if (option == 1) {
			return process1();

		} else if (option == 2) {
			return process2();
		}

		else if (option == 3) {

			return data.get("data").toString();
		}

		else if (option == 4) {
			return data.get("data").toString();
		}
		
		else if (option==5) {
			return process5();
		}
		

		return answer;
	}

	

	private String process2() throws ParseException {

		ArrayList dataList = (ArrayList) data.get("data");
		Object unit, date;
		Object n2;
		unit = dataList.get(0);
		n2 =  dataList.get(1);
		
		int n = Integer.parseInt(n2.toString());
		System.out.println("n"+n);
		date = dataList.get(2);

		String answer = "";

		Date strDate = new SimpleDateFormat("dd/MM/yyyy").parse((String) date);

		Calendar c = Calendar.getInstance();
		c.setTime(strDate);
		System.out.println(unit);
		

		if (unit.equals("weeks")||unit.equals("days")) {
			
			if(unit.equals("weeks")) {
			 n *= 7;
			
			}
			c.add(Calendar.YEAR, 0);
			c.add(Calendar.MONTH, 0);
			c.add(Calendar.DATE, n);
			
        
		}

		else if (unit.equals("months")) {
			c.add(Calendar.YEAR, 0);
			c.add(Calendar.MONTH, n);
			c.add(Calendar.DATE, 0);

		}

		Date curDate = c.getTime();
		

		answer = new SimpleDateFormat("dd/MM/yyyy").format(curDate);

		return answer;

	}

	private String process1() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		ArrayList dat = (ArrayList) data.get("data");
		Object date1, opt;
		Object date2;
		date1 = dat.get(0);
		date2 = dat.get(1);

		opt = dat.get(2);
		
		if (opt.equals("+")) {

			Date d1 = null;
			Date d2 = null;

			d1 = format.parse((String) date1);
			d2 = format.parse((String) date2);

			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();

			c1.setTime(d1);
			c2.setTime(d2);

			Calendar cTotal = (Calendar) c1.clone();

			cTotal.add(Calendar.YEAR, c2.get(Calendar.YEAR));
			cTotal.add(Calendar.MONTH, c2.get(Calendar.MONTH) + 1);
			cTotal.add(Calendar.DATE, c2.get(Calendar.DATE));

			String answer;
			answer = modify(cTotal);

			return answer;

		}

		else if (opt.equals("-")) {
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			Date d1 = null;
			Date d2 = null;

			d1 = format.parse((String) date1);
			d2 = format.parse((String) date2);

			c1.setTime((Date) date1);
			c2.setTime((Date) date2);

			d1 = format.parse((String) date1);
			d2 = format.parse((String) date2);

			Calendar before, after;

			before = (Calendar) c1.clone();
			after = (Calendar) c2.clone();

			if (!before.before(after)) {
				before = (Calendar) c2.clone();
				after = (Calendar) c1.clone();
			}

			int[] fields = { Calendar.YEAR, Calendar.MONTH, Calendar.DATE };
			int[] changes = { 0, 0, 0 };
			Calendar clone = (Calendar) before.clone();
			int index = 0;

			for (int field : fields) {
				int changed = -1;
				Calendar subs_tracker = (Calendar) clone.clone();
				while (!subs_tracker.after(after)) {
					subs_tracker.add(field, 1);
					changed++;
				}
				changes[index++] = changed;
				clone.add(field, changed);
			}

			String answer = changes[2] + "/" + changes[1] + "/" + changes[0];
			clone.setTime(format.parse(answer));

			return modify(clone);

		}

		return null;

	}

	public static String modify(Calendar c) {
		return c.get(Calendar.DATE) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR);
	}

	public static String process5() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the expression");
	
		String exString=sc.next();
		int n=0;
		if(exString.charAt(0)=='N') {
			System.out.println("Enter the value of N");
			n=sc.nextInt();
		
					
			
		}
		
		
		LocalDateTime today = LocalDateTime.now();
		LocalDateTime ans = null;
		
		
		
		if (exString.contentEquals("Today")) {
			ans=today;

		}

		else if (exString.contentEquals("Yesterday")) {
			ans = today.minusDays(-1);
		}

		else if (exString.contentEquals("day after tommorow")) {
			ans = today.plusDays(-2);
		}

		else if (exString.contentEquals("day before yesterday")) {
			ans = today.minusDays(-2);
		}

		else if (exString.contentEquals("Yesterday")) {
			ans = today.minusDays(-1);
		}

		else if (exString.contentEquals("LastMonth") || exString.contentEquals("PreviousMonth")) {
			ans = today.minusMonths(1);
			System.out.println(ans);
		} else if (exString.contentEquals("NextMonth")) {
			ans = today.plusMonths(1);

		}

		else if (exString.contentEquals("LastYear") || exString.contentEquals("PreviousMonth")) {
			ans = today.minusYears(1);
			System.out.println(ans);
		} else if (exString.contentEquals("NextMonth")) {
			ans = today.plusYears(1);

		}
		
		else if(exString.charAt(0)=='N') {
			if (exString.contains("days") && exString.contains("after")) {
				 ans = today.plusDays(n);
				
			} 
			
			else if (exString.contains("days") && exString.contains("before")) {
				 ans = today.minusDays(n);
					
			} 
			
			else if (exString.contains("months") && exString.contains("before")) {
				 ans = today.minusMonths(n);
					
			} 
			
			
			else if (exString.contains("days") && exString.contains("after")) {
				 ans = today.plusMonths(n);
					
			} 
			
			
		}
		

		return ans.toString();
	}
	

}

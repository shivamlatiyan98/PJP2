package calculator;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Scanner;

public class Display {
   public static Hashtable dHashtable;
	public Scanner sc;
   
	public static Hashtable start() {
		
		return dHashtable;
	}
	
	
	
	
	public Display() throws ParseException {
		dHashtable=new Hashtable();
		display();
		
	}




	public void display() throws ParseException {
		
    sc = new Scanner(System.in);
		int option;
System.out.println("Options: ");
System.out.println("1. option for addition and Subtraction of Dates");
System.out.println("2. option for addition of days/months/week to given date" );
System.out.println("3. option for finding the day of the  date");
System.out.println("4. option for finding  the week number for the given date");
System.out.println("5. Natural Langauage Processing Translation  option: ");
System.out.println("       n days from now, n months from now, n years from now,");
System.out.println("       n days earlier, n weeks earlier, n months earlier,");
System.out.println("       n years earlier");
System.out.println("     Tomorrow, Day-after-tomorrow,Today, yesterday,");
System.out.println("    Last week, Previous week, Day-before-yesterday");
System.out.println("       Next week, Next month, Next year, Last month,");
System.out.println("       Last year, Month after, Month before, n weeks from now,");
	
System.out.println("\n: enter the date in the given format dd/mm/yy");
System.out.println("\n Please select correct option for date calculator: ");
		
option = sc.nextInt();

switch (option) {
case 1:
	dHashtable.put("option", 1);
	dHashtable.put("data", option1());
	break;
case 2:
	dHashtable.put("option", 2);
	dHashtable.put("data", option2());
	break;
case 3:
	dHashtable.put("option", 3);
	dHashtable.put("data", option3());
	break;
case 4:
	dHashtable.put("option", 4);
	dHashtable.put("data", option4());
	break;
case 5:
	dHashtable.put("option", 5);
	
	
	break;
	
	
default:
	System.out.println("choose correct option");
	break;
}
   






		
	}
	
	
	private ArrayList<String> option1() {
		ArrayList<String> data = new ArrayList<String>();
		String date1;
		String date2;
		String operation;
		  
		System.out.println("\nEnter Date 1:");
		date1 = sc.next();
		data.add(date1);
		

		
		

		System.out.println("Enter Date 2: ");
		date2 = sc.next();
		data.add(date2);
		

		
		
		
		
		System.out.println("Enter the operation(+, -):");
		operation = sc.next();
		
		
		data.add(operation);

		return data;
	}
	
	private ArrayList option2() {
		sc = new Scanner(System.in);

		ArrayList data = new ArrayList();
		
		System.out.println("Enter unit to be added 1.days, 2.weeks, 3.months: ");
		String unit = sc.next();
		
//		if(unit!="days"&&unit!="weeks"&&unit!="months") {
//			System.out.println("enter correct option");
//		    System.exit(0);
//		}
//		
		System.out.println("enter n units for additon");
		System.out.println("if subtraction n should be negative");
		
		
		int n = sc.nextInt();
		
		System.out.println("Enter the date for addition and subtraction");
		String date=sc.next();
		
		data.add(unit);
		data.add(n);
		data.add(date);
		
		return data;
		
		
	}

	private String option3() throws ParseException{
		sc = new Scanner(System.in);
		System.out.println("enter the date");
		String date=sc.next();
		
	      Date sdate =  new SimpleDateFormat("dd/MM/yyyy").parse(date);

		Calendar c = Calendar.getInstance();
		c.setTime(sdate);

		String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thrusday", "Friday", "Saturday" };
         
		String anString = days[c.get(Calendar.DAY_OF_WEEK) - 1];
		
		return anString;
		
		
		
	}
	
	
	private String option4() throws ParseException {
		System.out.println("enter the date");
		String date=sc.next();
		
		Date sdate = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(date);
		
		Calendar c = Calendar.getInstance();
		c.setTime(sdate);
		
		int ans = c.get(Calendar.WEEK_OF_YEAR);
		String anString = String.valueOf(ans);
		
		
		return anString;
		
		
		
		
	}

	
	public boolean _check_date_format(String date) {
		boolean is_correct = true;
		SimpleDateFormat format=null;
		
		try {
			format.parse(date);
		}
		catch(ParseException e) {
			is_correct = false;
		}
		
		return is_correct;
	}
	
	
	
	
	


	

	


	

	
	
	
	

}

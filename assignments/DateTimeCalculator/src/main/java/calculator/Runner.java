package calculator;

import java.text.ParseException;
import java.util.Hashtable;
import java.util.Iterator;


public class Runner {

	
		
		public static void main(String[] args) throws ParseException {
		
		
		Display display=new Display();
		Hashtable data=display.start();
		
		Functionality fp=new Functionality(data);
		String anString=null;
		

				anString=fp.execute();
		if(anString!=null)
		System.out.println(anString);
		//System.out.println("sucess");
		
		
	}
}

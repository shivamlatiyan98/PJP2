package com.SalaryCalculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.opencsv.CSVWriter;




public class SalaryCalculatorIo {
	
	public static final String path="output.csv";

	public List<Record> read(File file) throws IOException {
		List<Record>saList=new ArrayList<Record>();
		
		BufferedReader bReader;
		
		bReader=new BufferedReader(new FileReader(file));
		
		String buString="";
		int i=0;
		
		while(bReader.readLine()!=null) {
			i++;
			if(i==1) {
				continue;
			}
			String [] row=null;
			buString=bReader.readLine();
			if(buString!=null) {
			
			row=buString.split(",");
			
			}
			
			if(row!=null) {
           Record cuRecord=new Record();
           
           cuRecord.setCity(row[0]);
           cuRecord.setCountry(row[1]);
           cuRecord.setGender(row[2].charAt(0));
           cuRecord.setCurrency(row[3]);
           cuRecord.setIncome(Double.parseDouble(row[4]));
           
           
           
           saList.add(cuRecord);
			}
           

		
		
		}
		
		
		
		return saList;
	}

	
	
	
	
	
	public File write(List<LocationGroup> list) throws IOException {
		File file = new File(path);
		DecimalFormat df = new DecimalFormat("#.00"); 
		
		
		
		list.sort(new Compare());
		System.out.println("hello");
		
		
		try (CSVWriter csvWriter = new CSVWriter(new FileWriter(file))) {
			
			
			csvWriter.writeNext(new String [] {"Country/City", "Gender", "Average Income(in USD)"});
			
			for(LocationGroup lgGroup: list) {
				String [] row = new String[3];
				row[0]=lgGroup.getName();
				row[1]= Character.toString(lgGroup.getGender());
				row[2]=df.format(lgGroup.getAvgIncome()/lgGroup.getCount());
				System.out.println("row"+row[0]+" "+row[1]+row[2]);
				csvWriter.writeNext(row);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
		
		
	}
	
	class Compare implements Comparator<LocationGroup> 
	{ 
	    
	    public int compare(LocationGroup a, LocationGroup b) 
	    { if(!a.getName().equals(b.getName()))
			return a.getName().compareTo(b.getName());
		else
			return Character.compare(a.getGender(), b.getGender());
	       
	    } 
	} 
	
	
	public static void comapare() {
		
	}
	
	
	
	

}

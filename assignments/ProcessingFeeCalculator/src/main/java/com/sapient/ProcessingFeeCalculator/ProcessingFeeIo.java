package com.sapient.ProcessingFeeCalculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


import com.opencsv.CSVWriter;




public class ProcessingFeeIo {
	
	private static String DATE_FORMAT = "mm/dd/yyyy";
	private static String FILE = "transaction_report.csv";
	
	public List<Record> read(File file) throws IOException, ParseException {
		List<Record>TaList=new ArrayList<Record>();
		
		BufferedReader bReader;
		
		bReader=new BufferedReader(new FileReader(file));
		
		String buString;
		int i=0;
		
		while((buString= bReader.readLine())!=null) {
			i++;
			if(i==1) {
				continue;
			}
			String [] row=buString.split(",");
			
			
		String datesString="mm/dd/yyyy";
			
			if(row!=null) {
           Record cuRecord=new Record();
           cuRecord.setTransactionId(row[0]);
           cuRecord.setClientId(row[1]);
           cuRecord.setSecurityId(row[2]);
           cuRecord.setTransactionType(row[3]);
           cuRecord.setTransactionDate(new SimpleDateFormat(datesString)
					.parse(row[4]));
           cuRecord.setMarketValue(Double.parseDouble(row[5]));
           cuRecord.setPriorityFlag(row[6]);
          
           
           
           TaList.add(cuRecord);
			}
           

		
		
		}
		
		
		
		return  TaList; 
	}

	
	

	public File write(List<Record> taupdList) throws IOException {
		File file = new File(FILE);
		   
		taupdList.sort(new Compare());
		
		
		
		try (CSVWriter csvWriter = new CSVWriter(new FileWriter(file))) {
			
		
			String [] list = {"Client ID", "TransactionType", "Transaction Date",
					"Priority Flag", "Amount"};
			csvWriter.writeNext(list);
		
			
			for (Record record : taupdList) {
				String [] row = new String[5];
				row[0] = record.getClientId(); 
				row[1] = record.getTransactionType(); 
				row[2] = record.DateToSTring(); 
				row[3] = record.getPriorityFlag();
				row[4] = Double.toString(record.getAmount());
				csvWriter.writeNext(row);
			}
			
		
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return file;
	}
	
	
	class Compare implements Comparator<Record> 
	{ 
	    
	    public int compare(Record a, Record b) {
	    	if(!a.getClientId().equals(b.getClientId())) {
				return a.getClientId().compareTo(b.getClientId());
				
				
	    	}
			else if(!a.getTransactionType().equals(b.getTransactionType())) {
				return a.getTransactionType().compareTo(b.getTransactionType());
				
			}
			else if(!a.getTransactionDate().equals(b.getTransactionDate())) {
				return a.getTransactionDate().compareTo(b.getTransactionDate());
				
			}
			else 
				return a.getPriorityFlag().compareTo(b.getPriorityFlag()); 
			
				
	    	
	    }
	    
	    
	    
	    
	} 
	

	

}

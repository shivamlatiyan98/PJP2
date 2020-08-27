package com.sapient.ProcessingFeeCalculator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sapient.TransactionFeeCalculator.TransactionAttribute;




public class Process {
	private static final int IntradayFee  = 10;
	private static final int add50 = 50;
	private static final int add100 = 100;
	private static final int add500 = 500;
	private static final String Priority = "Y";
	
	public final Map<String, List<Record>> buy;
	public final Map<String, List<Record>> sell;
	
	
	
   public Process() {
	this.buy=new HashMap<String, List<Record>>();
	this.sell=new HashMap<String, List<Record>>();
	
	
	
	   
}
	
	

	public List<Record> calculate(List<Record> taList) {
		
		for(Record record : taList) {
			if(record.getTransactionType().equals("WITHDRAW") || record.getTransactionType().equals("DEPOSIT")) 
				setNominalValue(record);
			
			
			else if(record.getTransactionType().equals("BUY")) {
				if(check(record, sell)) 
					continue;
				
				List<Record> temp = buy.getOrDefault(record.getKey(), new ArrayList<>());
				temp.add(record);
				
				if(!buy.containsKey(record.getKey()))
					buy.put(record.getKey(), temp);
			} else {
				
				if(check(record, buy)) 
					continue;
				List<Record> temp = sell.getOrDefault(record.getKey(), new ArrayList<>());
				temp.add(record);
				
				if(!sell.containsKey(record.getKey()))
					sell.put(record.getKey(), temp);
			}
			
			
		}
				
		Next(buy);
		Next(sell);
			
			
			
		
		
		
		
		
		
		return null;
	}



	private void Next(Map<String, List<Record>> map) {
		for (String key : map.keySet()) {
			map.get(key).forEach(this::setNominalValue);
		}
		
		
	}



	private boolean check(Record record, Map<String, List<Record>> map) {
	
		if(map.containsKey(record.getKey())) {
			Record temp = map.get(record.getKey()).remove(0);
			if(map.get(record.getKey()).isEmpty())
				map.remove(record.getKey());
			temp.setAmount(IntradayFee);
			record.setAmount(IntradayFee);
			setNominalValue(temp);
			setNominalValue(record);
		}
		
		
		return false;
	}



	private void setNominalValue(Record record) {

		
   if(record.getPriorityFlag().equals(Priority)) {
	   record.setAmount(add500+record.getAmount());
	   
	   
   }
   
   else  if(record.getTransactionType().equals("SELL")||record.getTransactionType().equals("WITHDRAW")) {
	   record.setAmount(add100+record.getAmount());
	   
	   
   }
   
   else    record.setAmount(add50+record.getAmount());
	   
	   
   }
   
   
   
   


	}

	
	
	



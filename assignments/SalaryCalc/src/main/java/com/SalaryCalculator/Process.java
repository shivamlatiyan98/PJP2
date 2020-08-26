package com.SalaryCalculator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Process {
	
	private static Map<String, LocationGroup> map;
	public static Map<String,Double> cmap;
	
	Process(){
		
		map = new HashMap<>();
		cmap = new HashMap<>();
		
		cmap.put("INR", 66.00);
		cmap.put("GBP", 0.67);
		cmap.put("SGP", 1.5);
		cmap.put("HKD", 8.0);
		cmap.put("USD", 1.0);
		
		
		
		
	}
	
	
	
	

	public List<LocationGroup> execute(List<Record>saList) {
		
		String nameCounString=null;
		for(Record record : saList) {
			if(record.country.length()>0) {
				nameCounString=record.getCountry();
				
			}
			else if(record.country.length()==0){
			nameCounString=record.getCity();
			}
			
			String keyString=nameCounString+"#"+record.getGender();
			LocationGroup locationGroup=null;

			locationGroup=map.getOrDefault(keyString, new LocationGroup());
			locationGroup.increment();
			double avgIncome= 0.0;
			
			
			
			locationGroup.setAvgIncome(convert(record));
			
			if(!map.containsKey(keyString)) {
			locationGroup.setName(nameCounString);	
			locationGroup.setGender(record.getGender());
			
			map.put(keyString, locationGroup);
			
			}
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		return  new ArrayList<LocationGroup>(map.values());
	}

	
	private double convert(Record r) {
		double income = r.getIncome();
		income /= cmap.get(r.getCurrency());
		return income;
	}
	
	
	
	
}

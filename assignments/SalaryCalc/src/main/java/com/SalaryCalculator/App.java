package com.SalaryCalculator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;


public class App {
   public static final String FILE = "sample_input.csv";
   public static final String path="output.csv";
	public static void main(String[] args) throws IOException {
		 
		
		SalaryCalculatorIo salaryCalculatorIo=new SalaryCalculatorIo();
		List<Record>salaryList=salaryCalculatorIo.read(Path.of(FILE).toFile());
		
		for(Record r: salaryList)
		{
			System.out.println(r.toString());
		}
		
		Process process=new Process();
		
		List<LocationGroup>list=process.execute(salaryList);
		salaryCalculatorIo.write(list);
		
		
		
	        
		
		
	}

}

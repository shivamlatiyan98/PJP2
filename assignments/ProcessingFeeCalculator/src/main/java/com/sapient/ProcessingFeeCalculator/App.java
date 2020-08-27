package com.sapient.ProcessingFeeCalculator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.List;





/**
 * Hello world!
 *
 */



public class App 
{
	
	public static final String FILE = "Transactions1.csv";
    public static void main( String[] args ) throws IOException, ParseException
    {
    	
		
		
		
		
		ProcessingFeeIo processingFeeIo=new ProcessingFeeIo();
		List<Record>taList=processingFeeIo.read(Path.of(FILE).toFile());
		Process process=new Process();
		process.calculate(taList);
		
		for(Record record : taList) {
			System.out.println(record.toString());
		}
		
		processingFeeIo.write(taList);
    	System.out.println("completed");
		
    	
    }
}

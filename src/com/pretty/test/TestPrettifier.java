package com.pretty.test;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;

import com.pretty.*;

import java.util.*;

/**
 * The TestPrettyFormatter class tests the results of PrettyFormatter class. 
 * 
 * @author Atahan Ozer
 * @version 1.0
 */
public class TestPrettifier {

	@Test
	public void testPositive() {
		//LinkedHashMap is used to maintain the order of elements in map. 
		LinkedHashMap<String,String> map = new LinkedHashMap<String,String>();
		
		map.put("0", "0");
		map.put("10", "10");
		map.put("1000", "1000");
		map.put("10000", "10000");
		map.put("100000", "100000");
		map.put("1,000,000", "1M");
		map.put("1.08E2", "1.08E2");
		map.put("1000000", "1M");
		map.put("2500000.34", "2.5M");
		map.put("532", "532");
		map.put("1123456789", "1.1B");
		map.put("football", "football doesn't look like a number. Try something like 789 or 4560000.08 or 100,000,000");

		System.out.println("Testing positivie examples..");
		
		for(Iterator<String> it = map.keySet().iterator(); it.hasNext(); )
		{
			String key = it.next();
			String expectedValue = map.get(key);
			String actualValue = new PrettifyFormatter(key).getFormattedValue();

			if(!expectedValue.equals(actualValue)){
				fail("Unexpected result: " + key + " != " + expectedValue);				
			}else{
				System.out.println(key + " equals " + expectedValue);	
			}

		}
		System.out.println();

	}

	@Test
	public void testNegative(){

		LinkedHashMap<String,String> map = new LinkedHashMap<String,String>();
		map.put("-1000", "-1000");
		map.put("-10000", "-10000");
		map.put("-100000", "-100000");
		map.put("-1,000,000", "-1M");
		
		System.out.println("Testing negative examples..");
		
		for(Iterator<String> it = map.keySet().iterator(); it.hasNext(); )
		{
			String key = it.next();
			String expectedValue = map.get(key);
			String actualValue = new PrettifyFormatter(key).getFormattedValue();

			if(!expectedValue.equals(actualValue)){
				fail("Unexpected result: " + key + " != " + expectedValue);				
			}else{
				System.out.println(key + " equals " + expectedValue);	
			}

		}
		
		System.out.println();

	}

	@Test
	public void testBig(){
		LinkedHashMap<String,String> map = new LinkedHashMap<String,String>();

		map.put("1,000,000,000,000", "1T");
		map.put("10,000,000,000,000", "10T");
		map.put("100,000,000,000,000", "100T");
		map.put("1,000,000,000,000,000", "1,000T");

		System.out.println("Testing big examples..");

		for(Iterator<String> it = map.keySet().iterator(); it.hasNext(); )
		{
			String key = it.next();
			String expectedValue = map.get(key);
			String actualValue = new PrettifyFormatter(key).getFormattedValue();

			if(!expectedValue.equals(actualValue)){
				fail("Unexpected result: " + key + " != " + expectedValue);				
			}else{
				System.out.println(key + " equals " + expectedValue);	
			}

		}
		System.out.println();
	}

}

package com.pretty;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * PrettyFormatter class accepts a numeric type and returns a truncated, 
 * "prettified" string version. The prettified version includes one number after the
 * decimal when the truncated number is not an integer. It prettifies numbers greater
 * than 6 digits and supports millions, billions and trillions.

 * @author Atahan Ozer
 * @version 1.0
 */
public class PrettifyFormatter {

	// to be appended to the number to make it prettified
	private static String[] suffixes = new String[] { "M", "B", "T" };
	private String value;

	public PrettifyFormatter(String value){
		this.value = value;
	}

	/**
	 * Returns a prettified string 
	 * 
	 * @param String value - a String representing a number to be prettified.
	 * @return a String - the prettified number.
	 */
	public String getFormattedValue() {

		Locale locale = Locale.getDefault();
		NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
		DecimalFormat prettyDecimalFormat = (DecimalFormat) numberFormat;
		prettyDecimalFormat.applyLocalizedPattern("#,##0.#");


		try{
			double d = numberFormat.parse(value).doubleValue();

			//"It should prettify numbers greater than 6 digits"
			// Return the value unchanged when number is less than 1000000
			if(Math.abs(d) < 1000000) {
				return value;
			}

			String formattedNumber = format(d, prettyDecimalFormat);
			return formattedNumber;

		}catch (ParseException pe) {
			return value + " doesn't look like a number. Try something like 789 or 4560000.08 or 100,000,000";
		}
	}

	/**
	 * Returns a string representing a number with the appropriate suffix
	 * 
	 * @param number
	 * @param decimalFormat
	 * @return String formatted with decimalFormat provided
	 */
	private static String format(double number, DecimalFormat decimalFormat) {

		for (int i = suffixes.length; i > 0; i--) {
			double unit = Math.pow(1000, i+1);

			if (Math.abs(number) >= unit) {
				return decimalFormat.format(number / unit) + suffixes[--i];
			}
		}
		return decimalFormat.format(number);
	}
}

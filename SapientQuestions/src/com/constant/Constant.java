/**
 * 
 */
package com.constant;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.exceptions.ReadPropertyDataException;

/**
 * @author khushbuk
 *
 */

public class Constant {
	public static final String outDataPathCSV = "outData.csv";
	public static final String CSV_SPLIT_BY = "||";

	

	public enum FILETYPE {
		CSV("CSV"), XML("XML"), TEXT("TXT");
		String ext;

		private FILETYPE(String ext) {
			this.ext = ext;
		}

		/**
		 * @return the path
		 */
		public String getType() {
			return ext;
		}
	}

	public static double getExchangeRate(String amountStr, String currency) throws ReadPropertyDataException {
		Double amount = Double.valueOf(amountStr);
		Double exchangeRate = 0.00;
		switch (currency) {
		case "INR":
			exchangeRate = 68.89;
			break;
		case "HKD":
			exchangeRate = 8.77;
			break;
		case "SGP":
			exchangeRate = 50.48;
			break;
		case "USD":
			exchangeRate = 1.00;
			break;
		case "GBP":
			exchangeRate = 89.66;
			break;
		}
		BigDecimal bd = new BigDecimal(amount / exchangeRate);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		return bd.doubleValue();

	}

}

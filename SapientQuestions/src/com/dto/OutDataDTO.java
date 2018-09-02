package com.dto;

import java.util.Comparator;

/**
 * @author khushbuk
 *
 */
public class OutDataDTO   implements Comparator<OutDataDTO>{
	private String cityOrCountry;
	private String gender;
	private String averageIncome;
	/**
	 * @return the cityOrCountry
	 */
	public String getCityOrCountry() {
		return cityOrCountry;
	}
	/**
	 * @param cityOrCountry the cityOrCountry to set
	 */
	public void setCityOrCountry(String cityOrCountry) {
		this.cityOrCountry = cityOrCountry;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the averageIncome
	 */
	public String getAverageIncome() {
		return averageIncome;
	}
	/**
	 * @param averageIncome the averageIncome to set
	 */
	public void setAverageIncome(String averageIncome) {
		this.averageIncome = averageIncome;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OutDataDTO [cityOrCountry=" + cityOrCountry + ", gender=" + gender + ", averageIncome=" + averageIncome
				+ "]";
	}
	@Override
	public int compare(OutDataDTO obj1, OutDataDTO obj2) {
		return obj1.getCityOrCountry().compareTo(obj2.getCityOrCountry()) ;
	
	}
	
	
}

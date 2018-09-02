package com.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author khushbuk
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class InDataDTO {
	 @XmlElement(name = "city")
	private String city;
	 @XmlElement(name = "country")
	private String country;
	 @XmlElement(name = "gender")
	private String gender;
	 @XmlElement(name = "currency")
	private String currency;
	 @XmlElement(name = "averageincome")
	private String averageIncome;
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
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
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
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
		return "InDataDTO [city=" + city + ", country=" + country + ", gender=" + gender + ", currency=" + currency
				+ ", averageIncome=" + averageIncome + "]";
	}
	
	

}

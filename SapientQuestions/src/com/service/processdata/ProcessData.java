/**
 * 
 */
package com.service.processdata;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.constant.Constant;
import com.dto.InDataDTO;
import com.dto.OutDataDTO;
import com.exceptions.ReadPropertyDataException;

/**
 * @author khushbuk
 *
 */
public class ProcessData {

	/**
	 * 
	 */
	List<OutDataDTO> outList;
	OutDataDTO outDataDTO;
	public static final String DECIMAL_FORMATER ="##.00";
	public static final String SAPARATOR ="#";

	public List<OutDataDTO> ProcessDataOut(List<InDataDTO> inList) throws ReadPropertyDataException {
		Map<String, Double> temp1 = new LinkedHashMap<>();
		Map<String, Integer> temp2 = new LinkedHashMap<>();
		List<OutDataDTO> outList = new LinkedList<>();
		DecimalFormat formater = new DecimalFormat(DECIMAL_FORMATER);
		for (InDataDTO inDataDTO : inList) {
			String city = inDataDTO.getCity();
			String country = inDataDTO.getCountry();
			String gender = inDataDTO.getGender();
			String currency = inDataDTO.getCurrency();
			String amount = inDataDTO.getAverageIncome();

			double changesamount = Constant.getExchangeRate(amount, currency);

			if ((country.equals("") || country == null || country.equals(" ") )&& !temp1.containsKey(city + SAPARATOR + gender)) {
				temp1.put(city + SAPARATOR + gender, changesamount);
				temp2.put(city + SAPARATOR + gender, 1);
			} else if ((country.equals("") || country == null || country.equals(" "))&& temp1.containsKey(city + SAPARATOR + gender)) {
				temp1.put(city + SAPARATOR + gender, temp1.get(city + SAPARATOR + gender) + changesamount);
				temp2.put(city + SAPARATOR + gender, temp2.get(city + SAPARATOR + gender) + 1);
			} else if (!(country.equals("") || country == null || country.equals(" ") ) && !temp1.containsKey(country + SAPARATOR + gender)) {
				temp1.put(country + SAPARATOR + gender, changesamount);
				temp2.put(country + SAPARATOR + gender, 1);
			} else if (!(country.equals("") || country == null || country.equals(" ")) && temp1.containsKey(country + SAPARATOR + gender)) {
				temp1.put(country + SAPARATOR + gender, temp1.get(country + SAPARATOR + gender) + changesamount);
				temp2.put(country + SAPARATOR + gender, temp2.get(country + SAPARATOR + gender) + 1);
			}
		}
		System.out.println(temp1);
		System.out.println(temp2);

		for (String s : temp1.keySet()) {
			outDataDTO = new OutDataDTO();
			double val = temp1.get(s);
			int count = temp2.get(s);
			outDataDTO.setCityOrCountry(s.split(SAPARATOR)[0]);
			outDataDTO.setGender(s.split(SAPARATOR)[1]);
			double avg = val / count;
			outDataDTO.setAverageIncome(formater.format(avg));
			outList.add(outDataDTO);
		}
		Collections.sort(outList,new OutDataDTO());
		System.out.println(outList);
		return outList;

	}

}

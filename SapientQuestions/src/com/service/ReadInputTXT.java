package com.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import com.constant.Constant;
import com.dto.FileInfoDTO;
import com.dto.InDataDTO;
import com.exceptions.ReadPropertyDataException;
import com.exceptions.ReadTxtDataException;
/**
 * @author khushbuk
 *
 */
public class ReadInputTXT implements ReadInput {




	
	@Override
	public List<InDataDTO> readDataFromFile(FileInfoDTO fileInfoDTO) throws ReadPropertyDataException, ReadTxtDataException {
		List<InDataDTO> inList = new LinkedList<>();
		InDataDTO inDataDTO;
		int firstLine = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(new File(fileInfoDTO.getLocation())))) {
			String line = "";
			while ((line = br.readLine()) != null) {
				inDataDTO= new InDataDTO();

				if (firstLine == 0) {
					firstLine = 1;
					continue;
				}
				StringTokenizer st = new StringTokenizer(line, Constant.CSV_SPLIT_BY);
				int myIndex = 0;
				while (st.hasMoreElements()) {
					String data = (String) st.nextElement();
					SetData(data, myIndex, inDataDTO);
					myIndex++;
				}
				inList.add(inDataDTO);
			}

		} catch (IOException e) {
			e.printStackTrace();
			 throw new ReadTxtDataException("Getting Error while loading txt file");
		}
		System.out.println(inList);
		return inList;
	}
	private static void SetData(String data, int myIndex, InDataDTO inDataDTO) {

		switch (myIndex) {
		case 0:
			inDataDTO.setCity(data);
			break;
		case 1:
			inDataDTO.setCountry(data);
			break;
		case 2:
			inDataDTO.setGender(data);
			break;
		case 3:
			inDataDTO.setCurrency(data);
			break;
		case 4:
			inDataDTO.setAverageIncome(data);
			break;
		}
	}
}
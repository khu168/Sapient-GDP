package com.service;

import java.util.List;

import com.dto.FileInfoDTO;
import com.dto.InDataDTO;
import com.exceptions.ReadExcelDataException;
import com.exceptions.ReadPropertyDataException;
import com.exceptions.ReadTxtDataException;
import com.exceptions.ReadXMLDataException;

public interface ReadInput {
	public List<InDataDTO> readDataFromFile(FileInfoDTO fileInfoDTO) throws ReadExcelDataException, ReadPropertyDataException, ReadTxtDataException, ReadXMLDataException;

}

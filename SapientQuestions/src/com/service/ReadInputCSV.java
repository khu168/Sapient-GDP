/**
 * 
 */
package com.service;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.dto.FileInfoDTO;
import com.dto.InDataDTO;
import com.exceptions.ReadExcelDataException;

/**
 * @author khushbuk
 *
 */
public class ReadInputCSV implements ReadInput {

	/**
	 * 
	 */

	@Override
	public List<InDataDTO> readDataFromFile(FileInfoDTO fileInfoDTO) throws ReadExcelDataException {
		List<InDataDTO> inList = new LinkedList<>();
		InDataDTO inDataDTO;
		try(Workbook workbook = WorkbookFactory.create(new File(fileInfoDTO.getLocation()))){
			Sheet sheet = workbook.getSheetAt(0);
			DataFormatter dataFormatter = new DataFormatter();
			Iterator<Row> rowIterator = sheet.rowIterator();
			rowIterator.next();// omitting header value
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				inDataDTO = new InDataDTO();

				Cell cell1 = row.getCell(0);
				Cell cell2 = row.getCell(1);
				Cell cell3 = row.getCell(2);
				Cell cell4 = row.getCell(3);
				Cell cell5 = row.getCell(4);

				inDataDTO.setCity(dataFormatter.formatCellValue(cell1));
				inDataDTO.setCountry(dataFormatter.formatCellValue(cell2));
				inDataDTO.setGender(dataFormatter.formatCellValue(cell3));
				inDataDTO.setCurrency(dataFormatter.formatCellValue(cell4));
				inDataDTO.setAverageIncome(dataFormatter.formatCellValue(cell5));
				inList.add(inDataDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ReadExcelDataException("Getting Error while loading Excel file");

		}

		return inList;

	}

}

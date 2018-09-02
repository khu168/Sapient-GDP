/**
 * 
 */
package com.service.processdata;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import com.constant.Constant;
import com.dto.OutDataDTO;
import com.exceptions.ReadPropertyDataException;
import com.exceptions.WriteExcelDataException;

/**
 * @author khushbuk
 *
 */
public class WriteDataCSV {

	public void WriteDatainCSV(List<OutDataDTO> outList) throws WriteExcelDataException, ReadPropertyDataException {
		
		String filename = Constant.outDataPathCSV;
		try {
			
			SXSSFWorkbook workbook = new SXSSFWorkbook();
			SXSSFSheet sheet = workbook.createSheet("FirstSheet");
			int count=1;
			Row row = sheet.createRow(0);
			Cell cell = row.createCell(0);
			cell.setCellValue("City/Country");
			Cell cell1 = row.createCell(1);
			cell1.setCellValue("Gender");
			Cell cell2 = row.createCell(2);
			cell2.setCellValue("Average Income");
			for(OutDataDTO outDataDTO:outList) {
				 row = sheet.createRow(count++);
				 cell = row.createCell(0);
				cell.setCellValue(outDataDTO.getCityOrCountry());
				cell1 = row.createCell(1);
				cell1.setCellValue(outDataDTO.getGender());
				cell2 = row.createCell(2);
				cell2.setCellValue(outDataDTO.getAverageIncome());
			}
			FileOutputStream outputStream = new FileOutputStream(filename) ;
	            workbook.write(outputStream);
	            outputStream.close();
	            workbook.close();
			
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
			throw new WriteExcelDataException("Getting Error while Writing Excel file");
		}
		
	}


}

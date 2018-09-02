/**
 * 
 */
package com.main.entry;

import java.util.List;
import java.util.Scanner;

import com.constant.Constant;
import com.dto.FileInfoDTO;
import com.dto.InDataDTO;
import com.dto.OutDataDTO;
import com.exceptions.GetFileLocationException;
import com.exceptions.ReadExcelDataException;
import com.exceptions.ReadPropertyDataException;
import com.exceptions.ReadTxtDataException;
import com.exceptions.ReadXMLDataException;
import com.exceptions.WriteExcelDataException;
import com.service.ReadInput;
import com.service.ReadInputFactory;
import com.service.processdata.ProcessData;
import com.service.processdata.WriteDataCSV;

/**
 * @author khushbuk
 *
 */
public class EntryPoint {

	/**
	 * Main method to start the program
	 * @param args
	 */

	public static void main(String[] args) {
		ReadInput readInput;
		ReadInputFactory readInputFactory;
		List<InDataDTO> inList;
		List<OutDataDTO> outList;
		ProcessData processData;
		WriteDataCSV writeDataCSV;
		FileInfoDTO fileInfoDTO = null;
		System.out.println("Starting The project");
		readInputFactory = ReadInputFactory.instantiateObject();
		processData = new ProcessData();
		writeDataCSV = new WriteDataCSV();
		try {
			fileInfoDTO = getInput();
			readInput = readInputFactory.readInputFactoryExposer(fileInfoDTO.getExt());
			System.out.println(fileInfoDTO.toString());
			inList = readInput.readDataFromFile(fileInfoDTO);
			outList = processData.ProcessDataOut(inList);
			writeDataCSV.WriteDatainCSV(outList);
			System.out.println("File Generated with Name :"+Constant.outDataPathCSV);
		} catch (ReadExcelDataException | ReadPropertyDataException | WriteExcelDataException | ReadTxtDataException
				| ReadXMLDataException | GetFileLocationException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	private static FileInfoDTO getInput() throws GetFileLocationException {
		String fileloc;
		FileInfoDTO fileInfoDTO = new FileInfoDTO();
		
			
			try(Scanner scanner = new Scanner(System.in)){
			System.out.println("Please enter the file loc");
			fileloc = scanner.nextLine();
			if (fileloc != null) {
				fileInfoDTO.setExt(fileloc.substring(fileloc.lastIndexOf(".")+1));
				fileInfoDTO.setLocation(fileloc);
			}
		} catch (Exception exc) {
		
			throw new GetFileLocationException("Please enter the file location in proper format");
		}
		return fileInfoDTO;
	}

}

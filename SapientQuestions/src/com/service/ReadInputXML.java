/**
 * 
 */
package com.service;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.dto.FileInfoDTO;
import com.dto.InDataDTO;
import com.dto.RootDTO;
import com.exceptions.ReadXMLDataException;

/**
 * @author khushbuk
 *
 */
public class ReadInputXML implements ReadInput {


	@Override
	public List<InDataDTO> readDataFromFile(FileInfoDTO fileInfoDTO) throws ReadXMLDataException {
		try{ JAXBContext context = JAXBContext.newInstance(new Class[] {RootDTO.class,InDataDTO.class});
        Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
        RootDTO rootData = (RootDTO) jaxbUnmarshaller.unmarshal(new File(fileInfoDTO.getLocation()));
			System.out.println(rootData.getList().toString());
        return rootData.getList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ReadXMLDataException("Getting Error while loading xml file");

		}
		
	}

}

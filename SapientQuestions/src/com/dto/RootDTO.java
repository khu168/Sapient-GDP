/**
 * 
 */
package com.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author khushbuk
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
public class RootDTO {
	 @XmlElement(name = "InDataDTO")
 private List<InDataDTO> list ;

public List<InDataDTO> getList() {
	return list;
}

public void setL(List<InDataDTO> list) {
	this.list = list;
}

@Override
public String toString() {
	return "RootDTO [list=" + list + "]";
}


 
}

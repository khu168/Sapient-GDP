/**
 * 
 */
package com.dto;

/**
 * @author khushbuk
 *
 */
public class FileInfoDTO {
	String Location;
	String ext;
	/**
	 * @return the location
	 */
	public String getLocation() {
		return Location;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FileInfoDTO [Location=" + Location + ", ext=" + ext + "]";
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		Location = location;
	}
	/**
	 * @return the ext
	 */
	public String getExt() {
		return ext;
	}
	/**
	 * @param ext the ext to set
	 */
	public void setExt(String ext) {
		this.ext = ext;
	}
	
	

}

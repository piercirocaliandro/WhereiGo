package logic.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RentAccomodationBean {
	
	private long id;
	private String beds;
	private String renter;
	private String city;
	private String address;
	private String type;
	private String squareMetres;
	private String description;
	private File houseImage;
	private byte[] services;
	private byte[] inputF;
	protected Logger logger = Logger.getLogger("WIG");
	
	
	public void setBeds(String numBeds) {
		this.beds= numBeds;	
	}
	
	public void setRenter(String renter) {
		this.renter = renter;
	}
	
	public String getRenter() {
		return this.renter;
	}
	
	public void setID(long l) {
		this.id = l;
	}

	public String getBeds() {
		return this.beds;	
	}

	public String getCity() {
		return city;
	}

	public void setCity(String citta) {
		this.city = citta;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String indirizzo) {
		this.address = indirizzo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSquareMetres() {
		return squareMetres;
	}

	public void setSquareMetres(String squareMetres) {
		this.squareMetres = squareMetres;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public InputStream getInputFile() {
		InputStream imageInputFile = null;
		if (houseImage != null) {
			try {
				imageInputFile = new FileInputStream(houseImage);
			} catch (FileNotFoundException e) {
				logger.log(Level.SEVERE, e.getMessage());
			}
		}
		return imageInputFile;
	}

	public long getFileLength() {
		long len = 0;
		if (houseImage != null) {
			len = houseImage.length();
		}
		return len;
	}
	
	public void setHouseImage(File houseImage) {
		this.houseImage = houseImage;
	}
	
	public byte[] getServices() {
		return services;
	}

	public void setServices(byte[] listOfServices) {
		this.services = new byte[4];
		this.services = listOfServices;
	}

	public long getID() {
		return id;
	}
	
	public void setInputStream(byte[] inputS) {
		this.inputF = inputS;
	}

	public byte[] getHouseImage() {
		return inputF;
	}
}
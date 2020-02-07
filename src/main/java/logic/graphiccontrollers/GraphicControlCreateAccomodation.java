package logic.graphiccontrollers;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import logic.beans.RentAccomodationBean;
import logic.controllers.RentAccomodationController;
import logic.view.Window;

public class GraphicControlCreateAccomodation extends Window{
	
	private RentAccomodationController control;
	
	ObservableList<String> typeList = FXCollections.observableArrayList("appartamento", "villetta", "monolocale");
	ObservableList<String> squareList = FXCollections.observableArrayList("<20", "20 to 39", "40 to 59", ">60");
	ObservableList<String> beds = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", ">8");
	
	@FXML private ChoiceBox<String> numberBeds;
	@FXML private Button saveInfo;
	@FXML private TextField description;
	@FXML private TextField city;
	@FXML private TextField address;
	@FXML private CheckBox bathroom;
	@FXML private CheckBox kitchen;
	@FXML private CheckBox wifi;
	@FXML private CheckBox garden;
	@FXML private ChoiceBox<String> squareMetres;
	@FXML private ChoiceBox<String> type;
	@FXML private ImageView imageView;
	@FXML private Button openButton;
	
	@FXML
	private void initialize() {
		type.setValue("appartamento");
		type.setItems(typeList);
		squareMetres.setValue("<20");
		squareMetres.setItems(squareList);
		numberBeds.setValue("1");	
		numberBeds.setItems(beds);
		garden.setSelected(false);
		wifi.setSelected(false);
		bathroom.setSelected(false);
		kitchen.setSelected(false);
	}
	
	private RentAccomodationBean bean;
	private int[] listOfServices;
	private Desktop desktop = Desktop.getDesktop();
	
	public static void main(String[] args) {
		setScene("InfoAccomodation.fxml");
		launch(args);
	}
	
	public GraphicControlCreateAccomodation() {
		control = new RentAccomodationController();
		bean = new RentAccomodationBean();
	}

	public void applyInfo() {
		//bean.setHouseImage(image);
		listOfServices = new int[4];
		if (garden.isSelected()) {
			listOfServices[0] = 1;
		}
		else { 
			listOfServices[0] = 0;
		}
		if (wifi.isSelected()) {
			listOfServices[1] = 1;
		}
		else { 
			listOfServices[1] = 0;
		}
		if (bathroom.isSelected()) {
			listOfServices[2] = 1;
		}
		else { 
			listOfServices[2] = 0;
		}
		if (kitchen.isSelected()) {
			listOfServices[3] = 1;
		}
		else { 
			listOfServices[3] = 0;
		}
		bean.setServices(listOfServices);
		bean.setCity(city.getText());
		bean.setAddress(address.getText());
		bean.setDescription(description.getText());
		control.createAccomodation(bean);
	}
    
    public void insertImage() {
    	FileChooser fileChooser = new FileChooser();
    	//Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
        }
    }
}

/* should @Override the initialize method*/
package logic.graphiccontrollers;

import java.awt.image.BufferedImage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import logic.ImageViewer;
import logic.beans.LocationBean;
import logic.view.TravelerGui;

public class GraphicControllerLocationInfo extends TravelerGui{
	@FXML private ImageViewer imageView;
	@FXML private Text cityName;
	@FXML private Text cityCountry;
	@FXML private Text description;
	@FXML private ImageView locImm;
	@FXML private Button backButton;
	
	public void setInfo(LocationBean bean) {
		BufferedImage bufImage;
		this.imageView = new ImageViewer();
		bufImage = imageView.loadImage(bean.getStream());
		locImm.setImage(imageView.convertToFxImage(bufImage));
		this.cityName.setText(bean.getCityName());
		this.cityCountry.setText(bean.getCountryName());
		this.description.setText(bean.getDescription());
	}
	
	public void backTrav(MouseEvent e) {
		goBookTravel(e);
	}
}

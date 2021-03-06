package manager.GUIController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import manager.controller.SceneLoadController;
import manager.model.Car;
import manager.model.GameController;
import manager.model.Profile;

public class TeamManagementController extends SceneLoadController implements Initializable
{
	// Background
	@FXML
	private AnchorPane	root;
	@FXML
	private ImageView	background, back;
	@FXML
	private Pane		lowRisk, mediumRisk, highRisk;
	@FXML
	private Pane		lowRiskBack, mediumRiskBack, highRiskBack;
	// private Pane[] risks = new Pane[] {lowRisk, mediumRisk, highRisk};

	private int		selected;
	private String	styleSelected	= "-fx-background-color: rgba(255,255,255,0.3);";
	private String	styleUnselected	= "-fx-background-color: rgba(255,255,255,0.1);";
	private Car userCar = Profile.getCar();

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		background.fitWidthProperty().bind(root.widthProperty());
		background.fitHeightProperty().bind(root.heightProperty());

		// risks = {lowRisk, mediumRisk, highRisk};
		// int selected = Profile.getStrategy();
		selected = Profile.getStrategy();

		displaySelected();

		lowRisk.setOnMousePressed(event -> {
			playAudio("click.wav", 1.0);
			Profile.setStrategy(1);
			userCar.setCrashChance(2);
			userCar.setRiskMultiplier(97);
			try {
				GameController.writeJsonObjectToFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			selected = 1;
			displaySelected();
		});

		mediumRisk.setOnMousePressed(event -> {
			playAudio("click.wav", 1.0);
			Profile.setStrategy(2);
			userCar.setCrashChance(7);
			userCar.setRiskMultiplier(100);
			try {
				GameController.writeJsonObjectToFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			selected = 2;
			displaySelected();
		});

		highRisk.setOnMousePressed(event -> {
			playAudio("click.wav", 1.0);
			Profile.setStrategy(3);
			userCar.setCrashChance(15);
			userCar.setRiskMultiplier(105);
			try {
				GameController.writeJsonObjectToFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			selected = 3;
			displaySelected();
		});
		
		back.setOnMousePressed(event -> {
			try
			{
				gotoFxmlScene("Dashboard", (Stage) back.getScene().getWindow());
				playAudio("click.wav", 1.0);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		});
		back.setOnMouseEntered(event -> {
			back.setImage(new Image("file:images/menu/BackHover.png"));
			playAudio("hover.wav", 1.0);
		});
		back.setOnMouseExited(event -> {
			back.setImage(new Image("file:images/menu/Back.png"));
		});
	}

	private void displaySelected()
	{
		unselectAll();
		switch (selected)
		{
		case 1:
			lowRiskBack.setStyle(styleSelected);
			break;
		case 2:
			mediumRiskBack.setStyle(styleSelected);
			break;
		case 3:
			highRiskBack.setStyle(styleSelected);
			break;
		default:
			break;
		}
	}

	private void unselectAll()
	{
		lowRiskBack.setStyle(styleUnselected);
		mediumRiskBack.setStyle(styleUnselected);
		highRiskBack.setStyle(styleUnselected);
	}
}

package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddMemberController {
	
	@FXML
	private Label addMemberlabel;
	@FXML
	private TextField fNameText;
	@FXML
	private TextField lNameText;
	@FXML
	private TextField phoneNumberText;
	@FXML
	private TextField memberIDText;
	@FXML
	private TextField streetText;
	@FXML
	private TextField cityText;
	@FXML
	private TextField stateText;
	@FXML
	private TextField zipText;
	
	
	@FXML
	private Button addMember;
	@FXML
	private Button updateMember; // used to edit members
	
	public void addMember(ActionEvent event) {
		
	}
	public void updateMember(ActionEvent event) {

	}
	
	public void setUpdateVisible() {
		addMember.setVisible(false);
		updateMember.setVisible(true);
		addMemberlabel.setText("Edit Member");
	}
	public void addMemberVisible() {
		addMember.setVisible(true);
		updateMember.setVisible(false);
		addMemberlabel.setText("Add Member");
	}
	

}

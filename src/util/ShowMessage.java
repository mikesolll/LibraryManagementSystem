package util;

import javafx.scene.control.Alert;

public class ShowMessage {

    private static Alert alert;
    private ShowMessage(){}

    public static void error(String header,String message){
       alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!!!");
        alert.setHeaderText(header);
        alert.setContentText(message);

        alert.showAndWait();
    }

    public static void success(String header,String message){
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Success");
        alert.setHeaderText(header);
        alert.setContentText(message);

        alert.showAndWait();
    }

    public static void warning(String header,String message){
        alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning!!!");
        alert.setHeaderText(header);
        alert.setContentText(message);

        alert.showAndWait();
    }
}

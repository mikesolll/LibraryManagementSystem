package dataaccess;

import javafx.stage.Stage;

public class VisibilityControl {

    private static Stage currentStage;

    public static void firstPage(Stage stage){
        currentStage=stage;
    }

    public static void navigate(Stage to){
        currentStage.hide();
        to.show();
        currentStage=to;
    }
}

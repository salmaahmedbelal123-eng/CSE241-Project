import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LMS extends Application{
    

    @Override
    public void start(Stage primaryStage) throws Exception{
        //loads the first scene (wich is the login page)
        Parent root = FXMLLoader.load(getClass().getResource("gui/LoginPage.fxml"));
        primaryStage.setTitle("Learning Managment System");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


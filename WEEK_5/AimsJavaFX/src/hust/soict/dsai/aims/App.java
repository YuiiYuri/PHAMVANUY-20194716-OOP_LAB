package hust.soict.dsai.aims;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Store.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("AIMS Store");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

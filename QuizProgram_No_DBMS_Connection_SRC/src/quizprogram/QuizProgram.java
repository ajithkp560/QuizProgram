/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizprogram;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author TERMINAL
 */
public class QuizProgram extends Application {
    
    @Override
    public void start(Stage stage) throws Exception 
    {
        stage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("design.fxml"));    
        //stage.setFullScreen(true);
        Scene scene = new Scene(root);
        stage.setTitle("Quiz Program");
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("apple.png")));
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
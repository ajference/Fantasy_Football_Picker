package picker_gui;

import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JButton;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FantasyGui extends Application {


	private PageTracker stage;
	private Button weekly;
	private Scene main;
	
	
	
	
	public static void main(String[] args)
	{
	    Application.launch( args );

	}
	
	
	
	public void start(Stage primaryStage) throws Exception{
			//stage set up
			primaryStage.setTitle("Fantasy Football Picker");
		    primaryStage.show();
			//stage = new PageTracker(primaryStage);  
			
			//main scene 
		    GridPane grid = new GridPane();
		    grid.setAlignment(Pos.CENTER);
		    grid.setHgap(10);
		    grid.setVgap(10);
		    grid.setPadding(new Insets(25, 25, 25, 25));

		    Scene scene = new Scene(grid, 300, 275);
		    primaryStage.setScene(scene);
		    
		    Text scenetitle = new Text("Welcome");
		    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		    grid.add(scenetitle, 0, 0, 2, 1);
		    createButtons("test");
		    grid.add(weekly, 0, 1);

//		    Label userName = new Label("User Name:");
//		    grid.add(userName, 0, 1);
//
//		    TextField userTextField = new TextField();
//		    grid.add(userTextField, 1, 1);
//
//		    Label pw = new Label("Password:");
//		    grid.add(pw, 0, 2);
//
//		    PasswordField pwBox = new PasswordField();
//		    grid.add(pwBox, 1, 2);
		    
		   // primaryStage.setScene(main);
			

}
	
	
	public Button createButtons(String e) {
		DropShadow shadow = new DropShadow();
		weekly = new Button("Weekly Schedule");   //sets the button 
		weekly.setLayoutX(100);
	    weekly.setLayoutY(80);
		weekly.addEventFilter(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
	    	@Override public void handle(MouseEvent e) {
	    		weekly.setEffect(shadow);
	        }
	});
		weekly.addEventFilter(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
	        @Override public void handle(MouseEvent e) {
	        	weekly.setEffect(null);
	       }});
		
		weekly.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	System.out.println("test");
               //go to the weekly scene 
            }
        });
		return weekly;
	}

}
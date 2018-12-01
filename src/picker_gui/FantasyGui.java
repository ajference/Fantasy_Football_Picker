package picker_gui;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.AbstractButton;
import javax.swing.JButton;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import nfl.NFL;

public class FantasyGui extends Application {

	private Scene weeklyScene;
	private Button exit;
	private Button back;
	private Button home;
	private Button weekly;
	private Button Pick;
	private Button Team;
	private Button Players;
	private Scene main;
	private NFL nfl;
	
	TableView table = new TableView();

	
	
	public static void main(String[] args)
	{
	    Application.launch( args );

	}
	
	
	
	public void start(Stage primaryStage) throws Exception{
			//stage set up
			nfl = new NFL();
			primaryStage.setTitle("Fantasy Football Picker");
		    primaryStage.show(); 
			//main scene 
		    GridPane grid = new GridPane();
		    grid.setAlignment(Pos.CENTER);
		    grid.setHgap(40);
		    grid.setVgap(40);
		    grid.setPadding(new Insets(100, 100, 100, 100));

		     main = new Scene(grid, 450, 375);
		    primaryStage.setScene(main);
		    
		    Text scenetitle = new Text("Pick a Category");
		    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		    grid.add(scenetitle, 0, 0, 2, 1);
		    exit = createButton("Exit");
			back = createButton("Back");
			home = createButton("Home");
		    weekly = createButton("Weekly Schedule");
		    Team = createButton("My Team");
		    Players = createButton("Top Players");
		    Pick = createButton("Pick Guru");
		    grid.add(weekly, 0, 1);
		    grid.add(Players, 0, 2);
		    grid.add(Pick, 1, 1);
		    grid.add(Team, 1, 2);
		    
		    
		    weekly.setOnAction((event)-> {primaryStage.setScene(buildWeekMatchesScene(1, primaryStage));});
		    
		    Team.setOnAction((event) -> {System.out.println("test");});
		    
		    Players.setOnAction((event) -> {System.out.println("test");});
		    
		    Pick.setOnAction((event) -> {System.out.println("test");});
		    /*
		      table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                  if (newSelection != null) {
                     String week  = (String) newSelection;
           
                   //  primaryStage.setScene(menu);
                  }
              });*/
		    
		    
		    
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
	
	
	
	
	
	public Button createButton(String e) {
		DropShadow shadow = new DropShadow();
		Button button = new Button(e);   //sets the button 
		button.setLayoutX(150);
		button.setLayoutY(120);
		button.addEventFilter(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
	    	@Override public void handle(MouseEvent e) {
	    		button.setEffect(shadow);
	        }
	});
		button.addEventFilter(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
	        @Override public void handle(MouseEvent e) {
	        	button.setEffect(null);
	       }});
		return button;
	}
	
	
	public void buildPlayerScene(String e, Stage main) {

		//main scene 

		    GridPane grid = new GridPane();
		    grid.setAlignment(Pos.CENTER);
		    grid.setHgap(10);
		    grid.setVgap(10);
		    grid.setPadding(new Insets(25, 25, 25, 25));
		    
		    Button week1Button  = createButton("Week 1");
		    Button week2Button  = createButton("Week 2");
		    Button week3Button  = createButton("Week 3");
		    Button week4Button  = createButton("Week 4");
		    Button week5Button  = createButton("Week 5");
		    Button week6Button  = createButton("Week 6");
		    Button week7Button  = createButton("Week 7");
		    Button week8Button  = createButton("Week 8");
		    Button week9Button  = createButton("Week 9");
		    Button week10Button = createButton("Week 10");
		    Button week11Button = createButton("Week 11");
		    Button week12Button = createButton("Week 12");
		    Button week13Button = createButton("Week 13");
		    Button week14Button = createButton("Week 14");
		    Button week15Button = createButton("Week 15");
		    Button week16Button = createButton("Week 16");
		    Button week17Button = createButton("Week 17");

		   switch (e) {
		   
		   case "Weekly":
			Text scenetitle = new Text("Pick a Week");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid.add(scenetitle, 0, 0, 0, 0);
			week1Button.setOnAction((event)-> { buildWeekMatchesScene(1, main);});
		    week2Button.setOnAction((event)-> {DriverOne.TopPlayers(2); });
		    week3Button.setOnAction((event)-> {DriverOne.TopPlayers(3); });
		    week4Button.setOnAction((event)-> {DriverOne.TopPlayers(4);});
		    week5Button.setOnAction((event)-> {DriverOne.TopPlayers(5);});
		    week6Button.setOnAction((event)-> {DriverOne.TopPlayers(6); });
		    week7Button.setOnAction((event)-> {DriverOne.TopPlayers(7); });
		    week8Button.setOnAction((event)-> {DriverOne.TopPlayers(8); });
		    week9Button.setOnAction((event)-> {DriverOne.TopPlayers(9); });
		    week10Button.setOnAction((event)-> {DriverOne.TopPlayers(10);});
		    week11Button.setOnAction((event)-> { DriverOne.TopPlayers(11);});
		    week12Button.setOnAction((event)-> { DriverOne.TopPlayers(12);});
		    week13Button.setOnAction((event)-> { DriverOne.TopPlayers(13); });
		    week14Button.setOnAction((event)-> { DriverOne.TopPlayers(14); });
		    week15Button.setOnAction((event)-> {DriverOne.TopPlayers(15);});
		    week16Button.setOnAction((event)-> {DriverOne.TopPlayers(16);});
		    week17Button.setOnAction((event)-> {DriverOne.TopPlayers(17);});
		    break;
		   
		   case "Player":
			week1Button.setOnAction((event)-> { DriverOne.TopPlayers(1);});
		    week2Button.setOnAction((event)-> {DriverOne.TopPlayers(2); });
		    week3Button.setOnAction((event)-> {DriverOne.TopPlayers(3); });
		    week4Button.setOnAction((event)-> {DriverOne.TopPlayers(4);});
		    week5Button.setOnAction((event)-> {DriverOne.TopPlayers(5);});
		    week6Button.setOnAction((event)-> {DriverOne.TopPlayers(6); });
		    week7Button.setOnAction((event)-> {DriverOne.TopPlayers(7); });
		    week8Button.setOnAction((event)-> {DriverOne.TopPlayers(8); });
		    week9Button.setOnAction((event)-> {DriverOne.TopPlayers(9); });
		    week10Button.setOnAction((event)-> {DriverOne.TopPlayers(10);});
		    week11Button.setOnAction((event)-> { DriverOne.TopPlayers(11);});
		    week12Button.setOnAction((event)-> { DriverOne.TopPlayers(12);});
		    week13Button.setOnAction((event)-> { DriverOne.TopPlayers(13); });
		    week14Button.setOnAction((event)-> { DriverOne.TopPlayers(14); });
		    week15Button.setOnAction((event)-> {DriverOne.TopPlayers(15);});
		    week16Button.setOnAction((event)-> {DriverOne.TopPlayers(16);});
		    week17Button.setOnAction((event)-> {DriverOne.TopPlayers(17);});
		    break;
		   default: 
			   System.out.println("error");
		   break;
		   
		   }
		   
		   
		   
		    Scene players = new Scene(grid, 300, 275);
		    main.setScene(players);
		}
	
	
	public Scene buildWeekMatchesScene(int i, Stage prim) {
		String temp; 
		GridPane grid = new GridPane();
	    grid.setAlignment(Pos.CENTER);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(25, 25, 25, 25));
	    Text scenetitle = new Text("Pick A Match To Get More Info");
	    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	    grid.add(scenetitle, 0, 0, 0, 0);
		final ArrayList<String> matches = nfl.printWeeklySchedule(i);
		

		    for (int r = 0; r < matches.size(); r++) {
		            Button button = createButton(matches.get(r));
		            Label name = new Label(matches.get(r));
		            button.setOnAction((event) -> {prim.setScene(new Scene(name, 450, 375));});
		            grid.add(button, 0, r);
		            
		    }
		    
        
		    ScrollPane scrollPane = new ScrollPane(grid);

		   Scene MatchScenes = new Scene(scrollPane, 450, 375);

          
		return MatchScenes;
		
	}
	
	
	
	
	
	
	
}
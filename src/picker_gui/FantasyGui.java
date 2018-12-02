package picker_gui;

import java.util.ArrayList;

import dataCollection.CalculateRanks;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import nfl.NFL;

public class FantasyGui extends Application {

//	private Scene weeklyScene;
	private Button exit;
	private Button back;
	private Button home;
	private Button weekly;
	private Button Pick;
	private Button Team;
	private Button Players;
	private Scene main;
	private NFL nfl;
	private HBox hbBtn;
	

	
	
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
		    
		    
		    hbBtn = new HBox(10);
		    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		    hbBtn.getChildren().add(exit);
		    grid.add(hbBtn, 1, 4);
		    
		    exit.setOnAction((event)-> {System.exit(0);});
		    
		    weekly.setOnAction((event)-> {buildPlayerScene("Weekly", primaryStage);});
		    
		    Players.setOnAction((event) -> {buildPlayerScene("Player", primaryStage);});
		    
		    Team.setOnAction((event) -> {System.out.println("test");});
		    
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
		Text scenetitle;
		    GridPane grid = new GridPane();
		    grid.add(hbBtn, 1, 17);
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

		    grid.add(week1Button, 0, 1);
		    grid.add(week2Button, 0, 2);
		    grid.add(week3Button, 0, 3);
		    grid.add(week4Button, 0, 4);
		    grid.add(week5Button, 0, 5);
		    grid.add(week6Button, 0, 6);
		    grid.add(week7Button, 0, 7);
		    grid.add(week8Button, 0, 8);
		    grid.add(week9Button, 0, 9);
		    grid.add(week10Button, 0, 10);
		    grid.add(week11Button, 0, 11);
		    grid.add(week12Button, 0, 12);
		    grid.add(week13Button, 0, 13);
		    grid.add(week14Button, 0, 14);
		    grid.add(week15Button, 0, 15);
		    grid.add(week16Button, 0, 16);
		    grid.add(week17Button, 0, 17);
		   switch (e) {
		   
		   case "Weekly":
			scenetitle = new Text("Pick a Week");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid.add(scenetitle, 0, 0, 1, 1);
			week1Button.setOnAction((event)-> {buildWeekMatchesScene(1, main);});
		    week2Button.setOnAction((event)-> {buildWeekMatchesScene(2, main);});
		    week3Button.setOnAction((event)-> {buildWeekMatchesScene(3, main);});
		    week4Button.setOnAction((event)-> {buildWeekMatchesScene(4, main);});
		    week5Button.setOnAction((event)-> {buildWeekMatchesScene(5, main);});
		    week6Button.setOnAction((event)-> {buildWeekMatchesScene(6, main);});
		    week7Button.setOnAction((event)-> {buildWeekMatchesScene(7, main);});
		    week8Button.setOnAction((event)-> {buildWeekMatchesScene(8, main);});
		    week9Button.setOnAction((event)-> {buildWeekMatchesScene(9, main);});
		    week10Button.setOnAction((event)-> {buildWeekMatchesScene(10, main);});
		    week11Button.setOnAction((event)-> {buildWeekMatchesScene(11, main);});
		    week12Button.setOnAction((event)-> {buildWeekMatchesScene(12, main);});
		    week13Button.setOnAction((event)-> {buildWeekMatchesScene(13, main);});
		    week14Button.setOnAction((event)-> {buildWeekMatchesScene(14, main);});
		    week15Button.setOnAction((event)-> {buildWeekMatchesScene(15, main);});
		    week16Button.setOnAction((event)-> {buildWeekMatchesScene(16, main);});
		    week17Button.setOnAction((event)-> {buildWeekMatchesScene(17, main);});
		    break;
		   
		   case "Player":
			scenetitle = new Text("Pick a Week To get the best \nPlayers form those mathces");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid.add(scenetitle, 0, 0, 1, 1);
			week1Button.setOnAction((event)-> {showPlayerCalculations(1, main);});
		    week2Button.setOnAction((event)-> {showPlayerCalculations(2, main);});
		    week3Button.setOnAction((event)-> {showPlayerCalculations(3, main);});
		    week4Button.setOnAction((event)-> {showPlayerCalculations(4, main);});
		    week5Button.setOnAction((event)-> {showPlayerCalculations(5, main);});
		    week6Button.setOnAction((event)-> {showPlayerCalculations(6, main);});
		    week7Button.setOnAction((event)-> {showPlayerCalculations(7, main);});
		    week8Button.setOnAction((event)-> {showPlayerCalculations(8, main);});
		    week9Button.setOnAction((event)-> {showPlayerCalculations(9, main);});
		    week10Button.setOnAction((event)-> {showPlayerCalculations(10, main);});
		    week11Button.setOnAction((event)-> {showPlayerCalculations(11, main);});
		    week12Button.setOnAction((event)-> {showPlayerCalculations(12, main);});
		    week13Button.setOnAction((event)-> {showPlayerCalculations(13, main);});
		    week14Button.setOnAction((event)-> {showPlayerCalculations(14, main);});
		    week15Button.setOnAction((event)-> {showPlayerCalculations(15, main);});
		    week16Button.setOnAction((event)-> {showPlayerCalculations(16, main);});
		    week17Button.setOnAction((event)-> {showPlayerCalculations(17, main);});
		    break;
		   default: 
			   System.out.println("error");
		   break;
		   
		   }
		   
		   
		   ScrollPane scrollPane = new ScrollPane(grid);
		    Scene players = new Scene(scrollPane, 400, 300);
		    main.setScene(players);
		}
	
	
	public void showPlayerCalculations(int i, Stage main) {
		GridPane grid2 = new GridPane();
	    grid2.setAlignment(Pos.CENTER);
	    grid2.setHgap(10);
	    grid2.setVgap(10);
	    grid2.setPadding(new Insets(25, 25, 25, 25));
	    grid2.add(hbBtn, 1, 4);
	    Text scenetitle2 = new Text("Best Player picks for Week "+ i);
	    scenetitle2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	    grid2.add(scenetitle2, 0, 0, 1, 1);
        Label name = new Label(CalculateRanks.makeBreakDown(i));
        grid2.add(name,0,1);
        ScrollPane scrollPane = new ScrollPane(grid2);
        main.setScene(new Scene(scrollPane, 500, 375));
	}
	
	
	public Scene buildWeekMatchesScene(int i, Stage prim) {
		GridPane grid = new GridPane();
	    grid.setAlignment(Pos.CENTER);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(25, 25, 25, 25));
	    Text scenetitle = new Text("Pick A Match To Get More Info");
	    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	    grid.add(scenetitle, 0, 0, 1, 1);
	    grid.add(hbBtn, 1, 4);
		ArrayList<String> matches = nfl.printWeeklySchedule(i);

		    for (int r = 0; r < matches.size(); r++) {
		            Button button = createButton(matches.get(r));
		            GridPane grid2 = new GridPane();
		    	    grid2.setAlignment(Pos.CENTER);
		    	    grid2.setHgap(10);
		    	    grid2.setVgap(10);
		    	    grid2.setPadding(new Insets(25, 25, 25, 25));
		    	    grid2.add(hbBtn, 1, 4);
		    	    Text scenetitle2 = new Text("Stats for the"+ matches.get(r) + " Match");
		    	    scenetitle2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		    	    grid2.add(scenetitle2, 0, 0, 1, 1);
		            Label name = new Label(nfl.teamComparison(i, (r+1)));
		            grid2.add(name,0,1);
		            ScrollPane scrollPane2 = new ScrollPane(grid2);
		            button.setOnAction((event) -> {prim.setScene(new Scene(scrollPane2, 750, 375));});
		            grid.add(button, 0, (r+1));
		            
		    }
		    ScrollPane scrollPane = new ScrollPane(grid);

		   Scene MatchScenes = new Scene(scrollPane, 450, 375);

		   prim.setScene(MatchScenes);
		return MatchScenes;
		
	}
	
	
	
	
	
	
	
	
	
}
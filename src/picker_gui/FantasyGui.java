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
import nfl.Player;

public class FantasyGui extends Application {

	private Scene Weekly;
	private Scene Player;
	private Scene MatchScenes;
	private Button weekly;
	private Button Pick;
	private Button Team;
	private Button Players;
	private Scene main;
	private NFL nfl;
	private ArrayList<Player> myTeam; 
	

	
	
	public static void main(String[] args)
	{
	    Application.launch( args );

	}
	
	
	
	public void start(Stage primaryStage) throws Exception{
			//stage set up
			myTeam = new  ArrayList<Player>();
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
		    Button exit = createButton("Exit");
			Button back = createButton("Back");
			Button home = createButton("Home");
		    weekly = createButton("Weekly Schedule");
		    Team = createButton("My Team");
		    Players = createButton("Top Players");
		    Pick = createButton("Pick Guru");
		    grid.add(weekly, 0, 1);
		    grid.add(Players, 0, 2);
		    grid.add(Pick, 1, 1);
		    grid.add(Team, 1, 2);
		    buildPlayerScene("Weekly", primaryStage);
		    buildPlayerScene("Player", primaryStage);
		    HBox hbBtn = new HBox(10);
		    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		    hbBtn.getChildren().add(exit);
		    grid.add(hbBtn, 1, 4);
		    
		    exit.setOnAction((event)-> {System.exit(0);});
		    
		    home.setOnAction((event)-> {primaryStage.setScene(main);});
		    
		    weekly.setOnAction((event)-> {primaryStage.setScene(Weekly);});
		    
		    Players.setOnAction((event) -> {primaryStage.setScene(Player);});
		    
		    Team.setOnAction((event) -> {primaryStage.setScene(creatQB(primaryStage));});
		    
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
	
	
	public void buildPlayerScene(String e, Stage prim) {
	    Button exit = createButton("Exit");
		Button back = createButton("Back");
		Button home = createButton("Home");
		exit.setOnAction((event)-> {System.exit(0);});
	    home.setOnAction((event)-> {prim.setScene(main);});
		
		Text scenetitle;
			ScrollPane scrollPane;
		    GridPane grid = new GridPane();
		    HBox hbBtn = new HBox(10);
		    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		    hbBtn.getChildren().add(exit);
		    hbBtn.getChildren().add(home);
		    hbBtn.getChildren().add(back);
		    grid.add(hbBtn, 0, 18);
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
			week1Button.setOnAction((event)-> {buildWeekMatchesScene(1, prim);});
		    week2Button.setOnAction((event)-> {buildWeekMatchesScene(2, prim);});
		    week3Button.setOnAction((event)-> {buildWeekMatchesScene(3, prim);});
		    week4Button.setOnAction((event)-> {buildWeekMatchesScene(4, prim);});
		    week5Button.setOnAction((event)-> {buildWeekMatchesScene(5, prim);});
		    week6Button.setOnAction((event)-> {buildWeekMatchesScene(6, prim);});
		    week7Button.setOnAction((event)-> {buildWeekMatchesScene(7, prim);});
		    week8Button.setOnAction((event)-> {buildWeekMatchesScene(8, prim);});
		    week9Button.setOnAction((event)-> {buildWeekMatchesScene(9, prim);});
		    week10Button.setOnAction((event)-> {buildWeekMatchesScene(10, prim);});
		    week11Button.setOnAction((event)-> {buildWeekMatchesScene(11, prim);});
		    week12Button.setOnAction((event)-> {buildWeekMatchesScene(12, prim);});
		    week13Button.setOnAction((event)-> {buildWeekMatchesScene(13, prim);});
		    week14Button.setOnAction((event)-> {buildWeekMatchesScene(14, prim);});
		    week15Button.setOnAction((event)-> {buildWeekMatchesScene(15, prim);});
		    week16Button.setOnAction((event)-> {buildWeekMatchesScene(16, prim);});
		    week17Button.setOnAction((event)-> {buildWeekMatchesScene(17, prim);});
			   back.setOnAction((event)-> {prim.setScene(main);});
			   scrollPane = new ScrollPane(grid);
			    Weekly = new Scene(scrollPane, 400, 300);
		    break;
		   
		   case "Player":
			scenetitle = new Text("Pick a Week To get the best \nPlayers form those mathces");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid.add(scenetitle, 0, 0, 1, 1);
			week1Button.setOnAction((event)-> {showPlayerCalculations(1, prim);});
		    week2Button.setOnAction((event)-> {showPlayerCalculations(2, prim);});
		    week3Button.setOnAction((event)-> {showPlayerCalculations(3, prim);});
		    week4Button.setOnAction((event)-> {showPlayerCalculations(4, prim);});
		    week5Button.setOnAction((event)-> {showPlayerCalculations(5, prim);});
		    week6Button.setOnAction((event)-> {showPlayerCalculations(6, prim);});
		    week7Button.setOnAction((event)-> {showPlayerCalculations(7, prim);});
		    week8Button.setOnAction((event)-> {showPlayerCalculations(8, prim);});
		    week9Button.setOnAction((event)-> {showPlayerCalculations(9, prim);});
		    week10Button.setOnAction((event)-> {showPlayerCalculations(10, prim);});
		    week11Button.setOnAction((event)-> {showPlayerCalculations(11, prim);});
		    week12Button.setOnAction((event)-> {showPlayerCalculations(12, prim);});
		    week13Button.setOnAction((event)-> {showPlayerCalculations(13, prim);});
		    week14Button.setOnAction((event)-> {showPlayerCalculations(14, prim);});
		    week15Button.setOnAction((event)-> {showPlayerCalculations(15, prim);});
		    week16Button.setOnAction((event)-> {showPlayerCalculations(16, prim);});
		    week17Button.setOnAction((event)-> {showPlayerCalculations(17, prim);});
			   back.setOnAction((event)-> {prim.setScene(main);});
			   scrollPane = new ScrollPane(grid);
			   	Player = new Scene(scrollPane, 400, 300);
		    break;
		   default: 
			   System.out.println("error");
		   break;
		   
		   }
		}
	
	
	public void showPlayerCalculations(int i, Stage prim) {
		GridPane grid = new GridPane();
	    grid.setAlignment(Pos.CENTER);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    Button exit = createButton("Exit");
		Button back = createButton("Back");
		Button home = createButton("Home");
		exit.setOnAction((event)-> {System.exit(0);});
	    home.setOnAction((event)-> {prim.setScene(main);});
	    grid.setPadding(new Insets(25, 25, 25, 25));
	    HBox hbBtn = new HBox(10);
	    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
	    hbBtn.getChildren().add(exit);
	    hbBtn.getChildren().add(home);
	    hbBtn.getChildren().add(back);
	    exit.setOnAction((event)-> {System.exit(0);});
	    home.setOnAction((event)-> {prim.setScene(main);});
	    back.setOnAction((event)-> {prim.setScene(Player);});
	    grid.add(hbBtn, 0, 4);
	    Text scenetitle2 = new Text("Best Player picks for Week "+ i);
	    scenetitle2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	    grid.add(scenetitle2, 0, 0, 1, 1);
        Label name = new Label(CalculateRanks.makeBreakDown(i));
        grid.add(name,0,1);
        ScrollPane scrollPane = new ScrollPane(grid);
        prim.setScene(new Scene(scrollPane, 500, 375));
	}
	
	
	public void buildWeekMatchesScene(int i, Stage prim) {
		GridPane grid = new GridPane();
	    grid.setAlignment(Pos.CENTER);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(25, 25, 25, 25));
	    Text scenetitle = new Text("Pick A Match To Get More Info");
	    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	    grid.add(scenetitle, 0, 0, 1, 1);
	    HBox hbBtn = new HBox(10);
	    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
	    Button exit = createButton("Exit");
		Button back = createButton("Back");
		Button home = createButton("Home");
		exit.setOnAction((event)-> {System.exit(0);});
	    home.setOnAction((event)-> {prim.setScene(main);});
	    hbBtn.getChildren().add(exit);
	    hbBtn.getChildren().add(home);
	    hbBtn.getChildren().add(back);
	    grid.add(hbBtn, 0, 18);
		ArrayList<String> matches = nfl.printWeeklySchedule(i);

		    for (int r = 0; r < matches.size(); r++) {
		            Button button = createButton(matches.get(r));
		            GridPane grid2 = new GridPane();
		    	    grid2.setAlignment(Pos.CENTER);
		    	    grid2.setHgap(10);
		    	    grid2.setVgap(10);
		    	    grid2.setPadding(new Insets(25, 25, 25, 25));
				    HBox hbBtn2 = new HBox(10);
				    hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
				    Button exit1 = createButton("Exit");
					Button back1 = createButton("Back");
					Button home1 = createButton("Home");
					exit1.setOnAction((event)-> {System.exit(0);});
					back1.setOnAction((event)-> {prim.setScene(MatchScenes);});
				    home1.setOnAction((event)-> {prim.setScene(main);});
				    hbBtn2.getChildren().add(exit1);
				    hbBtn2.getChildren().add(home1);
				    hbBtn2.getChildren().add(back1);
		    	    grid2.add(hbBtn2, 0, matches.size());
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

		   MatchScenes = new Scene(scrollPane, 450, 375);
		   back.setOnAction((event)-> {prim.setScene(Weekly);});
		   prim.setScene(MatchScenes);
	}
	
	
	
	
	//My Team
	
	public Scene creatQB(Stage prim) {
		GridPane grid = new GridPane();
	    grid.setAlignment(Pos.CENTER);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(25, 25, 25, 25));
	    Text scenetitle = new Text("Pick A Quarterback");
	    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	    grid.add(scenetitle, 0, 0, 1, 1);
	    HBox hbBtn = new HBox(10);
	    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
	    Button exit = createButton("Exit");
		Button home = createButton("Home");
		exit.setOnAction((event)-> {System.exit(0);});
	    home.setOnAction((event)-> {prim.setScene(main);});
	    hbBtn.getChildren().add(exit);
	    hbBtn.getChildren().add(home);
	    ArrayList<Player> topPlayers = nfl.printPlayerPosition(0, 4, 15);
	    grid.add(hbBtn, 0, topPlayers.size());
	    for (int r = 0; r < topPlayers.size(); r++) {
            Button button = createButton((topPlayers.get(r).getName()));
            Player p = topPlayers.get(r);
           button.setOnAction((event) -> {myTeam.add(p); prim.setScene(creatRB(prim));});
            grid.add(button, 0, (r+1));   
    }
	    
	    
	    
	    
	    ScrollPane scrollPane = new ScrollPane(grid);
	    Scene QBScene = new Scene(scrollPane, 450, 375);
	    return QBScene;
	}
	
	public Scene creatRB(Stage prim) {
		GridPane grid = new GridPane();
	    grid.setAlignment(Pos.CENTER);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(25, 25, 25, 25));
	    Text scenetitle = new Text("Pick A Running Back");
	    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	    grid.add(scenetitle, 0, 0, 1, 1);
	    HBox hbBtn = new HBox(10);
	    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
	    Button exit = createButton("Exit");
		Button home = createButton("Home");
		exit.setOnAction((event)-> {System.exit(0);});
	    home.setOnAction((event)-> {prim.setScene(main);});
	    hbBtn.getChildren().add(exit);
	    hbBtn.getChildren().add(home);
	    ArrayList<Player> topPlayers = nfl.printPlayerPosition(0, 3, 15);
	    grid.add(hbBtn, 0, topPlayers.size());
	    for (int r = 0; r < topPlayers.size(); r++) {
            Button button = createButton((topPlayers.get(r).getName()));
            Player p = topPlayers.get(r);
            button.setOnAction((event) -> {myTeam.add(p); prim.setScene(creatWR(prim));});
            grid.add(button, 0, (r+1));   
    }
	    
	    
	    
	    
	    ScrollPane scrollPane = new ScrollPane(grid);
	    Scene RBScene = new Scene(scrollPane, 450, 375);
	    return RBScene;
	}

	public Scene creatWR(Stage prim) {
		GridPane grid = new GridPane();
	    grid.setAlignment(Pos.CENTER);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(25, 25, 25, 25));
	    Text scenetitle = new Text("Pick A Running Back");
	    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	    grid.add(scenetitle, 0, 0, 1, 1);
	    HBox hbBtn = new HBox(10);
	    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
	    Button exit = createButton("Exit");
		Button home = createButton("Home");
		exit.setOnAction((event)-> {System.exit(0);});
	    home.setOnAction((event)-> {prim.setScene(main);});
	    hbBtn.getChildren().add(exit);
	    hbBtn.getChildren().add(home);
	    ArrayList<Player> topPlayers = nfl.printPlayerPosition(0, 3, 15);
	    grid.add(hbBtn, 0, topPlayers.size());
	    for (int r = 0; r < topPlayers.size(); r++) {
            Button button = createButton((topPlayers.get(r).getName()));
            Player p = topPlayers.get(r);
            button.setOnAction((event) -> {myTeam.add(p); prim.setScene(creatRB(prim));});
            grid.add(button, 0, (r+1));   
    }
	    
	    
	    
	    
	    ScrollPane scrollPane = new ScrollPane(grid);
	    Scene RBScene = new Scene(scrollPane, 450, 375);
	    return RBScene;
	}
	
	
	
	
}
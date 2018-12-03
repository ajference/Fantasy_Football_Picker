package picker_gui;

import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import dataCollection.CalculateRanks;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
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
			myTeam = loadData();
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
		    
		    //Text scenetitle = new Text("Pick a Category");
		    //scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		    //grid.add(scenetitle, 0, 0, 2, 1);
		    
		    File f = new File("");
		    File x = new File(f.getAbsolutePath() + "/src/input_files/Fantasy_Football_Logo.png");
		    Image img = new Image(x.toURI().toString());
		    grid.add(new ImageView(img), 0, 0, 2, 1);
		    
		    
		    
		    Button exit = createButton("Exit");
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
		    
		    weekly.setOnAction((event)-> {primaryStage.setScene(Weekly);});
		    
		    Players.setOnAction((event) -> {primaryStage.setScene(Player);});
		    
		    Team.setOnAction((event) -> {primaryStage.setScene(displayMyTeam(primaryStage, " "));});
		    
		    Pick.setOnAction((event) -> {if (Error4() == true) {myTeam = new ArrayList<Player>(); saveData(myTeam); primaryStage.setScene(startGuru(primaryStage));}});

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
			
		    GridPane grid = new GridPane();
		    HBox hbBtn = new HBox(10);
		    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		    hbBtn.getChildren().add(exit);
		    hbBtn.getChildren().add(home);
		    hbBtn.getChildren().add(back);
		    grid.setAlignment(Pos.CENTER);
		    grid.setHgap(10);
		    grid.setVgap(10);
		    grid.setPadding(new Insets(25, 25, 25, 25));
		    ScrollPane scrollPane = new ScrollPane(grid);
		    
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
			   	Player = new Scene(scrollPane, 400, 300);
		    break;
		   default: 
			   System.out.println("error");
		   break;
		   
		   }
		   grid.add(hbBtn, 0, 18);
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
	    ScrollPane scrollPane = new ScrollPane(grid);
	    HBox hbBtn = new HBox(10);
	    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
	    hbBtn.getChildren().add(exit);
	    hbBtn.getChildren().add(home);
	    hbBtn.getChildren().add(back);
	    exit.setOnAction((event)-> {System.exit(0);});
	    home.setOnAction((event)-> {prim.setScene(main);});
	    back.setOnAction((event)-> {prim.setScene(Player);});
	    Text scenetitle2 = new Text("Best Player picks for Week "+ i);
	    scenetitle2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	    grid.add(scenetitle2, 0, 0, 1, 1);
        Label name = new Label(CalculateRanks.makeBreakDown(i));
        grid.add(name,0,1);
        prim.setScene(new Scene(scrollPane, 500, 375));
        grid.add(hbBtn, 0, 4);
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
	    ScrollPane scrollPane = new ScrollPane(grid);
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
				    ScrollPane scrollPane2 = new ScrollPane(grid2);
		    	    Text scenetitle2 = new Text("Stats for the "+ matches.get(r) + " Match");
		    	    scenetitle2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		    	    grid2.add(scenetitle2, 0, 0, 1, 1);
		            Label name = new Label(nfl.teamComparison(i, (r+1)));
		            grid2.add(name,0,1);
		            grid2.add(hbBtn2, 0, 2); 
		            button.setOnAction((event) -> {prim.setScene(new Scene(scrollPane2, 750, 375));});
		            grid.add(button, 0, (r+1)); 
		    }
		   MatchScenes = new Scene(scrollPane, 450, 375);
		   grid.add(hbBtn, 0, matches.size()+1);
		   back.setOnAction((event)-> {prim.setScene(Weekly);});
		   prim.setScene(MatchScenes);
	}
	
	
	

	public Scene startGuru(Stage prim) {
		GridPane grid = new GridPane();
	    grid.setAlignment(Pos.CENTER);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(25, 25, 25, 25));
	    Text scenetitle = new Text("The Pick Guru");
	    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	    grid.add(scenetitle, 0, 0, 1, 1);
	    HBox hbBtn = new HBox(10);
	    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
	    Button exit = createButton("Exit");
	    Button back = createButton("Back");
		Button home = createButton("Home");
		exit.setOnAction((event)-> {System.exit(0);});
	    home.setOnAction((event)-> {prim.setScene(main);});
	    back.setOnAction((event)-> {prim.setScene(main);});
	    hbBtn.getChildren().add(exit);
	    hbBtn.getChildren().add(home);
	    Label info = new Label("This is the Pick guru. This application walks you though the the process\nof picking a team. This is for less experienced users; to use the more\n experienced method then access it with the ~My Team~ menu located on the\n home page.");
	    grid.add(info, 0, 1);
	    Button button = createButton("Start");
	    button.setOnAction((event) -> {prim.setScene(creatQB(prim, "Guru"));});
	    grid.add(button, 0, 2);  
	    	
		
	    ScrollPane scrollPane = new ScrollPane(grid);
	    Scene teamStart = new Scene(scrollPane, 450, 375);
	    return teamStart;
	}
	
	
	
	
	
	
	public Scene creatQB(Stage prim, String q) {
		myTeam = new ArrayList<Player>();
		GridPane grid = new GridPane();
	    grid.setAlignment(Pos.CENTER);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(25, 25, 25, 25));
	    HBox hbBtn = new HBox(10);
	    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
	    Button exit = createButton("Exit");
		Button home = createButton("Home");
		exit.setOnAction((event)-> {if (Error() == true) {myTeam = new ArrayList<Player>(); System.exit(0);}});
	    home.setOnAction((event)-> {if (Error2() == true) {myTeam = new ArrayList<Player>(); prim.setScene(main);}});
	    hbBtn.getChildren().add(exit);
	    hbBtn.getChildren().add(home);
	    ArrayList<Player> topPlayers = new ArrayList<Player>();
	    Text scenetitle;
	    ScrollPane scrollPane = new ScrollPane(grid);
	    switch (q) {
		   
		   case "teamPick":
		scenetitle = new Text("Pick A Quarterback");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 1, 1);
	    topPlayers = nfl.printPlayerPosition(0, 4, 15, myTeam);
	    grid.add(hbBtn, 0, topPlayers.size()+1);
	    for (int r = 0; r < topPlayers.size(); r++) {
            Button button = createButton((topPlayers.get(r).getName()));
            Player p = topPlayers.get(r);
           button.setOnAction((event) -> {myTeam.add(p); prim.setScene(creatRB(prim, q));});
            grid.add(button, 0, (r+1));   
	    }
	    break;
	    
		   case "Guru":
			   	scenetitle = new Text("Pick A Quarterback");
			   	Label info = new Label("This is where you pick a Quarterback. To make it easy here are\n the top five QB's for this season.");
				scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
				grid.add(scenetitle, 0, 0, 1, 1);
				grid.add(info, 0,1);
			   topPlayers = nfl.printPlayerPosition(0, 4, 5, myTeam);
			    grid.add(hbBtn, 0, topPlayers.size()+3);
			    for (int r = 0; r < topPlayers.size(); r++) {
		            Button button = createButton((topPlayers.get(r).getName()));
		            Player p = topPlayers.get(r);
		           button.setOnAction((event) -> {myTeam.add(p); prim.setScene(creatRB(prim,q));});
		            grid.add(button, 0, (r+2)); 
			    }
			   break;
	    }
	    
	    
	  
	    Scene QBScene = new Scene(scrollPane, 450, 375);
	    return QBScene;
	}
	
	public Scene creatRB(Stage prim, String q) {
		GridPane grid = new GridPane();
	    grid.setAlignment(Pos.CENTER);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(25, 25, 25, 25));
	    HBox hbBtn = new HBox(10);
	    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
	    Button exit = createButton("Exit");
		Button home = createButton("Home");
		exit.setOnAction((event)-> {if (Error() == true) {myTeam = new ArrayList<Player>(); System.exit(0);}});
	    home.setOnAction((event)-> {if (Error2() == true) {myTeam = new ArrayList<Player>(); prim.setScene(main);}});
	    hbBtn.getChildren().add(exit);
	    hbBtn.getChildren().add(home);
	    ArrayList<Player> topPlayers;
	    Text scenetitle;
	    ScrollPane scrollPane = new ScrollPane(grid);
	    switch (q) {
		   
		   case "teamPick":
		scenetitle = new Text("Pick A Running Back");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 1, 1);
	    topPlayers = nfl.printPlayerPosition(0, 3, 15, myTeam);
	    grid.add(hbBtn, 0, topPlayers.size()+1);
	    for (int r = 0; r < topPlayers.size(); r++) {
            Button button = createButton((topPlayers.get(r).getName()));
            Player p = topPlayers.get(r);
           button.setOnAction((event) -> {myTeam.add(p); prim.setScene(creatWR1(prim, q));});
            grid.add(button, 0, (r+1));   
	    }
	    break;
	    
		   case "Guru":
			   	scenetitle = new Text("Pick A Running Back");
			   	Label info = new Label("This is where you pick a Running Back. To make it easy here are\n the top five RB's for this season.");
				scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
				grid.add(scenetitle, 0, 0, 1, 1);
				grid.add(info, 0,1);
			   topPlayers = nfl.printPlayerPosition(0, 3, 5, myTeam);
			    grid.add(hbBtn, 0, topPlayers.size()+3);
			    for (int r = 0; r < topPlayers.size(); r++) {
		            Button button = createButton((topPlayers.get(r).getName()));
		            Player p = topPlayers.get(r);
		           button.setOnAction((event) -> {myTeam.add(p); prim.setScene(creatWR1(prim,q));});
		            grid.add(button, 0, (r+2)); 
			    }
				   break;
	    }
	     
	    
	    Scene RBScene = new Scene(scrollPane, 450, 375);
	    return RBScene;
	}

	public Scene creatWR1(Stage prim, String q) {
		GridPane grid = new GridPane();
	    grid.setAlignment(Pos.CENTER);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(25, 25, 25, 25));
	    HBox hbBtn = new HBox(10);
	    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
	    Button exit = createButton("Exit");
		Button home = createButton("Home");
		exit.setOnAction((event)-> {if (Error() == true) {myTeam = new ArrayList<Player>(); System.exit(0);}});
	    home.setOnAction((event)-> {if (Error2() == true) {myTeam = new ArrayList<Player>(); prim.setScene(main);}});
	    hbBtn.getChildren().add(exit);
	    hbBtn.getChildren().add(home);
	    ArrayList<Player> topPlayers;
	    Text scenetitle;
	    switch (q) {
		   
		   case "teamPick":
		scenetitle = new Text("Pick Three Wide receivers");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 1, 1);
	    topPlayers = nfl.printPlayerPosition(0, 2, 15, myTeam);
	    grid.add(hbBtn, 0, topPlayers.size()+1);
	    for (int r = 0; r < topPlayers.size(); r++) {
            Button button = createButton((topPlayers.get(r).getName()));
            Player p = topPlayers.get(r);
           button.setOnAction((event) -> {myTeam.add(p); prim.setScene(creatWR2(prim, q));});
            grid.add(button, 0, (r+1));   
	    }
	    break;
	    
		   case "Guru":
			   	scenetitle = new Text("Pick Three Wide receivers");
			   	Label info = new Label("This is where you pick the Wide receivers. There are 3 WR's in a fantasy\n football team. To make it easy here are the top five WR's for this season.");
				scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
				grid.add(scenetitle, 0, 0, 1, 1);
				grid.add(info, 0,1);
			   topPlayers = nfl.printPlayerPosition(0, 2, 5, myTeam);
			    grid.add(hbBtn, 0, topPlayers.size()+3);
			    for (int r = 0; r < topPlayers.size(); r++) {
		            Button button = createButton((topPlayers.get(r).getName()));
		            Player p = topPlayers.get(r);
		           button.setOnAction((event) -> {myTeam.add(p); prim.setScene(creatWR2(prim,q));});
		            grid.add(button, 0, (r+2)); 
			    }
				   break;
	    }
	    
	    ScrollPane scrollPane = new ScrollPane(grid);
	    Scene WR1Scene = new Scene(scrollPane, 450, 375);
	    return WR1Scene;
	}
	
	public Scene creatWR2(Stage prim, String q) {
		GridPane grid = new GridPane();
	    grid.setAlignment(Pos.CENTER);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(25, 25, 25, 25));
	    HBox hbBtn = new HBox(10);
	    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
	    Button exit = createButton("Exit");
		Button home = createButton("Home");
		exit.setOnAction((event)-> {if (Error() == true) {myTeam = new ArrayList<Player>(); System.exit(0);}});
	    home.setOnAction((event)-> {if (Error2() == true) {myTeam = new ArrayList<Player>(); prim.setScene(main);}});
	    hbBtn.getChildren().add(exit);
	    hbBtn.getChildren().add(home);
	    ArrayList<Player> topPlayers;
	    Text scenetitle;
	    ScrollPane scrollPane = new ScrollPane(grid);
	    switch (q) {
		   
		   case "teamPick":
		scenetitle = new Text("Pick Two Wide receivers");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 1, 1);
	    topPlayers = nfl.printPlayerPosition(0, 2, 15, myTeam);
	    grid.add(hbBtn, 0, topPlayers.size()+1);
	    for (int r = 0; r < topPlayers.size(); r++) {
            Button button = createButton((topPlayers.get(r).getName()));
            Player p = topPlayers.get(r);
           button.setOnAction((event) -> {myTeam.add(p); prim.setScene(creatWR3(prim, q));});
            grid.add(button, 0, (r+1));   
	    }
	    break;
	    
		   case "Guru":
			   	scenetitle = new Text("Pick Two Wide receivers");
			   	Label info = new Label(myTeam.get(2).getName() + " was picked and removed from the list, here are five more.");
				scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
				grid.add(scenetitle, 0, 0, 1, 1);
				grid.add(info, 0,1);
			   topPlayers = nfl.printPlayerPosition(0, 2, 5, myTeam);
			    grid.add(hbBtn, 0, topPlayers.size()+3);
			    for (int r = 0; r < topPlayers.size(); r++) {
		            Button button = createButton((topPlayers.get(r).getName()));
		            Player p = topPlayers.get(r);
		           button.setOnAction((event) -> {myTeam.add(p); prim.setScene(creatWR3(prim,q));});
		            grid.add(button, 0, (r+2)); 
			    }
				   break;
	    }

	    
	    Scene WR2Scene = new Scene(scrollPane, 450, 375);
	    return WR2Scene;
	}
	
	public Scene creatWR3(Stage prim, String q) {
		GridPane grid = new GridPane();
	    grid.setAlignment(Pos.CENTER);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(25, 25, 25, 25));
	    HBox hbBtn = new HBox(10);
	    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
	    Button exit = createButton("Exit");
		Button home = createButton("Home");
		exit.setOnAction((event)-> {if (Error() == true) {myTeam = new ArrayList<Player>(); System.exit(0);}});
	    home.setOnAction((event)-> {if (Error2() == true) {myTeam = new ArrayList<Player>(); prim.setScene(main);}});
	    hbBtn.getChildren().add(exit);
	    hbBtn.getChildren().add(home);
	    ArrayList<Player> topPlayers;
	    Text scenetitle;
	    ScrollPane scrollPane = new ScrollPane(grid);
	    switch (q) {
		   
		   case "teamPick":
		scenetitle = new Text("Pick the Final Wide receiver");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 1, 1);
	    topPlayers = nfl.printPlayerPosition(0, 2, 15, myTeam);
	    grid.add(hbBtn, 0, topPlayers.size()+1);
	    for (int r = 0; r < topPlayers.size(); r++) {
            Button button = createButton((topPlayers.get(r).getName()));
            Player p = topPlayers.get(r);
           button.setOnAction((event) -> {myTeam.add(p); prim.setScene(creatTE(prim, q));});
            grid.add(button, 0, (r+1));   
	    }
	    break;
	    
		   case "Guru":
			   	scenetitle = new Text("Pick the Final Wide receiver");
			   	Label info = new Label(myTeam.get(2).getName() +" and " +myTeam.get(3).getName() +" were picked and removed from the\n list, here are five more for your last WB.");
				scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
				grid.add(scenetitle, 0, 0, 1, 1);
				grid.add(info, 0,1);
			   topPlayers = nfl.printPlayerPosition(0, 2, 5, myTeam);
			    grid.add(hbBtn, 0, topPlayers.size()+3);
			    for (int r = 0; r < topPlayers.size(); r++) {
		            Button button = createButton((topPlayers.get(r).getName()));
		            Player p = topPlayers.get(r);
		           button.setOnAction((event) -> {myTeam.add(p); prim.setScene(creatTE(prim,q));});
		            grid.add(button, 0, (r+2)); 
			    }
				   break;
	    }	    
	    

	    Scene WR3Scene = new Scene(scrollPane, 450, 375);
	    return WR3Scene;
	}
	
	public Scene creatTE(Stage prim, String q) {
		GridPane grid = new GridPane();
	    grid.setAlignment(Pos.CENTER);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(25, 25, 25, 25));
	    HBox hbBtn = new HBox(10);
	    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
	    Button exit = createButton("Exit");
		Button home = createButton("Home");
		exit.setOnAction((event)-> {if (Error() == true) {myTeam = new ArrayList<Player>(); System.exit(0);}});
	    home.setOnAction((event)-> {if (Error2() == true) {myTeam = new ArrayList<Player>(); prim.setScene(main);}});
	    hbBtn.getChildren().add(exit);
	    hbBtn.getChildren().add(home);
	    ArrayList<Player> topPlayers;
	    Text scenetitle;
	    ScrollPane scrollPane = new ScrollPane(grid);
	    switch (q) {
		   
		   case "teamPick":
		scenetitle = new Text("Pick A Tight End");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 1, 1);
	    topPlayers = nfl.printPlayerPosition(0, 1, 15, myTeam);
	    grid.add(hbBtn, 0, topPlayers.size()+1);
	    for (int r = 0; r < topPlayers.size(); r++) {
            Button button = createButton((topPlayers.get(r).getName()));
            Player p = topPlayers.get(r);
           button.setOnAction((event) -> {myTeam.add(p); prim.setScene(displayMyTeam(prim, q));});
            grid.add(button, 0, (r+1));   
	    }
	    break;
	    
		   case "Guru":
			   	scenetitle = new Text("Pick A Tight End");
			   	Label info = new Label("This is where you pick a Tight End. To make it easy here are the top five\n TE's for this season.");
				scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
				grid.add(scenetitle, 0, 0, 1, 1);
				grid.add(info, 0,1);
			   topPlayers = nfl.printPlayerPosition(0, 1, 5, myTeam);
			    grid.add(hbBtn, 0, topPlayers.size()+3);
			    for (int r = 0; r < topPlayers.size(); r++) {
		            Button button = createButton((topPlayers.get(r).getName()));
		            Player p = topPlayers.get(r);
		           button.setOnAction((event) -> {myTeam.add(p); prim.setScene(displayMyTeam(prim,q));});
		            grid.add(button, 0, (r+2)); 
			    }
				   break;
	    }	    

	    
	    scrollPane.setVvalue(0);
	    Scene TEScene = new Scene(scrollPane, 450, 375);
	    return TEScene;
	}
	
	
	public Scene displayMyTeam(Stage prim, String q) {
		saveData(myTeam);
		GridPane grid = new GridPane();
	    grid.setAlignment(Pos.CENTER);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(25, 25, 25, 25));
	    Text scenetitle = new Text("This is Your Team");
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
	    ScrollPane scrollPane = new ScrollPane(grid);
	    if (myTeam.size() == 0) {
	    	Label info = new Label("Looks Like you don't have a team yet, choose what you want to build you Team With:");
	    	grid.add(info, 0, 1);
	    	 Button button = createButton("Pick Guru");
	         button.setOnAction((event) -> {prim.setScene(creatQB(prim, "Guru"));});
	         grid.add(button, 0, 2); 
	         Button button2 = createButton("Experienced Team builder");
	         button2.setOnAction((event) -> {prim.setScene(creatQB(prim, "teamPick"));});
	         grid.add(button2, 0, 3); 
	    	
	    }
	    else {
	    Label info2 = new Label("Click on a player to get more stats on them.)");
	    grid.add(info2, 0, 1);
	    Label QB = new Label("Your Quarterback");
	    grid.add(QB, 0, 2);
	    Button button = createButton((myTeam.get(0).getName()));
        Player p = myTeam.get(0);
        String play = ("https://www.teamrankings.com/nfl/player/" + (p.getName()).toLowerCase().replaceAll( "\\s+", "-"));
        button.setOnAction((event) -> {createWindow(play);});
        grid.add(button, 0, 3); 
        
	    Label RB = new Label("Your Running back");
	    grid.add(RB, 0, 4);
	    Button button2 = createButton((myTeam.get(1).getName()));
        p = myTeam.get(1);
        String play2 = ("https://www.teamrankings.com/nfl/player/" + (p.getName()).toLowerCase().replaceAll( "\\s+", "-"));
        button2.setOnAction((event) -> {createWindow(play2);});
        grid.add(button2, 0, 5);
        
	    Label WR = new Label("Your Wide receivers");
	    grid.add(WR, 0, 6);
	    Button button3 = createButton((myTeam.get(2).getName()));
        p = myTeam.get(2);
        String play3 = ("https://www.teamrankings.com/nfl/player/" + (p.getName()).toLowerCase().replaceAll( "\\s+", "-"));
        button3.setOnAction((event) -> {createWindow(play3);});
        grid.add(button3, 0, 7);
        
        Button button4 = createButton((myTeam.get(3).getName()));
        p = myTeam.get(3);
        String play4 = ("https://www.teamrankings.com/nfl/player/" + (p.getName()).toLowerCase().replaceAll( "\\s+", "-"));
        button4.setOnAction((event) -> {createWindow(play4);});
        grid.add(button4, 0, 8);
        
        Button button5 = createButton((myTeam.get(4).getName()));
        p = myTeam.get(4);
        String play5 = ("https://www.teamrankings.com/nfl/player/" + (p.getName()).toLowerCase().replaceAll( "\\s+", "-"));
        button5.setOnAction((event) -> { createWindow(play5);});
        grid.add(button5, 0, 9);
        
	    Label TE = new Label("Your Tight End");
	    grid.add(TE, 0, 10);
	    Button button6 = createButton((myTeam.get(5).getName()));
        p = myTeam.get(5);
        String play6 = ("https://www.teamrankings.com/nfl/player/" + (p.getName()).toLowerCase().replaceAll( "\\s+", "-"));
        button6.setOnAction((event) -> {createWindow(play6);});
        grid.add(button6, 0, 11);
	    
		
    	Label info = new Label("If you want to build a new team then pick one of the below buttons\n with the method you want to use to build it with.");
    	grid.add(info, 0, 13);
    	 Button button7 = createButton("Pick Guru");
         button7.setOnAction((event) -> {if (Error3() == true) {prim.setScene(creatQB(prim, "Guru"));myTeam = new ArrayList<Player>(); saveData(myTeam);}});
         grid.add(button7, 0, 14); 
         Button button8 = createButton("Experienced Team builder");
         button8.setOnAction((event) -> {if (Error3() == true) {prim.setScene(creatQB(prim, "teamPick")); myTeam = new ArrayList<Player>(); saveData(myTeam);}});
         grid.add(button8, 0, 15); 
         grid.add(hbBtn, 0, 16);
	    }
	    
	    Scene showMyTeam = new Scene(scrollPane, 450, 375);
	    return showMyTeam;
	}
	
	public void createWindow(String e) {
		Stage playerStats = new Stage();
		playerStats.setTitle("Player Stats");
        WebView webView = new WebView();
        final WebEngine webEngine = webView.getEngine();
        webEngine.load(e);
        playerStats.show();
        ScrollPane scrollPane = new ScrollPane(webView);
	    Scene showMyTeam = new Scene(scrollPane, 450, 375);
	    playerStats.setScene(showMyTeam);
	}
	
	public Boolean Error() {
	Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to exit? This will delete the team you are building.", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
	alert.showAndWait();

	if (alert.getResult() == ButtonType.YES) {
	    return true;
	}
	return false;
	}
	
	public Boolean Error2() {
		Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to go home? This will delete the team you are building.", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
		alert.showAndWait();

		if (alert.getResult() == ButtonType.YES) {
		    return true;
		}
		return false;
		}
	
	public Boolean Error3() {
		Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to build a new team? This will delete your old team.", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
		alert.showAndWait();

		if (alert.getResult() == ButtonType.YES) {
		    return true;
		}
		return false;
		}
	public Boolean Error4() {
		if (myTeam.size() != 0) {
		Alert alert = new Alert(AlertType.CONFIRMATION, "Looks like you already have a Team. Using Pick Guru will delete your old team. Are you sure you want to use Pick Guru?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
		alert.showAndWait();

		if (alert.getResult() == ButtonType.YES) {
		    return true;
		}
		else {
		return false;
		}
		}
		else {
		return true;	
		}
		}
	
	public static void saveData(ArrayList<Player> e) {
		try {
			FileOutputStream fileOut = new FileOutputStream("YourTeam.ser");
			if (e.size() == 0) {
				fileOut.write(("").getBytes());
				fileOut.close();
			}
			else {
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(e);
			fileOut.close();
			}
			
		}
		catch (IOException ex){
			ex.printStackTrace();
		}
		
	}

	public static ArrayList<Player> loadData() {
		FileInputStream fileIn = null;
		ObjectInputStream objIn= null;
		ArrayList<Player> player = new ArrayList<Player>();

		try {
			fileIn = new FileInputStream("YourTeam.ser");
			objIn = new ObjectInputStream(fileIn);
			player = (ArrayList<Player>) objIn.readObject();
			fileIn.close();
		}
		catch (IOException ex){
			player = new ArrayList<Player>();
			//ex.printStackTrace();
		}
		catch (ClassNotFoundException c) {
			player = new ArrayList<Player>();
			//c.printStackTrace();
		}
		return player;
	}
	
	
	
	
}
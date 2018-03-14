/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazelab;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author tcwilson
 */
public class Maze extends Application implements EventHandler {
    private Button [][] buttons;
    private Button btn;
    private int rows, cols;
    private BorderPane pane;
    private Scene scene;
    
    @Override
    public void start(Stage stage) throws Exception {
        pane = new BorderPane();
        pane.setCenter(createCenterPane());
        pane.setBottom(HBox());
        scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
        
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void start(){
        launch();
    }
  
private Pane createCenterPane(){
    GridPane x = new GridPane();
    int y = 10; //Integer.parseInt(JOptionPane.showInputDialog("Number of Rows"));
    int z = 10;//Integer.parseInt(JOptionPane.showInputDialog("Number of Cols"));
    rows = y;
    cols =z;
    buttons = new Button[rows][cols];
    for(int i = 0; i<rows; i++){
        for(int j=0; j<buttons[i].length; j++){
            Button butt = new Button();
           butt.setStyle("-fx-font: 30 arial; -fx-base: blue;");
           butt.setOnAction(this);
//           butt.prefHeight(30);
//           butt.prefWidth(j)
           x.add(butt, i, j);
           buttons[i][j]= butt;
        }
}
    
    return x;
}
    

    private FlowPane HBox() {
       FlowPane hbox = new FlowPane();
       Button button1 = new Button("Save");
    Button button2 = new Button("Exit");
  hbox.getChildren().add(button1);
  hbox.getChildren().add(button2);
    return hbox;
  //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   //Returns the Maze character associated with the given button   
private char getColorChar(Button b )
    {
         if (b.getStyle().indexOf("blue") > -1) {
                    return '0';
                }
                else if (b.getStyle().indexOf("white") > -1) {
                    return '1';
                }
                else if (b.getStyle().indexOf("green") > -1) {
                    return 'S';
                }
                else {
                    return 'E';
                }
    }
    
    //Inner class lister for buttons
    //public class MyHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle( Event e)
        {
	    //e.getSource() returns the button that was clicked.
            Button b = (Button) e.getSource();

            if (b.getText().equals("Save")) {
                
                

//create output file

            }
            else if (b.getText().equals("Exit")) {
                //exit the application

            }
            else { //a maze button was clicked

                char val = getColorChar(b);
                if (val == '0') {  //the button is currently blue so change it to white
                    b.setStyle("-fx-font: 30 arial; -fx-base: white;");
                    
                }
                else if (val == '1') {
                    b.setStyle("-fx-font: 30 arial; -fx-base: green;");
                   
                }
                else if (val == 'S') {
                    b.setStyle("-fx-font: 30 arial; -fx-base: red;");
                    
                }
                else {
                    b.setStyle("-fx-font: 30 arial; -fx-base: blue;");
                }
                
            
            }
        }
    //}

 
    
}

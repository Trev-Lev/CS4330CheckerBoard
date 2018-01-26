/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4330checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Trevor
 */
public class CheckerBoardFXMLController implements Initializable, Startable {
    
    private Stage stage;
    private double boardWidth;
    private double boardHeight;
    
    private CheckerBoard checkerBoard;
    
    // Constants
    public static final int DEFAULTROWCOL = 8;
    public static final int DEFAULTHEIGHT = 375;
    public static final int DEFAULTWIDTH = 600;
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private VBox vbox;
    
    @FXML 
    public void handle16x16(ActionEvent event) {
        checkerBoard.setNumRows(16);
        checkerBoard.setNumCols(16);
        checkerBoard.build();
    }
    
    @FXML 
    public void handle10x10(ActionEvent event) {
        checkerBoard.setNumRows(10);
        checkerBoard.setNumCols(10);
        checkerBoard.build();
    }
    
    @FXML 
    public void handle8x8(ActionEvent event) {
        checkerBoard.setNumRows(8);
        checkerBoard.setNumCols(8);
        checkerBoard.build();
    }
    
    @FXML 
    public void handle3x3(ActionEvent event) {
        checkerBoard.setNumRows(3);
        checkerBoard.setNumCols(3);
        checkerBoard.build();
    }
    
    @FXML
    public void handleDefaultSwap(ActionEvent event) {
        checkerBoard.setColors(Color.RED, Color.BLACK);
    }
    
    @FXML
    public void handleBlueSwap(ActionEvent event) {
        checkerBoard.setColors(Color.SKYBLUE, Color.DARKBLUE);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        checkerBoard = new CheckerBoard(DEFAULTROWCOL, DEFAULTROWCOL, DEFAULTWIDTH, DEFAULTHEIGHT);
        checkerBoard.setVBox(vbox);
        checkerBoard.setStage(stage);
        checkerBoard.build();
    }
    

}

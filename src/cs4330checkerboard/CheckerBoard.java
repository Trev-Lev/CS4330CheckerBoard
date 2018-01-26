/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4330checkerboard;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Trevor
 */
public class CheckerBoard {
    
    // Root: null if build has not been called yet
    private AnchorPane anchorPane = null;
    
    // Reference to stage
    private Stage stage;
    
    // Checkerboard fields
    private int numRows;
    private int numCols;
    private double width;
    private double height;
    private Color lightColor = Color.RED;
    private Color darkColor = Color.BLACK;
    
    // For formatting reference
    private VBox vbox;
    
    // Fields to be calculated based off of last resize
    private int rectangleWidth;
    private int rectangleHeight;
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.width = boardWidth;
        this.height = boardHeight;
    }
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor) {
        this(numRows, numCols, boardWidth, boardHeight);
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    // Returns board UI - AnchorPane as root
    public AnchorPane build() {
        if (anchorPane == null) {
            anchorPane = new AnchorPane();
            refresh();
            setResizable();
            vbox.getChildren().add(anchorPane);
            return anchorPane;
        } else {
            vbox.getChildren().remove(anchorPane);
            anchorPane.getChildren().clear();
            refresh();
            vbox.getChildren().add(anchorPane);
            return anchorPane;
        }
    }
    
    public AnchorPane getBoard() {
        if (anchorPane == null) return null;
        else return build();
    }
    
    private void refresh() {
        
        // Update the width/height based on size of application
        anchorPane.setPrefSize(width, height);
        
        // Refresh: refresh the state of the board.
        double rectWidth = Math.ceil(width / numCols);
        double rectHeight = Math.ceil(height / numRows);
        
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                Rectangle rect = new Rectangle(rectWidth*col, rectHeight*row, rectWidth, rectHeight);
                if ((row + col) % 2 == 0)
                    rect.setFill(lightColor);
                else 
                    rect.setFill(darkColor);
                anchorPane.getChildren().add(rect);
            }
        }
    }
    
    public void setColors(Color lightColor, Color darkColor) {
        this.lightColor = lightColor;
        this.darkColor = darkColor;
        build();
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }
    
    public void setNumCols(int numCols) {
        this.numCols = numCols;
    }
    
    public void setVBox(VBox vbox) {
        this.vbox = vbox;
    }
    
    public int getNumRows() {
        return numRows;
    }
    
    public int getNumCols() {
        return numCols;
    }
    
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }
    
    public Color getLightColor() {
        return lightColor;
    }
    
    public Color getDarkColor() {
        return darkColor;
    }
    
    public int getRectangleWidth() {
        return rectangleWidth;
    }
    
    public int getRectangleHeight() {
        return rectangleHeight;
    }
    
    private void setResizable() {
        
        // Add resizable listener
        stage.widthProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                width = (double)newValue;
                build();
            }
        });
        
        stage.heightProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                height = (double)newValue;
                height = height - 50; // 50 offset
                build();
            }
        });
        
    }
    
}

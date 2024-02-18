package com.colorslide;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {

    private Label colorLabel;

    private Slider redSlider;
    private Slider greenSlider;
    private Slider blueSlider;
    private Slider opacitySlider;

    @Override
    public void start(Stage primaryStage) {
        colorLabel = new Label("Color");
        colorLabel.setFont(Font.font(20)); // Set font size to 20

        redSlider = createSlider("Red", 0, 255);
        greenSlider = createSlider("Green", 0, 255);
        blueSlider = createSlider("Blue", 0, 255);
        opacitySlider = createSlider("Opacity", 0, 100);

        redSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor());
        greenSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor());
        blueSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor());
        opacitySlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor());

        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-padding: 20;");
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(new Label("Red"), 0, 0);
        gridPane.add(redSlider, 1, 0);
        gridPane.add(new Label("Green"), 0, 1);
        gridPane.add(greenSlider, 1, 1);
        gridPane.add(new Label("Blue"), 0, 2);
        gridPane.add(blueSlider, 1, 2);
        gridPane.add(new Label("Opacity"), 0, 3);
        gridPane.add(opacitySlider, 1, 3);

        gridPane.add(colorLabel, 0, 4, 2, 1);

        Scene scene = new Scene(gridPane, 300, 250);
        primaryStage.setTitle("Color Selector");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Slider createSlider(String label, double min, double max) {
        Slider slider = new Slider(min, max, 0);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit((max - min) / 10);
        slider.setBlockIncrement(1);

        return slider;
    }

    private void updateColor() {
        int red = (int) redSlider.getValue();
        int green = (int) greenSlider.getValue();
        int blue = (int) blueSlider.getValue();
        double opacity = opacitySlider.getValue() / 100.0;

        Color color = Color.rgb(red, green, blue, opacity);
        colorLabel.setText("Color");
        colorLabel.setTextFill(color);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

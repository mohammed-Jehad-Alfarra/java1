/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package as2q2;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author DAMIN
 */
public class as2q2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    Label label, newTemp;
    TextField field;
    HBox FkTemp;
    RadioButton Fahrenheit_btn, Kelvin_btn;
    VBox AOHBox;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Temperature Converter");
        label = new Label("Enter Celsius Temperature :");
        label.setAlignment(Pos.CENTER);

        field = new TextField();
        field.setAlignment(Pos.CENTER);

        Fahrenheit_btn = new RadioButton("Fahrenheit");
        Kelvin_btn = new RadioButton("Kelvin");
        FkTemp = new HBox(10, Fahrenheit_btn, Kelvin_btn);
        FkTemp.setAlignment(Pos.CENTER);

        ToggleGroup myToggleGroup = new ToggleGroup();
        Fahrenheit_btn.setToggleGroup(myToggleGroup);
        Kelvin_btn.setToggleGroup(myToggleGroup);

        newTemp = new Label();
        newTemp.setAlignment(Pos.CENTER);

        Fahrenheit_btn.setOnAction(F -> {
            if (Fahrenheit_btn.isSelected()) {
                if (!field.getText().isEmpty()) {
                    double Celsius = Double.parseDouble(field.getText());

                    double Fahrenheit = Celsius * 9 / 5 + 32;
                    newTemp.setText(" Trmperatyure  is : " + Fahrenheit);

                } else {
                    newTemp.setText("");
                }
            }
        });

        Kelvin_btn.setOnAction(K -> {

            if (Kelvin_btn.isSelected()) {
                if (!field.getText().equals("")) {
                    double Celsius = Double.parseDouble(field.getText());
                    double Kelvin = Celsius + 273.15;
                    newTemp.setText("New Trmperature in is : " + Kelvin);
                } else {
                    newTemp.setText("");
                }

            }
        });

        AOHBox = new VBox(20, label, field, FkTemp, newTemp);
        AOHBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(AOHBox, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

}

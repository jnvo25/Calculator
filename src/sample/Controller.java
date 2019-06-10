package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Label result_label;

    private CalculatorModel Calculator;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Calculator = new CalculatorModel();
    }

    public void clearButton_pressed(ActionEvent actionEvent) {
        Calculator.clear();
        result_label.setText("");
    }

    public void changeSignButton_pressed(ActionEvent actionEvent) {
        Calculator.changeSign();
        result_label.setText(Calculator.getCurrentNumber());
    }

    public void operatorButton_pressed(ActionEvent actionEvent) {
        Button button = (Button)actionEvent.getSource();
        Calculator.saveNumber();
        Calculator.addOperator(button.getText());
        result_label.setText("");
    }

    public void numberButton_pressed(ActionEvent actionEvent) {
        Button button = (Button)actionEvent.getSource();
        Calculator.addDigit(Integer.parseInt(button.getText()));
        result_label.setText(Calculator.getCurrentNumber());
    }

    public void decimalButton_pressed(ActionEvent actionEvent) {
        Calculator.addDecimal();
        result_label.setText(Calculator.getCurrentNumber());
    }

    public void equalButton_pressed(ActionEvent actionEvent) {
        Calculator.saveNumber();
        double result = Calculator.calculate();
        if(result == (long) result)
            // TODO:: Round to 5th decimal place
            result_label.setText(String.format("%d",(long)result));
        else
            result_label.setText(String.format("%s",result));
        Calculator.clear();
    }
}

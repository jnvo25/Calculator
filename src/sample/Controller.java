package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.text.DecimalFormat;
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
        update_result(Double.parseDouble(Calculator.getCurrentNumber()));
    }

    public void operatorButton_pressed(ActionEvent actionEvent) {
        Button button = (Button)actionEvent.getSource();
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
        update_result(result);
        Calculator.clear();
    }

    private void update_result(double result) {
        if(result == (long) result) {
            // If whole number
            result_label.setText(String.format("%d", (long) result));
        } else {
            // If have digits after decimals
            result_label.setText(String.format("%.6f",result));
        }
    }
}

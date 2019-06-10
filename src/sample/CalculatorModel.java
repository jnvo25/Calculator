package sample;

class CalculatorModel {

    private Double term1, term2, result;
    private String operator;
    private StringBuilder currentNumber;

    CalculatorModel() {
        currentNumber = new StringBuilder();
    }

    String getCurrentNumber() {
        return currentNumber.toString();
    }

    double calculate() {
        System.out.println(term1 + " " + term2);
        if(term1 != null && term2 != null) {
            switch (operator) {
                case "+":
                    result = term1 + term2;
                    break;
                case "-":
                    result = term1 - term2;
                    break;
                case "X":
                    result = term1 * term2;
                    break;
                case "/":
                    result = term1 / term2;
                    break;
                case "%":
                    result = term1 % term2;
                    break;
                default:
                    result = 0.0;
                    break;
            }
        } else if(term1 != null)
            return term1;
        else result = 0.0;
            return result;
    }

    void clear() {
        term1 = null;
        term2 = null;
        operator = null;
        currentNumber = new StringBuilder();
    }

    void addOperator(String passedOperator) {
        operator = passedOperator;
        saveNumber();

        if(term1 != null && term2 != null) {
            calculate();
            term1 = result;
        }
    }

    // Functions to create number
    void addDigit(int digit) {
        currentNumber.append(digit);
    }

    void addDecimal() {
        if(currentNumber.indexOf(".") == -1)
            currentNumber.append('.');
    }

    void changeSign() {
        if(currentNumber.length() == 0 && result != null)
            currentNumber.append(result);
        if(currentNumber.charAt(0) == '-')
            currentNumber.deleteCharAt(0);
        else
            currentNumber.insert(0,"-");
    }

    void saveNumber() {
        if(currentNumber.length() != 0) {
            if(term1 == null)
                term1 = Double.parseDouble(currentNumber.toString());
            else
                term2 = Double.parseDouble(currentNumber.toString());
        } else if(term1 == null && result != null) {
            term1 = result;
        }
        currentNumber = new StringBuilder();
    }



}

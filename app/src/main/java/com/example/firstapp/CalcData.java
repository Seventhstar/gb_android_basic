package com.example.firstapp;

public class CalcData {

    enum OPERATORS {PLUS, MINUS, DIVIDE, MULTIPLY, PERCENT, EQUAL}

    Double result;
    Double currentNumber;
    OPERATORS lastOperator;
    boolean firstOperation;
    int afterPoint;
    int currentAfterPoint;
    boolean lastInputIsOperator;

    public CalcData() {
        clear();
    }

    public String getStingCurrent() {
        return currentNumber.toString();
    }

    public void setLastOperator(OPERATORS o) {
//        if (lastOperator == null) result = currentNumber;
        if (!lastInputIsOperator) calculate();
        lastOperator = o;
        lastInputIsOperator = true;
    }

    public String calculate() {
        //if (lastOperator != null) {
        switch (lastOperator) {
            case EQUAL:
                if (firstOperation) result = currentNumber;
                break;
            case PLUS:
                result += currentNumber;
                break;
            case MINUS:
                result -= currentNumber;
                break;
            case DIVIDE:
                result /= currentNumber;
                break;
            case PERCENT:
                break;
            case MULTIPLY:
                result *= currentNumber;
                break;
        }
        //}
        String res = getStingResult();
        if (lastOperator != null) firstOperation = false;
        return res;
    }

    public String getStingResult() {
        if (firstOperation) return currentNumber.toString();
        return printNumber(result, afterPoint);
    }

    public String addNumber(double number) {
        if (lastInputIsOperator) {
            currentNumber = 0.0;
            currentAfterPoint = 0;
            lastInputIsOperator = false;
        }
        if (currentNumber == 0.0) {
            currentNumber = number;
        } else {
            if (afterPoint == 0) {
                currentNumber *= 10;
            } else {
                for (int i = 0; i < currentAfterPoint; i++) {
                    number /= 10;
                }
                currentAfterPoint++;
            }
            currentNumber += number;
        }
        if (currentAfterPoint > afterPoint) afterPoint = currentAfterPoint;
        return printNumber(currentNumber, currentAfterPoint);
    }

    public String printNumber(double number, int outFormat) {
        int format = outFormat;
        if (format == -1) format = afterPoint - 1;
        if (format < 1) format = 1;
        return String.format("%." + format + "f", number);
    }

    public void clear() {
        currentNumber = 0.0;
        result = 0.0;
        afterPoint = 0;
        currentAfterPoint = 0;
        firstOperation = true;
        lastInputIsOperator = true;
        lastOperator = OPERATORS.EQUAL;
    }

    public void setPoint() {
        currentAfterPoint = 1;
    }
}

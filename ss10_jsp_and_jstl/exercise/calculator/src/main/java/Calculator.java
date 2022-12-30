public class Calculator {
    public static double Calculator(double firstOperand, double secondOperand, char operator) {
        switch (operator) {
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;
            case '*':
                return firstOperand * secondOperand;
            case '/':
                if (secondOperand != 0) {
                    return firstOperand / secondOperand;
                } else {
                    throw new RuntimeException("cannot be divided by zero");
                }
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}

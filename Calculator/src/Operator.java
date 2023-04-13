public class Operator {
    public static double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    System.out.println("Cannot divide by zero.");
                    return 0;
                }
                return num1 / num2;
            default:
                return 0;
        }
    }
}
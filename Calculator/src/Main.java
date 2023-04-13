import java.util.Scanner;

public class Main {
    public static void show() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constants.WELCOME_MESSAGE);
        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Perform a calculation");
            System.out.println("2. Exit");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                performCalculation();
            } else if (choice.equals("2")) {
                System.out.println(Constants.GOODBYE_MESSAGE);
                break;
            } else {
                System.out.println(Constants.INVALID_CHOICE_MESSAGE);
            }
        }
        scanner.close();
    }

    private static void performCalculation() {
        try (Scanner scanner = new Scanner(System.in)) {
            double num1, num2;
            String operator;
            while (true) {
                System.out.println(Constants.ENTER_NUMBER_MESSAGE);
                num1 = scanner.nextDouble();
                scanner.nextLine(); // Consume el caracter de nueva línea
                System.out.println(Constants.ENTER_OPERATOR_MESSAGE);
                operator = scanner.nextLine();
                if (!Validator.isValidOperator(operator)) {
                    System.out.println(Constants.INVALID_OPERATOR_MESSAGE);
                    continue;
                }
                System.out.println(Constants.ENTER_NUMBER_MESSAGE);
                num2 = scanner.nextDouble();
                scanner.nextLine(); // Consume el caracter de nueva línea
                if (!Validator.isValidNumber(num2)) {
                    System.out.println(Constants.INVALID_NUMBER_MESSAGE);
                    continue;
                }
                double result = Operator.calculate(num1, num2, operator);
                System.out.println("Result: " + result);
                System.out.println(Constants.ANOTHER_CALCULATION_MESSAGE);
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("n")) {
                    break;
                }else if(choice.equalsIgnoreCase("y")){
                    continue;
                }
                scanner.close();
        }
    }
}
    // Intento de mejora el código de la calculadora, pero no funciona del todo
    private static void performCalculationEnhanced() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constants.ENTER_EXPRESSION_MESSAGE);
        String expression = scanner.nextLine();
        String[] terms = expression.split("\\s+");
        for (int i = 0; i < terms.length; i++) {
            if (Validator.isValidOperator(terms[i])) {
                if (i == 0 || i == terms.length - 1 || !Validator.isValidNumberOfTerm(terms[i - 1]) || !Validator.isValidNumberOfTerm(terms[i + 1])) {
                    System.out.println(Constants.INVALID_EXPRESSION_MESSAGE);
                    return;
                }
                double num1 = Double.parseDouble(terms[i - 1]);
                double num2 = Double.parseDouble(terms[i + 1]);
                String operator = terms[i];
                double result = Operator.calculate(num1, num2, operator);
                terms[i + 1] = Double.toString(result);
            }
        }
        System.out.println("Result: " + terms[terms.length - 1]);
        scanner.close();
}
   
    public static void main(String[] args) {
        show();
    }
}
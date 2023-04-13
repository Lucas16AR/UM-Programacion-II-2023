public class Validator {
    public static boolean isValidNumber(double num) {
        return !Double.isNaN(num) && !Double.isInfinite(num);
    }

    public static boolean isValidNumberOfTerm(String numStr) {
        try {
            double num = Double.parseDouble(numStr);
            return !Double.isNaN(num) && !Double.isInfinite(num);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidOperator(String operator) {
        return operator.matches("[+\\-*/]");
    }
}
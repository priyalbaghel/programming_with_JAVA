class Calculator {
    static int calculationCount = 0;

    // Overloaded method for integer addition
    int add(int a, int b) {
        calculationCount++;
        return a + b;
    }

    // Overloaded method for decimal addition
    double add(double a, double b) {
        calculationCount++;
        return a + b;
    }

    // Static method to display total calculations
    static void displayCount() {
        System.out.println("Total Calculations: " + calculationCount);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("Integer Addition: " + calc.add(15, 25));
        System.out.println("Decimal Addition: " + calc.add(12.5, 7.8));

        Calculator.displayCount();
    }
}

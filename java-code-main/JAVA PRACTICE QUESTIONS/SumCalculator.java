class SumCalculator {
    public int sum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        SumCalculator calc = new SumCalculator();
        System.out.println(calc.sum(10, 20));
    }
}

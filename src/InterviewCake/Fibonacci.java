package InterviewCake;

public class Fibonacci {
    public static int getFibonacci(int n) {
        int fibonacciMinusTwo = 1;
        int fibonacciMinusOne = 1;
        for (int i = 2; i <= n; i++) {
            int newFibonacci = fibonacciMinusTwo + fibonacciMinusOne;
            fibonacciMinusTwo = fibonacciMinusOne;
            fibonacciMinusOne = newFibonacci;
        }
        return fibonacciMinusOne;
    }
    public static void main(String[] args) {
        System.out.println(getFibonacci(6));
    }
}

//*    T.C. = O(n^2)
//*    S.C. = O(n)

public class Fib_Recursive {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void printFibonacciSeries(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    public static void main(String[] args) {
        int n = 10; 
        printFibonacciSeries(n);
    }
}

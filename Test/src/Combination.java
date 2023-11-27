public class Combination {
    public static void main(String[] args) {
        System.out.println(combinationUsingFactorial(10,3));
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int combinationUsingFactorial(int n, int k) {
        return factorial(n) / ( factorial(k) * factorial(n -k));
    }
}

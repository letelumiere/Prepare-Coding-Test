public class practice {
    public static int factorial(int n){
        if(n<2) return n;
        else return n*factorial(n-1);
    }

    public static int fibonacci(int n){
        if(n<2) return n;
        else return fibonacci(n-1) + fibonacci(n-2);
    }
}

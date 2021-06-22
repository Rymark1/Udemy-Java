package com.ryanmark;

public class Series {

    public static int nSum(int n){
        if (n < 0)
            return 0;
        int sum = 0;
        for (int i = 0; i <=n;i++){
            sum += i;
        }
        return sum;
    }

    public static int factorial(int n){
        if (n <= 1)
            return 1;
        int factorial = 1;
        for (int i = 2; i <= n; i++){
            factorial *= i;
        }
        return factorial;
    }

    public static int fibonacci(int n){
        if (n <= 1)
            return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
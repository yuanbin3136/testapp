package com.wind.yuanbin.testapp;

public class Test {
    public static void main(String[] args){
        nineTnine();
    }

    private static void nineTnine() {
        for(int i = 1;i <= 9;i++){
            for (int k = 1;k <= i;k++){
                System.out.print(i + " * " + k + " = " + i * k + "\t");
            }
            System.out.println();
        }
    }
}

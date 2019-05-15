package com.wind.yuanbin.testapp;

import java.util.Random;

public class Test {
    public static void main(String[] args){
        nineTnine();
        sort2();
    }

    private static void nineTnine() {
        for(int i = 1;i <= 9;i++){
            for (int k = 1;k <= i;k++){
                System.out.print(i + " * " + k + " = " + i * k + "\t");
            }
            System.out.println();
        }
    }

    private static void sort1(){
        Random random = new Random();
        int [] a = new int[10];
        for (int i = 0;i<a.length;i++){
            a[i] = random.nextInt(20);
            out(a[i] + ",");
        }
        outLine("");
        for (int i = 0 ;i < a.length - 1;i ++){
            for (int k = 0;k < a.length - i - 1;k ++){
                if (a[k] > a[k + 1]){
                    int temp = a[k];
                    a[k] = a[k + 1];
                    a[k + 1] = temp;
                }
            }
            out(a);
        }
    }

    private static void sort2(){
        Random random = new Random();
        int [] a = new int[20];
        for (int i = 0;i<a.length;i++){
            a[i] = random.nextInt(50);
            out(a[i] + ",");
        }
        outLine("");
        for (int i = 0;i < a.length - 1;i ++){
            int index = 0;
            for (int k = 1; k < a.length - i - 1;k ++){
                if (a[k] > a[index]){
                    index = k;
                }
            }
            int maxIndex = a.length - 1 - i;
            if (maxIndex != index){
                int temp = a[maxIndex];
                a[maxIndex] = a[index];
                a[index] = temp;
            }
            out(a);
        }
    }

    public static void out(int [] a){
        for (int i:
             a) {
            out(i + ",");
        }
        outLine("");
    }
    public static void out(Object o){
        System.out.print(o);
    }

    public static void outLine(Object o){
        System.out.println(o);
    }
}

package com.wind.yuanbin.testapp;

import java.util.Random;

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
    public static void sort(int arr[], int low, int high) {
        int l = low;
        int h = high;
        int povit = arr[low];

        while (l < h) {
            while (l < h && arr[h] >= povit)
                h--;
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                l++;
            }
            while (l < h && arr[l] <= povit)
                l++;
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                h--;
            }
        }
        out("  l=" + (l + 1) + "h=" + (h + 1) + "povit=" + povit + "\n");
        if (l > low) sort(arr, low, l - 1);
        if (h < high) sort(arr, l + 1, high);
    }
    public static void sort(Integer arr[], int low, int high) {
        int l = low;
        int h = high;
        int povit = arr[low];

        while (l < h) {
            while (l < h && arr[h] >= povit)
                h--;
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                l++;
//                for (int x : arr) {
//                    L.outSingleLine(x);
//                }
//                L.out("");
            }
            while (l < h && arr[l] <= povit)
                l++;
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                h--;
//                for (int x : arr) {
//                    L.outSingleLine(x);
//                }
//                L.out("");
            }
        }
        if (l > low) sort(arr, low, l - 1);
        if (h < high) sort(arr, l + 1, high);
    }
    /*//////////////////////////方式二////////////////////////////////*/
//更高效点的代码：
    public static <T extends Comparable<?super T>> T[] quickSort1(T[] targetArr, int start, int end) {
        int i = start + 1, j = end;
        T key = targetArr[start];
//        SortUtil<T> sUtil = new SortUtil<T>();

        if (start >= end) return (targetArr);


        /*从i++和j--两个方向搜索不满足条件的值并交换
         *
         *条件为：i++方向小于key，j--方向大于key
         */
        while (true) {
            while (targetArr[j].compareTo(key) > 0) j--;
            while (targetArr[i].compareTo(key) < 0 && i < j) i++;
            if (i >= j)
                break;

            // TODO
//            sUtil.swap(targetArr, i, j);
            if (targetArr[i] == key) {
                j--;
            } else {
                i++;
            }
        }

        /*关键数据放到‘中间’*/
        // TODO
//        sUtil.swap(targetArr, start, j);

        if (start < i - 1) {
            quickSort1(targetArr, start, i - 1);
        }
        if (j + 1 < end) {
            quickSort1(targetArr, j + 1, end);
        }

        return targetArr;
    }
    /*//////////////方式三：减少交换次数，提高效率/////////////////////*/
    public static <T extends Comparable<?super T>> void quickSort(T[] targetArr, int start, int end) {
        int i = start, j = end;
        T key = targetArr[start];

        while (i < j) {
            /*按j--方向遍历目标数组，直到比key小的值为止*/
            while (j > i && targetArr[j].compareTo(key) >= 0) {
                j--;
            }
            if (i < j) {
                /*targetArr[i]已经保存在key中，可将后面的数填入*/
                targetArr[i] = targetArr[j];
                i++;
            }
            /*按i++方向遍历目标数组，直到比key大的值为止*/
            while (i < j && targetArr[i].compareTo(key) <= 0)
                /*此处一定要小于等于零，假设数组之内有一亿个1，0交替出现的话，而key的值又恰巧是1的话，那么这个小于等于的作用就会使下面的if语句少执行一亿次。*/ {
                i++;
            }
            if (i < j) {
                /*targetArr[j]已保存在targetArr[i]中，可将前面的值填入*/
                targetArr[j] = targetArr[i];
                j--;
            }
        }
        /*此时i==j*/
        targetArr[i] = key;

        /*递归调用，把key前面的完成排序*/
//        L.out(" I" + i + " j" + j);
        if (start < i){
            quickSort(targetArr, start, i - 1);
        }
        if (end > j){
            /*递归调用，把key后面的完成排序*/
            quickSort(targetArr, j + 1, end);
        }
    }
    public static void quickSort(Integer[] targetArr, int start, int end) {
        int i = start, j = end;
        Integer key = targetArr[start];

        while (i < j) {
            /*按j--方向遍历目标数组，直到比key小的值为止*/
            while (j > i && targetArr[j] >= (key)) {
                j--;
            }
            if (i < j) {
                /*targetArr[i]已经保存在key中，可将后面的数填入*/
                targetArr[i] = targetArr[j];
                i++;
            }
            /*按i++方向遍历目标数组，直到比key大的值为止*/
            while (i < j && targetArr[i] >= (key))
                /*此处一定要小于等于零，假设数组之内有一亿个1，0交替出现的话，而key的值又恰巧是1的话，那么这个小于等于的作用就会使下面的if语句少执行一亿次。*/ {
                i++;
            }
            if (i < j) {
                /*targetArr[j]已保存在targetArr[i]中，可将前面的值填入*/
                targetArr[j] = targetArr[i];
                j--;
            }
        }
        /*此时i==j*/
        targetArr[i] = key;

        /*递归调用，把key前面的完成排序*/
//        L.out(" I" + i + " j" + j);
        if (start < i){
            quickSort(targetArr, start, i - 1);
        }
        if (end > j){
            /*递归调用，把key后面的完成排序*/
            quickSort(targetArr, j + 1, end);
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

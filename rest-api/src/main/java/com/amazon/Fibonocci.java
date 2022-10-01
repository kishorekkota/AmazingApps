package com.amazon;

public class Fibonocci {


    int[] fibs = new int[20000];


    public int fibonocci(int number)
    {

        if (number == 1)
            return 1;

        if (fibs[number] > 0)
            return fibs[number];
        else{
            fibs[number] = fibonocci(number -1) + fibonocci(number-2);
        }


        return fibs[number];

    }


    public static void main(String[] args){
        Fibonocci fbs = new Fibonocci();

        int number = fbs.fibonocci(4);

        System.out.println(number);
    }
}

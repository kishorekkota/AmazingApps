package com.amazon;

import java.util.HashMap;
import java.util.Map;

public class Fibonocci {


    Map<Integer,Integer> fibs = new HashMap<>();


    public int fibonocci(int number)
    {

        if (number == 1)
            return 1;
        if (number == 2)
            return 1;

        Integer fib = fibs.get(number);

        if (fib != null)
            return fib;
        else{
             fib = fibonocci(number -1) + fibonocci(number-2);

             fibs.put(number,fib);
            }


        return fib;

    }


    public static void main(String[] args){
        Fibonocci fbs = new Fibonocci();

        int number = fbs.fibonocci(400);

        System.out.println(number);
    }
}

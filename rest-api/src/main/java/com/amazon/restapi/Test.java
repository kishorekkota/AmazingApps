package com.amazon.restapi;

import java.util.*;

class Test {
    

    public String intToRoman(int s) {

    Map<Integer,String> mapRoman = new HashMap<>();
        
    mapRoman.put(1,"I");
    mapRoman.put(5,"V");
    mapRoman.put(10,"X");
    mapRoman.put(50,"L");
    mapRoman.put(100,"C");
    mapRoman.put(500,"D");
    mapRoman.put(1000,"M");
   
    
    String sb = "";

    if(s%1000> 0)
    {
        int num = s%1000;
        
        sb = multiplyString("M", num);
    }

   // s = s - num * 1000;

    if(s%500> 0)
    {
        int num = s%1000;
        
        sb = multiplyString("M", num);
    }



    return "";
        
    }

    public static String multiplyString(String s, int number)
    {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<number;i++)
        {
            sb.append(s);
        }
        return sb.toString();
    }
}
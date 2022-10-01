package com.amazon.restapi;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;


public class Solution {


    public static String longestPalindrome(String s) {

    List<Pojo>  list = new ArrayList<>();


    Pojo pojo1 = new Pojo();

    pojo1.number = 5;

    pojo1.str = "Hello";


    Pojo pojo2 = new Pojo();

    pojo2.number = 4;

    pojo2.str = "Test";

    Pojo pojo3 = new Pojo();

    pojo3.number = 40;

    pojo3.str = "Hello";

    list.add(pojo1);
    list.add(pojo2);
    list.add(pojo3);

    long count = list.stream().filter(pojo -> pojo.str.equalsIgnoreCase("Hello")).mapToInt(pojo -> pojo.number).sum();


    System.out.println(count);





     return "";
    }

    public static void main(String[] args)
    {
        Solution.longestPalindrome("s");
    }
}

@Data
class Pojo
{
    String str;
    int number;
}
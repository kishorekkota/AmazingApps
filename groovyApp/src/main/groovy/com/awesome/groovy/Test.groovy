package com.awesome.groovy

import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic


class Test {


    def static variabled = 1..5

    def static array = ['test','hello','world'];





    public static void main(String[] args)
    {
        println variabled;

        array.plus("append").each { println( it) }

        array.each { println( it) }


       println array.getMetaClass().metaPropertyValues
        def newarray = [];
      // array.each { newarray.add(it+"append")   }
//array.each { newarray.add(it+"append")   }
        array.metaClass.appender
                {

                }

        newarray.each { println it }

        array.appender

        newarray.each { println it }


    }
}

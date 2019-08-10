package com.test.singleton;



public class SingleTon {


    private static SingleTon mySingleTon;

    private SingleTon()
    {

    }

    public synchronized static SingleTon getInstance()
    {

        if( mySingleTon == null)
        {
            mySingleTon = new SingleTon();
        }

        return mySingleTon;
    }


    public synchronized  void testOperation()
    {

    }
}

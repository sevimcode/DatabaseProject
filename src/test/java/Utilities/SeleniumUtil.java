package Utilities;

public class SeleniumUtil{

    public static void pause (int seconds){

        try{
            Thread.sleep (seconds*1000);
        }catch (InterruptedException e){
            e.printStackTrace ();
        }


    }
}

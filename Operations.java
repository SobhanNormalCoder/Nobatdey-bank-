package Bank;

import java.util.Random;
import java.lang.Math;


public class Operations {

    public boolean ran_waz(){
        Random ran=new Random();
        boolean n=ran.nextBoolean();
       return n;
    }
    public int ran_balan(){
        Random ran=new Random();
        int p=ran.nextInt(1)+3;
        int l=(int) Math.pow(10,p);
        int a=(ran.nextInt(9)+1)*l;
        return a;
    }
    public int ran_time(){
        Random ran=new Random();
        int l=(int) Math.pow(10,3);
        int a=(ran.nextInt(35)+5)*l;
        return a;
    }

    public int ran_time_sq(){
        Random ran=new Random();
        int l=(int) Math.pow(10,3);
        int a=(ran.nextInt(10)+5)*l;
        return a;
    }

    public int ran_time_mastmali(){
        Random ran=new Random();
        int a=ran.nextInt(8000);
        return a;
    }
}
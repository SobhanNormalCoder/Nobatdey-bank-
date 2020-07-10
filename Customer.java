package Bank;

public class Customer {
    private int balance;
    private boolean waziat;
    private int time_an;
    private int time_sq;
    private int shomareh;


    public void set_waziat(boolean waz){
        waziat=waz;
    }
    public void set_balance(int blan){
        balance=blan;
    }
    public void set_time(int time){
        time_an=time;
    }
    public void set_time_sq(int time){
        time_sq=time;
    }
    public void set_shomareh(int shomare){
        shomareh=shomare;
    }
    public int getBalance(){
        return balance;
    }
    public boolean getWaziat(){
        return waziat;
    }
    public int getTime_an(){
        return time_an;
    }
    public int getTime_sq(){
        return time_sq;
    }
    public int getShomareh(){
        return shomareh;
    }
}
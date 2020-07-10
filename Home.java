package Bank;

import javafx.application.Application;

import java.lang.Runnable;
import java.util.*;
import javafx.application.Application;
import javafx.stage.Stage;

class Sarasry {
    static int sandogh = 50000;
    static int nobat = 0;
}


public class Home extends Application {
    public static void main(String[] args) {

        launch(args);

        final ArrayList<Customer> Cust = new ArrayList<Customer>();

        Grafic grafic=new Grafic();


        for (int i = 0; i < 300; i++) {
            Operations rand = new Operations();
            Customer cust = new Customer();

            cust.set_balance(rand.ran_balan());
            cust.set_waziat(rand.ran_waz());
            cust.set_time(rand.ran_time());
            cust.set_time_sq(rand.ran_time_sq());
            cust.set_shomareh(-1);
            Cust.add(i, cust);
        }
        Cust.get(0).set_time_sq(0);

        Scanner scanner = new Scanner(System.in);
        System.out.print("tedad baje: ");
        final int h = scanner.nextInt();

        class Sequencer implements Runnable {
            public void run() {
                for (int i = 0; i < 630; i++) {
                    Cust.get(i).set_shomareh(i);
                    System.out.println(Cust.get(i).getShomareh() + " nobat dehi shod\n");
                    try {
                        Thread.sleep(Cust.get(i).getTime_sq());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        Sequencer seq = new Sequencer();
        Thread thSequencer = new Thread(seq, "nonatdehi");
        thSequencer.start();


        class Tahvildar implements Runnable {
            int mojodi = 0;
            int baje;

            public void run() {
                for (int i = 0; i < 630 / h; i++) {
                    if (i == 0) {
                        Operations rand = new Operations();
                        System.out.println("bitch");
                        try {
                            Thread.sleep(rand.ran_time_mastmali());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        baje=Sarasry.nobat;

                    } else if (Cust.get(Sarasry.nobat).getShomareh() == -1) {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else if (Cust.get(Sarasry.nobat).getWaziat() == true && Cust.get(Sarasry.nobat).getBalance() != 0) {
                        mojodi = mojodi + Cust.get(Sarasry.nobat).getBalance();

                        System.out.println("badje: "+baje+" nobat: "+Sarasry.nobat + " pardakht " + Cust.get(Sarasry.nobat).getBalance() + "\nmojodi=" + mojodi + "\n");
                        Cust.get(Sarasry.nobat).set_balance(0);

                        Sarasry.nobat = Sarasry.nobat + 1;

                        try {
                            Thread.sleep(Cust.get(Sarasry.nobat).getTime_an());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    } else if (Cust.get(Sarasry.nobat).getWaziat() == true && Cust.get(Sarasry.nobat).getBalance() == 0) {
                        Sarasry.nobat = Sarasry.nobat + 1;
                    } else if (Cust.get(Sarasry.nobat).getWaziat() == false) {
                        if (mojodi >= Cust.get(Sarasry.nobat).getBalance()) {
                            mojodi = mojodi - Cust.get(Sarasry.nobat).getBalance();
                            System.out.println("badje: "+baje+" nobat: "+Sarasry.nobat + " bradasht " + Cust.get(Sarasry.nobat).getBalance() + "\nmojodi=" + mojodi + "\n");
                            Sarasry.nobat = Sarasry.nobat + 1;
                            try {
                                Thread.sleep(Cust.get(Sarasry.nobat).getTime_an());
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        } else if (Sarasry.sandogh >= Cust.get(Sarasry.nobat).getBalance()) {
                            Sarasry.sandogh = Sarasry.sandogh - Cust.get(Sarasry.nobat).getBalance();
                            System.out.println("badje: "+baje+" nobat: "+Sarasry.nobat + " bradasht " + Cust.get(Sarasry.nobat).getBalance() + "\nsandogh=" + Sarasry.sandogh + "\n");
                            Sarasry.nobat = Sarasry.nobat + 1;

                            try {
                                Thread.sleep(Cust.get(Sarasry.nobat).getTime_an());
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else if (Sarasry.sandogh < Cust.get(Sarasry.nobat).getBalance() && mojodi < Cust.get(Sarasry.nobat).getBalance()) {

                            for (int j = Sarasry.nobat; j < 630 / h; j++) {
                                if (Cust.get(j).getWaziat() == true && Cust.get(j).getBalance() != 0 && Cust.get(j).getShomareh() == j) {
                                    mojodi = mojodi + Cust.get(j).getBalance();
                                    System.out.println("badje: "+baje+" nobat: "+Cust.get(j).getShomareh() + " pardakht " + Cust.get(j).getBalance() + "\nmojodi=" + mojodi + "*****" + "\n");
                                    Cust.get(j).set_balance(0);

                                    try {
                                        Thread.sleep(Cust.get(j).getTime_an());
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        ArrayList<Tahvildar> Tahv = new ArrayList<Tahvildar>();

        for (int i = 0; i < h; i++) {
            Tahvildar tahvil = new Tahvildar();
            Tahv.add(i, tahvil);
            Thread thTahvildar = new Thread(tahvil, "karmand");
            thTahvildar.start();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowerdemo;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
public class FlowerDemo {
    public static void main(String[] args) throws InterruptedException{
        //variable
        int water;
        int money;
        int flower;
        planting test = new planting();
        water = test.getWater();
        money = test.getMoney();
        flower = test.getFlower();
        
        // login   
        
        System.out.println("[FLOWER HOUSE OPENED]");
        ArrayList you = new ArrayList();
        char play;
        do{
            you.clear();
        System.out.print("What's is your character name? > ");
        Scanner k = new Scanner(System.in);
        String userName = k.nextLine();
        you.add(userName);
            System.out.println("Choose your character gender?");
            System.out.println("\t<1> Female");
            System.out.println("\t<2> Male");
            int gender;
            do{
                System.out.print("Number > ");
                Scanner l = new Scanner(System.in);
                gender = l.nextInt();
            }while(gender!=1 && gender!=2);
            if(gender == 1){ 
                you.add("Ms.");
            } else {
                you.add("Mr.");
            }
            System.out.print("[Play](Y/N):");
            Scanner m = new Scanner(System.in);
            String p = m.nextLine();
            play = p.toUpperCase().charAt(0);
        }while(play != 'Y');
        
        // welcome
        System.out.println("\nHello," + you.get(1) + you.get(0) +
        "\n\tWelcome to your flower house. you'll receive the order here. "
        + "\nLater you'll pick up your flowers in your store and sale to the customer");
        
        // main menu
        int menu;
        do{ 
        System.out.println("======================== MAIN MENU =======================");
        System.out.println("<1> Selling your product");
        System.out.println("<2> Check your warehouse");
        System.out.println("<3> Add some water");
        System.out.println("<4> Plants some flowers");
        System.out.println("<99> Quiz");
        System.out.print("Select menu >>> ");
        Scanner c = new Scanner(System.in);
        menu = c.nextInt();
        switch(menu){
        case 1:
            System.out.println("+++++++++++++++ SELLING +++++++++++++++");
            System.out.println("CHOOSE THE NUMBER OF SELLING");
            System.out.println("1 : Flower Stand");
            System.out.println("2 : Flower Workshop");
            int numOfSell;
            do{
            System.out.print("number >>> ");
            Scanner d = new Scanner(System.in);
            numOfSell = d.nextInt();
            }while(numOfSell!=1 && numOfSell!=2);
            if(numOfSell == 1){
                selling1 s = new selling1(money,flower);
                money = s.getMoney();
                flower = s.getFlower();
            } else {
                selling2 ss = new selling2(water,money,flower);
                water = ss.getWater();
                money = ss.getMoney();
                flower = ss.getFlower();
            }
            break;
        case 2:
            char rt;
            System.out.println("+++++++++++++++ WAREHOUSE  +++++++++++++++");
            System.out.println("\twater : " + water + "/30 Drops");
            System.out.println("\tCash : " + money + " Gold");
            System.out.println("\tflower : " + flower + " Pansy");
            do {
            System.out.print("Return <Y> :");
            Scanner i = new Scanner(System.in);
            String wrt = i.nextLine();
            rt = wrt.toUpperCase().charAt(0);
            }while(rt != 'Y');
            break;
        case 3:
            char mw;
            if(water < 30){
                System.out.println("----------------------------------------------");
                System.out.println("It will take 10 secounds to get 1 drop of water");
                System.out.println("----------------------------------------------");
                do{
                    for (int i = 10; i >= 0; i--) {
                        Thread.sleep(1000);
                        System.out.print(i + " ");
                    }
                Thread.sleep(1000);
                water++;
                System.out.println("\nwater +1");
                System.out.println("Your water: " + water + "/30");
                System.out.print("Want to get more water? (Y/N) : " );
                Scanner j = new Scanner(System.in);
                String wmw = j.nextLine();
                mw = wmw.toUpperCase().charAt(0);
                }while(mw == 'Y');
            } else {
                System.out.println("30/30 water");
            }
            break;
        case 4:
             test.print(water,money,flower);
             water = test.getWater();
             money = test.getMoney();
             flower = test.getFlower();
        }
        }while(menu != 99);
        System.out.println("[FLOWER HOUSE CLOSED]");
    }
}

//abstract class
abstract class Warehouse {
    int water;
    int money;
    int flower;
    Warehouse(){
        this(10,1000,0);
    }
    Warehouse(int water,int money,int flower){
        this.water = water;
        this.money = money;
        this.flower = flower;
    }
   
    //abstract method + รับพารามิเตอร์
    public abstract void checkWarehouse();
    public void cash(int money){
        this.money = money;
        System.out.println("\t\tYour Cash : " + this.money);
    }
}

//concrete extends abstract
class planting extends Warehouse implements Flower {
    //constrcutor
    planting(){
        super();
    }
    
    //method + รับพารามิเตอร์
    public void print(int water,int money,int flower){
        super.water = water;
        super.money = money;
        super.flower = flower;
        System.out.println("+++++++++++++++ Plant some seed +++++++++++++++");
        cash(money);
        checkWarehouse();
        print1();
        //ประกาศตัวแปร
        char pm;
        int buySeed;
        int buy;
        do {
            do{
                System.out.print("buy seed : x");
                Scanner n = new Scanner(System.in);
                buySeed = n.nextInt();
                buy = buySeed*price1;
            }while(buySeed <= 0);
            if(super.money >= buy){
                if(super.water >= buySeed){
                    while(buySeed > 0){
                        System.out.println("...planting a seed x1");
                        System.out.println("\t-" + price1 + " cash");
                        super.money-=price1;
                        System.out.println("\t-1 water");
                        super.water--;
                        System.out.println("\t+" + output1 + " flower");
                        super.flower+=output1;  
                        buySeed--;
                    }
                    System.out.println("-----------------------------------------");
                    cash(super.money);
                    checkWarehouse();
                } else{
                    System.out.println("Oops! you don't have enough water");
                }
            } else{
                System.out.println("Oops! you don't have enough money");
                cash(super.money);
            }
        System.out.print("Want to plant flower more? (Y/N) : " );
        Scanner o = new Scanner(System.in);
        String wpm = o.nextLine();
        pm = wpm.toUpperCase().charAt(0);
        }while(pm == 'Y');
    }
    
    //method get(คืนค่า)
    public int getWater(){
        return super.water;
    }
    public int getMoney(){
        return super.money;
    }
    public int getFlower(){
        return super.flower;
    }
    
    public void checkWarehouse(){
        System.out.println("\t\tYour water : " + getWater());
        System.out.println("\t\tYour flower : " + getFlower());
    }
    
    public void print1(){
        System.out.println("_________________ Seed _________________ ");
        System.out.println("\tNAME :" + name1 + "\tPRICE :" + price1
                           + "\n\tOUTPUT :" + output1 + "\tSELLFOR :" + sellFor1);
    }

}//ปิดคลาส


abstract class FlowerSaleCart{
    abstract void sell();
}

abstract class FlowerStand extends FlowerSaleCart{
    abstract void craftmaking();
}

abstract class FlowerWorkshop extends FlowerSaleCart{
    abstract void craftmaking();
}

class selling1 extends FlowerStand implements Vessel1,Vessel2 {
    private int num;
    private int money;
    private int flower;
    
    selling1(){
        System.out.println("--------------- Flower Stand ---------------");
        System.out.println("\tStart making flower vase crafts.\n"
                         + "Customer will come and buy the crafts that are\n"
                         + "on the stand once you're finished making them.\n");
    }
    //constructer
    selling1(int money,int flower){
        this();
        this.money = money;
        this.flower = flower;
        sell();
    }
    
    void sell(){ 
        char mc;
        do{
            System.out.println("\t   Please choose a vessel");
            System.out.print("<1> ");
            print2();
            System.out.print("<2> ");
            print5();
            do{
            System.out.print("Vessel >>");
            Scanner e = new Scanner(System.in);
            num = e.nextInt();
        }while(num != 1 && num != 2);
        craftmaking();
        System.out.print("Want to make more crafts? (Y/N) : " );
        Scanner g = new Scanner(System.in);
        String wmc = g.nextLine();
        mc = wmc.toUpperCase().charAt(0);
        }while(mc == 'Y');
    }
    
    public void craftmaking(){
           System.out.println("Making craft...");
            if(flower >= 10){
                flower-=10;
                System.out.println("-10 flower");
                System.out.println("Pansy Vase Craft is done. Wait for the customer buy it!");
                try {
                   SaleCraft();
                } catch (InterruptedException ex) {
                   Logger.getLogger(selling1.class.getName()).log(Level.SEVERE, null, ex);
                }
                money+=35;
                System.out.println("\nCongratulations! you get 35 Gold");
            } else {
                System.out.println("Oops! you don't have enough flowers");
            }
    }
    public void SaleCraft() throws InterruptedException{
        for(int i = 5; i >= 0; i--) {
            Thread.sleep(1000);
            System.out.print(i + " ");
        }
        Thread.sleep(1000);
    }            
    public void print2(){
        System.out.println("Vessal : " + name2 + "\t[SellFor] : " + sellFor2);
    }
    public void print5(){
        System.out.println("Vessal : " + name5 + "\t[SellFor] : " + sellFor5);
    }
    public int getMoney(){
        return this.money;
    }
    public int getFlower(){
        return this.flower;
    }
}//ปิดคลาส selling1


class selling2 extends FlowerStand implements Item1,Item2 {
    int num;
    private int water;
    private int money;
    private int flower;
    
    selling2(){
        System.out.println("-------------------- Flower Workshop --------------------");
        System.out.println("\tA place where you can make basic products\n"
                         + "and which are very popular within the town!\n");
    }
    selling2(int water,int money,int flower){
        this();
        this.water = water;
        this.money = money;
        this.flower = flower;
        sell();
    }
    void sell(){
        char mp;
        do{
        System.out.print("\t    Choose the product you want to make");
        System.out.println("\n___________________<1> Petal Soap($273)__________________");
        System.out.println("\tWater x5\tPansy x30\tSoup x3");
        print3();
        System.out.println("________________<2> Refreshing Powder($789)______________");
        System.out.println("\tPansy x60\tPeppermint Leaf x3");
        print4();
        System.out.println();
            do{
                System.out.print("Product >>> ");
                Scanner f = new Scanner(System.in);
                num = f.nextInt();
            }while(num!=1 && num!=2);
            craftmaking();
        System.out.print("Want to make more products? (Y/N) : " );
        Scanner h = new Scanner(System.in);
        String wmp = h.nextLine();
        mp = wmp.toUpperCase().charAt(0);
        }while(mp == 'Y');
    }
    
    public void craftmaking(){
        if(num==1){
            if(water>=5 && flower>=30){
                System.out.println("Buy 3 Soup...");
                if(money>=price3){
                    money-=price3;
                    System.out.println("-" + price3 + " Gold");
                    flower-=30;
                    System.out.println("-30 flowers");
                    water-=5;
                    System.out.println("-5 water");
                    System.out.println("Petal Soap has been made! Wait for the customer buy it!");
                    try {
                        SaleCraft();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(selling2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    money+=273;
                    System.out.println("\nCongratulations! you get 273 Gold");
                } else {
                    System.out.println("Oops! you don't have enough money");
                }
            } else {
                System.out.println("Oops! you don't have enough meterials");
                System.out.println("\tYour water " + water);
                System.out.println("\tYour flower " + flower);
            }
        } else {
            if(flower>=60){
                System.out.println("Buy 3 Peppermint Leaf...");
                if(money>=(price4*3)){
                    money-=(price4*3);
                    System.out.println("-" + (price4*3) + " Gold");
                    flower-=60;
                    System.out.println("-60 flowers");
                    System.out.println("Refreshing Powder has been made! Wait for the customer buy it!");
                    try {
                        SaleCraft();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(selling2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    money+=789;
                    System.out.println("\nCongratulations! you get 789 Gold");
                    
                } else {
                    System.out.println("Oops! you don't have enough money");
                }
            } else {
                System.out.println("Oops! you don't have enough meterials");
                System.out.println("\tYour flower " + flower);
            }
        }
    }
    
    public void SaleCraft() throws InterruptedException{
        for(int i = 20; i >= 0; i--) {
            Thread.sleep(1000);
            System.out.print(i + " ");
        }
        Thread.sleep(1000);
    }            
    public void print3(){
        System.out.println(".:. " + name3 + " -> price:" + price3 + " output:x" + output3);
    }
    public void print4(){
        System.out.println(".:. " + name4 + " -> price:" + price4 + " output:x" + output4);
    }
    public int getWater(){
        return this.water;
    }
    public int getMoney(){
        return this.money;
    }
    public int getFlower(){
        return this.flower;
    }
    
}


//interface
interface Flower{
    String name1 = "Pansy";
    int price1 = 25; 
    int sellFor1 = 3;
    int output1 = 10;
    public void print1();
}
interface Vessel1{
    String name2 = "White Pottery Vase"; 
    int sellFor2 = 5;
    public void print2();
}
interface Vessel2{
    String name5 = "Rainbow Glass Vase"; 
    int sellFor5 = 5;
    public void print5();
}
interface Item1{
    String name3 = "Soup";
    int price3 = 30;
    int output3 = 3;
    public void print3();
}
interface Item2{
    String name4 = "Peppermint Leaf";
    int price4 = 137; 
    int output4 = 1;
    public void print4();
}



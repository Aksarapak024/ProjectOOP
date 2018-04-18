/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowerdemo;

import java.util.Scanner;
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
             test.plant(water,money,flower);
             water = test.getWater();
             money = test.getMoney();
             flower = test.getFlower();
        }
        }while(menu != 99);
        System.out.println("[FLOWER HOUSE CLOSED]");
    }
}


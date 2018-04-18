/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowerdemo;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */

class selling2 extends FlowerWorkshop implements Item1,Item2 {
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
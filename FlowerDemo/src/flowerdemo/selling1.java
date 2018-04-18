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
        System.out.println("Vessal : " + name2 + "\t[SellFor] : " + sellFor2 + " Gold");
    }
    public void print5(){
        System.out.println("Vessal : " + name5 + "\t[SellFor] : " + sellFor5 + " Gold");
    }
    public int getMoney(){
        return this.money;
    }
    public int getFlower(){
        return this.flower;
    }
}//ปิดคลาส selling1

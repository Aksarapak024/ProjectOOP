/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowerdemo;

import java.util.Scanner;

/**
 *
 * @author acer
 */

//concrete extends abstract
class planting extends Warehouse implements Flower {
    //constrcutor
    planting(){
        super();
    }
    
    //method + รับพารามิเตอร์
    public void plant(int water,int money,int flower){
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
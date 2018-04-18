/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowerdemo;

/**
 *
 * @author acer
 */
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson5_thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class Ex2 {
    public static void main(String[] args) {
        SharedData sd = new SharedData();
        new Consumer(sd).start();
        new Producer(sd).start();
        new Consumer(sd).start();
    }
}
class SharedData {
    int data;
    boolean produced = false;
    synchronized public void produce(int data){
        System.out.println("check sd status - produce" + Thread.currentThread().getId());
        if(produced)
            try {
                this.wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(SharedData.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.data = data;
        System.out.println("produce: " + data);
        produced = true;
        notify();
    }
    synchronized public void consume(){
        System.out.println("check sd status - cosume");
        if(!produced)
            try {
                this.wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(SharedData.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("consume: " + data);
        this.data = 0;
        produced = false;
        notify();
    }
}

class Producer extends Thread {
    SharedData sharedData;

    public Producer(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++)
            sharedData.produce((int)(Math.random()*100));
    }
    
}
class Consumer extends Thread {
    SharedData sharedData;

    public Consumer(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++)
            sharedData.consume();
    }
    
}
package com;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 5/2/15
 * Time: 11:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProducerConsumerTest {

    static Queue<String> messageQueue= new LinkedList<String>();
    static Thread p=new Thread(new Producer());
    static Thread[] cs=new Thread[10];



    static Thread c=new Thread(new Consumer("Consumer_1"));
    static Thread c2=new Thread(new Consumer("Consumer_2"));
    static Thread c3=new Thread(new Consumer("Consumer_3"));


    public static void main(String args[]){


        for(int i=0;i<10;i++){
            cs[i]=new Thread(new Consumer("Consumer_"+i));
            cs[i].start();
        }
        p.start();

    }

    static class Producer implements Runnable{
        Random rand = new Random();
        int count=0;
        @Override
        public void run() {

            while (true){
                try {
                    int sl=rand.nextInt(5)*1000;
//                    System.out.println(" Producer sleeping for "+sl);
                    Thread.sleep(sl);
                    String newMessage= "message_"+count++;
//                    System.out.println(" producer adding message "+newMessage);
                    messageQueue.offer(newMessage);

                    synchronized (messageQueue){
                        messageQueue.notify();
                    }
                } catch (InterruptedException e) {

                }
            }
        }
    }

    static class Consumer implements Runnable{

        public String name;

        public Consumer(String consumer_1) {
            name=consumer_1;
        }

        public void consume(){
            String msg=messageQueue.poll();
            System.out.println(name +" ->Consuming ->"+msg);

        }

        @Override
        public void run() {
            System.out.println("Consumer started");
            while(true){
            if(messageQueue.size()==0){
                try {
//                    System.out.println(name+" is going to waiting");
                    synchronized (messageQueue){
                        messageQueue.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            consume();
            }

        }
    }




}





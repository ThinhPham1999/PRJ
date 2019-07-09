package producer.consumer;

import java.util.LinkedList;

public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {
        //Object of a class that has both produce() and consume()
        final PC pc = new PC();

        //Thread(Muti-thread) implement Runnable or extend java.lang.Thread 
        // should use implement Runnable
        
        //Create produce thread
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    pc.produce();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        
        //Create consumer thread
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    pc.consume();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        
        //start both thread
        //each run 2 method produce() and consumer at a same time follow synchronized
        t1.start();
        t2.start();
        
        //t1 finishes before t2 
        t1.join();
        t2.join();
    }

    // This class have list
    // Add item to list and remove consumber(or remove item)
    public static class PC {

        //create linked list
        //size of list is 2
        LinkedList<Integer> list = new LinkedList<>();
        int capacity = 2;

        //Function called by producer thread
        public void produce() throws InterruptedException {
            int value = 0;
            while (true) {
                // keyword synchronized is call Synchronized
                synchronized (this) {
                    // producer thread waits while list is full
                    // it means items is maximun in store
                    while (list.size() == capacity) {
                        wait();
                    }

                    System.out.println("Producer produced: " + value);

                    //to insert the jobs in the list
                    list.add(value++);

                    //notifies the consumer thread
                    // start consuming
                    notify();

                    //make the program run easier
                    // it just show how program run
                    // if don't use program run too fast
                    Thread.sleep(2000);
                }
            }
        }

        public void consume() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    //consumer thread waits while list is empty
                    //it means no request 
                    while (list.size() == 0) {
                        wait();
                    }

                    int val = list.removeFirst();
                    System.out.println("Consumer consumed: " + val);

                    //wake produce thread
                    notify();

                    // and sleep
                    // it just show how program run
                    // if don't use program run too fast
                    Thread.sleep(2000);
                }
            }
        }
    }
}

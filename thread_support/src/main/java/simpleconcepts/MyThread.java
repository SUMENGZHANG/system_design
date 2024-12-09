package simpleconcepts;

public class MyThread implements Runnable{


    @Override
    public void run() {
        System.out.println("curThread:"+Thread.currentThread().getName());
    }
}

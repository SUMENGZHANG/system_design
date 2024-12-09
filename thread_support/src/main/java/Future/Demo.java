package Future;


import AQS.MyThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Demo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
         List<CompletableFuture<Void>> list = new ArrayList<>();
        CompletableFuture<Void> c1 =   CompletableFuture.runAsync(()->{
            System.out.println("hello");
        });

        CompletableFuture<Void> c2 =   CompletableFuture.runAsync(()->{
            System.out.println("SumengZhang");
        });
        list.add(c1);
        list.add(c2);

         CompletableFuture.allOf(list.toArray(new CompletableFuture[list.size()])).join();




    }
}

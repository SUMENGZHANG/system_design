package simpleconcepts;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolStudy {


    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor  = null;
        try{
            threadPoolExecutor = new ThreadPoolExecutor(
                    8,16,
                    10, TimeUnit.SECONDS,
                    new LinkedBlockingDeque<>(),
                    new ThreadPoolExecutor.CallerRunsPolicy()
            );
            MyThread thread1 = new MyThread();
            threadPoolExecutor.submit(thread1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}

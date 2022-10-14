import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyCallable task1 = new MyCallable("Быстро только кошки родятся");
        MyCallable task2 = new MyCallable("Терпенье и труд всё перетрут");
        MyCallable task3 = new MyCallable("Сытое брюхо к учению глухо");
        MyCallable task4 = new MyCallable("Маленькая собачка всю жизнь щенок");
        MyCallable task5 = new MyCallable("Не откладывай на завтра то, что можешь сделать сегодня");
        ArrayList<MyCallable> tasks = new ArrayList<>();
        Collections.addAll(tasks, task1, task2, task3, task4, task5);
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        List<Future<Integer>> futures = threadPool.invokeAll(tasks);
        for (Future future : futures) {
            System.out.println(future.get());
        }
        int fastResult = threadPool.invokeAny(tasks);
        System.out.println(fastResult);
        threadPool.shutdown();
    }
}
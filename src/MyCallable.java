import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    String str;

    public MyCallable(String str) {
        this.str = str;
    }

    @Override
    public Integer call() throws Exception {
        String[] words = str.split(" ");
        for (String word : words) {
            System.out.println(word);
        }
        return words.length;
    }
}

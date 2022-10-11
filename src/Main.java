public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup threadGroup = new ThreadGroup("threadGroup");
        System.out.println("Создаю потоки ...");
        for (int i = 1; i < 5; i++) {
            new MyThread(threadGroup, "Я поток " + i).start();
        }
        Thread.sleep(15000);
        System.out.println("Завершаю все потоки");
        threadGroup.interrupt();
    }
}
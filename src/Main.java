public class Main {

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("MyRunnable");
        }
    }

    public static class MyRunnable2 extends Thread {
        public void run() {
            System.out.println("MyRunnable2");
        }
    }

    private static void myRunnable3() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("myRunnable3");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        try {
            Thread.sleep(2000);
            System.out.println("in myRunnable3 main thread slept 2s");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void myRunnable4() {
        Runnable runnable = () -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("myRunnable4");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        myRunnable4();
        myRunnable3();
        thread.start();
    }

}
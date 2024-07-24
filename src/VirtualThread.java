public class VirtualThread {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("Thread Started");
        };
        Thread started_virtual_thread = Thread.ofVirtual().start(runnable);
        Thread unStarted_virtual_thread = Thread.ofVirtual().unstarted(runnable);
        unStarted_virtual_thread.start();

        try {
            unStarted_virtual_thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

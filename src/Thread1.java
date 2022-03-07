public class Thread1 {
    public static void main(String[] args) throws  InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside the thread : "+ Thread.currentThread().getName());
                throw  new RuntimeException("Run Time exception to check thread exception handling");
            }
        });
        thread.setName("Worker Thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.print("A critical error has occured  "+ "Thread Name=>"+ t.getName()  +" message "+e.getMessage());
            }
        });

        System.out.println("I am inside main method before calling Thread");
        thread.start();
        System.out.println("I am inside main method After calling Thread");
    }
}

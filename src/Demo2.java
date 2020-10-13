import java.util.Scanner;

class Processor extends Thread{
    private boolean running = true;

    public void run(){
        while(running){
            System.out.println("hello");
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void shutdown(){
        running = false;
    }

}

public class Demo2 {
    public static void main(String[] args){
        Processor proc1 = new Processor();
        proc1.start();

        System.out.println("Press return to stop...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        proc1.shutdown();
    }
}

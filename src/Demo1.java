class Runner extends Thread{

    private int id;
    Runner(int id){
        this.id = id;
    }

    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println("Thread "+id+":"+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Runner1 implements Runnable{

    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Demo1 {
    public static void main (String[] args){
        Runner runner1 = new Runner(0);
        runner1.start();

        Runner runner2 = new Runner(1);
        runner2.start();
    }
}

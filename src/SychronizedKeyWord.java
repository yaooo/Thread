class Sender {
    public void send(String msg) {
        synchronized (this) {
            System.out.println("Sending " + msg + "...");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Thread  interrupted.");
            }
            System.out.println(msg + "sent.");
        }
    }
}
class ThreadedSend extends Thread {
    private String msg;
    Sender  sender;
    ThreadedSend(String m,  Sender obj) {
        msg = m;
        sender = obj;
    }
    public void run() {
        sender.send(msg);
    }
}
class SychronizedKeyWord {
    public static void main(String[] args) {
        Sender snd = new Sender();
        ThreadedSend S1 = new ThreadedSend( " Hi " , snd );
        ThreadedSend S2 = new ThreadedSend( " Bye " , snd );
        S1.start();
        S2.start();

        try {
            S1.join();
            S2.join();
        }
        catch(Exception e) {
            System.out.println("Interrupted");
        }
    }
}


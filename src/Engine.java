import java.lang.Thread;

class Engine{

    final Window window;
    boolean running = false;

    Engine(Window window){
        this.window = window;
    }

    void run(){
        running = true;
        while(running){
            window.paint();
            try {Thread.sleep(1000/60);} catch (Exception e) {e.printStackTrace();}
        }
    }

    void endProgram(){
        running = false;
    }

}
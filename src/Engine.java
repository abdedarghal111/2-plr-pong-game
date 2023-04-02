import java.lang.Thread;

class Engine{

    final Window window;
    boolean running = false;
    Play play;

    Engine(Window window){
        this.window = window;
        this.play = new Play(window);
    }

    void run(){
        running = true;
        play.init();
        while(running){
            loop();
            window.paint(play);
            try {Thread.sleep(1000/60);} catch (Exception e) {e.printStackTrace();}
        }
    }

    void endProgram(){
        running = false;
    }

    void loop(){
        
    }

}
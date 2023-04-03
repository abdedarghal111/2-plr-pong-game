import java.lang.Thread;

class Engine{

    final Window window;
    boolean gameRunning = false;
    Play play;
    

    Engine(Window window){
        this.window = window;
        this.play = new Play(window);
    }

    void oneGame(int ballSide){
        gameRunning = true;
        play.init(ballSide);
        while(gameRunning){
            play.loop();
            window.paint(play);
            try {Thread.sleep(1000/60);} catch (Exception e) {e.printStackTrace();}
        }
    }

    void endGame(){
        gameRunning = false;
    }

}
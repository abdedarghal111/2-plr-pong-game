import java.lang.Thread;
import obj.Racket.TEAM;

class Engine{

    final Window window;
    boolean gameRunning = false;
    final int FPS = 60;
    Play play;
    TEAM winner;
    

    Engine(Window window){
        this.window = window;
        this.play = new Play(window);
    }

    void oneGame(int ballSide){
        gameRunning = true;
        play.init(ballSide);
        while(gameRunning){
            play.loop(this);
            window.paint(play);
            try {Thread.sleep(1000/FPS);} catch (Exception e) {e.printStackTrace();}
        }
        if(winner == TEAM.BLUE){
            System.out.println("Ha ganado el azul.");
        }else if(winner == TEAM.RED){
            System.out.println("Ha ganado el rojo.");
        }
    }

    void endGame(TEAM winner){
        this.winner = winner;
        gameRunning = false;
    }

}
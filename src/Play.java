import obj.*;
import obj.Racket.TEAM;
import java.awt.Graphics;

public class Play{

    Racket blue,red;
    Ball ball;
    
    Play(Window window){
        this.blue = new Racket(window.getWidth(),window.getHeight(),TEAM.BLUE);
        this.red = new Racket(window.getWidth(),window.getHeight(),TEAM.RED);
        this.ball = new Ball(window.getWidth(),window.getHeight());
    }

    void init(){
        blue.setVisible(true);
        red.setVisible(true);
        ball.setVisible(true);
    }

    public void drawObj(Graphics g){
        blue.draw(g);
        red.draw(g);
        ball.draw(g);
    }

}
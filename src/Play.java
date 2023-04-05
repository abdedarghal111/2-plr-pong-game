import obj.*;
import obj.Racket.TEAM;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Play implements KeyListener{

    Racket blue,red;
    Ball ball;
    Window window;
    
    Play(Window window){
        this.window = window;
        this.blue = new Racket(window.getWidth(),window.getHeight(),TEAM.BLUE);
        this.red = new Racket(window.getWidth(),window.getHeight(),TEAM.RED);
        this.ball = new Ball(window.getWidth(),window.getHeight());
        window.addKeyListener(this);
    }

    void init(int ballSide){
        blue.setVisible(true);
        red.setVisible(true);
        ball.setVisible(true);
        ball.setFirstVelocity(ballSide);
    }

    public void drawObj(Graphics g){
        blue.draw(g);
        red.draw(g);
        ball.draw(g);
    }

    boolean
    wPressed = false,
    sPressed = false,
    upPressed = false,
    downPressed = false;
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            wPressed = true;
        }else if(e.getKeyCode() == KeyEvent.VK_S){
            sPressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            upPressed = true;
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            downPressed = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            wPressed = false;
        }else if(e.getKeyCode() == KeyEvent.VK_S){
            sPressed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            upPressed = false;
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            downPressed = false;
        }
    }

    public void keyTyped(KeyEvent e) {}

    private void inputEvents(){
        if(wPressed){blue.moveUp();}
        if(sPressed){blue.moveDown();}
        if(upPressed){red.moveUp();}
        if(downPressed){red.moveDown();}
    }

    public void loop(Engine engine){
        inputEvents();
        ball.update();
        blue.checkColisionWithBall(ball);
        red.checkColisionWithBall(ball);
        switch(BallOut()){
            case 1: engine.endGame(TEAM.RED);break;
            case 2: engine.endGame(TEAM.BLUE);break;
        }
    };

    int BallOut(){
        if(0 > ball.getx() + ball.getsize()){
            return 1;
        }else if(window.getWidth() < ball.getx()){
            return 2;
        }
        return 3;
    }
    
}
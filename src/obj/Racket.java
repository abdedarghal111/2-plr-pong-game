package obj;

import java.awt.Graphics;
import java.awt.Color;

public class Racket {
    
    private float 
    x,y,
    widthCons = 0.07f,
    heightcons = 0.34f,
    velocity = 10,
    velocityUpload = 1;
    private int
    width,
    height;
    Color color;
    int windowWidth,windowHeight;

    public boolean visible = false;

    public enum TEAM{
        BLUE,
        RED
    }

    TEAM team;
    
    public Racket(int windowWidth,int windowHeight,TEAM team){
        this.width = (int)(windowWidth * widthCons);
        this.height = (int)(windowHeight * heightcons);
        this.team = team;
        if(team == TEAM.BLUE){
            this.x = 0;
            this.color = Color.BLUE;
        }else{
            this.x = windowWidth - width;
            this.color = Color.RED;
        }

        this.y = (int)((windowHeight/2) -  (height/2));
        this.windowHeight = windowHeight;
        this.windowWidth = windowWidth;
    }

    public void draw(Graphics g){
        if(visible){
            g.setColor(color);
            g.fillRect((int)x, (int)y, width, height);
        }
    }

    public void setVisible(boolean visible){
        this.visible = visible;
    }

    public void moveUp(){
        y -= velocity;
        if(y < 0){
            y = 0;
        }
    }

    public void moveDown(){
        y += velocity;
        if(y+ height > windowHeight){
            y = windowHeight - height;
        }
    }

    public void increaseVel(){
        velocity += velocityUpload;
    }

    public void checkColisionWithBall(Ball ball){
        if(team == TEAM.BLUE && ball.getx() < width && ball.getx() > width/2){
            if(ball.gety() <= y && ball.gety() + ball.getsize() >= y){
                ball.colisionedWithRacket(width);
                increaseVel();
            }else if(ball.gety() <= y + height && ball.gety() + ball.getsize() >= y + height){
                ball.colisionedWithRacket(width);
                increaseVel();
            }else if(ball.gety() >= y && ball.gety() + ball.getsize() <= y + height){
                ball.colisionedWithRacket(width);
                increaseVel();
            }
        }else if(team == TEAM.RED && ball.getx() + ball.getsize() > windowWidth - width && ball.getx() + ball.getsize() < windowWidth - width/2){
            if(ball.gety() <= y && ball.gety() + ball.getsize() >= y){
                ball.colisionedWithRacket(windowWidth - width - ball.getsize());
                increaseVel();
            }else if(ball.gety() <= y + height && ball.gety() + ball.getsize() >= y + height){
                ball.colisionedWithRacket(windowWidth - width - ball.getsize());
                increaseVel();
            }else if(ball.gety() >= y && ball.gety() + ball.getsize() <= y + height){
                ball.colisionedWithRacket(windowWidth - width - ball.getsize());
                increaseVel();
            }
        }

    }

}



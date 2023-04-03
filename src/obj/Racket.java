package obj;

import java.awt.Graphics;
import java.awt.Color;

public class Racket {
    
    private float 
    x,y,
    widthCons = 0.07f,
    heightcons = 0.34f,
    velocity = 3;
    private int
    width,
    height;
    Color color;

    public boolean visible = false;

    public enum TEAM{
        BLUE,
        RED
    }
    
    public Racket(int windowWidth,int windowHeight,TEAM team){
        this.width = (int)(windowWidth * widthCons);
        this.height = (int)(windowHeight * heightcons);
        if(team == TEAM.BLUE){
            this.x = 0;
            this.color = Color.BLUE;
        }else{
            this.x = windowWidth - width;
            this.color = Color.RED;
        }

        this.y = (int)((windowHeight/2) -  (height/2));
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
    }

    public void moveDown(){
        y += velocity;
    }

}



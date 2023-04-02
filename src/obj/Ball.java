package obj;

import java.awt.Graphics;
import java.awt.Color;

public class Ball {

    private float 
    x,y,
    sizeCons = 0.03f;
    private int
    size;
    Color color;

    public boolean visible = false;
    
    public Ball(int windowWidth,int windowHeight){
        this.size = (int)(windowWidth*sizeCons);
        
        this.color = Color.WHITE;
        this.x = (int)((windowWidth/2) -  (size/2));
        this.y = (int)((windowHeight/2) -  (size/2));
    }

    public void draw(Graphics g){
        if(visible){
            g.setColor(color);
            g.fillOval((int)x, (int)y, size,size);
        }
    }

    public void setVisible(boolean visible){
        this.visible = visible;
    }

}

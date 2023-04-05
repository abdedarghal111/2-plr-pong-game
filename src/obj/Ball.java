package obj;

import java.awt.Graphics;
import java.awt.Color;

public class Ball {

    private double 
    x,y,
    sizeCons = 0.03f,
    velocity = 5,
    velocityUploading = 1,
    speedCons = 1f;
    private int
    size;
    Color color;
    double[] directionVector = {0,0};
    int windowWidth,windowHeight;
    

    public boolean visible = false;
    
    public Ball(int windowWidth,int windowHeight){
        this.size = (int)(windowWidth*sizeCons);
        
        this.color = Color.WHITE;
        this.x = (int)((windowWidth/2) -  (size/2));
        this.y = (int)((windowHeight/2) -  (size/2));
        this.windowHeight = windowHeight;
        this.windowWidth = windowWidth;
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

    public void setFirstVelocity(int vectorDirection){

        double ang = Math.random();

        if(ang >= Math.sin(Math.toRadians(50))){
            ang = Math.toRadians(50);
        }

        directionVector[0] = Math.sqrt(1-Math.pow(ang,2))*vectorDirection;
        
        directionVector[1] = ang*vectorDirection;
        if(Math.random() <= 0.5){
            directionVector[1] *= -1;
        }


    }

    void setRandDirection(){

        double ang = Math.random();
        if(ang >= Math.sin(Math.toRadians(50))){
            ang = Math.toRadians(50);
        }

        double 
        oldXvec = directionVector[0],
        oldYvec = directionVector[1];

        directionVector[0] = Math.sqrt(1-Math.pow(ang,2));
        directionVector[1] = ang;

        if(oldXvec<0){
            directionVector[0] *= -1;
        }

        if(oldYvec>0){
            directionVector[1]*= -1;
        }

        

    }

    public void update(){
        moveBall();
        colisionHeight();
    }

    void moveBall(){
        x += directionVector[0]*velocity*speedCons;
        y += directionVector[1]*velocity*speedCons;
    }

    void colisionHeight(){
        if(y < 0){
            y = 0;
            directionVector[1] *= -1;
        }else if(y + size > windowHeight){
            y = windowHeight - size;
            directionVector[1] *= -1;
        }
    }

    public void colisionedWithRacket(double ballXPosition){
        directionVector[0] *= -1;
        x = ballXPosition;
        setRandDirection();
        increaseVelocity();
    }

    public double getx(){
        return x;
    }
    public double gety(){
        return y;
    }

    public double getsize(){
        return size;
    }

    public void increaseVelocity(){
        velocity +=velocityUploading;
    }

}

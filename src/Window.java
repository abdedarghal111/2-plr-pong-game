import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


class Window extends JFrame{
    

    Window(){
        
        //window Settings
        setSize(new Dimension(1000,700));
        //setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true); 
    }


    void paint(Play play){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(2);
            bs = getBufferStrategy();
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0,(int)getSize().getWidth(),(int)getSize().getHeight());

        //start drawing
        play.drawObj(g);
        //end drawing

        bs.show();
        bs.dispose();
    }

    void draw(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(2);
            bs = getBufferStrategy();
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLUE);
        g.fillRect(0, 0,(int)getSize().getWidth(),(int)getSize().getHeight());

        bs.show();
        bs.dispose();
    }

}

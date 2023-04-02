import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;

class Window extends JFrame{
    

    Window(){
        
        //window Settings
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);     
    }


    void paint(Play play){
        Graphics g = getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0,(int)getSize().getWidth(),(int)getSize().getHeight());

        //start drawing
        play.drawObj(g);
        //end drawing

        g.dispose();
    }

}

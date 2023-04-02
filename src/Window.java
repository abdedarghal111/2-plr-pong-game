import javax.swing.JFrame;
import javax.tools.Tool;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

class Window extends JFrame{
    
    int[] screenSize = {
        (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
        (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()
    };

    Window(){
        //window Customization
        setSize(new Dimension(screenSize[0],screenSize[1]));
        setExtendedState(MAXIMIZED_BOTH);

        //window Settings
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);     
    }


    void paint(){
        Graphics g = getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0,(int)getSize().getWidth(),(int)getSize().getHeight());

        //start drawing
        
        //end drawing
        g.dispose();
    }

}

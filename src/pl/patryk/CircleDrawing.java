package pl.patryk;

import javax.swing.*;
import java.awt.*;


/*
    Dodatkowa klasa do tworzenia grafiki 2D - okręgu, wraz z metodą umożliwiającą jej przerysowywanie
 */
public class CircleDrawing extends JComponent {

    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.red);
        g.drawOval(0,0,100,100);
    }

    public void changePosition(int x, int y){
        this.setLocation(x,y);
        repaint();
        setVisible(true);
    }
}

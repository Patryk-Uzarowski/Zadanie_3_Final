package pl.patryk;

import javax.swing.*;
import java.awt.*;

/*
    Dodatkowa klasa do tworzenia grafiki 2D - prostokątu (przy tych parametrach kwadratu) oraz metoda umożliwiająca jej przerysowywanie
 */
public class RectangleDrawing extends JComponent {

    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.green);
        g.drawRect(0,0,99,99);
    }

    public void changePosition(int x, int y){
        this.setLocation(x,y);
        repaint();
        setVisible(true);
    }
}

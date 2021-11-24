package pl.patryk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
    Klasa generująca dodatkowy panel, w którym można wygenerować kształt kwadratu / koła, w wybranym przez użytkownika miejscu.
 */
public class Kanwa extends JPanel {

    private final RectangleDrawing rectangle = new RectangleDrawing();
    private final CircleDrawing circle = new CircleDrawing();
    private int mousePosX;
    private int mousePosY;

    /*
        W konstruktorze klasy definiujemy całą zawartość okna umożliwiającą rysowanie kształtów. Został tutaj zaimplementowany interfejs
        MouseListener oraz KeyListener, które umożliwiają generowanie kształtów w wybranym przez użytkownika miejscu. Sam wybór polega
        na najechaniu myszką w wybrane przez użytkownika miejsce, wciśnięcie prawego klawisza myszy oraz kluczowego znaku - 'r' lub 'o',
        definiującego, czy w danym miejcu zostanie wygenerowany kwadrat, czy okrąg. Kształ jest rysowany symetrycznie względem kursora, który
        sam znajduje się w centralnym punkcie całej figury.
     */
    public Kanwa() {
        this.setBounds(0, 0, 500, 300);
        this.setLayout(null);
        this.setBackground(Color.black);

        rectangle.setBounds(0,0,100,100);
        rectangle.setVisible(false);
        this.add(rectangle);

        circle.setBounds(100,100,100,100);
        circle.setVisible(false);
        this.add(circle);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                mousePosX = e.getX();
                mousePosY=e.getY();
            }
        });

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if(e.getKeyChar()=='r'){
                    rectangle.changePosition(mousePosX-50,mousePosY-50);
                }else if(e.getKeyChar()=='o')
                    circle.changePosition(mousePosX-50,mousePosY-50);
            }
        });

        JLabel label1 = new JLabel();
        label1.setForeground(Color.green);
        label1.setText("Click + 'r' = Rectangle");
        label1.setBounds(0,0,130,30);
        JLabel label2 = new JLabel();
        label2.setForeground(Color.red);
        label2.setText("Click + 'o' = Circle");
        label2.setBounds(0,25,120,30);
        this.add(label1);
        this.add(label2);

        this.setFocusable(true);
        this.setVisible(true);
    }
}





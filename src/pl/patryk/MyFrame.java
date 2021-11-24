package pl.patryk;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

/*
    Główna klasa programu odpowiadająca za stworzenie środowiska aplikacji SWING oraz wyposażenie jej w podstawowe elementy programu
 */

public class MyFrame extends JFrame {

    JPanel mainPanel;
    JButton buttonRun;
    JButton button2;
    Kanwa panelKanwy;


    public MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);

        panelKanwy = new Kanwa();
        this.add(panelKanwy);
        addJPanel();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MyFrame();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }

    /*
        Panel odpowiadający za dodanie przycisków oraz zaimplementowanie interfejsów przycisków umożliwiających interakcję
     */

    private void addJPanel(){
        mainPanel = new JPanel();
        mainPanel.setBounds(0,300,500,200); // JPanel - 500 na 200
        mainPanel.setLayout(null);
        buttonRun = new JButton("Run");
        button2 = new JButton("Cancel");
        buttonRun.setBounds(0,120,90,40);
        button2.setBounds(400,120,80,40);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonRun.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                checkMargain(e.getX());
            }

        });

        mainPanel.add(buttonRun);
        mainPanel.add(button2);


        this.add(mainPanel);
    }

    /*
    Metoda odpowiedzialna za sprawdzenie, czy przy najechaniu kursorem w obszar przycisku "Run", nie najechaliśmy na margines,
    w którym przycisk nie będzie zmieniał swojej lokalizacji. W przeciwnym razie przycisk zmieni swoje położenie - ucieczka przed użytkownikiem.
    Za zmianę współrzędnych odpowiada metoda changeLocal()
     */
    private void checkMargain(int mouseX){
        if( (mouseX>=0&&mouseX<=20) || (mouseX>=70 && mouseX<=90) ){}
        else
            changeLocal(buttonRun);
    }

    /*
        Metoda changeLocal() odpowiada za zmianę współrzędnych przycisku. Algorytm działania przystosowuje się do wymiarów Componentu, w którym znajduję
        się przycisk, a przez narzucone ograniczenia, nie może wyjechać chociażby poza zakres Frame'u, przez co nie zniknie z pola widzenia.
        W metodzie została zaimplementowana pomocnicza zmienna pseudolosowa, losująca liczbę z zakresu [0,50), definiuje ona o ile zostanie
        jednostek zostanie przeniesiony przycisk wzdłuż osi OX i OY (Jeżeli jest to możliwe - nie wykracza poza zakres Container'a)
     */

    private void changeLocal(JButton button){
            Random random = new Random();
            int x = random.nextInt(50)+30;
            if(button.getX()+x<310){
                if(button.getY()-x>=40){
                    button.setLocation(button.getX() + x, button.getY() - x);
                }else if(button.getY()+x<130){
                    button.setLocation(button.getX() + x, button.getY() + x);
                }
            }else if(button.getX()-x>0){
                if(button.getY()-x>=40){
                    button.setLocation(button.getX() - x, button.getY() - x);
                }else if(button.getY()+x<130){
                    button.setLocation(button.getX() - x, button.getY() + x);
                }
            }
        }
    }

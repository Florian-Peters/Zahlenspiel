import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class Main {



    static Integer myNumber = ThreadLocalRandom.current().nextInt(0, 100 + 1);;
    static Integer tries = 0;


    static JLabel text = new JLabel("Gebe eine zwischen 0 und 100 ein ");

    public static void main(String[] args) {
        openUi();
        //nextround();
    }

    public static void openUi()  {
        JFrame frame = new JFrame("Rate die Zahl!");
        frame.setSize(300 , 400);
        frame.setLocation(100 , 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(true);





        text.setBounds(50, 50 , 400 , 30);

        JTextField Textfeld = new JTextField();
        Textfeld.setBounds(50 , 150 , 200, 30);

        JButton button = new JButton("Raten");
        button.setBounds(50, 220, 200 , 30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textf = Textfeld.getText();
                Integer number = Integer.parseInt(textf);
                System.out.println();
                guess(number);
            }
        });



        frame.add(button);
        frame.add(Textfeld);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(text);



    }


    public static void nextround(){
        tries++;
        Scanner scanner = new Scanner (System.in);
        System.out.println("Gebe eine Zahl zwischen 1 und 100 ein.");
        Integer number = scanner.nextInt();
        guess(number);
    }

    public static void  guess (Integer number) {

        if (number == myNumber) {
            text.setText(" Richtig!! Du hast " +tries+ " versuche gebraucht");
        } else {
            tries++;
            System.out.println("leider falsch versuche es erneut.");
            text.setText("Falsch Geraten");

             if (number < myNumber) {
                 text.setText("Falsch geraten Sie ist zu klein");
             }else {
                 text.setText("Falsch geraten Sie ist zu gross");
               }
              //nextround();

    }
 }
}
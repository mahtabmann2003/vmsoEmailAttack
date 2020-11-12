import javax.swing.*;
import java.awt.*;


public class Main {


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().setBackground(Color.black);
                frame.setPreferredSize(new Dimension(600, 500));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setResizable(false);
            }
        });
        };
    }



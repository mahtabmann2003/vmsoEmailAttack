
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main(){

        initUI();
    }

    private void initUI() {

        add(new Board());

        setTitle("Moving sprite");
        setSize(700, 500);

        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            StartScreen ex = new StartScreen();
            ex.setVisible(true);
        });
    }
}
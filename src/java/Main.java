
import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main extends JFrame {
    String username;
    public Main(String name) throws IOException {
        username = name;
        initUI();
    }

    private void initUI() throws IOException {

        add(new Board(username));

        setTitle("VMSO Email Attack");
        setSize(700, 500);

        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            StartScreen ex = null;
            try {
                ex = new StartScreen();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ex.setVisible(true);
        });
    }
}
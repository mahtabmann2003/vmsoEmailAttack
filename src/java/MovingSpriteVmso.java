

import java.awt.EventQueue;
import javax.swing.JFrame;


public class MovingSpriteVmso extends JFrame {

    public MovingSpriteVmso() {

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
            MovingSpriteVmso ex = new MovingSpriteVmso();
            ex.setVisible(true);
        });
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel implements ActionListener {

        private Timer timer;
        private VmsoShip vmsoShip;
        private final int DELAY = 10;

        public Board() {

            initBoard();
        }

        private void initBoard() {

            addKeyListener(new TAdapter());
            setBackground(Color.black);
            setFocusable(true);

            vmsoShip = new VmsoShip();

            timer = new Timer(DELAY, this);
            timer.start();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            doDrawing(g);

            Toolkit.getDefaultToolkit().sync();
        }

        private void doDrawing(Graphics g) {

            Graphics2D g2d = (Graphics2D) g;

            g2d.drawImage(vmsoShip.getImage(), vmsoShip.getX(),
                    vmsoShip.getY(), this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            step();
        }

        private void step() {

            vmsoShip.move();


            repaint(vmsoShip.getX()-1, 250,
                    vmsoShip.getWidth()+2, vmsoShip.getHeight()+2);
        }

        private class TAdapter extends KeyAdapter {

            @Override
            public void keyReleased(KeyEvent e) {
                vmsoShip.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                vmsoShip.keyPressed(e);
            }
        }
    }


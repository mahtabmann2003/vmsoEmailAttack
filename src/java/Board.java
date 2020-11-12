import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel implements ActionListener {

        private Timer timer;
        private VmsoShip vmsoShip;
        private Sprite enemy1;
        private final int DELAY = 10;

        public Board() {

            initBoard();
        }

        private void initBoard() {

            addKeyListener(new TAdapter());
            setBackground(Color.black);
            setFocusable(true);

            vmsoShip = new VmsoShip();
            enemy1 = new Sprite("gmail.png");

            timer = new Timer(DELAY, this);
            timer.start();
            gameLoop();

        }

        private void gameLoop(){

            enemyStep(enemy1);

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

            g2d.drawImage(enemy1.getImage(), enemy1.getX(),
                    enemy1.getY(), this);
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

        private void enemyStep(Sprite enemy) {

            enemy.move();


            repaint(enemy.getX()-1, 250,
                        enemy.getWidth()+2, enemy.getHeight()+2);
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


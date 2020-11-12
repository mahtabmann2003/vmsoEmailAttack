import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Board extends JPanel {

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

            timer = new Timer();
            timedLoop();

        }

        private void timedLoop(){
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    gameLoop();
                }
            }, 100, 10);
        }

        private void gameLoop(){
            enemyStep(enemy1);
            playerStep();
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


        private void playerStep() {

            vmsoShip.move();

            repaint(vmsoShip.getX()-1, vmsoShip.getY(), vmsoShip.getWidth()+2, vmsoShip.getHeight()+2);
        }

        private void enemyStep(Sprite enemy) {

            enemy.move(2);


            repaint(enemy.getX()-1, enemy.getY(),
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


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
        private Sprite enemy1, enemy2, enemy3;

        public Board() {

            initBoard();
        }

        private void initBoard() {

            addKeyListener(new TAdapter());
            setBackground(Color.black);
            setFocusable(true);

            vmsoShip = new VmsoShip();
            enemy1 = new Sprite("gmail.png",2);
            enemy2 = new Sprite("email2.png", 3);
            enemy3 = new Sprite("email3.png", 4);

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

        private void gameLoop(){ //Game logic done here...loops repeats every 0.1 second
            enemyStep(enemy1);
            enemyStep(enemy2);
            enemyStep(enemy3);
            playerStep();
            collisionCheck();
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

            g2d.drawImage(enemy2.getImage(), enemy2.getX(),
                    enemy2.getY(), this);

            g2d.drawImage(enemy3.getImage(), enemy3.getX(),
                    enemy3.getY(), this);

        }


        private void playerStep() {

            vmsoShip.move();

            repaint(vmsoShip.getX()-1, vmsoShip.getY(), vmsoShip.getWidth()+2, vmsoShip.getHeight()+2);
        }


        private void enemyStep(Sprite enemy) {

            enemy.move();

            repaint(enemy.getX()-1, enemy.getY(),
                        enemy.getWidth()+2, enemy.getHeight()+2);
        }
            public void collisionCheck() {
               Rectangle r = new Rectangle(vmsoShip.getX(), vmsoShip.getY(), vmsoShip.getWidth(), vmsoShip.getWidth());
               Rectangle p = new Rectangle(enemy1.getX(), enemy1.getY(), enemy1.getWidth(), enemy1.getHeight());
               Rectangle q = new Rectangle(enemy2.getX(), enemy2.getY(), enemy2.getWidth(), enemy2.getHeight());
               Rectangle d = new Rectangle(enemy3.getX(), enemy3.getY(), enemy3.getWidth(), enemy3.getHeight());

               if (r.intersects(p)){
                   System.exit(0);
               }
               if (r.intersects(q)) {
                   System.exit(0);
               }
               if (r.intersects(d)){
                   System.exit(0);
               }
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


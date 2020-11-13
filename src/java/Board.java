import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Board extends JPanel {

    private Timer timer;

    private Sprite enemy1, enemy2, enemy3, vmsoShip;
    private boolean status;

    public Board() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        enemy1 = new Sprite("gmail.png",2,0, ThreadLocalRandom.current().nextInt(0,  700), -500);
        enemy2 = new Sprite("email2.png", 3,0, ThreadLocalRandom.current().nextInt(0,  700), -540);
        enemy3 = new Sprite("email3.png", 4,0, ThreadLocalRandom.current().nextInt(0,  700), -560);
        vmsoShip = new Sprite("vmso.png", 0,0, 250,390);

        status = true;
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
        if(status) {
            step(enemy1);
            step(enemy2);
            step(enemy3);
            step(vmsoShip);
            collisionCheck();
        }
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


    ///private void playerStep() {

    ///     vmsoShip.move();

    ///     repaint(vmsoShip.getX()-1, vmsoShip.getY(), vmsoShip.getWidth()+2, vmsoShip.getHeight()+2);
    /// }


    private void step(Sprite sprite) {

        sprite.move();

        repaint(sprite.getX()-1, sprite.getY(),
                sprite.getWidth()+2, sprite.getHeight()+2);
    }

    public void collisionCheck(){
        Rectangle r = new Rectangle(vmsoShip.getX(), vmsoShip.getY(), vmsoShip.getWidth(), vmsoShip.getWidth());
        Rectangle p = new Rectangle(enemy1.getX(), enemy1.getY(), enemy1.getWidth(), enemy1.getHeight());
        Rectangle q = new Rectangle(enemy2.getX(), enemy2.getY(), enemy2.getWidth(), enemy2.getHeight());
        Rectangle d = new Rectangle(enemy3.getX(), enemy3.getY(), enemy3.getWidth(), enemy3.getHeight());

        if (r.intersects(p)){
            gameEnd();

        }
        if (r.intersects(q)) {
            gameEnd();

        }
        if (r.intersects(d)){
            gameEnd();
        }
    }

    public void gameEnd() {
        EndScreen ex = new EndScreen();
        ex.setVisible(true);
        status = false;
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


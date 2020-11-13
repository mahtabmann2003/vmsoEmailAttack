import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;

public class Board extends JPanel {

    private Timer timer;
    private Sprite enemy1, enemy2, enemy3, vmsoShip;
    String username;
    private boolean status;
    private long score, startTime, endTime;



    public Board(String name) throws IOException {
        username = name;
        initBoard();
    }

    private void initBoard() throws IOException {

        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);


        enemy1 = new Sprite("assets/gmail.png",2,0, ThreadLocalRandom.current().nextInt(0,  700), -500);
        enemy2 = new Sprite("assets/gmail.png", 3,0, ThreadLocalRandom.current().nextInt(0,  700), -540);
        enemy3 = new Sprite("assets/gmail.png", 4,0, ThreadLocalRandom.current().nextInt(0,  700), -560);
        vmsoShip = new Sprite("assets/vmso.png", 0,0, 250,390);

        status = true;
        startTime = System.currentTimeMillis();
        timer = new Timer();
        timedLoop();

    }

    private void timedLoop(){
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    gameLoop();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 100, 10);
    }

    private void gameLoop() throws IOException { //Game logic done here...loops repeats every 0.1 second
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

    public void collisionCheck() throws IOException {
        Rectangle r = new Rectangle(vmsoShip.getX(), vmsoShip.getY(), vmsoShip.getWidth() - 25, vmsoShip.getHeight());
        Rectangle p = new Rectangle(enemy1.getX(), enemy1.getY(), enemy1.getWidth()-20, enemy1.getHeight() - 20);
        Rectangle q = new Rectangle(enemy2.getX(), enemy2.getY(), enemy2.getWidth()-20, enemy2.getHeight() - 20);
        Rectangle d = new Rectangle(enemy3.getX(), enemy3.getY(), enemy3.getWidth()-20, enemy3.getHeight() - 20);

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

    public void gameEnd() throws IOException {
        status = false;
        endTime = System.currentTimeMillis();
        score = (endTime - startTime)/1000;

        String fileData = "";
        String fileName = "";

        //Gets current high score + name
        Scanner myReader = new Scanner(new File("score.txt"));
        while (myReader.hasNextLine()) {
            fileData = myReader.nextLine();
            fileName = myReader.nextLine();
        }
        myReader.close();

        //If new score is higher it will rewrite old score
        FileWriter myWriter = new FileWriter("score.txt");
        BufferedWriter out = new BufferedWriter(myWriter);
        if(score > Integer.parseInt(fileData)){
            out.write(Long.toString(score));
            out.newLine();
            out.write(username);
        }
        else {
            out.write(fileData);
            out.newLine();
            out.write(fileName);
        }
        out.close();

        //Open game over window
        EndScreen ex = new EndScreen(score, username);
        ex.setVisible(true);

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


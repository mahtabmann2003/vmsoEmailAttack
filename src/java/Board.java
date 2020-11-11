import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private VmsoCharacter player;
    private Enemy enemy;

    private final int DELAY = 10;

    public Board() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        player = new VmsoCharacter();
        enemy = new Enemy();
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

        g2d.drawImage(player.getImage(), player.getX(), 390, this);
        g2d.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), this);

//        System.out.println("x: "+spaceShip.getX());
//        System.out.println("y: "+spaceShip.getY());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        step();
        spawnEnemy();
    }

    private void step() {

        player.move();

        repaint(player.getX()-1, 390,
                player.getWidth()+2, player.getHeight()+2);
    }

    private void spawnEnemy(){
        enemy.move();

        repaint(enemy.getX()-1, enemy.getY(),
                enemy.getWidth()+2, enemy.getHeight()+2);

    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);

        }
    }
}
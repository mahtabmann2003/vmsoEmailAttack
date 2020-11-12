import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class VmsoShip {
    private int dx;
    private int dy;
    private int x = 300;
    private int y = 390;
    private int w;
    private int h;
    private Image image;


    public VmsoShip() {
        loadImage();
    }
    private void loadImage() {
        ImageIcon ii = new ImageIcon("vmso.png");
        image = ii.getImage();

        w = image.getWidth(null);
        h = image.getHeight(null);
    }
    public void move() {
        x += dx;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getWidth() {
        return w;
    }
    public int getHeight() {
        return h;
    }
    public Image getImage() {
        return image;
    }
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

         if (key == KeyEvent.VK_LEFT) {
            dx = -5;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 5;
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, w, h);
    }
}

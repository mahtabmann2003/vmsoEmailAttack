import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class VmsoCharacter {

    private int dx;
    private int dy;
    private int x = 40;
    private int y = 390;
    private int w;
    private int h;
    private Image image;

    public VmsoCharacter() {

        loadImage();
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon("spaceship.png");
        image = ii.getImage();

        w = image.getWidth(null);
        h = image.getHeight(null);
    }

    public void move() {

        x += dx;
        y += dy;
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
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
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
}

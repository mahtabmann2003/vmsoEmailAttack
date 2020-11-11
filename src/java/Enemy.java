import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.util.concurrent.ThreadLocalRandom;

public class Enemy {



    private int x = ThreadLocalRandom.current().nextInt(-0,  700);
    private int y = 0;
    private int w;
    private int h;
    private Image image;




    public Enemy() {

        loadImage();
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon("mail.png");
        image = ii.getImage();

        w = image.getWidth(null);
        h = image.getHeight(null);
    }

    public void move() {
        y += 2;
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

}

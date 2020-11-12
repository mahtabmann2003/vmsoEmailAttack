import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.ThreadLocalRandom;

public class Sprite {
    private int x;
    private int y;
    private int speedx;
    private int speedy;
    private int width;
    private int height;
    private boolean visible;
    private Image image;


    public Sprite(String imageName, int speedy, int speedx, int x, int y) {
        this.x = x;
        this.y = y;
        this.speedy = speedy;
        this.speedx = speedx;
        loadImage(imageName);
        visible = true;
    }

    private void loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();

        width = image.getWidth(null);
        height = image.getHeight(null);

    }

    public void move () {
        if (this.y<500){
            this.y += this.speedy;
            this.x += this.speedx;
        }
        else {
            this.x = ThreadLocalRandom.current().nextInt(0,  700);
            this.y = ThreadLocalRandom.current().nextInt(-300,  -50);
        }

    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            this.speedx = -5;
        }

        if (key == KeyEvent.VK_RIGHT) {
            this.speedx = 5;
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            this.speedx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            this.speedx = 0;
        }
    }

    public void setSpeed(int speedx){
        this.speedx = 0;
    }





    public Image getImage() {
        return image;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getWidth(){return width;}
    public int getHeight(){return height;}
    public boolean isVisible() {
        return visible;
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}

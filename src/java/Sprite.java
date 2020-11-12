import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Sprite {
    private int x;
    private int y;
    private int speed;
    private int width;
    private int height;
    private boolean visible;
    private Image image;


    public Sprite(String imageName, int speed) {
        this.x = ThreadLocalRandom.current().nextInt(0,  700);
        this.y = 0;
        this.speed = speed;
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
            this.y += this.speed;
        }
        else {
            this.x = ThreadLocalRandom.current().nextInt(0,  700);
            this.y = ThreadLocalRandom.current().nextInt(-150,  -50);
        }

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

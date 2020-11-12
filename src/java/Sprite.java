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


    public Sprite(String imageName) {
        this.x = ThreadLocalRandom.current().nextInt(0,  700);
        this.y = 0;
        loadImage(imageName);
        visible = true;
    }

    private void loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();

        width = image.getWidth(null);
        height = image.getHeight(null);

    }

    public void move (int speed) {
        if (this.y<500){
            this.y += speed;
        }
        else {
            this.x = ThreadLocalRandom.current().nextInt(0,  700);
            this.y = 0;
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

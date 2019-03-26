import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.lang.IllegalArgumentException;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
 
public class Background {
    private BufferedImage bg;
 
    private int x;
    private int y;
 
    public Background() {
        this(0,0);
    }
 
    public Background(int x, int y) {
        this.x = x;
        this.y = y;
 
        try {
            bg = ImageIO.read(new File("Finalfinal/background.jpg"));
        }
        catch (Exception e) { 
            System.out.println(e); 
        }
 
    }
    public void draw(Graphics window) {
 
        
        window.drawImage(bg, getX(), getY(), bg.getWidth(), bg.getHeight(), null);
 
        this.x -= 5;

        if (this.x <= -1 * bg.getWidth()) {
            this.x = this.x + bg.getWidth() * 2;
        }
 
    }
 
    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int getImageWidth() {
        return bg.getWidth();
    }
}
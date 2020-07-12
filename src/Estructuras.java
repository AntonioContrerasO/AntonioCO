import javax.swing.*;
import java.awt.*;

public class Estructuras extends JPanel {
    private final int x;
    private final int y;
    private final int width;
    private final int height =10;

    public Estructuras(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x,y,width,height);
    }

    @Override
    public Rectangle getBounds(Rectangle rv) {
        return new Rectangle(x,y,width,height);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
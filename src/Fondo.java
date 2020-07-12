import javax.swing.*;
import java.awt.*;

public class Fondo extends JPanel {

    private Image image;
    private String nombre;


    public Fondo(String nombre) {
        this.nombre = nombre;

    }

    @Override
    public void paint(Graphics g)
    {
        image = new ImageIcon(getClass().getResource("./Imagenes/"+nombre+".png")).getImage();
        g.drawImage(image,0,0,getWidth(),getHeight(),this);
        setOpaque(false);
        super.paint(g);
    }
}
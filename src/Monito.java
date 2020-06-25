import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

class Monito extends JPanel{

    BufferedImage imagen;
    int x = 0;
    int y = 0;
    int width = 64;
    int height = 64;
    BufferedImage imagen2;
    BufferedImage subImagen2;

    private int z = 0;


    public Monito(BufferedImage imagen)
    {
        this.imagen = imagen;
        try {
            imagen2 = ImageIO.read(new File("src/Imagenes/medallas.png"));
        } catch (Exception e) {
            System.out.println("Error al cargar imagen");
        }
    }
    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        g.drawImage(imagen,0,0,width,height,null);
        //g.fillOval(25,50,35, 10);
    }
    public void pintar(Graphics e)
    {
        subImagen2 = imagen2.getSubimage(0, z, 200, 200);
        e.drawImage(subImagen2, 10, 30, 50, 50, null);
    }
    public Rectangle getBounds()
    {
        return new Rectangle(x+20,y+50,22,25);
    }

    public void setZ(int z) {
        this.z = z;
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}

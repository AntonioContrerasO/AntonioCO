import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class Title extends JPanel {

    private BufferedImage image;
    private int width;
    private int height;

    public Title(String string,int width, int height)  {
        try{
            this.image = ImageIO.read(new File("src/Imagenes/"+string+".png"));
        }catch(Exception e)
        {
            System.out.println("Error al cargar la imagen");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        g.drawImage(image,0,0,width,height,this);
    }

}

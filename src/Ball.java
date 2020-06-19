import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Ball extends JPanel
{
    private int x;
    private int y;
    private int z;
    private int dir;
    int width = 40;
    int height = 40;
    int posicion;

    private final int VEL = 5;
    private final int TAM = 150;

    BufferedImage imagen2;
    BufferedImage subImagen2;

    public Ball(int x, int y)
    {
        this.x = x;
        this.y = y;
        dir = 1;
        try {
            imagen2 = ImageIO.read(new File("src/Imagenes/meteorito.png"));
        } catch (Exception e) {
            System.out.println("Error al cargar imagen");
        }
    }

    public void pintar(Graphics g)
    {
        //g.fillOval(x,y,30,30);
        if(posicion==0)
        {
            z=360;
        }
        else if (posicion == 1)
        {
            z=240;
        }
        else if (posicion ==2)
        {
            z=720;
        }
        else if (posicion ==3)
        {
            z=840;
        }
        else if (posicion ==4)
        {
            z=120;
        }
        else if (posicion ==5)
        {
            z=480;
        }
        else if (posicion ==6)
        {
            z=0;
        }
        else if (posicion ==7)
        {
            z=600;
        }
        subImagen2 = imagen2.getSubimage(0,z, 120, 120);
        g.drawImage(subImagen2,x,y,width,height,null);
        //g.fill3DRect(x+5,y+5,20,20,true);
    }

    public void mover()
    {
        if(dir==0)
        {
            y+= VEL;
            posicion = 0;
        }
        else if(dir==1)
        {
            y-= VEL;
            posicion = 1;
        }
        else if(dir==2)
        {
            x+= VEL;
            posicion = 2;
        }
        else if(dir==3)
        {
            x-= VEL;
            posicion = 3;
        }
        else if(dir==4)
        {
            x+= VEL; y+= VEL;
            posicion = 4;
        }
        else if(dir==5)
        {
            x-= VEL; y-= VEL;
            posicion = 5;
        }
        else if(dir==6)
        {
            x-= VEL; y+= VEL;
            posicion = 6;
        }
        else if(dir==7)
        {
            x+= VEL; y-= VEL;
            posicion = 7;
        }
    }

    public void rebotar(int limX, int limY)
    {
        if(y<=0)
        {
            int nr = (int)(Math.random()*3)+1;
            dir = nr == 1 ? 6 : nr == 2 ? 0: 4;
        }
        else if(x<=0)
        {
            int nr = (int)(Math.random()*3)+1;
            dir = nr == 1 ? 7 : nr == 2 ? 2: 4;
        }
        else if(y>=limY - TAM)
        {
            int nr = (int)(Math.random()*3)+1;
            dir = nr == 1 ? 5 : nr == 2 ? 1: 7;
        }
        else if(x>=limX - TAM)
        {
            int nr = (int)(Math.random()*3)+1;
            dir = nr == 1 ? 6 : nr == 2 ? 3: 5;
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) { this.y = y; }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDir() {
        return dir;
    }

    public Rectangle getBounds()
    {
        return new Rectangle(x+5,y+5,15,15);
    }



}


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

class Monito extends JPanel  {
    //Imagenes
    BufferedImage imagen;
    BufferedImage subImagen;
    private final int width = 64;
    private final int height = 64;
    private int indiceX = 0;
    private volatile int sentido = 0;
    //Movimiento vertical
    private int y;
    public boolean jumping = false;
    public long jumpingTime = 200;
    private int numBrincos = 0;

    //Movimiento horizontal
    private int x;
    public Rectangle bottomBox;

    Game game;

    public Monito(String mono,Game game, int x, int y)
    {
        this.x = x;
        this.y = y;
        this.game = game;

        try {
            this.imagen = ImageIO.read(new File("src/Imagenes/"+mono+".png"));
        } catch (Exception e) {
            System.out.println("Error al cargar imagen");
        }
        subImagen = imagen.getSubimage(0, 0, 82, 82);
        bottomBox = new Rectangle(0,500,200,30);

    }

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        g.drawImage(subImagen,0,0,width,height,null);
        if (jumping && y>0 && numBrincos<=2)
        {
            y-=20;
            if (sentido==0)
            {
                x+=10;
            }
            if(sentido==1)
            {
                x-=10;
            }
        }
        if (!jumping && y<350 && x>170)
        {
            y+=5;
            if(y==350)
            {
                numBrincos = 0;
            }
        }
        if (!jumping && (game.getWidth()/4)-30>this.x)
        {
            y+=5;
        }
        if (!jumping && this.x>880)
        {
            y+=5;
        }
        if (!jumping && this.y>350)
        {
            y+=5;
        }

    }
    public Rectangle getBounds()
    {
        return new Rectangle(x+20,y+30,50,50);
    }

    public void keyReleased(KeyEvent e) {
        if (sentido == 0) {
            subImagen = imagen.getSubimage(0, 0, 82, 82);
        }
        if (sentido == 1) {
            subImagen = imagen.getSubimage(574, 82, 82, 82);
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar()=='d') {
            indiceX = ((indiceX + 1) % 7) * 82;
            subImagen = imagen.getSubimage(indiceX, 0, 82, 82);
            sentido = 0;
            if (x<game.getWidth()-70) {
                //y = y+ya;
                x = x + 10;
                this.setLocation(x, y);
            }
            System.out.println(x+" "+y);
        }
        else if(e.getKeyChar()=='a')
        {

            indiceX = ((indiceX + 1) % 7) * 82;
            subImagen = imagen.getSubimage(indiceX,82,82,82);
            sentido = 1;
            if (x>-5)
            {
               // y = y+ya;
                x = x-10;
                this.setLocation(x,y);
            }
            System.out.println(x+" "+y);
        }
        if (e.getKeyChar() == KeyEvent.VK_SPACE)
        {
            jumping = true;
            if (sentido==0)
            {
                subImagen = imagen.getSubimage(574,0,82,82);
            }
            if(sentido==1)
            {
                subImagen = imagen.getSubimage(164,82,82,82);
            }
            new Thread(new thread()).start();
        }
    }
    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public int getSentido() {
        return sentido;
    }

    public void setNumBrincos(int numBrincos) {
        this.numBrincos = numBrincos;
    }

    public class thread implements Runnable
    {
        @Override
        public void run() {
            try {
                numBrincos++;
                Thread.sleep(jumpingTime);
                jumping = false;
            }catch (Exception e)
            {
                e.printStackTrace();
                new Thread(this).start();
                System.exit(0);
            }
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

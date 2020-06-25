import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Game extends JFrame implements KeyListener {

    BufferedImage imagen;
    BufferedImage subImagen;


    Monito monito;
    int indiceX=0;

    int start = 0;

    JPanel panel;
    JLabel tiempo;

    int x;
    int y;
    int ya=1;
    int sentido = 0;
    boolean ciclo=true;
    boolean visibleP = false;
    ArrayList<Ball> balls = new ArrayList<>();
    Cronometro cronometro = new Cronometro();
    Cronometro cronometro2 = new Cronometro();

    private int pelotas=5;
    private int tiempos=10;


    public Game() {

        panel = new Fondo();
        panel.setLayout(null);
        try {
            imagen = ImageIO.read(new File("src/Imagenes/g1.png"));
        } catch (Exception e) {
            System.out.println("Error al cargar imagen");
        }

        subImagen = imagen.getSubimage(0, 0, 82, 82);

        tiempo = new JLabel();
        tiempo.setBounds(950,0,200,50);
        tiempo.setFont(new Font("SansSerif",Font.ITALIC,49));
        tiempo.setForeground(Color.WHITE);
        panel.add(tiempo);

        monito = new Monito(subImagen);
        monito.setOpaque(false);
        monito.setBounds(490, 402, 64, 64);
        monito.setVisible(true);
        panel.add(monito);

        this.add(panel);
        this.setTitle("DinoRUN");
        this.setSize(1000, 600);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        /// Sea agregan los listeners
        this.addKeyListener(this);
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        monito.pintar(g);
        for (int i = 0;i<balls.size();i++) {

            balls.get(i).pintar(g);
            balls.get(i).mover();
            balls.get(i).rebotar(1000,700);

            if (cronometro.tiempo()==tiempos && balls.size()<pelotas)
            {
                balls.add(new Ball(130,0));
                cronometro.setSegundos(0);
            }
            if (monito.getBounds().intersects(balls.get(i).getBounds())&& x!= 0 && y!=0)
            {
                ciclo = false;
            }
            tiempo.setText(String.valueOf(cronometro2.tiempo()));
        }
        cambioNumColor();
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(1000,1000);
    }

    public void keyPressed(KeyEvent e)
    {
        //System.out.println("Tecla presionada = "+e.getKeyCode());
        int t = e.getKeyCode();


        Point pos = monito.getLocation();
         this.x = (int)pos.getX();
         this.y = (int)pos.getY();
        //System.out.println( (int) pos.getX() );

        if(t==68 && x<800)
        {
            x = x+5;
            indiceX = ((indiceX + 1) % 7) * 82;
            monito.imagen = imagen.getSubimage(indiceX,0,82,82);
            if (y>300)
                monito.setLocation(x,y+ya);
            sentido = 0;
            start++;
        }
        else if(t==65 && x>0)
        {
            x = x-5;
            indiceX = ((indiceX + 1) % 7) * 82;
            monito.imagen = imagen.getSubimage(indiceX,82,82,82);
                monito.setLocation(x,y+ya);
            sentido = 1;
            start++;
        }
        if (t==87)
        {
            ya = -1;
        }
        if (t==83)
        {
            ya=1;
        }
        if (start==1)
        {
            cronometro2.setSegundos(0);
            cronometro.setSegundos(0);
            balls.add(new Ball(0,0));
            balls.get(0).rebotar(1000,700);
        }
        monito.setX(x);
        monito.setY(y+ya);

        //System.out.println(x+" "+y);
    }

    public void keyReleased(KeyEvent e) {
        if (sentido == 0) {
            monito.imagen = imagen.getSubimage(0, 0, 82, 82);
        }
        if (sentido == 1) {
            monito.imagen = imagen.getSubimage(574, 82, 82, 82);
        }

    }

    public void keyTyped(KeyEvent e)
    {
        //System.out.println("Tecla en el buffer.");

    }
    public void gameOver()
    {
        String[] opciones = {"Volver a jugar","Volver al menu"};
        ImageIcon icono1 = new ImageIcon("src/Imagenes/gameover.png");
        int opcion = JOptionPane.showOptionDialog(this,"","",0,JOptionPane.QUESTION_MESSAGE,icono1,opciones,"");
        if (opciones[opcion]=="Volver a jugar")
        {
            reset();
        }
        else if (opciones[opcion]=="Volver al menu")
        {
            reset();
            visibleP = true;
        }
        //System.exit(ABORT);
    }

    public void reset()
    {
        balls.clear();
        start = 0;
        cronometro.setSegundos(0);
        cronometro2.setSegundos(0);
        tiempo.setLocation(950,0);
        tiempo.setForeground(Color.WHITE);
        monito.setLocation(490, 402);
        ciclo = true;
        monito.setZ(0);
    }
    public void cambioNumColor()
    {
        if (cronometro2.tiempo() == 10)
        {
            monito.setZ(200);
            tiempo.setLocation(925,0);
            tiempo.setForeground(Color.decode("0x782F00"));
        }
        if (cronometro2.tiempo() == 25)
        {
            monito.setZ(400);
            tiempo.setForeground(Color.decode("0xBC753E"));
        }
        if (cronometro2.tiempo() == 40)
        {
            monito.setZ(600);
            tiempo.setForeground(Color.decode("0x979797"));
        }
        if (cronometro2.tiempo() == 65)
        {
            monito.setZ(800);
            tiempo.setForeground(Color.decode("0xE0A83D"));
        }
        if (cronometro2.tiempo() == 80)
        {
            monito.setZ(1000);
            tiempo.setForeground(Color.decode("0xF3D4B1"));
        }
        if (cronometro2.tiempo() == 100)
        {
            monito.setZ(1200);
            tiempo.setLocation(900,0);
            tiempo.setForeground(Color.decode("0x39BAA5"));
        }
        if (cronometro2.tiempo() == 150)
        {
            monito.setZ(1400);
            tiempo.setForeground(Color.decode("0xB81450"));
        }
    }

    public void setPelotas(int pelotas) {
        this.pelotas = pelotas;
    }

    public void setTiempos(int tiempos) {
        this.tiempos = tiempos;
    }
}
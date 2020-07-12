import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Game extends JFrame implements KeyListener {

    Monito monitoP1;
    Mapas panel;
    JLabel tiempo;

    boolean ciclo=true;
    boolean visibleP = false;
    ArrayList<Ball> balls = new ArrayList<>();

    private final int width = 1200;
    private final int height = 800;


    Cronometro cronometro = new Cronometro();
    Cronometro cronometro2 = new Cronometro();
    JLabel gameover;


    public Game() {

        panel = new Mapas(2,this);
        panel.setLayout(null);


        ImageIcon exitImage = new ImageIcon("src/Imagenes/gameover.png");
        gameover = new JLabel();
        gameover.setBounds((width/2)-225,(height/8),450,300);
        gameover.setIcon(new ImageIcon(exitImage.getImage().getScaledInstance(gameover.getWidth(),gameover.getHeight(), Image.SCALE_SMOOTH)));
        gameover.setVisible(false);


        panel.add(gameover);




        tiempo = new JLabel();
        tiempo.setBounds((width/2)-200,height/2+50,400,200);
        tiempo.setFont(new Font("SansSerif",Font.ITALIC,200));
        tiempo.setForeground(Color.WHITE);
        tiempo.setOpaque(false);
        tiempo.setHorizontalAlignment(SwingConstants.CENTER);
        tiempo.setVerticalAlignment(SwingConstants.CENTER);


        panel.add(tiempo);


        monitoP1 = new Monito("g1",this,490,350);
        monitoP1.setSize(64,64);
        monitoP1.setOpaque(false);
        monitoP1.setVisible(true);
        panel.add(monitoP1);


        this.add(panel);
        this.setTitle("DinoRUN");
        this.setSize(width, height);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        /// Sea agregan los listeners
        this.addKeyListener(this);
    }

    public synchronized void paint(Graphics g) {
        super.paint(g);
        for (int i = 0;i<balls.size();i++) {

            balls.get(i).pintar(g);
            balls.get(i).mover();
            balls.get(i).rebotar(1200,900);
            if (monitoP1.getBounds().intersects(balls.get(i).getBounds()))
            {
                ciclo = false;
                System.out.println("choque");
            }
            if (cronometro.tiempo()==tiempos && balls.size()<pelotas)
            {
                balls.add(new Ball(130,0));
                cronometro.setSegundos(0);
            }
            tiempo.setText(String.valueOf(cronometro2.tiempo()));
        }
        if (monitoP1.getY() == 750)
        {
            tiempo.setVisible(false);
            gameOver();
        }
        cambioNumColor();
        /*
        try {
           /* for (Ball ball:balls) {
                ball.pintar(g);
                ball.mover();
                if (ball.getX() == monitoP1.getX() - 200 || ball.getX() == monitoP1.getX() + 200) {
                    balls.remove(ball);
                    System.out.println("Distancia");
                    break;
                }
                if (ball.getBounds().intersects(new Rectangle(monitoP2.getX()+30,monitoP2.getY(),22,64))) {
                    balls.remove(ball);
                    System.out.println("Colision");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Bola borrada");
        }
        if (this.getBounds().intersects(panel.mapa1.get(0).getBounds()))
        {
            System.out.println("choque");
        }*/

      /*  if (monitoP1.getBounds().intersects(new Rectangle(200,200,100,20))&& x!=0);
        {
            monitoP1.tabla = true;
            System.out.println("choque");
            if (!monitoP1.getBounds().intersects(200,200,100,20))
            {
                monitoP1.tabla = false;
            }
        }*/
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(1000,1000);
    }
    int start = 0 ;
    public synchronized void keyPressed(KeyEvent e)
    {
        monitoP1.keyPressed(e);
        if (start == 0)
        {
            balls.add(new Ball(0,0));
            start++;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        monitoP1.keyReleased(e);
    }

    public void keyTyped(KeyEvent e)
    {
        //System.out.println("Tecla en el buffer.");

    }
    public void gameOver()
    {
        gameover.setVisible(true);
        String[] opciones = {"Volver a jugar","Volver al menu"};
        int opcion = JOptionPane.showOptionDialog(this,"","",0,JOptionPane.QUESTION_MESSAGE,null,opciones,"");
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
        monitoP1.setX(490);
        monitoP1.setY(350);
        ciclo = true;
        start = 0;
        monitoP1.setNumBrincos(0);
        cronometro.setSegundos(0);
        cronometro2.setSegundos(0);
        tiempo.setForeground(Color.WHITE);
        gameover.setVisible(false);
    }
    public void cambioNumColor()
    {
        if (cronometro2.tiempo() == 10)
        {
            tiempo.setForeground(Color.decode("0x782F00"));
        }
        if (cronometro2.tiempo() == 25)
        {
            tiempo.setForeground(Color.decode("0xBC753E"));
        }
        if (cronometro2.tiempo() == 40)
        {
            tiempo.setForeground(Color.decode("0x979797"));
        }
        if (cronometro2.tiempo() == 65)
        {
            tiempo.setForeground(Color.decode("0xE0A83D"));
        }
        if (cronometro2.tiempo() == 80)
        {
            tiempo.setForeground(Color.decode("0xF3D4B1"));
        }
        if (cronometro2.tiempo() == 100)
        {
            tiempo.setForeground(Color.decode("0x39BAA5"));
        }
        if (cronometro2.tiempo() == 150)
        {
            tiempo.setForeground(Color.decode("0xB81450"));
        }
    }

    int pelotas = 5;
    int tiempos = 10;

    public void setTiempos(int tiempos) {
        this.tiempos = tiempos;
    }

    public void setPelotas(int pelotas) {
        this.pelotas = pelotas;
    }
}
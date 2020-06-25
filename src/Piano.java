import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Piano extends JFrame implements ActionListener {

    JLayeredPane pane;
    JTextArea txt;
    MiReproductor m = new MiReproductor();

    private int lowHigh;

    //Botones Extra
    JButton fondo;
    JButton back;
    JButton flauta;
    JButton piano ;
    JButton guitarra;
    JButton arpa;
    JButton violin;
    JButton high;
    JButton low;

    JLabel highL;
    JLabel lowL;

    JTextField txtf1;

    JButton leer;
    JButton guardar;
    JTextField txtf;



    //notas B
    JButton note1;
    JButton note2;
    JButton note3;
    JButton note4;
    JButton note5;
    JButton note6;
    JButton note7;
    JButton note8;
    JButton note9;
    JButton note10;
    JButton note11;
    JButton note12;
    JButton note13;
    JButton note14;
    //notas N
    JButton noteN1;
    JButton noteN2;
    JButton noteN3;
    JButton noteN4;
    JButton noteN5;
    JButton noteN6;
    JButton noteN7;
    JButton noteN8;
    JButton noteN9;
    JButton noteN10;


    ArrayList<String> contenido_1;
    ArrayList<Integer> contenidoInt = new ArrayList<Integer>();
    ArrayList<Integer> contenidoDur = new ArrayList<Integer>();




    public Piano() {

        pane = new JLayeredPane();
        pane.setLayout(null);

        //txt
        txt = new JTextArea();
        txt.setBounds(1120,10,200,300);
        txtf = new JTextField();
        txtf.setBounds(1320,50,100,40);
        leer = new JButton("LEER");
        leer.setBounds(1320,10,100,40);
        guardar = new JButton("GUARDAR");
        guardar.setBounds(1320,90,100,40);

        //Notas Blancas
        note1 = new JButton();
        note1.setBounds(4,385,106,479);
        note1.setBackground(Color.WHITE);
        note2 = new JButton();
        note2.setBounds(114,385,106,479);
        note2.setBackground(Color.WHITE);
        note3 = new JButton();
        note3.setBounds(224,385,106,479);
        note3.setBackground(Color.WHITE);
        note4 = new JButton();
        note4.setBounds(334,385,106,479);
        note4.setBackground(Color.WHITE);
        note5 = new JButton();
        note5.setBounds(444,385,106,479);
        note5.setBackground(Color.WHITE);
        note6 = new JButton();
        note6.setBounds(554,385,106,479);
        note6.setBackground(Color.WHITE);
        note7 = new JButton();
        note7.setBounds(664,385,106,479);
        note7.setBackground(Color.WHITE);
        note8 = new JButton();
        note8.setBounds(774,385,106,479);
        note8.setBackground(Color.WHITE);
        note9 = new JButton();
        note9.setBounds(884,385,106,479);
        note9.setBackground(Color.WHITE);
        note10 = new JButton();
        note10.setBounds(994,385,106,479);
        note10.setBackground(Color.WHITE);
        note11 = new JButton();
        note11.setBounds(1104,385,106,479);
        note11.setBackground(Color.WHITE);
        note12 = new JButton();
        note12.setBounds(1214,385,106,479);
        note12.setBackground(Color.WHITE);
        note13 = new JButton();
        note13.setBounds(1324,385,106,479);
        note13.setBackground(Color.WHITE);
        note14 = new JButton();
        note14.setBounds(1434,385,106,479);
        note14.setBackground(Color.WHITE);

        //Notas negras
        noteN1 = new JButton();
        noteN1.setBounds(80,385,65,340);
        noteN1.setBackground(Color.BLACK);
        noteN2 = new JButton();
        noteN2.setBounds(190,385,65,340);
        noteN2.setBackground(Color.BLACK);
        noteN3 = new JButton();
        noteN3.setBounds(410,385,65,340);
        noteN3.setBackground(Color.BLACK);
        noteN4 = new JButton();
        noteN4.setBounds(520,385,65,340);
        noteN4.setBackground(Color.BLACK);
        noteN5 = new JButton();
        noteN5.setBounds(630,385,65,340);
        noteN5.setBackground(Color.BLACK);
        noteN6 = new JButton();
        noteN6.setBounds(850,385,65,340);
        noteN6.setBackground(Color.BLACK);
        noteN7 = new JButton();
        noteN7.setBounds(960,385,65,340);
        noteN7.setBackground(Color.BLACK);
        noteN8 = new JButton();
        noteN8.setBounds(1180,385,65,340);
        noteN8.setBackground(Color.BLACK);
        noteN9= new JButton();
        noteN9.setBounds(1290,385,65,340);
        noteN9.setBackground(Color.BLACK);
        noteN10 = new JButton();
        noteN10.setBounds(1400,385,65,340);
        noteN10.setBackground(Color.BLACK);

        //Botones Cambio de instrumento
        flauta = new MiBoton();
        flauta.setBounds(100,80,200,200);
        ImageIcon r = new ImageIcon("src/Imagenes/Flau.png");
        flauta.setIcon(new ImageIcon(r.getImage().getScaledInstance(flauta.getWidth(),flauta.getHeight(), Image.SCALE_SMOOTH)));
        flauta.setContentAreaFilled(false);
        flauta.setBorder(null);

        violin = new MiBoton();
        violin.setBounds(300,80,200,200);
        ImageIcon r1 = new ImageIcon("src/Imagenes/Vio.png");
        violin.setIcon(new ImageIcon(r1.getImage().getScaledInstance(violin.getWidth(),violin.getHeight(), Image.SCALE_SMOOTH)));
        violin.setContentAreaFilled(false);
        violin.setBorder(null);

        piano = new MiBoton();
        piano.setBounds(500,80,200,200);
        ImageIcon r2 = new ImageIcon("src/Imagenes/PI.png");
        piano.setIcon(new ImageIcon(r2.getImage().getScaledInstance(piano.getWidth(),piano.getHeight(), Image.SCALE_SMOOTH)));
        piano.setContentAreaFilled(false);
        piano.setBorder(null);

        arpa = new MiBoton();
        arpa.setBounds(700,80,200,200);
        ImageIcon r3 = new ImageIcon("src/Imagenes/arpa.png");
        arpa.setIcon(new ImageIcon(r3.getImage().getScaledInstance(arpa.getWidth(),arpa.getHeight(), Image.SCALE_SMOOTH)));
        arpa.setContentAreaFilled(false);
        arpa.setBorder(null);

        guitarra = new MiBoton();
        guitarra.setBounds(900,80,200,200);
        ImageIcon r4 = new ImageIcon("src/Imagenes/GuiA.png");
        guitarra.setIcon(new ImageIcon(r4.getImage().getScaledInstance(guitarra.getWidth(),guitarra.getHeight(), Image.SCALE_SMOOTH)));
        guitarra.setContentAreaFilled(false);
        guitarra.setBorder(null);

        //Fondo EE
        fondo = new JButton();
        fondo.setBounds(0,0,1536,900);
        ImageIcon i = new ImageIcon("src/Imagenes/G.png");
        fondo.setIcon(new ImageIcon(i.getImage().getScaledInstance(fondo.getWidth(),fondo.getHeight(), Image.SCALE_SMOOTH)));
        fondo.setBorder(null);


        //Boton Volver
        back = new MiBoton();
        back.setBounds(0,0,70,70);
        ImageIcon i1 = new ImageIcon("src/Imagenes/flecha.png");
        back.setIcon(new ImageIcon(i1.getImage().getScaledInstance(back.getWidth(),back.getHeight(), Image.SCALE_SMOOTH)));
        back.setContentAreaFilled(false);
        back.setBorder(null);

        //High & Lower
        high = new MiBoton();
        high.setBounds(520,10,70,70);
        ImageIcon r5 = new ImageIcon("src/Imagenes/proximo.png");
        high.setIcon(new ImageIcon(r5.getImage().getScaledInstance(high.getWidth(),high.getHeight(), Image.SCALE_SMOOTH)));
        high.setContentAreaFilled(false);
        high.setBorder(null);

        highL = new JLabel("HIGH PITCH");
        highL.setBounds(600,20,300,50);
        highL.setFont(new Font("SansSerif",Font.PLAIN,50));
        highL.setForeground(Color.WHITE);

        low = new MiBoton();
        low.setBounds(450,10,70,70);
        ImageIcon r6 = new ImageIcon("src/Imagenes/espalda.png");
        low.setIcon(new ImageIcon(r6.getImage().getScaledInstance(low.getWidth(),low.getHeight(), Image.SCALE_SMOOTH)));
        low.setContentAreaFilled(false);
        low.setBorder(null);

        lowL = new JLabel("LOW PITCH");
        lowL.setBounds(150,20,300,50);
        lowL.setFont(new Font("SansSerif",Font.PLAIN,50));
        lowL.setForeground(Color.WHITE);

        txtf1 = new JTextField();
        txtf1.setBounds(1500, 5, 150, 30);


        //Panel
        pane.add(guardar,new Integer(2));
        pane.add(leer,new Integer(2));
        pane.add(txt, new Integer(2));
        pane.add(txtf,new Integer(2));
        pane.add(txtf1,new Integer(2));
        pane.add(fondo,new Integer(1));
        pane.add(back,new Integer(2));
        pane.add(high,new Integer(2));
        pane.add(highL,new Integer(2));
        pane.add(lowL,new Integer(2));
        pane.add(low,new Integer(2));

        //Notas negras
        pane.add(noteN1,new Integer(3));
        pane.add(noteN2,new Integer(3));
        pane.add(noteN3,new Integer(3));
        pane.add(noteN4,new Integer(3));
        pane.add(noteN5,new Integer(3));
        pane.add(noteN6,new Integer(3));
        pane.add(noteN7,new Integer(3));
        pane.add(noteN8,new Integer(3));
        pane.add(noteN9,new Integer(3));
        pane.add(noteN10,new Integer(3));

        //Notas blancas
        pane.add(note1,new Integer(2));
        pane.add(note2,new Integer(2));
        pane.add(note3,new Integer(2));
        pane.add(note4,new Integer(2));
        pane.add(note5,new Integer(2));
        pane.add(note6,new Integer(2));
        pane.add(note7,new Integer(2));
        pane.add(note8,new Integer(2));
        pane.add(note9,new Integer(2));
        pane.add(note10,new Integer(2));
        pane.add(note11,new Integer(2));
        pane.add(note12,new Integer(2));
        pane.add(note13,new Integer(2));
        pane.add(note14,new Integer(2));

        //Cambio
        pane.add(flauta,new Integer(2));
        pane.add(violin,new Integer(2));
        pane.add(piano,new Integer(2));
        pane.add(arpa,new Integer(2));
        pane.add(guitarra,new Integer(2));

        this.getContentPane().add(pane);
        this.setFocusable(true);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        m.inicializar();
        //Notas blancas
        back.addActionListener(this);
        note1.addActionListener(this);
        note2.addActionListener(this);
        note3.addActionListener(this);
        note4.addActionListener(this);
        note5.addActionListener(this);
        note6.addActionListener(this);
        note7.addActionListener(this);
        note8.addActionListener(this);
        note9.addActionListener(this);
        note10.addActionListener(this);
        note11.addActionListener(this);
        note12.addActionListener(this);
        note13.addActionListener(this);
        note14.addActionListener(this);

        //Notas negras
        noteN1.addActionListener(this);
        noteN2.addActionListener(this);
        noteN3.addActionListener(this);
        noteN4.addActionListener(this);
        noteN5.addActionListener(this);
        noteN6.addActionListener(this);
        noteN7.addActionListener(this);
        noteN8.addActionListener(this);
        noteN9.addActionListener(this);
        noteN10.addActionListener(this);

        //Cambiar Instrumento
        arpa.addActionListener(this);
        piano.addActionListener(this);
        flauta.addActionListener(this);
        guitarra.addActionListener(this);
        violin.addActionListener(this);

        //Subir pitch
        low.addActionListener(this);
        high.addActionListener(this);
        guardar.addActionListener(this);
        leer.addActionListener(this);

        eventosDelTeclado();

   }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == note1)
        {
            m.reproducirNota(60+lowHigh,1,250);
        }
        if(e.getSource() == noteN1)
        {
            m.reproducirNota(61+lowHigh,1,250);
        }
        if(e.getSource() == note2)
        {
            m.reproducirNota(62+lowHigh,1,250);
        }
        if(e.getSource() == noteN2)
        {
            m.reproducirNota(63+lowHigh,1,250);
        }
        if(e.getSource() == note3)
        {
            m.reproducirNota(64+lowHigh,1,250);
        }
        if(e.getSource() == note4)
        {
            m.reproducirNota(65+lowHigh,1,250);
        }
        if(e.getSource() == noteN3)
        {
            m.reproducirNota(66+lowHigh,1,250);
        }
        if(e.getSource() == note5)
        {
            m.reproducirNota(67+lowHigh,1,250);
        }
        if(e.getSource() == noteN4)
        {
            m.reproducirNota(68+lowHigh,1,250);
        }
        if(e.getSource() == note6)
        {
            m.reproducirNota(69+lowHigh,1,250);
        }
        if(e.getSource() == noteN5)
        {
            m.reproducirNota(70+lowHigh,1,250);
        }
        if(e.getSource() == note7)
        {
            m.reproducirNota(71+lowHigh,1,250);
        }
        if(e.getSource() == note8)
        {
            m.reproducirNota(72+lowHigh,1,250);
        }
        if(e.getSource() == noteN6)
        {
            m.reproducirNota(73+lowHigh,1,250);
        }

        if(e.getSource() == note9)
        {
            m.reproducirNota(74+lowHigh,1,250);
        }
        if(e.getSource() == noteN7)
        {
            m.reproducirNota(75+lowHigh,1,250);
        }

        if(e.getSource() == note10)
        {
            m.reproducirNota(76+lowHigh,1,250);
        }
        if(e.getSource() == note11)
        {
            m.reproducirNota(77+lowHigh,1,250);
        }
        if(e.getSource() == noteN8)
        {
            m.reproducirNota(78+lowHigh,1,250);
        }

        if(e.getSource() == note12)
        {
            m.reproducirNota(79+lowHigh,1,250);
        }
        if(e.getSource() == noteN9)
        {
            m.reproducirNota(80+lowHigh,1,250);
        }
        if(e.getSource() == note13)
        {
            m.reproducirNota(81+lowHigh,1,250);
        }
        if(e.getSource() == noteN10)
        {
            m.reproducirNota(82+lowHigh,1,250);
        }

        if(e.getSource() == note14)
        {
            m.reproducirNota(83+lowHigh,1,250);
        }
        if (e.getSource() == piano)
        {
            m.cambiarInstrumento(0,0);
        }
        if (e.getSource() == arpa)
        {
            m.cambiarInstrumento(0,46);
        }
        if (e.getSource() == violin)
        {
            m.cambiarInstrumento(0,40);
        }
        if (e.getSource() == flauta)
        {
            m.cambiarInstrumento(0,73);
        }
        if (e.getSource() == guitarra)
        {
            m.cambiarInstrumento(1024,25);
        }
        if (e.getSource() == low)
        {
            if (lowHigh>-36)
            {
                lowHigh -=12;
            }

        }
        if (e.getSource() == high)
        {
            if (lowHigh<36)
            {
                lowHigh += 12;
            }
        }
        if (e.getSource() == leer)
        {

                contenido_1 = Archivo.leerTodo(txtf.getText());
                String cadena = "";

                for (String s : contenido_1) {
                    cadena = cadena + s + "\n";
                    contenidoInt.add(Integer.parseInt(s.substring(0,2)));
                    contenidoDur.add(Integer.parseInt(s.substring(3,s.indexOf("f"))));
                    txt.setText(cadena);
                }
                for (int x=0;x<contenido_1.size();x++)
                {
                    m.reproducirNota(contenidoInt.get(x) ,1 ,contenidoDur.get(x));
                }
                contenido_1.clear();

        }
        if (e.getSource() == this.guardar) {

            String contenido_2;
            contenido_2 = txt.getText();
            String nombre = txtf.getText();
            Archivo.guardarTodo(nombre, contenido_2);
        }
    }

    private int x = 100;


    private void eventosDelTeclado()
    {
        KeyListener eventoTeclado = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                x+=100;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyChar() == 'q')
                    m.reproducirNota(60+lowHigh,1,x);
                if (e.getKeyChar() == '2')
                    m.reproducirNota(61+lowHigh,1,x);
                if (e.getKeyChar() == 'w')
                    m.reproducirNota(62+lowHigh,1,x);
                if (e.getKeyChar() == '3')
                    m.reproducirNota(63+lowHigh,1,x);
                if (e.getKeyChar() == 'e')
                    m.reproducirNota(64+lowHigh,1,x);
                if (e.getKeyChar() == 'r')
                    m.reproducirNota(65+lowHigh,1,x);
                if (e.getKeyChar() == '5')
                    m.reproducirNota(66+lowHigh,1,x);
                if (e.getKeyChar() == 't')
                    m.reproducirNota(67+lowHigh,1,x);
                if (e.getKeyChar() == '6')
                    m.reproducirNota(68+lowHigh,1,x);
                if (e.getKeyChar() == 'y')
                    m.reproducirNota(69+lowHigh,1,x);
                if (e.getKeyChar() == '7')
                    m.reproducirNota(70+lowHigh,1,x);
                if (e.getKeyChar() == 'u')
                    m.reproducirNota(71+lowHigh,1,x);
                if (e.getKeyChar() == 'z')
                    m.reproducirNota(72+lowHigh,1,x);
                if (e.getKeyChar() == 's')
                    m.reproducirNota(73+lowHigh,1,x);
                if (e.getKeyChar() == 'x')
                    m.reproducirNota(74+lowHigh,1,x);
                if (e.getKeyChar() == 'd')
                    m.reproducirNota(75+lowHigh,1,x);
                if (e.getKeyChar() == 'c')
                    m.reproducirNota(76+lowHigh,1,x);
                if (e.getKeyChar() == 'v')
                    m.reproducirNota(77+lowHigh,1,x);
                if (e.getKeyChar() == 'g')
                    m.reproducirNota(78+lowHigh,1,x);
                if (e.getKeyChar() == 'b')
                    m.reproducirNota(79+lowHigh,1,x);
                if (e.getKeyChar() == 'h')
                    m.reproducirNota(80+lowHigh,1,x);
                if (e.getKeyChar() == 'n')
                    m.reproducirNota(81+lowHigh,1,x);
                if (e.getKeyChar() == 'j')
                    m.reproducirNota(82+lowHigh,1,x);
                if (e.getKeyChar() == 'm')
                    m.reproducirNota(83+lowHigh,1,x);
                x=0;
            }
        };setFocusable(true);
        txtf1.addKeyListener(eventoTeclado);
        this.addKeyListener(eventoTeclado);
    }


}
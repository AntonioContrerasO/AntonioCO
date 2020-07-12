import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuegoMenu extends JFrame implements ActionListener {
    JButton back;
    JButton start;
    JButton muteUnMute;

    JButton facil;
    JButton medio;
    JButton dificil;

    JLabel facilT;
    JLabel medioT;
    JLabel dificlT;

    ImageIcon [] dificultad = new ImageIcon[3];

    ImageIcon[] i = new ImageIcon[2];


    Title title = new Title("w",900,700);
    MusicStuff musicStuff = new MusicStuff("W");
    Game game = new Game();

    int x = 0;
    private int count = 0;

    public JuegoMenu() {
        back = new MiBoton();
        back.setBounds(0,0,70,70);
        ImageIcon i1 = new ImageIcon("src/Imagenes/flecha1.png");
        back.setIcon(new ImageIcon(i1.getImage().getScaledInstance(back.getWidth(),back.getHeight(), Image.SCALE_SMOOTH)));
        back.setContentAreaFilled(false);
        back.setBorder(null);

        start = new MiBoton();
        start.setBounds(425,265,100,100);
        ImageIcon i2 = new ImageIcon("src/Imagenes/play.png");
        start.setIcon(new ImageIcon(i2.getImage().getScaledInstance(start.getWidth(),start.getHeight(), Image.SCALE_SMOOTH)));
        start.setContentAreaFilled(false);
        start.setBorder(null);

        muteUnMute = new JButton();
        muteUnMute.setBounds(50,600,50,50);
        i[0] = new ImageIcon("src/Imagenes/altavoz.png");
        i[1] = new ImageIcon("src/Imagenes/mudo.png");
        muteUnMute.setIcon(new ImageIcon(i[count].getImage().getScaledInstance(muteUnMute.getWidth(),muteUnMute.getHeight(), Image.SCALE_SMOOTH)));
        muteUnMute.setContentAreaFilled(false);
        muteUnMute.setBorder(null);

        dificultad[0] = new ImageIcon("src/Imagenes/uno.png");
        dificultad[1] = new ImageIcon("src/Imagenes/dos.png");
        dificultad[2] = new ImageIcon("src/Imagenes/tres.png");

        facil = new MiBoton();
        facil.setBounds(550,10,60,60);
        facil.setIcon(new ImageIcon(dificultad[0].getImage().getScaledInstance(facil.getWidth(),facil.getHeight(), Image.SCALE_SMOOTH)));
        facil.setContentAreaFilled(false);
        facil.setBorder(null);

        medio = new MiBoton();
        medio.setBounds(550,80,60,60);
        medio.setIcon(new ImageIcon(dificultad[1].getImage().getScaledInstance(medio.getWidth(),medio.getHeight(), Image.SCALE_SMOOTH)));
        medio.setContentAreaFilled(false);
        medio.setBorder(null);

        dificil = new MiBoton();
        dificil.setBounds(550,150,60,60);
        dificil.setIcon(new ImageIcon(dificultad[2].getImage().getScaledInstance(dificil.getWidth(),dificil.getHeight(), Image.SCALE_SMOOTH)));
        dificil.setContentAreaFilled(false);
        dificil.setBorder(null);

        facilT = new JLabel("FACIL");
        facilT.setBounds(660,15,250,50);
        facilT.setFont(new Font("SansSerif",Font.PLAIN,50));
        facilT.setForeground(Color.white);

        medioT = new JLabel("MEDIO");
        medioT.setBounds(650,85,250,50);
        medioT.setFont(new Font("SansSerif",Font.PLAIN,50));
        medioT.setForeground(Color.white);

        dificlT = new JLabel("DIFICIL");
        dificlT.setBounds(650,155,250,50);
        dificlT.setFont(new Font("SansSerif",Font.PLAIN,50));
        dificlT.setForeground(Color.white);


        this.add(facil);
        this.add(facilT);
        this.add(medio);
        this.add(medioT);
        this.add(dificil);
        this.add(dificlT);
        this.add(muteUnMute);
        this.add(start);
        this.add(back);
        this.add(title);
        this.setSize(900,700);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        start.addActionListener(this);
        muteUnMute.addActionListener(this);
        facil.addActionListener(this);
        medio.addActionListener(this);
        dificil.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            this.setVisible(false);
            game.setVisible(true);
            game.reset();
        }
        if (e.getSource() == muteUnMute) {
            if (count == 0) {
                musicStuff.StopPlaying();
                x = 1;
                muteUnMute.setIcon(new ImageIcon(i[x].getImage().getScaledInstance(muteUnMute.getWidth(), muteUnMute.getHeight(), Image.SCALE_SMOOTH)));
                revalidate();
            }
            if (count == 1) {
                musicStuff.playMusic(Clip.LOOP_CONTINUOUSLY);
                x = 0;
                muteUnMute.setIcon(new ImageIcon(i[x].getImage().getScaledInstance(muteUnMute.getWidth(), muteUnMute.getHeight(), Image.SCALE_SMOOTH)));
                revalidate();
            }
            setCount(x);
        }
        if (e.getSource() == facil)
        {
            game.setPelotas(5);
            game.setTiempos(10);
        }
        if (e.getSource() == medio)
        {
            game.setPelotas(20);
            game.setTiempos(0);
        }
        if (e.getSource() == dificil)
        {
            game.setPelotas(100);
            game.setTiempos(0);

        }

    }

    public void setX(int x) {
        this.x = x;
    }
    public void setCount(int count) {
        this.count = count;
    }
}


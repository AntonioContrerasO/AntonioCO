import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener{

    JFrame panel;
    JButton piano;
    JLabel pianoN;
    JButton console;
    JLabel consoleN;


    Piano pianoPanel = new Piano();
    MusicStuff musicStuff = new MusicStuff("M");
    Title title = new Title("F",800,600);
    JuegoMenu juegoMenu = new JuegoMenu();


    public Menu()  {
        panel = new JFrame("Menu principal");

        piano = new MiBoton();
        piano.setBounds(75,250,250,250);
        ImageIcon i1 = new ImageIcon("src/Imagenes/piano.png");
        piano.setIcon(new ImageIcon(i1.getImage().getScaledInstance(piano.getWidth(),piano.getHeight(),Image.SCALE_SMOOTH)));
        piano.setContentAreaFilled(false);
        piano.setBorder(null);
        pianoN = new JLabel("TOCAR MUSICA");
        pianoN.setBounds(100,470,250,25);
        pianoN.setFont(new Font("SansSerif",Font.PLAIN,24));
        pianoN.setForeground(Color.WHITE);

        console = new MiBoton();
        console.setBounds(450,230,250,250);
        ImageIcon i2 = new ImageIcon("src/Imagenes/Palanca.png");
        console.setIcon(new ImageIcon(i2.getImage().getScaledInstance(console.getWidth(),console.getHeight(), Image.SCALE_SMOOTH)));
        console.setContentAreaFilled(false);
        console.setBorder(null);
        consoleN = new JLabel("JUGAR");
        consoleN.setBounds(530,470,150,25);
        consoleN.setFont(new Font("SansSerif",Font.PLAIN,24));
        consoleN.setForeground(Color.WHITE);


        panel.add(piano);
        panel.add(pianoN);
        panel.add(console);
        panel.add(consoleN);
        panel.add(title);

        panel.setSize(800,600);
        panel.setDefaultCloseOperation(panel.EXIT_ON_CLOSE);
        panel.setResizable(false);
        panel.setVisible(true);
        panel.setLayout(null);
        panel.setFocusable(true);

        piano.addActionListener(this);
        console.addActionListener(this);
        pianoPanel.back.addActionListener(this);
        juegoMenu.back.addActionListener(this);
        musicStuff.playMusic();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == piano)
        {
            musicStuff.StopPlaying();
            panel.setVisible(false);
            pianoPanel.setVisible(true);

        }
        if (e.getSource() == console)
        {
            panel.setVisible(false);
            juegoMenu.setVisible(true);
            musicStuff.StopPlaying();
            juegoMenu.musicStuff.playMusic();

        }
        if (e.getSource() == pianoPanel.back)
        {
            musicStuff.playMusic();
            panel.setVisible(true);
            pianoPanel.setVisible(false);
        }
        if (e.getSource() == juegoMenu.back)
        {
            musicStuff.playMusic();
            panel.setVisible(true);
            juegoMenu.setVisible(false);
            juegoMenu.musicStuff.StopPlaying();
            juegoMenu.setCount(0);
            juegoMenu.setX(1);
            juegoMenu.muteUnMute.setIcon(new ImageIcon(juegoMenu.i[0].getImage().getScaledInstance(juegoMenu.muteUnMute.getWidth(), juegoMenu.muteUnMute.getHeight(), Image.SCALE_SMOOTH)));
            juegoMenu.revalidate();
        }

    }






}





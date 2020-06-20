import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuegoMenu extends JFrame implements ActionListener {
    JButton back;
    JButton start;
    JButton muteUnMute;

    ImageIcon[] i = new ImageIcon[2];


    Title title = new Title("w",800,600);
    MusicStuff musicStuff = new MusicStuff("W");
    Game game = new Game();

    int x = 0;
    private int count = 0;

    public void setCount(int count) {
        this.count = count;
    }

    public JuegoMenu() {
        back = new MiBoton();
        back.setBounds(0,0,70,70);
        ImageIcon i1 = new ImageIcon("src/Imagenes/flecha1.png");
        back.setIcon(new ImageIcon(i1.getImage().getScaledInstance(back.getWidth(),back.getHeight(), Image.SCALE_SMOOTH)));
        back.setContentAreaFilled(false);
        back.setBorder(null);

        start = new MiBoton();
        start.setBounds(350,325,100,100);
        ImageIcon i2 = new ImageIcon("src/Imagenes/play.png");

        start.setIcon(new ImageIcon(i2.getImage().getScaledInstance(start.getWidth(),start.getHeight(), Image.SCALE_SMOOTH)));
        start.setContentAreaFilled(false);
        start.setBorder(null);

        muteUnMute = new JButton();
        muteUnMute.setBounds(50,500,50,50);
        i[0] = new ImageIcon("src/Imagenes/altavoz.png");
        i[1] = new ImageIcon("src/Imagenes/mudo.png");
        muteUnMute.setIcon(new ImageIcon(i[count].getImage().getScaledInstance(muteUnMute.getWidth(),muteUnMute.getHeight(), Image.SCALE_SMOOTH)));
        muteUnMute.setContentAreaFilled(false);
        muteUnMute.setBorder(null);


        this.add(muteUnMute);
        this.add(start);
        this.add(back);
        this.add(title);
        this.setSize(800,600);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        start.addActionListener(this);
        muteUnMute.addActionListener(this);
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
                musicStuff.playMusic();
                muteUnMute.setIcon(new ImageIcon(i[x].getImage().getScaledInstance(muteUnMute.getWidth(), muteUnMute.getHeight(), Image.SCALE_SMOOTH)));
                revalidate();
                x = 0;
            }
            if (game.visibleP)
            {
                this.setVisible(true);
            }
            setCount(x);
        }

    }

    public void setX(int x) {
        this.x = x;
    }
}


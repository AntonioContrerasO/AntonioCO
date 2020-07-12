import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Mapas extends JPanel {
    public Image image;
    private Game game;
    private final int mapa;

    ArrayList<Estructuras> mapa1 = new ArrayList<>();

    public Mapas(int mapa, Game game) {
        this.mapa = mapa;
        this.game = game;
        if (this.mapa == 1)
        {
            image = new ImageIcon(getClass().getResource("./Imagenes/mapa1.png")).getImage();
        }
        if (this.mapa == 2)
        {
            image = new ImageIcon(getClass().getResource("./Imagenes/mapa2.png")).getImage();
        }
    }

    @Override
    public void paint(Graphics g)
    {
        int x = 0;
        int y = 0;
        g.drawImage(image, x, y,game.getWidth(),game.getHeight(),this);
        setOpaque(false);
            mapa1.add(new Estructuras(game.getWidth()/4,game.getHeight()/2,game.getWidth()/2));
            mapa1.get(0).paint(g);
        super.paint(g);
    }

    public int getMapa() {
        return mapa;
    }
}
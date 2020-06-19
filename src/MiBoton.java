import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MiBoton extends JButton {
    private float opacity = 0.5f;

    public MiBoton() {
        super();
        addMouseListener(new EventButton());
    }

    public MiBoton(String text) {
        super(text);
        addMouseListener(new EventButton());
    }

    public float getOpacity() {
        return opacity;
    }

    public void setOpacity(float opacity) {
        this.opacity = opacity;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g)
    {
       Graphics2D g2 = (Graphics2D) g;
       g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,opacity));
       super.paintComponent(g2);
    }

    public class EventButton extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            efectHover(1f,0.5f,0.03f,10,false);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            efectHover(0.5f,1f,0.03f,10,true);

        }

        @Override
        public void mouseExited(MouseEvent e) {
            efectHover(1f,0.5f,0.03f,10,false);
        }
        private void efectHover(float index, float range, float cont, int sleep, boolean event)
        {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (float i= index ;(event) ? i <= range : i> range;i = (event) ? i + cont : i - cont)
                    {
                        setOpacity(i);
                        try{
                            Thread.sleep(sleep);
                        }catch (Exception e)
                        {

                        }
                    }
                }
            }).start();
        }
    }
}

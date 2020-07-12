import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class Elementos extends JFrame {


    private int width = 500;
    private int height = 500;
    JLabel Encabezado;
    JLabel Element;
    JTextArea texto1;
    String titulo;
    Fondo fondo;
    ArrayList<String> contenido;

    public Elementos(String titulo,ImageIcon imageIcon,String string) {
        this.titulo = titulo;

        fondo = new Fondo("F3");
        fondo.setBounds(0,0,width,height);

    Encabezado = new JLabel(titulo);
    Encabezado.setBounds(210, 35, 270, 50);
    Encabezado.setFont(new Font("SansSerif", Font.BOLD, 35));
    Encabezado.setForeground(Color.decode("0X3434"));
    //Encabezado.setOpaque(true);
    Encabezado.setHorizontalAlignment(SwingConstants.CENTER);
    Encabezado.setVerticalAlignment(SwingConstants.CENTER);



    Element = new JLabel();
    Element.setBounds(5, 10, 200, 200);
    Element.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(Element.getWidth(), Element.getHeight(), Image.SCALE_SMOOTH)));
    Element.setBorder(null);

    texto1 = new JTextArea();
    texto1.setBounds(40, 240, 420, 205);
    texto1.setFont(new Font("SansSerif", Font.ITALIC, 15));
    Border border = BorderFactory.createLineBorder(Color.BLACK);
    texto1.setBorder(BorderFactory.createCompoundBorder(border,
            BorderFactory.createEmptyBorder(10, 10, 10, 30)));
    texto1.setOpaque(false);
    texto1.setBackground(Color.decode("0Xfde9b7"));
    texto1.setEditable(false);
    

    String cadena = "";
    contenido = Archivo.leerTodo("src/Elementos/" + string + ".txt");
    for (String s : contenido) {

        cadena = cadena + s + "\n";
    }
    texto1.append(cadena);
    this.add(Element);
    this.add(Encabezado);
    this.add(texto1);

        this.add(fondo);
        this.setLayout(null);
        this.setTitle(titulo);
        this.setSize(width,height);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.repaint();
    }

}

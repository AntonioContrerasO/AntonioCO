import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TablaPeriodica implements ActionListener {

    JFrame panel;
    Fondo fondo;
    private int width = 1250;
    private int heigth = 850;
    private int subir = 75;
    private int centrar = -20;

    private int cuadraW =60;
    private int cuadraH =68;

    JButton back;

    JLabel tiposElementos;
    JButton[] metalesAlcalinos;
    JButton[] metalesAlcalinoterreos;
    JButton[][] metalesPesados;
    JButton[][] metalesYGases;
    JButton[] gasesNobles;
    JButton[] lactanidosYactinidos;
    

    ImageIcon[] imagenes = new ImageIcon[120];
    ImageIcon extra = new ImageIcon("src/Imagenes/E.png");
    Elementos[] elementos = new Elementos[118];


    JButton salir;
    JuegoTabla juegoTabla = new JuegoTabla();

    ImageIcon extra2 = new ImageIcon("src/Imagenes/R.png");
    public TablaPeriodica() {

        panel = new JFrame("Tabla Periodica");
        fondo = new Fondo("Fondo");
        fondo.setBounds(0,0,width,heigth);

        back = new MiBoton();
        back.setBounds(0,0,70,70);
        ImageIcon i1 = new ImageIcon("src/Imagenes/flecha1.png");
        back.setIcon(new ImageIcon(i1.getImage().getScaledInstance(back.getWidth(),back.getHeight(), Image.SCALE_SMOOTH)));
        back.setContentAreaFilled(false);
        back.setBorder(null);
        panel.add(back);

        salir = new MiBoton();
        salir.setBounds(1135,10,80,80);
        salir.addActionListener(this);
        salir.setIcon(new ImageIcon(extra2.getImage().getScaledInstance(salir.getWidth(),salir.getHeight(), Image.SCALE_SMOOTH)));
        salir.setContentAreaFilled(false);
        salir.setBorder(null);
        panel.add(salir);

        tiposElementos = new JLabel();
        tiposElementos.setBounds(280,80+subir,450,150);
        tiposElementos.setIcon(new ImageIcon(extra.getImage().getScaledInstance(tiposElementos.getWidth(),tiposElementos.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(tiposElementos);

        for (int x=0;x<imagenes.length;x++)
        {
            imagenes[x] = new ImageIcon("src/Imagenes/H"+x+".png");
        }

        //Botones
        metalesAlcalinos = new JButton[7];

        int y = 0;
        int x =0;
        int prueba=0;
        for (int indice=0;indice<metalesAlcalinos.length;indice++)
        {
            metalesAlcalinos[indice] = new MiBoton();
            metalesAlcalinos[indice].setBounds(104+centrar,57+y+subir,cuadraW,cuadraH);
            metalesAlcalinos[indice].setIcon(new ImageIcon(imagenes[indice].getImage().getScaledInstance(metalesAlcalinos[x].getWidth(),metalesAlcalinos[x].getHeight(), Image.SCALE_SMOOTH)));
            metalesAlcalinos[indice].setContentAreaFilled(false);
            metalesAlcalinos[indice].setBorder(null);
            panel.add(metalesAlcalinos[indice]);
            metalesAlcalinos[indice].addActionListener(this);
            y+=cuadraH;
            prueba++;
        }
        y = 0;
        metalesAlcalinoterreos = new JButton[6];
        for (int indie=0;indie<metalesAlcalinoterreos.length;indie++)
        {
            metalesAlcalinoterreos[indie] = new MiBoton();
            metalesAlcalinoterreos[indie].setBounds(161+centrar,125+y+subir,cuadraW,cuadraH);
            metalesAlcalinoterreos[indie].setIcon(new ImageIcon(imagenes[prueba].getImage().getScaledInstance(metalesAlcalinos[indie].getWidth(),metalesAlcalinos[indie].getHeight(), Image.SCALE_SMOOTH)));
            metalesAlcalinoterreos[indie].setContentAreaFilled(false);
            metalesAlcalinoterreos[indie].setBorder(null);
            panel.add(metalesAlcalinoterreos[indie]);
            metalesAlcalinoterreos[indie].addActionListener(this);
            y+=cuadraH;
            prueba++;
        }
        y=0;
        metalesPesados = new JButton[10][4];
        for (int indo=0;indo<10;indo++)
        {
            for (int indo2=0;indo2<4;indo2++)
            {
                metalesPesados[indo][indo2] = new MiBoton();
                metalesPesados[indo][indo2].setBounds(216+x+centrar,261+y+subir,cuadraW,cuadraH);
                metalesPesados[indo][indo2].setIcon(new ImageIcon(imagenes[prueba].getImage().getScaledInstance(metalesPesados[indo][indo2].getWidth(),metalesPesados[indo][indo2].getHeight(), Image.SCALE_SMOOTH)));
                metalesPesados[indo][indo2].setContentAreaFilled(false);
                metalesPesados[indo][indo2].setBorder(null);
                panel.add(metalesPesados[indo][indo2]);
                metalesPesados[indo][indo2].addActionListener(this);
                y+=cuadraH;
                prueba++;
            }
            x += cuadraW;
            y=0;
        }
        y=0;
        x=0;
        metalesYGases = new JButton[5][6];
        for (int indo=0;indo<5;indo++)
        {
            for (int indo2=0;indo2<6;indo2++)
            {
                metalesYGases[indo][indo2] = new MiBoton();
                metalesYGases[indo][indo2].setBounds(816+x+centrar,125+y+subir,cuadraW,cuadraH);
                metalesYGases[indo][indo2].setIcon(new ImageIcon(imagenes[prueba].getImage().getScaledInstance(metalesYGases[indo][indo2].getWidth(),metalesYGases[indo][indo2].getHeight(), Image.SCALE_SMOOTH)));
                metalesYGases[indo][indo2].setContentAreaFilled(false);
                metalesYGases[indo][indo2].setBorder(null);
                panel.add(metalesYGases[indo][indo2]);
                metalesYGases[indo][indo2].addActionListener(this);
                y+=cuadraH;
                prueba++;
            }
            x += cuadraW;                       //1111*11 = 12221
            y=0;                                //5803*11 = 63833
        }
        gasesNobles = new JButton[7];
        y=0;
        for (int i=0;i<gasesNobles.length;i++)
        {
            gasesNobles[i] = new MiBoton();
            gasesNobles[i].setBounds(1116+centrar,57+y+subir,cuadraW,cuadraH);
            gasesNobles[i].setIcon(new ImageIcon(imagenes[prueba].getImage().getScaledInstance(gasesNobles[i].getWidth(),gasesNobles[i].getHeight(), Image.SCALE_SMOOTH)));
            gasesNobles[i].setContentAreaFilled(false);
            gasesNobles[i].setBorder(null);
            panel.add(gasesNobles[i]);
            gasesNobles[i].addActionListener(this);
            y+=cuadraH;
            prueba++;
        }
        lactanidosYactinidos = new JButton[30];
        x = 0;
        y = 0;
        for (int c=0;c<lactanidosYactinidos.length;c++) {
            lactanidosYactinidos[c] = new MiBoton();
            lactanidosYactinidos[c].setBounds(276 + x + centrar, 553 + y+subir, cuadraW, cuadraH);
            lactanidosYactinidos[c].setIcon(new ImageIcon(imagenes[prueba].getImage().getScaledInstance(lactanidosYactinidos[c].getWidth(), lactanidosYactinidos[c].getHeight(), Image.SCALE_SMOOTH)));
            lactanidosYactinidos[c].setContentAreaFilled(false);
            lactanidosYactinidos[c].setBorder(null);
            panel.add(lactanidosYactinidos[c]);
            lactanidosYactinidos[c].addActionListener(this);
            x += cuadraW;
            if (c == 14) {
                y += cuadraH;
                x = 0;
            }
            prueba++;
        }





        panel.add(fondo);
        panel.setSize(width,heigth);
        panel.setResizable(false);
        panel.setLocationRelativeTo(null);
        panel.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel.setVisible(false);


    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == salir)
        {
            juegoTabla.setVisible(true);
        }
          if (e.getSource() == metalesAlcalinos[0])
        {
            elementos[0] = new Elementos("Hidrogeno",imagenes[0],"1.-H");
        }
          if (e.getSource() == metalesAlcalinos[1])
        {
            elementos[1] = new Elementos("Litio",imagenes[1],"3.-Li");
        }
          if (e.getSource() == metalesAlcalinos[2])
        {
            elementos[2] = new Elementos("Sodio",imagenes[2],"11.-Na");
        }
          if (e.getSource() == metalesAlcalinos[3])
        {
            elementos[3] = new Elementos("Potasio",imagenes[3],"19.-K");
        }
          if (e.getSource() == metalesAlcalinos[4])
        {
            elementos[4] = new Elementos("Rubidio",imagenes[4],"37.-Rb");
        }
          if (e.getSource() == metalesAlcalinos[5])
        {
            elementos[5] = new Elementos("Cesio",imagenes[5],"55.-Cs");
        }
          if (e.getSource() == metalesAlcalinos[6])
        {
            elementos[6] = new Elementos("Francio",imagenes[6],"87.-Fr");
        }
          if (e.getSource() == metalesAlcalinoterreos[0])
        {
            elementos[7] = new Elementos("Berilio",imagenes[7],"4.-Be");
        }
          if (e.getSource() == metalesAlcalinoterreos[1])
        {
            elementos[8] = new Elementos("magnesio",imagenes[8],"12.-Mg");
        }
          if (e.getSource() == metalesAlcalinoterreos[2])
        {
            elementos[9] = new Elementos("calcio",imagenes[9],"20.-Ca");
        }
          if (e.getSource() == metalesAlcalinoterreos[3])
        {
            elementos[10] = new Elementos("estroncio",imagenes[10],"38.-Sr");
        }
          if (e.getSource() == metalesAlcalinoterreos[4])
        {
            elementos[11] = new Elementos("Bario",imagenes[11],"56.-Ba");
        }
          if (e.getSource() == metalesAlcalinoterreos[5])
        {
            elementos[12] = new Elementos("Radio",imagenes[12],"88.-Ra");
        }                               //10 4
          if(e.getSource()== metalesPesados[0][0])
        {
            elementos[13] = new Elementos("Escandio",imagenes[13],"21.-Sc");
        }
          if(e.getSource()== metalesPesados[0][1])
        {
            elementos[14] = new Elementos("Itrio",imagenes[14],"39.-Y");
        }
    //    if(e.getSource()== metalesPesados[0][2])
    //  {
    //     elementos[15] = new Elementos("Lantano",imagenes[15],"57.-La");
    //  }
    //    if(e.getSource()== metalesPesados[0][3])
    //  {
    //     elementos[16] = new Elementos("Actinio",imagenes[16],"89.-Ac");
    //  }
          if(e.getSource()== metalesPesados[1][0])
        {
            elementos[17] = new Elementos("Titanio",imagenes[17],"22.-Ti");
        }
          if(e.getSource()== metalesPesados[1][1])
        {
            elementos[18] = new Elementos("Circonio",imagenes[18],"40.-Zr");
        }
          if(e.getSource()== metalesPesados[1][2])
        {
            elementos[19] = new Elementos("Hafnio",imagenes[19],"72.-Hf");
        }
          if(e.getSource()== metalesPesados[1][3])
        {
            elementos[20] = new Elementos("Rutherfordio",imagenes[20],"104.-Rf");
        }
          if(e.getSource()== metalesPesados[2][0])
        {
            elementos[21] = new Elementos("Vanadio",imagenes[21],"23.-V");
        }
          if(e.getSource()== metalesPesados[2][1])
        {
            elementos[22] = new Elementos("Niobio",imagenes[22],"41.-Nb");
        }
          if(e.getSource()== metalesPesados[2][2])
        {
            elementos[23] = new Elementos("Tantalo",imagenes[23],"73.-Ta");
        }
          if(e.getSource()== metalesPesados[2][3])
        {
            elementos[24] = new Elementos("Dubnio",imagenes[24],"105.-Db");
        }
          if(e.getSource()== metalesPesados[3][0])
        {
            elementos[25] = new Elementos("Cromo",imagenes[25],"24.-Cr");
        }
          if(e.getSource()== metalesPesados[3][1])
        {
            elementos[26] = new Elementos("Molibdeno",imagenes[26],"42.-Mo");
        }
          if(e.getSource()== metalesPesados[3][2])
        {
            elementos[27] = new Elementos("Wolframio",imagenes[27],"74.-W");
        }
          if(e.getSource()== metalesPesados[3][3])
        {
            elementos[28] = new Elementos("Seaborgio",imagenes[28],"106.-Sg");
        }
          if(e.getSource()== metalesPesados[4][0])
        {
            elementos[29] = new Elementos("Manganeso",imagenes[29],"25.-Mn");
        }
          if(e.getSource()== metalesPesados[4][1])
        {
            elementos[30] = new Elementos("Tecnecio",imagenes[30],"43.-Tc");
        }
          if(e.getSource()== metalesPesados[4][2])
        {
            elementos[31] = new Elementos("Renio",imagenes[31],"75.-Re");
        }
          if(e.getSource()== metalesPesados[4][3])
        {
            elementos[32] = new Elementos("Bohrio",imagenes[32],"107.-Bh");
        }
          if(e.getSource()== metalesPesados[5][0])
        {
            elementos[33] = new Elementos("Hierro",imagenes[33],"26.-Fe");
        }
          if(e.getSource()== metalesPesados[5][1])
        {
            elementos[34] = new Elementos("Rutenio",imagenes[34],"44.-Ru");
        }
          if(e.getSource()== metalesPesados[5][2])
        {
            elementos[35] = new Elementos("Osmio",imagenes[35],"76.-Os");
        }
          if(e.getSource()== metalesPesados[5][3])
        {
            elementos[36] = new Elementos("Hassio",imagenes[36],"108.-Hs");
        }
          if(e.getSource()== metalesPesados[6][0])
        {
            elementos[37] = new Elementos("Cobalto",imagenes[37],"27.-Co");
        }
          if(e.getSource()== metalesPesados[6][1])
        {
            elementos[38] = new Elementos("Rodio",imagenes[38],"45.-Rh");
        }
          if(e.getSource()== metalesPesados[6][2])
        {
           elementos[39] = new Elementos("Iridio",imagenes[39],"77.-Ir");
        }
          if(e.getSource()== metalesPesados[6][3])
        {
            elementos[40] = new Elementos("Meitnerio",imagenes[40],"109.-Mt");
        }
          if(e.getSource()== metalesPesados[7][0])
        {
            elementos[41] = new Elementos("Niquel",imagenes[41],"28.-Ni");
        }
          if(e.getSource()== metalesPesados[7][1])
        {
            elementos[42] = new Elementos("Paladio",imagenes[42],"46.-Pd");
        }
          if(e.getSource()== metalesPesados[7][2])
        {
            elementos[43] = new Elementos("Platino",imagenes[43],"78.-Pt");
        }
          if(e.getSource()== metalesPesados[7][3])
        {
            elementos[44] = new Elementos("Darmstadio",imagenes[44],"110.-Ds");
        }
          if(e.getSource()== metalesPesados[8][0])
        {
            elementos[45] = new Elementos("Cobre",imagenes[45],"29.-Cu");
        }                                 //9  3
          if(e.getSource()== metalesPesados[8][1])
        {
            elementos[46] = new Elementos("Plata",imagenes[46],"47.-Ag");
        }
          if(e.getSource()== metalesPesados[8][2])
        {
            elementos[47] = new Elementos("Oro",imagenes[47],"79.-Au");
        }
          if(e.getSource()== metalesPesados[8][3])
        {
            elementos[48] = new Elementos("Roentgenio",imagenes[48],"111.-Rg");
        }                                 
          if(e.getSource()== metalesPesados[9][0])
        {
            elementos[49] = new Elementos("Zinc",imagenes[49],"30.-Zn");
        }
          if(e.getSource()== metalesPesados[9][1])
        {
            elementos[50] = new Elementos("Cadmio",imagenes[50],"48.-Cd");
        }
          if(e.getSource()== metalesPesados[9][2])
        {
            elementos[51] = new Elementos("Mercurio",imagenes[51],"80.-Hg");
        }                                 
          if(e.getSource()== metalesPesados[9][3])
        {
            elementos[52] = new Elementos("Copernicio",imagenes[52],"112.-Cn");
        }                             // 5  6 o 4 , 5
          if(e.getSource()== metalesYGases[0][0])
        {
            elementos[53] = new Elementos("Boro",imagenes[53],"5.-B");
        }
          if(e.getSource()== metalesYGases[0][1])
        {
            elementos[54] = new Elementos("Aluminio",imagenes[54],"13.-Al");
        }
          if(e.getSource()== metalesYGases[0][2])
        {
            elementos[55] = new Elementos("Galio",imagenes[55],"31.-Ga");
        }
          if(e.getSource()== metalesYGases[0][3])
        {
            elementos[56] = new Elementos("Indio",imagenes[56],"49.-In");
        }
          if(e.getSource()== metalesYGases[0][4])
        {
            elementos[57] = new Elementos("Talio",imagenes[57],"81.-Tl");
        }
          if(e.getSource()== metalesYGases[0][5])
        {
            elementos[58] = new Elementos("Nihonio",imagenes[58],"113.-Nh");
        }
          if(e.getSource()== metalesYGases[1][0])
        {
            elementos[59] = new Elementos("Carbono",imagenes[59],"6.-C");
        }
          if(e.getSource()== metalesYGases[1][1])
        {
            elementos[60] = new Elementos("Silicio",imagenes[60],"14.-Si");
        }
          if(e.getSource()== metalesYGases[1][2])
        {
            elementos[61] = new Elementos("Germanio",imagenes[61],"32.-Ge");
        }
          if(e.getSource()== metalesYGases[1][3])
        {
            elementos[62] = new Elementos("Estaño",imagenes[62],"50.-Sn");
        }
          if(e.getSource()== metalesYGases[1][4])
        {
            elementos[63] = new Elementos("Plomo",imagenes[63],"82.-Pb");
        }
          if(e.getSource()== metalesYGases[1][5])
        {
            elementos[64] = new Elementos("Flerovio",imagenes[64],"114.-Fl");
        }
          if(e.getSource()== metalesYGases[2][0])
        {
            elementos[65] = new Elementos("Nitrogeno",imagenes[65],"7.-N");
        }
          if(e.getSource()== metalesYGases[2][1])
        {
            elementos[66] = new Elementos("Fosforo",imagenes[66],"15.-P");
        }
          if(e.getSource()== metalesYGases[2][2])
        {
            elementos[67] = new Elementos("Arsenico",imagenes[67],"33.-As");
        }
          if(e.getSource()== metalesYGases[2][3])
        {
            elementos[68] = new Elementos("Antimonio",imagenes[68],"51.-Sb");
        }
          if(e.getSource()== metalesYGases[2][4])
        {
            elementos[69] = new Elementos("Bismuto",imagenes[69],"83.-Bi");
        }
          if(e.getSource()== metalesYGases[2][5])
        {
            elementos[70] = new Elementos("Moscovio",imagenes[70],"115.-Mc");
        }
          if(e.getSource()== metalesYGases[3][0])
        {
            elementos[71] = new Elementos("Oxigeno",imagenes[71],"8.-O");
        }
          if(e.getSource()== metalesYGases[3][1])
        {
            elementos[72] = new Elementos("Azufre",imagenes[72],"16.-S");
        }
          if(e.getSource()== metalesYGases[3][2])
        {
            elementos[73] = new Elementos("Selenio",imagenes[73],"34.-Se");
        }
          if(e.getSource()== metalesYGases[3][3])
        {
            elementos[74] = new Elementos("Telurio",imagenes[74],"52.-Te");
        }
          if(e.getSource()== metalesYGases[3][4])
        {
            elementos[75] = new Elementos("Polonio",imagenes[75],"84.-Po");
        }
          if(e.getSource()== metalesYGases[3][5])
        {
            elementos[76] = new Elementos("Livermorio",imagenes[76],"116.-Lv");
        }
         if(e.getSource()== metalesYGases[4][0])
        {
            elementos[77] = new Elementos("Fluor",imagenes[77],"9.-F");
        }
          if(e.getSource()== metalesYGases[4][1])
        {
            elementos[78] = new Elementos("Cloro",imagenes[78],"17.-Cl");
        }
          if(e.getSource()== metalesYGases[4][2])
        {
            elementos[79] = new Elementos("Bromo",imagenes[79],"35.-Br");
        }
          if(e.getSource()== metalesYGases[4][3])
        {
            elementos[80] = new Elementos("Yodo",imagenes[80],"53.-I");
        }
          if(e.getSource()== metalesYGases[4][4])
        {
            elementos[81] = new Elementos("Astato",imagenes[81],"85.-At");
        }
          if(e.getSource()== metalesYGases[4][5])
        {
            elementos[82] = new Elementos("Teneso",imagenes[82],"117.-Ts");
        }
          if(e.getSource()== gasesNobles[0])
        {
            elementos[83] = new Elementos("Helio",imagenes[83],"2.-He");
        }
          if(e.getSource()== gasesNobles[1])
        {
            elementos[84] = new Elementos("Neon",imagenes[84],"10.-Ne");
        }
          if(e.getSource()== gasesNobles[2])
        {
            elementos[85] = new Elementos("Argon",imagenes[85],"18.-Ar");
        }
          if(e.getSource()== gasesNobles[3])
        {
            elementos[86] = new Elementos("Kripton",imagenes[86],"36.-Kr");
        }
          if(e.getSource()== gasesNobles[4])
        {
            elementos[87] = new Elementos("Xenon",imagenes[87],"54.-Xe");
        }
          if(e.getSource()== gasesNobles[5])
        {
            elementos[88] = new Elementos("Radon",imagenes[88],"86.-Rn");
        }
          if(e.getSource()== gasesNobles[6])
        {
            elementos[89] = new Elementos("Oganeson",imagenes[89],"118.-Og");
        }

          if(e.getSource()== lactanidosYactinidos[0])
        {
            elementos[90] = new Elementos("Lantano",imagenes[90],"57.-La");
        }
          if(e.getSource()== lactanidosYactinidos[1])
        {
            elementos[91] = new Elementos("Cerio",imagenes[91],"58.-Ce");
        }
          if(e.getSource()== lactanidosYactinidos[2])
        {
            elementos[92] = new Elementos("Praseodimio",imagenes[92],"59.-Pr");
        }
          if(e.getSource()== lactanidosYactinidos[3])
        {
            elementos[93] = new Elementos("Neodimio",imagenes[93],"60.-Nd");
        }
          if(e.getSource()== lactanidosYactinidos[4])
        {
            elementos[94] = new Elementos("Prometio",imagenes[94],"61.-Pm");
        }
          if(e.getSource()== lactanidosYactinidos[5])
        {
            elementos[95] = new Elementos("Samario",imagenes[95],"62.-Sm");
        }
          if(e.getSource()== lactanidosYactinidos[6])
        {
            elementos[96] = new Elementos("Europio",imagenes[96],"63.-Eu");
        }
          if(e.getSource()== lactanidosYactinidos[7])
        {
            elementos[97] = new Elementos("Gadolinio",imagenes[97],"64.-Gd");
        }
          if(e.getSource()== lactanidosYactinidos[8])
        {
            elementos[98] = new Elementos("Terbio",imagenes[98],"65.-Tb");
        }
          if(e.getSource()== lactanidosYactinidos[9])
        {
            elementos[99] = new Elementos("Disprosio",imagenes[99],"66.-Dy");
        }
          if(e.getSource()== lactanidosYactinidos[10])
        {
            elementos[100] = new Elementos("Holmio",imagenes[100],"67.-Ho");
        }
          if(e.getSource()== lactanidosYactinidos[11])
        {
            elementos[101] = new Elementos("Erbio",imagenes[101],"68.-Er");
        }
          if(e.getSource()== lactanidosYactinidos[12])
        {
            elementos[102] = new Elementos("Tulio",imagenes[102],"69.-Tm");
        }
          if(e.getSource()== lactanidosYactinidos[13])
        {
            elementos[103] = new Elementos("Iterbio",imagenes[103],"70.-Yb");
        }
          if(e.getSource()== lactanidosYactinidos[14])
        {
            elementos[104] = new Elementos("Lutecio",imagenes[104],"71.-Lu");
        }
          if(e.getSource()== lactanidosYactinidos[15])
        {
            elementos[105] = new Elementos("Actinio",imagenes[105],"89.-Ac");
        }
          if(e.getSource()== lactanidosYactinidos[16])
        {
            elementos[106] = new Elementos("Torio",imagenes[106],"90.-Th");
        }
          if(e.getSource()== lactanidosYactinidos[17])
        {
            elementos[107] = new Elementos("Protactinio",imagenes[107],"91.-Pa");
        }
          if(e.getSource()== lactanidosYactinidos[18])
        {
            elementos[108] = new Elementos("Uranio",imagenes[108],"92.-U");
        }
          if(e.getSource()== lactanidosYactinidos[19])
        {
            elementos[109] = new Elementos("Neptunio",imagenes[109],"93.-Np");
        }
          if(e.getSource()== lactanidosYactinidos[20])
        {
            elementos[110] = new Elementos("Plutonio",imagenes[110],"94.-Pu");
        }
          if(e.getSource()== lactanidosYactinidos[21])
        {
            elementos[111] = new Elementos("Americio",imagenes[111],"95.-Am");
        }
          if(e.getSource()== lactanidosYactinidos[22])
        {
            elementos[112] = new Elementos("Curio",imagenes[112],"96.-Cm");
        }
          if(e.getSource()== lactanidosYactinidos[23])
        {
            elementos[113] = new Elementos("Berkelio",imagenes[113],"97.-Bk");
        }
          if(e.getSource()== lactanidosYactinidos[24])
        {
            elementos[114] = new Elementos("Californio",imagenes[114],"98.-Cf");
        }
          if(e.getSource()== lactanidosYactinidos[25])
        {
            elementos[115] = new Elementos("Einstenio",imagenes[115],"99.-Es");
        }
          if(e.getSource()== lactanidosYactinidos[26])
        {
            elementos[116] = new Elementos("Fermio",imagenes[116],"100.-Fm");
        }
          if(e.getSource()== lactanidosYactinidos[27])
        {
            elementos[117] = new Elementos("Mendelevio",imagenes[117],"101.-Md");
        }
          if(e.getSource()== lactanidosYactinidos[28])
        {
            elementos[118] = new Elementos("Nobelio",imagenes[118],"102.-No");
        }
          if(e.getSource()== lactanidosYactinidos[29])
        {
            elementos[119] = new Elementos("Lawrencio",imagenes[119],"103.-Lr");
        }

    }

    public void setVisible() {
        panel.setVisible(true);
    }

    public void setInvisible() {
        panel.setVisible(false);
    }
}
//Alcalinos 7
//Alcalinoterreos 6
//metales Pesados 40[][]
//metales Y Gases 30
//
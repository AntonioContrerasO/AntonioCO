import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Archivo {
    public static ArrayList<String> leerTodo(String nombreArchivo){
        String strLine = new String();
        ArrayList<String> arraylist = new ArrayList<String>();

        try(FileInputStream fis = new FileInputStream(nombreArchivo);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader( new InputStreamReader(in));)
        {
            strLine = br.readLine();
            while (strLine != null)
            {
                //System.out.println(strLine)	;
                arraylist.add(strLine);
                strLine = br.readLine();
            }
            //in.close();
        }
        catch (Exception e ) //Agregar Excepciones
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Peto banda","Error Perro", JOptionPane.ERROR_MESSAGE);
        }
        //arraylist.remove(arraylist.size()-1); // remover el ultimo elemento, que es null
        return arraylist;

    }

    public static void guardarTodo(String nombre,String informacion){
        try{
            FileOutputStream fos = new FileOutputStream (nombre);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            out.write(informacion);
            out.close();
        }
        catch (Exception e) //Agregar Excepciones
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Peto banda","Error Perro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
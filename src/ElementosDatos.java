public class ElementosDatos {

    private String elemento;
    private String NumeroAtomico;
    private String nombre;

    public ElementosDatos(String elemento,String NumeroAtomico,String nombre)
    {
        this.elemento = elemento;
        this.NumeroAtomico = NumeroAtomico;
        this.nombre = nombre;
    }
    public String getElemento() {
        return elemento;
    }
    public String getNumeroAtomico() {
        return NumeroAtomico;
    }
    public String getNombre() {
        return nombre;
    }
    
}
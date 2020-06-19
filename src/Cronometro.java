public class Cronometro implements Runnable {

    private Thread hilo;

    private int minutos;
    private int segundos;
    private int segundos2 = 0;
    private int tiempo;


    public Cronometro() {

        hilo = new Thread(this);
        hilo.start();
    }

    public void iniciar() {

        hilo.start();
    }

    public void run() {
        while (true) {

            for (minutos = 0; minutos < 60; minutos++) {


                for (segundos = 0; segundos < 60; segundos++) {
                    segundos2++;

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException exc) {
                    }


                }//fin for segundos
            }//fin for minutos
        }//fin while
    }//fin run


    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int getSegundos2() {
        return this.segundos2;
    }

    public void setSegundos2(int segundos2) {
        this.segundos2 = segundos2;
    }


    public void detener() {

        this.hilo.stop();
    }

    public int tiempo() {
        tiempo = (this.minutos * 60) + this.segundos;
        return tiempo;
    }
}

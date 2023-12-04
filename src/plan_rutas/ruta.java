/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plan_rutas;

/**
 *
 * @author AndresD
 */
public class ruta {
 
    int noRuta, noConductor, noBus, noEmpleado, hora;
    String origen, destino, fecha;

    public int getNoEmpleado() {
        return noEmpleado;
    }

    public void setNoEmpleado(int noEmpleado) {
        this.noEmpleado = noEmpleado;
    }
    
    public int getNoRuta() {
        return noRuta;
    }

    public void setNoRuta(int noRuta) {
        this.noRuta = noRuta;
    }

    public int getNoConductor() {
        return noConductor;
    }

    public void setNoConductor(int noConductor) {
        this.noConductor = noConductor;
    }

    public int getNoBus() {
        return noBus;
    }

    public void setNoBus(int noBus) {
        this.noBus = noBus;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    
    
}

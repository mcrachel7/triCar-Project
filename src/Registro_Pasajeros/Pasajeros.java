
package Registro_Pasajeros;

/**
 *
 * @author Cristian Aguiluz
 */

public class Pasajeros {
         int id;
         String Nombre;
         int Edad;
         String genero;
         int Num_Autobus;
         int Num_Asiento;
         int num_ruta;
         String condi;
         boolean equipaje;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNum_ruta() {
        return num_ruta;
    }

    public void setNum_ruta(int num_ruta) {
        this.num_ruta = num_ruta;
    }

    public String getCondi() {
        return condi;
    }

    public void setCondi(String condi) {
        this.condi = condi;
    }

    public boolean isEquipaje() {
        return equipaje;
    }

    public void setEquipaje(boolean equipaje) {
        this.equipaje = equipaje;
    }
    
    public String getNombre (){
        
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }
      public int getNum_Autobus() {
        return Num_Autobus;
    }

    public void setNum_Autobus(int Num_Autobus) {
        this.Num_Autobus = Num_Autobus;
    }
      public int getNum_Asiento() {
        return Num_Asiento;
    }

    public void setNum_Asiento(int Num_Asiento) {
        this.Num_Asiento = Num_Asiento;
    }
}

   


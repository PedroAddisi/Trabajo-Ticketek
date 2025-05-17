package ar.edu.ungs.prog2.ticketek;

public class IEntrada {/**
    * 10) Calcula y devuelve el precio de la entrada.
    * 
    * @return
    */
    public double precio(){
        return 0.0;

   }

   /**
    * Si la entrada es para estadio, la ubicacion será "CAMPO". 
    * sino, será "{SECTOR} f:{NRO FILA} a:{NRO ASIENTO}" 
    * 
    * Por ejemplo:
    *  - CAMPO
    *  - Platea Común f:3 a:31
    * @return
    */;
   public String ubicacion(){
    return null;
   }
/**
    * El toString de cada entrada debe respetar el siguiente formato:
    *  - "{COD ENTRADA} - {NOMBRE ESPECTACULO} - {FECHA} - {NOMBRE SEDE} - {UBICACION}"
    *  
    *  Si la entrada es para estadio, la ubicacion será "CAMPO". sino, será "{SECTOR} f:{NRO FILA} a:{NRO ASIENTO}" 
    *  Si la fecha de la entrada ya pasó, se le agrega una P luego de la fecha.
    * 
    * Por ejemplo:
    *  - 7896 - Coldplay en vivo - 30/08/2025 - La bombonera - CAMPO
    *  - 1901 - Stand up Comedy - 30/06/2025 - Teatro San Martín - Platea Común f:3 a:31
    *  - 7196 - Coldplay en vivo - 30/04/2025 P - La bombonera - CAMPO
    * @return
    */
   public String toString();

}

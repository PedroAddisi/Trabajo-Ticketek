package ar.edu.ungs.prog2.ticketek;

public class Sector {
    private int capacidaddesectorvip;
    private int capacidaddesectorcomun;
    private int capacidaddesectoralta;
    private int capacidaddesectorbaja;
    private int[] capacidadasientosector;
    public Sector(int capacidaddesectorvip, int capacidaddesectorcomun, int capacidaddesectoralta,int capacidaddesectorbaja, int[] capacidadasientosector) {
        this.capacidaddesectorvip = capacidaddesectorvip;
        this.capacidaddesectorcomun = capacidaddesectorcomun;
        this.capacidaddesectoralta = capacidaddesectoralta;
        this.capacidaddesectorbaja = capacidaddesectorbaja;
        this.capacidadasientosector = capacidadasientosector;
    }
    public int getCapacidaddesectorvip() {
        return capacidaddesectorvip;
    }
    public int getCapacidaddesectorcomun() {
        return capacidaddesectorcomun;
    }
    public int getCapacidaddesectoralta() {
        return capacidaddesectoralta;
    }
    public int getCapacidaddesectorbaja() {
        return capacidaddesectorbaja;
    }
    public int[] getCapacidadasientosector() {
        return capacidadasientosector;
    }

}

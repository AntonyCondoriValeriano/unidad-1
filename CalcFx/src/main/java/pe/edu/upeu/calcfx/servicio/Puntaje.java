package pe.edu.upeu.calcfx.servicio;

public class Puntaje {
    private int numeroPartido;
    private String jugador1;
    private String jugador2;
    private String ganador;
    private String estado;
    private String puntuacion;

    public Puntaje(int numeroPartido, String jugador1, String jugador2, String ganador, String estado, String puntuacion) {
        this.numeroPartido = numeroPartido;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.ganador = ganador.equals("Anulado") ? "Anulado" : ganador;
        this.estado = estado;
        this.puntuacion = puntuacion;
    }
    //devuelven valores
    public int getNumeroPartido() { return numeroPartido; }
    public String getJugador1() { return jugador1; }
    public String getJugador2() { return jugador2; }
    public String getGanador() { return ganador; }
    public String getEstado() { return estado; }
    public String getPuntuacion() { return puntuacion; }
}

package pe.edu.upeu.calcfx.servicio;

import org.springframework.stereotype.Service;

@Service
public class TictacToe {
    private int numP;
    private String NomJ1;
    private String NomJ2;
    private String Nomg;
    private String Esta;
    private String Punt;

    public TictacToe(int numeroPartido, String jugador1, String jugador2, String ganador, String estado, String puntuacion) {
        this.numP = numeroPartido;
        this.NomJ1 = jugador1;
        this.NomJ2 = jugador2;
        this.Nomg = ganador.equals("Anulado") ? "Anulado" : ganador;
        this.Esta = estado;
        this.Punt = puntuacion;
    }
    public int getNumeroPartido() { return numP; }
    public String getJugador1() { return NomJ1; }
    public String getJugador2() { return NomJ2; }
    public String getGanador() { return Nomg; }
    public String getEstado() { return Esta; }
    public String getPuntuacion() { return Punt; }
}

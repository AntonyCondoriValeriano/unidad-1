package pe.edu.upeu.calcfx.servicio;
import pe.edu.upeu.calcfx.modelo.Tictac;
import java.util.List;

public interface TictacToe {
    public void guardarResult(Tictac to);
    public List<Tictac> obtenerResult();
    public void actualizarResult(Tictac to, int index);
    public void eliminaResult(int index);

}

package pe.edu.upeu.calcfx.servicio;
import org.springframework.stereotype.Service;
import pe.edu.upeu.calcfx.modelo.Tictac;

import java.util.ArrayList;
import java.util.List;

@Service
public class TictacToeImp implements TictacToe{


    List<Tictac> Ganador= new ArrayList<>();
    @Override
    public void guardarResult(Tictac to) {

        Ganador.add(to);
    }

    @Override
    public List<Tictac> obtenerResult() {
        return Ganador;
    }

    @Override
    public void actualizarResult(Tictac to, int index) {
        Ganador.set(index, to);
    }

    @Override
    public void eliminaResult(int index) {
        Ganador.remove(index);
    }
}

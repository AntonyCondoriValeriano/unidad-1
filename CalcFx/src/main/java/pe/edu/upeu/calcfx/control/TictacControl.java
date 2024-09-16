package pe.edu.upeu.calcfx.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.upeu.calcfx.modelo.Tictac;
import pe.edu.upeu.calcfx.servicio.TictacToe;

@Component
public class TictacControl {

    @Autowired
    TictacToe serviceI;

    @FXML
    Button[][] tablero;


    @FXML
    Button btn00, btn01, btn02,btn10, btn11, btn12, btn20,btn21, btn22;

    boolean turno=true;
    @FXML
    public void initialize() {

        tablero=new Button[][]{
                {btn00, btn01, btn02},
                {btn10, btn11, btn12},
                {btn20,btn21, btn22}
        };
        anular();
    }

    @FXML
     public void accionButon(ActionEvent e){
        Button b=(Button)e.getSource();
        b.setText(turno?"X":"O");
        turno=!turno;
        comprobarGanador();
    }

    public void comprobarGanador() {
            for (int i = 0; i < 3; i++) {
                // Verifica filas
                if (tablero[i][0].getText().equals("X") &&
                        tablero[i][1].getText().equals("X") &&
                        tablero[i][2].getText().equals("X")) {
                    System.out.println("gano X" );
                }
                // Verifica columnas
                if (tablero[0][i].getText().equals("O") &&
                        tablero[1][i].getText().equals("O") &&
                        tablero[2][i].getText().equals("O")) {
                    System.out.println("gano \"O\"");
                }
            }
            // Verifica diagonales
            if (tablero[0][0].getText().equals("X") &&
                    tablero[1][1].getText().equals("X") &&
                    tablero[2][2].getText().equals("X")) {
                System.out.println("gano\"X\"" );
            }
            if (tablero[0][2].getText().equals("O") &&
                    tablero[1][1].getText().equals("O") &&
                    tablero[2][0].getText().equals("O")) {
                System.out.println("gano \"O\"" );
            }
        }


    public void imprimir() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(tablero[i][j].getText() + "\t");
            }
            System.out.println("");
        }
    }
    @FXML
    public void iniciar(){
        activaDesacticaB(false);
        imprimir();
    }

    public void anular(){
        activaDesacticaB(true);
        imprimir();
        limpiarTablero();
    }
    public void limpiarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j].setText(""); // Limpia el texto de cada casilla
            }
        }
    }

    public void activaDesacticaB(boolean indi){
        btn00.setDisable(indi);
        btn01.setDisable(indi);
        btn02.setDisable(indi);
        btn10.setDisable(indi);
        btn11.setDisable(indi);
        btn12.setDisable(indi);
        btn20.setDisable(indi);
        btn21.setDisable(indi);
        btn22.setDisable(indi);
    }

}

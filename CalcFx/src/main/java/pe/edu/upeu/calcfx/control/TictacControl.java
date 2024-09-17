package pe.edu.upeu.calcfx.control;

import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upeu.calcfx.servicio.TictacToe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import org.springframework.stereotype.Component;


import java.util.ArrayList;

@Component
public class TictacControl {

    @FXML
    Button[][] tablero;
    @FXML
    private TextField nombreJugador1, nombreJugador2;

    @FXML
    private TableView<TictacToe> tablaPuntajes;
    @FXML
    private TableColumn<TictacToe, Integer> numP;
    @FXML
    private TableColumn<TictacToe, String> NomJ2;
    @FXML
    private TableColumn<TictacToe, String> Nomg;
    @FXML
    private TableColumn<TictacToe, String> Punt;
    @FXML
    private TableColumn<TictacToe, String> Esta;


    @FXML
    Button btn00, btn01, btn02,btn10, btn11, btn12, btn20,btn21, btn22;

    boolean turno=true;
    private ArrayList<TictacToe> partidas = new ArrayList<>();
    private String jugador1, jugador2;
    private int numeroPartidas = 1;
    @FXML
    public void initialize() {
        jugador1 = nombreJugador1.getText();
        jugador2 = nombreJugador2.getText();
        tablero=new Button[][]{
                {btn00, btn01, btn02},
                {btn10, btn11, btn12},
                {btn20,btn21, btn22}
        };
        anular();
        numP.setCellValueFactory(new PropertyValueFactory<>("numP"));
        NomJ2.setCellValueFactory(new PropertyValueFactory<>("NomJ2"));
        Nomg.setCellValueFactory(new PropertyValueFactory<>("Nomg"));
        Punt.setCellValueFactory(new PropertyValueFactory<>("Punt"));
        Esta.setCellValueFactory(new PropertyValueFactory<>("Esta"));
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
                    registrarResultado("ganador", "terminado","1");
                }
                // Verifica columnas
                if (tablero[0][i].getText().equals("O") &&
                        tablero[1][i].getText().equals("O") &&
                        tablero[2][i].getText().equals("O")) {
                    registrarResultado("ganador", "terminado","1");
                }
            }
            // Verifica diagonales
            if (tablero[0][0].getText().equals("X") &&
                    tablero[1][1].getText().equals("X") &&
                    tablero[2][2].getText().equals("X")) {
                registrarResultado("ganador", "terminado","1");
            }
            if (tablero[0][2].getText().equals("O") &&
                    tablero[1][1].getText().equals("O") &&
                    tablero[2][0].getText().equals("O")) {
                registrarResultado("ganador", "terminado","1");
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
    public void registrarResultado(String ganador, String estado, String puntuacion) {
        TictacToe nuevoPuntaje = new TictacToe(numeroPartidas, jugador1, jugador2, ganador, estado, puntuacion);
        partidas.add(nuevoPuntaje);
        tablaPuntajes.getItems().add(nuevoPuntaje);
        numeroPartidas++;
    }
    @FXML
    public boolean esEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j].getText().isEmpty()) {
                    System.out.println("es empate");
                    return false;
                }
            }
        }
        return true;
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
        registrarResultado("anulado", "terminado","0");
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

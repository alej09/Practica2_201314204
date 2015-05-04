package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


 
public class Hanoi extends JFrame implements ActionListener, ChangeListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labelNroDiscos;
    private JLabel labelInformacion;
    private JLabel spinnerNroDiscos;
    private JButton botonIniciar;
    private Graficos dibujo;

    public Hanoi() {
        super("TUTORIAL TORRES DE HANOI");
        configurarVentana();
        inicializarComponentes();
        this.setVisible(true);
    }

    private void configurarVentana() {
        this.setSize(900, 620);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {

        JPanel panelInferior = new JPanel();

        labelNroDiscos = new JLabel(" ");
        panelInferior.add(labelNroDiscos);

        spinnerNroDiscos = new JLabel("5 Discos");
        
        panelInferior.add(spinnerNroDiscos);

        botonIniciar = new JButton("Iniciar");
        botonIniciar.addActionListener(this);
        panelInferior.add(botonIniciar);

        labelInformacion = new JLabel("RESOLUCIÓN COMPLETADA");
        labelInformacion.setForeground(Color.red);
        labelInformacion.setVisible(false);
        panelInferior.add(labelInformacion);

        add(panelInferior, BorderLayout.SOUTH);
        dibujo = new Graficos(5, this);
        add(dibujo, BorderLayout.CENTER);


    }

    public void actionPerformed(ActionEvent e) {
        if (botonIniciar.getText().equals("Pausar")) {
            dibujo.pausarAnimacion();
            botonIniciar.setText("Continuar");
        } else {
            if (botonIniciar.getText().equals("Iniciar De Nuevo")) {
                dibujo = new Graficos(Integer.parseInt(spinnerNroDiscos.getSize().toString()), this);
                add(dibujo, BorderLayout.CENTER);
                botonIniciar.setText("Iniciar");
                labelInformacion.setVisible(false);
                this.setVisible(true);
            } else {
                dibujo.iniciarAnimacion();
                botonIniciar.setText("Pausar");
            }
        }
    }

    public void stateChanged(ChangeEvent e) {
        dibujo.pausarAnimacion();
        botonIniciar.setText("Iniciar");
        labelInformacion.setVisible(false);
        dibujo = new Graficos(Integer.parseInt(spinnerNroDiscos.getSize().toString()), this);
        add(dibujo, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void resolucionCompletada() {
        botonIniciar.setText("Iniciar De Nuevo");
        labelInformacion.setVisible(true);
    }
}
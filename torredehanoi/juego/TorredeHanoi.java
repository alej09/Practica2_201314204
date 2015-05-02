package juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import menu.Hanoi;

public class TorredeHanoi {
	
	
	private ImageIcon fondotorres = new ImageIcon("dibujos\\torres.png");

	public TorredeHanoi(){
		//CREANDO VENTANA
		final JFrame ven = new JFrame("TORRE  DE  HANOI");
		ven.setSize(900, 620);
		ven.setVisible(true);
		ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ven.setLocationRelativeTo(null);
		ven.setResizable(false);
		ven.setLayout(null);
		
		JLabel fondo = new JLabel(fondotorres);
		fondo.setSize(900, 620);
		fondo.setVisible(true);
		
		//CREANDO BOTONES
		JButton bNuevo = new JButton("Nuevo Juego");
		bNuevo.setBounds(310, 310, 200, 35);

		JButton bDemo = new JButton("Tutorial");
		bDemo.setBounds(310, 355, 200, 35);
		
		JButton bPuntajes = new JButton("Puntajes");
		bPuntajes.setBounds(310, 400, 200, 35);
		
		//CREANDO CAJA DE USUARIO
		JTextField usuario = new JTextField();
		usuario.setBounds(310, 207, 120, 20);
		
		
		//CREANDO LISTA DE DISCOS
		String[] numero = new String[] {"3","4","5","6","7","8"};
        final JComboBox<String> discos = new JComboBox<String>(numero);
        JLabel nu = new JLabel("N�mero de Discos");
        nu.setBounds(200, 248, 50, 50);
        discos.setVisible(false);
        discos.setBounds(310,248,50,20);
		
		
		//A�ADIENDO COMPONENTES
		ven.add(bNuevo);
		ven.add(bDemo);
		ven.add(bPuntajes);
		ven.add(discos);
		discos.setVisible(true);
		ven.add(usuario);
		ven.repaint();
		
		//EVENTO DE BOTON NUEVO JUEGO
		bNuevo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	ven.dispose();
            	llamarNuevo(discos.getSelectedItem());
            }
        });
		
		//EVENTO DE BOTON DEMO
		bDemo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	ven.dispose();
            	llamarTutorial();
            }
        });
		
	}
	
	public void llamarNuevo(Object num){
        String i = (String) num;
		BotonesTorres jt = new BotonesTorres();
		jt.nuevoJuego(i);
	}
	
	public void llamarTutorial(){
		new Hanoi();
		
	}
	
	public static void main(String[] args){
		TorredeHanoi t = new TorredeHanoi();
		
	}

}

package juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BotonesTorres {
	//CARGANDO IMAGENES
	private ImageIcon fondo = new ImageIcon("dibujos\\torres.png");

	public String Discos;
	
		
		JFrame nueva = null;
	
		private ImageIcon disc1 = new ImageIcon("dibujos\\disco1.png");
		private ImageIcon disc2 = new ImageIcon("dibujos\\disco2.png");
		private ImageIcon disc3 = new ImageIcon("dibujos\\disco3.png");
		private ImageIcon disc4 = new ImageIcon("dibujos\\disco4.png");
		private ImageIcon disc5 = new ImageIcon("dibujos\\disco5.png");
		private ImageIcon disc6 = new ImageIcon("dibujos\\disco6.png");
		private ImageIcon disc7 = new ImageIcon("dibujos\\disco7.png");
		private ImageIcon disc8 = new ImageIcon("dibujos\\disco8.png");
		
		////////////
		JLabel disco0 = null;
		JLabel disco1 = null;
		JLabel disco2 = null;
		JLabel disco3 = null;
		JLabel disco4 = null;
		JLabel disco5 = null;
		JLabel disco6 = null;
		JLabel disco7 = null;
		
		
		
		public void nuevoJuego(String discos){
			//CREANDO VENTANA
			final JFrame nueva = new JFrame("NUEVO  JUEGO  -  TORRES  DE  HANOI");
			nueva.setSize(900, 620);
			nueva.setVisible(true);
			nueva.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			nueva.setLocationRelativeTo(null);
			nueva.setResizable(false);
			nueva.setLayout(null);
			
			JLabel fondoJ = new JLabel(fondo);
			fondoJ.setSize(900, 600);
			
			//BOTON
			JButton bRegresar = new JButton("Regresar");
			bRegresar.setBounds(800, 0, 100, 20);
			
			final JButton empezar = new JButton("Empezar a jugar");
			empezar.setBounds(400,90,150,20);
			
			//LABEL CRONOMETRO:
			final JLabel crono = new JLabel("00:00:00:00");
			crono.setBounds(435, 65, 100, 20);
			
			//GENERANDO
			generarDiscos(nueva,discos);
			//generar(nueva,discos);
			
			//BOTONES DE MOVIMIENTO
			
			final JButton t1at2 = new JButton("A TORRE 2");
			final JButton t1at3 = new JButton("A TORRE 3");
			final JButton t2at1 = new JButton("A TORRE 1");
			final JButton t2at3 = new JButton("A TORRE 3");
			final JButton t3at1 = new JButton("A TORRE 1");
			final JButton t3at2 = new JButton("A TORRE 2");
			
			t1at2.setBounds(60,560,100,20);
			t1at3.setBounds(170,560,100,20);
			t2at1.setBounds(350,560,100,20);
			t2at3.setBounds(460,560,100,20);
			t3at1.setBounds(640,560,100,20);
			t3at2.setBounds(750,560,100,20);
			
			/*t1at2.setEnabled(false);
			t1at3.setEnabled(false);
			t2at1.setEnabled(false);
			t2at3.setEnabled(false);
			t3at1.setEnabled(false);
			t3at2.setEnabled(false);*/
			
			
			//AGREGANDO A INTERFAZ
			nueva.add(crono);
			nueva.add(t1at2);
			nueva.add(t1at3);
			nueva.add(t2at1);
			nueva.add(t2at3);
			nueva.add(t3at1);
			nueva.add(t3at2);
			nueva.add(bRegresar);
			nueva.add(empezar);
			nueva.repaint();
			nueva.add(fondoJ);
			
			
			//EVENTO REGRESAR
			empezar.addActionListener(new ActionListener(){
	            @Override
	            public void actionPerformed(ActionEvent e){
	        		empezar.setEnabled(false);
	        		iniciarCrono(crono);
	            }
	        });
			
			//EVENTO INICIAR
			bRegresar.addActionListener(new ActionListener(){
	            @Override
	            public void actionPerformed(ActionEvent e){
	            	nueva.dispose();
	            	llamarMenu();
	            }
	        });
		        
			//*************
			final Stack<Integer>[] torres = new Stack[4];
	        torres[1] = new Stack<Integer>();
	        torres[2] = new Stack<Integer>();
	        torres[3] = new Stack<Integer>();
	        torres[1].push(1);
        	torres[1].push(2);
        	torres[1].push(3);
	        final int y[] ={485,445,405,365,325,285,245,205};
	        
			t1at2.addActionListener(new ActionListener(){ // boton torre 1 a torre 2
	            public void actionPerformed(ActionEvent e){
	            	int ficha = 0;
	            	
	            	ficha = torres[1].pop();
	            	torres[2].push(ficha);
	            	disco1.setBounds(625, y[0], 240, 40);
	            	
	            }
	        });
			t1at3.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e){
	            	
	            	disco0.setBounds(332, y[0], 240, 40);
	            	
	            }
	        });
			t2at1.addActionListener(new ActionListener(){
				int yy[] ={485,445,405,365,325,285,245,205};
	            public void actionPerformed(ActionEvent e){
	            	disco0.setBounds(45, yy[1], 240, 40);
	            	
	            }
	        });
			t2at3.addActionListener(new ActionListener(){
				int yy[] ={485,445,405,365,325,285,245,205};
	            public void actionPerformed(ActionEvent e){
	            	disco0.setBounds(625, yy[1], 240, 40);
	            	
	            }
	        });
			
			t3at1.addActionListener(new ActionListener(){
				int yy[] ={485,445,405,365,325,285,245,205};
	            public void actionPerformed(ActionEvent e){
	            	disco1.setBounds(45, yy[0], 240, 40);
	            	
	            }
	        });
			
			t3at2.addActionListener(new ActionListener(){
				int yy[] ={485,445,405,365,325,285,245,205};
	            public void actionPerformed(ActionEvent e){
	            	disco2.setBounds(332, yy[0], 240, 40);
	            	
	            }
	        });
			
		}
		public void llamarMenu(){
	    	String[] args=null;
	    	TorredeHanoi.main(args);
		}
		
		public void iniciarCrono(JLabel crono){
			Tiempo tiempo = new Tiempo();
			tiempo.correr(crono,nueva);
			
		}
	
		public void generarDiscos(JFrame ventana, String Discos){ // dibujar los discos
			
			BotonesTorres jn = new BotonesTorres();
			disco0 = new JLabel(jn.disc1);
			disco1 = new JLabel(jn.disc2);
			disco2 = new JLabel(jn.disc3);
			disco3 = new JLabel(jn.disc4);
			disco4 = new JLabel(jn.disc5);
			disco5 = new JLabel(jn.disc6);
			disco6 = new JLabel(jn.disc7);
			disco7 = new JLabel(jn.disc8);
			
			final int y[] ={485,445,405,365,325,285,245,205};
			int d = Integer.parseInt(Discos);
			
			final Stack<Integer>[] torres = new Stack[4];
	        torres[1] = new Stack<Integer>();
	        torres[2] = new Stack<Integer>();
	        torres[3] = new Stack<Integer>();
		
	        
	        
			//GENERANDO DISCOS
			if(d==3){
				disco2.setBounds(45, y[0], 240, 40);
				disco1.setBounds(45, y[1], 240, 40);
				disco0.setBounds(45, y[2], 240, 40);
				ventana.add(disco2);
				ventana.add(disco1);
				ventana.add(disco0);
				ventana.repaint();
					
		        	torres[1].push(1);
		        	torres[1].push(2);
		        	torres[1].push(3);
					
				}
			            
			 else if(d==4){
				disco3.setBounds(45, y[0], 240, 40);
				disco2.setBounds(45, y[1], 240, 40);
				disco1.setBounds(45, y[2], 240, 40);
				disco0.setBounds(45, y[3], 240, 40);
				ventana.add(disco3);
				ventana.add(disco2);
				ventana.add(disco1);
				ventana.add(disco0);
				ventana.repaint();
				
				torres[1].push(1);
    			torres[1].push(2);
    			torres[1].push(3);
    			torres[1].push(4);
			}
			
			
			
			else if (d==5){
				disco4.setBounds(45, y[0], 240, 40);
				disco3.setBounds(45, y[1], 240, 40);
				disco2.setBounds(45, y[2], 240, 40);
				disco1.setBounds(45, y[3], 240, 40);
				disco0.setBounds(45, y[4], 240, 40);
				ventana.add(disco4);
				ventana.add(disco3);
				ventana.add(disco2);
				ventana.add(disco1);
				ventana.add(disco0);
				ventana.repaint();
				torres[1].push(1);
     			torres[1].push(2);
     			torres[1].push(3);
     			torres[1].push(4);
     			torres[1].push(5);
			}
			else if(d==6){
				disco5.setBounds(45, y[0], 240, 40);
				disco4.setBounds(45, y[1], 240, 40);
				disco3.setBounds(45, y[2], 240, 40);
				disco2.setBounds(45, y[3], 240, 40);
				disco1.setBounds(45, y[4], 240, 40);
				disco0.setBounds(45, y[5], 240, 40);
				ventana.add(disco5);
				ventana.add(disco4);
				ventana.add(disco3);
				ventana.add(disco2);
				ventana.add(disco1);
				ventana.add(disco0);
				ventana.repaint();
				torres[1].push(1);
    			torres[1].push(2);
    			torres[1].push(3);
    			torres[1].push(4);
    			torres[1].push(5);
    			torres[1].push(6);
			}
			
			else if (d==7){
				disco6.setBounds(45, y[0], 240, 40);
				disco5.setBounds(45, y[1], 240, 40);
				disco4.setBounds(45, y[2], 240, 40);
				disco3.setBounds(45, y[3], 240, 40);
				disco2.setBounds(45, y[4], 240, 40);
				disco1.setBounds(45, y[5], 240, 40);
				disco0.setBounds(45, y[6], 240, 40);
				ventana.add(disco6);
				ventana.add(disco5);
				ventana.add(disco4);
				ventana.add(disco3);
				ventana.add(disco2);
				ventana.add(disco1);
				ventana.add(disco0);
				ventana.repaint();
				torres[1].push(1);
    			torres[1].push(2);
    			torres[1].push(3);
    			torres[1].push(4);
    			torres[1].push(5);
    			torres[1].push(6);
    			torres[1].push(7);
			}else{
				disco7.setBounds(45, y[0], 240, 40);
				disco6.setBounds(45, y[1], 240, 40);
				disco5.setBounds(45, y[2], 240, 40);
				disco4.setBounds(45, y[3], 240, 40);
				disco3.setBounds(45, y[4], 240, 40);
				disco2.setBounds(45, y[5], 240, 40);
				disco1.setBounds(45, y[6], 240, 40);
				disco0.setBounds(45, y[7], 240, 40);
				ventana.add(disco7);
				ventana.add(disco6);
				ventana.add(disco5);
				ventana.add(disco4);
				ventana.add(disco3);
				ventana.add(disco2);
				ventana.add(disco1);
				ventana.add(disco0);
				
				torres[1].push(1);
      			torres[1].push(2);
      			torres[1].push(3);
      			torres[1].push(4);
      			torres[1].push(5);
      			torres[1].push(6);
      			torres[1].push(7);
      			torres[1].push(8);
				
				ventana.repaint();
			}	
		}
}

package menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class JuegoTorres extends JFrame {

    /**
	 * 
	 */
	
	Dimension tamano = Toolkit.getDefaultToolkit().getScreenSize();
	
	private static final long serialVersionUID = 1L;

    int minutos = 0, segundos = 0, horas = 0;
    int encender=0;
    Timer cronometro;
    Timer parpadeo;
    static int[][] matrizTorres = new int[11][11];// matriz
    int posicionTorre1 = 45;
    int posicionTorre2 = 335;
    int posicionTorre3 = 622;
    int i;
    int j;
    int b=0;
    static int escalones = 3;
    static int torre = 4;// 1,2,3
    // torre desde y hasta
    public int desde = 0;
    public int hasta = 0;
    int vertical = 455;
    int contador; //solo hasta 1
    // Almacenan valores para reponer
    int torreDesde;
    int guardaIDesde;
    int guardaDesde;
    int torreHasta;
    int guardaIHasta;
    int guardaHasta;
    int jugadasPosibles;
    // Contadores
    int jugadasRealizadas;
    int aciertos;
    int avisos;
    // coordenadas para colocar escalones
    int x;
    int y;
    int a;// posici�n vertical
    //int b;// posicion horizontal
    double pixelVertical;
    //double pixelHorizontal;

    public JuegoTorres() {
       super("Juego Torres de Hanoi");
    	
    	
        //this.setLocation((int) tamano.getWidth() / 2 - this.getWidth() / 2, (int) tamano.getHeight() / 2 - this.getHeight() / 2);
        initComponents();
        setResizable(false);
        new Cronometro(); //llama a la clase cronometro
        

        jugadasPosibles = (2 * 2) - 1;
        jLabel4.setText("" + jugadasPosibles);

        //llama a estos metodos
        mostrarBaseTorres();
        llenarMatriz();

    }
    


    private class Cronometro implements ActionListener { //clase
        //Timer da milisegundos, pero aqui hacemos que funcione como cron�metro

        private Timer cronometro = new Timer(1000, this);
       
        //metodos de la clase
        public Cronometro() {
        	cronometro.start();// empieza desde 0 (o pone a cero)
        }

        public void actionPerformed(ActionEvent e) {
            segundos++;
            if (segundos == 59) {
                segundos = 0;
                minutos++;
            }
            if (minutos == 59) {
                minutos = 0;
                horas++;
            }
            jLabel21.setText(horas + ":" + minutos + ":" + segundos);

            if (segundos == 10000000) {

                Toolkit.getDefaultToolkit().beep();
                cronometro.stop();
            }
            encender++;
        }
        
    }
   
private class Parpadeo implements ActionListener { //clase
        
        private Timer parpadeo = new Timer(10, this);
        //metodos de la clase
        public Parpadeo() {
            b = 0;
            encender=0;
            parpadeo.start();
        }

        public void actionPerformed(ActionEvent e) {
            //b=0;
            encender++;
            b++;
            jLabel8.setForeground(Color.red);
            jLabel9.setForeground(Color.red);
           
            if (encender == 50) { 
                 System.out.println("encender= "+encender); 
                jLabel8.setVisible(false);
                jLabel9.setVisible(false);

            } else {
                if (encender == 100) {
                    System.out.println("encender= "+encender); 
                    jLabel8.setVisible(true);
                    jLabel9.setVisible(true);
                    encender = 0;
                }
            }

            if (b == 300) {
                Toolkit.getDefaultToolkit().beep();
                parpadeo.stop();
                jLabel8.setVisible(true);
                jLabel9.setVisible(true);
                jLabel8.setForeground(Color.black);
                jLabel9.setForeground(Color.black);
            }
            System.out.println("encender= "+encender);   
            
        }
        
    }

    public void llenarMatriz() {
        matrizTorres[escalones][1] = escalones;
        matrizTorres[escalones][2] = escalones;
        matrizTorres[escalones][3] = escalones;
        for (i = 1; i < escalones; i++) {
            for (j = 1; j < torre; j++) {
                matrizTorres[i][j] = 0;
                matrizTorres[i][1] = i;
            }
        }
        mostrarMatriz();
    }

    public void mostrarMatriz() {
        for (i = 1; i < escalones; i++) {
            for (j = 1; j < torre; j++) {
               
            }
            
        }
        
        modoGrafico();
    }

    public void mostrarBaseTorres() {
        //1.- Coodenada vertical 2.- Coordinada horizontal 3.- ancho del objeto 4.-Alto del objeto 
        jButton1.setBounds(110, 570, 100, 50);
        jButton2.setBounds(400, 570, 100, 50);
        jButton3.setBounds(690, 570, 100, 50);
    }

    public void modoGrafico() {

        if (escalones == 3) {

            y = 455;

            jLabel12.setVisible(false);
            jLabel13.setVisible(false);
            jLabel14.setVisible(false);
            jLabel15.setVisible(false);
            jLabel16.setVisible(false);
            jLabel17.setVisible(false);
        }

        for (i = 1; i < escalones; i++) {
            for (j = 1; j < torre; j++) {
                if (j == 1) {
                    x = posicionTorre1;//Pimera base o torre
                }
                if (j == 2) {
                    x = posicionTorre2;//Segunda base
                }
                if (j == 3) {
                    x = posicionTorre3;//Tercera base
                }

                if (i == 1) {
                    a = 0;
                }
                if (i == 2) {
                    a = 40;
                }
                if (i == 3) {
                    a = 80;
                }
                if (i == 4) {
                    a = 120;
                }
                if (i == 5) {
                    a = 160;
                }
                if (i == 6) {
                    a = 200;
                }
                if (i == 7) {
                    a = 240;
                }
                if (i == 8) {
                    a = 280;
                }
            
                if (matrizTorres[i][j] == 1) {jLabel10.setBounds(x, y + a, 240, 40);} //disco1	
                if (matrizTorres[i][j] == 2) {jLabel11.setBounds(x, y + a, 240, 40);}//disco2
                if (matrizTorres[i][j] == 3) {jLabel12.setBounds(x, y + a, 240, 40);}//disco3
                if (matrizTorres[i][j] == 4) {jLabel13.setBounds(x, y + a, 240, 40);}//disco4
                if (matrizTorres[i][j] == 5) {jLabel14.setBounds(x, y + a, 240, 40);}//disco5
                if (matrizTorres[i][j] == 6) {jLabel15.setBounds(x, y + a, 240, 40);}//disco6
                if (matrizTorres[i][j] == 7) {jLabel16.setBounds(x, y + a, 240, 40);}//disco7
                if (matrizTorres[i][j] == 8) {jLabel17.setBounds(x, y + a, 240, 40);}//disco8
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    public void initComponents() {
    	
		
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
		
		
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        new javax.swing.JMenuItem();
        new javax.swing.JPopupMenu.Separator();
        new javax.swing.JMenuItem();
        new javax.swing.JPopupMenu.Separator();
        new javax.swing.JMenuItem();
        new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Juego Torres de Hanoi");
        setMinimumSize(new java.awt.Dimension(900, 670));
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 15)); 
        jButton1.setText("Torre 1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(60, 280, 100, 70);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 15));
        jButton2.setText("Torre 2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(100, 100, 100, 70);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 15)); 
        jButton3.setText("Torre 3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(520, 280, 100, 50);
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 20)); 
        jButton4.setText("Mover");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(30, 50, 100, 50);
		
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20));
        jLabel1.setText("Jugadas posibles");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(240, 15, 180, 29);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20));
        jLabel2.setText("Jugadas realizadas");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(240, 45, 220, 29);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20));
        jLabel3.setText("Aciertos");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(240, 75, 190, 29);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("0");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(480, 15, 40, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("0");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(470, 45, 50, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); 
        jLabel6.setForeground(new java.awt.Color(0, 102, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("0");
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(440, 75, 80, 20);

       

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); 
        getContentPane().add(jLabel8);
        jLabel8.setBounds(650, 10, 50, 50);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 36)); 
        getContentPane().add(jLabel9);
        jLabel9.setBounds(710, 10, 50, 50);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setOpaque(true);
        getContentPane().add(jLabel10);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dibujos/disco1.png"))); 
        jLabel10.setBounds(10, 60, 60, 40);
      
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dibujos/disco2.png")));
        jLabel11.setOpaque(true);
        getContentPane().add(jLabel11);
        jLabel11.setBounds(10, 60, 60, 40);

  
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dibujos/disco3.jpg")));
        jLabel12.setOpaque(false);
        getContentPane().add(jLabel12);
        jLabel12.setBounds(10, 90, 90, 40);

    
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dibujos/disco4.jpg"))); 
        jLabel13.setOpaque(false);
        getContentPane().add(jLabel13);
        jLabel13.setBounds(10, 120, 100, 40);

 
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dibujos/disco5.jpg"))); 
        jLabel14.setOpaque(true);
        getContentPane().add(jLabel14);
        jLabel14.setBounds(10, 150, 130, 40);

 
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dibujos/disco6.jpg"))); 
        jLabel15.setOpaque(true);
        getContentPane().add(jLabel15);
        jLabel15.setBounds(10, 180, 160, 40);

      
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dibujos/disco7.jpg")));
        jLabel16.setOpaque(true);
        getContentPane().add(jLabel16);
        jLabel16.setBounds(10, 210, 180, 40);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 20));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dibujos/disco8.jpg")));
        jLabel17.setOpaque(false);
        getContentPane().add(jLabel17);
        jLabel17.setBounds(10, 240, 200, 40);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 20));
        jLabel18.setText("Avisos");
        
        jLabel18.setBounds(240, 105, 160, 20);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 20));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("0");
      
        jLabel19.setBounds(470, 105, 50, 20);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 20));
        jLabel20.setText("Tiempo (seg.)");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(240, 135, 160, 20);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 20));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("0");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(400, 135, 120, 20);
       
        
        configurarPanel1();
       

        jMenu3.setText("Opciones");

        jMenuItem8.setText("Salir");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        
        jMenu3.add(jMenuItem8);
        jMenuItem9.setText("Regresar");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Discos");

        jMenuItem1.setText("2 Discos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem2.setText("3 Discos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuItem3.setText("4 Discos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuItem4.setText("5 Discos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem5.setText("6 Discos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuItem6.setText("7 Discos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem7.setText("8 Discos");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }                      
    
   
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        if (desde == 0) {
            desde = 1;
            jLabel8.setText("" + desde);
        } else {
            if (hasta == 0) {
                hasta = 1;
                jLabel9.setText("" + hasta);
            }
        }
        torreDesdeVacia();
    }                                        
	 
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if (desde == 0) {
            desde = 2;
            jLabel8.setText("" + desde);
        } else {
            if (hasta == 0) {
                hasta = 2;
                jLabel9.setText("" + hasta);
            }
        }
        torreDesdeVacia();
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        if (desde == 0) {
            desde = 3;
            jLabel8.setText("" + desde);
        } else {
            if (hasta == 0) {
                hasta = 3;
                jLabel9.setText("" + hasta);
            }
        }
        torreDesdeVacia();
    }                                        
 
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        torreHastaVacia();
        jugadasRealizadas = jugadasRealizadas + 1;
        jLabel5.setText("" + jugadasRealizadas);
        colocarEscalones();
        mostrarMatriz();
        desde = 0;
        jLabel8.setText("");
        hasta = 0;
        jLabel9.setText("");
        felicitacion();
    }                                        

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
        y = 455;
        jLabel10.setVisible(true);
        jLabel11.setVisible(true);
        jLabel12.setVisible(true);
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
        jLabel15.setVisible(false);
        jLabel16.setVisible(false);
        jLabel17.setVisible(false);
        escalones = 3;
        minutos = 0;
        segundos = 0;
        horas = 0;
        llenarMatriz();
        jugadasPosibles = (int) Math.pow(2, 2) - 1;//potencia de un numero
        jLabel4.setText("" + jugadasPosibles);
    }                                          

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
      
        y = 415;
        jLabel10.setVisible(true);
        jLabel11.setVisible(true);
        jLabel12.setVisible(true);
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
        jLabel15.setVisible(false);
        jLabel16.setVisible(false);
        jLabel17.setVisible(false);
        escalones = 4;
        minutos = 0;
        segundos = 0;
        horas = 0;
        llenarMatriz();
        jugadasPosibles = (int) Math.pow(2, 3) - 1;//potencia de un numero
        jLabel4.setText("" + jugadasPosibles);
    }                                          

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
       
        y = 375;
        jLabel10.setVisible(true);
        jLabel11.setVisible(true);
        jLabel12.setVisible(true);
        jLabel13.setVisible(true);
        jLabel14.setVisible(false);
        jLabel15.setVisible(false);
        jLabel16.setVisible(false);
        jLabel17.setVisible(false);
        escalones = 5;
        minutos = 0;
        segundos = 0;
        horas = 0;
        llenarMatriz();
        jugadasPosibles = (int) Math.pow(2, 4) - 1;//potencia de un numero
        jLabel4.setText("" + jugadasPosibles);
    }                                          

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {                                           
       
        y = 335;
        jLabel10.setVisible(true);
        jLabel11.setVisible(true);
        jLabel12.setVisible(true);
        jLabel13.setVisible(true);
        jLabel14.setVisible(true);
        jLabel15.setVisible(false);
        jLabel16.setVisible(false);
        jLabel17.setVisible(false);
        minutos = 0;
        segundos = 0;
        horas = 0;
        escalones = 6;
        llenarMatriz();
        jugadasPosibles = (int) Math.pow(2, 5) - 1;//potencia de un numero
        jLabel4.setText("" + jugadasPosibles);
}                                          

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {                                           
       
        y = 295;
        jLabel10.setVisible(true);
        jLabel11.setVisible(true);
        jLabel12.setVisible(true);
        jLabel13.setVisible(true);
        jLabel14.setVisible(true);
        jLabel15.setVisible(true);
        jLabel16.setVisible(false);
        jLabel17.setVisible(false);
        minutos = 0;
        segundos = 0;
        horas = 0;
        escalones = 7;
        llenarMatriz();
        jugadasPosibles = (int) Math.pow(2, 6) - 1;//potencia de un numero
        jLabel4.setText("" + jugadasPosibles);
}                                          

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {                                           
       
        y = 255;
        jLabel10.setVisible(true);
        jLabel11.setVisible(true);
        jLabel12.setVisible(true);
        jLabel13.setVisible(true);
        jLabel14.setVisible(true);
        jLabel15.setVisible(true);
        jLabel16.setVisible(true);
        jLabel17.setVisible(false);
        minutos = 0;
        segundos = 0;
        horas = 0;
        escalones = 8;
        llenarMatriz();
        jugadasPosibles = (int) Math.pow(2, 7) - 1;//potencia de un numero
        jLabel4.setText("" + jugadasPosibles);
}                                          

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
        y = 215;
        jLabel10.setVisible(true);
        jLabel11.setVisible(true);
        jLabel12.setVisible(true);
        jLabel13.setVisible(true);
        jLabel14.setVisible(true);
        jLabel15.setVisible(true);
        jLabel16.setVisible(true);
        jLabel17.setVisible(true);
        minutos = 0;
        segundos = 0;
        horas = 0;
        escalones = 9;
        llenarMatriz();
        jugadasPosibles = (int) Math.pow(2, 8) - 1;//potencia de un numero
        jLabel4.setText("" + jugadasPosibles);
        
}                                                
    
    public static void llamarMenu(){
    	String[] args=null;
    	TorredeHanoi.main(args);
	}
    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	JuegoTorres.DISPOSE_ON_CLOSE();
    	
    }                                          

    private static void DISPOSE_ON_CLOSE() {
    	llamarMenu();
	}

	private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {                                            
       
        System.exit(0);
    }                                           

                     
     

   
    public void colocarEscalones() {// construye los discos

        for (i = 1; i < escalones; i++) {
            if (matrizTorres[i][desde] != 0) {
              
                contador = contador + 1;
                if (contador == 1) {
                    torreDesde = matrizTorres[i][desde];
                    guardaIDesde = i;
                    matrizTorres[i][desde] = 0;
                }
            }
        }

        contador = 0;

        for (i = 1; i < escalones; i++) {

            if (matrizTorres[i + 1][hasta] != 0) {

                escalonGrande();
                contador = contador + 1;

                if (contador == 1) {
                    mismaTorre();
                    guardaIHasta = i; 
                    matrizTorres[i][hasta] = torreDesde;
                }
            }
        }

        contador = 0;
    }

    public void mismaTorre() {
        if (desde == hasta) {
        
            new Parpadeo();
            Object[] opciones = {"Aceptar"};
            JOptionPane.showOptionDialog(null, "            AVISO-1\n\n Seleccionastes la misma torre", "ATENCI�N: Se ha producido un error",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, opciones, opciones[0]);

            jugadasRealizadas = jugadasRealizadas - 1;
            jLabel5.setText("" + jugadasRealizadas);
           
            avisos = avisos + 1;//contador de errores
            jLabel19.setText("" + avisos);
          
            jLabel8.setText("");
            
            jLabel9.setText("");
        }
    }

    public void escalonGrande() {

        if (matrizTorres[i - 1][hasta] > matrizTorres[i][hasta]) {
          
            new Parpadeo();
            Object[] opciones = {"Aceptar"};
            JOptionPane.showOptionDialog(null, "            AVISO\n\n No se puede poner un Disco mas grande encima de otro mas peque�o", "ATENCI�N: Se ha producido un error",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, opciones, opciones[0]);
            
            matrizTorres[guardaIDesde][desde] = torreDesde; 
            matrizTorres[guardaIHasta][hasta] = torreHasta; 
  
            jugadasRealizadas = jugadasRealizadas - 1;
            jLabel5.setText("" + jugadasRealizadas);
            avisos = avisos + 1;
            jLabel19.setText("" + avisos);
        }
    }

    public void torreDesdeVacia() {
        if (matrizTorres[escalones - 1][desde] == 0) {
      
            new Parpadeo();
            Object[] opciones = {"Aceptar"};
            JOptionPane.showOptionDialog(null, "            AVISO-2\n\n La Torre Esta Vacia \n " , "ATENCI�N: Se ha producido un error",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, opciones, opciones[0]);

            avisos = avisos + 1;
            jLabel19.setText("" + avisos);
            desde = 0;
            jLabel8.setText("");
            
        }
    }

    public void torreHastaVacia() {
        if (matrizTorres[i][hasta] == 0) {
            
            new Parpadeo();
            Object[] opciones = {"Aceptar"};
            JOptionPane.showOptionDialog(null, "            AVISO-3\n\n No se indico la torre destino" , "ATENCI�N: JUGAR Se ha producido un error",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, opciones, opciones[0]);

            jugadasRealizadas = jugadasRealizadas - 1;
            jLabel5.setText("" + jugadasRealizadas);
            avisos = avisos + 1;
            jLabel19.setText("" + avisos);
            desde = 0;
            jLabel8.setText("");
           
        }
    }

    public void felicitacion() {

        if (matrizTorres[1][2] == 1 || matrizTorres[1][3] == 1) {
            if (matrizTorres[escalones - 1][1] == 0) {
                aciertos = aciertos + 1;
                jLabel6.setText("" + aciertos);
               
                Object[] opciones = {"Aceptar"};
                JOptionPane.showOptionDialog(null, "==================================================\n==                                                                                                           ==\n==              FELICIDADES HAS TERMINADO LA TORRE                ==\n==                                                                				                                           ==\n==================================================", "ATENCI�N: JUEGO TERMINADO",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        null, opciones, opciones[0]);

                minutos = 0;
                segundos = 0;
                horas = 0;
                jugadasRealizadas = 0;
                jLabel5.setText("" + jugadasRealizadas);
                avisos = 0;
                jLabel19.setText("" + avisos);
               
                llenarMatriz();// pone discos
            }
        }
    }

    
    public void Torreh(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
            	new JuegoTorres().setVisible(true);
            }
        });
    }
    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
  
    
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private Image fondo;
    private void configurarPanel1() {
    	ImageIcon fondo = new ImageIcon("dibujos\\torres.png");
    	JLabel fondoD = new JLabel(fondo);
    	fondoD.setSize(900, 620);
    	add(fondoD);
    	
    }
   
}

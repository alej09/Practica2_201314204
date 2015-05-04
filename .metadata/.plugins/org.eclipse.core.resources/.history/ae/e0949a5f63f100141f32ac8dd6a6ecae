package juego;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class NDiscos extends JFrame {
	private JPanel contentPane;
	
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	NDiscos frame = new NDiscos();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public NDiscos() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setBounds(0,0,800,600);
    }
    
    public void paint (Graphics g)
    
    {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect (40, 420, 220, 5);
        g.setColor(Color.black);
        g.fillRect (145, 240, 10, 180);
        g.setColor (Color.red);
        g.fillRoundRect (50, 400, 200, 20, 6, 6);
        g.setColor (Color.blue);
        g.fillRoundRect (60, 380, 180, 20, 6, 6);
        g.setColor (Color.green);
        g.fillRoundRect (70, 360, 160, 20, 6, 6);
        g.setColor (Color.yellow);
        g.fillRoundRect (80, 340, 140, 20, 6, 6);
        g.setColor (Color.magenta);
        g.fillRoundRect (90, 320, 120, 20, 6, 6);
        g.setColor (Color.darkGray);
        g.fillRoundRect (100, 300, 100, 20, 6, 6);
        g.setColor (Color.pink);
        g.fillRoundRect (110, 280, 80, 20, 6, 6);
        g.setColor (Color.cyan);
        g.fillRoundRect (120, 260, 60, 20, 6, 6);
    }

}


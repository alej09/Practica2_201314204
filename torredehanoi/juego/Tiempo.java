package juego;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Tiempo {
	boolean encendido=false;
	int h=0,m=0,s=0,cs=0;
	//String tiempo = (h<=9?"0":"")+h+":"+(m<=9?"0":"")+m+":"+(s<=9?"0":"")+s+":"+(cs<=9?"0":"")+cs;
	
	
	public String correr(JLabel timer,JFrame ven){
		boolean y= true;
		while(y==true){
			
			for(int i =0;i<100;i++){
				try{
					Thread.sleep(10);
					cs++;
					System.out.println(i);
					actualizarLabel(timer,ven);
				}catch(Exception e){
					System.out.println("ERROR");
				}
			}
			
			cs=0;
			s++;
			
			actualizarLabel(timer,ven);
			if(s==60){
				s=0;
				m++;
				actualizarLabel(timer,ven);
			}
			if(m==60){
				h++;
				m=0;
				actualizarLabel(timer,ven);
			}
			//aqui poner condicion para que se pare if algo entonce y=false;
			if(s==5)
				y=false;
		}
		
		
		return null;
	}
	
	
	
	private void actualizarLabel(JLabel label,JFrame v) {
        String tiempo = (h<=9?"0":"")+h+":"+(m<=9?"0":"")+m+":"+(s<=9?"0":"")+s+":"+(cs<=9?"0":"")+cs;
        label.setText(tiempo);
        label.repaint();
    }

	
}

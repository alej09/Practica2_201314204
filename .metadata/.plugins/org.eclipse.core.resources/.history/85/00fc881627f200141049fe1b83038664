package juego;

import javax.swing.JLabel;

public class Movimientos {
	final int r=1;
	public int animacionxR(int xI, JLabel Color, int xF, int y){
		int i=0;
		
		try{
	        for(i=xI;i<xF;i++){
	        	Thread.sleep(r);
	        	Color.setLocation(i, y);
	        }
	        
	        }catch(Exception e){}
		return i;
	}
	
	public int animacionxL(int xI, JLabel Color, int xF, int y){
		int i=0;
		try{
	        for(i=xI;i>xF;i--){
	        	Thread.sleep(r);
	        	Color.setLocation(i, y);
	        }
	        
	        }catch(Exception e){}
		return i;
	}
	
	public int animacionyU(int yI, JLabel Color, int yF, int x){
		int i=0;
		try{
	        for(i=yI;i>yF;i--){
	        	Thread.sleep(r);
	        	Color.setLocation(x, i);
	        }
	        
	        }catch(Exception e){}
		return i;
	}
	
	public int animacionyD(int yI, JLabel Color, int yF, int x){
		int i=0;
		try{
	        for(i=yI;i<yF;i++){
	        	Thread.sleep(r);
	        	Color.setLocation(x, i);
	        }
	        
	        }catch(Exception e){}
		return i;
	}
	

}

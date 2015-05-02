package menu;

		class Torres {
	
        private static int movimientos=0;
        public static int mover(int n, char a,char b, char c)
        {
                if(n>0){
                        mover(n-1, a,c,b);
                        System.out.println("mover disco "+a+" a "+c);
                        movimientos++;
                        mover(n-1,b,a,c);
                }
                return movimientos;
         }
}
	
		public class H
{
 
    public static void main(String[]args){
    	int n=5;
     int movimientos;
     System.out.println("Numero de discos: ");
     
     movimientos = Torres.mover(n, 'A', 'B', 'C');
     System.out.println("\nMovimientos efectuados: "+movimientos);
    }  
    
}
	

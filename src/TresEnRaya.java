import java.util.Scanner;

public class TresEnRaya {

	private int contador;
    private   char posn[]=new char[10];
    private   char player;
    
    public static void main(String args[])
    {
        String ch;
        TresEnRaya Toe=new TresEnRaya();
        do{
            Toe.newBoard();
            Toe.play();
            System.out.println ("Volver a jugar ('si'/'no')? ");
            Scanner in =new Scanner(System.in);
            ch=in.nextLine();
            System.out.println("ch valor es  "+ch);
        }while (ch.equals("si")); //Debe finalizar cuando diga "no".
        
        
    }
    public  void newBoard()
    {
        //Los valores no estaban en orden
        char posndef[] = {'0','1', '2', '3', '4', '5', '6', '7','8', '9'}; 
        int i;
        contador = 0;
        player = 'X';
        for (i=1; i<10; i++) posn[i]=posndef[i];
        tablero();
        
        
    }
    public  String tablero()
    { //Las posiciones estaban mal
        System.out.println( "\n\n" );
        System.out.println(  "\n\n" );
        System.out.println(  "\n\n\t\t" + posn [1] + "   | " +posn [2]+ "  | " +posn [3]);
        System.out.println(  " \t\t    |    |   " );
        System.out.println(  " \t\t ___|____|___ " );
        System.out.println(  "\n\n\t\t" +posn [4]+ "   | " +posn [5]+ "  | " +posn [6]);
        System.out.println(  " \t\t    |    |   " );
        System.out.println(  " \t\t ___|____|___ " );
        System.out.println(  "\n\n\t\t" +posn [7]+ "   | " +posn [8]+ "  | " +posn [9]);
        System.out.println(  " \t\t    |    |   " );
        System.out.println(  " \t\t    |    |   " );
        System.out.println(  "\n\n" );
        return "tablero";
    }
    
    public  void play()
    {
        int spot;
        char blank = ' ';
        
        System.out.println(  "Jugador " + getPlayer() +" va a jugar con ficha 'X'" );
        
        do {
            tablero();              // display current board
            
            System.out.println(  "\n\n Jugador " + getPlayer() +" elije la posicion." );
            
            boolean posTaken = true; //Necesita un true para que funcione no un false
            while (posTaken) {
                Scanner in =new Scanner (System.in);
                spot=in.nextInt();
                posTaken = comprobarPosn(spot);
                if(posTaken==false)
                posn[spot]=getPlayer();
            }
            
            System.out.println(  "Buen movimiento." );
            
            tablero();              // display current board
            
            nextPlayer();
        }while ( comprobarGanador() == blank );
        
    }
    
    public  char comprobarGanador()
    {
        char Winner = ' ';
        
        // Comprobacion sobre X //Los numeros estaban mal
        if (posn[1] == 'X' && posn[2] == 'X' && posn[3] == 'X') Winner = 'X';
        if (posn[4] == 'X' && posn[5] == 'X' && posn[6] == 'X') Winner = 'X';
        if (posn[7] == 'X' && posn[8] == 'X' && posn[9] == 'X') Winner = 'X';
        if (posn[1] == 'X' && posn[4] == 'X' && posn[7] == 'X') Winner = 'X';
        if (posn[2] == 'X' && posn[5] == 'X' && posn[8] == 'X') Winner = 'X';
        if (posn[3] == 'X' && posn[6] == 'X' && posn[9] == 'X') Winner = 'X';
        if (posn[1] == 'X' && posn[5] == 'X' && posn[9] == 'X') Winner = 'X';
        if (posn[3] == 'X' && posn[5] == 'X' && posn[7] == 'X') Winner = 'X';
        if (Winner == 'X' )
        {System.out.println("Jugador 1 ha ganado" );
            return Winner;
        }
        
        // Comprobacion sobre Os
        if (posn[1] == 'O' && posn[2] == 'O' && posn[3] == 'O') Winner = 'O';
        if (posn[4] == 'O' && posn[5] == 'O' && posn[6] == 'O') Winner = 'O';
        if (posn[7] == 'O' && posn[8] == 'O' && posn[9] == 'O') Winner = 'O';
        if (posn[1] == 'O' && posn[4] == 'O' && posn[7] == 'O') Winner = 'O';
        if (posn[2] == 'O' && posn[5] == 'O' && posn[8] == 'O') Winner = 'O';
        if (posn[3] == 'O' && posn[6] == 'O' && posn[9] == 'O') Winner = 'O';
        if (posn[1] == 'O' && posn[5] == 'O' && posn[9] == 'O') Winner = 'O';
        if (posn[3] == 'O' && posn[5] == 'O' && posn[7] == 'O') Winner = 'O';
        if (Winner == 'O' )
        {
            System.out.println( "Jugador 2 ha ganado" );
        return Winner; }
        
        // comprobar empate
        for(int i=1;i<11;i++)
        {
            if(posn[i]=='X' || posn[i]=='O')
            {
                if(i==9)
                {
                    char Draw='D';
                    System.out.println(" Empate ");
                    return Draw;
                }
                continue;
            }
            else
            break;
            
        }
        
        return Winner;
    }
    
    public  boolean comprobarPosn(int spot)
    {
        
        
        if (posn[spot] == 'X' || posn[spot] == 'O') //CAMBIAR && POR ||
        {
            System.out.println("Esa posicion ya se ha elegido, por favor elija otra");
            return true;
        }
        else {
            return false;
        }
        
    }
    
    
    
    public  void nextPlayer()
    { //CAMBIAR X Y O
        if (player == 'X')
        player = 'O';
        else player = 'X';
        
    }
    
    public String getTitle()
    {
        return "Tic Tac Toe" ;
    }
    
    public  char getPlayer()
    {
        return player;
    }
}
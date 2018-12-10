package Practica3;
import java.util.Scanner;

public class EstadoPartida {
	public static void main(String [] args){

		char tablero [] [] = new char [3][3];
		char jugador1 = 'X';
		char jugador2 = 'O';
		boolean  winner = false;
		int tiradas=0;
		int i=0;
	    int j=0;
	    int z = 0;
	    int h =0;
	    int posicion =1;
	 
	 
	     for (i=0;i<3;i++)
	       for (j=0;j<3;j++)
	      tablero[i][j]=' ';
	    System.out.println(tablero[0][0] + " | " + tablero[0][1] + " | " + tablero[0][2] + "\n---------");
	    System.out.println(tablero[1][0] + " | " + tablero[1][1] + " | " + tablero[1][2] + "\n---------");
	    System.out.println(tablero[2][0] + " | " + tablero[2][1] + " | " + tablero[2][2] + "\n");
	 
	     Scanner sn = new Scanner(System.in);
	    do{
	        do{
		        do{
		    	    do{
		    		    do{
		         System.out.print("Jugador 1 selecciona fila: ");
	 
			     i = sn.nextInt();
	 
	 
			     System.out.print("Jugador 1 selecciona columna: ");
	 
			     j = sn.nextInt();
	 
	 
		                 tablero[i][j]=jugador1;
			     System.out.println(tablero[0][0] + " | " + tablero[0][1] + " | " + tablero[0][2] + "\n---------");
			     System.out.println(tablero[1][0] + " | " + tablero[1][1] + " | " + tablero[1][2] + "\n---------");
			     System.out.println(tablero[2][0] + " | " + tablero[2][1] + " | " + tablero[2][2] + "\n");
	 
	 
			     //JUGADOR 2:
	 
		         System.out.print("Jugador 2 selecciona fila: ");
	 
			     z = sn.nextInt();
	 
	 
			     System.out.print("Jugador 2 selecciona columna: ");
	 
			     h = sn.nextInt();
	 
	 
		                 tablero[z][h]=jugador2;
			     System.out.println(tablero[0][0] + " | " + tablero[0][1] + " | " + tablero[0][2] + "\n---------");
			     System.out.println(tablero[1][0] + " | " + tablero[1][1] + " | " + tablero[1][2] + "\n---------");
			     System.out.println(tablero[2][0] + " | " + tablero[2][1] + " | " + tablero[2][2] + "\n");
	 
	 
	            if ((tablero[0][0] == jugador1) && (tablero[0][1] == jugador1) && (tablero[0][2]==jugador1)){
					winner = true;
					System.out.println("¡Jugador 1 gana!");
				}
				if ((tablero[1][0] == jugador1) && (tablero[1][1] == jugador1) && (tablero[1][2]==jugador1)){
					winner = true;
					System.out.println("¡Jugador 1 gana!");
				}
				if ((tablero[2][0] == jugador1) && (tablero[2][1] == jugador1) && (tablero[2][2]==jugador1)){
					winner = true;
					System.out.println("¡Jugador 1 gana!");
				}
				if ((tablero[0][0] == jugador1) && (tablero[1][1] == jugador1) && (tablero[2][2]==jugador1)){
					winner = true;
					System.out.println("¡Jugador 1 gana!");
				}
				if ((tablero[0][2] == jugador1) && (tablero[1][1] == jugador1) && (tablero[2][0]==jugador1)){
					winner = true;
					System.out.println("¡Jugador 1 gana!");
				}
				if ((tablero[0][0] == jugador1) && (tablero[1][0] == jugador1) && (tablero[2][0]==jugador1)){
					winner = true;
					System.out.println("¡Jugador 1 gana!");
				}
				if ((tablero[0][1] == jugador1) && (tablero[1][1] == jugador1) && (tablero[2][1]==jugador1)){
					winner = true;
					System.out.println("¡Jugador 1 gana!");
				}
				if ((tablero[0][2] == jugador1) && (tablero[1][2] == jugador1) && (tablero[2][2]==jugador1)){
					winner = true;
					System.out.println("¡Jugador 1 gana!");
				}
	             }while ((i>0) || (i<2) || (j>0) || (j<2));
	             }while (tablero[i][j]!=' ');
	 
					//JUGADOR 2:
	 
				     if ((tablero[0][0] == jugador2) && (tablero[0][1] == jugador2) && (tablero[0][2]==jugador2)){
							winner = true;
							System.out.println("¡Jugador 2 gana!");
						}
						if ((tablero[1][0] == jugador2) && (tablero[1][1] == jugador2) && (tablero[1][2]==jugador2)){
							winner = true;
							System.out.println("¡Jugador 2 gana!");
						}
						if ((tablero[2][0] == jugador2) && (tablero[2][1] == jugador2) && (tablero[2][2]==jugador2)){
							winner = true;
							System.out.println("¡Jugador 2 gana!");
						}
						if ((tablero[0][0] == jugador2) && (tablero[1][1] == jugador2) && (tablero[2][2]==jugador2)){
							winner = true;
							System.out.println("¡Jugador 2 gana!");
						}
						if ((tablero[0][2] == jugador2) && (tablero[1][1] == jugador2) && (tablero[2][0]==jugador2)){
							winner = true;
							System.out.println("¡Jugador 2 gana!");
						}
						if ((tablero[0][0] == jugador2) && (tablero[1][0] == jugador2) && (tablero[2][0]==jugador2)){
							winner = true;
							System.out.println("¡Jugador 2 gana!");
						}
						if ((tablero[0][1] == jugador2) && (tablero[1][1] == jugador2) && (tablero[2][1]==jugador2)){
							winner = true;
							System.out.println("¡Jugador 2 gana!");
						}
						if ((tablero[0][2] == jugador1) && (tablero[1][2] == jugador1) && (tablero[2][2]==jugador1)){
							winner = true;
							System.out.println("¡Jugador 2 gana!");
				}
	             }while ((z>0) || (z<2) || (h>0) || (h<2));
	             }while (tablero[z][h]!=' ');
			}
		while(tiradas<9 && winner !=true);


	}
}

package interfaz;

import java.util.Scanner;

import dominio.OpcionesSudoku;
import dominio.Sudoku;

public class PruebaSudoku {
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		Sudoku nuevo = null;
		int opcion = 0;
		OpcionesSudoku opcionMenu;

		do {
			mostrarTablero(nuevo);
			mostrarOpciones();
			opcion = seleccionarOpcion(1, 5);
			opcionMenu = seleccionarOpcionMenu(opcion);
			switch(opcionMenu) {
			case INICIAR_NUEVO_JUEGO: nuevo = iniciarNuevoJuego();
				break;
			case INGRESAR_NUMERO: ingresarNumero(nuevo);
				break;
			case SALIR:
				break;
			}
		} while(opcionMenu != OpcionesSudoku.SALIR && !estaCompleto(nuevo));
		

	}
	
	private static Sudoku iniciarNuevoJuego() {
		Sudoku nuevo = new Sudoku();
		return nuevo;
	}
	
	private static void ingresarNumero(Sudoku actual) {
		if(actual!=null) {
			int numero = 0;
			int fila = 0;
			int columna = 0;
			System.out.println("Ingrese el numero entre 1 y 9");
			numero = teclado.nextInt();
			System.out.println("Ingrese la fila");
			fila = teclado.nextInt();
			System.out.println("Ingrese la columna");
			columna = teclado.nextInt();
			if(fila>=0&&fila<=8&&columna>=0&&columna<=8&&actual.ingresarNumero(fila, columna, numero)) {
				System.out.println("Numero ingresado correctamente");
			}else {
				System.out.println("Entrada inválida");
			}
			
		}else {
			System.out.println("No hay juego en progreso");
		}
	}
	
	
	private static int seleccionarOpcion(int min, int max) {
		int opcion = 0;
		do {
			opcion = teclado.nextInt();
		} while(!(opcion>=min && opcion <=max));
		return opcion;
	}
	private static OpcionesSudoku seleccionarOpcionMenu(int opcion) {
		return OpcionesSudoku.values()[opcion-1];
	}
	
	private static void mostrarOpciones() {
		System.out.println("Seleccione la opcion");
		for(int i=0; i<OpcionesSudoku.values().length; i++) {
			System.out.println(i+1 + " - " + OpcionesSudoku.values()[i]);
		}
	}
	
	private static void mostrarTablero(Sudoku actual) {
		if(actual!=null) {
			System.out.println(actual);
		}
	}
	
	private static boolean estaCompleto(Sudoku actual) {
		if(actual==null) {
			return false;
		}else {
			return actual.estaCompleto();
		}
	}

}

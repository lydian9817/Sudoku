package dominio;

public class Sudoku {
	private int tablero[][];
	private final int FILAS = 9;
	private final int COLUMNAS = 9;

	public Sudoku() {
		tablero = new int[FILAS][COLUMNAS];
	}

	public boolean ingresarNumero(int fila, int columna, int numero) {
		boolean resultado = false;
		if (verificarNumero(numero, fila, columna)) {
			tablero[fila][columna] = numero;
			resultado = true;
		}
		return resultado;
	}

	private boolean verificarSiExisteNumeroEnElSubtablero(int numero, int fila, int columna) {
		int columnaInicialDelSubtablero = 0;
		if (columna < 3) {
			// columnaInicialDelSubtablero = 0;
		} else if (columna < 6) {
			columnaInicialDelSubtablero = 3;
		} else {
			columnaInicialDelSubtablero = 6;
		}

		boolean resultado = false;
		for (int i = fila; i < fila + 3; i++) {
			for (int j = columnaInicialDelSubtablero; j < columnaInicialDelSubtablero + 3; j++) {
				if (tablero[i][j] == numero) {
					resultado = true;
				}
			}
		}
		return resultado;
	}

	private boolean verificarNumero(int numero, int fila, int columna) {
		boolean resultado = false;
		if (numero >= 1 && numero <= 9 && !verificarSiExisteNumeroEnElSubtablero(numero, fila, columna)
				&& !buscarPorFila(numero, fila) && !buscarPorColumna(numero, columna)) {

			resultado = true;
		}
		return resultado;
	}

	private boolean buscarPorFila(int numero, int fila) {
		for (int j = 0; j < tablero.length; j++) {
			if (tablero[fila][j] == numero) {
				return true;
			}
		}
		return false;
	}

	private boolean buscarPorColumna(int numero, int columna) {
		for (int i = 0; i < tablero.length; i++) {
			if (tablero[i][columna] == numero) {
				return true;
			}
		}
		return false;
	}

	public boolean estaCompleto() {
		int fila = 0;
		int columna = 0;
		int numero = 0;

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				fila = i;
				columna = j;
				numero = tablero[i][j];
				if (!verificarNumero(numero, fila, columna)) {
					return false;
				}
			}

		}
		return true;
	}
	
	public String toString() {
		String resultado = "";
		for(int i=0; i<tablero.length;i++) {
			for(int j=0; j<tablero[i].length;j++) {
				resultado += tablero[i][j] + " ";
			}
			resultado += "\n";
		}
		
		return resultado;
	}
}

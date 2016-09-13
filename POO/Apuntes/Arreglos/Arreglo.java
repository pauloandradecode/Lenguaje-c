/************************************************************
Clase Arreglo - Metodos para manipular vectores y matrice

Practica: 2
Nombre: Paulo Andrade
Email: source.compu@gmail.com
************************************************************/

public class Arreglo
{
	// Propiedades
	public int renglones; // para matriz 1
	public int renglones2; // para matriz 2
	public int columnas; // para matriz 1
	public int columnas2; // para matriz 2
	public int[] vector;
	public int[][] m1;
	public int[][] m2;
	public int[][] mRes;

	// Constructor
	Arreglo()
	{
		this.renglones = 0;
		this.renglones2 = 0;
		this.columnas = 0;
		this.columnas2 = 0;
	}

	/*****************************************************
	Metodos getter y setter
	*****************************************************/

	// Metodo get para columnas

	// Metodo get para m1
	public int[][] getM1() {
        return m1;
    }
	// Metodo get para m2
	public int[][] getM2() {
        return m2;
    }
	// Metodo get para mRes
	public int[][] getmRes() {
        return mRes;
    }
	// Metodo get para renglones
	public int getRenglones ()
	{
		return renglones;
	}
	// Metodo get para renglones
	public int getRenglones2 ()
	{
		return renglones2;
	}
	// Metodo get para vector
	public int[] getVector() {
        return vector;
    }
    // Metodo set para columnas
    // @param columnas numero de columnas
	public void setColumnas (int columnas)
	{
		this.columnas = columnas;
	}
	// Metodo set para columnas
    // @param columnas numero de columnas
	public void setColumnas2 (int columnas)
	{
		this.columnas2 = columnas;
	}
	// Metodo set para m1
	// @param m1 matriz a asignar
    public void setM1(int[][] m1) {
        this.m1 = m1;
    }
    // Metodo set para m2
    // @param m2 matriz a asignar
    public void setM2(int[][] m2) {
        this.m2 = m2;
    }
    // Metodo set para mRes
    // @param mRes matriz a asignar
    public void setmRes(int[][] mRes) {
        this.mRes = mRes;
    }
    // Metodo set para renglones
    // @param renglones numero de renglones
	public void setRenglones (int renglones)
	{
		this.renglones = renglones;
	}
	// Metodo set para renglones
    // @param renglones numero de renglones
	public void setRenglones2 (int renglones)
	{
		this.renglones2 = renglones;
	}
	// Metodo set para vector
	// @param vector vector a asignar
	public void setVector(int[] vector) {
        this.vector = vector;
    }

    /*****************************************************
	Metodos genericos
	*****************************************************/

	// Metodo que multiplica una matriz
	// Para poder multiplicar dos matrices A de orden m*p y B de orden p*q ha de ocurrir:
	// que el número de columnas de A sea igual al número de filas de B : p
	// además observa que el resultado es otra matriz
	// C = A.B
	// que tiene orden m*q,es decir el número de filas de A y el número de  columnas de B
	public int[][] multiplicarMatriz ()
	{
		int suma = 0;
		int[][] multi = null;

		// Verificamos que las matrices sean cuadradas
		if(this.columnas == this.renglones2){
			// Matrices no cuadradas
			multi  = new int[this.renglones][this.columnas2];

			for(int i = 1; i <= renglones; i++){ // Filas A
				for(int j = 1; j <= columnas2; j++){ // Columna B				
					for(int k = 1; k <= columnas; k++){ 
						// (C[i][j]+(A[i][k]*B[k][j]))
						multi[i - 1][j - 1] += this.m1[i - 1][k - 1] * this.m2[k -1][j - 1];
					}
				}
			}
		}

		return multi;
	}
	// Metodo que obtiene el numero mayor de un vector
	// @param a vector a analizar
	public int numeroMayor (int[] a)
	{
		// Ordenamos de mayor a menor
		int[] x = this.order(a, true);

		// Retornamos el primer valor
		return x[0];
	}
	// Metodo que obtiene el numero menor de un vector
	// @param a vector a analizar
	public int numeroMenor (int[] a)
	{
		// Ordenamos de menor a mayor
		int[] x = this.order(a, false);

		// Retornamos el primer valor
		return x[0];
	}
	// Ordernar elementos del array
	// @param x vector a ordenar
	// @param type Tipo de ordenamiento [false = ascendente, true = descendente]
	private int[] order (int[] x, boolean type)
	{
		int i, j;
		int auxiliar;

		// Verificamos el tipo de orden
		if(type){
			// Orden descendente
			for(i = 0; i < x.length - 1; i++){
            	for(j = i + 1; j < x.length; j++){
                	if(x[i] < x[j]){
	                    //Intercambiamos valores
	                    auxiliar = x[i];
	                    x[i] = x[j];
	                    x[j] = auxiliar;
                	}
            	}
			}
		} else {
			// Orden ascendente
			for(i = 0; i < x.length - 1; i++){
            	for( j = i + 1; j < x.length; j++){
                	if(x[i] > x[j]){
	                    //Intercambiamos valores
	                    auxiliar = x[i];
	                    x[i] = x[j];
	                    x[j] = auxiliar;
                	}
            	}
			}
		}

		return x;
	}
	// Metodo para resta de matrices
	// @param m matriz a restar
	public void restarMatriz (int[][] m)
	{
		int indice = this.m2.length;
		int[][] suma = new int[indice][indice];

		// Sumamos las matrices
		for(int i = 1; i <= indice; i++){
			for(int j = 1; j <= indice; j++){
				suma[i - 1][j - 1] = m[i - 1][j - 1] - this.m2[i - 1][j - 1];
			}
		}

		// Mostramos el resultado
		System.out.println("Resultado: ");

		for(int i = 1; i <= indice; i++){
			System.out.println("");
			for(int j = 1; j <= indice; j++){
				System.out.print(suma[i - 1][j - 1] + " ");
			}
		}

		System.out.println("\n");
	}
	// Metodo que suma matrices
	public void sumarMatriz ()
	{
		int indice = this.m1.length;
		int[][] suma = new int[indice][indice];

		// Sumamos las matrices
		for(int i = 1; i <= indice; i++){
			for(int j = 1; j <= indice; j++){
				suma[i - 1][j - 1] = this.m1[i - 1][j - 1] + this.m2[i - 1][j - 1];
			}
		}

		// Mostramos el resultado
		System.out.println("Resultado: ");

		for(int i = 1; i <= indice; i++){
			System.out.println("");
			for(int j = 1; j <= indice; j++){
				System.out.print(suma[i - 1][j - 1] + " ");
			}
		}

		System.out.println("\n");
	}
}
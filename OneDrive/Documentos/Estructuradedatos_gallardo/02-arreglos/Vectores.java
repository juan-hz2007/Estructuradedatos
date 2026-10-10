package mx.edu.uttt.arreglos.vectores;

public class Vectores {
    private int[] vector;
    private int tamanio;

    // constructor por defecto
    public Vectores(){
        this.vector = new int[2];
        this.tamanio = vector.length;
    }

    // constructor con tamaño personalizado
    public Vectores (int tamanio){
        if (validarTamanio(tamanio)){
            this.vector = new int[tamanio];
        } else {
            this.vector = new int[2];
        }
        this.tamanio = this.vector.length;
    }

    private boolean validarTamanio(int tamanio){
        return tamanio > 0;
    }

    private boolean sonIguales(int [] vector){
        return this.vector.length == vector.length;
    }

    // 1) agregar valor en una posicion
    public void agregarValor(int pos, int valor){
        // valida que la posicion no sea negativa ni se pase del limite del arreglo
        if (pos >= 0 && pos < this.vector.length){
            this.vector[pos] = valor;
        } else {
            System.out.println("Posicion invalida o fuera de rango");
        }
    }

    // 2) llenar vector
    public void llenarVector(int [] vec){
        if (sonIguales(vec)){
            for (int i = 0; i < this.vector.length; i++) {
                this.vector[i] = vec[i];
            }
        } else {
            System.out.println("Los vectores no son del mismo tamaño ");
        }
    }

    // 3) sumar datos
    public int sumarValores(){
        int suma = 0;
        for (int i = 0; i < vector.length; i++) {
            suma = suma + vector[i]; // va acumulando cada numero del vector en la variable suma
        }
        return suma;
    }

    // 4) sumar con otro vector
    public int[] sumarConOtroVector(int[] otroVector){
        if (sonIguales(otroVector)){
            int[] res = new int[this.vector.length];
            for (int i = 0; i < this.vector.length; i++) {
                // suma casilla por casilla de ambos vectores en la misma posicion 'i'
                res[i] = this.vector[i] + otroVector[i];
            }
            return res;
        } else {
            System.out.println("Los vectores no miden lo mismo");
            return null;
        }
    }

    // 5) calcular pares
    public int[] calcularPares(){
        int cont = 0;

        // paso 1: cuento cuantos pares hay primero para saber de que tamaño crear el nuevo arreglo
        for (int i = 0; i < vector.length; i++) {
            // el % saca el residuo de dividir entre 2, si da 0 significa que es par
            if (vector[i] % 2 == 0){
                cont++;
            }
        }

        // le pongo al nuevo arreglo el tamaño exacto del contador de pares
        int[] pares = new int[cont];
        int aux = 0; // aux es el indice para ir llenando el nuevo arreglo de pares desde la casilla 0

        // paso 2: recorro otra vez pero ahora si guardo los pares
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] % 2 == 0){
                pares[aux] = vector[i]; // guardo el numero par en la posicion aux
                aux++; // incremento aux para que el siguiente par se guarde en la casilla de al lado
            }
        }
        return pares;
    }

    // 6) funcion auxiliar para ver si un numero es primo
    private boolean esPrimo(int n){
        if (n <= 1){
            return false; // los menores o iguales a 1 no son primos
        }
        // busca si hay algun numero entre 2 y n-1 que divida exactamente a 'n'
        for (int i = 2; i < n; i++) {
            if (n % i == 0){ // si el residuo da 0, significa que es divisible por otro numero, entonces NO es primo
                return false;
            }
        }
        return true; // si termino el for y no encontro divisores, si es primo
    }

    public int[] calcularPrimos(){
        int cont = 0;
        // paso 1: cuento cuantos primos hay
        for (int i = 0; i < vector.length; i++) {
            if (esPrimo(vector[i])){
                cont++;
            }
        }

        // creo el arreglo con el tamaño justo de primos encontrados
        int[] primos = new int[cont];
        int j = 0; // indice auxiliar para el arreglo primos

        // paso 2: guardo los primos en el arreglo
        for (int i = 0; i < vector.length; i++) {
            if (esPrimo(vector[i])){
                primos[j] = vector[i];
                j++;
            }
        }
        return primos;
    }

    // 7) promedio
    public double calcularPromedio(){
        // divide la suma de elementos entre la cantidad total de casillas
        return sumarValores() / vector.length;
    }

    // 8) valor mayor
    public int obtenerMayor(){
        int mayor = vector[0]; // supongo que el primer numero es el mayor
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] > mayor){ // si encuentro un numero mas grande que mi mayor actua´{
                mayor = vector[i];  // actualizo la variable mayor con ese nuevo numero
            }
        }
        return mayor;
    }

    // 9) valor menor
    public int obtenerMenor(){
        int menor = vector[0]; // supongo que el primer numero es el menor
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] < menor){ // si encuentro un numero mas pequeño que mi menor actual
                menor = vector[i];  // actualizo la variable menor
            }
        }
        return menor;
    }

    // 10) buscar elemento
    public String buscarElemento(int dato){
        // busqueda secuencialva revisando casilla por casilla desde la posicion 0
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == dato){
                // si lo encuentra, regresa el dato y la posicion 'i' donde lo halló
                return "Dato: " + dato + " en la posicion: " + i;
            }
        }
        // si termina el for y no retornado nada, es porque no estaba el numero
        return "No se encontro el dato " + dato;
    }

    public int obtenerTamanio(){
        return this.tamanio;
    }

    public String imprimir(){
        String salida = "";
        for (int val: this.vector){
            salida += val + " ";
        }
        return salida;
    }
}
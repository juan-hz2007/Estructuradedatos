package mx.edu.uttt.arreglos.vectores;

public class VectorEntero {
    //Variables de instancia

    private int [] vector;

    public VectorEntero(){
        vector = new int[2];
    }

    public VectorEntero(int tamanio){
       if(validarTamanio(tamanio)){
           vector = new int[tamanio];
       }else {
           vector = new int[2];
       }
    }
    private boolean validarTamanio (int tamanio){
        return tamanio  > 1;
    }

    public int obtenerTamanio(){
        return vector.length;
    }

    public int[] obtenerVector(){

        return vector;
    }

    private int [] copiarVector(int v){
        int [] copiaVector = new int [this.obtenerTamanio()];
        int i=0;
        for (int valor: vector){
            copiaVector[i] = valor;
            i++;
        }
        return copiaVector;
    }
}
//ejercicio1
package mx.edu.uttt.matrices;

public class SalaTeatro {
    
    private int[][] matrizAsientos;
    private int filas;
    private int columnas;

   
    public SalaTeatro() {
        this.filas = 3;
        this.columnas = 3;
    
        this.matrizAsientos = new int[3][3];
    }

   
    public SalaTeatro(int filas, int columnas) {
        if (validarDimensiones(filas, columnas)) {
            this.filas = filas;
            this.columnas = columnas;
            this.matrizAsientos = new int[filas][columnas];
        } else {
            System.out.println("Dimensiones inválidas. Se creará una sala de 3x3 por defecto.");
            this.filas = 3;
            this.columnas = 3;
            this.matrizAsientos = new int[3][3];
        }
    }

    
    private boolean validarDimensiones(int filas, int columnas) {
        return filas > 0 && columnas > 0;
    }

    
    private boolean validarCoordenadas(int fila, int columna) {
        return (fila >= 0 && fila < this.filas) && (columna >= 0 && columna < this.columnas);
    }

    // =========================================================================
    // EJERCICIO 1: Método para reservar asientos
    // =========================================================================
    public boolean reservarAsiento(int fila, int columna) {
        
        if (!validarCoordenadas(fila, columna)) {
            System.out.println("❌ Error: Las coordenadas [" + fila + "][" + columna + "] exceden los límites de la sala.");
            return false;
        }

       
        if (this.matrizAsientos[fila][columna] == 0) {
            this.matrizAsientos[fila][columna] = 1; 
            System.out.println("✅ ¡Éxito! El asiento [" + fila + "][" + columna + "] ha sido reservado correctamente.");
            return true;
        } else {
            System.out.println("⚠️ Notificación: El asiento [" + fila + "][" + columna + "] ya se encuentra OCUPADO.");
            return false;
        }
    }

   
    public void mostrarMapaAsientos() {
        System.out.println("\n--- MAPA DE ASIENTOS (0: Libre | 1: Ocupado) ---");
        
       
        for (int i = 0; i < this.filas; i++) {
            System.out.print("Fila " + i + ": [ ");
            for (int j = 0; j < this.columnas; j++) {
                System.out.print(this.matrizAsientos[i][j] + " ");
            }
            System.out.println("]");
        }
    }
}

//ejercicio2
public class ControlVentas {
 
    private int[][] ventas;
    private int numSucursales;
    private int numMeses;

   
    public ControlVentas(int numSucursales, int numMeses) {
        if (validarDimensiones(numSucursales, numMeses)) {
            this.numSucursales = numSucursales;
            this.numMeses = numMeses;
            this.ventas = new int[numSucursales][numMeses];
        } else {
            System.out.println("Dimensiones inválidas. Se creará una matriz de 2x2 por defecto.");
            this.numSucursales = 2;
            this.numMeses = 2;
            this.ventas = new int[2][2];
        }
    }


    private boolean validarDimensiones(int m, int n) {
        return m > 0 && n > 0;
    }

    public void cargarVentas(int[][] matrizVentas) {
        if (matrizVentas.length == this.numSucursales && matrizVentas[0].length == this.numMeses) {
            this.ventas = matrizVentas;
        } else {
            System.out.println("Error: Las dimensiones de la matriz ingresada no coinciden.");
        }
    }

    // =========================================================================
    // 1. Método para calcular la suma por cada fila (Total por Sucursal)
    // =========================================================================
    public int[] calcularTotalPorSucursal() {
        int[] totalesSucursal = new int[this.numSucursales];

        for (int i = 0; i < this.numSucursales; i++) {
            int sumaFila = 0;
            for (int j = 0; j < this.numMeses; j++) {
                sumaFila += this.ventas[i][j];
            }
            totalesSucursal[i] = sumaFila;
        }

        return totalesSucursal; 
    }

    // =========================================================================
    // 2. Método para calcular la suma por cada columna (Total por Mes)
    // =========================================================================
    public int[] calcularTotalPorMes() {
        int[] totalesMes = new int[this.numMeses];

       
        for (int j = 0; j < this.numMeses; j++) {
            int sumaColumna = 0;
            for (int i = 0; i < this.numSucursales; i++) {
                sumaColumna += this.ventas[i][j];
            }
            totalesMes[j] = sumaColumna;
        }

        return totalesMes; 
    }

    // =========================================================================
    // 3. Método para generar un reporte formateado que integra todo
    // =========================================================================
    public void generarReporte() {
        int[] totalSucursales = calcularTotalPorSucursal();
        int[] totalMeses = calcularTotalPorMes();
        int granTotal = 0;

        System.out.println("============================================================================");
        System.out.println("                 REPORTE DE VENTAS POR SUCURSAL Y MES                       ");
        System.out.println("============================================================================");

       
        System.out.printf("%-15s", "Sucursal");
        for (int j = 0; j < this.numMeses; j++) {
            System.out.printf("%-12s", "Mes " + (j + 1));
        }
        System.out.printf("%-15s\n", "| TOTAL SUCURSAL");
        System.out.println("----------------------------------------------------------------------------");

      
        for (int i = 0; i < this.numSucursales; i++) {
            System.out.printf("%-15s", "Sucursal " + (i + 1));
            for (int j = 0; j < this.numMeses; j++) {
                System.out.printf("%-12d", this.ventas[i][j]);
            }
            System.out.printf("| $%-14d\n", totalSucursales[i]);
            granTotal += totalSucursales[i];
        }

        System.out.println("----------------------------------------------------------------------------");

        System.out.printf("%-15s", "TOTAL MES");
        for (int j = 0; j < this.numMeses; j++) {
            System.out.printf("$%-11d", totalMeses[j]);
        }
        System.out.printf("| $%-14d\n", granTotal);
        System.out.println("============================================================================");
    }
}

//ejercicio3
public class AnalizadorMatriz {
   
    private int[][] matriz;
    private int filas;
    private int columnas;

   
    public AnalizadorMatriz(int filas, int columnas) {
        if (filas > 0 && columnas > 0) {
            this.filas = filas;
            this.columnas = columnas;
            this.matriz = new int[filas][columnas];
        } else {
            System.out.println("Dimensiones inválidas. Se creará una matriz de 2x2 por defecto.");
            this.filas = 2;
            this.columnas = 2;
            this.matriz = new int[2][2];
        }
    }

   
    public void cargarMatriz(int[][] datos) {
        if (datos.length == this.filas && datos[0].length == this.columnas) {
            this.matriz = datos;
        } else {
            System.out.println("Error: Las dimensiones de los datos no coinciden con la matriz asignada.");
        }
    }

    // =========================================================================
    // 1. Validación Previa: Comprobar si la matriz es cuadrada
    // =========================================================================
    public boolean esCuadrada() {
        return this.filas == this.columnas;
    }

    // =========================================================================
    // 2. Método para evaluar si es una Matriz Identidad
    // =========================================================================
    public boolean esMatrizIdentidad() {
       
        if (!esCuadrada()) {
            System.out.println("🚨 MENSAGE DE EMERGENCIA: La matriz no es cuadrada (" 
                               + this.filas + "x" + this.columnas 
                               + "). Operación cancelada.");
            return false;
        }

      
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                
                if (i == j) {
                    if (this.matriz[i][j] != 1) {
                        return false;
                    }
                } 
               
                else {
                    if (this.matriz[i][j] != 0) {
                        return false;
                    }
                }
            }
        }

        return true; 
    }

    // =========================================================================
    // 3. Método para calcular e imprimir la suma de la diagonal principal
    // =========================================================================
    public int calcularSumaDiagonalPrincipal() {
        
        if (!esCuadrada()) {
            System.out.println("🚨 MENSAGE DE EMERGENCIA: La matriz no es cuadrada (" 
                               + this.filas + "x" + this.columnas 
                               + "). No existe diagonal principal.");
            return -1;
        }

        int suma = 0;
        for (int i = 0; i < this.filas; i++) {
            suma += this.matriz[i][i];
        }

        return suma;
    }

    public void mostrarMatriz() {
        System.out.println("\n--- CONTENIDO DE LA MATRIZ ---");
        for (int i = 0; i < this.filas; i++) {
            System.out.print("[ ");
            for (int j = 0; j < this.columnas; j++) {
                System.out.print(this.matriz[i][j] + " ");
            }
            System.out.println("]");
        }
    }
}

//ejercicio4

public class Matriz {
    
    private int[][] matriz;
    private int filas;     // m
    private int columnas;  // n

    
    public Matriz(int filas, int columnas) {
        if (filas > 0 && columnas > 0) {
            this.filas = filas;
            this.columnas = columnas;
            this.matriz = new int[filas][columnas];
        } else {
            System.out.println("Dimensiones inválidas. Se creará una matriz de 2x2 por defecto.");
            this.filas = 2;
            this.columnas = 2;
            this.matriz = new int[2][2];
        }
    }

   
    public int getFilas() {
        return this.filas;
    }

    public int getColumnas() {
        return this.columnas;
    }

   
    public void cargarMatriz(int[][] datos) {
        if (datos.length == this.filas && datos[0].length == this.columnas) {
            this.matriz = datos;
        } else {
            System.out.println("Error: Las dimensiones de los datos no coinciden.");
        }
    }

    // =========================================================================
    // EJERCICIO 4: Transposición Dinámica de Matriz (m x n -> n x m)
    // =========================================================================
    public Matriz obtenerTranspuesta() {
    
        Matriz transpuesta = new Matriz(this.columnas, this.filas);

        
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                
                transpuesta.matriz[j][i] = this.matriz[i][j];
            }
        }

        
        return transpuesta;
    }

    
    public void mostrarMatriz(String titulo) {
        System.out.println("\n--- " + titulo + " (" + this.filas + "x" + this.columnas + ") ---");
        for (int i = 0; i < this.filas; i++) {
            System.out.print("[ ");
            for (int j = 0; j < this.columnas; j++) {
                System.out.print(this.matriz[i][j] + " ");
            }
            System.out.println("]");
        }
    }
}


//ejercicio5
    public boolean esCuadrada() {
        return this.filas == this.columnas;
    }

    public Matriz rotar90GradosHorario() {
      
        if (!esCuadrada()) {
            System.out.println("🚨 ERROR CRÍTICO: La matriz no es cuadrada (" 
                               + this.filas + "x" + this.columnas 
                               + "). No se puede rotar.");
            return null;
        }

        int n = this.filas; 
        
        
        Matriz matrizRotada = new Matriz(n, n);

  
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               
                matrizRotada.matriz[j][n - 1 - i] = this.matriz[i][j];
            }
        }

       
        return matrizRotada;
    }
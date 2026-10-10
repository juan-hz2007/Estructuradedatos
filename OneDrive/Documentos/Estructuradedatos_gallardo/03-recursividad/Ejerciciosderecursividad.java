// Método recursivo para sumar números de 1 a n
    public int sumarRecursivo(int n) {
        if (n <= 1) {
            return n;
        }
        return n + sumarRecursivo(n - 1);
    }

    // Método recursivo para calcular el factorial de n
    public int factorialRecursivo(int n) {
        if (n < 0) {
            System.out.println("El factorial no está definido para números negativos.");
            return -1;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorialRecursivo(n - 1);
    }

    // Método recursivo para multiplicar a * b mediante sumas
    public int multiplicarRecursivo(int a, int b) {
        if (b == 0 || a == 0) {
            return 0;
        }
        if (b == 1) {
            return a;
        }
        return a + multiplicarRecursivo(a, b - 1);
    }

    // Método recursivo para calcular la potencia a^b mediante multiplicaciones
    public int potenciaRecursiva(int base, int exponente) {
        if (exponente < 0) {
            System.out.println("Este método solo soporta exponentes enteros no negativos.");
            return -1;
        }
        if (exponente == 0) {
            return 1;
        }
        return base * potenciaRecursiva(base, exponente - 1);
    }
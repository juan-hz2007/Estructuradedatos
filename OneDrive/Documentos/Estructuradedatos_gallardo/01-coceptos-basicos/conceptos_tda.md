# Tipos de Datos Abstractos

La idea central *es que no se memorice TDA como una definición.

La secuencia para entenderlo:

**problema=>datos=>operaciones=>reglas=>abstracción=>TDA=>Implementación=>Clase Java=>Estructura de Datos**

para despues entrar a lo que es una *pila, cola, lista y arboles*

1. Problema:

> Supongamos que tenemos un sistema escolar y queremos manejar estudiantes.

Cada estudiante:

* matricula,
* nombre,
* carrera,
* promedio

Hasta ahora estamos de **datos**

Pero el programa no solamente necesita almacenar esos datos. También necesita hacer cosas con ellos:

* registrar un cliente
* consultar sus datos
* cambiar su promedio
* verificar si está aprobado
* mostrar información

Entonces aparece una idea importante:

En programación no solamente importa **que datos tenemos**, si no también **qué operaciones podemos realizar sobre esos datos**

Nota: Este el primer paso hacia un TDA.

2. Dato simple vs algo más complejo

Ya conocemos:

```
int edad;
double promedio;
String nombre;
```

Estos tipos de datos ya los conoce Java.

`int edad = 20;`

Java sabe:

* qué tipo de valor puede almacenar
* cuánto espacio requiere,
* qué operaciones se pueden realizar

con un int:

```
edad + 1
edad - 1
edad > 18
edad++
++edad
```

Pero si pensamos en:

`Estudiante`

Java originalmente no tiene un tipo llamado **Estudiante**

Necesitamos construirlo

Aquí comienza a aparecer la idea de **crear nuestros propios tipos de datos**

3. ¿Qué sería un tipo de dato ?

Se puede definir inicializmente así:

> Un tipo de dato define qué valores pueden existir y que operaciones pueden realizarse con esos valores

Por ejemplo:

*int* valores posibles:

-10 0 5 100 2500

operaciones: Aritméticas y Relaciones

**boolean** Valores:

```
true
false
```

Operaciones:
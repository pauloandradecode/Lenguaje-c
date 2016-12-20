Fundamentos de programación
===========================

# Práctica de programación estructurada en lenguaje C – regularización

Analice cuidadosamente los siguientes problemas y elabore una solución antes de escribir el programa correspondiente.

## Programa de regularización [racionales].

Debera definir (uso de typedef) un nuevo tipo de dato (un struct) para el almacenamiento de numeros racionales. Un numero racional se define de la siguiente manera.-

Un numero X se llama racional si es el cociente de dos numeros enteros. Es decir, si X = p/q, en donde p y q son numeros enteros, y q es distinto de 0. el numero p es llamado el numerador de X, mientras que q es llamado denominador.

### Lectura de numeros racionales.

Deberá escribir una función de nombre 'leer' que lea un numero racional como dos enteros separados con el carácter dos puntos (:). Por ejemplo 5:2. Esta función deberá retornar como resultado un número racional en donde el primer entero es el numerador y el segundo entero es el denominador. Por ejemplo, si se lee 5:2 entonces se deberá generar y retornar el racional 5/2. El prototipo de esta función es el siguiente

```c
racional lee();
```

### Operaciones.

Enseguida se muestran las operaciones que deberán implimentarse. Cada una de estas recibe dos números racionales y retorna otro número racional como resultado.-

```c
// Prototipo para suma
racional suma(racional x, racional y);

// Prototipo para resta
racional resta(racional x, racional y);

// Prototipo para multiplicación
racional multiplica(racional x, racional y);

// Prototipo para división
racional divide(racional x, racional y);
```

### Impresión de racionales.

Deberá imprimir una función de nombre 'imprime' que muestre en pantalla un numero racional (x) en el formato [a:b], en donde a es el numerador y b es el denominador. Por ejemplo si X = 5/4, entonces su programa deberá imprimir a X como [5:4]. El prototipado de esta función es el siguiente.-

```c
void imprmime(racional x);
```

### Definición del problema.

Su programa deberá declarar tres números racionales X, Y y Z. Deberá leer (con la función lee) a X y a Y. Deberá utilizar a Z para almacenar cada una de las cuatro operaciones (suma, resta, multiplicación y división, una a la vez) e imprimir el resultado en pantalla (función imprime).

### A evaluar

* El uso correcto de las variables tipo racional para guardar sus datos.
* Le escritura correcta de las funciones.
* El uso correcto de las funciones para leer, calcular (y retornar) e imprimir sus resultados.
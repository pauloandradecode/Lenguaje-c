Fundamentos de programación
===========================

# Prácticas de programación estructurada en lenguaje C – Parte 2

Analice cuidadosamente los siguientes problemas y elabore una solución antes de escribir el programa correspondiente.

## Programa 1. [order]

Escribir un programa que lea dos números enteros separados por comas. Hacer que el programa imprima ambos números de mayor a menor. Use el operador condicional (?:) para hacer su selección. Por ejemplo, si se lee la entrada 123,315 entonces debería mostrarse un resultado similar al siguiente:

```c
Mayor: 315
Menor: 123
```

## Programa 2. [swap]

Escribir un programa que lea dos variables enteras separadas por comas e intercambie su valor. Su programa deberá imprimir ambas variables en el mismo orden que fueron leídas para mostrar el resultado. Por ejemplo, si le lee la entrada 123,315 para las variables x e y, respectivamente, entonces el programa deberá mostrar un resultado similar al siguiente:

```c
x: 315
y: 123
```

## Programa 3. [times]

Escribir un programa que lea dos números enteros entre 0 y 999 separados por comas. Hacer que imprima el producto de ambos números en forma posicional. Por ejemplo, suponga que se proporciona la entrada 123,315 entonces el programa debería generar la siguiente salida:

```c
  123
* 315
------
   615
  123
 369
------
38745
```

## Programa 4 [sel]

Un sistema de ecuaciones lineales de la forma:

```c
ax + by = c
dx + ey = f
```

tiene la siguiente solución:

```c
    ce - ef              af - cd
x = -------          y = -------
    ae - bd              ae - bd
```

Escriba un programa que lea los coeficientes del sistema (a, b y c en una lectura, separadas por comas, y d, e y f en otra lectura, también separadas por comas) y calcule e imprima los valores de X e Y con una precisión de dos decimales. Por ejemplo, si se leen las entradas 1,2,3 y 4,5,6 entonces deberá mostrarse un resultado similar al siguiente:

```c
Resultado de x: 5.00
Resultado de y: 2.00
```

## Programa 5 [convert]

Escribir un programa que lea un número de pies, e imprima su equivalente en yardas, pulgadas, centímetros y metros. Un pie equivale a 12 pulgadas, una yarda equivale a 3 pies, una pulgada equivale a 2.54 centímetros y un metro equivale a 100 centímetros. Use una precisión de 4 decimales. Por ejemplo, si se leen 10 pies, entonces debería mostrarse una salida similar a la siguiente:

```c
10.0000 pie(s) equivale a:
    3.3333 yardas
  120.0000 pulgadas
  304.8000 centímetros
    3.0480 metros
```

## Programa 6 [pascua]

La fecha del domingo de Pascua corresponde al primer domingo después de la primera luna llena que sigue al equinoccio de primavera. Esta fecha se determina de la siguiente manera:

```c
A = x mod 19
B = x mod 4
C = x mod 7
D = (19A + 24) mod 30
E = (2B + 4C + 6D + 5)mod 7
n = 22 + D + E
```

en donde n indica el número del día del mes de marzo (ó n − 31 el día de abril, si n > 31) correspondiente al domingo de Pascua del año x. Escriba un programa que determine e imprima esta fecha para algún año que se proporcione. Por ejemplo, para el año 2010 su programa deberá imprimir algo similar a lo siguiente:

```c
En 2010, el domingo de Pascua es el día 4 de abril.
```

Use el operador condicional (?:) para seleccionar el resultado adecuado para el día y el mes.
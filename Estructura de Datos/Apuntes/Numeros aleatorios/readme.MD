Numeros aleatorios
==================

La generación de numeros aleatorios sigue un curso al azhar, sin nada definido, sin dirección, regla o método (lo que puede ser controlado). Es algo que no es arbitrario (no depende de la voluntad).

Se utilizan para varios propositos.-

* Generación de llaves para encriptación.
* Modelado y simulación.
* selección de datos de ejemplo.

En conclusión un número se considera aleatorio, si cada número es estadisticamente independiente del resto.

# contenido

## Números decimales [programa]

En este programa mostramos una tecnica para generar números decimales grandes sin que estos se desborden. (con una presición mayor a 15 decimales).

## Numeros_largos [programa]

En este programa se muestra una tecnica para generar números bastante grandes que si son generados de forma normal en C/C++ (long unsigned) estos pueden desbordar la memoria.

## Pseudoaleatorios [programa]

En este programa se muestra como generar números pseudo aleatorios en C/C++ mediante la función rand() perteneciente a la libreria cstdlib, para generarlos se utiliza una semilla (seed) que genera siempre la misma secuencia.

Pero si lo combinamos con la función srand() a la cual le pasamos un valor por parametro (por ejemplo la hora en milisegundos) podemos generar secuencias de números diferentes cada ves que los necesitemos.

## Errores y aclaraciones sobre el código

Si encuentras algun error en el código o la forma de optimizarlo puedes informarme en el siguiente enlace para realizar las correcciones correspondientes.-

<a href="https://github.com/nemesis866/Lenguaje-c/issues">https://github.com/nemesis866/lenguaje-c/issues</a>
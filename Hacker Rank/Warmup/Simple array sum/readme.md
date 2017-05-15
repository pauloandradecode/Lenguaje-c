Simple array sum
===

Dado un array de n elementos, puedes encontrar la suma de estos elementos?.

# Contenido

Para resolver el problema utilizamos la libreria vector, la cual nos provee de muchas funcionalidades para manipular el array.

## Libreria vector

Nos permite crear arrays de secuencia de datos con tamaños dinamicos, para utilizarla debemos crear la libreria vector.-

```c++
#include <vector>

using namespace std;
```

Inicializamos un array.-

```c++
// Creamos un array con 4 elementos
vector<int> v = { 1, 3, 5, 7 };

// Creamos un array con n elementos
vector<int> v[n];

// Añadimos un dato al final del array
v.push(3);
```

### Métodos de utileria

#### front y back

Nos permite acceder al primer y ultimo elemento del array respectivamente.-

```c++
// Creamos un array con 4 elementos
vector<int> v = { 1, 3, 5, 7 };

// Obtenemos el primer elemento
printf("%i", v.front()); // 1

// Obtenemos el ultimo elemento
printf("%i", v.back()); // 7
```

#### size, capacity y empty

Nos permite obtener el tamaño, la capacidada y si saber si esta vacio el array respectivamente.-

```c++
// Creamos un array con 4 elementos
vector<int> v = { 1, 3, 5, 7 };

// Obtenemos el tamaño
printf("%i", v.size()); // 4

// Obtenemos la capacidad
printf("%i", v.capacity()); // 4

// Verificamos si esta vacio
if(v.empty()) printf("vacio");
else printf("No vacio");
```

#### clear, erase, pop_back, insert y push_back

Limpia el array completo, elimina un elemento del array, elimina el ultimo elemento del array, inserta un elemento al array en la posición dada e inserta un elemento al final del array;

```c++
// Creamos un array con 4 elementos
vector<int> v = { 1, 3, 5, 7 };

// Insertamos un elemento
v.insert(v.begin() + 2, 4); // 1 3 4 5 7

// Eliminamos un elemento
v.erase(v.begin() + 3); // 1 3 5 7

// Eliminamos el ultimo elemento
v.pop_back(); // 1 3 5

// Limpiamos el array
v.clear(); // -
```
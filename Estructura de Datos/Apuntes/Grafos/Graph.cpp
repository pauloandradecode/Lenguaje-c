/*
Name: Paulo Cesar Andrade
Fecha: 17/05/2017
Notas: Implementación de grafos
*/

#include <cstdio>
#include "Graph.hpp"
#include "Stack.hpp"
#include "Queue.hpp"
#include "Set.hpp"

/*********************************************
Implementación elementos estaticos
*********************************************/

bool Graph::_x = false;

/*********************************************
Implementación clase Graph
*********************************************/

// Constructor
Graph::Graph(int n): _n(n)
{
    // Obtenemos la maxima cantidad de aristas
    _m_max = _n * (_n - 1) / 2;

    // _v = new bool[_n = n];
    _v = new bool[_m_max]; // creamos el array caracteristico

    // llenamos el array
    for(int i = 0; i < _m_max; i++) _v[i] = 0;
}

// Destructor
Graph::~Graph()
{
    delete _v; // Eliminamos array caracteristico
}

// Funcion caracteristica
// Obtenemos el indice del array para acceder a el
int Graph::_f(int u, int v)
{
    // Verificamos
    if(u == v) return 0; // No existe el vertice
    if(v > _n) return 0;
    if(u < v){
        // Intercambiamos ya que el vertice se encuentra en la triangular superior
        int aux = u;
        u = v;
        v = aux;
    }

    // Obtenemos el vertice
    return ((u - 1) * (u - 2)) / 2 + (v - 1);
}

// Regresa un valor almacenado en al array caracteristico
// Se le conoce como asignacion de funciones
bool &Graph::edge(int i, int j)
{
    // Validamos i , j
    if(i < 1 || i > _n || j < 1 || j > _n || i == j){
        // mensaje de error
        // printf("[Graph]: bad index\n");

        // Retornamos una referencia (obligatoria)
        return _x; // Retornamos un variable de contencion
    }

    // Retornamos la variable, por eso podemos asignar valores cuando la retornamos
    return _v[_f(i, j)]; // Retornamos la referencia a la variable
}

// Imprimimos un grafo (función amiga)
void print(Graph &g)
{
    for(int i = 2; i <= g._n; i++){ // Corremos de 2 hasta n
        for(int j = 1; j < i; j++){ // corremos de 1 hasta (i - 1)
            // printf("[%i:%i] %i\n", i, j, g._v[g._f(i, j)]);
            if(j == 1) printf("[%2i] %3i ", i, g.edge(i, j)); // Imprimimos el valor
            else printf("%3i ", g.edge(i, j));
        }
        puts("");
    }

    // Imprimimos los indices J
    for(int k = 1; k < g._n; k++){
        if(k == 1) printf("     [%2i]", k);
        else printf("[%2i]", k);
    }
}

// Obtenemos la vecindad
int Graph::vecindad(Set M, int x)
{
    // Buscamos la vecindad del nodo
    for(int i = 1; i <= _n; i++){
        // si existe agregamos el nodo al conjunto
        if(_v[_f(i, x)] == 1 && !M.find(i)) return i;
    }

    return 0;
}

// Busqueda en profundidad
Stack Graph::DFS(int source, int target)
{
    Set M; // Conjunto de marcado
    Stack s(_n); // Pila

    s.push(source); // Insertamos el primer elemento a la pila

    // Mientras la pila no este vacia corremos
    while(!s.empty()){
        int u = s.top(); // Obtenemos el primer elemento de la pila
        M.insert(u); // Marcamos el vertice u
        int v = vecindad(M, u);

        if(v != 0 && !M.find(v)){ // Verificamos si v no esta marcado
            s.push(v); // Agregamos v a la pila
            if(v == target) return s; // Si v es el objetivo retornamos la cola
        } else s.pop(); // Eliminamos
    }

    return s; // Retornamos la pila
}

// Busqueda en amplitud
bool Graph::BFS(int source, int target)
{
    Set M; // Conjunto de marcado
    Queue q(_n); // Pila

    q.enqueue(source); // Insertamos el inicio
    M.insert(source); // Marcamos el primer elemento

    // Mientras la pila no este vacia corremos
    while(!q.empty()){
        int u = q.dequeue(); // Obtenemos el primer elemento de la pila
        for(int v = vecindad(M, u); v != 0 && !M.find(v); v = vecindad(M, u)){ // Obtenemos la vecindad
            if(v == target) return true; // Si v es el objetivo retornamos true
            q.enqueue(v); // Insertamos el vertice
            M.insert(v); // Marcamos el vertice
        }
    }

    return false;
}

// Camino mas corto
Stack Graph::SP(int source, int target)
{
    Set M; // Conjunto de marcado
    Queue q(_n); // Creamos cola

    q.enqueue(source); // Insertamos el primer vertice
    M.insert(source); // Marcamos el vertice
    Graph E(_m_max); // Conjunto de vertices nuevo

    // Mientras la cola no esta vacia corremos
    while(!q.empty()){
        int u = q.dequeue(); // Obtenemos el primer elemento de la cola
        for(int v = vecindad(M, u); v != 0 && !M.find(v); v = vecindad(M, u)){ // Obtenemos la vecindad
            E.edge(u, v) = true; // Insertamos al conjunto UV
            if(v == target) return E.DFS(source, target); // Si el vertice es igual al buscado, retornamos busqueda a profundidad
            q.enqueue(v); // Insertamos el vertice
            M.insert(v); // Marcamos el vetice
        }
    }

    return E.DFS(source, target);
}

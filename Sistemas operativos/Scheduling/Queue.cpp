/*
Fecha: 03/04/2017
Integrantes:
    Andrade Gonzlez Paulo Cesar
    Lazo Godinez Maria Ines
    Lopez Gacia Romina Arantxa
    Sanchez Gutierrez Alejandra Amaranta
Nota: Implementacion de colas con estructuras dinamicas
*/

#include <cstdio>
#include "Queue.hpp"

/***********************************************
Clase Node
***********************************************/

// Constructor
// @param x ID del proceso
// @param y Tiempo del proceso
// @param z Prioridad del proceso
Queue::Node::Node(char x, int y, int z): _id(x), _time(y), _priority(z) {
    _next = NULL;
}; // El apuntador siguiente siempre apunta a NULL

// Pedimos la informacion del objeto
// Se utiliza const por que no podemos modificar el objeto
// Nos devuelve el Id del proceso
char Queue::Node::id() const {
    return _id;
}

// Nos devuelve el tiempo de proceso
int Queue::Node::time() const {
    return _time;
}

// Nos devuelve la prioridad del proceso
int Queue::Node::priority() const {
    return _priority;
}

// cambiamos el tiempo del proceso
void Queue::Node::settime(int x)
{
    _time = x;
}

// cambiamos la prioridad del proceso
void Queue::Node::setpriority(int x)
{
    _priority = x;
}

Queue::Node *Queue::Node::next() const
{
    return _next;
} // Nos devuelve el siguiente nodo (si no existe retorna NULL)

// Metodo que permite modificar el apuntador
// Asigno y me retorna el nuevo nodo
Queue::Node *Queue::Node::next(Queue::Node *p)
{
    return _next = p;
}

/***********************************************
Clase Queue
***********************************************/

// Constructor
Queue::Queue(int n): start(NULL), eoq(NULL), _n(n), _s(0) {}
// Destructor
Queue::~Queue() {
    delete start;
    delete eoq;
}

// Metodos para colas

// Metodo para insertar nodos al final de la cola
// @param x ID del proceso
// @param y Tiempo del proceso
// @param z Prioridad del proceso
void Queue::enqueue(char x, int y, int z)
{
    // precondicion
    if(!full()){
        if(empty()){
            // Creamos la cola
            start = eoq = new Node(x, y, z);
        } else {
            // Agregamos un nuevo nodo a la cola
            eoq->next(new Node(x, y, z));
            eoq = eoq->next();
        }

        // Incremento tamaño
        _s++;
    } else {
        // Mostramos el mensaje en caso de que la cola este llena
        printf("Cola llena \n");
    }
}

// Devolvemos el valor almacenado y eliminamos el nodo
int Queue::dequeue()
{
    // Precondicion
    if(!empty()){
        Node *aux = start;
        // Respaldamos el dato
        int time = start->time();
        // Apuntamos al siguiente nodo
        start = start->next();
        // Eliminamos el auxiliar
        delete aux;
        // Decrementamos el tamaño
        _s--;

        // Regresamos el dato
        return time;
    }

    // Imprime un mensaje si la cola esta vacia
    printf("Cola vacia\n");
    return 0;
}

// Obtenemos un dato del primer nodo
int Queue::front()
{
    if(!empty()){
        // Retornamos el dato
        return start->time();
    }

    // Mostramos mensaje en caso de cola vacia
    printf("Cola vacia\n");
    return 0;
}

// Obtenemos el quantum de los procesos
int Queue::quantum()
{
    // precondicion
    if(!empty()){
        int x = 0; // Suma para el quantum
        Node *p = start; // Inicializamos el nodo inicio

        // Obtenemos la suma del tiempo
        while(p){
            x += p->time();
            p = p->next();
        }


        return x / _s;
    }

    return 0;
}

// Ordenamos la cola por prioridad
// @param x ID del proceso
// @param y Tiempo del proceso
// @param z Prioridad del proceso
void Queue::orderbypriority(char x, int y, int z)
{
    // precondicion
    if(!full()){
        // Verificamos si la cola esta vacia
        if(empty()){
            // Si esta vacia creamos la cola
            start = eoq = new Node(x, y, z);
        } else {
            // p es igual al inicio de la lista
            Node *p = start;
            Node *q = NULL;

            // Recorremos la lista en busca del punto de inserccion
            while(p != NULL && p->priority() >= z){
                q = p;
                p = p->next();
            }

            // Creamos un nodo
            Node *aux = new Node(x, y, z);

            // Verificamos si p == NULL e insertamos al final
            if(p == NULL) q->next(aux);
            else if(p == start) {
                // Insertamos al final de la lista
                aux->next(start);
                start = aux;
            } else {
                // Insertamos a la mitad de la lista
                q->next(aux);
                aux->next(p);
            }
        }

        // Incremento tamaño
        _s++;
    } else {
        // Mostramos el mensaje en caso de que la cola este llena
        printf("Cola llena \n");
    }
}

// Ordenamos la cola por tiempo
// @param x ID del proceso
// @param y Tiempo del proceso
// @param z Prioridad del proceso
void Queue::orderbytime(char x, int y, int z)
{
    // precondicion
    if(!full()){
        // Verificamos si la lista esta vacia
        if(empty()){
            // Si esta vacia creamos la cola
            start = eoq = new Node(x, y, z);
        } else {
            // p es igual al inicio de la lista
            Node *p = start;
            Node *q = NULL;

            // Recorremos la lista en busca del punto de inserccion
            while(p != NULL && p->time() < y){
                q = p;
                p = p->next();
            }

            // Creamos un nodo
            Node *aux = new Node(x, y, z);

            // Verificamos si p == NULL e insertamos al final
            if(p == NULL) q->next(aux);
            else if(p == start) {
                // Insertamos al final de la lista
                aux->next(start);
                start = aux;
            } else {
                // Insertamos a la mitad de la lista
                q->next(aux);
                aux->next(p);
            }
        }

        // Incremento tamaño
        _s++;
    } else {
        // Mostramos el mensaje en caso de que la cola este llena
        printf("Cola llena \n");
    }
}

// Ordenamos la cola por id
// @param x ID del proceso
// @param y Tiempo del proceso
// @param z Prioridad del proceso
void Queue::orderbyid(char x, int y, int z)
{
    // precondicion
    if(!full()){
        // Verificamos si la cola esta vacia
        if(empty()){
            // si esta vacia creamos la cola
            start = eoq = new Node(x, y, z);
        } else {
            // p es igual al inicio de la lista
            Node *p = start;
            Node *q = NULL;

            // Recorremos la lista en busca del punto de inserccion
            while(p != NULL && p->id() < x){
                q = p;
                p = p->next();
            }

            // Creamos un nodo
            Node *aux = new Node(x, y, z);

            // Verificamos si p == NULL e insertamos al final
            if(p == NULL) q->next(aux);
            else if(p == start) {
                // Insertamos al final de la lista
                aux->next(start);
                start = aux;
            } else {
                // Insertamos a la mitad de la lista
                q->next(aux);
                aux->next(p);
            }
        }

        // Incremento tamaño
        _s++;
    } else {
        // Mostramos el mensaje en caso de que la cola este llena
        printf("Cola llena \n");
    }
}

// Metodo para busqueda de nodos
// Adaptado para retornar un nodo anteriro al que se busca
// @param x id del nodo a buscar
Queue::Node *Queue::search(char x)
{
    // Verificamos que la cola no este vacia
    if(!empty()){
        // Inicializamos el puntero p
        Node *p = start;
        Node *q = NULL;

        // Recorremos en busca del nodo
        while(p && p->id() < x){
            q = p;
            p = p->next();
        }

        // Verificamos si el dato buscado es igual al del nodo
        if(p && p->id() == x) return q; // Retornamos el nodo
        else return NULL; // Retornamos null, al no encontrar el dato
    }

    // Si no existe el nodo retornamos null
    return NULL;
}

// Metodo para la eliminacion de nodos
// @param x ID del nodo a buscar
bool Queue::supr(char x)
{
    // Precondicion
    if(!empty()){
        // Inicializamos el puntero p
        Node *p = start;
        Node *q = NULL;

        // Buscamos el item
        if((q = search(x))) p = q->next();

        // Verificamos si encontramos el item
        if(p && p->id() == x){
            if(p == start){
                // Eliminamos por el frente
                start = p->next();
            } else {
                // Eliminamos por en medio
                q->next(p->next());
            }

            // Eliminamos p
            delete p;

            _s--; // Restamos el tamaño de la cola

            // Retornamos true por eliminar el nodo
            return true;
        }
    }
    // Retornamos false por no eliminar ningun nodo
    return false;
}

// Metodo para imprimir los resultados
void Queue::print()
{
    // Precondicion
    if(!empty()){
        // Recorremos la cola para imprimir los datos
        for(Queue::Node *i = start; i; i = i->next()){
            // Imprimimos la prioridad
            printf("%6i", i->priority());
        }
        printf("\n");

        for(Queue::Node *i = start; i; i = i->next()){
            // Verificamos si es el nodo inicial
            if(i == start){
                // Si lo es imprimimos un espacio extra
                printf("    ");
            }

            // Imprimimos el ID del proceso
            printf("[%c]", i->id());

            // Verificamos si se trata del ultimo nodo
            if(i->next() != NULL){
                // Si no lo es agregamos union de nodos
                printf("<--");
            }
        }
        printf("\n");

        for(Queue::Node *i = start; i; i = i->next()){
            // Imprimimos el tiempo del proceso
            printf("%6i", i->time());
        }
    }
}


// Metodo para imprimir los resultados
void Queue::result()
{
    // Suma de los tiempos de los procesos
    float suma = 0.0;

    printf("   ID  |  Tiempo\n");
    printf("----------------\n");

    // Recorremos la lista
    for(Node *p = start; p; p = p->next()){
        // Imprimimos el ID y tiempo del procesp
        printf("  TR%c  |    %i\n", p->id(), p->time());
        suma += p->time();
    }

    printf("-----------------\n");
    printf("T. promedio = %.1f\n\n", suma / _s);
}
//Metodo para procesar el algoritmo de round robin
void Queue::processroundrobin(int quantum)
{
    float suma = 0.0; // Suma del tiempo total
    int s = _s; // Tamaño de la cola
    Node *control = start; // Asignamos control igual a inicio de la cola
    Queue *respaldo = new Queue(_s);

    printf("\nProcesando el algoritmo: [quantum=%i]\n\n", quantum);

    print(); // Imprimimos la cola inicialmente

    // El ciclo correra mientras existan nodos de las colas
    while(control != NULL){
        Node *p = start; // Nodo a recorrer
        Node *aux = NULL;

        // Verificamos si el tiempo es igual o menor al quantum
        if(p->time() <= quantum){
            // Encontramos resultado
            suma += p->time(); // Aumentamos el tiempo total
            printf("\nTR%c = %.0f\n", p->id(), suma);
            respaldo->orderbyid(p->id(), (int) suma, p->time()); // Respaldamos
            supr(p->id()); // Eliminamos el nodo
            print(); // Imprimimos la cola
        } else {
            // Reordenamos la cola
            printf("\n->\n|\nt.%i\n|\n->\n", quantum); // Imprimimos el quantum
            suma += quantum; // Aumentamos el tiempo total
            p->settime(p->time() - quantum); // Recalculamos el tiempo

            aux = new Node(p->id(), p->time(), p->priority()); // Respaldamos el nodo
            if(supr(p->id())){ // Eliminamos el nodo
                enqueue(aux->id(), aux->time(), aux->priority()); // mandamos el nodo al final
            }

            print(); // Imprimimos la cola
        }

        // Reasignamos el valor de control
        control = start;
    }

    printf("\nTiempo total: %.0f\n", suma);
    printf("Tiempo promedio: %.1f\n\n", suma / s);
    printf("*** Tabla de resultados ***\n\n");
    respaldo->result();
}

// Metodo para procesar el algoritmo de prioridad
// @param quantum Tiempo promedio de los procesos
void Queue::processpriority(int quantum)
{
    float suma = 0.0; // Suma del tiempo total
    int s = _s; // Tamaño de la cola
    Node *control = start; // Asignamos control igual a inicio de la cola
    Queue *respaldo = new Queue(_s);

    printf("\nProcesando el algoritmo: [quantum=%i]\n\n", quantum);

    print(); // Imprimimos la cola inicialmente

    // El ciclo correra mientras existan nodos de las colas
    while(control != NULL){
        Node *p = start; // Nodo a recorrer
        Node *aux = NULL;

        // Verificamos si el tiempo es igual o menor al quantum
        if(p->time() <= quantum){
            // Encontramos resultado
            suma += p->time(); // Aumentamos el tiempo total
            printf("\nTR%c = %.0f\n", p->id(), suma);
            respaldo->orderbyid(p->id(), (int) suma, p->priority()); // Respaldamos
            supr(p->id()); // Eliminamos el nodo
            print(); // Imprimimos la cola
        } else {
            // Reordenamos la cola
            printf("\n->\n|\nt.%i\n|\n->\n", quantum); // Imprimimos el quantum
            suma += quantum; // Aumentamos el tiempo total
            p->settime(p->time() - quantum); // Recalculamos el tiempo
            // Verificamos que la prioridad sea diferente a 1
            if(p->priority() != 1) p->setpriority(p->priority() - 1); // Recalculamos la prioridad
            aux = new Node(p->id(), p->time(), p->priority()); // Respaldamos el nodo
            if(supr(p->id())){ // Eliminamos el nodo
                orderbypriority(aux->id(), aux->time(), aux->priority()); // Reordenamos el nodo
            }
            print(); // Imprimimos la cola
        }

        // Reasignamos el valor de control
        control = start;
    }

    printf("\nTiempo total: %.0f\n", suma);
    printf("Tiempo promedio: %.1f\n\n", suma / s);
    printf("*** Tabla de resultados ***\n\n");
    respaldo->result();
}

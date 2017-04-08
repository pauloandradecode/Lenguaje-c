# sistemas operativos
=====================

En un S.O. el sheduler es el encargado de manejar el tiempo de procesos del CPU y es la capa bas baja del S.O.

# Contenido

## Scheduling [directorio]

En este directorio encontraras un proyecto (creado en codeblocks) para obtener una simulación del procesamiento de instrucciones en un sistema operativo.-

* FIFO.- Se procesan por conforme se van agregando a la cola.
* SJF.- Para procesar las instrucciones, estas se ordenan por tiempo de ejecución y despues se procesan cada una de estas.
* Round Robin.- Se ordenan por ID del proceso, se obtiene el tiempo medio de estos procesos (quantum) y se ejecuta como un FIFO, solo que respetando que el tiempo de ejecucion de cada proceso sea menor al quantum, si no es menor, se le resta el quantum al tiempo del proceso y se manda al final de la cola.
* Prioridad.- Se ordenan por prioridad, se obtiene el tiempo medio de estos procesos (quantum), para procesar el tiempo de ejecucion de cada proceso debe ser menor al quantum, si no es menor, se le resta el quantum al tiempo del proceso y se le resta uno a la prioridad, la cola se vuelve a ordenar por prioridad.
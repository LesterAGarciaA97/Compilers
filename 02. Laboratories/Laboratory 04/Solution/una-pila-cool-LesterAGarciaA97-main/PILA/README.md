Archivo README para el laboratorio PILA
=======================================

Su directorio ahora debería contener los siguientes archivos:

* Makefile
* README
* atoi.cl
* pila.cl
* pila.test

El Makefile contiene objetivos para compilar y ejecutar su programa, así como entregarlo.

El README contiene esta información. Parte de la tarea es responda las preguntas al final de este archivo README. Edite este archivo en formato [Markdown](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)

atoi.cl es una implementación en Cool de la función de conversión cadena a entero conocida del lenguaje C.

pila.cl es el archivo esqueleto con el que debe completar su programa

pila.test es una breve entrada de prueba a la máquina de pila.

Instrucciones
------------

Para compilar y ejecutar su programa, escriba:

> make test

Sin hacer ningún cambio el programa debe imprimir "Nothing implemented"


Para simplemente compilar su programa, escriba

> make compile


Las instrucciones para entregar la tarea se publicarán en Moodle.

¡BUENA SUERTE!


Preguntas sobre LAB PILA
------------------------

1. Describa su implementación de la máquina de pila en un párrafo.


2. Escriba una lista de tres características del lenguaje cool (-e.g. soporta programación orientada a objetos-).


3. Escriba una lista de tres características que crea que pueden mejorar en COOL.


Respuestas a las preguntas sobre LAB PILA
-----------------------------------------

1. Cuando se habla de una máquina de pila nos referimos a la forma en que toma la memoria de una computadora en forma de una o más pilas ya sea física o simulada. La implementación que yo hice en mi máquina de pila fue haciendo uso de una Lista para simular la cabeza y la cola de una pila con sus métodos básicos para verificar si está vacía, obtener el valor de hasta arriba y el valor de hasta abajo. Al momento de estar recibiendo las instrucciones ingresadas desde la terminal tengo dos métodos, uno para evaluarPila el cual lee los símbolos + y s con un if y hacen ya sea la suma de los últimos 2 valores ingresados o el cambio de la posición para poder operarlos. Dichas operaciones fueron trabajaras en clases independientes para sumar los valores y cambiar posiciones dentro de la stack. Ya con esos métodos definidos podía recibir los símbolos ingresados en la terminal y hacer cada operación dentro de mi pila.

2. 
   * Es un lenguaje fuertemente tipado
   * Asignación dinámica
   * Manejo automático de memoria

3. 
   * El uso de ; debería de ser en todas las líneas porque llega a ser confuso en cual línea cerrar con ; y en cuales no.
   * El cierre de palabras reservadas como Loop con Pool o If con fi pienso que podría omitirse y trabajar como un lenguaje de programación común.
   * El uso del símbolo <- podría estandarizarse a un símbolo =
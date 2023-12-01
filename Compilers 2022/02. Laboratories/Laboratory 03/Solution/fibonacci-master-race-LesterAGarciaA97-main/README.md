Descripción
===========

El objetivo del laboratorio es explorar las consecuencias de una mala
programación.

Laboratorio
===========

El tutor del curso le asignara una tarea via GitHub Classroom, para esta
tarea:

1. Resuelva el laboratorio en SU fork del repositorio, las pruebas
    serán ejecutadas automáticamente. Puede utilizar el IDE que
    considere conveniente siempre que este tenga soporte para JUnit 5 y Java 11


2. Analice el contenido de la clase FraseTest, implemente la clase
    Frase que satisfaga cada uno de los tests presentados


3. La clase FibonacciCreator presenta una implementación que es capaz
    de calcular el n-esimo termino de la sucesión de Fibonacci
    (iniciando la cuenta en 0), la cual es dada por la siguiente
    progresión:

    > número 0 - 0, número 1 - 1, número 2 - 0+1=1, número 3 - 1+1=2,
    número 4 - 1+2=3, número 5 - 2+3=5, número 6 - 8 = 5+3
    
    En el repositorio base implementado para este proyecto, usted
    también encontrara la clase FibonacciTest, que podría (o no) ser
    funcional al momento que usted trabaje sobre su copia. Corrija la
    implementación de tal forma que los tests sean funcionales.


4. ¿Que cambios ha realizado? ¿Por qué? Explique su respuesta y adjuntela en su archivo README.md

Clase Frase.java

1) doPaco: En esta lo que hice fue crear una variable que tuviera el valor literal "juan paco pedro de la mar" y luego retorno esa variable.

2) doFraseREversa: Aquí creé una variable llamada fraseReversa en la cual almacenaría la frase con su nuevo orden, le hice un split para identificar hasta donde llegaba cada palabra viendo los espacios en blanco (espacios intermedios entre palabras), después recorrí el tamñaño completo de la cadena y que lo fuera restando, a diferencia de un for normal, en este lo restaba, y por último validaba si debía tener o no un espacio entre cada palabra para mostrar el nuevo orden de las palabras con sus respectivos espacios.

3) doPalindromo: Aquí primero pasé todo a minúsculas y reemplazé todos los espacios en blanco para dejar todo junto. Luego en un arreglo de caracteres fui ingresando letra por letra al arreglo, después en un ciclo for recorrí todo el arreglo y verificaba la última letra con la primera, si eran iguales es palíndromo y sino no lo es.

4) doMayusculas: En este puse como valor definido "paco" a una variable la cual mientras recorro un ciclo for, valido con un if si es diferente o no a la posición del arreglo, si es diferente la mete al arreglo, si es igual la elimina, paso todo a mayúsculas y regreso el nuevo arreglo.

Clase FibonacciCreator.java

1) Para que se lograra obtener una ejecución exitosa del Thanos Fibonacci lo que hice fue primer evitar que se enciclara tratando de devolver un 0 ya que es el valor inicial, entonces minetras mi varaible con valor entero sea menor a 1 que me regrese NULL, luego de eso asigné valores predeterminados con 0 y 1 ya que son los primeros valores de la cadena de Fibonacci y ya después con un ciclo while voy sumando y restando a cada uno de esos valores para ir generando el resto de dígitos después del 0 y 1 iniciales.

Fecha límite de entrega: Jueves 3 de febrero, 20:55 SIN EXCEPCIONES

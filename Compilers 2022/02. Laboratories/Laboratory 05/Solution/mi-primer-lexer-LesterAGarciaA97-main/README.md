# Preguntas de laboratorio

1. ¿Para resolver este laboratorio necesitó de establecer alguna prioridad? Explique:
2. ¿Cuál es el objetivo del plugin de Maven para JFlex?
3. ¿Para que sirve la función yylex()?
4. ¿Cómo podemos cambiar el tipo de dato que genera yylex()?

Bonus
5. ¿Que clase debemos cambiar u omitir para hacer este lexer compatible con CUPS?


# Respuestas a preguntas de laboratorio

1. Si se necesitaron cambios de prioridad, estos fueron hechos en el archivo simple.flex ya que la forma en que se procesaba las gramaticas tenia que ser en un orden especifico, por ejemplo primero se tuvo que definiir la gramatica de evaluacion para paginas web, si esa no cumplia seguia con palabras reservadas y para el resto el orden era indiferente.
<br></br>
2. Esto lo que permite es generar una gramatica completa basado en nuestro archivo flex. Todo esto mediante una libreria jflex de Maven.
<br></br>
3. yylex() no tiene parametros y es un analizador lexico. Este tiene que devolver un numero de token de tipo entero en funcion a la grmatica ingresada. En otras palabras, es un escaner de tokens.
<br></br>
4. Esto se puede lograr haciendo la modificacion necesaria en nuestras gramaticas, por ejemplo, para la solucion de este laboratorio se tiene ID, KEYWORD, COMMENT, etc., y ahi es donde definimos que datos genera, todo dependera de la gramatica que queramos generar.
<br></br>
### Bonus
5. Para empezar, se deben importar todos los paquetes de java_cup runtime al proyecto.  Luego hay que declarar la compatibilidad con cup colocando esto en la clase utilizada, por ejemplo, seria de colocar %cup. Y adicional hay que agregar la dependencia de java-cup-runtime. Con esos 3 cambios el proyecto de Lexer seria totalmente compatible con CUP.
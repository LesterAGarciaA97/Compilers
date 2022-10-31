# Preguntas

1. ¿Qué tipo de analizador léxico genera ANTLR 4?
2. ¿Qué tipo de analizador sintáctico genera ANTLR 4?
3. ¿Qué tipo de algoritmo utiliza ANTLR 4 para el análisis sintáctico? ¿Cómo se resuelven los conflictos de precedencia?
4. ¿En qué parte del proyecto se ha configurado la compatibilidad con ANTLR 4?
<br></br>
# Respuestas
1. Genera analizadores tipo LL(k) y esto se debe a que la revisón que hace es sobre tokens y cadenas.
<br></br>
2. Genera un tipo descentende, o dicho en inglés "Top-Down"
<br></br>
3. ANTLR4 procesa los tokens que vienen del Lexer y si todo es correcto el siguiente paso es cuando se genera el árbol de sintaxis. Los conflictos de precedencia se resuelven con la implementación de "Visitors", eso y combinado con el recorrido descendente se logra resolver la precedencia.
<br></br>
4. En el POM.xml se tuvo que agregar un plugin de las librerías de maven, y adicional se tuvo que agregar las tags de Listeners y Visitors y colocarle un valor TRUE para que al momento de hacer un antlr4:antlr4 se generaran dichos archivos.

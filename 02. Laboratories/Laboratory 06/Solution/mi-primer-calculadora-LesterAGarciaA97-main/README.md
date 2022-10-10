# Preguntas

1. ¿Qué plugin es el encargado de generar los archivos Jar con dependencia?
2. ¿Cuales cambios fueron necesarios para hacer compatible Quickstart con Java 17?
3. ¿En que parte del proyecto se ha configurado la compatibilidad con JLex?
4. ¿Es estrictamente necesario crear una gramática no ambigua en CUP?


# Respuestas

1. El plugin encargado de generar los archivos JAR con dependencias es el siguiente:
   “maven-assembly-plugin” el cual tiene como groupID lo siguiente “org.apache.maven.plugins” y como descriptorRef tiene “jar-with-dependencies”
   <br></br>
2. Primero, dentro del POM.xml se debe de modificar la versión de Java a 17 ya que por defecto el arquetipo viene con versiones más antiguas.
   Luego se hace el cambio de Junit 4 hacia Junit 5 (Junit Jupiter), todos estos cambios se hacen a nivel de las dependencias. Adicional se hace la modificación a SureFire para que sea compatible con Java 17.
   <br></br>
3. En el POM.xml, en la sección de plugins/build se tiene que agregar específicamente el plugin “jflex-maven-plugin” y luego actualizar las dependencias de Maven. Y en la clase parser.cup se coloca la siguiente importación: import java_cup.runtime.*; esto habilita la compatiblidad entre lex y cup.
   <br></br>
4. No necesariamente ya que al hacer uso del “precedence” se puede definir un tipo de jerarquía, como cup lo lee de abajo hacia arriba se debe de colocar en el orden en el que buscamos que lo lea. Por ejemplo, mientras resolvía el laboratorio me topé con el problema de que había puesto las sumas antes de las multiplicaciones, entonces el test original me operaba 2 + 2 * 6 el cual esperaba resultado 14 y a mi me daba 24 porque hacía primero la suma y luego la multiplicación. En resumen, no es estrictamente necesario que sea ambiguo o no ya que al hacer uso de la precedencia se puede delimitar una jerarquía de lectura.

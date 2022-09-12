--Original content of the solution given by the teacher.
class Main inherits IO {

   b : List;
   cadena : String;

   main() : Object { {
      b <- new List;
      out_string(">");
      cadena <- in_string();
      while (not cadena = "x" ) loop {
         b <- (new Stack).init(cadena, b);
         out_string(">");
         cadena <- in_string();
      }
      pool;
   }
   };
};

--This List class was taken from the example in /opt/cool-distro/examples/list.cl
class List {

   --Basic methods for the List
   isNil() : Bool { true };
   head() : String { { abort(); ""; } };
   tail() : List { { abort(); self; } };
   
   cons(i : String) : List {
      (new Cons).init(i, self)
   };
};

class Cons inherits List {
   inicial : String;
   cuerpo : List;
   isNil() : Bool { false };
   head() : String { inicial };
   tail() : List { cuerpo };

   init(i : String, pilaCompleta : List) : List {
      {
         inicial <- i;
         cuerpo <- pilaCompleta;
         self;
      }
   };
};

class Stack inherits A2I {
   --Initialize the List as a Stack
   init(a : String, b : List) : List {
      if a = "e" then
      new EvaluarPila.ex(b) else
      if a = "d" then
      { new MostrarPila.print_list(b); b; } else
      b.cons(a)
      fi
      fi
   };
};

--Mostrar la pila y hacer salto de linea
class MostrarPila inherits Stack {
   i : IO <- new IO;
   print_list(b : List) : Object{
      if b.isNil() then
      i.out_string("")
      else{
         i.out_string(b.head());
         i.out_string("\n");
         print_list(b.tail());
      }
      fi
   };
};

--Evaluación de la pila si se ingresan símbolos + o s
class EvaluarPila inherits Stack {
   ex(b : List) : List {
      if b.isNil() then b
      else
      if b.head() = "+" then new SumarValores.suma(b.tail())
      else
      if b.head() = "s" then new CambiarPosicion.cam(b.tail())
      else
      b
      fi
      fi
      fi
   };
};

class SumarValores inherits Stack {
   primerValor : Int;
   segundoValor : Int;

   suma(b : List) : List { { 
      primerValor <- new A2I.a2i_aux(b.head());
      segundoValor <- new A2I.a2i_aux(b.tail().head());
      new Cons.init(new A2I.i2a_aux(primerValor + segundoValor), b.tail().tail());
      }
   };
};

class CambiarPosicion inherits Stack {
   primerValor : String;
   segundoValor : String;

   cam(b : List) : List { {
      primerValor <- b.head();
      segundoValor <- b.tail().head();
      new Cons.init(segundoValor, new Cons.init(primerValor, b.tail().tail()));
      }
   };
};
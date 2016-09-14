package co.edu.eafit.dis.nueveonce
import scala.util.parsing.combinator._
    object model extends RegexParsers {
    def regu = ope 
    def ope: Parser[RegExpr] = op2 ~ rep("[.|]".r ~ op2)  ^^ {
	 	case op ~ list => list.foldLeft(op) {
	      case (res1, "." ~ res2) => Con(res1,res2)
	      case (res1, "|" ~ res2) => Union(res1,res2)
    }   	
   }
    def op2: Parser[RegExpr] = (op1 | res) 
    def op1: Parser[RegExpr] = res ~ ("[*+]").r ^^ {
    	case (s ~ "*") => Kleene(s)
    	case (s ~ "+") => Cross(s)
    }
    def res:   Parser[RegExpr] = (a | b | pare)   
	def a:     Parser[RegExpr] = 'a' ^^ (s => Sym(s))
	def b:     Parser[RegExpr] = 'b' ^^ (s => Sym(s))
	def pare:  Parser[RegExpr] = ("(" ~> ope <~ ")") 
	

	def apply(input:String): String = parseAll(regu,input) match {
    case Success(resul,_) => resul.toString
    case NoSuccess(msg,_) => "*Parser Error" + msg
    case Error(_,_)       => "WE HAVE A DAMN ERROR" 
  }
}

import co.edu.eafit.dis.nueveonce._
import scala.util.parsing.combinator._

object RegExpr extends RegexParsers  {
  def apply(input:String): String = parseAll(Parser.res,input) match {
    case Success(resul,_) => resul
    case NoSuccess(_,_) => "WE HAVE A DAMN ERROR" 
  }
  def main(args:Array[String]):Unit = {
    for(ln <- io.Source.stdin.getLines)
     println(apply(ln))
  } 
} 

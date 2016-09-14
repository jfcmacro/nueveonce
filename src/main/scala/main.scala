import co.edu.eafit.dis.nueveonce._
import scala.util.parsing.combinator._

object RegExpr extends RegexParsers  {
  def main(args:Array[String]):Unit = {
    for(ln <- io.Source.stdin.getLines)
     println(model.apply(ln))
  } 
} 

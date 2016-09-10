package co.edu.eafit.dis.nueveonce.parser
import scala.util.parsing.combinator._
import co.edu.eafit.dis.nueveonce.ast.RegExpr

object RegParser extends RegexParsers {
  def res: Parser[RegExpr] = (a | b | con | kle | cru)
  def a:   Parser[RegExpr] = "a" ^^ (s => Sym(s))
  def b:   Parser[RegExpr] = "b" ^^ (s => Sym(s))
  def ope: Parser[RegExpr] = res ~ rep("""[.] | [|]""".r) ~ res ^^ {case op ~ list => list.foldLeft(op) {
  case (res1, "." ~ res2) => Con(res1,res2)
  case (res1, "|" ~ res2) => Union(res1,res2)
}   
  }
  def kle: Parser[RegExpr] = res ~ ("""[*]""".r)
  def cru: Parser[RegExpr] = res ~ ("""[+]""".r)
}

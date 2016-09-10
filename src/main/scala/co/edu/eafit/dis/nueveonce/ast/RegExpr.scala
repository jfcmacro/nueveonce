package co.edu.eafit.dis.nueveonce.ast

sealed abstract class RegExpr
case class Sym(sym:Char) extends RegExpr
case class Null() extends RegExpr
case class Con(left:RegExpr, right:RegExpr) extends RegExpr
case class Union(left:RegExpr, right:RegExpr) extends RegExpr
case class Kleene(subChild:RegExpr) extends RegExpr
case class Cross(subChild:RegExpr) extends RegExpr


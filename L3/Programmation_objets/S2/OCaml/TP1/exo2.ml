type form =
  | Top
  | Bot
  | Var of string
  | Not of form
  | And of form*form
  | Or of form*form
  | Imp of form*form
  | Equ of form*form
;;

let f1= And(Bot,Top);;
let f2= Imp(f1,"p");;


let rec affiche= function
  | Top -> "T"
  | Bot -> "F"
  | Var n -> n
  | Not f -> "!("^(affiche f)^")"
  | And (f1,f2) -> "("^(affiche f1)^"^"^(affiche f1)^")"
  | Or (f1,f2) -> "("^(affiche f1)^"v"^(affiche f1)^")"
  | Imp (f1,f2) -> "("^(affiche f1)^"->"^(affiche f2)^")"
  | Equ (f1,f2) -> "("^(affiche f1)^"<->"^(affiche f2)^")"
;;

affiche f2;;

let simp_and= function
  | (f1,Top) | (Top,f1) -> f1
  | (_,Bot) | (Bot,_) -> Bot
  | (f1,f2) -> And(f1,f2)
;;

let simp_or= function
  | (_,Top) | (Top,_) -> Top
  | (f1,Bot) | (Bot,f1) -> f1
  | (f1,f2) -> Or(f1,f2)
;;

let simp_imp= function
  | (_,Top) -> Top
  | (Top,f1) -> f1
  | (f1,Bot) -> Not f1
  | (Bot,_) -> Top
  | (f1,f2) -> Imp(f1,f2)
;;

let simp_equ= function
  | (f1,Top) | (Top,f1) -> f1
  | (f1,Bot) | (Bot,f1) -> Not f1
  | (f1,f2) -> Equ(f1,f2)
;;

let rec simplification= function
  | And(f1,f2) ->
     let f1'= simplification f1
     and f2'= simplification f2
     in simp_and(f1',f2')
  | Or(f1,f2) ->
     let f1'= simplification f1
     and f2'= simplification f2
     in simp_or(f1',f2')
  | Imp(f1,f2) ->
     let f1'= simplification f1
     and f2'= simplification f2
     in simp_imp(f1',f2')
  | Equ(f1,f2) ->
     let f1'= simplification f1
     and f2'= simplification f2
     in simp_equ(f1',f2')
  | f -> f
;;

simplification f2;;

let liste= [1; 2; 3; 4; 5];;


let rec reverse= function
  | [] -> []
  | e::tl ->
     (reverse tl)@[e]
;;

reverse liste;;


let rec nbOcc n= function
  | [] -> 0
  | e::tl ->
     if (e=n)
     then 1+(nbOcc n tl)
     else nbOcc n tl
;;

nbOcc 4 liste;;


let rec estTriee= function
  | [] -> true
  | [e1] -> true
  | e1::e2::tl ->
     if (e1<e2)
     then estTriee (e2::tl)
     else false
;;

estTriee liste;;


let rec insert n= function
  | [] -> [n]
  | e::tl ->
     if (n>e)
     then e::(insert n tl)
     else n::e::tl
;;

insert 4 liste;;


let rec insertTri= function
  | [] -> []
  | e::tl ->
     insert e (insertTri tl)
;;

insertTri liste;;

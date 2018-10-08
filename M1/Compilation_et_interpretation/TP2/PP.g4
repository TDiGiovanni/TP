/**
 * authors: Alexandre Hellin, Thomas Di Giovanni
 */

grammar PP;

/**
 * Type
 */
type returns [Type value] :
    'integer' {$value = new Int();}
  | 'boolean' {$value = new Bool();}
  | 'array' 'of' t = type {$value = new Array($t.value);}
  ;

/**
 * Constant
 */
constant returns [Constant value] :
    'true' {$value = new True();}
  | 'false' {$value = new False();}
  | n = NUMBER {$value = new N(Integer.parseInt($n.text));}
  ;

/**
 * Callee name.
 */
callee returns [Callee value] :
    'read' { $value = new Read(); }
  | 'write' { $value = new Write(); }
  | m = NAME { $value = new User($m.text); }
  ;

/**
 * Variable name
 */
variable returns [Variable value] :
    c = NAME {$value = new Variable($c.text);} ;

/**
 * Expression
 */
expr returns [Expression value]
@init {
  ArrayList<Expression> arguments = new ArrayList<>();
} :
    c = constant {$value = $c.value; }
  | v = variable {$value = $v.value; }
  | '-' e = expr {$value = new Negative($e.value);}
  | 'not' e = expr {$value = new Not($e.value);}
  | e1 = expr '+' e2 = expr {$value = new Addition($e1.value, $e2.value);}
  | e1 = expr '-' e2 = expr {$value = new Substraction($e1.value, $e2.value);}
  // Inferior or equal
  | e1 = expr '≤' e2 = expr {$value = new LowerOrEqual($e1.value, $e2.value);}
  | e1 = expr '<=' e2 = expr {$value = new LowerOrEqual($e1.value, $e2.value);}
  // Inequality
  | e1 = expr '≠' e2 = expr {$value = new NotEqual($e1.value, $e2.value);}
  | e1 = expr '!=' e2 = expr {$value = new NotEqual($e1.value, $e2.value);}
  // Superior or equal
  | e1 = expr '≥' e2 = expr {$value = new GreaterOrEqual($e1.value, $e2.value);}
  | e1 = expr '>=' e2 = expr {$value = new GreaterOrEqual($e1.value, $e2.value);}
  // Multiply
  | e1 = expr '×' e2 = expr {$value = new Multiplication($e1.value, $e2.value);}
  | e1 = expr '*' e2 = expr {$value = new Multiplication($e1.value, $e2.value);}
  | e1 = expr '/' e2 = expr {$value = new Division($e1.value, $e2.value);}
  | e1 = expr '<' e2 = expr {$value = new Lower($e1.value, $e2.value);}
  | e1 = expr '=' e2 = expr {$value = new Equal($e1.value, $e2.value);}
  | e1 = expr '>' e2 = expr {$value = new Greater($e1.value, $e2.value);}
  | e1 = expr 'and' e2 = expr {$value = new And($e1.value, $e2.value);}
  | e1 = expr 'or' e2 = expr {$value = new Or($e1.value, $e2.value);}
  | f = callee '(' (e = expr { arguments.add($e.value); })* ')' { $value = new CallFun($f.value, arguments); }
  | e1 = expr '[' e2 = expr ']' {$value = new ArrayGet($e1.value, $e2.value);}
  | 'new' 'array' 'of' t = type '[' e = expr ']' {$value = new ArrayAllocation($t.value, $e.value);}
  ;

/**
 * Instruction
 */
inst returns [Instruction value]
@init {
  ArrayList<Expression> arguments = new ArrayList<>();
} :
    v = variable ':' '=' e = expr { $value = new Assignment($v.value, $e.value); }
  | a = expr '[' idx = expr ']' ':' '=' val = expr { $value = new ArraySet($a.value, $idx.value, $val.value); }
  | 'if' e = expr 'then' i1 = inst 'else' i2 = inst { $value = new If($e.value, $i1.value, $i2.value); }
  | 'while' e = expr 'do' i = inst { $value = new While($e.value, $i.value); }
  | f = callee '(' (e = expr { arguments.add($e.value); })* ')' { $value = new CallProc($f.value, arguments); }
  | 'skip' { $value = new Skip(); }
  | i1 = inst ';' i2 = inst {$value = new Semicolon($i1.value, $i2.value); }
  ;

/**
 * Function/procedure definition
 *
 * prototype
 *   (optional) parameters
 *   (optional) return value
 * local variables
 * 1+ instructions
 */

def returns [Definition value]
@init {
  ArrayList<Pair<String,Type>> arguments = new ArrayList<>();
  ArrayList<Pair<String,Type>> localVars = new ArrayList<>();
} :
      // Function definition
      n = callee '(' (v = variable ':' t = type { arguments.add(new Pair($v.text, $t.value)); } )* ')' ':' r = type
      ('var' (v = variable ':' t = type { localVars.add(new Pair($v.text, $t.value)); })+)?
      i = inst { $value = new FunDefinition($n.text, arguments, localVars, $i.value, $r.value); }
    | // Procedure definition
      n = callee '(' (v = variable ':' t = type { arguments.add(new Pair($v.text, $t.value)); })* ')'
      ('var' (v = variable ':' t = type { localVars.add(new Pair($v.text, $t.value)); })+)?
      i = inst { $value = new ProcDefinition($n.text, arguments, localVars, $i.value); }
    ;

/**
 * Program definition
 *
 * (optional) variables
 * (optional) function / procedure definitions
 * 1+ instructions
 */

prog returns [Program value]
@init {
  ArrayList<Pair<String,Type>> globalVars = new ArrayList<>();
  ArrayList<Definition> definitions = new ArrayList<>();
} :
    ('var' (v = variable ':' t = type { globalVars.add(new Pair($v.text, $t.value)); })+)?
    (d = def { definitions.add($d.value); })*
    i = inst { $value = new Program(globalVars, definitions, $i.value); };

// Order is very important
NAME :  '_'*[A-Za-z][A-Za-z0-9_]* ;
NUMBER : ('0'..'9')+ ;
WS : [ \t\r\n]+ -> skip ;
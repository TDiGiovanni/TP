// Binôme :
// Hellin Alexandre
// Di Giovanni Thomas

import java.util.*;

class Pair<L,R>
{
    final L left;
    final R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    static <L,R> Pair<L,R> of(L left, R right){
        return new Pair<L,R>(left, right);
    }

    public String toString() {
	return left.toString() + " : " + right.toString();
    }
}

// Types
abstract class Type {}

class Int extends Type
{
    public String toString() {
        return "integer";
    }
}

class Bool extends Type
{
    public String toString() {
        return "boolean";
    }
}

class Array extends Type
{
    Type elements;

    public Array(Type elements) {
        this.elements = elements;
    }
    public String toString() {
        return "array of " + elements.toString();
    }
}

// Expressions
abstract class Expression {}

class Variable extends Expression
{
    String name;

    public Variable(String name) {
        this.name = name;
    }

    public String toString() {
        return "var " + name;
    }
}

class CallFun extends Expression
{
    Callee f;
    ArrayList<Expression> arguments;

    public CallFun(Callee f, ArrayList<Expression> arguments) {
	this.f = f;
	this.arguments = arguments;
    }

    public String toString() {
	String stringArguments = "";

        for (Expression e : arguments)
            stringArguments = stringArguments + e.toString();
	
	return f.toString() + "(" + stringArguments + ")";
    }
}

class ArrayAllocation extends Expression
{
    Type type;
    Expression size;

    public ArrayAllocation (Type type, Expression size) {
        this.type = type;
        this.size = size;
    }

    public String toString() {
	return "new array of " + type.toString() + "[" + size.toString() + "]";
    }
}

class ArrayGet extends Expression
{
    Expression array, index;

    public ArrayGet (Expression array, Expression index) {
        this.array = array;
        this.index = index;
    }

    public String toString() {
	return array.toString() + "[" + index.toString() + "]";
    }
}

// Constantes
abstract class Constant extends Expression {}

class N extends Constant
{
    Integer n;

    public N(int n) {
        this.n = n;
    }

    public String toString() {
        return n.toString();
    }
}

class True extends Constant
{
    public String toString() {
        return "true";
    }
}

class False extends Constant
{
    public String toString() {
        return "false";
    }
}

// Opérations unaires
abstract class UnaryOp extends Expression
{
    Expression e;
}

class Negative extends UnaryOp
{
    public Negative(Expression e) {
        this.e = e;
    }

    public String toString() {
        return "-" +e.toString();
    }
}

class Not extends UnaryOp
{
    public Not(Expression e) {
        this.e = e;
    }

    public String toString() {
        return "not " + e.toString();
    }
}

// Opérations binaires
abstract class BinaryOp extends Expression
{
    Expression e1, e2;
}

class Addition extends BinaryOp
{
    public Addition(Expression e1, Expression e2) {
        this.e1= e1;
        this.e2 = e2;
    }

    public String toString() {
        return e1.toString() + " + " + e2.toString();
    }
}

class Substraction extends BinaryOp
{
    public Substraction(Expression e1, Expression e2) {
        this.e1= e1;
        this.e2 = e2;
    }

    public String toString() {
        return e1.toString() + " - " + e2.toString();
    }
}

class Multiplication extends BinaryOp
{
    public Multiplication(Expression e1, Expression e2) {
        this.e1= e1;
        this.e2 = e2;
    }

    public String toString() {
        return e1.toString() + " * " + e2.toString();
    }
}

class Division extends BinaryOp
{
    public Division(Expression e1, Expression e2) {
        this.e1= e1;
        this.e2 = e2;
    }

    public String toString() {
        return e1.toString() + " / " + e2.toString();
    }
}

class And extends BinaryOp
{
    public And(Expression e1, Expression e2) {
        this.e1= e1;
        this.e2 = e2;
    }

    public String toString() {
        return e1.toString() + " and " + e2.toString();
    }
}

class Or extends BinaryOp
{
    public Or(Expression e1, Expression e2) {
        this.e1= e1;
        this.e2 = e2;
    }

    public String toString() {
        return e1.toString() + " or " + e2.toString();
    }
}

class Greater extends BinaryOp
{
    public Greater(Expression e1, Expression e2) {
        this.e1= e1;
        this.e2 = e2;
    }

    public String toString() {
        return e1.toString() + " > " + e2.toString();
    }
}

class GreaterOrEqual extends BinaryOp
{
    public GreaterOrEqual(Expression e1, Expression e2) {
        this.e1= e1;
        this.e2 = e2;
    }

    public String toString() {
        return e1.toString() + " >= " + e2.toString();
    }
}

class Equal extends BinaryOp
{
    public Equal(Expression e1, Expression e2) {
        this.e1= e1;
        this.e2 = e2;
    }

    public String toString() {
        return e1.toString() + " = " + e2.toString();
    }
}

class LowerOrEqual extends BinaryOp
{
    public LowerOrEqual(Expression e1, Expression e2) {
        this.e1= e1;
        this.e2 = e2;
    }

    public String toString() {
        return e1.toString() + " <= " + e2.toString();
    }
}

class Lower extends BinaryOp
{
    public Lower(Expression e1, Expression e2) {
        this.e1= e1;
        this.e2 = e2;
    }

    public String toString() {
        return e1.toString() + " < " + e2.toString();
    }
}

class NotEqual extends BinaryOp
{
    public NotEqual(Expression e1, Expression e2) {
        this.e1= e1;
        this.e2 = e2;
    }
    public String toString() {
        return e1.toString() + " != " + e2.toString();
    }
}

// Cible d'appels
abstract class Callee {}

class Read extends Callee
{
    public String toString() {
        return "read";
    }
}

class Write extends Callee
{
    public String toString() {
        return "write";
    }
}

class User extends Callee
{
    String name;

    public User(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}

// Instructions
abstract class Instruction {}

class Assignment extends Instruction
{
    Variable x;
    Expression value;

    public Assignment(Variable x, Expression value) {
	this.x = x;
	this.value = value;
    }
    
    public String toString() {
        return x.toString() + " := " + value.toString();
    }
}

class ArraySet extends Instruction
{
    Expression array, index, value;

    public ArraySet (Expression array, Expression index, Expression value) {
        this.array = array;
        this.index = index;
        this.value = value;
    }

    public String toString() {
	return array.toString() + "[" + index.toString() + "] := " + value.toString();
    }
}

class If extends Instruction
{
    Expression e;
    Instruction i1, i2;

    public If(Expression e, Instruction i1, Instruction i2) {
	this.e = e;
	this.i1 = i1;
	this.i2 = i2;
    }
    
    public String toString() {
        return "if "+ e.toString() + " then \n" + i1.toString() + "\n else " + i2.toString();
    }
}

class While extends Instruction
{
    Expression e;
    Instruction i;

    public While(Expression e, Instruction i) {
	this.e = e;
	this.i = i;
    }
    
    public String toString() {
        return "while " + e.toString() + " do \n" + i.toString();
    }
}

class CallProc extends Instruction
{
    Callee f;
    ArrayList<Expression> arguments;

    public CallProc(Callee f, ArrayList<Expression> arguments) {
	this.f = f;
	this.arguments = arguments;
    }

    public String toString() {
	String stringArguments = "";

        for (Expression e : arguments)
            stringArguments = stringArguments + e.toString();
	
	return f.toString() + "(" + stringArguments + ")";
    }
}

class Skip extends Instruction
{
    public String toString() {
        return "skip";
    }
}

class Semicolon extends Instruction
{
    Instruction i1, i2;

    public Semicolon(Instruction i1, Instruction i2) {
	this.i1 = i1;
	this.i2 = i2;
    }
    
    public String toString() {
        return this.i1 + "; \n" + this.i2;
    }
}
    
// Définitions de fonctions/procédures
abstract class Definition
{
    String name;
    ArrayList<Pair<String,Type>> arguments, localVars;
    Instruction code;
}

class FunDefinition extends Definition
{
    Type returnType;

    public FunDefinition (String name, ArrayList<Pair<String,Type>> arguments, ArrayList<Pair<String,Type>> localVars, Instruction code, Type returnType) {
        this.name = name;
        this.arguments = arguments;
        this.localVars = localVars;
        this.code = code;
        this.returnType = returnType;
    }

    public String toString() {
	String stringArguments = "", stringLocalVars = "", stringToReturn = "";

	stringToReturn += name;

	for (int i = 0; i < arguments.size() - 1; i++)
            stringArguments = stringArguments + arguments.get(i).toString() + ", ";
	stringArguments += arguments.get(arguments.size()-1).toString();
	stringToReturn += "(" + stringArguments + ") " + returnType.toString() + "\n";

	for (Pair<String,Type> v : localVars)
            stringLocalVars = stringLocalVars + v.toString() + ", ";
	stringToReturn += stringLocalVars + "\n";

	stringToReturn += code.toString();
	
	return stringToReturn;
    }
}

class ProcDefinition extends Definition
{
    public ProcDefinition (String name, ArrayList<Pair<String,Type>> arguments, ArrayList<Pair<String,Type>> localVars, Instruction code) {
        this.name = name;
        this.arguments = arguments;
        this.localVars = localVars;
        this.code = code;
    }

    public String toString() {
	String stringArguments = "", stringLocalVars = "", stringToReturn = "";

	stringToReturn += name;

	for (int i = 0; i < arguments.size() - 1; i++)
            stringArguments = stringArguments + arguments.get(i).toString() + ", ";
	stringArguments += arguments.get(arguments.size()-1).toString();
	stringToReturn += "(" + stringArguments + ") \n";

	for (Pair<String,Type> v : localVars)
            stringLocalVars = stringLocalVars + v.toString() + "\n";
	stringToReturn += stringLocalVars + "\n";

	stringToReturn += code.toString();
	
	return stringToReturn;
    }
}

// Programmes
class Program
{
    ArrayList<Pair<String,Type>> globalVars;
    ArrayList<Definition> definitions;
    Instruction code;

    public Program(ArrayList<Pair<String,Type>> globalVars, ArrayList<Definition> definitions, Instruction code) {
        this.globalVars = globalVars;
        this.definitions = definitions;
        this.code = code;
    }

    public String toString() {
	String stringGlobalVars = "", stringDefinitions = "", stringToReturn = "";

	for (Pair<String,Type> v : globalVars)
            stringGlobalVars = stringGlobalVars + v.toString() + "\n";
	stringToReturn += stringGlobalVars + "\n";

	for (Definition d : definitions)
            stringDefinitions = stringDefinitions + d.toString() + ", ";
	stringToReturn += stringDefinitions + "\n";

	stringToReturn += code.toString();
	
	return stringToReturn;
    }
}

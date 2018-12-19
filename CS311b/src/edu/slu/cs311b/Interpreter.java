/**
 Original Grammar:
    <program> -> <start_program> <stmt_list> <end_program>
    <stmt_list> -> <stmt> <stmt_list’>
    <stmt_list’> -> <stmt> <stmt_list’>
    <stmt_list’> -> EPSILON
    <stmt> -> <declaration>
    <stmt> -> <assignment>
    <declaration> -> <data_type> <var> <end_symbol>
    <var> -> <iden>
    <data_type> -> <int_type>
    <data_type> -> <float_type>
    <data_type> -> <char_type>
    <data_type> -> <string_type>
    <data_type> -> <boolean_type>
    <assignment> -> <var> <assignment_sym> <value> <end_symbol>
    <value> -> <expr>
    <value> -> <string_value>
    <value> -> <boolean_value>
    <expr> -> <term> <expr’>
    <expr’> -> <operation> <term> <expr’>
    <expr’> -> EPSILON
    <term> -> <const>
    <term> -> <iden>
    <operation> -> <add>
    <operation> -> <minus>
    <operation> -> <multiply>
    <operation> -> <divide>
    <operation> -> <divide_float>
    <operation> -> <mod>
    <string_value> -> <string>
    <stmt> -> <if> <if_stmt>
    <if_stmt> -> <condition> <then> <stmt>
    <if_stmt> -> <boolean_value> <then> <stmt> 
    <condition> -> <term> <relational_op> <term>
    <boolean_value> -> <true>
    <boolean_value> -> <false>
    <relational_op> -> <lt>
    <relational_op> -> <gt>
    <relational_op> -> <le>
    <relational_op> -> <ge>
    <relational_op> -> <eq>
    <relational_op> -> <ne>
    <stmt> -> <while> <while_stmt>
    <while_stmt> -> <condition> <then> <stmt> 
    <while_stmt> -> <boolean_value> <then> <stmt>
    <stmt> -> <repeat_stmt>
    <repeat_stmt> -> <repeat> <stmt> <until> <condition>
    <stmt> -> <for_stmt>
    <for_stmt> -> <for> <term> <relational_op> <term> <stmt>
    <stmt> -> <input>
    <input> -> <read> <var> <end_symbol>
    <stmt> -> <print> <output>
    <output> -> <string> <end_symbol>
    <output> -> <var> <end_symbol>
 
 Predict Set:
    1	<program> → <start_program> <stmt_list> <end_program>	<start_program>
    2	<stmt_list> → <stmt> <stmt_list’>	<if>, <while>, <print>, <int_type>, <float_type>, <char_type>, <string_type>, <boolean_type>, <repeat>, <read>, <iden>, <for>
    3	<stmt_list’> → <stmt> <stmt_list’>	<if>, <while>, <print>, <int_type>, <float_type>, <char_type>, <string_type>, <boolean_type>, <repeat>, <read>, <iden>, <for>
    4	<stmt_list’> → ε	<end_program>
    5	<stmt> → <declaration>	<int_type>, <float_type>, <char_type>, <string_type>, <boolean_type>
    6	<stmt> → <assignment>	<iden>
    7	<stmt> → <if> <if_stmt>	<if>
    8	<stmt> → <while> <while_stmt>	<while>
    9	<stmt> → <repeat_stmt>	<repeat>
    10	<stmt> → <for_stmt>	<for>
    11	<stmt> → <input>	<read>
    12	<stmt> → <print> <output>	<print>
    13	<declaration> → <data_type> <var> <end_symbol>	<int_type>, <float_type>, <char_type>, <string_type>, <boolean_type>
    14	<var> → <iden>	<iden>
    15	<data_type> → <int_type>	<int_type>
    16	<data_type> → <float_type>	<float_type>
    17	<data_type> → <char_type>	<char_type>
    18	<data_type> → <string_type>	<string_type>
    19	<data_type> → <boolean_type>	<boolean_type>
    20	<assignment> → <var> <assignment_sym> <value> <end_symbol>	<iden>
    21	<value> → <expr>	<const>, <iden>
    22	<value> → <string_value>	<string>
    23	<value> → <boolean_value>	<true>, <false>
    24	<expr> → <term> <expr’>	<const>, <iden>
    25	<expr’> → <operation> <term> <expr’>	<add>, <minus>, <multiply>, <divide>, <divide_float>, <mod>
    26	<expr’> → ε	<end_symbol>
    27	<term> → <const>	<const>
    28	<term> → <iden>	<iden>
    29	<operation> → <add>	<add>
    30	<operation> → <minus>	<minus>
    31	<operation> → <multiply>	<multiply>
    32	<operation> → <divide>	<divide>
    33	<operation> → <divide_float>	<divide_float>
    34	<operation> → <mod>	<mod>
    35	<string_value> → <string>	<string>
    36	<if_stmt> → <condition> <then> <stmt>	<const>, <iden>
    37	<if_stmt> → <boolean_value> <then> <stmt>	<true>, <false>
    38	<condition> → <term> <relational_op> <term>	<const>, <iden>
    39	<boolean_value> → <true>	<true>
    40	<boolean_value> → <false>	<false>
    41	<relational_op> → <lt>	<lt>
    42	<relational_op> → <gt>	<gt>
    43	<relational_op> → <le>	<le>
    44	<relational_op> → <ge>	<ge>
    45	<relational_op> → <eq>	<eq>
    46	<relational_op> → <ne>	<ne>
    47	<while_stmt> → <condition> <then> <stmt>	<const>, <iden>
    48	<while_stmt> → <boolean_value> <then> <stmt>	<true>, <false>
    49	<repeat_stmt> → <repeat> <stmt> <until> <condition>	<repeat>
    50	<for_stmt> → <for> <term> <relational_op> <term> <stmt>	<for>
    51	<input> → <read> <var> <end_symbol>	<read>
    52	<output> → <string> <end_symbol>	<string>
    53	<output> → <var> <end_symbol>	<iden>
 */

package edu.slu.cs311b;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Interpreter {

    public static void interpret(Symbol root) {
        Program p = new Program(root);

        p.interpret();
    }
}

// Rule No. 1: <program> → <start_program> <stmt_list> <end_program>
class Program {
    
    Stmt_list stmt_list;
    
    public Program(Symbol lhs) {
        stmt_list = new Stmt_list(lhs.children.get(1));
    }

    public void interpret() {
        stmt_list.interpret();
    }
}

// Rule No. 2: <stmt_list> → <stmt> <stmt_list’>
class Stmt_list {
    Stmt stmt;
    Stmt_list_prime stmt_list_prime;
    
    public Stmt_list(Symbol lhs) {
        stmt = Stmt.construct(lhs.children.get(0));
        stmt_list_prime = Stmt_list_prime.construct(lhs.children.get(1));
    }
    
    public void interpret() {
        stmt.interpret();
        stmt_list_prime.interpret();
    }
}

abstract class Stmt_list_prime {
    public static Stmt_list_prime construct(Symbol sym) {
        switch (sym.ruleNo) {
            case 3:
                return new Stmt_list_prime_1(sym);

            case 4:
                return new Stmt_list_prime_2(sym);

            default:
                // do nothing
                return null;
        }
    }
    
    public abstract void interpret();
}

// Rule No. 3: <stmt_list’> → <stmt> <stmt_list’>
class Stmt_list_prime_1 extends Stmt_list_prime{
    Stmt stmt;
    Stmt_list_prime stmt_list_prime;
    
    public Stmt_list_prime_1(Symbol lhs) {
        stmt = Stmt.construct(lhs.children.get(0));
        stmt_list_prime = Stmt_list_prime.construct(lhs.children.get(1));
    }
    
    @Override
    public void interpret() {
        stmt.interpret();
        stmt_list_prime.interpret();
    }
}

// Rule No. 4: <stmt_list’> → ε
class Stmt_list_prime_2 extends Stmt_list_prime {

    public Stmt_list_prime_2(Symbol lhs) {
        // do nothing
    }
    
    @Override
    public void interpret() {
        // do nothing
    }
    
}

abstract class Stmt {

    public static Stmt construct(Symbol sym) {
        switch (sym.ruleNo) {
            case 5:
                return new Stmt_1(sym);
            case 6:
                return new Stmt_2(sym);
            case 7:
                return new Stmt_3(sym);
            case 8:
                return new Stmt_4(sym);
            case 9:
                return new Stmt_5(sym);
            case 10:
                return new Stmt_6(sym);
            case 11:
                return new Stmt_7(sym);
            case 12:
                return new Stmt_8(sym);
                   
            default:
                return null;
        }
    }

    public abstract void interpret();
}

// Rule No. 5: <stmt> → <declaration>
class Stmt_1 extends Stmt{
    
    Declaration declaration;
    
    public Stmt_1(Symbol lhs) {
        declaration = new Declaration(lhs.children.get(0));
    }
    
    @Override
    public void interpret() {
        declaration.interpret();
    }
}

// Rule No. 6: <stmt> → <assignment>
class Stmt_2 extends Stmt{
    
    Assignment assignment;
    
    public Stmt_2(Symbol lhs) {
        assignment = new Assignment(lhs.children.get(0));
    }
    
    @Override
    public void interpret() {
        assignment.interpret();
    }
}

// Rule No. 7: <stmt> → <if> <if_stmt>
class Stmt_3 extends Stmt {
    
    If_stmt if_stmt;
    
    public Stmt_3(Symbol lhs) {
        if_stmt = If_stmt.construct(lhs.children.get(1));
    }
    
    @Override
    public void interpret() {
        if_stmt.interpret();
    }
}

// Rule No. 8:	<stmt> → <while> <while_stmt>
class Stmt_4 extends Stmt {
    
    While_stmt while_stmt;
    
    public Stmt_4(Symbol lhs) {
        while_stmt = While_stmt.construct(lhs.children.get(1));
    }
    
    @Override
    public void interpret() {
        while_stmt.interpret();
    }
}

// Rule No. 9:	<stmt> → <repeat_stmt>
class Stmt_5 extends Stmt {
    
    Repeat_stmt repeat_stmt;
    
    public Stmt_5(Symbol lhs) {
        repeat_stmt = new Repeat_stmt(lhs.children.get(0));
    }
    
    @Override
    public void interpret() {
        repeat_stmt.interpret();
    }
}

// Rule No. 10:	<stmt> → <for_stmt>
class Stmt_6 extends Stmt {
    
    For_stmt for_stmt;
    
    public Stmt_6(Symbol lhs) {
        for_stmt = new For_stmt(lhs.children.get(0));
    }
    
    @Override
    public void interpret() {
        for_stmt.interpret();
    }
}

// Rule No. 11:	<stmt> → <input>
class Stmt_7 extends Stmt {
    
    Input input;
    
    public Stmt_7(Symbol lhs) {
        input = new Input(lhs.children.get(0));
    }
    
    @Override
    public void interpret() {
        input.interpret();
    }
}

// Rule No. 12:	<stmt> → <print> <output>
class Stmt_8 extends Stmt {
    
    Output output;
    
    public Stmt_8(Symbol lhs) {
        output = Output.construct(lhs.children.get(1));
    }
    
    @Override
    public void interpret() {
        output.interpret();
    }
}

// Rule No. 13: <declaration> → <data_type> <var> <end_symbol>
class Declaration {
    Data_type data_type;
    String iden;
    
    public Declaration(Symbol lhs) {
        data_type = Data_type.construct(lhs.children.get(0));
        iden = lhs.children.get(1).lexeme;
    }
    
    public void interpret() {
        Variable var = new Variable(iden, data_type.toString(), 1);
//        System.out.println(var.symbolTable.toString());
        System.out.println(data_type.toString() + " " + iden);
    }
}

abstract class Data_type {

    public static Data_type construct(Symbol sym) {
        switch (sym.ruleNo) {
            case 15:
                return new Data_type_1(sym);
            case 16:
                return new Data_type_2(sym);
            case 17:
                return new Data_type_3(sym);
            case 18:
                return new Data_type_4(sym);
            case 19:
                return new Data_type_5(sym);
                   
            default:
                return null;
        }
    }

    public abstract void interpret();
    
    public abstract String toString();
}

// Rule No. 15:	<data_type> → <int_type>
class Data_type_1 extends Data_type {
    
    String type;
    
    public Data_type_1(Symbol lhs) {
        type = lhs.children.get(0).lexeme;
    }
    
    @Override
    public void interpret() {
        System.out.println(type);
    }
    
    public String toString() {
        return "int";
    }
}
// Rule No. 16:	<data_type> → <float_type>
class Data_type_2 extends Data_type {
    
    String type;
    
    public Data_type_2(Symbol lhs) {
        type = lhs.children.get(0).lexeme;
    }
    
    @Override
    public void interpret() {
        
    }
    
    public String toString() {
        return "float";
    }
}

// Rule No. 17:	<data_type> → <char_type>
class Data_type_3 extends Data_type {
    
    String type;
    
    public Data_type_3(Symbol lhs) {
        type = lhs.children.get(0).lexeme;
    }
    
    @Override
    public void interpret() {
        
    }
    
    public String toString() {
        return "char";
    }
}

// Rule No. 18:	<data_type> → <string_type>
class Data_type_4 extends Data_type {
    
    String type;
    
    public Data_type_4(Symbol lhs) {
        type = lhs.children.get(0).lexeme;
    }
    
    @Override
    public void interpret() {
        
    }
    
    public String toString() {
        return "String";
    }
}

// Rule No. 19:	<data_type> → <boolean_type>
class Data_type_5 extends Data_type {
    
    String type;
    
    public Data_type_5(Symbol lhs) {
        type = lhs.children.get(0).lexeme;
    }
    
    @Override
    public void interpret() {
        
    }
    
    public String toString() {
        return "boolean";
    }
}

// Rule No. 20: <assignment> → <var> <assignment_sym> <value> <end_symbol>
class Assignment {
    String var;
    
    public Assignment(Symbol lhs) {
        
    }
    
    public void interpret() {
        
    }
}

// Rule No. 21: <value> → <expr>
// Rule No. 22: <value> → <string_value>	
// Rule No. 23: <value> → <boolean_value>	
// Rule No. 24: <expr> → <term> <expr’>	
// Rule No. 25: <expr’> → <operation> <term> <expr’>
// Rule No. 26: <expr’> → ε

abstract class Term {
    public static Term construct(Symbol sym) {
        switch (sym.ruleNo) {
            case 27:
                return new Term_1(sym);
            case 28:
                return new Term_2(sym);
                   
            default:
                return null;
        }
    }

    public abstract void interpret();
}

// Rule No. 27: <term> → <const>
class Term_1 extends Term{
    int con;
    
    public Term_1(Symbol lhs) {
        con = Integer.parseInt(lhs.children.get(0).lexeme);
    }
    
    @Override
    public void interpret() {
        
    }
}

// Rule No. 28: <term> → <iden>
class Term_2 extends Term{
    String iden;
    
    public Term_2(Symbol lhs) {
        iden = lhs.children.get(0).lexeme;
    }
    
    @Override
    public void interpret() {
        
    }
}

// Rule No. 29: <operation> → <add>
// Rule No. 30: <operation> → <minus>
// Rule No. 31: <operation> → <multiply
// Rule No. 32: <operation> → <divide>
// Rule No. 33: <operation> → <divide_float>
// Rule No. 34: <operation> → <mod>
// Rule No. 35: <string_value> → <string>

abstract class If_stmt {
    public static If_stmt construct(Symbol sym) {
        switch (sym.ruleNo) {
            case 36:
                return new If_stmt_1(sym);
            case 37:
                return new If_stmt_2(sym);
                   
            default:
                return null;
        }
    }

    public abstract void interpret();
}

// Rule No. 36: <if_stmt> → <condition> <then> <stmt>
class If_stmt_1 extends If_stmt{
    
    Condition condition;
    Stmt stmt;
    
    public If_stmt_1(Symbol lhs) {
        condition = new Condition(lhs.children.get(0));
        stmt = Stmt.construct(lhs.children.get(2));
    }
    
    public void interpret() {
        condition.interpret();
        stmt.interpret();
    }
}
        
// Rule No. 37: <if_stmt> → <boolean_value> <then> <stmt>
class If_stmt_2 extends If_stmt{
    
    Boolean_value boolean_value;
    Stmt stmt;
    
    public If_stmt_2(Symbol lhs) {
        boolean_value = Boolean_value.construct(lhs.children.get(0));
        stmt = Stmt.construct(lhs.children.get(2));
    }
    
    public void interpret() {
        boolean_value.interpret();
        stmt.interpret();
    }
}
        
// Rule No. 38: <condition> → <term> <relational_op> <term>
class Condition {
    Term term1;
    String relational_op;
    Term term2;
    
    public Condition(Symbol lhs) {
        term1 = Term.construct(lhs.children.get(0));
        relational_op = lhs.children.get(1).lexeme;
        term2 = Term.construct(lhs.children.get(2));
    }
    
    public void interpret() {
        term1.interpret();
        
    }
}

abstract class Boolean_value {
    public static Boolean_value construct(Symbol sym) {
        switch (sym.ruleNo) {
            case 39:
                return new Boolean_value_1(sym);
            case 40:
                return new Boolean_value_2(sym);
                   
            default:
                return null;
        }
    }

    public abstract void interpret();
}

// Rule No. 39: <boolean_value> → <true>
class Boolean_value_1 extends Boolean_value {
    String val;
    
    public Boolean_value_1(Symbol lhs) {
        val = lhs.children.get(0).lexeme;
    }
    
    @Override
    public void interpret() {
        
    }
}

// Rule No. 40: <boolean_value> → <false>
class Boolean_value_2 extends Boolean_value {
    String val;
    
    public Boolean_value_2(Symbol lhs) {
        val = lhs.children.get(0).lexeme;
    }
    
    @Override
    public void interpret() {
        
    }
}

abstract class Relational_op {
    public static Relational_op construct(Symbol sym) {
        switch (sym.ruleNo) {
            case 41:
                return new Relational_op_1(sym);
            case 42:
                return new Relational_op_2(sym);
            case 43:
                return new Relational_op_3(sym);
            case 44:
                return new Relational_op_4(sym);
            case 45:
                return new Relational_op_5(sym);
            case 46:
                return new Relational_op_6(sym);
            default:
                return null;
        }
    }

    public abstract void interpret();
}

// Rule No. 41: <relational_op> → <lt>
class Relational_op_1 extends Relational_op{
    
    String op;
    
    public Relational_op_1(Symbol lhs) {
        op = lhs.children.get(0).lexeme;
    }
    
    @Override
    public void interpret() {
        
    }
}

// Rule No. 42: <relational_op> → <gt>
class Relational_op_2 extends Relational_op{
    
    String op;
    
    public Relational_op_2(Symbol lhs) {
        op = lhs.children.get(0).lexeme;
    }
    
    @Override
    public void interpret() {
        
    }
}

// Rule No. 43: <relational_op> → <le>
class Relational_op_3 extends Relational_op{
    
    String op;
    
    public Relational_op_3(Symbol lhs) {
        op = lhs.children.get(0).lexeme;
    }
    
    @Override
    public void interpret() {
        
    }
}

// Rule No. 44: <relational_op> → <ge>
class Relational_op_4 extends Relational_op{
    
    String op;
    
    public Relational_op_4(Symbol lhs) {
        op = lhs.children.get(0).lexeme;
    }
    
    @Override
    public void interpret() {
        
    }
}

// Rule No. 45: <relational_op> → <eq>
class Relational_op_5 extends Relational_op{
    
    String op;
    
    public Relational_op_5(Symbol lhs) {
        op = lhs.children.get(0).lexeme;
    }
    
    @Override
    public void interpret() {
        
    }
}

// Rule No. 46: <relational_op> → <ne>
class Relational_op_6 extends Relational_op{
    
    String op;
    
    public Relational_op_6(Symbol lhs) {
        op = lhs.children.get(0).lexeme;
    }
    
    @Override
    public void interpret() {
        
    }
}

abstract class While_stmt {
    public static While_stmt construct(Symbol sym) {
        switch (sym.ruleNo) {
            case 47:
                return new While_stmt_1(sym);
            case 48:
                return new While_stmt_2(sym);
                   
            default:
                return null;
        }
    }

    public abstract void interpret();
}

// Rule No. 47: <while_stmt> → <condition> <then> <stmt>
class While_stmt_1 extends While_stmt{
    
    Condition condition;
    Stmt stmt;
    
    public While_stmt_1(Symbol lhs) {
        condition = new Condition(lhs.children.get(0));
        stmt = Stmt.construct(lhs.children.get(2));
    }
    
    @Override
    public void interpret() {
        condition.interpret();
        stmt.interpret();
    }
}

// Rule No. 48: <while_stmt> → <boolean_value> <then> <stmt>
class While_stmt_2 extends While_stmt {
    Boolean_value boolean_value;
    Stmt stmt;
    
    public While_stmt_2(Symbol lhs) {
        boolean_value = Boolean_value.construct(lhs.children.get(0));
        stmt = Stmt.construct(lhs.children.get(2));
    }
    
    @Override
    public void interpret() {
        
        stmt.interpret();
    }
}

// Rule No. 49: <repeat_stmt> → <repeat> <stmt> <until> <condition>
class Repeat_stmt {
    
    Stmt stmt;
    Condition condition;
    
    public Repeat_stmt(Symbol lhs) {
        stmt = Stmt.construct(lhs.children.get(1));
        condition = new Condition(lhs.children.get(3));
    }
    
    public void interpret() {
        stmt.interpret();
        condition.interpret();
    }
}

// Rule No. 50: <for_stmt> → <for> <term> <relational_op> <term> <stmt>
class For_stmt {
    
    Term term1;
    Relational_op relational_op;
    Term term2;
    
    public For_stmt(Symbol lhs) {
        relational_op = Relational_op.construct(lhs.children.get(2));   
    } 
    
    public void interpret() {
        relational_op.interpret();
    }
    
}

// Rule No. 51: <input> → <read> <var> <end_symbol>
class Input {
    String var;
    
    public Input(Symbol lhs) {
        var = lhs.children.get(1).lexeme;
    }
    
    public void interpret() {
        
    }
}

abstract class Output {
    public static Output construct(Symbol sym) {
        switch (sym.ruleNo) {
            case 52:
                return new Output_1(sym);
            case 53:
                return new Output_2(sym);
                   
            default:
                return null;
        }
    }

    public abstract void interpret();
}

// Rule No. 52: <output> → <string> <end_symbol>
class Output_1 extends Output{
    
    String str;
    
    public Output_1(Symbol lhs) {
        str = lhs.children.get(0).lexeme;
    }
    
    @Override
    public void interpret() {
        System.out.println(str);
    }
}

// Rule No. 53: <output> → <var> <end_symbol>
class Output_2 extends Output{
    
    String str;
    
    public Output_2(Symbol lhs) {
        str = lhs.children.get(0).lexeme;
    }
    
    @Override
    public void interpret() {
        System.out.println(str);
    }
}


// Rule No. ?: ....
class Expr1 {
    // DO NOT DELETE.
    // Use this class can evaluation arithmetic, relational or logical expressions
    // Just change the case labels/selectable segments in the switch statement to suit your programming langauge

    // See usage in LINE 192 and LINE 203 in MyInterpreter.java for your reference
       
    
    LinkedList<Symbol> expression;
    Stack<Integer> operands = new Stack();

    public Expr1(Symbol lhs) {
        expression = Expression.getExpression(lhs);
    }

    public int interpret() {
        Variable var;
        int result = 0;

        while (!expression.isEmpty()) {
            Symbol sym = expression.removeFirst();

            switch (sym.type) {
                // sym is an operand
                case "<const>":
                    operands.push(Integer.parseInt(sym.lexeme));
                    break;

                case "<iden>":
                    var = Variable.symbolTable.get(sym.lexeme);

                    operands.push((Integer) var.value);
                    break;

                // sym is an operator
                default:
                    int operand2 = operands.pop();
                    int operand1 = operands.pop();

                    switch (sym.lexeme) {
                        case "+":
                            operands.push(operand1 + operand2);
                            break;

                        case "-":
                            operands.push(operand1 - operand2);
                            break;

                        case "*":
                            operands.push(operand1 * operand2);
                            break;

                        case "/":
                            operands.push(operand1 / operand2);
                            break;
                    }
            }
        }

        return operands.pop();
    }
}
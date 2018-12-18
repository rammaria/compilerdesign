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
        if_stmt = new If_stmt(lhs.children.get(1));
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
        while_stmt = new While_stmt(lhs.children.get(1));
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
        for_stmt = new For_Stmt(lhs.children.get(0));
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
        output = new Output(lhs.children.get(1));
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
        iden = lhs.children.get(1).lexeme;
    }
    
    // TODO
    public void interpret() {
        
    }
}

abstract class Data_type {

    public static Stmt construct(Symbol sym) {
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
}

// Rule No. 15:	<data_type> → <int_type>
class Data_type_1 extends Data_type {
    
    String type;
    
    public Data_type_1(Symbol lhs) {
        type = lhs.children.get(0).lexeme;
    }
    
    @Override
    public void interpret() {
        
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
}

// Rule No. 20: <assignment> → <var> <assignment_sym> <value> <end_symbol>
class Assignment {
    String var;
    
    public Assignment(Symbol lhs) {
        
    }
    
    public void interpret() {
        
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

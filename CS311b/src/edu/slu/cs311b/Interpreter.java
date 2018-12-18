/**
 Original Grammar:
    <program> -> <start_program> <stmt_list> <end_program>
    <stmt_list> -> <stmt> <stmt_list’>
    <stmt_list’> -> <stmt> <stmt_list’>
    <stmt_list’> -> EPSILON
    <stmt> -> <declaration>
    <stmt> -> <assignment>
    <declaration> -> <data_type> <var_list> <end_symbol>
    <var_list> -> <var> <var_list’>
    <var_list’> -> <comma> <var> <var_list’>
    <var_list’> -> EPSILON
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
   13	<declaration> → <data_type> <var_list> <end_symbol>	<int_type>, <float_type>, <char_type>, <string_type>, <boolean_type>
   14	<var_list> → <var> <var_list’>	<iden>
   15	<var_list’> → <comma> <var> <var_list’>	<comma>
   16	<var_list’> → ε	<end_symbol>
   17	<var> → <iden>	<iden>
   18	<data_type> → <int_type>	<int_type>
   19	<data_type> → <float_type>	<float_type>
   20	<data_type> → <char_type>	<char_type>
   21	<data_type> → <string_type>	<string_type>
   22	<data_type> → <boolean_type>	<boolean_type>
   23	<assignment> → <var> <assignment_sym> <value> <end_symbol>	<iden>
   24	<value> → <expr>	<const>, <iden>
   25	<value> → <string_value>	<string>
   26	<value> → <boolean_value>	<true>, <false>
   27	<expr> → <term> <expr’>	<const>, <iden>
   28	<expr’> → <operation> <term> <expr’>	<add>, <minus>, <multiply>, <divide>, <divide_float>, <mod>
   29	<expr’> → ε	<end_symbol>
   30	<term> → <const>	<const>
   31	<term> → <iden>	<iden>
   32	<operation> → <add>	<add>
   33	<operation> → <minus>	<minus>
   34	<operation> → <multiply>	<multiply>
   35	<operation> → <divide>	<divide>
   36	<operation> → <divide_float>	<divide_float>
   37	<operation> → <mod>	<mod>
   38	<string_value> → <string>	<string>
   39	<if_stmt> → <condition> <then> <stmt>	<const>, <iden>
   40	<if_stmt> → <boolean_value> <then> <stmt>	<true>, <false>
   41	<condition> → <term> <relational_op> <term>	<const>, <iden>
   42	<boolean_value> → <true>	<true>
   43	<boolean_value> → <false>	<false>
   44	<relational_op> → <lt>	<lt>
   45	<relational_op> → <gt>	<gt>
   46	<relational_op> → <le>	<le>
   47	<relational_op> → <ge>	<ge>
   48	<relational_op> → <eq>	<eq>
   49	<relational_op> → <ne>	<ne>
   50	<while_stmt> → <condition> <then> <stmt>	<const>, <iden>
   51	<while_stmt> → <boolean_value> <then> <stmt>	<true>, <false>
   52	<repeat_stmt> → <repeat> <stmt> <until> <condition>	<repeat>
   53	<for_stmt> → <for> <term> <relational_op> <term> <stmt>	<for>
   54	<input> → <read> <var> <end_symbol>	<read>
   55	<output> → <string> <end_symbol>	<string>
   56	<output> → <var> <end_symbol>	<iden>
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

// Rule No. 1: <program> → ...
class Program {
    
    Stmt_list stmt_list;
    
    public Program(Symbol lhs) {
        stmt_list = new Stmt_list(lhs.children.get(1));
    }

    public void interpret() {
        stmt_list.interpret();
    }
}

class Stmt_list {
    Stmt stmt;
    Stmt_list_prime stmt_list_prime;
    
    public Stmt_list(Symbol lhs) {
        stmt = new Stmt(lhs.children.get(0));
        stmt_list_prime = new Stmt_list_prime(lhs.children.get(1));
    }
    
    public void interpret() {
        stmt.interpret();
        stmt_list_prime.interpret();
    }
}

class Stmt_list_prime {
    public Stmt_list_prime(Symbol lhs) {
        
    }
    
    public void interpret() {
        
    }
}


class Stmt {
    public Stmt(Symbol lhs) {
        
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

// Rule No. 14: <declaration> → <var> <iden> <colon> <type> <initial_value> <semi>
class Declaration {

    Symbol iden;
    Symbol type;
    Initial_value initial_value;

    public Declaration(Symbol lhs) {
        iden = lhs.children.get(1);
        type = lhs.children.get(3);
        initial_value = Initial_value.construct(lhs.children.get(4));
    }

    public void interpret() {
        Variable v = new Variable(iden.lexeme, type.lexeme, 0);
        v.value = initial_value.interpret();

        System.out.println("\t" + Variable.symbolTable);
    }
}

abstract class Initial_value {

    public static Initial_value construct(Symbol sym) {
        switch (sym.ruleNo) {
            case 15:
                return new Initial_value1(sym);

            case 16:
                return new Initial_value2(sym);

            default:
                return null;
        }
    }

    public abstract Object interpret();
}

// Rule No. 15: <initial_value> → <eq> <term>
class Initial_value1 extends Initial_value {

    Term term;

    public Initial_value1(Symbol lhs) {
        term = Term.construct(lhs.children.get(1));
    }

    @Override
    public Object interpret() {
        return term.interpret();
    }
}

// Rule No. 16: <initial_value> → ε
class Initial_value2 extends Initial_value {

    public Initial_value2(Symbol lhs) {
        // rhs is EPSILON - default to null(???)
    }

    @Override
    public Object interpret() {
        return null;
    }
}

abstract class Term {

    public static Term construct(Symbol sym) {
        switch (sym.ruleNo) {
            case 17:
                return new Term1(sym);

            case 18:
                return new Term2(sym);

            default:
                return null;
        }
    }

    public abstract Object interpret();
}

// Rule No. 17: <term> → <iden>
class Term1 extends Term {

    Variable iden;

    public Term1(Symbol lhs) {
        iden = Variable.symbolTable.get(lhs.children.get(0).lexeme);
    }

    public Object interpret() {
        return iden.value;
    }
}

// Rule No. 18: <term> → <const>
class Term2 extends Term {

    String const1;

    public Term2(Symbol lhs) {
        const1 = lhs.children.get(0).lexeme;
    }

    @Override
    public Object interpret() {
        return Integer.parseInt(const1);
    }
}

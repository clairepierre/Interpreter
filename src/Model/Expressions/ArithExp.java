package Model.Expressions;

import Model.DataStructures.IHeap;
import Model.DataStructures.MyIDict;
import Model.Exceptions.MyExprEvalExcep;

public class ArithExp extends Expression {
    Expression exp1;
    Expression exp2;
    String op;

    public ArithExp(Expression exp1,Expression exp2, String op)
    {
        this.exp1=exp1;
        this.exp2=exp2;
        this.op=op;
    }

    @Override
    public int eval(MyIDict<String,Integer> symTable, IHeap heap) throws MyExprEvalExcep
    {
        switch(op)
        {
            case "+":
            {
                return exp1.eval(symTable,heap)+ exp2.eval(symTable,heap);
            }
            case "-":
            {
                return exp1.eval(symTable,heap)-exp2.eval(symTable,heap);
            }
            case "*":
            {
                return exp1.eval(symTable,heap)*exp2.eval(symTable,heap);
            }
            case "/":
            {
                if (exp2.eval(symTable,heap)==0)
                    throw new MyExprEvalExcep("Division by zero!\n");
                return exp1.eval(symTable,heap)/exp2.eval(symTable,heap);
            }
            default:
            {
                throw new MyExprEvalExcep("Invalid operand!\n");
            }

        }
    }

    @Override
    public  String toString()
    {
        switch(op)
        {
            case "+":
            {
                return exp1.toString()+"+"+exp2.toString();
            }
            case "-":
            {
                return exp1.toString()+"-"+exp2.toString();
            }
            case "*":
            {
                return exp1.toString()+"*"+exp2.toString();
            }
            case "/":
            {
                return exp1.toString()+"/"+exp2.toString();
            }
            default:
            {
                return "Invalid operand!";
            }

        }

    }
}

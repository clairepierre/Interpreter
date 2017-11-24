package Model.Statements;

import Model.DataStructures.MyIList;
import Model.Exceptions.MyExprEvalExcep;
import Model.Expressions.Expression;
import Model.PrgState;

public class PrintStmt implements IStmt {
    private Expression exp;

    public PrintStmt(Expression e){exp=e;}

    @Override
    public PrgState execute(PrgState state) throws Exception
    {
        MyIList<Integer> out= state.getOut();
        try
        {
            out.add(exp.eval(state.getSymTable(),state.getHeap()));
        }
        catch (MyExprEvalExcep e)
        {
            throw e;
        }
        state.setOut(out);
        return state;
    }

    @Override
    public String toString()
    {
        return "print("+exp.toString()+")";
    }
}

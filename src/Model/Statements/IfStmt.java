package Model.Statements;

import Model.DataStructures.MyIStack;
import Model.Exceptions.MyExprEvalExcep;
import Model.Expressions.Expression;
import Model.PrgState;

public class IfStmt implements IStmt{
    private Expression exp;
    private IStmt thenStmt;
    private IStmt elseStmt;

    public IfStmt(Expression ex, IStmt th, IStmt el)
    {
        exp=ex;
        thenStmt=th;
        elseStmt=el;
    }

    @Override
    public PrgState execute (PrgState state) throws Exception
    {
        MyIStack<IStmt> stk =state.getExeStack();
        try
        {
            if(exp.eval(state.getSymTable(),state.getHeap())!=0)
                stk.push(thenStmt);
            else stk.push(elseStmt);
        }
        catch (MyExprEvalExcep e)
        {
            throw e;
        }
        state.setExeStack(stk);
        return state;
    }

    @Override
    public String toString()
    {
        return "IF("+exp.toString()+")THEN("+thenStmt.toString()+")ELSE("+elseStmt.toString()+")";
    }
}

package Model.Statements;

import Model.DataStructures.IHeap;
import Model.DataStructures.MyIDict;
import Model.Expressions.Expression;
import Model.PrgState;

public class AssignStmt implements IStmt
{
    private String var;
    private Expression exp;

    public AssignStmt(String var,Expression e)
    {
        this.var=var;
        this.exp=e;
    }

    @Override
    public PrgState execute(PrgState state) throws Exception
    {
        MyIDict<String,Integer> dict =state.getSymTable();
        IHeap heap =state.getHeap();
        dict.setValue(var,exp.eval(dict,heap));
        state.setSymTable(dict);
        return state;
    }
    @Override
    public String toString()
    {
        return var+"="+exp.toString();
    }
}

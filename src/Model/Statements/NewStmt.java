package Model.Statements;

import Model.DataStructures.IHeap;
import Model.DataStructures.MyIDict;
import Model.Exceptions.MyExprEvalExcep;
import Model.Expressions.Expression;
import Model.PrgState;

public class NewStmt implements IStmt {
    private String var_name;
    private Expression exp;

    public NewStmt(String name,Expression exp)
    {
        this.var_name=name;
        this.exp=exp;
    }


    @Override
    public PrgState execute(PrgState state) throws Exception {

        try
        {
            IHeap heap =state.getHeap();
            MyIDict<String,Integer>symTable =state.getSymTable();
            int j=exp.eval(symTable,heap);
            int i =heap.getKey();
            symTable.setValue(var_name,i);
            heap.setValue(j);
        }
        catch(MyExprEvalExcep e)
        {
            throw e;
        }
        return state;
    }

    @Override
    public String toString()
    {
        return "new("+var_name+","+exp.toString()+")";
    }
}

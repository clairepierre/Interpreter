package Model.Statements;

import Model.DataStructures.IHeap;
import Model.DataStructures.MyIDict;
import Model.Expressions.Expression;
import Model.PrgState;

public class wHStmt implements IStmt {

    private String variable;
    private Expression newV;

    public wHStmt(String variable,Expression newV) {
        this.variable = variable;
        this.newV = newV;
    }

    @Override
    public PrgState execute(PrgState state) throws Exception {
        MyIDict<String, Integer> symTable=state.getSymTable();
        IHeap heap=state.getHeap();
        try {
            int i = symTable.lookUp(variable);
            int v=newV.eval(symTable,heap);
            if (heap.containKey(i))
            {
                heap.updateHeap(i,v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return state;
    }

    public String toString()
    {
        return "wH("+variable+","+newV.toString()+")";
    }
}

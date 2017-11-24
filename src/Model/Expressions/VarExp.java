package Model.Expressions;

import Model.DataStructures.IHeap;
import Model.DataStructures.MyIDict;
import Model.Exceptions.MyExprEvalExcep;

public class VarExp extends Expression{
    private String var;

    public VarExp(String var) {
        this.var = var;
    }

    @Override
    public int eval(MyIDict<String,Integer> symTable, IHeap heap) throws MyExprEvalExcep {
        int i = symTable.lookUp(var);

        if (heap.containValue(i)) {
            try {
                return heap.lookUp(i);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return i;
    }

    @Override
    public String toString()
    {
        return var;
    }
}

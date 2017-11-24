package Model.Expressions;

import Model.DataStructures.IHeap;
import Model.DataStructures.MyIDict;
import Model.Exceptions.MyExprEvalExcep;

public class wH extends Expression{
    private String variable;
    private Expression newV;

    public wH(String variable,Expression newV)
    {
        this.variable=variable;
        this.newV=newV;
    }

    @Override
    public int eval(MyIDict<String, Integer> symTable, IHeap heap) throws MyExprEvalExcep {
        try {
            int i = symTable.lookUp(variable);
            int v=newV.eval(symTable,heap);
            if (heap.containKey(i))
            {
                heap.updateHeap(i,v);
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public String toString()
    {
        return "wH("+variable+","+newV.toString()+")";
    }
}

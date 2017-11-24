package Model.Expressions;

import Model.DataStructures.IHeap;
import Model.DataStructures.MyIDict;
import Model.Exceptions.MyExprEvalExcep;

public class rH extends Expression {
    private String variable;
    public rH(String var){variable=var;}

    @Override
    public int eval(MyIDict<String, Integer> symTable, IHeap heap) throws MyExprEvalExcep {

        try {
            int i = symTable.lookUp(variable);
            return heap.lookUp(i);
            } catch (Exception e) {
                e.printStackTrace();
            }

        return 0;
    }
    public String toString()
    {
        return "rH("+variable+")";
    }
}

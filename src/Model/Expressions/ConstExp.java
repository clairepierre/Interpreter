package Model.Expressions;

import Model.DataStructures.IHeap;
import Model.DataStructures.MyIDict;
import Model.Exceptions.MyExprEvalExcep;

public class ConstExp extends Expression {
    private int value;
    public ConstExp(int value){this.value =value;}

    @Override
    public int eval(MyIDict<String,Integer> symTable, IHeap heap) throws MyExprEvalExcep
    {
        return value;
    }

    @Override
    public String toString()
    {
        return Integer.toString(value);
    }
}

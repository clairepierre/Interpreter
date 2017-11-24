package Model.Expressions;

import Model.DataStructures.IHeap;
import Model.DataStructures.MyIDict;
import Model.Exceptions.MyExprEvalExcep;

public abstract class Expression {
    public abstract int eval(MyIDict<String,Integer> symTable, IHeap heap) throws MyExprEvalExcep;
}

package Model.DataStructures;

import Model.Exceptions.MyExprEvalExcep;

import java.util.Map;

public interface MyIDict <T1,T2> {
    T2 lookUp(T1 key) throws MyExprEvalExcep;
    void setValue(T1 key, T2 value);
    Map getContent();
}

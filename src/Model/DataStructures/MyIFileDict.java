package Model.DataStructures;

import Model.Exceptions.MyExprEvalExcep;
import Model.Tuple;

public interface MyIFileDict {
    void addVariable(String filename) throws MyExprEvalExcep;
    Tuple lookUp(int var) throws MyExprEvalExcep;
    int getDescriptor(String filename);
    void deleteFile(String file) throws MyExprEvalExcep;
    String toString();

}

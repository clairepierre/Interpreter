package Model.Statements;

import Model.Exceptions.MyExprEvalExcep;
import Model.PrgState;

public class OpenRFile implements IStmt {
    private String var_file_id;
    private String filename;

    public OpenRFile(String var_file_id,String filename)
    {
        this.filename=filename;
        this.var_file_id=var_file_id;
    }

    @Override
    public PrgState execute(PrgState state) throws MyExprEvalExcep {
        if(state.getFileTable().getDescriptor(filename)!=0)
            throw new MyExprEvalExcep("File already opened!");
        state.getFileTable().addVariable(filename);
        state.getSymTable().setValue(var_file_id,state.getFileTable().getDescriptor(filename));
        return state;
    }

    @Override
    public String toString(){
        return "openRFile("+var_file_id+",\""+filename+"\")";
    }
}

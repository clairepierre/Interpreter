package Model.Statements;

import Model.Exceptions.MyExprEvalExcep;
import Model.Expressions.Expression;
import Model.PrgState;
import Model.Tuple;

import java.io.IOException;

public class CloseRFile implements IStmt {
    private Expression exp_file_id;

    public CloseRFile(Expression exp)
    {
        exp_file_id=exp;
    }

    @Override
    public PrgState execute(PrgState state) throws Exception
    {
        int desc=exp_file_id.eval(state.getSymTable(),state.getHeap());
        Tuple file=state.getFileTable().lookUp(desc);
        try {
            file.getFile().close();
        }catch (IOException e){
            throw new MyExprEvalExcep(e.toString());
        }
        state.getFileTable().deleteFile(file.getFilename());
        return state;
    }

    public String toString(){
        return "closeRFile("+exp_file_id+")";
    }


}

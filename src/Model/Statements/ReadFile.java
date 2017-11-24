package Model.Statements;

import Model.Exceptions.MyExprEvalExcep;
import Model.Expressions.ConstExp;
import Model.Expressions.Expression;
import Model.PrgState;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadFile implements IStmt {
    private Expression exp_file_id;
    private String var_name;
    public ReadFile(Expression exp,String name)
    {
        this.exp_file_id=exp;
        this.var_name=name;
    }

    @Override
    public PrgState execute(PrgState state) throws Exception
    {
        int desc=exp_file_id.eval(state.getSymTable(),state.getHeap());
        BufferedReader buff;
        try
        {
            buff = state.getFileTable().lookUp(desc).getFile();
        }
        catch(MyExprEvalExcep e)
        {
            throw new MyExprEvalExcep("Variable "+exp_file_id+" not defined!");
        }
        try
        {
            String line = buff.readLine();
            if (line == null)
            {
                AssignStmt stmt = new AssignStmt(var_name, new ConstExp(0));
                try
                {
                    stmt.execute(state);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                return state;
            }
            else
            {
                Integer val = Integer.parseInt(line);
                AssignStmt stmt = new AssignStmt(var_name, new ConstExp(val));
                try {
                    stmt.execute(state);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return state;
            }
        }
        catch(IOException e)
        {
            throw new MyExprEvalExcep(e.toString());
        }
    }
    @Override
    public String toString() {
        return "readFile("+exp_file_id+","+var_name+")";
    }
}

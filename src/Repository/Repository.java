package Repository;

import Model.PrgState;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Repository implements RepositoryInterface{
    String logFilePath;
    PrintWriter logFile;
    private ArrayList<PrgState> elems;
    public Repository(){elems= new ArrayList<>();}
    public Repository(String logFilePath){this.logFilePath=logFilePath;elems= new ArrayList<>();}

    @Override
    public PrgState getCrtPrg(){return elems.get(elems.size()-1);}

    @Override
    public void addNewPrg(PrgState prg){elems.add(prg);}

    @Override
    public void logPrgStateExec() {
        try {
            logFile=new PrintWriter(new BufferedWriter(new FileWriter(getLogFilePath(),true)));
            logFile.write(getCrtPrg().toString());
            logFile.flush();
        }
        catch(Exception e)
        {

            System.out.println(e);

        }
        logFile.close();

    }

    @Override
    public String getLogFilePath() {
        return logFilePath;
    }

}

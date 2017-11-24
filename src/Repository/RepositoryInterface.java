package Repository;

import Model.PrgState;

public interface RepositoryInterface {
    PrgState getCrtPrg();
    void addNewPrg(PrgState prg);
    void logPrgStateExec();
    String getLogFilePath();

}

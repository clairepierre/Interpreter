package Controller;

import Model.DataStructures.MyIStack;
import Model.Exceptions.MyException;

import Model.PrgState;
import Model.Statements.IStmt;
import Repository.RepositoryInterface;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller
{
    private RepositoryInterface repo;

    public Controller(RepositoryInterface repo){this.repo=repo;}

    Map<Integer,Integer> conservativeGarbageCollector(Collection<Integer> symTableValues,Map<Integer,Integer> heap)
    {
        return heap.entrySet().stream()
                .filter(e->symTableValues.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private PrgState oneStep(PrgState state) throws Exception
    {
        MyIStack<IStmt> stk=state.getExeStack();
        if(stk.isEmpty())
            throw new MyException("Program finished!\n");
        IStmt crtStmt=stk.pop();
        return crtStmt.execute(state);
    }

    public void allSteps() throws Exception {
        PrgState prg=repo.getCrtPrg();
        MyIStack<IStmt> stack=prg.getExeStack();
        System.out.println(prg);
        while(! stack.isEmpty())
        {
            PrgState newPrg= oneStep(prg);
            prg.getHeap().setContent(conservativeGarbageCollector(
                    prg.getSymTable().getContent().values(),
                    prg.getHeap().getContent()));
            repo.logPrgStateExec();
        }
    }

}

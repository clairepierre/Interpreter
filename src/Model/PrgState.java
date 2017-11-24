package Model;

import Model.DataStructures.*;
import Model.Statements.IStmt;

public class PrgState {

    private MyIFileDict fileTable;
    private MyIStack<IStmt> exeStack;
    private MyIDict<String,Integer> symTable;
    private MyIList<Integer> out;
    private IHeap heap;
    private IStmt initialPrg;




    public PrgState(MyIStack<IStmt> exeStack, MyIDict<String,Integer> symTable, MyIList<Integer> out, IStmt initialPrg, MyIFileDict fileTable, IHeap heap)
    {
        this.fileTable=fileTable;
        this.exeStack=exeStack;
        this.symTable = symTable;
        this.out = out;
        this.initialPrg = initialPrg;
        this.heap=heap;
        exeStack.push(initialPrg);
    }

    @Override
    public String toString()
    {
        return "ExeStack="+exeStack.toString()+"\nSymTable="+symTable.toString()+"\nOut="+out.toString()+"\n"+ "FileTable:\n"+fileTable.toString()+"\n"+"Heap:"+heap.toString()+"\n";
    }

    public MyIStack<IStmt> getExeStack() {
        return exeStack;
    }

    public void setExeStack(MyIStack<IStmt> exeStack) {
        this.exeStack = exeStack;
    }

    public MyIDict<String, Integer> getSymTable() {
        return symTable;
    }

    public void setSymTable(MyIDict<String, Integer> symTable) {
        this.symTable = symTable;
    }

    public MyIList<Integer> getOut() {
        return out;
    }

    public void setOut(MyIList<Integer> out) {
        this.out = out;
    }

    public MyIFileDict getFileTable() {
        return fileTable;
    }

    public void setFileTable(MyIFileDict fileTable) {
        this.fileTable = fileTable;
    }

    public IHeap getHeap() {
        return heap;
    }

    public void setHeap(IHeap heap) {
        this.heap = heap;
    }
}

package Main;

import Controller.Controller;
import Model.DataStructures.*;
import Model.Expressions.ArithExp;
import Model.Expressions.ConstExp;
import Model.Expressions.VarExp;
import Model.PrgState;
import Model.Statements.*;
import Repository.Repository;
import Repository.RepositoryInterface;
import View.Interpreter;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Interpreter.main(args);}
       /* MyIStack<IStmt> exeStack = new MyStack<>();
        MyIDict<String, Integer> symTable = new MyDict<>();
        MyIList<Integer> out = new MyList<>();
        MyIFileDict fd=new MyFileDict();

        //IStmt ex= new CompStmt(new AssignStmt("v",new ConstExp(3)),new PrintStmt(new VarExp("v")));
        IStmt ex = new CompStmt(new AssignStmt("v", new ArithExp(new ConstExp(4), new ConstExp(2), "-")), new PrintStmt(new VarExp("v")));
        //IStmt ex1=new CompStmt(new AssignStmt("p",new ConstExp(4)),new PrintStmt(new VarExp("p")));

        IStmt ex1 = new CompStmt(new AssignStmt("a", new ConstExp(0)),
                new CompStmt(new IfStmt(new VarExp("a"),
                        new AssignStmt("v", new ConstExp(2)),
                        new AssignStmt("v", new ConstExp(3))),
                        new PrintStmt(new VarExp("v"))));

        IStmt program=new CompStmt(new OpenRFile("var_f","test.in"),
                                new CompStmt(new ReadFile(new VarExp("var_f"),"var_c"),
                                            new CompStmt(new PrintStmt(new VarExp("var_c")),
                                                        new CompStmt(new IfStmt(new VarExp("var_c"),
                                                                                    new CompStmt(new ReadFile(new VarExp("var_f"),"var_c"),
                                                                                               new PrintStmt(new VarExp("var_c"))),
                                                                                   new PrintStmt(new ConstExp(0))),
                                                                new CloseRFile(new VarExp("var_f"))))));




        try {
            Scanner scanner = new Scanner(System.in);
            String path = scanner.nextLine();
            scanner.close();
            if (path.isEmpty()) {
                throw new Exception("Could not");
            }
            PrgState initProg = new PrgState(exeStack, symTable, out,program,fd);
            RepositoryInterface repo = new Repository(path);
            repo.addNewPrg(initProg);
            Controller ctrl = new Controller(repo);
            ctrl.allSteps();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }*/
}

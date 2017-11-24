package View;

import Controller.Controller;
import Model.Commands.ExitCommand;
import Model.Commands.RunCommand;
import Model.DataStructures.*;
import Model.Expressions.*;
import Model.PrgState;
import Model.Statements.*;
import Repository.*;

public class Interpreter {
    public static void main(String[] args) {
        TextMenu menu = new TextMenu();
        IStmt ex1 = new CompStmt(new OpenRFile("var_f", "test.in"),
                new CompStmt(new ReadFile(new VarExp("var_f"), "var_c"),
                        new CompStmt(new PrintStmt(new VarExp("var_c")),
                                new CompStmt(new IfStmt(new VarExp("var_c"),
                                        new CompStmt(new ReadFile(new VarExp("var_f"), "var_c"),
                                                new PrintStmt(new VarExp("var_c"))),
                                        new PrintStmt(new ConstExp(0))),
                                        new CloseRFile(new VarExp("var_f"))))));
        try {
            PrgState prg1;
            prg1 = new PrgState(new MyStack<>(), new MyDict<>(), new MyList<>(), ex1,new MyFileDict(), new Heap());
            RepositoryInterface repo1 = new Repository( "file.txt");
            repo1.addNewPrg(prg1);
            Controller ctr1 = new Controller(repo1);
            menu.addCommand(new ExitCommand("0", "exit"));
            menu.addCommand(new RunCommand("1", ex1.toString(), ctr1));
        } catch (Exception e) {
            System.out.println("Example 1: " + e);
        }

        IStmt ex2 = new CompStmt(new AssignStmt("v", new ConstExp(1)),
                new CompStmt(new IfStmt(new VarExp("v"),
                        new CompStmt(new AssignStmt("v", new ConstExp(2)),
                                new PrintStmt(new VarExp("v"))),
                        new PrintStmt(new VarExp("v"))),
                        new PrintStmt(new ConstExp(2))));
        try {
            PrgState prg2 = new PrgState(new MyStack<>(), new MyDict<>(),new MyList<>(), ex2,  new MyFileDict(),new Heap());
            RepositoryInterface repo2 = new Repository("file2.txt");
            repo2.addNewPrg(prg2);
            Controller ctr2 = new Controller(repo2);
            menu.addCommand(new RunCommand("2", ex2.toString(), ctr2));
        } catch (Exception e) {
            System.out.println("Example 2: " + e);
        }

        IStmt ex3 =new CompStmt(new CompStmt(new AssignStmt("a",
                new ArithExp(new ConstExp(2),new ArithExp(new ConstExp(3),new ConstExp(5),
                        "*"),
                        "+")),
                new AssignStmt("b",
                        new ArithExp(new ArithExp(new VarExp("a"),
                                new ArithExp(new ConstExp(4),
                                        new ConstExp(2),
                                        "/"),
                                "-"),
                                new ConstExp(7),
                                "+"))),
                new PrintStmt(new VarExp("b")));
        try {
            PrgState prg3 = new PrgState(new MyStack<>(), new MyDict<>(), new MyList<>(), ex3, new MyFileDict(),new Heap());
            RepositoryInterface repo3 = new Repository("file3.txt");
            repo3.addNewPrg(prg3);
            Controller ctr3 = new Controller(repo3);
            menu.addCommand(new RunCommand("3", ex3.toString(), ctr3));
        } catch (Exception e) {
            System.out.println("Example 3: " + e);
        }

//        openRFile(var_f,"test.in");
//        readFile(var_f+2,var_c);print(var_c);
//        (if var_c then readFile(var_f,var_c);print(var_c)
//else print(0));
//        closeRFile(var_f)
        IStmt ex4 = new CompStmt(new OpenRFile("var_f","test.in"),
                new CompStmt(new ReadFile(new ArithExp(new VarExp("var_f"),
                        new ConstExp(2),
                        "+"),
                        "var_c"),
                        new CompStmt(new IfStmt(new VarExp("var_c"),
                                new CompStmt(new ReadFile(new VarExp("var_f"),"var_c"),
                                        new PrintStmt(new VarExp("var_c"))),
                                new PrintStmt(new ConstExp(0))),
                                new CloseRFile(new VarExp("var_f")))));
        try {
            PrgState prg4;
            prg4 = new PrgState(new MyStack<>(), new MyDict<>(), new MyList<>(), ex4,new MyFileDict(),new Heap());
            RepositoryInterface repo4 = new Repository( "file4.txt");
            repo4.addNewPrg(prg4);
            Controller ctr4 = new Controller(repo4);
            menu.addCommand(new RunCommand("4", ex4.toString(), ctr4));
        } catch (Exception e) {
            System.out.println("Example 4: " + e);
        }

        IStmt ex5= new CompStmt(
                new CompStmt(
                    new CompStmt(
                        new CompStmt(new AssignStmt("v",new ConstExp(10)),new NewStmt("v", new ConstExp(20))),
                        new NewStmt("a",new ConstExp(22))),
                    new PrintStmt(new ArithExp(new ConstExp(100),new rH("v"),"+"))),
                new PrintStmt(new ArithExp(new ConstExp(100),new rH("a"),"+" )));

        try {
            PrgState prg5;
            prg5 = new PrgState(new MyStack<>(), new MyDict<>(), new MyList<>(), ex5, new MyFileDict(), new Heap());
            RepositoryInterface repo5 = new Repository("file5.txt");
            repo5.addNewPrg(prg5);
            Controller ctrl5 = new Controller(repo5);
            menu.addCommand(new RunCommand("5", ex5.toString(), ctrl5));
        } catch (Exception e) {
            System.out.println(e);

        }

        //v=10;new(v,20);new(a,22);wH(a,30);print(a);print(rH(a))


        IStmt ex6=new CompStmt(
                new CompStmt(
                    new CompStmt(
                        new CompStmt(
                                new CompStmt(new AssignStmt("v",new ConstExp(10)),new NewStmt("v", new ConstExp(20))),
                                new NewStmt("a",new ConstExp(22))),
                        new wHStmt("a",new ConstExp(30))),
                    new PrintStmt(new VarExp("a"))),
                    new PrintStmt(new rH("a")));

        try {
            PrgState prg6;
            prg6 = new PrgState(new MyStack<>(), new MyDict<>(), new MyList<>(), ex6, new MyFileDict(), new Heap());
            RepositoryInterface repo6 = new Repository("file6.txt");
            repo6.addNewPrg(prg6);
            Controller ctrl6 = new Controller(repo6);
            menu.addCommand(new RunCommand("6", ex6.toString(), ctrl6));
        } catch (Exception e) {
            System.out.println(e);
        }

        //v=10;new(v,20);new(a,22);wH(a,30);print(a);print(rH(a));a=0
        IStmt ex7=new CompStmt(
                    new CompStmt(
                        new CompStmt(
                            new CompStmt(
                                new CompStmt(
                                        new CompStmt(new AssignStmt("v",new ConstExp(10)),new NewStmt("v", new ConstExp(20))),
                                        new NewStmt("a",new ConstExp(22))),
                                new wHStmt("a",new ConstExp(30))),
                            new PrintStmt(new VarExp("a"))),
                        new PrintStmt(new rH("a"))),
                    new AssignStmt("a",new ConstExp(0)));

        try {
            PrgState prg7;
            prg7 = new PrgState(new MyStack<>(), new MyDict<>(), new MyList<>(), ex7, new MyFileDict(), new Heap());
            RepositoryInterface repo7 = new Repository("file7.txt");
            repo7.addNewPrg(prg7);
            Controller ctrl7 = new Controller(repo7);
            menu.addCommand(new RunCommand("7", ex7.toString(), ctrl7));
        } catch (Exception e) {
            System.out.println(e);
        }

        menu.show();
    }
}
package Model.DataStructures;

import Model.Exceptions.MyExprEvalExcep;
import Model.Tuple;

import java.util.HashMap;
import java.util.Objects;

public class MyFileDict implements MyIFileDict {
    private static int i=0;
    private HashMap<Integer,Tuple> dict;
    public MyFileDict () { dict = new HashMap<>();}

    @Override
    public void addVariable(String filename) throws MyExprEvalExcep {
        Tuple t=new Tuple(filename);
        i++;
        dict.put(i,t);
    }

    @Override
    public Tuple lookUp(int var) throws MyExprEvalExcep {
        if(!this.dict.containsKey(var))
        {
            throw new MyExprEvalExcep("Variable " + var + " is not defined yet!");
        }
        return this.dict.get(var);
    }

    @Override
    public int getDescriptor(String filename) {
        for(int k=1;k<=i;k++)
            try
            {
                if(Objects.equals(this.lookUp(k).getFilename(), filename))
                    return k;
            } catch (MyExprEvalExcep myExprEvalExcep) {
                myExprEvalExcep.printStackTrace();
            }
        return 0;
    }

    @Override
    public void deleteFile(String file) throws MyExprEvalExcep
    {
        int k=getDescriptor(file);
        if(k==0){
            throw new MyExprEvalExcep("File not opened!\n");
        }
        this.dict.remove(k);
    }

    @Override
    public String toString()
    {
        StringBuilder s= new StringBuilder();
        for(int var:this.dict.keySet()) {
            s.append(var).append("->").append(this.dict.get(var)).append("\n\t");
        }
        return s.toString();
    }
}

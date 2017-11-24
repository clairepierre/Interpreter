package Model.DataStructures;

import Model.Exceptions.MyExprEvalExcep;

import java.util.HashMap;
import java.util.Map;

public class MyDict<T1,T2> implements MyIDict<T1,T2>
{
    private HashMap<T1,T2> dict;
    public MyDict()
    {
        this.dict=new HashMap<>();
    }
    @Override
    public T2 lookUp(T1 key) throws MyExprEvalExcep {
        if (!dict.containsKey(key))
            throw new MyExprEvalExcep("There is no variable " + key.toString() + "\n");
        return dict.get(key);

    }

    @Override
    public void setValue(T1 key,T2 value){dict.put(key, value);}

    @Override
    public Map getContent() {
        return (Map) dict;
    }

    @Override
    public String toString()
    {
        StringBuilder s= new StringBuilder("{");
        for(Map.Entry ent: dict.entrySet()) {
            s.append(ent.getKey().toString()).append("->").append(ent.getValue().toString()).append(",");
        }
        if(s.length()==1)
            return "{}";
        return s.substring(0,s.length()-1)+"}";
    }
}

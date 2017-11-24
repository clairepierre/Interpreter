package Model.DataStructures;
import Model.Exceptions.MyExprEvalExcep;
import java.util.HashMap;
import java.util.Map;



public class Heap implements IHeap{

    private static int i=1;
    private HashMap <Integer,Integer> dict;
    public Heap() { dict = new HashMap<>();}



    public Integer lookUp(Integer key) throws Exception {
        if (!dict.containsKey(key))
            throw new MyExprEvalExcep("There is no variable " + key.toString() + "\n");
        return dict.get(key);
    }

    @Override
    public void setValue(Integer value) {
        dict.put(i,value);
        i++;
    }

    public boolean containValue(Integer value)
    {
        return (dict.containsValue(value));}

    @Override
    public boolean containKey(Integer key) {
        return (dict.containsKey(key));
    }

    public Integer getKey()
    {
        return i;
    }

    @Override
    public void updateHeap(Integer key, Integer value) {dict.put(key, value);}

    @Override
    public Map getContent() {
        return dict;
    }

    @Override
    public void setContent(Map map) {
        dict=(HashMap)map;
    }


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

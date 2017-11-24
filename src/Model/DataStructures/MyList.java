package Model.DataStructures;

import java.util.ArrayList;

public class MyList <T> implements MyIList<T>
{
    private ArrayList<T> list;
    public MyList(){list= new ArrayList<>(); }

    @Override
    public void add(T elem) {list.add(elem);}

    @Override
    public String toString()
    {
        String s=list.toString();
        return"{"+s.substring(1,s.length()-1)+"}";
    }
}

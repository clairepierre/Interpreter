package Model.DataStructures;

import java.util.Map;

public interface IHeap {
    Integer lookUp(Integer key) throws  Exception;
    void setValue(Integer value);
    boolean containValue(Integer value);
    boolean containKey(Integer key);
    String toString();
    Integer getKey();
    void updateHeap(Integer key,Integer value);
    Map getContent();
    void setContent(Map map);
}

package Model;

import Model.Exceptions.MyExprEvalExcep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tuple {
    private String filename;
    private BufferedReader file;

    public Tuple(String f) throws MyExprEvalExcep
    {
        filename=f;
        try
        {
            file=new BufferedReader(new FileReader(filename));
        } catch (IOException e) {
            throw new MyExprEvalExcep("File "+f+" could not be opened!\n"+e);
        }
    }

    public String getFilename(){return filename;}

    public BufferedReader getFile()
    {
        return file;
    }
    @Override
    public String toString(){return filename;}
}


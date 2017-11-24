package Model.Commands;

import Controller.Controller;

public class RunCommand extends Command{
    private Controller ctr;
    public RunCommand(String key, String desc,Controller ctr){
        super(key, desc);
        this.ctr=ctr;
    }
    @Override
    public void execute() {
        try {
            ctr.allSteps();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

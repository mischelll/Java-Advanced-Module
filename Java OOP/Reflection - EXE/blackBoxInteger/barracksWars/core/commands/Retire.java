package javaoopexe.barracksWars.core.commands;

import javaoopexe.barracksWars.interfaces.Inject;
import javaoopexe.barracksWars.interfaces.Repository;
import jdk.jshell.spi.ExecutionControl;

public class Retire extends Command {
    @Inject
    private Repository repository;
   public Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = super.getData()[1];
        try {
            this.repository.removeUnit(unitType);
            return unitType + " retired!";
        } catch (ExecutionControl.NotImplementedException e) {
            return e.getMessage();
        }

    }
}

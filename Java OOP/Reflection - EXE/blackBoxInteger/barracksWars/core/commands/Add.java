package javaoopexe.barracksWars.core.commands;

import javaoopexe.barracksWars.interfaces.Inject;
import javaoopexe.barracksWars.interfaces.Repository;
import javaoopexe.barracksWars.interfaces.Unit;
import javaoopexe.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Add extends Command {
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory factory;

    public Add(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String unitType = super.getData()[1];
        Unit unitToAdd = this.factory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}

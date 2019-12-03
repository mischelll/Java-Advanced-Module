package javaoopexe.barracksWars.core.factories;

import javaoopexe.barracksWars.interfaces.Unit;
import javaoopexe.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "javaoopexe.barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
        try {
            Class unit = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor constructor = unit.getDeclaredConstructor();
            return (Unit) constructor.newInstance();

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        throw new ExecutionControl.NotImplementedException("message");
    }
}

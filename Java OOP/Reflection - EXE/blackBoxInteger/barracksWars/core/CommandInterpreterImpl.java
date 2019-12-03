package javaoopexe.barracksWars.core;

import javaoopexe.barracksWars.interfaces.CommandInterpreter;
import javaoopexe.barracksWars.interfaces.Executable;
import javaoopexe.barracksWars.interfaces.Repository;
import javaoopexe.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String COMMANDS_PACKAGE_ROOT = "javaoopexe.barracksWars.core.commands.";
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        String className = data[0].substring(0, 1).toUpperCase() + data[0].substring(1);


        Class class1 = null;
        Executable exe = null;
        try {
            class1 = Class.forName(COMMANDS_PACKAGE_ROOT + className);
            Constructor constructor = null;
            constructor = class1.getDeclaredConstructor(String[].class);
            exe = (Executable) constructor.newInstance((Object) data);

            populateDependencies(exe);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return exe;

    }

    private void populateDependencies(Executable executable){
        Field[] declaredField = executable.getClass().getDeclaredFields();
        Field[] declaredFields = this.getClass().getDeclaredFields();

        for (Field exField : declaredField) {
            if (exField.getAnnotations()[0].toString().contains("Inject")){
                for (Field curField : declaredFields) {
                    if (curField.getType().equals(exField.getType())){
                        exField.setAccessible(true);
                        try {
                            exField.set(executable,curField.get(this));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

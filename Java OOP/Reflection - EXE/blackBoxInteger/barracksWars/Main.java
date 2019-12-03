package javaoopexe.barracksWars;

import javaoopexe.barracksWars.core.CommandInterpreterImpl;
import javaoopexe.barracksWars.interfaces.CommandInterpreter;
import javaoopexe.barracksWars.interfaces.Repository;
import javaoopexe.barracksWars.interfaces.Runnable;
import javaoopexe.barracksWars.interfaces.UnitFactory;
import javaoopexe.barracksWars.core.Engine;
import javaoopexe.barracksWars.core.factories.UnitFactoryImpl;
import javaoopexe.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(repository,unitFactory);

        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}

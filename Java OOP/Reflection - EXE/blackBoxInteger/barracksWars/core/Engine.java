package javaoopexe.barracksWars.core;

import javaoopexe.barracksWars.interfaces.CommandInterpreter;
import javaoopexe.barracksWars.interfaces.Runnable;
import jdk.jshell.spi.ExecutionControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable {

   private CommandInterpreter commandInterpreter;

  public Engine(CommandInterpreter commandInterpreter){
      this.commandInterpreter = commandInterpreter;
  }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = this.commandInterpreter.interpretCommand(data, commandName).execute();

                if (result.equals("fight")) {
                    break;
                }

                System.out.println(result);
            } catch (IOException | RuntimeException | ExecutionControl.NotImplementedException e) {
                System.out.println(e.getMessage());
            }
        }
    }



}

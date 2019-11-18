import core.MachineFactoryImpl;
import core.MachinesManagerImpl;

import core.PilotFactoryImpl;
import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PilotFactory pilotFactory = new PilotFactoryImpl(); //TODO change null with your implementation
        MachineFactory machineFactory = new MachineFactoryImpl(); //TODO change null with your implementation
        Map<String, Pilot> pilots = new LinkedHashMap<>();
        Map<String, Machine> machines = new LinkedHashMap<>();

        MachinesManager machinesManager = new MachinesManagerImpl(pilotFactory, machineFactory, pilots, machines);

        String command = "";

        while (!"Over".equals(command = reader.readLine())) {
            String[] data = command.split("\\s+");
            String action = data[0];

            String name = data[1];

            switch (action) {
                case "Hire":
                    System.out.println(machinesManager.hirePilot(name));
                    break;

                case "ManufactureTank":
                    System.out.println(machinesManager.manufactureTank(name, Double.parseDouble(data[2]), Double.parseDouble(data[3])));
                    break;

                case "ManufactureFighter":
                    System.out.println(machinesManager.manufactureFighter(name, Double.parseDouble(data[2]), Double.parseDouble(data[3])));
                    break;

                case "Engage":
                    System.out.println(machinesManager.engageMachine(name, data[2]));
                    break;

                case "Attack":
                    System.out.println(machinesManager.attackMachines(name, data[2]));
                    break;

                case "DefenseMode":
                    System.out.println(machinesManager.toggleTankDefenseMode(name));
                    break;

                case "AggressiveMode":
                    System.out.println(machinesManager.toggleFighterAggressiveMode(name));
                    break;

                case "Report":
                    System.out.printf("%s%n",machinesManager.pilotReport(name));
                    break;

            }

        }
    }
}

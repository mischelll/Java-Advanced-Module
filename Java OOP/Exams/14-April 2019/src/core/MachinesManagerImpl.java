package core;

import common.OutputMessages;
import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;

import entities.interfaces.*;

import java.util.Map;

public class MachinesManagerImpl implements MachinesManager {
    private PilotFactory pilotFactory;
    private MachineFactory machineFactory;
    private Map<String, Pilot> pilots;
    private Map<String, Machine> machines;

    public MachinesManagerImpl(PilotFactory pilotFactory, MachineFactory machineFactory, Map<String, Pilot> pilots, Map<String, Machine> machines) {
        this.pilotFactory = pilotFactory;
        this.machineFactory = machineFactory;
        this.pilots = pilots;
        this.machines = machines;

    }


    @Override
    public String hirePilot(String name) {
        boolean check = this.pilots.containsKey(name);
        if (check) {
            return String.format(OutputMessages.pilotExists, name);
        }

        Pilot pilot = pilotFactory.createPilot(name);
        this.pilots.put(name, pilot);

        return String.format(OutputMessages.pilotHired, name);
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {
        boolean check = this.machines.containsKey(name);
        if (check) {
            return String.format(OutputMessages.machineExists, name);
        }

        Tank tank = machineFactory.createTank(name, attackPoints, defensePoints);
        this.machines.put(name, tank);

        return String.format(OutputMessages.tankManufactured, name, attackPoints, defensePoints);
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        boolean check = this.machines.containsKey(name);
        if (check) {
            return String.format(OutputMessages.machineExists, name);
        }

        Fighter fighter = machineFactory.createFighter(name, attackPoints, defensePoints);
        this.machines.put(name, fighter);

        return String.format(OutputMessages.fighterManufactured, name, attackPoints, defensePoints);
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        boolean checkPilot = this.pilots.containsKey(selectedPilotName);
        boolean checkMachine = this.machines.containsKey(selectedMachineName);

        if (!checkPilot) {
            return String.format(OutputMessages.pilotNotFound, selectedPilotName);
        }
        if (!checkMachine) {
            return String.format(OutputMessages.machineNotFound, selectedMachineName);
        }

        Pilot pilot = this.pilots.get(selectedPilotName);
        Machine machine = this.machines.get(selectedMachineName);

        if (!pilot.getMachines().contains(machine) && machine.getPilot() == null) {
            pilot.addMachine(this.machines.get(selectedMachineName));
            machine.setPilot(pilot);
        } else {
            return String.format(OutputMessages.machineHasPilotAlready, selectedMachineName);
        }

        return String.format(OutputMessages.machineEngaged, selectedPilotName, selectedMachineName);
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        boolean checkMachine1 = this.machines.containsKey(attackingMachineName);
        boolean checkMachine2 = this.machines.containsKey(defendingMachineName);

        if (!checkMachine1) {
            return String.format(OutputMessages.machineNotFound, attackingMachineName);
        }
        if (!checkMachine2) {
            return String.format(OutputMessages.machineNotFound, defendingMachineName);
        }

        Machine attack = this.machines.get(attackingMachineName);
        attack.attack(defendingMachineName);

        Machine defence = this.machines.get(defendingMachineName);

        if (attack.getAttackPoints() > defence.getDefensePoints()) {
            defence.setHealthPoints(defence.getHealthPoints() - attack.getAttackPoints());
            if (defence.getHealthPoints() < 0) {
                defence.setHealthPoints(0);
            }
        }

        return String.format(OutputMessages.attackSuccessful, defendingMachineName, attackingMachineName, defence.getHealthPoints());
    }

    @Override
    public String pilotReport(String pilotName) {
        if (!this.pilots.containsKey(pilotName)) {
            return String.format(OutputMessages.pilotNotFound, pilotName);
        }

        Pilot pilot = this.pilots.get(pilotName);

        return pilot.report();
    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {

        if (!(this.machines.get(fighterName) instanceof Fighter)){
            return String.format(OutputMessages.notSupportedOperation,fighterName);
        }

        Fighter fighter = (Fighter) this.machines.get(fighterName);
        fighter.toggleAggressiveMode();


        return String.format(OutputMessages.fighterOperationSuccessful, fighterName);
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {


        if (!(this.machines.get(tankName) instanceof Tank)){
            return String.format(OutputMessages.notSupportedOperation,tankName);
        }

        Tank tank = (Tank) this.machines.get(tankName);
        tank.toggleDefenseMode();

        return String.format(OutputMessages.tankOperationSuccessful, tankName);
    }
}

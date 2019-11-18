package entities;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.List;

public class PilotImpl implements Pilot {
    private static final String INVALID_PILOT = "Pilot cannot be null.";
    private String name;
    private List<Machine> machines;

    public PilotImpl(String name) {
        this.setName(name);
        this.machines = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(INVALID_PILOT);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addMachine(Machine machine) {
        if (machine == null) {
            throw new NullPointerException("Null machine cannot be added to the pilot.");
        }

        this.machines.add(machine);
    }

    @Override
    public List<Machine> getMachines() {
        return this.machines;
    }

    @Override
    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        if (stringBuilder.length() == 0) {

            stringBuilder.append(String.format("%s - %d machines", this.name, this.machines.size())).append(System.lineSeparator());
        } else if (stringBuilder.length() > 0){
            stringBuilder.append(String.format("%n%s - %d machines", this.name, this.machines.size())).append(System.lineSeparator());
        }
        for (Machine machine : this.machines) {
            stringBuilder.append(machine.toString()).append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }
}

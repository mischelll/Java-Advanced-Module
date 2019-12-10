package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.common.ExceptionMessages;
import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RaceImpl implements Race {
    private static final int REQUIRED_LENGTH = 5;
    private String name;
    private int laps;
    private Collection<Rider> riders;

    public RaceImpl(String name, int laps) {
        this.setName(name);
        this.setLaps(laps);
        this.riders = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < REQUIRED_LENGTH) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NAME, name, REQUIRED_LENGTH));
        }
        this.name = name;
    }

    private void setLaps(int laps) {
        if (laps < 1) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NUMBER_OF_LAPS, 1));
        }
        this.laps = laps;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    @Override
    public Collection<Rider> getRiders() {
        return this.riders;
    }

    @Override
    public void addRider(Rider rider) {
        if (riderIsNull(rider)) {
            throw new NullPointerException(ExceptionMessages.RIDER_INVALID);
        }

        if (!canParticipate(rider)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RIDER_NOT_PARTICIPATE, rider.getName()));
        }

        if (alreadyExists(rider)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RIDER_ALREADY_ADDED, rider.getName(), getName()));
        }

        this.riders.add(rider);

    }

    private boolean riderIsNull(Rider rider) {
        if (rider == null) {
            return true;
        }
        return false;
    }

    private boolean canParticipate(Rider rider) {
        return rider.getCanParticipate();
    }

    private boolean alreadyExists(Rider rider) {
        for (Rider rider1 : this.riders) {
            if (rider.getName().equals(rider1.getName())) {
                return true;
            }
        }

        return false;
    }
}

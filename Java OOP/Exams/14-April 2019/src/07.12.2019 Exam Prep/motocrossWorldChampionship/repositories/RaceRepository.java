package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RaceRepository implements Repository<Race> {
    private Collection<Race> models;

    public RaceRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {
        for (Race model : this.models) {
            if (model.getName().equals(name)){
                return model;
            }
        }
        return null;
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Race model) {
        this.models.add(model);
    }

    @Override
    public boolean remove(Race model) {
        return this.models.remove(model);
    }
}

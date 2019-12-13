package viceCity.repositories.interfaces;

import viceCity.common.ConstantMessages;
import viceCity.models.guns.Gun;


import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GunRepository implements Repository<Gun> {
    private List<Gun> models;

    public GunRepository() {
        this.models = new LinkedList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableList(this.models);
    }

    @Override
    public void add(Gun model) {
        if(!this.models.contains(model)){
            this.models.add(model);
        }

    }

    @Override
    public boolean remove(Gun model) {
        return this.models.remove(model);
    }

    @Override
    public Gun find(String name) {
        for (Gun model : this.models) {
            if (model.getName().equals(name)){
                return model;
            }
        }
        return null;
    }


}

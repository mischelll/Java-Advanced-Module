package repository;

import java.util.LinkedHashMap;
import java.util.Map;

public class Repository {
    private int ID = 0;
    private Map<Integer, Person> data;

    public Map<Integer, Person> getData() {
        return data;

    }

    public Repository() {
        this.data = new LinkedHashMap<>();
        this.ID = 0;
    }

    public void add(Person person) {
        getData().put(ID, person);
        ID++;
    }

    public Person get(int id) {
        return getData().get(id);
    }

    public boolean update(int id, Person newPerson) {
        if (getData().containsKey(id)) {
            getData().put(id, newPerson);
            return true;
        }

        return false;
    }

    public boolean delete(int id){
        if (getData().containsKey(id)){
            getData().remove(id);
            return true;
        }

        return false;
    }

    public int getCount(){
        return getData().size();
    }


}

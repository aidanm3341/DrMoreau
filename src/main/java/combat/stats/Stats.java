package combat.stats;

import data.mob.MobObserver;
import data.mob.MobSubject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stats implements Cloneable, MobSubject {
    private Map<Stat, Float> stats;
    private List<MobObserver> observers;

    public Stats(){
        stats = new HashMap<>();
        observers = new ArrayList<>();

        for(Stat stat : Stat.values())
            put(stat, 0f);
    }

    public void put(Stat stat, Float value){
        stats.put(stat, value);
        notifyListeners();
    }

    public void addModifier(Stat stat, Float value){
        put(stat, get(stat) + value);
    }

    public Float get(Stat stat){
        return stats.get(stat);
    }

    public Stats clone(){
        Stats clone = new Stats();
        for(Stat stat : stats.keySet())
            clone.put(stat, get(stat));
        return clone;
    }

    @Override
    public void addListener(MobObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeListener(MobObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyListeners() {
        for(MobObserver observer : observers){
            observer.update(this);
        }
    }
}

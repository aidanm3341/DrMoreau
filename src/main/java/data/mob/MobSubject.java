package data.mob;

public interface MobSubject {
    void addListener(MobObserver observer);
    void removeListener(MobObserver observer);
    void notifyListeners();
}

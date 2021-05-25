package util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Pool<E> {

    private List<E> things;
    private Random rand;

    public Pool(List<E> things){
        this();
        this.things.addAll(things);
    }

    public Pool() {
        things = new ArrayList<>();
        rand = new Random();
    }

    public void add(E e){
        things.add(e);
    }

    public void addAll(Collection<E> es){
        things.addAll(es);
    }

    public List<E> popX(int number) {
        if(number > things.size())
            throw new IndexOutOfBoundsException("Number given is greater than Pool size.");

        List<E> returns = new ArrayList<>();

        for(int i=number; i>0; i--) {
            E thing = things.get(rand.nextInt(things.size()));
            things.remove(thing);
            returns.add(thing);
        }

        return returns;
    }

    public E pop() {
        E e = things.get(rand.nextInt(things.size()));
        things.remove(e);
        return e;
    }

    public List<E> getX(int number) {
        if(number > things.size())
            throw new IndexOutOfBoundsException("Number given is greater than Pool size.");

        List<E> returns = new ArrayList<>();

        for(int i=number; i>0; i--)
            returns.add(things.get(rand.nextInt(things.size())));

        return returns;
    }

    public E get()
    {
        return things.get(rand.nextInt(things.size()));
    }

    public Stream<E> stream(){
        return things.stream();
    }
}

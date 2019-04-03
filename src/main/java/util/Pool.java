package util;

import java.util.ArrayList;
import java.util.Random;

public class Pool<E> {

    private ArrayList<E> things;
    private Random rand;

    public Pool()
    {
        things = new ArrayList<>();
        rand = new Random();
    }

    public void add(E e){
        things.add(e);
    }

    public void addAll(ArrayList<E> es){
        things.addAll(es);
    }

    public ArrayList<E> popX(int number) {
        if(number > things.size())
            throw new IndexOutOfBoundsException("Number given is greater than Pool size.");

        ArrayList<E> returns = new ArrayList<>();

        for(int i=number; i>0; i--) {
            E thing = things.get(rand.nextInt(things.size()));
            things.remove(thing);
            returns.add(thing);
        }

        return returns;
    }

    public ArrayList<E> getX(int number) {
        if(number > things.size())
            throw new IndexOutOfBoundsException("Number given is greater than Pool size.");

        ArrayList<E> returns = new ArrayList<>();

        for(int i=number; i>0; i--)
            returns.add(things.get(rand.nextInt(things.size())));

        return returns;
    }

    public E get()
    {
        return things.get(rand.nextInt(things.size()));
    }
}

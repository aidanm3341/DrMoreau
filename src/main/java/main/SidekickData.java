package main;

public class SidekickData {

    private Attack at1, at2, at3, at4, at5, at6;
    private int hp;

    public SidekickData(){
        at1 = new Attack("Punch!", 5);
        at2 = new Attack("Kick!", 6);
        at3 = new Attack("Shoot!!", 10);
        at4 = new Attack("Exterminate!", 15);
        at5 = new Attack("Push :/", 1);
        at6 = new Attack("Handshake.", 0);
    }

    public void attack(int dmg){
        hp -= dmg;
    }

    public Attack getAt1() {
        return at1;
    }

    public Attack getAt2() {
        return at2;
    }

    public Attack getAt3() {
        return at3;
    }

    public Attack getAt4() {
        return at4;
    }

    public Attack getAt5() {
        return at5;
    }

    public Attack getAt6() {
        return at6;
    }
}

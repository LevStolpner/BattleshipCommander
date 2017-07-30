package main.java.model;

public class Player {

    private Battlefield myBattlefield;
    private Battlefield enemyBattlefield;

    public Player() {
    }

    public void initializeBattlefield(int battlefieldSize) {
        myBattlefield = new Battlefield(battlefieldSize);

    }

    public void putShips() {

    }
}

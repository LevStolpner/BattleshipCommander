package main.java;

import main.java.model.Battlefield;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int BATTLEFIELD_SIZE = 10;

    public static void main(String[] args) {
        List<Battlefield> battlefields = new ArrayList<>(2);
        battlefields.add(new Battlefield(BATTLEFIELD_SIZE));
        battlefields.add(new Battlefield(BATTLEFIELD_SIZE));
    }
}

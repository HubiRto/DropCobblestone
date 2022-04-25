package pl.pomoku.cobblestonedropgui.system;

public class Random {
    public static int itemAmoundRandom(int min, int max) {
        int range = max - min + 1;
        int rand = (int)(Math.random() * range) + min;
        return rand;
    }

    public static Boolean percentChance(double chance) {
        return Math.random() <= chance;
    }
}

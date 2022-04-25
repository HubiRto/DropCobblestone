package pl.pomoku.cobblestonedropgui.system;

public class Random_2 {
    public static int getRandom() {
        int max = 3;
        int min = 1;
        int range = max - min + 1;

        int rand_2 = (int)(Math.random() * range) + min;

        return rand_2;
    }
}

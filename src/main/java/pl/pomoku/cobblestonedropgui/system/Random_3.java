package pl.pomoku.cobblestonedropgui.system;

public class Random_3 {
    public static int getRandom() {
        int max = 2;
        int min = 1;
        int range = max - min + 1;

        int rand_3 = (int)(Math.random() * range) + min;

        return rand_3;
    }
}

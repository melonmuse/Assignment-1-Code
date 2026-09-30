import java.util.Random;

public class ArenaManager {

    private Random random;

    public ArenaManager() {

        random = new Random();
    }

    public Arena createPresetArena() {

        Arena arena = new Arena();

        arena.addRock(1, 2);
        arena.addRock(1, 3);
        arena.addRock(4, 5);
        arena.addRock(6, 7);
        arena.addRock(8, 1);

        return arena;
    }

    public Arena createPresetArena2() {

        Arena arena = new Arena();

        arena.addRock(0, 5);
        arena.addRock(2, 2);
        arena.addRock(3, 8);
        arena.addRock(6, 4);
        arena.addRock(9, 7);

        return arena;
    }

    public Arena createRandomArena() {

        Arena arena = new Arena();

        int rocksAdded = 0;

        while (rocksAdded < 5) {

            int row = random.nextInt(10);

            int column = random.nextInt(10);

            boolean added = arena.addRock(row, column);

            if (added == true) {
                rocksAdded++;
            }
        }

        return arena;
    }
}
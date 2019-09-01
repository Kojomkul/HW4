import java.util.Random;

public class Main {

    public static int[] health = {700, 250, 250, 250, 250};
    public static int[] damageorcure = {50, 20, 20, 20, 7};
    public static String[] hitTypes = {"Physical", "Physical", "Magical", "Mental", "Medic"};

    public static void main(String[] args) {
        printStatistics();
        while (!isFinished()) {
            hitTypes[0] = genarateBossDefenceType();
            gameRounddd();
        }
    }

    public static boolean isFinished() {
        if (health[0] <= 0) {
            System.out.println("Герои won!!!");
            return true;
        }
        if (health[1] <= 0 && health[2] <= 0 && health[3] <= 0) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;
    }

    public static void gameRounddd() {
        for (int i = 1; i <= 3; i++) {
            health[i] = hitPlayer(i); // Босс бьет героя
            health[0] = hitBoss(i);// герой бьет Босса
            health[i] = curePlayers(i);
        }
        printStatistics();
    }

    public static String genarateBossDefenceType() {
        Random r = new Random();
        int randomNumber = r.nextInt(3) + 1;
        return hitTypes[randomNumber];
    }

    public static int hitBoss(int playerIndex) {
        Random r = new Random();
        int randomNumber = r.nextInt(8) + 1; // генерируем случайное число от 1 до 5
        if (hitTypes[0].equals(hitTypes[playerIndex])) {
            System.out.println(hitTypes[playerIndex] + " нанес критический удар " +
                    damageorcure[playerIndex] * randomNumber);
            return health[0] - damageorcure[playerIndex] * randomNumber;
        }
        return health[0] - damageorcure[playerIndex];
    }

    public static int hitPlayer(int playerIndex) {
        return health[playerIndex] - damageorcure[0];
    }

    public static int curePlayers(int playerIndex) { return health[playerIndex] + damageorcure[4];}

    public static void printStatistics() {
        System.out.println("_________________________");
        System.out.println("Boss health " + health[0]);
        System.out.println("Warrior health " + health[1]);
        System.out.println("Magic health " + health[2]);
        System.out.println("Kinetic health " + health[3]);
        System.out.println("_________________________");
    }
}
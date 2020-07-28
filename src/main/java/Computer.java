import java.util.Random;

public class Computer {

    /**
     * Ход компьютера. Рандомно определяет, каким орудием сыграет компьютер. Следует учесть,
     * что random.nextInt(3) генерирует числа от 0 до 2.
     * @return Weapon - конкретный тип орудия компьютера.
     */
    public Weapon computerMove() {
        Random random = new Random();
        int item = random.nextInt(3);
        switch (item) {
            case 0:
                return Weapon.ROCK;
            case 1:
                return Weapon.SCISSORS;
            case 2:
                return Weapon.PAPER;
        }
        return null;
    }
}

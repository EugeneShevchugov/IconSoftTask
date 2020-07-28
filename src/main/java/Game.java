import java.io.FileWriter;
import java.io.IOException;

public class Game {
    private Human human;
    private Computer computer;
    private int humanScore;
    private int computerScore;

    public Game() {
        human = new Human();
        computer = new Computer();
        humanScore = 0;
        computerScore = 0;
    }

    /**
     * Метод старта игры.
     * Для начала вводится имя игрока.
     * Затем идут ходы человека и компьютера(Перед ходом компьютера мы должны убедиться, что человек не выбрал 4 в методе move()).
     * Ходы печатаются на экран.
     * Проверяется победа того или иного игрока.
     * Печатается счет.
     */
    public void startGame() {
        System.out.println("Игра камень ножницы бумага началась\n");
        human.enterName();
        while (true) {
            Weapon humanWeapon = human.move();
            if (isGameEnd()) {
                break;
            }
            Weapon computerWeapon = computer.computerMove();
            printMoves(humanWeapon, computerWeapon);
            checkWin(humanWeapon, computerWeapon);
            printScore(humanScore, computerScore);
        }
    }

    /**
     * Метод проверки окончания игры
     * @return true если игра окончена
     */
    private boolean isGameEnd() {
        if (human.isEnd()) {
            System.out.println("Игра окончена");
            printScore(humanScore, computerScore);
            readRecord();
            return true;
        }
        return false;
    }

    /**
     * Метод записи рекорда в файл
     * @throws IOException если произошла ошибка ввода/вывода
     */
    private void readRecord() {
        try (FileWriter fileWriter = new FileWriter("record.txt", true)) {
            fileWriter.write("Игрок под ником " + human.getName() + " имеет рекорд " + humanScore + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод проверки победы. Использует метод compare класса Weapon
     * @param humanWeapon - Орудие человека
     * @param computerWeapon - Орудие компьютера
     */
    private void checkWin(Weapon humanWeapon, Weapon computerWeapon) {
        switch (humanWeapon.compare(computerWeapon)) {
            case 0:
                System.out.println("Ничья. Попробуйте снова");
                break;
            case 1:
                System.out.println(humanWeapon + " человека побил " + computerWeapon + " компьютера");
                humanScore++;
                break;
            case -1:
                System.out.println(computerWeapon + " компьюьтера побил " + humanWeapon + " человека");
                computerScore++;
                break;
        }
    }

    /**
     * Печатает ходы на экран
     * @param humanWeapon - Орудие человека
     * @param computerWeapon - Орудие компьютера
     */
    private void printMoves(Weapon humanWeapon, Weapon computerWeapon) {
        System.out.println("Вы выкинули " + humanWeapon);
        System.out.println("Компьютер выкинул " + computerWeapon);
    }

    /**
     * Печатает счет на экран
     * @param humanScore - Счет человека
     * @param computerScore - Счет компьютера
     */
    private void printScore(int humanScore, int computerScore) {
        System.out.println(String.format("Счет %d-%d", humanScore, computerScore));
    }
}

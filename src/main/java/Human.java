import java.util.Scanner;

public class Human {
    private Scanner scanner = new Scanner(System.in);
    private boolean isEnd = false;
    private String name;

    public String getName() {
        return name;
    }

    public boolean isEnd() {
        return isEnd;
    }

    /**
     * Ввод имени
     */
    public void enterName() {
        System.out.println("Введите свое имя");
        name = scanner.nextLine();
    }

    /**
     * Ход игрока. Орудия представлены цифрами от 1 до 3. Если введено неверное значение, система попросит ввести его снова. Выход - 4.
     * @return Weapon - Конкретное орудие игрока
     */
    public Weapon move() {
        System.out.println(String.format
                ("Вы ходите. Выберите оружие: %d - Камень, %d - Бумага, %d - Ножницы." +
                        " \nДля выхода используйте %d", 1, 2, 3, 4));
        switch (scanner.nextLine()) {
            case "1":
                return Weapon.ROCK;
            case "2":
                return Weapon.PAPER;
            case "3":
                return Weapon.SCISSORS;
            case "4":
                isEnd = true;
                return null;
            default:
                System.out.println("Оружия не существует");
        }
        return move();
    }
}

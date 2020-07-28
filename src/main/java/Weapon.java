/**
 * Перечисление содержит варианты возможного оружия против компьютера - Камень, Бумага или ножницы
 */
public enum Weapon {
    ROCK,
    PAPER,
    SCISSORS;

    /**
     * Метод сравнения. Позволяет определить, кто победил на текущем ходе.
     * @param weapon - Оружие, которое будем сравнивать с нашим
     * @return int(0 если равны, 1 если мы выйграли, -1 если выйграл компьютер)
     */
    public int compare(Weapon weapon) {
        if (this == weapon) {
            return 0;
        }

        switch (weapon) {
            case ROCK:
                return this == SCISSORS ? -1 : 1;
            case PAPER:
                return this == ROCK ? -1 : 1;
            case SCISSORS:
                return this == PAPER ? -1 : 1;
        }
        return 0;
    }
}

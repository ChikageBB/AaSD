package avlTree;

import java.util.*;

public class TaskGenerator {
    private static final String[] TITLES = {
        "Позвонить", "Написать email", "Купить", "Оплатить",
        "Подготовить", "Изучить", "Сделать", "Проверить"
    };

    private static final String[] DESCRIPTIONS = {
        "срочно", "важно", "не забыть", "к сроку",
        "по работе", "личное", "семья", "друзья"
    };

    private static final String[] DETAILS = {
        "в магазине", "до 18:00", "на неделю",
        "по списку", "онлайн", "в приложении"
    };

    private static String getRandomName() {
        String[] names = {"Анне", "Ивану", "Марии", "Алексею", "Ольге"};
        return names[new Random().nextInt(names.length)];
    };

    private static String getRandomThing() {
        String[] things = {"молоко", "хлеб", "книги", "документы", "цветы"};
        return things[new Random().nextInt(things.length)];
    }


    public static List<Task> generateTasks(int count){
        List<Task> tasks = new ArrayList<>();
        Random r = new Random();
        Set<Integer> prioritiesUsed = new HashSet<>();


        for (int i = 0; i < count; ++i){
            int priority;

            do{
                priority = r.nextInt(count) + 1;
            }while (prioritiesUsed.contains(priority));

            prioritiesUsed.add(priority);

            String title = TITLES[r.nextInt(TITLES.length)] + " "
                        + (r.nextBoolean() ? getRandomName() : getRandomThing());

            String descript = DESCRIPTIONS[r.nextInt(DESCRIPTIONS.length)] + " "
                            + DETAILS[r.nextInt(DETAILS.length)];

            tasks.add(new Task(priority, title, descript));
        }

        return tasks;
    }
}

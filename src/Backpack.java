/**
 * User: Roman V.F.
 * 
 * Имеется набор вещей, которые необходимо поместить в рюкзак. Рюкзак обладает заданной грузоподъемностью.
 * Вещи в свою очередь обладают двумя параметрами — весом и стоимостью.
 * Цель задачи заполнить рюкзак не превысив его грузоподъемность и максимизировать суммарную ценность груза.
 */
public class Backpack {
    public static void main(String[] args) {
        int maxWeightBackpack = 13;
        Thing[] things = {
                new Thing("спички", 1, 3),
                new Thing("ножницы", 6, 4),
                new Thing("зеркало", 4, 5),
                new Thing("нож", 7, 8),
                new Thing("часы", 6, 9)
        };

        int[][] values = getAllValues(things, maxWeightBackpack);

        // Таблица всех значений:
//        for (int[] value : values) {
//            System.out.println(Arrays.toString(value));
//        }

        int maxWeight = values[things.length][maxWeightBackpack];
        System.out.println("Максимальная ценность предметов в рюкзаке: " + maxWeight);
        if (maxWeight > 0) {
            printThingsInBackpack(values, things);
        }

    }

    private static void printThingsInBackpack(int[][] values, Thing[] things) {
        int weightPack = values[0].length - 1;
        for (int n = things.length; n > 0; n--) {
            if (values[n][weightPack] != values[n - 1][weightPack]) {
                weightPack -= things[n - 1].weight;
                System.out.println("В рюкзаке: " + things[n - 1]);
            }
        }
    }

    private static int[][] getAllValues(Thing[] things, int maxWeightBackpack) {
        int[][] values = new int[things.length + 1][maxWeightBackpack + 1];
        for (int n = 0; n < values.length; n++) {
            for (int w = 0; w <= maxWeightBackpack; w++) {
                if (n == 0 || w == 0) {
                    values[n][w] = 0;
                } else {
                    int currentCost = things[n - 1].getCost();
                    int currentWeight = things[n - 1].getWeight();
                    if (w >= currentWeight) {
                        values[n][w] = Math.max(values[n - 1][w], values[n - 1][w - currentWeight] + currentCost);
                    } else {
                        values[n][w] = values[n - 1][w];
                    }
                }
            }

        }
        return values;
    }
}

class Thing {
    final String name;
    final int cost;
    final int weight;

    public Thing(String name, int cost, int weight) {
        this.name = name;
        this.cost = cost;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name + " (цена=" + cost + ", вес=" + weight + ")";
    }
}

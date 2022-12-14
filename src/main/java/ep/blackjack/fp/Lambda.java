package ep.blackjack.fp;

import java.util.List;
import java.util.function.Function;

public class Lambda {
    public static void printAllOld(List<Integer> numbers) {
        System.out.println("printAllOld");

        for (int number : numbers) {
            System.out.println(number);
        }
    }

    public static void printAllLambda(List<Integer> numbers) {
        System.out.println("printAllLambda");

        numbers.forEach(System.out::println);
    }

    public static void runThread() {
        new Thread(() -> System.out.println("Hello from thread")).start();
    }

    public static int sumWithLambda(List<Integer> numbers, Function<Integer, Boolean> lambda) {
        int total = 0;
        for (int number : numbers) {
            if (lambda.apply(number)) {
                total += number;
            }
        }
        return total;
    }

    public static int sumAll(List<Integer> numbers) {
        return sumWithLambda(numbers, (number)-> true);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sumWithLambda(numbers, (number) -> number % 2 == 0);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sumWithLambda(numbers, (number) -> number > 3);
    }
}

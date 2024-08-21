package org.example;

public class Main {
    public static <T> T sumOrConcat(Pair<T> pair) {
        T first = pair.getFirst();
        T second = pair.getSecond();

        return switch (first) {
            case Integer i when second instanceof Integer ->
                    (T) Integer.valueOf(i.intValue() + ((Integer) second).intValue());
            case Double v when second instanceof Double ->
                    (T) Double.valueOf(v.doubleValue() + ((Double) second).doubleValue());
            case String s when second instanceof String -> (T) String.valueOf(first.toString() + second.toString());
            case null,
            default -> throw new IllegalArgumentException("Unsupported types");
        };
    }

    public static void main(String[] args) {
        Pair<Integer> integerPair = new Pair<>(1, 2);
        System.out.println(sumOrConcat(integerPair)); // Output: 3

        Pair<Double> doublePair = new Pair<>(1.5, 2.5);
        System.out.println(sumOrConcat(doublePair)); // Output: 4.0

        Pair<String> stringPair = new Pair<>("Hello", "World");
        System.out.println(sumOrConcat(stringPair)); // Output: HelloWorld
    }
}
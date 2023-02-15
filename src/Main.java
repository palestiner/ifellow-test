import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String in = scanner.nextLine().replaceAll("[^()]", "");
            while (in.startsWith(")")) {
                in = in.substring(1);
            }
            while (in.endsWith("(")) {
                in = in.substring(0, in.length() - 1);
            }
            List<String> brackets = Arrays.stream(in.split("")).toList();
            List<Pair> pairs = new ArrayList<>();
            for (int i = 0; i < brackets.size(); i++) {
                String sBracket = brackets.get(i);
                final Bracket bracket = new Bracket(sBracket, i);
                int nonNullLeft = 0;
                switch (sBracket) {
                    case "(" -> {
                        for (Pair pair : pairs) {
                            if (pair.getLeft() == null) pair.setLeft(bracket);
                            if (pair.getLeft() != null) nonNullLeft++;
                        }
                        if (pairs.size() == nonNullLeft) pairs.add(new Pair(bracket, null));
                    }
                    case ")" -> {
                        for (Pair pair : pairs) {
                            if (pair.getRight() == null) {
                                pair.setRight(bracket);
                                break;
                            }
                        }
                    }
                }
            }
            Map<Integer, String> collect = pairs.stream()
                    .filter(Pair::everyoneExists)
                    .flatMap(pair -> Stream.of(pair.getLeft(), pair.getRight()))
                    .collect(Collectors.toMap(Bracket::position, Bracket::value, (s, s2) -> s, TreeMap::new));
            System.out.println(resultString(collect.values()));
        }
    }

    private static String resultString(Collection<String> brackets) {
        int size = brackets.size();
        return size == 0 ? "0" : "%s - %s".formatted(size, String.join("", brackets));
    }
}

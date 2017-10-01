import java.util.Arrays;
import java.util.TimeZone;

public class ScalaConverter {

    public static void main(String[] args) {
        System.out.println(task1(6));
        System.out.println(task2("TEST"));
        task8();
    }

    private static int task1(int a) {
        if (a > 0) return 1;
        if (a < 0) return -1;
        return 0;
    }

    private static int task2(String str) {
        int mul = 1;
        for (char c : str.toCharArray()) {
            mul *= (int) c;
        }
        return mul;
    }

    private static void task8() {
        Arrays.stream(TimeZone.getAvailableIDs())
                .filter(s -> s.startsWith("America/"))
                .map(s -> s.replace("America/", "")).sorted().forEach(s -> System.out.println(s));
    }


}

import java.util.Arrays;
import java.util.TimeZone;

public class ScalaConverter {

    public static void main(String[] args) {
//        System.out.println(task1(6));
//        System.out.println(task2("TEST"));
//        task8();

        task4();
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

    private static void task4() {

        int[] arr = {1, 2, 3, 4, 5};

        for (int i = 0; i < arr.length - 1; i += 2) {

            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;

        }



    }

    private static void task8() {
        Arrays.stream(TimeZone.getAvailableIDs())
                .filter(s -> s.startsWith("America/"))
                .map(s -> s.replace("America/", ""))
                .sorted()
                .forEach(s -> System.out.println(s));
    }


}

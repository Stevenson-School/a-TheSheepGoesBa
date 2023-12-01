import java.util.ArrayDeque;
import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {

    private final Comparator<T> comparator;

    public MaxArrayDeque (Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public T max() {
        return max(comparator);
    }

    public T max(Comparator<T> c) {
        if (size() == 0) return null;
        T max = getFirst();
        for (T element: this) {
            if (c.compare(max, element) > 0) {
                max = element;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxArrayDeque<Integer> d = new MaxArrayDeque<>((o1, o2) -> o2 - o1);

        d.addFirst(1);
        d.addFirst(5);
        d.addFirst(2);
        d.addFirst(8);
        System.out.println(d.max());
        System.out.println(d.max(Comparator.comparingInt(o -> o)));
    }
}

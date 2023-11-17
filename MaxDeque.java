import java.util.Collection;
import java.util.Comparator;

public class MaxDeque<T> extends Deque<T> {

    private final Comparator<T> comparator;

    public MaxDeque (Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public T max() {
        return max(comparator);
    }

    public T max(Comparator<T> c) {
        if (size() == 0) return null;
        T max = get(0);
        for (T element: this) {
            if (c.compare(max, element) > 0) {
                max = element;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxDeque<Integer> d = new MaxDeque<>((o1, o2) -> o2 - o1);

        d.addFirst(1);
        d.addFirst(5);
        d.addFirst(2);
        d.addFirst(8);
        System.out.println(d.max());
        System.out.println(d.max((o1, o2) -> o1 - o2));
    }
}

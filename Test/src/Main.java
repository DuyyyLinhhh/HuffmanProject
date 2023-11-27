import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Hello World !!!");
        }
    }

    public ArrayList<Comic> filterComicByPrice(ArrayList<Comic> comics, double minPrice, double maxPrice) {
        ArrayList<Comic> result = new ArrayList<>();
        for (Comic comic : comics) {
            if (comic.getPrice() >= minPrice && comic.getPrice() <= maxPrice) {
                result.add(comic);
            }
        }
        return sortByPrice(result);
    }

    private ArrayList<Comic> sortByPrice(ArrayList<Comic> comics) {
        for (int i = 0; i < comics.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < comics.size(); j++) {
                if (comics.get(minIndex).getPrice() < comics.get(j).getPrice()) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Comic tmp = comics.get(i);
                comics.set(i,comics.get(minIndex));
                comics.set(minIndex, tmp);

            }
        }
        return comics;
    }
}

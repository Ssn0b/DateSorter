import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 * <p>
 * <p>
 * package sample;
 * <p>
 * import java.time.LocalDate;
 * import java.util.Collection;
 * import java.util.List;
 * <p>
 * /**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 * <p>
 * Implement in single class. Don't chane constructor and signature method.
 */

public class DateSorter {
    public static void main(String[] args) {
        List<LocalDate> unsortedDates = new ArrayList<>();
        unsortedDates.add(LocalDate.of(2004, 7, 1)); // July
        unsortedDates.add(LocalDate.of(2005, 1, 2)); // January
        unsortedDates.add(LocalDate.of(2007, 1, 1)); // January
        unsortedDates.add(LocalDate.of(2032, 5, 3)); // May
        unsortedDates.add(LocalDate.of(2022, 3, 15)); // March
        unsortedDates.add(LocalDate.of(2021, 9, 10)); // September

        DateSorter dateSorter = new DateSorter();

        Collection<LocalDate> sortedDates = dateSorter.sortDates(unsortedDates);

        System.out.println("Sorted Dates:");
        for (LocalDate date : sortedDates) {
            System.out.println(date);
        }
    }

    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
     * would sort to
     * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {

        List<LocalDate> datesWithR = unsortedDates.stream()
                .filter(date -> date.getMonth().name().toLowerCase().contains("r"))
                .sorted()
                .collect(Collectors.toList());

        List<LocalDate> datesWithoutR = unsortedDates.stream()
                .filter(date -> !date.getMonth().name().toLowerCase().contains("r"))
                .sorted(Comparator.reverseOrder())
                .toList();

        datesWithR.addAll(datesWithoutR);

        return datesWithR;
    }
}

import java.io.*;
import java.util.*;

public class most_active_cookie {

    /* DESCRIPTION: Prints the most common cookie id for a specific date from a log of cookie
    ids and timestamps. Assumes cookie log is a csv in the readfiles folder. To use in CLI,
    first compile with "javac most_active_cookie.java" and then run with "java most_active_cookie
    cookie_log_filename.csv -d year-month-day".

    INPUTS: cookie log csv filename (must be in readfiles folder, but solution can be very easily
    adjusted to accommodate for different locations) and specific date in question (in format
    2022-17-03).

    OUTPUTS: most common cookie id(s). */

    public static void main(String[] args) {

        // Catch if input is incorrectly formatted
        if (args.length != 3) {
            System.out.println("Invalid input, please include filename, -d flag, and date");
            return;
        }

        // Check if flag is correct
        if (!args[1].equals("-d")) {
            System.out.println("Incorrect flag, try again using '-d' flag");
            return;
        }

        // Read input information , declare variables for reading CSV file
        String fileName = "./readfiles/" + args[0]; // Assumes csv file in readfiles folder
        String relevantDate = args[2];
        String line = "";
        String delimiter = ",";
        HashMap<String, Integer> storage = new HashMap<>();
        boolean reachedDay = false;
        boolean passedDay = false;

        /* Use BufferedReader to read in each line of csv, and split line on the comma. cookieInfo
        contains the cookie id in the 0th index and its timestamp in the 1st index. Then check if
        the timestamp matches the specified date. If so, add the id to a hashmap as a key with its
        count as the value. Since the csv file is assumed to be sorted (most recent occurrence is
        first line), we use boolean logic to break from reading the entire file once we pass the
        specified date. After reading all the relevant lines, we have a map with the relevant ids
        and their respective counts of the times they appear. */

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            String temp = fileReader.readLine(); // Ignore the label line in csv file (cookie, timestamp)
            while ((line=fileReader.readLine()) != null) {
                String[] cookieInfo = line.split(delimiter);
                String currentDate = cookieInfo[1].substring(0, 10);
                if (currentDate.equals(relevantDate)) {
                    if (storage.containsKey(cookieInfo[0])) {
                        int count = 1 + storage.get(cookieInfo[0]);
                        storage.replace(cookieInfo[0], count);
                    } else {
                        storage.put(cookieInfo[0], 1);
                    }
                    reachedDay = true;
                } else {
                    if (reachedDay) {
                        passedDay = true;
                    }
                }
                if (passedDay) {
                    break;
                }
            }
        } catch (IOException ff) {
            System.out.println("Exception " + ff.toString());
        }

        /* Once values are read, we can simply iterate through the relevant cookie ids and
        see what the highest counts are. In total, we use 1 HashMap that contains the inputs
        of only the relevant ids and 1 TreeSet that contains only the cookie ids that have the
        maximum counts. We iterate only through (i + n + 1) lines of the csv, where i is the number
        of lines BEFORE the relevant date and n is the number of lines that occur DURING the relevant
        date. */

        int maxValueSeen = 0;
        TreeSet<String> maxCookies = new TreeSet<>();
        for (String currentCookie: storage.keySet()) {
            int count2 = storage.get(currentCookie);
            if (count2 > maxValueSeen) {
                maxValueSeen = count2;
            }
        }
        for (String currentCookie: storage.keySet()) {
            int count3 = storage.get(currentCookie);
            if (count3 == maxValueSeen) {
                maxCookies.add(currentCookie);
            }
        }
        for (String result: maxCookies) {
            System.out.println(result);
        }
    }
}

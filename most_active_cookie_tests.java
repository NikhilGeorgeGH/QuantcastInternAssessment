public class most_active_cookie_tests {

    public static void basicTest() {
    	// Tests basic functionality
        String[] input = new String[3];
        input[0] = "cookie_log.csv";
        input[1] = "-d";
        input[2] = "2018-12-09";
        most_active_cookie.main(input);
    }

    public static void basicTest2() {
    	// Tests if solution returns multiple cookies if needed
        String[] input = new String[3];
        input[0] = "cookie_log.csv";
        input[1] = "-d";
        input[2] = "2018-12-08";
        most_active_cookie.main(input);
    }

    public static void basicTest3() {
    	// Tests basic functionality
        String[] input = new String[3];
        input[0] = "cookie_log.csv";
        input[1] = "-d";
        input[2] = "2018-12-07";
        most_active_cookie.main(input);
    }

    public static void incorrectInputTest() {
    	// Tests if correct error message displays
        String[] input = new String[2];
        input[0] = "cookie_log.csv";
        input[1] = "-d";
        most_active_cookie.main(input);
    }

    public static void incorrectInputTest2() {
    	// Tests if correct error message displays
        String[] input = new String[3];
        input[0] = "cookie_log.csv";
        input[1] = "-f";
        input[2] = "2018-12-09";
        most_active_cookie.main(input);
    }

    public static void emptyInputTest() {
    	// Tests if doesn't error on empty input
        String[] input = new String[3];
        input[0] = "empty_log.csv";
        input[1] = "-d";
        input[2] = "2018-12-09";
        most_active_cookie.main(input);
    }

    public static void coverageTest() {
    	// Larger input
    	String[] input = new String[3];
        input[0] = "fullday_log.csv";
        input[1] = "-d";
        input[2] = "2018-12-06";
        most_active_cookie.main(input);
    }

    public static void coverageTest2() {
    	// Larger input
    	String[] input = new String[3];
        input[0] = "fullerday_log.csv";
        input[1] = "-d";
        input[2] = "2018-12-06";
        most_active_cookie.main(input);
    }

    public static void coverageTest3() {
    	// Larger input
    	String[] input = new String[3];
        input[0] = "fullestday_log.csv";
        input[1] = "-d";
        input[2] = "2018-12-06";
        most_active_cookie.main(input);
    }

    public static void main(String[] args) {
        System.out.println("Running basic test...");
        System.out.println("Expected:");
        System.out.println("AtY0laUfhglK3lC7");
        System.out.println("Actual:");
        basicTest();
        System.out.println("");

        System.out.println("Running basic test 2...");
        System.out.println("Expected:");
        System.out.println("4sMM2LxV07bPJzwf");
        System.out.println("SAZuXPGUrfbcn5UA");
        System.out.println("fbcn5UAVanZf6UtG");
        System.out.println("Actual:");
        basicTest2();
        System.out.println("");

        System.out.println("Running basic test 3...");
        System.out.println("Expected:");
        System.out.println("4sMM2LxV07bPJzwf");
        System.out.println("Actual:");
        basicTest3();
        System.out.println("");

        System.out.println("Running incorrect input test...");
        System.out.println("Expected:");
        System.out.println("Invalid input, please include filename, -d flag, and date");
        System.out.println("Actual:");
        incorrectInputTest();
        System.out.println("");

        System.out.println("Running incorrect input test 2...");
        System.out.println("Expected:");
        System.out.println("Incorrect flag, try again using '-d' flag");
        System.out.println("Actual:");
        incorrectInputTest2();
        System.out.println("");

        System.out.println("Running empty input test...");
        System.out.println("Expected:");
        System.out.println("");
        System.out.println("Actual:");
        emptyInputTest();
        System.out.println("");

        System.out.println("Running coverage test...");
        System.out.println("Expected:");
        System.out.println("AtY0laUfhglK3lC7");
        System.out.println("Actual:");
        coverageTest();
        System.out.println("");

        System.out.println("Running coverage test 2...");
        System.out.println("Expected:");
        System.out.println("4sMM2LxV07bPJzwf");
        System.out.println("AtY0laUfhglK3lC7");
        System.out.println("SAZuXPGUrfbcn5UA");
        System.out.println("Actual:");
        coverageTest2();
        System.out.println("");

        System.out.println("Running coverage test 3...");
        System.out.println("Expected:");
        System.out.println("SAZuXPGUrfbcn5UA");
        System.out.println("Actual:");
        coverageTest3();
        System.out.println("");


    }

}
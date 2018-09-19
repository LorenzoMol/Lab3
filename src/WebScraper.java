import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * A class whose meaning is obscure to me right now.
 */

public class WebScraper {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int numberOfWords(String url) {

        String urlLines = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String[] urlArr = urlLines.split(" ");

        int counter1 = 0;
        String testCheck = "prince";

        for (int i = 0; i < urlArr.length; i++) {
            if (urlArr[i].toLowerCase().contains(testCheck.toLowerCase())) {
                counter1++;
            }
        }

        return counter1;
    }


    public static void main(String[] used) {
        System.out.println(numberOfWords("http://erdani.com/tdpl/hamlet.txt"));
    }
}

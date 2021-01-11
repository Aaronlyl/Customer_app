import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GET_Requests {

    private String inputLine;
    private String returnString="";

    GET_Requests(String Web_URL)
    {
        makeGetRequest(Web_URL);
    }

    public void makeGetRequest(String Web_URL)
    {
        try {

            URL myURL = new URL(Web_URL);
            HttpURLConnection conn = (HttpURLConnection) myURL.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "text/html");
            conn.setRequestProperty("charset", "utf-8");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(myURL.openStream()));

            // Read the body of the response
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                returnString += inputLine;
            }
            in.close();
            conn.disconnect();
        }catch(Exception e)
        {
            System.out.println("Exception thrown");
        }
    }

    public String returnText()
    {
        return returnString;
    }

}



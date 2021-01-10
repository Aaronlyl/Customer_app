import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class POST_Requests {

    POST_Requests(String message, String url)
    {
        makePostRequest(message, url);
    }

    public void makePostRequest(String message, String url)
    {
        try{
            //Reference Tutorial 6
            // Set up the body data
            byte[] body = message.getBytes(StandardCharsets.UTF_8);
            URL myURL = new URL(url);
            HttpURLConnection conn = null;
            conn = (HttpURLConnection) myURL.openConnection();
            // Set up the header
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "text/html");
            conn.setRequestProperty("charset", "utf-8");
            conn.setRequestProperty("Content-Length", Integer.toString(body.length));
            conn.setDoOutput(true);
            // Write the body of the request
            try (OutputStream outputStream = conn.getOutputStream()) {
                outputStream.write(body, 0, body.length);
            }


            BufferedReader bufferedReader = new BufferedReader(new
                    InputStreamReader(conn.getInputStream(), "utf-8"));
            String inputLine;


            // Read the body of the response
            while ((inputLine = bufferedReader.readLine()) != null) {
                System.out.println(inputLine);
            }



            bufferedReader.close();
            conn.disconnect();

        }

        catch(Exception e)
        {
            System.out.println("Exception thrown");
        }

    }
}

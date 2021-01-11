import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.SQLException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class SIGNIN_Requests {

    private String inputLine;
    private String returnString;

    public SIGNIN_Requests() {
        
    }

    public String makeGetRequest(String Web_URL) throws IOException, SQLException {
        try {
            URL url = new URL(Web_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "text/html");
            conn.setRequestProperty("charset", "utf-8");
            BufferedReader in = new BufferedReader(
                new InputStreamReader((url.openStream()))
            );

            while ((inputLine = in.readLine()) !=null) {
                System.out.println(inputLine);
                returnString += inputLine;
            }
            in.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return returnString;
    }



    public String makePostRequest(String message, String i_url) {
        try {
            byte[] body = message.getBytes(StandardCharsets.UTF_8);
            URL url = new URL(i_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "text/html");
            conn.setRequestProperty("Content-Length", Integer.toString(body.length));
            conn.setDoOutput(true);

            try(OutputStream outputStream = conn.getOutputStream()) {
                outputStream.write(body, 0, body.length);

            }

            BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "utf-8")
            );
            
            while((inputLine = bufferedReader.readLine())!=null) {
                returnString = inputLine;
            }

            bufferedReader.close();
        }

        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return returnString;
    }


}

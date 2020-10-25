import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * @author 61404
 */
public class HttpClient01 {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        String url = "http://localhost:8801";
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println(response.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

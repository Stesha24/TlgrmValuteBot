import JSON.CbAPI;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by 1 on 14.02.2017.
 */
public class GetValute {

    OkHttpClient client = new OkHttpClient();


    String getXML(String url) throws IOException {

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

        static String getValute(String id, String date, String prevDate) throws IOException {
        GetXML getXML = new GetXML(id, date, prevDate);
        Gson gson = new Gson();
        CbAPI cbAPI = gson.fromJson(getXML.gettingXML(), CbAPI.class);

        String[] strings = {
                Arrays.toString(cbAPI.getValCurs().getRecord())

        };

        return Arrays.toString(strings);
    }

    //Get current value of valute.
    static String currentValue(String[] valueMass) {
        float currValue = Float.parseFloat(valueMass[valueMass.length-1]);
        float prevValue = Float.parseFloat(valueMass[valueMass.length-2]);

        String currentValue;
        if (currValue>prevValue){
            currentValue = currValue + "⬆";
        } else {
            currentValue = currValue + "⬇";
        }
        return currentValue;
    }

}

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

    static String getValute() throws IOException {

        GetXML getXML = new GetXML();
        Gson gson = new Gson();
        CbAPI cbAPI = gson.fromJson(getXML.gettingXML(), CbAPI.class);

        String[] strings = {
                Arrays.toString(cbAPI.getValCurs().getRecord())
                //cbAPI.getRecord().getValue()
        };

        return Arrays.toString(strings);
    }


    static void parserIntoMass() throws IOException {

        Splitter splitter = new Splitter();
        String[] splitStr = splitter.split(GetValute.getValute());
        int numberIndex = splitStr.length/4;

        String[] valueMass = new String[numberIndex];
        String[] dateMass = new String[numberIndex];
        String[] nominalMass = new String[numberIndex];
        String[] idMass = new String[numberIndex];

        int counter = 0;
        int index = 0;
        for (int i = 0; i < splitStr.length; i++) {
            switch (counter) {
                case 0: valueMass[index] = splitStr[i]; break;
                case 1: dateMass[index] = splitStr[i]; break;
                case 2: nominalMass[index] = splitStr[i]; break;
                case 3: idMass[index] = splitStr[i]; break;
            }
            if (counter == 3) {
                counter = 0;
                index++;
            } else {
                counter++;
            }
        }

        for (int i = 0; i <valueMass.length ; i++) {
            System.out.println(idMass[i]);
        }


    }
}

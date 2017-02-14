import JSON.CbAPI;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.XML;

import java.io.IOException;

/**
 * Created by 1 on 14.02.2017.
 */
public class GetXML {


    public String gettingXML() throws IOException {
        GetValute gv = new GetValute();
        String xml = gv.getXML("http://www.cbr.ru/scripts/XML_dynamic.asp?date_req1=01/01/2017&date_req2=14/02/2017&VAL_NM_RQ=R01235");

        org.json.JSONObject soapDatainJsonObject = XML.toJSONObject(xml);
        System.out.println(soapDatainJsonObject);
        String gJson = String.valueOf(soapDatainJsonObject);
        return gJson;
    }
}

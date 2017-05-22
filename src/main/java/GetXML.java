import JSON.CbAPI;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.XML;

import java.io.IOException;

/**
 * Getting xml from cb.
 */
public class GetXML {


    private final String id;
    private final String date;
    private final String prevDate;

    public GetXML(String id, String date, String prevDate) {
        this.id = id;
        this.date = date;
        this.prevDate = prevDate;
    }

    public String gettingXML() throws IOException {

        GetValute gv = new GetValute();
        String xml = gv.getXML("http://www.cbr.ru/scripts/XML_dynamic.asp?date_req1="+prevDate+"&date_req2="+date+"&VAL_NM_RQ="+ id);

        org.json.JSONObject soapDatainJsonObject = XML.toJSONObject(xml);
        System.out.println(soapDatainJsonObject);
        String gJson = String.valueOf(soapDatainJsonObject);
        return gJson;
    }
}

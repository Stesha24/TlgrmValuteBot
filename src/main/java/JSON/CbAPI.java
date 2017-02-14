package JSON;


/**
 * Created by 1 on 14.02.2017.
 */
public class CbAPI {

    private ValCurs ValCurs;
    private Record Record;

    public JSON.Record getRecord() {
        return Record;
    }

    public void setRecord(JSON.Record record) {
        Record = record;
    }

    public ValCurs getValCurs ()
    {
        return ValCurs;
    }

    public void setValCurs (ValCurs ValCurs)
    {
        this.ValCurs = ValCurs;
    }

    @Override
    public String toString()
    {
        return "ValCurs = "+ValCurs+"Record = " + Record+"";
    }
}


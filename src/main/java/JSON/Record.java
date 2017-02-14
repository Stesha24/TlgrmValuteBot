package JSON;

/**
 * Created by 1 on 14.02.2017.
 */
public class Record {
    private String Value;

    private String Date;

    private String Nominal;

    private String Id;

    public String getValue ()
    {
        return Value;
    }

    public void setValue (String Value)
    {
        this.Value = Value;
    }

    public String getDate ()
    {
        return Date;
    }

    public void setDate (String Date)
    {
        this.Date = Date;
    }

    public String getNominal ()
    {
        return Nominal;
    }

    public void setNominal (String Nominal)
    {
        this.Nominal = Nominal;
    }

    public String getId ()
    {
        return Id;
    }

    public void setId (String Id)
    {
        this.Id = Id;
    }

    @Override
    public String toString()
    {
        return "Value = "+Value+", Date = "+Date+", Nominal = "+Nominal+", Id = "+Id+"";
    }
}

package JSON;

/**
 * Created by 1 on 14.02.2017.
 */
public class ValCurs {

    private String DateRange1;

    private String DateRange2;

    private Record[] Record;

    private String name;

    private String ID;

    public String getDateRange1 ()
    {
        return DateRange1;
    }

    public void setDateRange1 (String DateRange1)
    {
        this.DateRange1 = DateRange1;
    }

    public String getDateRange2 ()
    {
        return DateRange2;
    }

    public void setDateRange2 (String DateRange2)
    {
        this.DateRange2 = DateRange2;
    }

    public Record[] getRecord ()
    {
        return Record;
    }

    public void setRecord (Record[] Record)
    {
        this.Record = Record;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getID ()
    {
        return ID;
    }

    public void setID (String ID)
    {
        this.ID = ID;
    }

    @Override
    public String toString()
    {
        return "DateRange1 = "+DateRange1+", DateRange2 = "+DateRange2+", Record = "+Record+", name = "+name+", ID = "+ID+"";
    }
    }


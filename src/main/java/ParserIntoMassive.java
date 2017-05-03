import java.io.IOException;

/**
 * Parsing JSON into arrays.
 */
public class ParserIntoMassive {

    String[] valueMass;
    String[] dateMass;
    String[] nominalMass;
    String[] idMass;

    void parserIntoMass(String id, String date, String prevDate) throws IOException {
        Splitter splitter = new Splitter();
        String[] splitStr = splitter.split(GetValute.getValute(id, date, prevDate));
        int numberIndex = splitStr.length / 4;

        String[] valueMass = new String[numberIndex];
        String[] dateMass = new String[numberIndex];
        String[] nominalMass = new String[numberIndex];
        String[] idMass = new String[numberIndex];

        int counter = 0;
        int index = 0;
        for (int i = 0; i < splitStr.length; i++) {
            switch (counter) {
                case 0:
                    valueMass[index] = splitStr[i];
                    break;
                case 1:
                    dateMass[index] = splitStr[i];
                    break;
                case 2:
                    nominalMass[index] = splitStr[i];
                    break;
                case 3:
                    idMass[index] = splitStr[i];
                    break;
            }
            if (counter == 3) {
                counter = 0;
                index++;
            } else {
                counter++;
            }
        }

        valueMass[0] = valueMass[0].replaceAll("Value = ", "");
        valueMass[0] = valueMass[0].replaceAll(",", ".");
        for (int i = 1; i < valueMass.length; i++) {
            valueMass[i] = valueMass[i].replaceAll(" Value = ", "");
            valueMass[i] = valueMass[i].replaceAll(",", ".");
            System.out.println(valueMass[i]);
        }

        for (int i = 0; i < dateMass.length; i++) {
            dateMass[i] = dateMass[i].replaceAll(" Date = ", "");
            System.out.println(dateMass[i]);
        }

        for (int i = 0; i < nominalMass.length; i++) {
            nominalMass[i] = nominalMass[i].replaceAll(" Nominal = ", "");
            System.out.println(nominalMass[i]);
        }

        for (int i = 0; i < idMass.length; i++) {
            idMass[i] = idMass[i].replaceAll(" Id = ", "");
            System.out.println(idMass[i]);
        }

        this.valueMass = valueMass;
        this.dateMass = dateMass;
        this.nominalMass = nominalMass;
        this.idMass = idMass;

    }
}
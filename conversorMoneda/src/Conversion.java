import com.google.gson.annotations.JsonAdapter;

public class Conversion {


    private String USD;
    private String ARS;
    private String BOB;
    private String BRL;
    private String CLP;
    private String COP;

    public Conversion() {

    }

    public Conversion(String USD, String COP, String ARS, String BOB, String BRL, String CLP) {
        this.USD = USD;
        this.COP = COP;
        this.ARS = ARS;
        this.BOB = BOB;
        this.BRL = BRL;
        this.CLP = CLP;
    }

    public String getUSD() {
        return USD;
    }

    public void setUSD(String USD) {
        this.USD = USD;
    }

    public String getARS() {
        return ARS;
    }

    public void setARS(String ARS) {
        this.ARS = ARS;
    }

    public String getBOB() {
        return BOB;
    }

    public void setBOB(String BOB) {
        this.BOB = BOB;
    }

    public String getBRL() {
        return BRL;
    }

    public void setBRL(String BRL) {
        this.BRL = BRL;
    }

    public String getCOP() {
        return COP;
    }

    public void setCOP(String COP) {
        this.COP = COP;
    }

    public String getCLP() {
        return CLP;
    }

    public void setCLP(String CLP) {
        this.CLP = CLP;
    }

    @Override
    public String toString() {
        return "Conversion{" +
                "USD='" + USD + '\'' +
                ", ARS='" + ARS + '\'' +
                ", BOB='" + BOB + '\'' +
                ", BRL='" + BRL + '\'' +
                ", CLP='" + CLP + '\'' +
                ", COP='" + COP + '\'' +
                '}';
    }
}

import com.google.gson.annotations.SerializedName;

public class ConversionRates {
    @SerializedName("result")
    private String result;

    @SerializedName("base_code")
    private String baseCode;

    @SerializedName("conversion_rates")
    private Rates conversionRates;


    public String getResult() {
        return result;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public Rates getConversionRates() {
        return conversionRates;
    }


    public static class Rates {
        @SerializedName("USD")
        private double usd;

        @SerializedName("ARS")
        private double ars;

        @SerializedName("BRL")
        private double brl;

        @SerializedName("COP")
        private double cop;

        @SerializedName("EUR")
        private double eur;

        @SerializedName("GBP")
        private double gbp;

        @SerializedName("JPY")
        private double jpy;

        @SerializedName("MXN")
        private double mxn;

        @SerializedName("CLP")
        private double clp;

        @SerializedName("PEN")
        private double pen;

        @SerializedName("CAD")
        private double cad;

        @SerializedName("AUD")
        private double aud;

        @SerializedName("CHF")
        private double chf;

        @SerializedName("CNY")
        private double cny;


        public double getUsd() { return usd; }
        public double getArs() { return ars; }
        public double getBrl() { return brl; }
        public double getCop() { return cop; }
        public double getEur() { return eur; }
        public double getGbp() { return gbp; }
        public double getJpy() { return jpy; }
        public double getMxn() { return mxn; }
        public double getClp() { return clp; }
        public double getPen() { return pen; }
        public double getCad() { return cad; }
        public double getAud() { return aud; }
        public double getChf() { return chf; }
        public double getCny() { return cny; }
    }
}

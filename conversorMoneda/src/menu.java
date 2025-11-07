import com.google.gson.Gson;
import java.util.Scanner;

public class menu {

    private ConversionRates conversionRates;
    private Scanner scanner;
    private Gson gson;

    public menu() {
        this.scanner = new Scanner(System.in);
        this.gson = new Gson();
    }

    public void menuConvertor() {
        boolean salir = false;

        while (!salir) {
            System.out.println("""
                *******************************
                Sea bienvenido/a al Conversor de Moneda =]
                
                1) Dólar => Peso argentino
                2) Peso argentino => Dólar
                3) Dólar => Real brasileño
                4) Real brasileño => Dólar
                5) Dólar => Peso colombiano
                6) Peso colombiano => Dólar
                7) Dólar => Euro
                8) Euro => Dólar
                9) Dólar => Libra esterlina
                10) Libra esterlina => Dólar
                11) Dólar => Yen japonés
                12) Yen japonés => Dólar
                13) Dólar => Peso mexicano
                14) Peso mexicano => Dólar
                15) Dólar => Peso chileno
                16) Peso chileno => Dólar
                17) Dólar => Sol peruano
                18) Sol peruano => Dólar
                19) Dólar => Dólar canadiense
                20) Dólar canadiense => Dólar
                21) Dólar => Dólar australiano
                22) Dólar australiano => Dólar
                23) Dólar => Franco suizo
                24) Franco suizo => Dólar
                25) Dólar => Yuan chino
                26) Yuan chino => Dólar
                27) Salir
                
                Elija una opción válida:
                *******************************
                """);

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    realizarConversion("USD", "ARS", "Dólar", "Peso argentino");
                    break;
                case 2:
                    realizarConversion("ARS", "USD", "Peso argentino", "Dólar");
                    break;
                case 3:
                    realizarConversion("USD", "BRL", "Dólar", "Real brasileño");
                    break;
                case 4:
                    realizarConversion("BRL", "USD", "Real brasileño", "Dólar");
                    break;
                case 5:
                    realizarConversion("USD", "COP", "Dólar", "Peso colombiano");
                    break;
                case 6:
                    realizarConversion("COP", "USD", "Peso colombiano", "Dólar");
                    break;
                case 7:
                    realizarConversion("USD", "EUR", "Dólar", "Euro");
                    break;
                case 8:
                    realizarConversion("EUR", "USD", "Euro", "Dólar");
                    break;
                case 9:
                    realizarConversion("USD", "GBP", "Dólar", "Libra esterlina");
                    break;
                case 10:
                    realizarConversion("GBP", "USD", "Libra esterlina", "Dólar");
                    break;
                case 11:
                    realizarConversion("USD", "JPY", "Dólar", "Yen japonés");
                    break;
                case 12:
                    realizarConversion("JPY", "USD", "Yen japonés", "Dólar");
                    break;
                case 13:
                    realizarConversion("USD", "MXN", "Dólar", "Peso mexicano");
                    break;
                case 14:
                    realizarConversion("MXN", "USD", "Peso mexicano", "Dólar");
                    break;
                case 15:
                    realizarConversion("USD", "CLP", "Dólar", "Peso chileno");
                    break;
                case 16:
                    realizarConversion("CLP", "USD", "Peso chileno", "Dólar");
                    break;
                case 17:
                    realizarConversion("USD", "PEN", "Dólar", "Sol peruano");
                    break;
                case 18:
                    realizarConversion("PEN", "USD", "Sol peruano", "Dólar");
                    break;
                case 19:
                    realizarConversion("USD", "CAD", "Dólar", "Dólar canadiense");
                    break;
                case 20:
                    realizarConversion("CAD", "USD", "Dólar canadiense", "Dólar");
                    break;
                case 21:
                    realizarConversion("USD", "AUD", "Dólar", "Dólar australiano");
                    break;
                case 22:
                    realizarConversion("AUD", "USD", "Dólar australiano", "Dólar");
                    break;
                case 23:
                    realizarConversion("USD", "CHF", "Dólar", "Franco suizo");
                    break;
                case 24:
                    realizarConversion("CHF", "USD", "Franco suizo", "Dólar");
                    break;
                case 25:
                    realizarConversion("USD", "CNY", "Dólar", "Yuan chino");
                    break;
                case 26:
                    realizarConversion("CNY", "USD", "Yuan chino", "Dólar");
                    break;
                case 27:
                    salir = true;
                    System.out.println("¡Gracias por usar el conversor! ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        scanner.close();
    }

    public void parsearJson(String json) {
        try {
            this.conversionRates = gson.fromJson(json, ConversionRates.class);

            if (conversionRates != null && "success".equals(conversionRates.getResult())) {
                System.out.println("✓ Tasas de cambio para " + conversionRates.getBaseCode() + " cargadas correctamente");
            } else {
                System.out.println("✗ Error al cargar las tasas de cambio");
            }
        } catch (Exception e) {
            System.out.println("Error al parsear JSON: " + e.getMessage());
        }
    }

    private void realizarConversion(String monedaBase, String monedaDestino, String nombreBase, String nombreDestino) {
        // Cargar las tasas de cambio para la moneda base seleccionada
        Main.cargarTasasDeCambio(monedaBase);

        if (conversionRates == null || conversionRates.getConversionRates() == null) {
            System.out.println("Error: No hay tasas de cambio disponibles");
            return;
        }

        try {
            // Pedir al usuario la cantidad a convertir
            System.out.print("Ingrese la cantidad en " + nombreBase + ": ");
            double cantidad = scanner.nextDouble();
            scanner.nextLine(); // Limpiar buffer

            // Obtener la tasa de conversión usando los getters de la clase
            double tasaDestino = obtenerTasa(monedaDestino);

            if (tasaDestino == 0) {
                System.out.println("Error: La moneda destino no está disponible");
                return;
            }

            // Realizar la conversión directa
            double cantidadConvertida = cantidad * tasaDestino;

            // Mostrar resultado
            System.out.println("\n=== RESULTADO DE LA CONVERSIÓN ===");
            System.out.printf("%,.2f %s = %,.2f %s%n",
                    cantidad, nombreBase, cantidadConvertida, nombreDestino);
            System.out.println("===================================\n");

        } catch (Exception e) {
            System.out.println("Error en la conversión: " + e.getMessage());
        }
    }

    private double obtenerTasa(String moneda) {
        ConversionRates.Rates rates = conversionRates.getConversionRates();

        switch (moneda) {
            case "USD": return rates.getUsd();
            case "ARS": return rates.getArs();
            case "BRL": return rates.getBrl();
            case "COP": return rates.getCop();
            case "EUR": return rates.getEur();
            case "GBP": return rates.getGbp();
            case "JPY": return rates.getJpy();
            case "MXN": return rates.getMxn();
            case "CLP": return rates.getClp();
            case "PEN": return rates.getPen();
            case "CAD": return rates.getCad();
            case "AUD": return rates.getAud();
            case "CHF": return rates.getChf();
            case "CNY": return rates.getCny();
            default: return 0;
        }
    }
}

💱 Conversor de Monedas
Un conversor de monedas desarrollado en Java que utiliza la API de ExchangeRate-API para obtener tasas de cambio en tiempo real.

*******************************
🚀 Características
26 pares de monedas disponibles para conversión

Tasas de cambio en tiempo real mediante API

Interfaz de línea de comandos fácil de usar

Conversiones precisas con formato adecuado

Arquitectura orientada a objetos con Gson para mapeo JSON

*******************************
📋 Monedas Disponibles
Código	Moneda
USD	Dólar Estadounidense
ARS	Peso Argentino
BRL	Real Brasileño
COP	Peso Colombiano
EUR	Euro
GBP	Libra Esterlina
JPY	Yen Japonés
MXN	Peso Mexicano
CLP	Peso Chileno
PEN	Sol Peruano
CAD	Dólar Canadiense
AUD	Dólar Australiano
CHF	Franco Suizo
CNY	Yuan Chino
*******************************

🛠️ Tecnologías Utilizadas
Java 21

Gson - Para el mapeo de JSON a objetos Java

HttpClient - Para las peticiones HTTP a la API

ExchangeRate-API - Como proveedor de tasas de cambio
*******************************
📦 Instalación
Prerrequisitos
Java 11 o superior

Maven o Gradle (para gestión de dependencias)

API Key de ExchangeRate-API
*******************************
Configuración
Clona el repositorio:

git clone https://github.com/tu-usuario/conversor-monedas.git
cd conversor-monedas
Configura tu API Key:

Obtén una API Key gratuita en ExchangeRate-API

En la clase Main.java, reemplaza "TU_API_KEY" por tu clave real:

java
private static final String API_BASE_URL = "https://v6.exchangerate-api.com/v6/TU_CLAVE_REAL/latest/";
Compila y ejecuta:

javac -cp ".:gson-2.8.9.jar" *.java
java -cp ".:gson-2.8.9.jar" Main
*******************************
🎯 Uso
Flujo del Programa
Inicio: El programa se conecta automáticamente a la API

Menú Principal: Se muestran 26 opciones de conversión

Selección: Elige el par de monedas deseado

Entrada: Ingresa la cantidad a convertir

Resultado: Obtén el valor convertido instantáneamente

Ejemplo de Uso
*******************************
Sea bienvenido/a al Conversor de Moneda =]

1) Dólar => Peso argentino
2) Peso argentino => Dólar
3) Dólar => Real brasileño
...
26) Yuan chino => Dólar
27) Salir

Elija una opción válida:
*******************************
1
Ingrese la cantidad en Dólar: 100

=== RESULTADO DE LA CONVERSIÓN ===
100.00 Dólar = 144,750.00 Peso argentino
===================================

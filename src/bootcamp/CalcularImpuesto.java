package bootcamp;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class CalcularImpuesto {
    public static Double parseArgentinianPeso(String sMonto) {
        sMonto = sMonto.replaceAll("[^\\d,]+", "");
        sMonto = sMonto.replace(",", ".");
        return Double.parseDouble(sMonto);
    }

    public static Double parseUSD(String sMonto) {
        sMonto = sMonto.replaceAll("[^\\d.]+", "");
        return Double.parseDouble(sMonto);
    }

    public static void main(String[] args) {
        String sMonto = "0.0";
        Double dMontoBruto = 0.0, dMontoTotal = 0.0;
//        Locale locale = new Locale("es", "AR");

        System.out.print("Ingrese el monto bruto ganado en la lotería: ");
        Scanner teclado = new Scanner(System.in);
        sMonto = teclado.nextLine();

//        // This option uses a basic currency parser.
//        dMontoBruto = parseUSD(sMonto);

        // Preferably use the NumberFormat class to parse the currency string to a Number object.
        try {
//            // Using the argentinian Locale for Currency conversion outputs the following exception:
//            // java.text.ParseException: Unparseable number: "$23.563.899,00"
//            Number nMontoBruto = NumberFormat.getCurrencyInstance(locale).parse(sMonto);
            Number nMontoBruto = NumberFormat.getCurrencyInstance(Locale.US).parse(sMonto);
            dMontoBruto = (Double) nMontoBruto.doubleValue();
        } catch (ParseException e) {
            System.out.println(e);
        }

        Double impuestos[] = {0.0245, 0.15, 0.03};

        dMontoTotal = dMontoBruto;
        for (double impuesto:impuestos) {
            dMontoTotal -= impuesto * dMontoBruto;
        }

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        sMonto = formatter.format(dMontoTotal);
        System.out.format("El monto total del premio es de %s", sMonto);
    }
}

package bootcamp;

import java.util.Scanner;

public class CalcularCosto {
    public static void main(String[] args) {
        System.out.print("Ingrese la cantidad de días de la campaña: ");

        Scanner teclado = new Scanner(System.in);
        int dias = teclado.nextInt();
        double costo = dias * 2.0;

        System.out.format("%d días de campaña → $%d * %d = $%.2f", dias, 2, dias, costo);
    }
}

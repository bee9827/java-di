package exchangerate.decoupled.provider;

import java.util.Scanner;

public class StandardInputExchangeRateProvider implements ExchangeRateProvider {

    Scanner scanner = new Scanner(System.in);

    @Override
    public double getExchangeRate() {
        return scanner.nextDouble();
    }
}

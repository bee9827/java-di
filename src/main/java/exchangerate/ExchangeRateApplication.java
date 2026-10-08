package exchangerate;

import exchangerate.decoupled.ExchangeRateSupportFactory;
import exchangerate.decoupled.renderer.ExchangeRateRenderer;

public class ExchangeRateApplication {
    public static void main(String[] args) {
        ExchangeRateRenderer renderer = ExchangeRateSupportFactory
                .getInstance()
                .getExchangeRateRenderer();
        renderer.render();
    }
}

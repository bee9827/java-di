package exchangerate;

import exchangerate.decoupled.provider.ExchangeRateProvider;
import exchangerate.decoupled.provider.StandardInputExchangeRateProvider;
import exchangerate.decoupled.renderer.ExchangeRateRenderer;
import exchangerate.decoupled.renderer.StandardOutputExchangeRateRenderer;

public class ExchangeRateApplication {
    public static void main(String[] args) {
        ExchangeRateProvider provider = new StandardInputExchangeRateProvider();
        ExchangeRateRenderer renderer = new StandardOutputExchangeRateRenderer();
        renderer.setExchangeRateProvider(provider);
        renderer.render();
    }
}

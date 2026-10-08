package exchangerate.decoupled.renderer;

import exchangerate.decoupled.provider.ExchangeRateProvider;

public interface ExchangeRateRenderer {
    void render();

    void setExchangeRateProvider(ExchangeRateProvider provider);

    ExchangeRateProvider getExchangeRateProvider();
}

package exchangerate.decoupled;

import exchangerate.decoupled.provider.ExchangeRateProvider;
import exchangerate.decoupled.renderer.ExchangeRateRenderer;

public final class ExchangeRateSupportFactory {
    private static final ExchangeRateSupportFactory INSTANCE;
    private final ExchangeRateProvider exchangeRateProvider;
    private final ExchangeRateRenderer exchangeRateRenderer;

    static {
        INSTANCE = null;
    }

    private ExchangeRateSupportFactory() {
        this.exchangeRateProvider = null;
        this.exchangeRateRenderer = null;
    }

    public static ExchangeRateSupportFactory getInstance() {
        return INSTANCE;
    }

    public ExchangeRateProvider getExchangeRateProvider() {
        return exchangeRateProvider;
    }

    public ExchangeRateRenderer getExchangeRateRenderer() {
        return exchangeRateRenderer;
    }
}

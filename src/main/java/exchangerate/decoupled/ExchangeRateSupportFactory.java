package exchangerate.decoupled;

import exchangerate.decoupled.provider.ExchangeRateProvider;
import exchangerate.decoupled.renderer.ExchangeRateRenderer;
import java.io.InputStream;
import java.util.Properties;

public final class ExchangeRateSupportFactory {
    private static final ExchangeRateSupportFactory INSTANCE;

    static {
        INSTANCE = new ExchangeRateSupportFactory();
    }

    private final ExchangeRateProvider exchangeRateProvider;
    private final ExchangeRateRenderer exchangeRateRenderer;

    private ExchangeRateSupportFactory() {
        Properties properties = new Properties();
        try (InputStream resources = this.getClass().getResourceAsStream("/exchange-rate.properties")) {
            properties.load(resources);

            final String providerClass = properties.getProperty("provider.class");
            final String rendererClass = properties.getProperty("renderer.class");

            exchangeRateProvider = (ExchangeRateProvider) Class.forName(providerClass)
                    .getDeclaredConstructor()
                    .newInstance();
            exchangeRateRenderer = (ExchangeRateRenderer) Class.forName(rendererClass)
                    .getDeclaredConstructor()
                    .newInstance();

            exchangeRateRenderer.setExchangeRateProvider(exchangeRateProvider);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

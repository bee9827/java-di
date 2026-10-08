package exchangerate.decoupled;

import exchangerate.decoupled.provider.DaumExchangeRateProvider;
import exchangerate.decoupled.provider.ExchangeRateProvider;
import exchangerate.decoupled.renderer.ExchangeRateRenderer;
import exchangerate.decoupled.renderer.StandardOutputExchangeRateRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@ComponentScan(basePackages = {"com.example.ioc.decoupled"})
//@ImportResource(locations = {"classpath:app-context-xml.xml"})
@Configuration
public class ExchangeRateConfiguration {

    @Bean
    public ExchangeRateProvider exchangeRateProvider() {
        return new DaumExchangeRateProvider();
    }

    @Bean
    public ExchangeRateRenderer exchangeRateRenderer() {
        final var renderer = new StandardOutputExchangeRateRenderer();
        renderer.setExchangeRateProvider(exchangeRateProvider());
        return renderer;
    }
}

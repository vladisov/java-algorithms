package dev.algos.snatch.api.config.module;

import com.google.inject.AbstractModule;
import dev.algos.snatch.api.config.Startup;

public class AppModule extends AbstractModule {

    protected void configure() {
        bind(Startup.class);
        install(new FileModule());
        install(WebModule.create());
    }
}

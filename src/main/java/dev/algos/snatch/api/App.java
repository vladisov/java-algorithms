package dev.algos.snatch.api;

import com.google.inject.Guice;
import dev.algos.snatch.api.config.EntrypointType;
import dev.algos.snatch.api.config.Startup;
import dev.algos.snatch.api.config.module.AppModule;

public class App {

    public static void main(String[] args) {
        var injector = Guice.createInjector(new AppModule());
        injector.getInstance(Startup.class).boot(EntrypointType.REST, args);
    }
}

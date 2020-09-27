package dev.algos.snatch.api.config.module;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import dev.algos.snatch.api.config.AppEntrypoint;
import dev.algos.snatch.api.config.EntrypointType;
import dev.algos.snatch.api.config.WebEntrypoint;
import io.javalin.Javalin;
import org.jetbrains.annotations.NotNull;

class WebModule extends AbstractModule {
    private Javalin app;

    private WebModule(Javalin app) {
        this.app = app;
    }

    @NotNull
    public static WebModule create() {
        Javalin app = Javalin.create();
        return new WebModule(app);
    }

    @Override
    protected void configure() {
        bind(Javalin.class).toInstance(app);
        MapBinder.newMapBinder(binder(), EntrypointType.class, AppEntrypoint.class)
                .addBinding(EntrypointType.REST)
                .to(WebEntrypoint.class);
    }
}

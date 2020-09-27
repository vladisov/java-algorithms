package dev.algos.snatch.api.config;

import com.google.inject.Inject;
import io.javalin.Javalin;

import javax.inject.Singleton;
import java.util.Set;

@Singleton
public class WebEntrypoint implements AppEntrypoint {
    private Javalin app;

    @Inject(optional = true)
    private Set<Routing> routes = Set.of();

    @Inject
    public WebEntrypoint(Javalin app) {
        this.app = app;
    }

    @Override
    public void boot(String[] args) {
        bindRoutes();
        app.start(7000);
        app.before(context -> context.header("Access-Control-Allow-Origin", "*")); // TODO temporary
    }

    private void bindRoutes() {
        routes.forEach(Routing::bindRoutes);
    }
}

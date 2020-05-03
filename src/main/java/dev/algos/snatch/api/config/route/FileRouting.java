package dev.algos.snatch.api.config.route;

import dev.algos.snatch.api.config.Routing;
import dev.algos.snatch.api.controller.FileController;
import io.javalin.Javalin;

import javax.inject.Inject;
import javax.inject.Singleton;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;

@Singleton
public class FileRouting extends Routing<FileController> {

    private Javalin javalin;

    @Inject
    public FileRouting(Javalin javalin) {
        this.javalin = javalin;
    }

    @Override
    public void bindRoutes() {
        javalin.routes(() -> {
            path("/", () -> get(ctx -> getController().root(ctx)));
            path("/:path", () -> get(ctx -> getController().getByPath(ctx)));
        });
    }
}

package dev.algos.snatch.api.config.route;

import dev.algos.snatch.api.config.Routing;
import dev.algos.snatch.api.controller.FileController;
import dev.algos.snatch.api.dto.ApiError;
import dev.algos.snatch.api.exception.PathNotFound;
import io.javalin.Javalin;

import javax.inject.Inject;
import javax.inject.Singleton;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;

@Singleton
public class FileRouting extends Routing<FileController> {

    private Javalin app;

    @Inject
    public FileRouting(Javalin javalin) {
        this.app = javalin;
    }

    @Override
    public void bindRoutes() {
        app.routes(() -> {
            path("/", () -> get(ctx -> getController().root(ctx)));
            path("/:path", () -> get(ctx -> getController().getByPath(ctx)));
        });

        app.exception(IllegalArgumentException.class, (e, ctx) ->
                ctx.json(new ApiError(400, e.getMessage())).status(400));

        app.exception(PathNotFound.class,
                (e, ctx) -> ctx.json(new ApiError(404, e.getMessage())).status(404));
    }
}

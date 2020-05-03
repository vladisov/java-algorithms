package dev.algos.snatch.api.controller;

import dev.algos.snatch.api.service.FileStorage;
import io.javalin.http.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FileController {

    FileStorage fileStorage;

    @Inject
    public FileController(FileStorage fileStorage) {
        this.fileStorage = fileStorage;
    }

    public void root(Context context) {
        context.json(fileStorage.getFiles(""));
    }

    public void getByPath(Context context) {
        String path = context.pathParam("path");
        context.json(fileStorage.getFiles(path));
    }
}

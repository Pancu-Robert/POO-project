package fileio;

import java.io.FileWriter;
import java.io.IOException;

public final class Writer {
    private final FileWriter file;


    public Writer(final String path) throws IOException {
        this.file = new FileWriter(path);
    }
}

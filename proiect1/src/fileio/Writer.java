package fileio;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.Constants;
import outputData.OutputData;

import java.io.FileWriter;
import java.io.IOException;

public final class Writer {

    public Writer() {
    }

    public void writeOutput(final OutputData outputData, final int testNumber) throws IOException {
        String outputPath = Constants.OUTPUT_PATH + testNumber + Constants.FILE_EXTENSION;
        new ObjectMapper().writerWithDefaultPrettyPrinter()
                .writeValue(new FileWriter(outputPath), outputData);
    }
}

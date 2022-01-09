package fileio;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.Constants;
import outputdata.OutputData;

import java.io.FileWriter;
import java.io.IOException;

public final class Writer {

    public Writer() {
    }

    /**
     * Creez un string care creeaza calea catre fiecare test de output, iar cu
     * ObjectMapper().writerWithDefaultPrettyPrinter() afisez datele intr-un format usor
     * de citit si inteles specific obiectelor JSON.
     * @param outputData toate datele de iesire pentru anumit test
     * @param testNumber numarul testului
     * @throws IOException
     */
    public void writeOutput(final OutputData outputData, final int testNumber) throws IOException {
        String outputPath = Constants.OUTPUT_PATH + testNumber + Constants.FILE_EXTENSION;
        new ObjectMapper().writerWithDefaultPrettyPrinter()
                .writeValue(new FileWriter(outputPath), outputData);
    }
}

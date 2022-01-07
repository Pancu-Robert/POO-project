package main;

import checker.Checker;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.Constants;
import database.Database;
import fileio.Input;

import java.io.File;
import java.io.IOException;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        for (int i = 1; i <= Constants.TESTS_NUMBER; i++) {
            File inputFile = new File(Constants.TESTS_PATH + i + Constants.FILE_EXTENSION);
            Input input = objectMapper.readValue(inputFile, Input.class);
            Database.initDatabase(input);
        }
        Checker.calculateScore();
    }
}

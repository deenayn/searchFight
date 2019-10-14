package utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.NoSuchFileException;
import java.util.stream.Collectors;

public class FileUtils {

    public static String readFile(Class clazz, String path) throws NoSuchFileException {
        InputStream stream = clazz.getClassLoader().getResourceAsStream(path);
        if (stream == null) {
            throw new NoSuchFileException(path);
        }
        return new BufferedReader(new InputStreamReader(stream))
                .lines().collect(Collectors.joining("\n"));
    }
}

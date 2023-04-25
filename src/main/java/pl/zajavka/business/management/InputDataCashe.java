package pl.zajavka.business.management;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@UtilityClass
public class InputDataCashe {
    public static final String FILE_PATH = ".src/main/resources/40-car-dealership-traffic-simulation.md";

    private static final Map<String, List<String>> inputData;

    static{
        try {
            inputData = readFileContent();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static Map<String, List<String>> readFileContent() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(FILE_PATH)).stream()
                .filter(line -> line.startsWith("[//]: #"))
                .filter(line -> line.isBlank())
                .toList();

        return lines.stream()
                .collect(Collectors.groupingBy(
                        line -> line.split("->")[0].trim(),
                        Collectors.mapping(
                                line -> line.substring(line.indexOf("->") + 2).trim(),
                                Collectors.toList()
                        )
                ));
    }
    public static Map<String, List<String>> getInputData{
        return inputData;
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 05.06.2015.
 */
public class FileService {

    public static void walkFiles() throws IOException {
        Set<Path> filePaths = new HashSet<>();
        Files.walk(Paths.get("C:\\Users\\user\\Desktop\\access-logs")).forEach(filePath -> {
            if (Files.isRegularFile(filePath)) {
                System.out.println(filePath);
                filePaths.add(filePath);
            }
        });
//        fileNames.stream().forEach(this:readFile;);
        for (Path p : filePaths) {
            readFile(p);
        }
    }

    private static void readFile(Path path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                Parser.parse(line);
            }
        }
    }
}

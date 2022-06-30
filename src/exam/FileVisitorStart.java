package exam;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Map;

public class FileVisitorStart {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get("/Users/veronika/Desktop/books");
        Files.walkFileTree(start, new FilesCollector());

        FilesCollector fc = new FilesCollector();
        Files.walkFileTree(Path.of("/Users/veronika/Desktop/books"), fc);
        List<Path> allFiles = fc.getAllFiles();
        Map<String, List<Path>> allFilesByExtension = fc.getFilesByExtension();

    }
}

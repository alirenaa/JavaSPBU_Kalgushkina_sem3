package exam;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilesCollector implements FileVisitor<Path>{

    List<Path> ListOfFiles = new ArrayList<>();
    Map<String, List<Path>> ListFilesByExtension = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
        System.out.println("Найден файл:" + file.toString());
        if (!Files.isDirectory(file)) {
            ListOfFiles.add(file);


            String[] arrayAfterSplit= file.toString().split("\\.");
            String extension = arrayAfterSplit[arrayAfterSplit.length - 1].toLowerCase();
            if (ListFilesByExtension.containsKey(extension)) {
                List<Path> ListOfFilesOfExt = ListFilesByExtension.get(extension);
                ListOfFilesOfExt.add(file);
                ListFilesByExtension.remove(extension);
                ListFilesByExtension.put(extension, ListOfFilesOfExt);
            }
            List<Path> ListOfFilesOfExt = new ArrayList<>();
            ListOfFilesOfExt.add(file);
            ListFilesByExtension.putIfAbsent(extension, ListOfFilesOfExt);

        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc){
        System.out.println("Найден файл: " + file.toString() + "С ошибкой:" + exc.toString());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs){
        System.out.println("Заходим в каталог: " + dir.toString());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc){
        System.out.println("Выходим из каталога:" + dir.toString());
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getAllFiles() throws IOException{
        return ListOfFiles;
    }

    public Map<String, List<Path>> getFilesByExtension() throws IOException{
        System.out.println(ListFilesByExtension);
        return ListFilesByExtension;
    }

}

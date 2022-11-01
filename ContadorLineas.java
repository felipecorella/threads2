package threads2;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class ContadorLineas extends SimpleFileVisitor<Path>   {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        String name = file.toAbsolutePath().toString();

        if( name.toLowerCase().endsWith(".txt")) {
            Thread contador = new Thread( new Threads2(name) );
            contador.start();
        }
        return super.visitFile(file, attrs);
    }
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.printf("No se puede procesar:%30s%n", file.toString()) ;
        return super.visitFileFailed(file, exc);
    }

    public static void main(String[] args) throws IOException {

        
        if (args.length < 1) {
            System.exit(2);
        }

        
        Path startingDir = Paths.get(args[0]);

        
        ContadorLineas contadorLineas = new ContadorLineas();

        
        Files.walkFileTree(startingDir, contadorLineas);
    }
}

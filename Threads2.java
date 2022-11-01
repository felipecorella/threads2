
package threads2;

import java.io.*;

public class Threads2 implements Runnable{
    private FileReader fl = null;
    private BufferedReader in = null;
    private String name;

    public Threads2 (String name) {
        this.name = name;
        try {
            fl = new FileReader(name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        in = new BufferedReader(fl);
    }

    @Override
    public void run() {
        int contadorLineas = 0;
        String linea = null;
        long t1 = System.currentTimeMillis();
        while (true) {
            try {
                if (!((linea = in.readLine()) != null))
                    break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            contadorLineas++;
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(Thread.currentThread().getName());
        System.out.println(" "+name);
        System.out.println("Número de líneas: "+contadorLineas);
    }
}

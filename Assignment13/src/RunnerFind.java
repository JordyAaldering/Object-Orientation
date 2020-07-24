import java.io.*;

public class RunnerFind implements Runnable {
    private final FileFinder ff;
    private final String fileName;

    RunnerFind(String rootDir, String fileName) throws IOException {
        ff = new FileFinder(rootDir);
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            ff.findFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

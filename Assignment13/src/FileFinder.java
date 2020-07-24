import java.io.*;

class FileFinder {
    private final File rootDir;

    FileFinder(String root) throws IOException {
        rootDir = new File(root);
        if (!(rootDir.exists() && rootDir.isDirectory())) {
            throw new IOException(root+" is not a directory");
        }
    }

    void findFile(String fileName) throws IOException {
        find(rootDir, fileName);
    }

    private void find(File rootDir, String fileName) throws IOException {
        File[] files = rootDir.listFiles();
        if (files != null) {
            for (File file: files) {
                if (file.getName().equals(fileName)) {
                    // System.out.println("Found at: "+file.getAbsolutePath());
                    return;
                } else if (file.isDirectory()) {
                    // System.out.println("Looking at: "+file.getAbsolutePath());
                    RunnerFind r = new RunnerFind(file.getAbsolutePath(), fileName);
                    Thread t = new Thread(r);
                    t.start();
                }
            }
        }
    }
}

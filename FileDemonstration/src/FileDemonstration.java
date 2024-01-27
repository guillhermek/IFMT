import javax.swing.JOptionPane;
import java.io.File;

public class FileDemonstration {

    public static void main(String[] args) {
        String path = JOptionPane.showInputDialog("Enter file or directory name:");
        analyzePath(path);
    }

    public static void analyzePath(String path) {
        File file = new File(path);

        if (file.exists()) {
            StringBuilder output = new StringBuilder();

            output.append(file.getName()).append(" exists\n");
            output.append(file.isFile() ? "is a file" : "is not a file").append("\n");
            output.append(file.isDirectory() ? "is a directory" : "is not a directory").append("\n");
            output.append(file.isAbsolute() ? "is an absolute path" : "is not an absolute path").append("\n");
            output.append("Last modified: ").append(file.lastModified()).append("\n");
            output.append("Length: ").append(file.length()).append("\n");
            output.append("Path: ").append(file.getPath()).append("\n");
            output.append("Absolute path: ").append(file.getAbsolutePath()).append("\n");
            output.append("Parent: ").append(file.getParent()).append("\n");

            if (file.isDirectory()) {
                String[] directoryContents = file.list();
                output.append("\nDirectory contents:\n");
                for (String directoryItem : directoryContents) {
                    output.append(directoryItem).append("\n");
                }
            }

            JOptionPane.showMessageDialog(null, output.toString());

        } else {
            JOptionPane.showMessageDialog(null, path + " does not exist.");
        }
    }
}

package strings.class_problems;

public class FileExtensionValidator {

    public static String validateFileExtension(String filename) {
        if (filename == null) {
            return "Rejected - invalid file type";
        }

        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex == -1 || lastDotIndex == filename.length() - 1) {
            return "Rejected - invalid file type";
        }

        String ext = filename.substring(lastDotIndex + 1);

        if (ext.equalsIgnoreCase("pdf") || ext.equalsIgnoreCase("docx") || ext.equalsIgnoreCase("zip")) {
            return "Accepted";
        } else {
            return "Rejected - invalid file type";
        }
    }

    public static void main(String[] args) {
        String file1 = "Assignment1.PDF";
        System.out.println(file1 + " -> " + validateFileExtension(file1));

        String file2 = "notes.txt";
        System.out.println(file2 + " -> " + validateFileExtension(file2));

        String file3 = "project_archive.zip";
        System.out.println(file3 + " -> " + validateFileExtension(file3));
    }
}

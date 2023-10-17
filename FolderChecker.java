/** Запуск скрипта производится с использованием предустановленной на компьютере Java JDK через командную строку
 * 1. команда javac FolderChecker.java
 * 2. команда java FolderChecker **/

import java.io.File;

public class FolderChecker {
    public static void main(String[] args) {
        String folderPath = "C:\\Users\\facep\\IdeaProjects\\PracticaGroupOne";

        FolderChecker checker = new FolderChecker();
        checker.checkFolders(folderPath);
    }

    public void checkFolders(String path) {
        File folder = new File(path);
        File[] files = folder.listFiles();

        if (files != null && files.length > 0) {
            long totalFolderSize = 0;
            boolean foundInvalidFile = false;
            for (File file : files) {
                if (file.isDirectory()) {
                    long subFolderSize = getFolderSize(file);
                    totalFolderSize += subFolderSize;
                    if (subFolderSize > 0) {
                        System.out.println("Папка: " + file.getAbsolutePath() + " Размер: " + formatSize(subFolderSize));
                    }
                } else {
                    String fileName = file.getName();
                    String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
                    if (!extensionMatches(extension)) {
                        System.out.println("Найден файл: " + fileName);
                        foundInvalidFile = true;
                    }
                }
            }
            if (!foundInvalidFile) {
                System.out.println("Папка: " + folder.getAbsolutePath() + " Общий размер: " + formatSize(totalFolderSize));
            }
        }
    }

    public boolean extensionMatches(String extension) {
        String[] excludedExtensions = {"txt", "doc","xml","md","java","class",};
        if (extension.equalsIgnoreCase("") || extension.equalsIgnoreCase("gitignore")) {
            return true;
        }
        for (String excludedExtension : excludedExtensions) {
            if (extension.equalsIgnoreCase(excludedExtension)) {
                return true;
            }
        }
        return false;
    }

    public long getFolderSize(File folder) {
        long size = 0;
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    size += getFolderSize(file);
                } else {
                    size += file.length();
                }
            }
        }
        return size;
    }

    public String formatSize(long size) {
        if (size < 1024) {
            return size + " Байт";
        } else if (size < 1024 * 1024) {
            double sizeInKB = (double) size / 1024;
            return String.format("%.2f", sizeInKB) + " КБ";
        } else if (size < 1024 * 1024 * 1024) {
            double sizeInMB = (double) size / (1024 * 1024);
            return String.format("%.2f", sizeInMB) + " МБ";
        } else {
            double sizeInGB = (double) size / (1024 * 1024 * 1024);
            return String.format("%.2f", sizeInGB) + " ГБ";
        }
    }
}
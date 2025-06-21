package DesignPatterns.Exercise_2;

public class DocumentFactory {
    public static Document createDocument(String type) {
        if (type.equalsIgnoreCase("pdf")) {
            return new PDFDocument();
        } else if (type.equalsIgnoreCase("word")) {
            return new WordDocument();
        } else {
            throw new IllegalArgumentException("Unknown document type");
        }
    }
}

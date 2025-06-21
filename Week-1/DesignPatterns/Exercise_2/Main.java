package DesignPatterns.Exercise_2;

public class Main {
    public static void main(String[] args) {
        Document doc1 = DocumentFactory.createDocument("pdf");
        doc1.open();

        Document doc2 = DocumentFactory.createDocument("word");
        doc2.open();
    }
}

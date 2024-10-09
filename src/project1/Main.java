package project1;

import java.util.Scanner; 

class PrintedEdition {
    protected String title;
    protected String author;

    public PrintedEdition(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void show() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

class Book extends PrintedEdition {
    private String publisher;

    public Book(String title, String author, String publisher) {
        super(title, author);
        this.publisher = publisher;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Publisher: " + publisher);
    }
}

class Journal extends PrintedEdition {
    private int issueNumber;

    public Journal(String title, String author, int issueNumber) {
        super(title, author);
        this.issueNumber = issueNumber;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Issue Number: " + issueNumber);
    }
}

class Textbook extends Book {
    private String subject;

    public Textbook(String title, String author, String publisher, String subject) {
        super(title, author, publisher);
        this.subject = subject;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Subject: " + subject);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintedEdition[] editions = new PrintedEdition[3];

        editions[0] = new Book("Java Programming", "John Doe", "Tech Books");
        editions[1] = new Journal("Science Journal", "Jane Smith", 5);
        editions[2] = new Textbook("Calculus", "Albert Einstein", "Math Publishers", "Mathematics");

        for (PrintedEdition edition : editions) {
            edition.show();
            System.out.println(); 
        }

        scanner.close();
    }
}

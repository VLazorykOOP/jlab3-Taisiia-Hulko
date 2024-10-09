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
        System.out.println("Назва: " + title + ", Автор: " + author);
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
        System.out.println("Видавництво: " + publisher);
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
        System.out.println("Номер випуску: " + issueNumber);
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
        System.out.println("Предмет: " + subject);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintedEdition[] editions = new PrintedEdition[3];

        editions[0] = new Book("Програмування на Java", "Іван Іванов", "Технічні Книги");
        editions[1] = new Journal("Науковий Журнал", "Олена Петренко", 5);
        editions[2] = new Textbook("Математичний Аналіз", "Альберт Ейнштейн", "Математичне Видавництво", "Математика");

        for (PrintedEdition edition : editions) {
            edition.show();
            System.out.println(); 
        }

        scanner.close();
    }
}

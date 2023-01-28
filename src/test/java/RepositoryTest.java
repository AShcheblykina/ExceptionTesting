import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {
    @Test
    public void testAdd() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "The birth of tragedy", 100, "Nietzsche");
        Book book2 = new Book(2, "On the other side of good and evil", 400, "Nietzsche");
        Book book3 = new Book(3, "Thus spoke Zarathustra", 600, "Nietzsche");


        repo.add(book1);
        repo.add(book2);
        repo.add(book3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearch() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "The birth of tragedy", 100, "Nietzsche");
        Book book2 = new Book(2, "On the other side of good and evil", 400, "Nietzsche");
        Book book3 = new Book(3, "Thus spoke Zarathustra", 600, "Nietzsche");


        repo.add(book1);
        repo.add(book2);
        repo.add(book3);

        Product[] expected = {book1, book3};
        Product[] actual = repo.deletyById(2);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void deletingAnElement() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);


        Book book1 = new Book(1, "The birth of tragedy", 100, "Nietzsche");
        Book book2 = new Book(2, "On the other side of good and evil", 400, "Nietzsche");
        Book book3 = new Book(3, "Thus spoke Zarathustra", 600, "Nietzsche");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);

        Product[] expected = {book2, book3};
        Product[] actual = repo.deletyById(1);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void deleteNonElement() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);


        Book book1 = new Book(1, "The birth of tragedy", 100, "Nietzsche");
        Book book2 = new Book(2, "On the other side of good and evil", 400, "Nietzsche");
        Book book3 = new Book(3, "Thus spoke Zarathustra", 600, "Nietzsche");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.deletyById(5);
        });

    }

}

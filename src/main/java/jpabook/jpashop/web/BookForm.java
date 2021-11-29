package jpabook.jpashop.web;

import jpabook.jpashop.domain.item.Book;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookForm {

    private Long id;
    private String name;
    private int price;
    private int stockQuantity;
    private String author;
    private String isbn;

    public Book toEntity() {
        Book book = new Book();
        book.setName(this.name);
        book.setPrice(this.price);
        book.setStockQuantity(this.stockQuantity);
        book.setAuthor(this.author);
        book.setIsbn(this.isbn);

        return book;
    }

    public Book toEntityWithId() {
        Book book = new Book();
        book.setId(this.id);
        book.setName(this.name);
        book.setPrice(this.price);
        book.setStockQuantity(this.stockQuantity);
        book.setAuthor(this.author);
        book.setIsbn(this.isbn);

        return book;
    }

    public static BookForm of(Book book) {
        BookForm form = new BookForm();
        form.setId(book.getId());
        form.setName(book.getName());
        form.setPrice(book.getPrice());
        form.setStockQuantity(book.getStockQuantity());
        form.setAuthor(book.getAuthor());
        form.setIsbn(book.getIsbn());

        return form;
    }
}

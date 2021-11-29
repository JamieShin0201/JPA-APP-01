package jpabook.jpashop.web;

import jpabook.jpashop.domain.item.Book;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookForm {

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
}

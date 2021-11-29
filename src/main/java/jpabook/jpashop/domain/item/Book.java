package jpabook.jpashop.domain.item;

import jpabook.jpashop.web.BookForm;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
@Getter
@Setter
public class Book extends Item {

    private String author;
    private String isbn;

    public void changeWith(BookForm form) {
        super.setName(form.getName());
        super.setPrice(form.getPrice());
        super.setStockQuantity(form.getStockQuantity());

        this.author = form.getAuthor();
        this.isbn = form.getIsbn();
    }
}

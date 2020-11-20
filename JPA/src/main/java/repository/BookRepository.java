package repository;

import model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by Habib, on 05/11/2020
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}


package repository;

import model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Habib, on 05/11/2020
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("from Author a where a.id=?1")
    List<Author> findAuthorById(Long authorId);

}

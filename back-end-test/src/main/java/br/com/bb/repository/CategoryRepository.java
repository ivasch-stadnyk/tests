package br.com.bb.repository;

import br.com.bb.model.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Ivasch
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "select c from Category c where UPPER(c.name) like %?1%")
    public List<Category> findByStringInName(String string);

}

package br.com.bb.repository;

import br.com.bb.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ivasch
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}

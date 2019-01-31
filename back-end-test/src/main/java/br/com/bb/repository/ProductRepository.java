package br.com.bb.repository;

import br.com.bb.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Ivasch
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select p from Product p join fetch p.category c where c.id = ?1")
    public List<Product> findProductByCategoryId(Integer categoryId);

    @Query(value = "select p from Product p "
            + " join fetch p.category c "
            + "      where c.id = ?1 "
            + "        and p.status.id = ?2 ")
    public List<Product> findProductByCategoryAndStatus(Integer categoryId, Integer statusId);

}

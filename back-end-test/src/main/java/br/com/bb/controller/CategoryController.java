package br.com.bb.controller;

import br.com.bb.repository.CategoryRepository;
import br.com.bb.model.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ivasch
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/listAll")
    public ResponseEntity<List<Category>> listAll() {
        //<editor-fold defaultstate="collapsed" desc="Testes para serem comentados após conexão">
        /*List<Category> testList = new ArrayList();
        Category c = new Category();

        c.setId(1);
        c.setName("Alimentos");
        testList.add(c);
        c = new Category();
        c.setId(2);
        c.setName("Eletrodomésticos");
        testList.add(c);
        c = new Category();
        c.setId(3);
        c.setName("Móveis");
        testList.add(c);
        return ResponseEntity.ok(testList);*/
        //</editor-fold>

        List<Category> categories = categoryRepository.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/findByChar/{string}")
    public ResponseEntity<Category> findByString(@PathVariable String string) {
        string = string.toUpperCase();
        List<Category> categories = categoryRepository.findByStringInName(string.toUpperCase());

        if (categories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        int maximun = 0;
        Category ret = null;
        for (Category c : categories) {
            String[] split = c.getName().split(string);
            if (maximun < split.length - 1) {
                maximun = split.length - 1;
                ret = c;
            }
        }

        return ResponseEntity.ok(ret);
    }

}

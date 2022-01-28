import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAll();
    Product getOne(int id);

    /**
     * Ajoute un produit si son id n'est pas partagé par un produit existant
     * Pas de null autorisé
     * @param toAdd le produit à ajouter
     * @return <code>true</code> si le produit est ajouté; <code>false</code> sinon
     */
    boolean insert(Product toAdd);
    Product delete(int id);

    List<Product> getAllSorted(Comparator<Product> comparator);
    Product getCheapest();
    Product getMostExpensive();

    List<Product> getAllByBrand(String brand);
}

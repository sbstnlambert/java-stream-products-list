import be.technifutur.exceptions.NoProductException;
import be.technifutur.exceptions.ProductNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    private final List<Product> list = new ArrayList<>();

    @Override
    public List<Product> getAll() {
        return List.copyOf(list);
    }

    @Override
    public Product getOne(int id) {
        Optional<Product> prod = list.stream()
                .filter(product -> product.getId() == id)
                .findFirst();
        return prod.orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public boolean insert(Product toAdd) {
        boolean isValid = false;
        if ( toAdd != null ) {
            isValid = list.stream()
                    .noneMatch(product -> product.getId() == toAdd.getId());
            if (isValid)
                list.add(toAdd);
        }
        return isValid;
    }

    @Override
    public Product delete(int id) {
        Product toDelete = getOne(id);
        list.remove(toDelete);
        return toDelete;
    }

    @Override
    public List<Product> getAllSorted(Comparator<Product> comparator) {
        return list.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    @Override
    public Product getCheapest() {
        return list.stream()
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(NoProductException::new);
    }

    @Override
    public Product getMostExpensive() {
        return list.stream()
                .max(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(NoProductException::new);
    }

    @Override
    public List<Product> getAllByBrand(String brand) {
        return list.stream()
                .filter(product -> Objects.equals(product.getBrand(), brand))
                .collect(Collectors.toList());
    }
}

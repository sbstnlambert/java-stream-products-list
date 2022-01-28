import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        ProductServiceImpl productServiceImpl = new ProductServiceImpl();


        Product p1 = new Product();
        p1.setId(1);
        p1.setBrand("Maison du Monde");
        p1.setName("Table");
        p1.setPrice(80.50);

        Product p2 = new Product();
        p2.setId(2);
        p2.setBrand("Ikea");
        p2.setName("Sofa");
        p2.setPrice(125.99);

        Product p3 = new Product();
        p3.setId(3);
        p3.setBrand("Roi du Matelas");
        p3.setName("Mattress");
        p3.setPrice(799.99);

        Product p4 = new Product();
        p4.setId(3);
        p4.setBrand("Nike");
        p4.setName("Shoes");
        p4.setPrice(110.00);

        Product p5 = new Product();

        Product p6 = null;

        Product p7 = new Product();
        p7.setId(7);
        p7.setBrand("Ikea");
        p7.setName("Desk");
        p7.setPrice(49.99);

        Product p8 = new Product();
        p8.setId(8);
        p8.setBrand("Maison du Monde");
        p8.setName("Light Bulb");
        p8.setPrice(35.99);

        productServiceImpl.insert(p1);
        productServiceImpl.insert(p2);
        productServiceImpl.insert(p3);
        productServiceImpl.insert(p4);
        productServiceImpl.insert(p5);
        productServiceImpl.insert(p6);
        productServiceImpl.insert(p7);
        productServiceImpl.insert(p8);

        // TEST METHODES
        System.out.println(productServiceImpl.getAll());
        System.out.println("----- DELETE -----");
        productServiceImpl.delete(0);
        System.out.println(productServiceImpl.getAll());
        System.out.println("----- INSERT -----");
        productServiceImpl.insert(p1);
        System.out.println(productServiceImpl.getAll());
        System.out.println("----- GET ONE -----");
        System.out.println(productServiceImpl.getOne(8));
        System.out.println("----- GET ALL -----");
        System.out.println(productServiceImpl.getAll());
        System.out.println("----- GET CHEAPEST -----");
        System.out.println(productServiceImpl.getCheapest());
        System.out.println("----- GET MOST EXPENSIVE -----");
        System.out.println(productServiceImpl.getMostExpensive());
        System.out.println("----- GET ALL SORTED -----");
        System.out.println(productServiceImpl.getAllSorted(Comparator.comparingDouble(Product::getPrice)));
        System.out.println("----- GET ALL BY BRAND -----");
        System.out.println(productServiceImpl.getAllByBrand("Ikea"));


    }

}

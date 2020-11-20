package pl.edu.wszib.kkubit.hw1.database;

import org.springframework.stereotype.Component;
import pl.edu.wszib.kkubit.hw1.model.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataBase implements IDataBase {
    private final List<Product> products = new ArrayList<>();

    public DataBase(){
        this.products.add(new Product("test","test"));
    }
    @Override
    public boolean addProduct(Product p) {
        for (Product product : products){
            if (p.getName().equals(product.getName())){
                return false; // nie dodane, jest produkt o tej nazwie
            }
        }
        products.add(p);
        return true;
    }

    @Override
    public boolean addPieces(String name, int quantity) {
        for (Product product : products){
            if(product.getName().equals(name)){
                product.setQuantity(quantity); //setQuantity dodaje
                return true;
            }
        }
        return false; //petla nie znalazla produktu, nie mozna dodac sztuk
    }

    @Override
    public boolean removePieces(String name, int quantity) {
        for (Product product : products){
            if(product.getName().equals(name) && product.getQuantity() >= quantity){
                product.removeQuantity(quantity);
                return true;
            }
        }
        return false; //petla nie znalazla produktu lub jest go za malo, nie odjac dodac sztuk
    }

    @Override
    public List<Product> getAllProducts() {
        return this.products;
    }

    @Override
    public boolean isEmpty() {
        if(products.size() >0)
            return false;
        else
            return true;
    }

    @Override
    public boolean removeProduct(String name) {
        for (int i = 0; i< products.size(); i++){
            if (name.equals(products.get(i).getName())){
                products.remove(i);
                return true; // znaleziono i usunieto
            }
        }

        return false; // nie ma takiego produktu
    }
}

package pl.edu.wszib.kkubit.hw1.database;

import pl.edu.wszib.kkubit.hw1.model.Product;

import java.util.List;

public interface IDataBase {
    boolean addProduct(Product p);

    boolean addPieces(String name, int quantity);
    boolean removePieces(String name, int quantity);
    boolean removeProduct(String name);
    boolean isEmpty();
    List<Product> getAllProducts();
}

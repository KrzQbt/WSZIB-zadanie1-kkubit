package pl.edu.wszib.kkubit.hw1.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wszib.kkubit.hw1.database.IDataBase;
import pl.edu.wszib.kkubit.hw1.model.Product;

import java.util.List;
import java.util.Scanner;

@Component
public class GUI implements IGui{

    Scanner scanner = new Scanner(System.in);

    @Autowired
    public IDataBase dataBase;

    @Override
    public void showMainMenu() {
        System.out.println("1. Show all products");
        System.out.println("2. Add a product");
        System.out.println("3. Increase quantity of a product");
        System.out.println("4. Decrease quantity of a product");
        System.out.println("5. Remove a product");
        System.out.println("6. Exit");

        switch (scanner.nextLine()){
            case  "1":
                this.showAllProducts();
                this.showMainMenu();
                break;
            case  "2":
                this.addAProduct();
                this.showMainMenu();
                break;
            case  "3":
                this.increaseQuantity();
                this.showMainMenu();
                break;
            case  "4":
                this.decreaseQuantity();
                this.showMainMenu();
                break;
            case  "5":
                this.removeAProduct();
                this.showMainMenu();
                break;
            case  "6":
                System.exit(0);
                break;

            default:
                System.out.println("Invalid input");
                this.showMainMenu();
                break;

        }


    }

    private void showAllProducts(){
        if (this.dataBase.isEmpty()){
            System.out.println("No items in storage");
        }else{
            for (Product product : this.dataBase.getAllProducts()){
                System.out.println(product);
            }
        }

    }

    private void addAProduct(){
        Scanner s = new Scanner(System.in);
        System.out.println("Type products name");
        String name = s.nextLine();
        System.out.println("Type products description");
        String description = s.nextLine();
        if (this.dataBase.addProduct(new Product(name,description)))
            System.out.println("Added product");
        else
            System.out.println("Product already exists");
    }

    private void increaseQuantity(){
        Scanner s = new Scanner(System.in);
        System.out.println("Type products name");
        String name = s.nextLine();
        System.out.println("Type amount to add");
        int quantity = s.nextInt();
        if (this.dataBase.addPieces(name,quantity))
            System.out.println("Added "+ quantity+" units of "+name);
        else
            System.out.println("There is no such product");
    }

    private void decreaseQuantity(){
        Scanner s = new Scanner(System.in);
        System.out.println("Type products name");
        String name = s.nextLine();
        System.out.println("Type amount to subtract");
        int quantity = s.nextInt();
        if (this.dataBase.removePieces(name,quantity))
            System.out.println("Subtracted "+ quantity+" units of "+name);
        else
            System.out.println("There is too little units to subtract or there is no such product");
    }

    private void removeAProduct(){

        Scanner s = new Scanner(System.in);
        System.out.println("Type products name");
        String name = s.nextLine();
        if (this.dataBase.removeProduct(name))
            System.out.println("Removed product" + name);
        else
            System.out.println("There is no such product");
    }

}


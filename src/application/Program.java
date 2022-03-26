package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

        List<Product> productList = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();


        for(int i = 1; i <=n ; i++){
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char option = sc.next().charAt(0);

            System.out.print("Name: ");
            String productName = sc.next();

            System.out.print("Price: ");

            Double productPrice = sc.nextDouble();

            if(option == 'i'){
                System.out.print("Customs fee: ");

                Double fee = sc.nextDouble();
                productList.add(new ImportedProduct(productName, productPrice, fee));

            } else if( option == 'u'){

                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String data = sc.next();
                productList.add( new UsedProduct(productName, productPrice, sdf.parse(data)));

            }else if(option == 'c') {

                productList.add(new Product(productName, productPrice));
            }

        }

        System.out.println();
        System.out.println("PRICE TAGS: ");
        for(Product produto : productList){
            System.out.println(produto.priceTag());
        }
    }
}

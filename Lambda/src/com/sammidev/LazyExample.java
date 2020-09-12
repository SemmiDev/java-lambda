package com.sammidev;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class LazyExample {

    private static ProductService productService = new ProductService();

    public static void main(String[] args) {

        Product product1 = findOrCreate(1, () -> productService.createNewProduct(1,"Logitect xxx",new BigDecimal("400.000")));
        System.out.println(product1.toString());

        Product product2 = findOrCreate(2, () -> productService.createNewProduct(2, "Keyboard xxx", new BigDecimal("950.000")));
        System.out.println(product2.toString());

        Product product1Find = findOrCreate(1, () -> productService.createNewProduct(1, "sample", new BigDecimal(BigInteger.ZERO)));
        System.out.println(product1Find);

        Boolean up = productService.updateProduct(1,"UPDATED",new BigDecimal(BigInteger.ZERO));
        if (up == false) {
            System.out.println("--> status : " + up);
            System.out.println("--> ID TIDAK DITEMUKAN");
        }
        System.out.println("--> status : " + up);
        System.out.println("--> UPDATING COMPLETED");
    }

    public static Product findOrCreate(Integer id, Supplier<Product> newProduct) {
        Product product = productService.findById(id);
        if (product != null) {
            return product;
        }
        return newProduct.get();
    }
    public static class ProductService {

        private Map<Integer, Product> databaseProduct = new HashMap<>();

        public Product findById(Integer id) {
            return databaseProduct.get(id);
        }
        public Product createNewProduct(Integer id, String name, BigDecimal price) {
            Product product = new Product(id,name,price);
            databaseProduct.put(id, product);
            return product;
        }

        public Boolean updateProduct(Integer id, String nameUpdate, BigDecimal priceUpdate) {
            Product product =  findById(id);
            if (product == null) {
                return false;
            }

            System.out.println("\n===BEFORE===");
            System.out.println(product + "\n");

            product.setId(id);
            product.setName(nameUpdate);
            product.setPrice(priceUpdate);

            System.out.println("===AFTER===");
            System.out.println(product);
            return true;
        }
    }

    public static class Product {
        private Integer id;
        private String name;
        private BigDecimal price;

        public Product(Integer id, String name, BigDecimal price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public Product() {
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }
    }
}
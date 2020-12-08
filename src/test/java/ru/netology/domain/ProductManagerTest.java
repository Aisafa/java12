package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductManager productManager = new ProductManager();
    private Book javaBook = new Book(1, "SteveJavaBook", 1000, "JobsShildt");
//    private Book javaCode = new Book(2, "jabaCde", 1000, "Code");
    private Smartphone iphoneX = new Smartphone(1, "SteveIphoneX", 75000, "JobsApple");
//    private Smartphone iphone12 = new Smartphone(2, "iphoneX", 99000, "Apple");


    @Test
    public void shouldAddItems() {
        productManager.add(iphoneX);
        productManager.add(javaBook);
        Product[] expected = new Product[]{iphoneX, javaBook};
        Product[] actual = productManager.getRepository().findAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchByTxt() {
        productManager.add(iphoneX);
        productManager.add(javaBook);
        Product[] expected = new Product[]{iphoneX, javaBook};
        Product[] actual = productManager.searchBy("Steve");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByTxt2() {
        productManager.add(iphoneX);
        productManager.add(javaBook);
        Product[] expected = new Product[]{iphoneX, javaBook};
        Product[] actual = productManager.searchBy("Jobs");
        assertArrayEquals(expected, actual);
    }

}
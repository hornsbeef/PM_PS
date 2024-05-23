package at.ac.uibk.pm.g03.csbb5525.s07.e01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Stack;

public class Main {

    private static final Path TARGET_PATH = Path.of("./index.html"); // Feel free to change the path

    public static void main(String[] args) throws IOException {
        Stack<Product> products = new Stack<>();
        products.add(Product.create("Aloe Vera", "71.71", 2017, 1400));
        products.add(Product.create("Snake Plant", "82.82", 2021, 700));
        products.add(Product.create("Moth Orchid", "93.93", 2023, 350));

        String html = Page.render(products);

        System.out.println(html);
        Files.writeString(TARGET_PATH, html);
    }
}

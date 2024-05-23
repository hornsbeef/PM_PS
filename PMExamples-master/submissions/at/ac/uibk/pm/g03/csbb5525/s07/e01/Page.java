package at.ac.uibk.pm.g03.csbb5525.s07.e01;

import java.util.Stack;

public class Page {

    private static final String PAGE_TEMPLATE = """
            <!DOCTYPE html>
            <html>
                <head>
                    <meta charset="UTF-8" />
                    <title>Products</title>
                    <style>
                        body {
                            font-family: system-ui;
                        }
                    </style>
                </head>
                <body>
                    <h1>Products</h1>
            %s
                </body>
            </html>
            """;

    private static final String PRODUCT_TEMPLATE = """
            <h2>%s</h2>
            <ul>
                <li>Net: €%s</li>
                <li>Gross: €%s</li>
                <li>Released: %s</li>
                <li>Last Update: %s (UTC)</li>
            </ul>
            """.indent(8);

    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm";

    public static String render(Stack<Product> products) {
        StringBuilder productsHtmlBuilder = new StringBuilder();

        // TODO: Consume the products stack, thereby rendering HTML for each product and appending it to the productsHtmlBuilder
        throw new UnsupportedOperationException("Not yet implemented");

        String productsHtml = productsHtmlBuilder.toString().stripTrailing();
        return PAGE_TEMPLATE.formatted(productsHtml);
    }
}

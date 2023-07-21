package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String url = "https://www.google.com"; // Replace with the URL of the website you want to parse

        try {
            // Connect to the website and fetch the HTML content
            Document doc = Jsoup.connect(url).get();

            // Extract and display the page title
            String title = doc.title();
            System.out.println("Page Title: " + title);

            // Extract and display all links (anchor tags) on the page
            Elements links = doc.select("a");
            System.out.println("Links on the page:");
            for (Element link : links) {
                String linkText = link.text();
                String linkHref = link.attr("href");
                System.out.println(linkText + " : " + linkHref);
            }

            // Extract and display all paragraphs on the page
            Elements paragraphs = doc.select("p");
            System.out.println("Paragraphs on the page:");
            for (Element paragraph : paragraphs) {
                System.out.println(paragraph.text());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

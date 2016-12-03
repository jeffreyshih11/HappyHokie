package com.example.jeff.happyhokie;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        try {
            //ClassLoader classLoader = this.getClass().getClassLoader();

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbFactory.newDocumentBuilder();
            Document xml = documentBuilder.parse("C:\\Users\\Jeff\\Documents\\jeffrey\\school\\senior\\design\\happy hokie\\HappyHokie\\app\\src\\main\\res\\Deals.xml");

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            xml.getDocumentElement().normalize();

            String sDay = "Thursday";
            NodeList nodeList = xml.getDocumentElement().getElementsByTagName("Restaurant");
            for (int j = 0 /*nodeList.getLength() - 20*/; j < nodeList.getLength(); j++) {
                Element e = (Element) nodeList.item(j);
                FullDeal f = new FullDeal(e.getAttribute("id"));    //restaurant name
                //System.out.println(e.getAttribute("id"));

                NodeList children = e.getElementsByTagName("Day");

                for(int i = 0; i < children.getLength(); i++){
                    //System.out.println("\t" + e2.getAttribute("id"));
                    Element e2 = (Element) children.item(i);

                    if(e2.getAttribute("id").equals(sDay)) {
                        NodeList fdeals = e2.getElementsByTagName("Food");
                        NodeList ddeals = e2.getElementsByTagName("Drink");

                        for (int k = 0; k < fdeals.getLength(); k++) {
                            Element foodDeal = (Element) fdeals.item(k);
                            //System.out.println("\t\tFood:" + foodDeal.getTextContent());
                            f.addFood(foodDeal.getTextContent());
                        }
                        for (int x = 0; x < ddeals.getLength(); x++) {
                            Element drinkDeal = (Element) ddeals.item(x);
                            //System.out.println("\t\tDrink:" + DrinkDeal.getTextContent());
                            f.addDrink(drinkDeal.getTextContent());
                        }
                    }
                }

                System.out.print(f.toString());
            }

            assert(true);
        } catch (Exception e) {
            System.out.println("Error while processing resource file: " + e.getStackTrace());
            assert(false);

        }

    }
}
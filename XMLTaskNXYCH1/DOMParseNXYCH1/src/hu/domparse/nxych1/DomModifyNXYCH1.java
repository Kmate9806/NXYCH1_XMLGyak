package hu.domparse.nxych1;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import hu.domparse.nxych1.DOMQueryNXYCH1;
import hu.domparse.nxych1.DOMReadNXYCH1;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.Scanner;
import java.io.File;
import javax.xml.transform.Result;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomModifyNXYCH1 {

	private static final String File = "XMLNXYCH1.xml";
	// private static final String UJFile = "teszt.xml";

	public static void main(String[] args) {
		NodeList list;

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// fokategoria
			// Adja meg a fokategoriat
			System.out.println("Adja meg a fokategoriat");
			String fokategoria = DOMQueryNXYCH1.fokategoria();
			// ALkategoria
			// Adja meg az alkategoriat
			System.out.println("Adja meg a alkategoriat");
			String alkategoria = DOMQueryNXYCH1.alkategoria();
			// keresesi id megadasa
			String idkod = idkereso();
			// atirando eredeti ertek
			String adat = ertekkereso();
			// ertek amire atirom
			System.out.println("Adja meg mire akarja atirni az adatot");
			String ujertek = ertekvalto();

			System.out.println("---Adatok kiolvasasa---");

			// fájl beolvasása
			Document document = builder.parse(new File("XMLNXYCH1.xml"));
			document.getDocumentElement().normalize();
			// Aktuális elem meghatározása //"beteg"
			list = document.getElementsByTagName(fokategoria);

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				// Aktuális elem Kiírása
				System.out.println("\n Current element: " + node.getNodeName());
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					// id eltárolása egy stringbe //"id"
					String id = element.getAttribute("id");
				
					Node nodeid = list.item(i);
					if (nodeid.getNodeType() == Node.ELEMENT_NODE) {
						Element element1 = (Element) node;
						// id vizsgálata és ha megegyezzik a megadottal akkor ertek modositasa
						if (id.equals(idkod)) {
							element1.getElementsByTagName(alkategoria).item(0).setTextContent(ujertek);

						}
						// uj adatok kiirasa
						System.out.println(
								"\n Uj adat: " + element1.getElementsByTagName(alkategoria).item(0).getTextContent());

					}

				}

			}

			// Lekérdezi az adatoktak és beleírja egy fájlba
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			Source input = new DOMSource(document);
			Result output = new StreamResult(new File("XMLNXYCH1UJ.xml"));
			transformer.transform(input, output);

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String ertekkereso() {
		// beolvasom az eredetiet
		System.out.println("Adja meg az atirando adatot");
		Scanner sc = new Scanner(System.in);
		String adatok = sc.next();
		String adat = adatok;
		System.out.println("A atirando eredeti: " + adat + "-----------");
		return adat;
	}

	public static String tartalom() {
		// beolvasom az eredeti alkategoria tartalmat
		Scanner sc = new Scanner(System.in);
		String adatok = sc.next();
		String tartalom = adatok;
		System.out.println("Eredeti tartalom: " + tartalom + "-----------");
		return tartalom;
	}

	// uj erteket ad meg
	public static String ertekvalto() {
		System.out.println("Adja meg az uj erteket");
		Scanner sc = new Scanner(System.in);
		String adatok = sc.next();
		String ujertek = adatok;
		System.out.println("Az uj ertek: " + ujertek + "-----------");
		return ujertek;
	}

	// id alapu kereses
	public static String idkereso() {
		System.out.println("Adja meg az elem idt");
		Scanner sc = new Scanner(System.in);
		String adatok = sc.next();
		String id = adatok;
		return id;
	}

}

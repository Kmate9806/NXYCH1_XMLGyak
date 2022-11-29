package hu.domparse.nxych1;

import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import hu.domparse.nxych1.DOMReadNXYCH1;

public class DOMQueryNXYCH1 {

	public static void main(String[] args) {
		try {
			// documentum xml beolvasasa hogy DOM parserral kezeljem
			File xmlDocumentum = new File("XMLNXYCH1.xml");
			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dFact.newDocumentBuilder();
			Document documentum = dBuild.parse(xmlDocumentum);

			System.out.println("Lehetseges kategoriak amire szürhet: ");
			System.out.println("beteg");
			System.out.println("korhaz");
			System.out.println("gyogyszer");
			System.out.println("doktor");
			System.out.println("korkep");
			System.out.println("minden");
			System.out.println("Adja meg a lehetseges kategoriakbol amire raakar keresni");

			// kategoria beolvasasa
			Scanner input = new Scanner(System.in);
			String opciok = input.next();
			String kategoria = opciok;
			//kategoriak alkategoriainak felsorolasa es a minden adat kiirato opcio implementalasa
			switch (kategoria) {
			case "beteg": {
				System.out.println(
						"A lehetseges keresesi opciok: teljes_nev, kor, telefonszam, beteg_azonositokod, bekerules_datuma, kezeloorvos, minden");
				System.out.println("ha most beirja hogy minden az adott kategoriabol megkap mindent");
				String alkategoria = alkategoria();
				if (alkategoria.contains("minden")) {
					DOMReadNXYCH1.betegkiiras();
				}
				break;
			}
			case "korhaz": {
				System.out.println(
						"A lehetseges keresesi opciok: cim, beoszottak, hasznalt_gyogyszerek, osztalyok, befogado_kepesseg, bekerules_datuma, mennyiseg, minden");
				System.out.println("ha most beirja hogy minden az adott kategoriabol megkap mindent");
				String alkategoria = alkategoria();
				if (alkategoria.contains("minden")) {
					DOMReadNXYCH1.korhazkiiras();
				}
				break;
			}
			case "gyogyszer": {
				System.out.println(
						"A lehetseges keresesi opciok: ar, gyogyszer_azonosito, nev, lejarat_ideje, mennyiseg, minden");
				System.out.println("ha most beirja hogy minden az adott kategoriabol megkap mindent");
				String alkategoria = alkategoria();
				if (alkategoria.contains("minden")) {
					DOMReadNXYCH1.gyogyszerkiiras();
				}
				break;
			}
			case "doktor": {
				System.out.println(
						"A lehetseges keresesi opciok: teljes_nev, telefonszam, szakterulet, doktor_azonositokod, munkahely, minden");
				System.out.println("ha most beirja hogy minden az adott kategoriabol megkap mindent");
				String alkategoria = alkategoria();
				if (alkategoria.contains("minden")) {
					DOMReadNXYCH1.orvoskiiras();
				}
				break;
			}
			case "korkep": {
				System.out.println(
						"A lehetseges keresesi opciok: beteg_azonositokod, datum, diagnozis, gyogyszerek, kezelo_orvos_neve, minden");
				System.out.println("ha most beirja hogy minden az adott kategoriabol megkap mindent");
				String alkategoria = alkategoria();
				if (alkategoria.contains("minden")) {
					DOMReadNXYCH1.korkepkiiras();
				}
				break;
			}
			case "minden": {
				System.out.println("Az osszes adatot megkapja ha beirja hogy minden: ");
				DOMReadNXYCH1.adatkiiras();
				break;
			}
			}
			
			//a fo metodus ami a keresest vegzi
			behelyettesites();

			System.out.println("---Ez volt a keresett adat---");

		} catch (Exception e) {
			System.out.println("A hiba: " + e);
		}
	}

	public static String fokategoria() {
		// beolvasom a fokategoriat
		Scanner scanner = new Scanner(System.in);
		String adatok = scanner.next();
		String fokategoria = adatok;
		System.out.println("A valasztott fokategoria: " + fokategoria + "-----------");
		return fokategoria;
	}

	public static String alkategoria() {
		// beolvasom az alkategoriat

		Scanner scanner = new Scanner(System.in);
		String adatok = scanner.next();
		String alkategoria = adatok;
		System.out.println("A valasztott alkategoria: " + alkategoria + "-----------");
		return alkategoria;
	}

	public static String behelyettesites() {
		System.out.println("fokategoriat irja be ujra:");
		String tarolo = alkategoria();
		String fokategoria = tarolo;

		System.out.println("alkategoriat irja be ujra:");
		String tarolo2 = alkategoria();
		String alkategoria = tarolo2;

		try {

			File xmlDocumentum = new File("XMLNXYCH1.xml");
			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dFact.newDocumentBuilder();
			Document documentum = dBuild.parse(xmlDocumentum);
			// a teljes nev összetettseget kezelo ag
			if (alkategoria.contains("teljes_nev")) {

				System.out.println("---adatok kiolvasasa---");
				NodeList nodeList = documentum.getElementsByTagName("beteg");
				for (int i = 0; i < nodeList.getLength(); i++) {
					Node nNode = nodeList.item(i);
					System.out.println("Node neve " + nNode.getNodeName() + "" + (i + 1));
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						System.out.println("Beteg teljes neve: "
								+ eElement.getElementsByTagName("vezeteknev").item(0).getTextContent() + " "
								+ eElement.getElementsByTagName("keresztnev").item(0).getTextContent());
						System.out.println("--------------------------------- ");
					}

				}
				//egyeb agak kezelese
			} else if (alkategoria.contentEquals(alkategoria)) {

				System.out.println("---Adatok kiolvasasa---");
				NodeList nodeList = documentum.getElementsByTagName(fokategoria);
				for (int i = 0; i < nodeList.getLength(); i++) {
					Node nNode = nodeList.item(i);
					System.out.println("Node neve " + nNode.getNodeName() + "" + (i + 1));
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						System.out.println(
								"Adatok: " + eElement.getElementsByTagName(alkategoria).item(0).getTextContent());
						System.out.println("--------------------------------- ");
					}

				}
			}

		} catch (Exception e) {
			System.out.println("A hiba: " + e);
		}

		return alkategoria;
	}
}

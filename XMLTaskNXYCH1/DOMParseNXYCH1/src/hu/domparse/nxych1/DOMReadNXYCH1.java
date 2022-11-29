package hu.domparse.nxych1;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMReadNXYCH1 {

	public static void main(String[] args) {
		try {
			// a beolvasas jelenleg egy metodus kod ujrafelhasznalas erdekeben
			betegkiiras();
			korhazkiiras();
			gyogyszerkiiras();
			orvoskiiras();
			korkepkiiras();
		} catch (Exception e) {
			System.out.println("A hiba: " + e);
		}
	}

	public static void adatkiiras() {

		try {
			File xmlDocumentum = new File("XMLNXYCH1.xml");
			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dFact.newDocumentBuilder();
			Document documentum = dBuild.parse(xmlDocumentum);

			// kiolvassuk a root elementet documentum megkeresi a root megkapjuk a node
			// nevet
			System.out.println("Root element: " + documentum.getDocumentElement().getNodeName());

			betegkiiras();
			korhazkiiras();
			gyogyszerkiiras();
			orvoskiiras();
			korkepkiiras();
		} catch (Exception e) {
			System.out.println("A hiba: " + e);
		}
	}

	public static void betegkiiras() {
		try {
			File xmlDocumentum = new File("XMLNXYCH1.xml");
			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dFact.newDocumentBuilder();
			Document documentum = dBuild.parse(xmlDocumentum);

			// kiolvassuk a root elementet documentum megkeresi a root megkapjuk a node
			// nevet
			System.out.println("Root element: " + documentum.getDocumentElement().getNodeName());

			// a korhazak adatai a NodeList tombbol
						System.out.println("---Korhazak kiolvasasa---");
						NodeList betegList = documentum.getElementsByTagName("beteg");
						for (int i = 0; i < betegList.getLength(); i++) {
							Node betegNode = betegList.item(i);
							System.out.println("Node neve " + betegNode.getNodeName() + "" + (i + 1));
							if (betegNode.getNodeType() == Node.ELEMENT_NODE) {
								Element eElement = (Element) betegNode;
								System.out.println("Beteg teljes neve: " +
								eElement.getElementsByTagName("vezeteknev").item(0).getTextContent() + " " +
								eElement.getElementsByTagName("keresztnev").item(0).getTextContent());
								System.out.println("Beteg Kora: " + eElement.getElementsByTagName("kor").item(0).getTextContent());
								System.out.println("Beteg Orvosanak azonositoja: " + eElement.getElementsByTagName("orvos_azonosito").item(0).getTextContent());
								System.out.println("Beteg telefonszama: " + eElement.getElementsByTagName("telefonszam").item(0).getTextContent());
								System.out.println("Beteg azonositokodja: " + eElement.getElementsByTagName("beteg_azonositokod").item(0).getTextContent());
								System.out.println("Beteg bekerulesenek datuma: " + eElement.getElementsByTagName("bekerules_datuma").item(0).getTextContent());
								System.out.println("Beteg kezelõorvosa: " + eElement.getElementsByTagName("kezeloorvos").item(0).getTextContent());
							
								System.out.println("--------------------------------- ");
							}
						}
						System.out.println("---Ezek voltak a betegek---");

		} catch (Exception e) {
			System.out.println("A hiba: " + e);
		}
	}

	public static void korhazkiiras() {
		try {
			File xmlDocumentum = new File("XMLNXYCH1.xml");
			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dFact.newDocumentBuilder();
			Document documentum = dBuild.parse(xmlDocumentum);

			// kiolvassuk a root elementet documentum megkeresi a root megkapjuk a node
			// nevet
			System.out.println("Root element: " + documentum.getDocumentElement().getNodeName());

			// a korhazak adatai a NodeList tombbol
			System.out.println("---Korhazak kiolvasasa---");
			NodeList korhazList = documentum.getElementsByTagName("korhaz");
			for (int i = 0; i < korhazList.getLength(); i++) {
				Node korhNode = korhazList.item(i);
				System.out.println("Node neve " + korhNode.getNodeName() + "" + (i + 1));
				if (korhNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) korhNode;
					System.out.println("Korhaz cime: " + eElement.getElementsByTagName("cim").item(0).getTextContent());
					System.out.println("Korhaz beosztottai szama: "
							+ eElement.getElementsByTagName("beosztottak").item(0).getTextContent());
					System.out.println("Korhazban hasznalt gyogszerek: "
							+ eElement.getElementsByTagName("hasznalt_gyogyszerek").item(0).getTextContent());
					System.out.println(
							"Korhaz osztalyai: " + eElement.getElementsByTagName("osztalyok").item(0).getTextContent());
					System.out.println("Korhaz gyogyszer id: "
							+ eElement.getElementsByTagName("gyogyszer_id").item(0).getTextContent());
					System.out.println("Korhazi beteg azonositoja: "
							+ eElement.getElementsByTagName("beteg_azonositokod").item(0).getTextContent());
					System.out.println("Korhazi beteg bekerülesenek datuma: "
							+ eElement.getElementsByTagName("bekerules_datuma").item(0).getTextContent());
					System.out.println("Korhazi gyogyszerek mennyisege: "
							+ eElement.getElementsByTagName("mennyiseg").item(0).getTextContent());
					// System.out.println("Korhazban levo orvos munkahelye: " +
					// eElement.getElementsByTagName("munkahely").item(0).getTextContent());
					System.out.println("--------------------------------- ");
				}
			}
			System.out.println("---Ezek voltak a korhazak---");

		} catch (Exception e) {
			System.out.println("A hiba: " + e);
		}
	}

	public static void gyogyszerkiiras() {
		try {
			File xmlDocumentum = new File("XMLNXYCH1.xml");
			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dFact.newDocumentBuilder();
			Document documentum = dBuild.parse(xmlDocumentum);

			// kiolvassuk a root elementet documentum megkeresi a root megkapjuk a node
			// nevet
			System.out.println("Root element: " + documentum.getDocumentElement().getNodeName());

			// a gyogyszerek a NodeList tombbol
			System.out.println("---Gyogyszerek kiolvasasa---");
			NodeList gyogyList = documentum.getElementsByTagName("gyogyszer");
			for (int i = 0; i < gyogyList.getLength(); i++) {
				Node gyogyNode = gyogyList.item(i);
				System.out.println("Node neve " + gyogyNode.getNodeName() + "" + (i + 1));
				if (gyogyNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) gyogyNode;
					System.out
							.println("Gyogyszer ara: " + eElement.getElementsByTagName("ar").item(0).getTextContent());
					System.out.println("Gyogyszer azonositoja: "
							+ eElement.getElementsByTagName("gyogyszer_azonosito").item(0).getTextContent());
					System.out.println(
							"Gyogyszer neve: " + eElement.getElementsByTagName("nev").item(0).getTextContent());
					System.out.println("Gyogyszer lejarati datuma: "
							+ eElement.getElementsByTagName("lejarat_ideje").item(0).getTextContent());
					System.out.println("Gyogyszerben levo mennyiseg: "
							+ eElement.getElementsByTagName("mennyiseg").item(0).getTextContent());
					System.out.println("--------------------------------- ");
				}
			}
			System.out.println("---Ezek voltak a gyogyszerek---");

		} catch (Exception e) {
			System.out.println("A hiba: " + e);
		}
	}

	public static void orvoskiiras() {
		try {
			File xmlDocumentum = new File("XMLNXYCH1.xml");
			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dFact.newDocumentBuilder();
			Document documentum = dBuild.parse(xmlDocumentum);

			// kiolvassuk a root elementet documentum megkeresi a root megkapjuk a node
			// nevet
			System.out.println("Root element: " + documentum.getDocumentElement().getNodeName());

			// a orvosok adatai a NodeList tombbol
			System.out.println("---Orvosok kiolvasasa---");
			NodeList orvosList = documentum.getElementsByTagName("doktor");
			for (int i = 0; i < orvosList.getLength(); i++) {
				Node orvosNode = orvosList.item(i);
				System.out.println("Node neve " + orvosNode.getNodeName() + "" + (i + 1));
				if (orvosNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) orvosNode;
					System.out.println(
							"Orvos teljes neve: " + eElement.getElementsByTagName("vezeteknev").item(0).getTextContent()
									+ " " + eElement.getElementsByTagName("keresztnev").item(0).getTextContent());
					System.out.println("Orvos telefonszama: "
							+ eElement.getElementsByTagName("telefonszam").item(0).getTextContent());
					System.out.println("Orvos szakterulete: "
							+ eElement.getElementsByTagName("szakterulet").item(0).getTextContent());
					System.out.println("Orvos azonositokodja: "
							+ eElement.getElementsByTagName("doktor_azonositokod").item(0).getTextContent());
					System.out.println(
							"Orvos munkahelye: " + eElement.getElementsByTagName("munkahely").item(0).getTextContent());
					System.out.println("--------------------------------- ");
				}
			}
			System.out.println("---Ezek voltak az orvosok---");

		} catch (Exception e) {
			System.out.println("A hiba: " + e);
		}
	}

	public static void korkepkiiras() {
		try {
			File xmlDocumentum = new File("XMLNXYCH1.xml");
			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dFact.newDocumentBuilder();
			Document documentum = dBuild.parse(xmlDocumentum);

			// kiolvassuk a root elementet documentum megkeresi a root megkapjuk a node
			// nevet
			System.out.println("Root element: " + documentum.getDocumentElement().getNodeName());

			// a korkepek a NodeList tombbol
			System.out.println("---Korkepek kiolvasasa---");
			NodeList korkList = documentum.getElementsByTagName("korkep");
			for (int i = 0; i < korkList.getLength(); i++) {
				Node korkNode = korkList.item(i);
				System.out.println("Node neve " + korkNode.getNodeName() + "" + (i + 1));
				if (korkNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) korkNode;
					System.out.println("Beteg azonositokodja: "
							+ eElement.getElementsByTagName("beteg_azonositokod").item(0).getTextContent());
					System.out.println(
							"Korkep datuma: " + eElement.getElementsByTagName("datum").item(0).getTextContent());
					System.out.println(
							"Diagnozis: " + eElement.getElementsByTagName("diagnozis").item(0).getTextContent());
					System.out.println(
							"Gyogyszerek: " + eElement.getElementsByTagName("gyogyszerek").item(0).getTextContent());
					System.out.println("Kezelo orvos neve: "
							+ eElement.getElementsByTagName("kezelo_orvos_neve").item(0).getTextContent());
					System.out.println("--------------------------------- ");
				}
			}
			System.out.println("---Ezek voltak a korkepek---");

		} catch (Exception e) {
			System.out.println("A hiba: " + e);
		}
	}
}
package saxnxych1;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import saxnxych1.*;
public class SaxNXYCH1 {

	public static void main(String[] args) {
		
		try{
			SAXParserFactory fact = SAXParserFactory.newInstance();
			SAXParser saxParser = fact.newSAXParser();
			
			DefaultHandler handle = new DefaultHandler() {
				boolean bora = false,
						btargy = false,
						bidopont = false,
							bnap = false,
							btol = false,
							big = false,
						bhelyszin = false,
						boktato = false,
						bszak = false;
				
				public void startElement(String uri, String localname, String qName, Attributes attributes){
					
					System.out.println(qName +" Start: ");
					if(qName.equals("ora")) {String id = attributes.getValue("id");
					String tipus = attributes.getValue("tipus");
					System.out.println("Ora: {ID=" + id + " Tipus=" + tipus + "}");
					}
					
					if(qName.equals("targy")) btargy = true;
					if(qName.equals("idopont")) bidopont = true;
						
							if(qName.equals("nap")) bnap = true;
							if(qName.equals("tol")) btol = true;
							if(qName.equals("ig")) big = true;
						
					if(qName.equals("helyszin")) bhelyszin = true;
					if(qName.equals("oktato")) boktato = true;
					if(qName.equals("szak")) bszak = true;
				}
				public void endElement(String uri, String localname, String qName){
					System.out.println(qName +" End: ");
				}	
				public void characters(char[] ch, int start, int length){
					
					
					if(btargy) {
						System.out.println("Targy: " + new String(ch, start, length));
						btargy = false;
					}
					if(bidopont) {
						System.out.println("Idopont: " + new String(ch, start, length));
						bidopont = false; }
							
							if(bnap) {
								System.out.println("nap: " + new String(ch, start, length));
								bnap = false;}
							if(btol) {
								System.out.println("tol: " + new String(ch, start, length));
								btol = false; }
							if(big) {
								System.out.println("ig: " + new String(ch, start, length));	
							    big = false;
									}
					
					if(bhelyszin) {
						System.out.println("Helyszin: " + new String(ch, start, length));
						bhelyszin = false;
					}
					if(boktato) {
						System.out.println("Oktato: " + new String(ch, start, length));
						boktato = false;
					}
					if(bszak) {
						System.out.println("Szak: " + new String(ch, start, length));
						bszak = false;
					}
				}
				
			};
			saxParser.parse("kmorarend.xml", handle);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		/*catch(SAXException e){
			System.out.println(e.getMessage());
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}*/
	}

}

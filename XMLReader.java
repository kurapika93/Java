package bolaScore;
// create date 18 april 2018
// update 19 april 2018
import java.io.File;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class XMLReader {

	
	public ArrayList<ScoreField> read_xml (String xml){
		try {
			File fXmlFile = new File(xml);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory. newInstance();
			//enable DOM parser
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			Document doc = dBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Score");
			
			ArrayList<ScoreField> list = new ArrayList<ScoreField>();
			
			for(int temp =0; temp <nList.getLength();temp++) {
				Node nNode = nList.item(temp);
				
				if (nNode.getNodeType()== Node.ELEMENT_NODE) {
					Element e = (Element) nNode;
					
					String clubName = "";
					int winScore = 0;
					int loseScore = 0;
					int drawScore = 0;
					int goalFors = 0;
					int goalAgaints = 0;
					int goalDraws = 0;
					int points = 0;
									
					clubName = e.getElementsByTagName("clubName").item(0)
							.getTextContent();
					winScore = Integer.parseInt(e
							.getElementsByTagName("winScore").item(0)
							.getTextContent());
					loseScore = Integer.parseInt(e
							.getElementsByTagName("loseScore").item(0)
							.getTextContent());
					drawScore = Integer.parseInt(e
							.getElementsByTagName("drawScore").item(0)
							.getTextContent());
					goalFors  = Integer.parseInt(e
							.getElementsByTagName("goalFors").item(0)
							.getTextContent());
					goalAgaints = Integer.parseInt(e
							.getElementsByTagName("goalAgaints").item(0)
							.getTextContent());
					goalDraws = Integer.parseInt(e
							.getElementsByTagName("goalDraws").item(0)
							.getTextContent());
					points = Integer.parseInt(e
							.getElementsByTagName("points").item(0)
							.getTextContent());
					
					ScoreField test = new ScoreField(clubName,winScore,loseScore,drawScore,goalFors,goalAgaints,goalDraws,points);
					list.add(test);	
			     	}
					
//					System.out.println("Name: "+e.getAttribute("name")+" with Format:"+e.getElementsByTagName("format").item(0).getTextContent());
					
				}
			return list;
	} catch (Exception e) {
		System.out.println(e);
		return null;
	}
				
	}  
}

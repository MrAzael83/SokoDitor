package mod;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import ctrl.AElement;
import ctrl.IElement;
import gui.GuiCharacter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Created by Yohan on 03/03/2016.
 */
public class Map {

    private int width;
    private int height;
    private String title;
    private char[][] map;
    private AElement[][] mapObject;
/**
 *  # : Wall
 *  , : Floor
 *  @ : Character
 *  . : Goal
 *  $ : Box
 *  ; : Vide
 **/
    public Map(String path) {
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            final DocumentBuilder builder = factory.newDocumentBuilder();
            final Document document = builder.parse(new File(path));
            final Element racine = document.getDocumentElement();
            final NodeList Level = racine.getChildNodes();
            final int nbLevel = Level.getLength();

            boolean isFind = false;
            int indice = 0;

            for (int i = 0; i<nbLevel && !isFind; i++) {
                if (Level.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    indice = i;
                    isFind = true;
                }
            }
            final Element L = (Element) Level.item(indice);

            this.width = Integer.parseInt(L.getAttribute("Width"));
            this.height = Integer.parseInt(L.getAttribute("Height"));
            this.title = L.getAttribute("Title");

            map = new char[height][width];
            for(int j = 0; j < height;j++){
                String s = "L" + (j+1) ;
                String nom = L.getElementsByTagName(s).item(0).getTextContent();
                for (int k=0; k < nom.length();k++){
                    map[j][k] = nom.charAt(k);
                }
                for (int k = nom.length(); k < width;k++){
                    map[j][k] = ';';
                }
            }
            CreateObjectMap();
        }
        catch (final ParserConfigurationException e) {
            e.printStackTrace();
        }
        catch (final SAXException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }



    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public AElement[][] getMapObject() {
        return mapObject;
    }

    public void PrintMap(){
        for (int i = 0; i<height;i++){
            for (int j = 0; j<width;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    private void CreateObjectMap(){
        mapObject = new AElement[height][width];
        for (int i = 0; i<height;i++){
            for (int j = 0; j<width;j++){
                switch (map[i][j]){
                    case '#':
                        mapObject[i][j] = new Wall();
                        break;
                    case ',':
                        mapObject[i][j] = new Floor();
                        break;
                    case '@':
                        mapObject[i][j] = new Character();
                        break;
                    case '.':
                        mapObject[i][j] = new Goal();
                        break;
                    case '$':
                        mapObject[i][j] = new Box();
                        break;
                    case ';':
                        mapObject[i][j] = new Vide();
                        break;
                }
            }
        }
    }

    public char[][] getMap(){
        return map;
    }
}
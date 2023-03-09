import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Morsecodierer {

    BinaryTree morseTree;
    public Morsecodierer() {
        morseTree = new BinaryTree<>(" ", new BinaryTree<>(),new BinaryTree<>());
    }

    public String encodiereText(String pText) throws IOException {
        FileReader fr = new FileReader("morse.txt");
        BufferedReader br = new BufferedReader(fr);
        for (int i = 0; i < 29; i++) {
            String zeile = br.readLine();
            String[] parts = zeile.split(";");
            zeichenEinfügen(parts[1],parts[2],morseTree);
        }

        return "";
    }
    public String decodiereText(String pMorseCode){
        return "";
    }
    public void stelleBaumDar(){
        BaumZeichner zeichner = new BaumZeichner(900,900,morseTree);
    }
    private BinaryTree zeichenEinfügen(char z, String code, BinaryTree baum){
        if (baum.isEmpty()){
            baum =  new BinaryTree<>(" ", new BinaryTree<>(),new BinaryTree<>());
        }
        if (code == ""){
            baum.setContent("");
        } else {
            if (code.charAt(0) == '.') {
                for (int i = 0; i < code.length(); i++) {
                    String newCode = "";
                    newCode += code.charAt(i);
                    baum.setLeftTree(zeichenEinfügen(z, newCode, baum));
                }
            } else {
                for (int i = 0; i < code.length(); i++) {
                    String newCode = "";
                    newCode += code.charAt(i);
                    baum.setRightTree(zeichenEinfügen(z, newCode, baum));
                }
            }
        }
        return baum;
    }
}

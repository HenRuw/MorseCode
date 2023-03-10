import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Morsecodierer {

    BinaryTree morseTree;
    public Morsecodierer() {
        morseTree = new BinaryTree<>(" ", new BinaryTree<>(),new BinaryTree<>());
    }

    public void setMorseTree(BinaryTree morseTree) {
        this.morseTree = morseTree;
    }

    public BinaryTree getMorseTree() {
        return morseTree;
    }

    public String encodiereText(String pText){

        return "";
    }
    public String decodiereText(String pMorseCode){
        return "";
    }
    public void stelleBaumDar(){
        BaumZeichner zeichner = new BaumZeichner(900,900,morseTree);
    }
    public void erstelleBaum() throws IOException {
        FileReader fr = new FileReader("src/morse.txt");
        BufferedReader br = new BufferedReader(fr);
        for (int i = 0; i < 29; i++) {
            String zeile = br.readLine();
            String[] parts = zeile.split(";"); //TODO funktioniert nicht, gibt keinen Buchstaben in part 1
            System.out.println(parts[1]);
            System.out.println(parts[1].charAt(0) + " parts 1" + parts[1]);
            zeichenEinfügen(parts[1].charAt(0),parts[1],morseTree);
        }
    }
    public BinaryTree zeichenEinfügen(char z, String code, BinaryTree baum){
        String newCode = "";
        if (baum.isEmpty()){
            baum =  new BinaryTree<>(" ", new BinaryTree<>(),new BinaryTree<>());
        }
        if (code == ""){
            baum.setContent("");
        } else {
            if (code.charAt(0) == '.') {
                for (int i = 1; i < code.length(); i++) {
                    newCode += code.charAt(i);
                }
                System.out.println("code: " + code + "newCode: " + newCode + "Buchstabe: " + z);
                baum.setLeftTree(zeichenEinfügen(z, newCode, baum));
            } else {
                for (int i = 1; i < code.length(); i++) {
                    newCode += code.charAt(i+1);
                }
                System.out.println("code: " + code + "newCode: " + newCode + "Buchstabe: " + z);
                baum.setRightTree(zeichenEinfügen(z, newCode, baum));
            }
        }
        return baum;
    }
}

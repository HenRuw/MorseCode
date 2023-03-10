import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Morsecodierer {

    BinaryTree morseTree;

    public Morsecodierer() {
        morseTree = new BinaryTree<>(" ", new BinaryTree<>(), new BinaryTree<>());
    }

    public BinaryTree getMorseTree() {
        return morseTree;
    }

    public void setMorseTree(BinaryTree morseTree) {
        this.morseTree = morseTree;
    }

    public String encodiereText(String pText){
        pText = pText.toUpperCase();
        String ergebnis = "";
        for (int i = 0; i < pText.length(); i++) {
            if (pText.charAt(i) == ' '){
                ergebnis += "     ";
            }
            else {
                ergebnis += encodiereZeichen(pText.charAt(i), morseTree, "")+ " ";
            }
        }
        return ergebnis;
    }

    public String encodiereZeichen(Character pZeichen, BinaryTree<Character> pBaum, String pTeilcode) {
        if (pBaum.isEmpty()){
            return "";
        }
        String ergebnis = "";
        if ((pBaum.getContent() == pZeichen)){
            ergebnis = pTeilcode;
        }
        else {
            ergebnis = encodiereZeichen(pZeichen, pBaum.getLeftTree(), pTeilcode + ".") + encodiereZeichen(pZeichen, pBaum.getRightTree(), pTeilcode + "-");
        }
        return ergebnis;
    }

    public String decodiereText(String pMorseCode) {

        return "";
    }

    public void stelleBaumDar() {
        BaumZeichner zeichner = new BaumZeichner(900, 900, morseTree);
    }

    public void erstelleBaum() throws IOException {
        FileReader fr = new FileReader("src/morse.txt");
        BufferedReader br = new BufferedReader(fr);
        for (int i = 0; i < 29; i++) {
            String zeile = br.readLine();
            String[] parts = zeile.split(";");
            zeichenEinfügen(parts[0].charAt(0), parts[1], morseTree);
        }
    }

    public BinaryTree zeichenEinfügen(char z, String code, BinaryTree baum) {
        String newCode = "";
        if (baum.isEmpty()) {
            baum = new BinaryTree<>(z, new BinaryTree<>(), new BinaryTree<>());
        }
        if (code.equals("")) {
            baum.setContent(z);
        } else {
            if (code.charAt(0) == '.') {
                for (int i = 1; i < code.length(); i++) {
                    newCode += code.charAt(i);
                }
                baum.setLeftTree(zeichenEinfügen(z, newCode, baum.getLeftTree()));
            } else {
                for (int i = 1; i < code.length(); i++) {
                    newCode += code.charAt(i);
                }
                baum.setRightTree(zeichenEinfügen(z, newCode, baum.getRightTree()));
            }
        }
        return baum;
    }
}

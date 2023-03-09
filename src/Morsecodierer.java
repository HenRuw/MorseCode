public class Morsecodierer {
    public Morsecodierer() {
        BinaryTree morseTree = new BinaryTree<>(" ", new BinaryTree<>(),new BinaryTree<>());
    }

    public String encodiereText(String pText){
        return "";
    }
    public String decodiereText(String pMorseCode){
        return "";
    }
    public void stelleBaumDar(){
        BaumZeichner zeichner = new BaumZeichner(100,100,morseTree);
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

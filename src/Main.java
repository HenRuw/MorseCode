import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Morsecodierer m  = new Morsecodierer();
        m.setMorseTree(m.zeichenEinfügen('v', "...-", m.getMorseTree()));
        System.out.println(m.getMorseTree().getContent());
        //m.stelleBaumDar();
    }
}

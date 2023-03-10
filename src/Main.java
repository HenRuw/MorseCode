import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Morsecodierer m  = new Morsecodierer();
        m.erstelleBaum();
        System.out.println(m.decodiereText(m.encodiereText("Ich bin werner")));
    }
}

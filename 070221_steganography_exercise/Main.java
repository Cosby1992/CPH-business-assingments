import java.io.File;

public class Main {

    public static void main(String[] args) {

        File image = new File("7fe3c3f6-Stego.png");
        SteganographyDecoder decoder = new SteganographyDecoder(image);

        decoder.decode();

    }


}
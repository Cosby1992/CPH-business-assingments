import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Main {

    public static void main(String[] args) {

        File image = new File("7fe3c3f6-Stego.png"); // <-- loading the image file

        try{
            // reading the image (Throws exception)
            BufferedImage bufferedImage = ImageIO.read(image);

            // Create new instans of ImageSteganography to decode message from image
            ImageSteganography imageDecoder = new ImageSteganography();

            // Get Ascii message from bit 0 in the color of each pixel (Blue least significant bit)
            String message = imageDecoder.decodeWithLittleEndianFromImageByBitPosition(bufferedImage, 0);

            // Print message in terminal
            System.out.println(message);
            // OUTPUT: Congratulations, this is the secret message of the UFO class! (no, not 42)

        } catch (Exception e){ // if there's an error reading the image
            System.out.println(e.getMessage());
        }

    }

}
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class SteganographyDecoder {

    File image;

    // no-arg contructor
    SteganographyDecoder() {

    }

    /**
     * Constructor
     * 
     * @param image - image to decode
     */
    SteganographyDecoder(File image) {
        this.image = image;
    }

    String decode() {

        // System.out.println("Decode initiating...");

        // message to return
        String decodedMessage = "";

        try {
            // read image file bytes
            BufferedImage image = ImageIO.read(this.image);

            ArrayList<Integer> bytes = new ArrayList<>();

            // System.out.println("Filling byte array");
            for (int i = 0; i < image.getHeight(); i++) {

                for (int j = 0; j < image.getWidth(); j++) {

                    int clr = image.getRGB(j, i);

                    bytes.add(getLastBitFromIntColor(clr));
                }

            }

            // System.out.println("Byte array length: " + bytes.size());
            // System.out.println("Image size: " + image.getHeight() * image.getWidth());

            int temp = 0;
            String nextChar = "";
            ArrayList<Integer> message = new ArrayList<>();

            for (int i = 0; i < bytes.size(); i++) {
                temp++;
                // nextChar += String.valueOf(bytes.get(i));
                nextChar += (bytes.get(i) == 0) ? "0" : "1";
                

                if (temp == 8) {

                    if (nextChar.equals("00000000")) {
                        System.out.println("BREAKING: EMPTY BYTE");
                        break;
                    }

                    // System.out.println(Integer.parseInt(nextChar, 2));

                    message.add(Integer.parseInt(nextChar, 2));
                    // System.out.println("Temp == 7: " + nextChar);
                    temp = 0;
                    nextChar = "";
                }

            }

            for (int character : message) {
                System.out.print((char) character);
            }

        } catch (Exception e) {
            return e.getMessage();
        }

        return decodedMessage;
    }

    private int getBit(int blue) {
        System.out.print(blue & 1);
        return blue & 1;
    }

    private int getLastBitFromIntColor(int clr) {

        Color color = new Color(clr, true);
        return getBit(color.getBlue());

    }

    // Getters and Setters
    void setImage(File image) {
        this.image = image;
    }

}

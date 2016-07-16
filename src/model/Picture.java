package model;

import configuration.Configure;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageInputStream;
import java.applet.Applet;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;


/**
 * Created by user on 05.07.2016.
 */
public class Picture extends Applet {
    private final static Picture picture = new Picture();

    private BufferedImage imageOrig;
    private int imageWidthOrig;
    private int imageHeightOrig;
    private BufferedImage imageCopy;
    private int imageWidthCopy;
    private int imageHeightCopy;
    private Color[][] colors;

    private Picture() {
    }

    public void setImage() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(Configure.getConfigure().getFoto_original_path()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.imageOrig = image;
        this.imageHeightOrig = image.getHeight();
        this.imageWidthOrig = image.getWidth();


//        this.setColors(picture.getColors());
    }


    public void setPixelsColor() {
        int x = getImageWidthOrig();
        int y = getImageHeightOrig();

        Color[][] mass = new Color[x][y];
        for (int j = 0; j < y; j++)
            for (int i = 0; i < x; i++) {
                mass[i][j] = new Color(getImageOrig().getRGB(i, j));
            }
        this.colors = mass;


//        Color[][] mass = new Color[x][y];
//        for (int j = 0; j < y; j++)
//            for (int i = 0; i < x; i++) {
//                Object colorData = getImageOrig().getRaster().getDataElements(i, j, null);//dane for pixel
//                int argb = getImageOrig().getColorModel().getRGB(colorData);//to Color
//                mass[i][j] = new Color(argb, true);
//            }
//
//        this.colors = mass;
    }

    public void CopyPicture() {
        setImage();
        setPixelsColor();
        Color[][] color = getColors();
        int width = getImageWidthOrig();
        int height = getImageHeightOrig();

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                bufferedImage.setRGB(i, j, color[i][j].getRGB());
            }
        }

        setImageCopy(bufferedImage);
        Configure configure = Configure.getConfigure();
        try {
            ImageIO.write(bufferedImage, "jpg",
                    new File("E:\\Universitet\\11_semestre\\Polska\\FotoDyplom\\web\\images\\mini\\"
                            + configure.getFoto_original_name()));
            configure.setFoto_copy_name(configure.getFoto_original_name());
            configure.setFoto_copy_path(configure.getPath_for_copy() + configure.getFoto_original_name());
            configure.setFoto_true(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Picture getPicture() {
        return picture;
    }

    public BufferedImage getImageOrig() {
        return imageOrig;
    }

    public Color[][] getColors() {
        return colors;
    }

    public int getImageWidthOrig() {
        return imageWidthOrig;
    }

    public int getImageHeightOrig() {
        return imageHeightOrig;
    }

    public void setColors(Color[][] colors) {
        this.colors = colors;
    }

    public void setImageWidthOrig(int imageWidthOrig) {
        this.imageWidthOrig = imageWidthOrig;
    }

    public void setImageHeightOrig(int imageHeightOrig) {
        this.imageHeightOrig = imageHeightOrig;
    }

    public int getImageWidthCopy() {
        return imageWidthCopy;
    }

    public void setImageWidthCopy(int imageWidthCopy) {
        this.imageWidthCopy = imageWidthCopy;
    }

    public int getImageHeightCopy() {
        return imageHeightCopy;
    }

    public void setImageHeightCopy(int imageHeightCopy) {
        this.imageHeightCopy = imageHeightCopy;
    }

    public void setImageOrig(BufferedImage imageOrig) {
        this.imageOrig = imageOrig;
    }

    public BufferedImage getImageCopy() {
        return imageCopy;
    }

    public void setImageCopy(BufferedImage imageCopy) {
        this.imageCopy = imageCopy;
    }
}

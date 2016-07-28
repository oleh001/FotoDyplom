package model;

import configuration.Configure;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.image.BufferedImage;
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
    private BufferedImage imageMini;
    private int imageWidthCopy;
    private int imageHeightCopy;
    private Color[][] colors;
    private JFrame jFrame;

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

    public void MiniPicture() {
        setImage();
        Image img = getImageOrig().getScaledInstance(500, -1, Image.SCALE_REPLICATE);

        BufferedImage bimage = imageToBufferedImage(img);

        //showFoto(img);
        //showFoto(bimage);

        setImageMini(bimage);
        Configure configure = Configure.getConfigure();
        try {
            ImageIO.write(bimage, "jpg", new File("E:\\Universitet\\11_semestre\\Polska\\FotoDyplom\\web\\images\\mini\\" + configure.getFoto_original_name()));
            configure.setFoto_copy_name(configure.getFoto_original_name());
            configure.setFoto_copy_path(configure.getPath_for_copy() + configure.getFoto_original_name());
            configure.setFoto_copy_width(bimage.getWidth());
            configure.setFoto_copy_height(bimage.getHeight());
            configure.setFoto_true(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CopyPicture() {
        setImage();
        setPixelsColor();
        Color[][] color = getColors();
        int width = getImageWidthOrig();
        int height = getImageHeightOrig();


        BufferedImage bufferedImage = newFoto(width, height, color);


        setImageMini(bufferedImage);
        Configure configure = Configure.getConfigure();
//        try {
//            ImageIO.write(bufferedImage, "jpg",
//                    new File("E:\\Universitet\\11_semestre\\Polska\\FotoDyplom\\web\\images\\mini\\"
//                            + configure.getFoto_original_name()));
//            configure.setFoto_copy_name(configure.getFoto_original_name());
//            configure.setFoto_copy_path(configure.getPath_for_copy() + configure.getFoto_original_name());
//            configure.setFoto_true(true);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public BufferedImage newFoto(int width, int height, Color[][] color) {
        int wid = 1, hei = 1;
        //if (width>500){wid=width/500;}
        //if (height>500){hei=height/500;}
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int j = 0; j < height; j = j + wid) {
            for (int i = 0; i < width; i = i + hei) {
                bufferedImage.setRGB(i, j, color[i][j].getRGB());
            }
        }
        Image img = bufferedImage.getScaledInstance(500, 500, 0);


        BufferedImage bimage = imageToBufferedImage(img);

        showFoto(img);
        return bimage;
    }

    public void showFoto(Image bufferedImage) {
        if (getjFrame() == null) {
            setjFrame(new JFrame());
        }
        JFrame frame = getjFrame();
        //frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Foto");
        frame.setVisible(true);


        JLabel label = new JLabel(new ImageIcon(bufferedImage));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(label);
        frame.pack();
        frame.setLocation(200, 200);

//        frame.add(new JLabel(new ImageIcon("E:/Universitet/11_semestre/Polska/FotoDyplom/web/images/mini/Demo.jpg")));
    }

    public BufferedImage imageToBufferedImage(Image image) {
        if (image instanceof BufferedImage) {
            return (BufferedImage) image;
        }

//      Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);

        bimage.getGraphics().drawImage(image, 0, 0, null);

        return bimage;
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

    public BufferedImage getImageMini() {
        return imageMini;
    }

    public void setImageMini(BufferedImage imageMini) {
        this.imageMini = imageMini;
    }

    public JFrame getjFrame() {
        return jFrame;
    }

    public void setjFrame(JFrame jFrame) {
        this.jFrame = jFrame;
    }
}

package model;

import configuration.Configure;

/**
 * Created by user on 05.07.2016.
 */
public class LoadFotoThread extends Thread {
    private Picture picture;

    private LoadFotoThread loadFotoThread;

    public LoadFotoThread() {
        this.picture = Picture.getPicture();
        start();
    }

    @Override
    public void run() {
//        Configure.getConfigure().setFoto_colors(false);

        synchronized (this) {
            picture.setPixelsColor();
        }
        Configure.getConfigure().setFoto_colors(true);
    }


}

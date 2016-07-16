package controller;

import configuration.Configure;
import model.Connection_DB;
import model.Pages_Select;
import model.Picture;

import java.awt.*;
import java.io.IOException;
import java.sql.ResultSet;

/**
 * Created by user on 03.07.2016.
 */
public class Controller {
    public Controller() {
    }
    private Configure configure = Configure.getConfigure();

    private Connection_DB connection_db = new Connection_DB();

    //    Отримання списку сторінок
    private Pages_Select pages_select = new Pages_Select(connection_db.getDbConnection(), "SELECT page_id, title from pages");
    private ResultSet resultSet = pages_select.getResultSet();

//    private Picture picture = new Picture(getConfigure().getFoto_original_path());
    private Picture picture=Picture.getPicture();

    private Color[][] colors;// = getPicture().getColors();

//    public static void main(String[] args) {
//        Controller controller=new Controller();
//        Picture picture=controller.getPicture();
//
//        Color[][] colors = controller.getColors();
//        int x = picture.getImageWidthOrig();
//        int y = picture.getImageHeightOrig();
//        for (int j = 0; j < y; j++) {
//            for (int i = 0; i < x; i++) {
//                System.out.print(colors[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }

    public Connection_DB getConnection_db() {
        return connection_db;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public Configure getConfigure() {
        return configure;
    }

    public Picture getPicture() {
        return picture;
    }

    public Color[][] getColors() {
        return colors;
    }

    public void setColors(Color[][] colors) {
        this.colors = colors;
    }

}

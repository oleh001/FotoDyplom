package configuration;

/**
 * Created by user on 03.07.2016.
 */
public class Configure {
    private final static Configure configure=new Configure();
    //    Driver for BD
    private final String database_driver = "com.mysql.jdbc.Driver";

    //    Address BD
    private final String database_url = "jdbc:mysql://localhost:3306/moda_db";

    //    Name BD
    private final String database_name = "moda_db";

    //    Log in for BD
    private final String user_name = "root";

    //    Password for BD
    private final String password = "123456789q";

    //    Tittle for Shop
    private final String title = "Moda - you style and your frends";

//    Download File(Foto)
    private String foto_original_path;//="E:\\Universitet\\11_semestre\\Polska\\FotoDyplom\\web\\images\\f2.JPG";
    private String path_for_copy="E:\\Universitet\\11_semestre\\Polska\\FotoDyplom\\web\\images\\mini\\";

    private String foto_original_name;
    private int foto_original_width;
    private boolean foto_true;
    private int foto_max_width=2000;
    private int foto_max_height=2000;
    private int foto_max_width_in_window=1000;
    private boolean foto_colors=false;

    private String foto_copy_path;
    private String foto_copy_name;
    private int foto_copy_width;
    private int foto_copy_height;

    //    Description for Shop
    private final String descr_1 = "Your the best shop - Moda";
    private final String descr_2 = "Moda - Shop you dream";
    private final String descr_3 = "You weekends in Moda";
    private final String descr_4 = "Buy in Moda and be fashionable";


    private Configure() {
    }

    public static Configure getConfigure() {
        return configure;
    }

    public String getDatabase_driver() {
        return database_driver;
    }

    public String getDatabase_url() {
        return database_url;
    }

    public String getPassword() {
        return password;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getDatabase_name() {
        return database_name;
    }

    public String getTitle() {
        return title;
    }

    public String getDescr_1() {
        return descr_1;
    }

    public String getDescr_2() {
        return descr_2;
    }

    public String getDescr_3() {
        return descr_3;
    }

    public String getDescr_4() {
        return descr_4;
    }

    public String getFoto_original_path() {
        return foto_original_path;
    }

    public void setFoto_original_path(String foto_original_path) {
        this.foto_original_path = foto_original_path;
    }

    public boolean isFoto_true() {
        return foto_true;
    }

    public void setFoto_true(boolean foto_true) {
        this.foto_true = foto_true;
    }

    public String getFoto_original_name() {
        return foto_original_name;
    }

    public void setFoto_original_name(String foto_original_name) {
        this.foto_original_name = foto_original_name;
    }

    public int getFoto_original_width() {
        return foto_original_width;
    }

    public void setFoto_original_width(int foto_original_width) {
        this.foto_original_width = foto_original_width;
    }

    public int getFoto_max_width() {
        return foto_max_width;
    }

    public int getFoto_max_height() {
        return foto_max_height;
    }

    public boolean isFoto_colors() {
        return foto_colors;
    }

    public void setFoto_colors(boolean foto_colors) {
        this.foto_colors = foto_colors;
    }

    public int getFoto_copy_width() {
        return foto_copy_width;
    }

    public void setFoto_copy_width(int foto_copy_width) {
        this.foto_copy_width = foto_copy_width;
    }

    public String getFoto_copy_name() {
        return foto_copy_name;
    }

    public void setFoto_copy_name(String foto_copy_name) {
        this.foto_copy_name = foto_copy_name;
    }

    public String getFoto_copy_path() {
        return foto_copy_path;
    }

    public void setFoto_copy_path(String foto_copy_path) {
        this.foto_copy_path = foto_copy_path;
    }

    public String getPath_for_copy() {
        return path_for_copy;
    }

    public int getFoto_max_width_in_window() {
        return foto_max_width_in_window;
    }

    public int getFoto_copy_height() {
        return foto_copy_height;
    }

    public void setFoto_copy_height(int foto_copy_height) {
        this.foto_copy_height = foto_copy_height;
    }
}

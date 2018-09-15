package necer.ncalendardemo.utils;

public class ConstantValue {
    /**
     * 打印log 的标签
     */
    public static final String TAG = "ZAO";
    /**
     * 日历的数据库
     */
    public static final String DADABASE_DAILYNOTES = "zao0915";
    /**
     * 每日笔记的数据库
     */
    public static final String DATABASE_DAILYNOTES_TABLE_NAME = "dailynotes";
    /**
     * 每日新闻 表
     */
    public static final String DATABASE_CREATE_TABLE_DAILYNOTES = "create table " + DATABASE_DAILYNOTES_TABLE_NAME +
                                                                 " (_id integer primary key autoincrement , title varchar(20),author varchar(20),content varchar(10000000),picpath varchar(200),email varchar(30),time varchar(60));";

    public static final String[]  PIC_PATH = {"https://img3.doubanio.com/view/photo/l/public/p2510110513.webp",
                                             "https://img3.doubanio.com/view/photo/l/public/p2507147220.webp",
                                             "https://img3.doubanio.com/view/photo/l/public/p1902051195.webp",
                                             "https://img3.doubanio.com/view/photo/l/public/p1902051371.webp",
                                             "https://img3.doubanio.com/view/photo/l/public/p1902051511.webp",
                                             "https://img3.doubanio.com/view/photo/l/public/p1763500663.webp"};
}

package db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import entry.Province;

/**
 * Created by Administrator on 2018/11/8 0008.
 */
public class WeatherDB {
    /**
     * 数据库名
     */
    public static final String DB_NAME="china_cities";
    /**
     * 数据库版本
      */
    public static final int VERSION=1;
    private static WeatherDB weatherDB;
    private SQLiteDatabase db;

    /**
     * 将构造方法私有化
     */
    private WeatherDB(Context context){
        WeatherOpeHelper dbHealer=new WeatherOpeHelper(context,DB_NAME,null,VERSION);
        db=dbHealer.getWritableDatabase();
    }

    /**
     * 获取WeatherDb的实例。
     */
    public synchronized static WeatherDB getInstance(Context context){
        if (weatherDB==null){
            weatherDB=new WeatherDB(context);
        }
        return weatherDB;
    }

    /**
     * 将Province实例到数据库。
     */
    public void saveProvince(Province province){
        if (province!=null){
            ContentValues values=new ContentValues();
            values.put("province_name",province.getProvinceName());

        }
    }
    /**
     * 从数据库读取全国的省份信息
     */
    public List<Province> loadProvinces(){
        List<Province> list=new ArrayList<Province>();
        Cursor cursor=db.query("Province",null,null, null, null, null, null);
        if (cursor.moveToFirst()){
            do {
                Province province = new Province();
                province.setId(cursor.getInt(cursor.getColumnIndex("id")));
                province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
                province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
                list.add(province);
            } while (cursor.moveToNext());
        }
        return list;
    }
/**
 * 将City实例存储到数据库。
 */
    













}

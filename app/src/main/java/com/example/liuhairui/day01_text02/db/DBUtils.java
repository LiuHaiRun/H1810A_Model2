package com.example.liuhairui.day01_text02.db;

import android.util.Log;

import com.example.liuhairui.day01_text02.bean.Student;
import com.example.text12_model3.dao.DaoMaster;
import com.example.text12_model3.dao.DaoSession;
import com.example.text12_model3.dao.StudentDao;

import java.util.List;

public class DBUtils {

    //--------------------------单例模式---------------------------------------------------------
    private static DBUtils instance;
    private final StudentDao mDao;

    private DBUtils() {
        //创建数据库
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApp.getmContext(), "ku.db");
        //获取读写对象
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        //获取管理表对象
        DaoSession daoSession = daoMaster.newSession();
        mDao = daoSession.getStudentDao();
    }

    public static DBUtils getInstance() {
        if (instance == null) {
            instance = new DBUtils();
        }
        return instance;
    }
    //-----------------------------------------------------------------------------------------

    private static final String TAG = "DBUtils";

    //添加
    public void insertAll(List<Student> list){

        if (pan()){
            return;
        }
        mDao.insertOrReplaceInTx(list);
        Log.d(TAG, "添加成功。。。。。。。。。。。。");
    }
    //查询
    public List<Student> showAll(){
        List<Student> list = mDao.queryBuilder().list();
        return list;
    }
    //判断重复
    public boolean pan(){
        List<Student> list = mDao.queryBuilder().list();

        if (list!=null && list.size()>0){
            return true;
        }
        return false;
    }
}
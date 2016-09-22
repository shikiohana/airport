package com.example.administrator.utils;

import android.util.Log;

import com.example.administrator.javabean.OrderDb;

import org.xutils.DbManager;
import org.xutils.db.sqlite.SqlInfo;
import org.xutils.db.table.DbModel;
import org.xutils.ex.DbException;
import org.xutils.x;

/**
 * Created by quick_tech cpc on 2016/9/21.
 * 保存未提交的工单
 */
public class SaveOrderData {
   private  static DbManager.DaoConfig daoConfig;
   private static DbManager dbManager;
    public static DbManager.DaoConfig getDaoConfig(){
        if(daoConfig==null){
            daoConfig = new DbManager.DaoConfig()
                    .setAllowTransaction(true)//设置允许开启事务
                    .setDbName("airport.db")//创建数据库的名称
                            // 不设置dbDir时, 默认存储在app的私有目录.
                   // .setDbDir(new File("/sdcard")) // "sdcard"的写法并非最佳实践, 这里为了简单, 先这样写了.
                    .setDbVersion(1)//数据库版本号
                    .setDbOpenListener(new DbManager.DbOpenListener() {
                        @Override
                        public void onDbOpened(DbManager db) {
                            // 开启WAL, 对写入加速提升巨大
                            db.getDatabase().enableWriteAheadLogging();
                        }
                    })
                    .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                        @Override
                        public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                            // TODO: ...
                            //db.addColumn(...);
                            // db.dropTable(...);
                            // ...
                            // or
                            // db.dropDb();
                        }
                    });
        }
        return daoConfig;
    }


    public static void saveOrder(OrderDb orderDb){


        daoConfig=getDaoConfig();
        dbManager= x.getDb(daoConfig);
        try {

            DbModel model= dbManager.findDbModelFirst(new SqlInfo("select * from orders where code = "+orderDb.code));

            if(model==null) {
                dbManager.save(orderDb);
                Log.i("save", "success");
            }else{
                Log.i("save","fail");
            }
        } catch (DbException e) {
            e.printStackTrace();
        }
    }


    public static void clear(){
        daoConfig=getDaoConfig();
        dbManager= x.getDb(daoConfig);
        try {
            dbManager.delete(OrderDb.class);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

}

package com.example.mrizkip.mukidi;

import android.app.Application;
import android.content.Context;

import org.greenrobot.greendao.database.Database;

/**
 * Created by mrizkip on 12/6/2016.
 */
public class MukidiApplication extends Application {

    private DaoSession daoSession;
    private static MukidiApplication app;

    @Override
    public void onCreate() {
        super.onCreate();

        if(app == null) app = this;

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "mukidi-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public static MukidiApplication getInstance() {
        return app;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}

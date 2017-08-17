package com.okason.mvpdemo.Activity;

import android.app.Application;

import com.okason.mvpdemo.dagger.AppComponent;
import com.okason.mvpdemo.dagger.AppModule;
import com.okason.mvpdemo.dagger.DaggerAppComponent;
import com.orm.SchemaGenerator;
import com.orm.SugarContext;
import com.orm.SugarDb;

/*** Created by Valentine on 4/20/2016.
 */
public class ProntoShopApplication extends Application {

    private static ProntoShopApplication instance = new ProntoShopApplication();
    private static AppComponent appComponent;

    public static ProntoShopApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        getAppComponent();
        SchemaGenerator schemaGenerator = new SchemaGenerator(getApplicationContext());
        schemaGenerator.deleteTables(new SugarDb(getApplicationContext()).getDB());
        SugarContext.init(getApplicationContext());
        schemaGenerator.createDatabase(new SugarDb(getApplicationContext()).getDB());
    }

    public AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
        }
        return appComponent;
    }
}

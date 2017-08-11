package com.example.nikita.mvpdemo.dagger;

import android.content.Context;

import com.example.nikita.mvpdemo.ProductListContract;

/**
 * Created by nikita on 11/8/17.
 */

public class TempRepositoty {

    @Module
    public class PersistenceModule {
        @Provides
        public ProductListContract.Repository providesProductRepository(Context context){
            return new TempRepository();
        }

    }
}

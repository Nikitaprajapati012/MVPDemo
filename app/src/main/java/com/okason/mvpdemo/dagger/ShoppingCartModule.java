package com.okason.mvpdemo.dagger;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.okason.mvpdemo.Activity.ShoppingCart;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/*** Created by nikita on 16/08/2017.
 */
@Module
public class ShoppingCartModule {

    @Provides
    @Singleton
    SharedPreferences providesSharedPreference(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @Singleton
        // TODO: 16/8/17 this class is provide the instance of shopping cart class
    ShoppingCart providesShoppingCart(SharedPreferences preferences) {
        return new ShoppingCart(preferences);
    }
}

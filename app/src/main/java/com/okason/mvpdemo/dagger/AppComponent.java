package com.okason.mvpdemo.dagger;

import com.okason.mvpdemo.Activity.MainActivity;
import com.okason.mvpdemo.Activity.ProductListener;

import javax.inject.Singleton;

import dagger.Component;

/*** Created by nikita on 16/08/2017.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                ShoppingCartModule.class
        }
)

public interface AppComponent {
    void inject(ProductListener presenter);
    void inject(MainActivity activity);
}

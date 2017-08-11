package com.example.nikita.mvpdemo.dagger;

import com.example.nikita.mvpdemo.MainActivity;
import com.example.nikita.mvpdemo.Presenter.ProductListPresenter;

/*** Created by nikita on 11/8/17.
 */

public class Presenter {
    @Singleton
    @Component(
            modules = {
                    AppModule.class,
                    ShoppingCartModule.class,
                    TempRepositoty.PersistenceModule.class
            }
    )
    public interface AppComponent {
        void inject(ProductListener presenter);
        void inject(MainActivity activity);
        void inject(ProductListPresenter presenter);
    }
}

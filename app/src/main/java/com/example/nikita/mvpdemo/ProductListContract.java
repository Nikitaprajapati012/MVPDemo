package com.example.nikita.mvpdemo;

import java.util.List;

/**
 * Created by nikita on 11/8/17.
 */

public class ProductListContract {

    public interface View {
        void showProducts(List&lt;Product&gt;products);

        void showAddProductForm();

        void showEditProductForm(Product product);

        void showDeleteProductPrompt(Product product);

        void showGoogleSearch(Product product);

        void showEmptyText();

        void hideEmptyText();

        void showMessage(String message);

    }

    public interface Actions {
        void loadProducts();

        void onAddProductButtonClicked();

        void onAddToCartButtonClicked(Product product);

        Product getProduct(long id);

        void addProduct(Product product);

        void onDeleteProductButtonClicked(Product product);

        void deleteProduct(Product product);

        void onEditProductButtonClicked(Product product);

        void updateProduct(Product product);

    }

    public interface Repository {

        List&lt;Product&gt;

        getAllProducts();

        Product getProductById(long id);

        void deleteProduct(Product product);

        void addProduct(Product product);

        void updateProduct(Product product);

    }
}

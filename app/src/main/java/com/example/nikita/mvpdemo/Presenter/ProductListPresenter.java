package com.example.nikita.mvpdemo.Presenter;

import com.example.nikita.mvpdemo.ProductListContract;

import javax.inject.Inject;

/*** Created by nikita on 11/8/17.
 */

public class ProductListPresenter implements ProductListContract.Actions {
    private final ProductListContract.View mView;
    @Inject
    ProductListContract.Repository mRepository;
    @Inject ShoppingCart mCart;

    public ProductListPresenter(ProductListContract.View mView) {
        this.mView = mView;
        ProntoShopApplication.getInstance().getAppComponent().inject(this);
    }


    @Override
    public void loadProducts() {
        List<Product> availableProducts = mRepository.getAllProducts();
        if (availableProducts != null && availableProducts.size() > 0){
            mView.hideEmptyText();
            mView.showProducts(availableProducts);

        }else {
            mView.showEmptyText();
        }

    }

    @Override
    public void onAddProductButtonClicked() {
        mView.showAddProductForm();

    }

    @Override
    public void onAddToCartButtonClicked(Product product) {
        //perform add to checkout button here
        LineItem item = new LineItem(product, 1);
        mCart.addItemToCart(item);

    }

    @Override
    public Product getProduct(long id) {
        return mRepository.getProductById(id);
    }

    @Override
    public void addProduct(Product product) {
        mRepository.addProduct(product);

    }

    @Override
    public void onDeleteProductButtonClicked(Product product) {
        mView.showDeleteProductPrompt(product);
    }

    @Override
    public void deleteProduct(Product product) {
        mRepository.deleteProduct(product);
        loadProducts();

    }

    @Override
    public void onEditProductButtonClicked(Product product) {
        //mView.showEditProductForm(product);
        mView.showEditProductForm(product);
    }

    @Override
    public void updateProduct(Product product) {
        mRepository.updateProduct(product);
    }
}

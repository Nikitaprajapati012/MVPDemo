package com.okason.mvpdemo.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.okason.mvpdemo.Adapter.CartAdapter;
import com.okason.mvpdemo.Model.Cart;
import com.okason.mvpdemo.Model.Product;
import com.okason.mvpdemo.R;
import com.okason.mvpdemo.Utils.Constants;
import com.okason.mvpdemo.Utils.Utils;

import java.util.List;

import butterknife.ButterKnife;

public class CartActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerViewProduct;
    ProductListener listener;
    Product productDetails;
    List<Cart> productArrayList;
    Utils utils;
    Toolbar toolbar;
    ImageView imgBack;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        findById();
        init();
        setDataInList();
        click();

        fab.setVisibility(View.INVISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.onAddToCartButtonClicked(productDetails);
            }
        });
    }

    private void findById() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        recyclerViewProduct = (RecyclerView) findViewById(R.id.activity_main_listProduct);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        imgBack = (ImageView) findViewById(R.id.activity_main_imgback);
        imgBack.setVisibility(View.VISIBLE);
    }

    private void init() {
        utils = new Utils(CartActivity.this);
    }

    private void setDataInList() {
        productArrayList = Cart.listAll(Cart.class);
        CartAdapter adapter = new CartAdapter(this, productArrayList);
        utils.replaceFragment(recyclerViewProduct, adapter);
    }

    private void click() {
        imgBack.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_imgback:
                onBackPressed();
                break;
        }
    }
}

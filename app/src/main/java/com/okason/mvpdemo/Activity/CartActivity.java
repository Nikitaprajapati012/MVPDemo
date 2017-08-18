package com.okason.mvpdemo.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.okason.mvpdemo.Adapter.CartAdapter;
import com.okason.mvpdemo.Model.CartItems;
import com.okason.mvpdemo.Model.Product;
import com.okason.mvpdemo.R;
import com.okason.mvpdemo.Utils.Utils;

import java.util.List;

public class CartActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerViewProduct;
    ProductListener listener;
    Product productDetails;
    List<CartItems> productArrayList;
    Utils utils;
    Toolbar toolbar;
    ImageView imgBack;
    public static TextView txtGrandTotal;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findById();
        init();
        setDataInList();
        click();

        fab.setVisibility(View.INVISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        txtGrandTotal = (TextView) findViewById(R.id.activity_main_txtgrandtotal);
        imgBack.setVisibility(View.VISIBLE);
    }

    private void init() {
        utils = new Utils(CartActivity.this);
    }

    private void setDataInList() {
        productArrayList = CartItems.listAll(CartItems.class);
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

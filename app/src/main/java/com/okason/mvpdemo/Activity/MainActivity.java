package com.okason.mvpdemo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.okason.mvpdemo.Adapter.ProductAdapter;
import com.okason.mvpdemo.Model.Product;
import com.okason.mvpdemo.R;
import com.okason.mvpdemo.Utils.Utils;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerViewProduct;
    ProductListener listener;
    //    Product productDetails;
    ImageView imgBack;
    ArrayList<Product> productArrayList;
    Utils utils;
    Toolbar toolbar;
    FloatingActionButton fab;
    public static TextView txtGrandTotal;

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
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();

//                listener.onAddToCartButtonClicked(productDetails);
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
        imgBack.setVisibility(View.GONE);
        txtGrandTotal = (TextView) findViewById(R.id.activity_main_txtgrandtotal);
    }

    private void init() {
        utils = new Utils(MainActivity.this);
    }

    private void setDataInList() {
        productArrayList = new ArrayList<>();
        int[] productId = {1, 2, 3, 4, 5};
        String[] productName = {"Mobile", "TV", "PC", "Fan", "Tubelight"};
        double[] productPrice = {15999, 99999, 39999, 2999, 199};
        String[] productDesc = {"This Mobile have very nice features.",
                "This TV have very nice features.",
                "This PC have very nice features.",
                "This Fan is too fast.",
                "This Tubelight is spread more light."};

        for (int h = 0; h < productId.length; h++) {
            Product productDetails = new Product();
            productDetails.setId(productId[h]);
            productDetails.setProductName(productName[h]);
            productDetails.setSalePrice(productPrice[h]);
            productDetails.setDescription(productDesc[h]);
            productDetails.save();
            productArrayList.add(productDetails);
        }
        ProductAdapter adapter = new ProductAdapter(this, productArrayList);
        utils.replaceFragment(recyclerViewProduct, adapter);
    }

    private void click() {
    }

    public MainActivity() {
        //Here is where the actual injection takes place
        ProntoShopApplication.getInstance().getAppComponent().inject(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cart) {
            Intent intent = new Intent(MainActivity.this, CartActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }
}

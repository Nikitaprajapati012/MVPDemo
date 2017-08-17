package com.okason.mvpdemo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.okason.mvpdemo.Model.Cart;
import com.okason.mvpdemo.Model.Product;
import com.okason.mvpdemo.R;
import com.okason.mvpdemo.Utils.Utils;
import com.orm.util.NamingHelper;

import java.util.ArrayList;
import java.util.List;

/*** Created by nikita on 17/8/17.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<Product> productList;
    private Utils utils;

    public ProductAdapter(Context context, ArrayList<Product> productArrayList) {
        this.mContext = context;
        this.productList = productArrayList;
        this.utils = new Utils(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_product_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Product productDetails = productList.get(position);
        holder.txtProductName.setText(productDetails.getProductName());
        holder.txtProductPrice.setText(String.valueOf(productDetails.getSalePrice()));
        holder.txtProductDescription.setText(productDetails.getDescription());
        holder.imgCancel.setVisibility(View.GONE);
        holder.imgAdd.setVisibility(View.VISIBLE);
        holder.imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Add to cart", Toast.LENGTH_SHORT).show();

/*                Utils.WriteSharePrefrence(mContext,

                        Constants.PRODUCT_ID, String.valueOf(productDetails.getId()));
*/

                List<Product> productListData = Product.find(Product.class, NamingHelper.toSQLNameDefault("id")
                        + " = ? ", String.valueOf(productDetails.getId()));

                for (Product product : productListData) {
                    Cart cart = new Cart();
                    cart.setId(product.getId());
                    cart.setDescription(product.getDescription());
                    cart.setSalePrice(product.getSalePrice());
                    cart.setProductName(product.getProductName());
                    cart.save();
                }


                notifyDataSetChanged();
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtProductName, txtProductPrice, txtProductDescription;
        ImageView imgCancel, imgAdd;

        public MyViewHolder(View itemView) {
            super(itemView);
            imgCancel = (ImageView) itemView.findViewById(R.id.fragment_product_list_imgcancel);
            imgAdd = (ImageView) itemView.findViewById(R.id.fragment_product_list_imgadd);
            txtProductName = (TextView) itemView.findViewById(R.id.fragment_product_list_txtproductname);
            txtProductPrice = (TextView) itemView.findViewById(R.id.fragment_product_list_txtproductprice);
            txtProductDescription = (TextView) itemView.findViewById(R.id.fragment_product_list_txtproductdesc);

        }
    }
}

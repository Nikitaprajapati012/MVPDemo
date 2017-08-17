package com.okason.mvpdemo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.okason.mvpdemo.Model.Cart;
import com.okason.mvpdemo.R;

import java.util.List;

/*** Created by nikita on 17/8/17.
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {
    private Context mContext;
    private List<Cart> productList;

    public CartAdapter(Context context, List<Cart> productArrayList) {
        this.mContext = context;
        this.productList = productArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_product_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Cart productDetails = productList.get(position);
        holder.txtProductName.setText(productDetails.getProductName());
        holder.txtProductPrice.setText(String.valueOf(productDetails.getSalePrice()));
        holder.txtProductDescription.setText(productDetails.getDescription());
        holder.imgCancel.setVisibility(View.VISIBLE);
        holder.imgAdd.setVisibility(View.GONE);
        holder.imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //delete product from cart
                productList.remove(position);
                productDetails.delete();
                notifyDataSetChanged();
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, productList.size());
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

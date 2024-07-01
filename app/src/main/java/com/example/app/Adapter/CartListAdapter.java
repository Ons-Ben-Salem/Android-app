package com.example.app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app.Domain.FoodDomain;
import com.example.app.Helper.ManagementCart;
import com.example.app.Interface.ChangeNumberItemsListener;
import com.example.app.R;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {
    private ArrayList<FoodDomain> listFoodSelected;
    private ManagementCart managementCart;
    ChangeNumberItemsListener changeNumberItemsListener;

    public CartListAdapter(ArrayList<FoodDomain> listFoodSelected , Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.listFoodSelected = listFoodSelected;
        managementCart=new ManagementCart(context);
        this.changeNumberItemsListener=changeNumberItemsListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(listFoodSelected.get(position).getTitle());
        holder.feeEachItem.setText(listFoodSelected.get(position).getFee()+"DT");
        holder.totalEachItem.setText(Math.round((listFoodSelected.get(position).getNumberInCart()*listFoodSelected.get(position).getFee()))+"DT");
        holder.num.setText(String.valueOf(listFoodSelected.get(position).getNumberInCart()));

        // Load the image using Glide
        int drawableResourceId = holder.itemView.getContext().getResources()
                .getIdentifier(listFoodSelected.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.pic);

        holder.plusItem.setOnClickListener(v -> managementCart.plusNumberFood(listFoodSelected,position,()->{
            notifyDataSetChanged();
            changeNumberItemsListener.changed();
        }));

        holder.minusItem.setOnClickListener(v -> managementCart.minusNumberFood(listFoodSelected,position,()->{
            notifyDataSetChanged();
            changeNumberItemsListener.changed();
        }));
        }


    @Override
    public int getItemCount() {
        return listFoodSelected.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, feeEachItem;
        ImageView pic,plusItem,minusItem;
        TextView totalEachItem,num;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTxt);
            pic = itemView.findViewById(R.id.pic);
            feeEachItem = itemView.findViewById(R.id.feeEachItem);
            totalEachItem = itemView.findViewById(R.id.totalEachItem);
            plusItem=itemView.findViewById(R.id.plusCardBtn);
            minusItem=itemView.findViewById(R.id.minusCardBtn);
            num=itemView.findViewById(R.id.numberItemTxt);
        }
    }
}

package com.example.app.Adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.Domain.CategoryDomain;
import com.example.app.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    ArrayList<CategoryDomain> categoryDomains;

    public CategoryAdapter(ArrayList<CategoryDomain> categoryDomains) {
        this.categoryDomains = categoryDomains;
    }

/*    // Inner ViewHolder class
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
*/
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.categoryName.setText(categoryDomains.get(position).getTitle());
        int imageResource = 0; // Initialisez la ressource d'image à 0

        // Utilisez une instruction switch pour déterminer quelle image charger en fonction de la position
        switch (position){
            case 0:
                imageResource = R.drawable.cat_1;
                break;
            case 1:
                imageResource = R.drawable.cat_2;
                break;
            case 2:
                imageResource = R.drawable.cat_3;
                break;
            case 3:
                imageResource = R.drawable.cat_4;
                break;
            case 4:
                imageResource = R.drawable.cat_5;
                break;
        }

        // Chargez l'image dans ImageView en utilisant setImageResource
        holder.categoryPic.setImageResource(imageResource);
    }


    @Override
    public int getItemCount() {
        return categoryDomains.size(); // Change this to the actual size of your data list
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;
        public ViewHolder (@NonNull View itemView){
            super(itemView);
            categoryName=itemView.findViewById(R.id.categoryName);
            categoryPic=itemView.findViewById(R.id.categoryPic);
            mainLayout=itemView.findViewById(R.id.mainLayout);
        }
    }
}

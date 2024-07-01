package com.example.app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.app.Adapter.CategoryAdapter;
import com.example.app.Adapter.RecommendedAdapter;
import com.example.app.Domain.CategoryDomain;
import com.example.app.Domain.FoodDomain;
import com.example.app.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter,adapter2;
private RecyclerView recyclerViewCategotyList,recyclerViewPopularList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewCategoty();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation(){
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);
        LinearLayout partBtn=findViewById(R.id.partBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CartActivity.class));
            }
        });
        partBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PartnersActivity.class));
            }
        });
    }



    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList=findViewById(R.id.view2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("Pepperoni pizza","pizza1","Slice pepoeroni ,mozzarellacheese ,fresh oregano ,ground black pepper, pizza souce",13.0,5,20,1000));
        foodlist.add(new FoodDomain("Cheese burger ","burger","Beef ,Gouda cheese ,Special sauce , Lettuce , tomato",15.20,4,18,1500));
        foodlist.add(new FoodDomain("Vegetable pizza","pizza3","Olive oil ,Vegetable oil ,pitted kalamata ,cherry tomatoes, fresh oregano ,basil",11.0,3,16,800));
        adapter2=new RecommendedAdapter(foodlist);
        recyclerViewPopularList.setAdapter(adapter2);
    }
    private void recyclerViewCategoty (){
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategotyList=findViewById(R.id.view1);
        recyclerViewCategotyList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList=new ArrayList<>();
        categoryList.add(new CategoryDomain("Pizza","cat_1"));
        categoryList.add(new CategoryDomain("Burger","cat_2"));
        categoryList.add(new CategoryDomain("Hotgog","cat_3"));
        categoryList.add(new CategoryDomain("Drink","cat_4"));
        categoryList.add(new CategoryDomain("Donut","cat_5"));

        adapter= new CategoryAdapter(categoryList);
        recyclerViewCategotyList.setAdapter(adapter);


    }
}
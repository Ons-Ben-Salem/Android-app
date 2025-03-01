package com.example.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.app.Domain.FoodDomain;
import com.example.app.Helper.ManagementCart;
import com.example.app.R;

public class ShowDetailActivity extends AppCompatActivity {
    private TextView addToCartBtn;
    private TextView titleTxt,feeTxt,descriptionTxt,numberOrderTxt,totalPriceTxt,starTxt,caloryTxt,timeTxt;
    private ImageView plusBtn,minusBtn,picFood;
    private FoodDomain object;
    private int numberOrder = 1;
    private ManagementCart managementCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        managementCart=new ManagementCart(this);
        iniView();
        getBundle();
    }

    private void getBundle(){
        object=(FoodDomain)getIntent().getSerializableExtra("object");
        int drawableResourceId=this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this).load(drawableResourceId).into(picFood);

        titleTxt.setText(object.getTitle());
        feeTxt.setText(object.getFee()+ "DT");
        descriptionTxt.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(numberOrder));
        caloryTxt.setText(object.getCalories()+ "Calories");
        starTxt.setText(object.getStar()+"");
        titleTxt.setText(object.getTime()+ "minutes");
        totalPriceTxt.setText(Math.round(numberOrder*object.getFee())+"DT");

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOrder = numberOrder + 1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
                totalPriceTxt.setText(Math.round(numberOrder*object.getFee())+"DT");
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberOrder > 1){
                    numberOrder = numberOrder - 1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
                totalPriceTxt.setText(Math.round(numberOrder*object.getFee())+"DT");
            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumberInCart(numberOrder);
                managementCart.insertFood(object);
            }
        });


    }
    private void iniView(){
        addToCartBtn=findViewById(R.id.addToCartBtn);
        titleTxt=findViewById(R.id.titleTxt);
        feeTxt=findViewById(R.id.priceTxt);
        descriptionTxt=findViewById(R.id.descriptionTxt);
        numberOrderTxt=findViewById(R.id.numberItemTxt);
        plusBtn=findViewById(R.id.plusCardBtn);
        minusBtn=findViewById(R.id.minusCardBtn);
        picFood=findViewById(R.id.foodPic);
        totalPriceTxt=findViewById(R.id.totalPriceTxt);
        starTxt=findViewById(R.id.starTxt);
        caloryTxt=findViewById(R.id.caloriesTxt);
        timeTxt=findViewById(R.id.timeTxt);




    }
}
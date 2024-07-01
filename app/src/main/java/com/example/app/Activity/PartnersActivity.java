package com.example.app.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;


import com.example.app.R;

public class PartnersActivity extends AppCompatActivity {

    // Ajoutez les IDs des ressources des images de restaurants
    private static final int[] restaurantImages = {
            R.drawable.restaurant1,
            R.drawable.restaurant2,
            R.drawable.restaurant3,
            R.drawable.restaurant4,
            R.drawable.restaurant5,
            // Ajoutez les IDs des autres images de restaurants ici
    };

    // URLs des sites web des restaurants
    private static final String[] restaurantUrls = {
            "https://www.restaurant1.com",
            "https://www.restaurant2.com",
            "https://www.restaurant3.com",
            // Ajoutez les URLs des autres restaurants ici
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.partners);

        GridView gridView = findViewById(R.id.gridView);
        // Adapter pour les images des restaurants
        ImageAdapter adapter = new ImageAdapter(this, restaurantImages);
        gridView.setAdapter(adapter);

        // Gérer le clic sur une image
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // Ouvrir le site web correspondant au restaurant sélectionné
                openWebsite(restaurantUrls[position]);
            }
        });
    }

    private void bottomNavigation(){
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout partBtn = findViewById(R.id.partBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PartnersActivity.this, MainActivity.class));
            }
        });

        partBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PartnersActivity.this, PartnersActivity.class));
            }
        });
    }

    // Fonction pour ouvrir un site web
    private void openWebsite(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}

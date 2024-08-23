package com.android.onlineshoppingapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import com.android.onlineshoppingapp.databinding.ActivityMainBinding;
import com.android.onlineshoppingapp.fragments.CategoryPageFragment;
import com.android.onlineshoppingapp.fragments.HomePageFragment;
import com.android.onlineshoppingapp.fragments.ProfilePageFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FirebaseFirestore db;
    private FirebaseUser user;
    private FirebaseAuth fAuth;
//    public static UserInformation userInformation = new UserInformation();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(binding.getRoot());
        fAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();

        if (user == null) {
            finish();
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
        }

//        db.collection("Users").document(user.getUid()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if (task.isSuccessful()) {
//                    DocumentSnapshot documentSnapshot = task.getResult();
//                    if (documentSnapshot.exists()) {
//                        Log.d(TAG, "DocumentSnapshot data: " + documentSnapshot.getData());
//                        userInformation = documentSnapshot.toObject(UserInformation.class);
//                        Log.e(TAG, userInformation.getAccountType());
//                    } else {
//                        Log.d(TAG, "No such document");
//                    }
//                } else {
//                    Log.d(TAG, "get failed with ", task.getException());
//                }
//            }
//        });


        db.collection("Users").document(fAuth.getCurrentUser().getUid()).get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (Objects.equals(documentSnapshot.getString("accountType"), "Shipper")) {
                        finish();
                        startActivity(new Intent(MainActivity.this, ShipperActivity.class));
                    }
                });


        // show bottom navigation view
        replaceFragment(new HomePageFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home_nav:
                    replaceFragment(new HomePageFragment());
                    break;
                case R.id.category_nav:
                    replaceFragment(new CategoryPageFragment());
                    break;
                case R.id.profile_nav:
                    replaceFragment(new ProfilePageFragment());
                    break;
            }
            return true;
        });

    }


    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout_main, fragment)
                .commit();
    }

}
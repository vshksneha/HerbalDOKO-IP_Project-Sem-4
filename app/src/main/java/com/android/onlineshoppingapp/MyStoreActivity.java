package com.android.onlineshoppingapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.onlineshoppingapp.adapters.RecyclerViewAdapterProduct;
import com.android.onlineshoppingapp.adapters.SimpleGalleryRecyclerAdapter;
import com.android.onlineshoppingapp.models.Product;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MyStoreActivity extends AppCompatActivity {

    private RecyclerView rvPopularProducts, rvRecentlyProducts, rvAllProducts;
    private RecyclerViewAdapterProduct recyclerViewAdapterProduct;
    private List<Product> popularProductList, recentlyProductList, allProductList;
    private SimpleGalleryRecyclerAdapter simpleGalleryRecyclerAdapter;

    private TextView tvShopName, tvSeemorePopular, tvSeemoreRecently, tvSeemoreAll;
    private CardView cardAddProduct, cardManageProduct, cardViewSaleStatistic;
    private ImageView ivVerifyBtnStore, ivBackToProfile, ivAvatarStore;

    private Button btnAddImage, btnAddProduct, btnFollowMyStore;

    private FirebaseAuth fAuth;
    private FirebaseUser user;
    private FirebaseFirestore db;

    public static List<String> imageUriList = new ArrayList<String>();

    private List<Uri> imageList = new ArrayList<Uri>();
    private String newProductId;

    private  List<String> categoryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_store);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        // init
        tvShopName = findViewById(R.id.tvShopName);
        cardAddProduct = findViewById(R.id.cardAddProduct);
        cardManageProduct = findViewById(R.id.cardManageProduct);
        cardViewSaleStatistic = findViewById(R.id.cardViewSaleStatistic);
        ivVerifyBtnStore = findViewById(R.id.ivVerifyBtnStore);
        ivBackToProfile = findViewById(R.id.ivBackToProfile);
        ivAvatarStore = findViewById(R.id.ivAvatarStore);
        tvSeemorePopular = findViewById(R.id.tvSeeMorePopularStore);
        tvSeemoreRecently = findViewById(R.id.tvSeeMoreRecentlyStore);
        tvSeemoreAll = findViewById(R.id.tvSeeMoreAllStore);
        btnFollowMyStore = findViewById(R.id.btnFollowMyStore);
        btnFollowMyStore.setVisibility(View.GONE);


        fAuth = FirebaseAuth.getInstance();
        user = fAuth.getCurrentUser();
        db = FirebaseFirestore.getInstance();

        // click on back
        ivBackToProfile.setOnClickListener(view -> onBackPressed());

        db.collection("Users").document(Objects.requireNonNull(fAuth.getCurrentUser()).getUid()).get()
                .addOnSuccessListener(documentSnapshot -> {
                    String seller = getIntent().getStringExtra("sellerOfProduct");
                    if (seller != null) {
                        if (Objects.requireNonNull(documentSnapshot.getString("accountType")).equals("Sell")) {
                            if (seller.equals(fAuth.getCurrentUser().getUid()))
                                showForSaleAccount();
                            else
                                showForPurchaseAccount(seller);
                        } else
                            showForPurchaseAccount(seller);
                    } else {
                        showForSaleAccount();
                    }
                });

    }

    @SuppressLint("SetTextI18n")
    private void showForPurchaseAccount(String seller) {

//        if (user.getPhotoUrl() != null) {
//            Glide.with(this)
//                    .load(user.getPhotoUrl())
//                    .into(ivAvatarStore);
//        }

        btnFollowMyStore.setVisibility(View.VISIBLE);
        // change shop name
        db.collection("Users")
                .document(seller)
                .get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        String lastName = documentSnapshot.getString("firstName");
                        String firstName = documentSnapshot.getString("lastName");
                        if (lastName != null) {
                            if (lastName.isEmpty()) {
                                tvShopName.setText(firstName);
                            } else {
                                tvShopName.setText(String.format("%s %s", firstName, lastName));
                            }
                        }
                        if (documentSnapshot.getString("avatarUrl") != null)
                            Glide.with(this)
                                    .load(documentSnapshot.getString("avatarUrl"))
                                    .into(ivAvatarStore);
                    }
                });

        //set text follow btn
        AsyncTask.execute(() -> {
            db.collection("Users")
                    .document(Objects.requireNonNull(fAuth.getCurrentUser()).getUid())
                    .collection("Following")
                    .addSnapshotListener((value, error) -> {
                        if (error != null)
                            Log.e("set text", Objects.requireNonNull(error.getMessage()));

                        if (value != null) {
                            Boolean aBoolean = true;
                            btnFollowMyStore.setText("Follow the store");
                            for (DocumentSnapshot documentSnapshot1 : value) {
                                if (seller.equals(documentSnapshot1.getId())) {
                                    btnFollowMyStore.setText("Followed");
                                    aBoolean = false;
                                }
                            }
                            //set event follow btn
                            if (aBoolean) {
                                btnFollowMyStore.setOnClickListener(view -> {
                                    Map<String, Object> map = new HashMap<>();
                                    map.put("sellerRef", db.collection("Users").document(seller));
                                    db.collection("Users")
                                            .document(Objects.requireNonNull(fAuth.getCurrentUser()).getUid())
                                            .collection("Following")
                                            .document(seller)
                                            .set(map)
                                            .addOnSuccessListener(unused -> {
//                        Toast.makeText(this, "Đã theo dõi", Toast.LENGTH_SHORT).show();
                                                btnFollowMyStore.setText("Followed");
                                                //increase follower of seller
                                                //get follower
                                                db.collection("Users")
                                                        .document(seller)
                                                        .get()
                                                        .addOnSuccessListener(documentSnapshot -> {
                                                            if (documentSnapshot.exists()) {
                                                                Map<String, Object> map1 = new HashMap<>();
                                                                if (documentSnapshot.getLong("followers") != null)
                                                                    map1.put("followers", documentSnapshot.getLong("followers") + 1);
                                                                else
                                                                    map1.put("followers", 1);
                                                                db.collection("Users")
                                                                        .document(seller)
                                                                        .set(map1, SetOptions.merge())
                                                                        .addOnFailureListener(e -> Log.e("increase follower", Objects.requireNonNull(e.getMessage())));
                                                            }
                                                        });

                                            })
                                            .addOnFailureListener(e -> {
                                                Toast.makeText(this, "An error occurred", Toast.LENGTH_SHORT).show();
                                                Log.e("follow store", Objects.requireNonNull(e.getMessage()));
                                            });
                                });
                            } else {
                                btnFollowMyStore.setOnClickListener(view -> {
                                    db.collection("Users")
                                            .document(fAuth.getCurrentUser().getUid())
                                            .collection("Following")
                                            .document(seller)
                                            .delete()
                                            .addOnSuccessListener(unused -> {
                                                btnFollowMyStore.setText("Follow the store");
                                                //decrease follower of seller
                                                //get follower
                                                db.collection("Users")
                                                        .document(seller)
                                                        .get()
                                                        .addOnSuccessListener(documentSnapshot -> {
                                                            if (documentSnapshot.exists()) {
                                                                Map<String, Object> map1 = new HashMap<>();
                                                                if (documentSnapshot.getLong("followers") != null)
                                                                    map1.put("followers", documentSnapshot.getLong("followers") - 1);
                                                                else
                                                                    map1.put("followers", 0);
                                                                db.collection("Users")
                                                                        .document(seller)
                                                                        .set(map1, SetOptions.merge())
                                                                        .addOnFailureListener(e -> Log.e("decrease follower", Objects.requireNonNull(e.getMessage())));
                                                            }
                                                        });
                                            })
                                            .addOnFailureListener(e -> Log.e("delete seller", Objects.requireNonNull(e.getMessage())));
                                });
                            }
                        }
                    });
        });


        cardAddProduct.setVisibility(View.GONE);
        cardManageProduct.setVisibility(View.GONE);
        cardViewSaleStatistic.setVisibility(View.GONE);

        // customer view part

        // show product
        showPopularProduct(seller);
        showRecentlyProduct(seller);
        showAllProduct(seller);

        // click on see more
        tvSeemorePopular.setOnClickListener(view -> navigateToListOfProduct("popular", seller));

        tvSeemoreRecently.setOnClickListener(view -> navigateToListOfProduct("recently", seller));

        tvSeemoreAll.setOnClickListener(view -> navigateToListOfProduct("all", seller));

    }

    private void showForSaleAccount() {

        if (user.getPhotoUrl() != null) {
            Glide.with(this)
                    .load(user.getPhotoUrl())
                    .into(ivAvatarStore);
        }

        // change shop name
        db.collection("Users")
                .document(Objects.requireNonNull(fAuth.getCurrentUser()).getUid())
                .get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        String lastName = documentSnapshot.getString("lastName");
                        String firstName = documentSnapshot.getString("firstName");
                        if (lastName != null) {
                            if (lastName.isEmpty()) {
                                tvShopName.setText(firstName);
                            } else {
                                tvShopName.setText(String.format("%s %s", firstName, lastName));
                            }
                        }
                        if (documentSnapshot.getString("avatarUrl") != null)
                            Glide.with(this)
                                    .load(documentSnapshot.getString("avatarUrl"))
                                    .into(ivAvatarStore);
                    }
                });


        // show product
        showPopularProduct("own");
        showRecentlyProduct("own");
        showAllProduct("own");

        // click on card add product
        cardAddProduct.setOnClickListener(v -> {
            Log.e("CLICKED", "clicked");
            addProductBottomSheetView();
            Toast.makeText(MyStoreActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
        });

        // test
        cardManageProduct.setOnClickListener(view -> startActivity(new Intent(MyStoreActivity.this, ManageProductActivity.class)));

        cardViewSaleStatistic.setOnClickListener(view -> {
            startActivity(new Intent(MyStoreActivity.this, SaleStatisticActivity.class));
        });

        // click on see more
        tvSeemorePopular.setOnClickListener(view -> navigateToListOfProduct("popular", "own"));

        tvSeemoreRecently.setOnClickListener(view -> navigateToListOfProduct("recently", "own"));

        tvSeemoreAll.setOnClickListener(view -> navigateToListOfProduct("all", "own"));
    }


    private void showPopularProduct(String seller) {

        popularProductList = new ArrayList<>();
        rvPopularProducts = findViewById(R.id.rvPopularProductsStore);

        db.collection("Products")
                .whereEqualTo("seller", (seller.equals("own")) ? Objects.requireNonNull(fAuth.getCurrentUser()).getUid() : seller)
                .orderBy("quantitySold", Query.Direction.DESCENDING)
                .orderBy("productPrice", Query.Direction.ASCENDING)
                .limit(10)
                .addSnapshotListener((value, error) -> {
                    if (error != null) {
                        Log.w(TAG, "Listen failed.", error);
                        return;
                    }
                    popularProductList.clear();
                    assert value != null;
                    for (QueryDocumentSnapshot document : value) {
                        Product product = document.toObject(Product.class);
                        product.setProductId(document.getId());
                        popularProductList.add(product);
                    }

                    // setup recyclerview: recently products
                    recyclerViewAdapterProduct = new RecyclerViewAdapterProduct(popularProductList, MyStoreActivity.this);
                    rvPopularProducts.setLayoutManager(new LinearLayoutManager(MyStoreActivity.this, LinearLayoutManager.HORIZONTAL, false));
                    rvPopularProducts.setAdapter(recyclerViewAdapterProduct);
                });
    }

    private void showRecentlyProduct(String seller) {

        recentlyProductList = new ArrayList<>();
        rvRecentlyProducts = findViewById(R.id.rvRecentlyProductsStore);


        db.collection("Products")
                .whereEqualTo("seller", (seller.equals("own")) ? Objects.requireNonNull(fAuth.getCurrentUser()).getUid() : seller)
                .orderBy("createTime", Query.Direction.DESCENDING)
                .limit(10)
                .addSnapshotListener((value, error) -> {
                    if (error != null) {
                        Log.w(TAG, "Listen failed.", error);
                        return;
                    }

                    recentlyProductList.clear();
                    assert value != null;
                    for (QueryDocumentSnapshot document : value) {
                        Product product = document.toObject(Product.class);
                        product.setProductId(document.getId());
                        recentlyProductList.add(product);
                    }
                    // setup recyclerview: recently products
                    recyclerViewAdapterProduct = new RecyclerViewAdapterProduct(recentlyProductList, MyStoreActivity.this);
                    rvRecentlyProducts.setLayoutManager(new LinearLayoutManager(MyStoreActivity.this, LinearLayoutManager.HORIZONTAL, false));
                    rvRecentlyProducts.setAdapter(recyclerViewAdapterProduct);

                });
    }

    private void showAllProduct(String seller) {

        allProductList = new ArrayList<>();
        rvAllProducts = findViewById(R.id.rvAllProductsStore);

        db.collection("Products")
                .whereEqualTo("seller", (seller.equals("own")) ? Objects.requireNonNull(fAuth.getCurrentUser()).getUid() : seller)
                .limit(10)
                .addSnapshotListener((value, error) -> {
                    if (error != null) {
                        Log.w(TAG, "Listen failed.", error);
                        return;
                    }

                    allProductList.clear();
                    assert value != null;
                    for (QueryDocumentSnapshot document : value) {
                        Product product = document.toObject(Product.class);
                        product.setProductId(document.getId());
                        allProductList.add(product);
                    }

                    // setup recyclerview: recently products
                    recyclerViewAdapterProduct = new RecyclerViewAdapterProduct(allProductList, MyStoreActivity.this);
                    rvAllProducts.setLayoutManager(new LinearLayoutManager(MyStoreActivity.this, LinearLayoutManager.HORIZONTAL, false));
                    rvAllProducts.setAdapter(recyclerViewAdapterProduct);
                });
    }

    private void navigateToListOfProduct(String key, String seller) {
        Intent intent = new Intent(this, ListOfProductActivity.class);
        switch (key) {
            case "popular":
                intent.putExtra("see_more_product", "popular");
                intent.putExtra("sellerDetail", seller);
                startActivity(intent);
                break;
            case "recently":
                intent.putExtra("see_more_product", "recently");
                intent.putExtra("sellerDetail", seller);
                startActivity(intent);
                break;
            case "all":
                intent.putExtra("see_more_product", "all");
                intent.putExtra("sellerDetail", seller);
                startActivity(intent);
                break;
        }
    }

    private void addProductBottomSheetView() {

        @SuppressLint("InflateParams") View sheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_layout_addproduct, null);
        BottomSheetDialog bottomSheetDialogAddProduct = new BottomSheetDialog(MyStoreActivity.this);
        bottomSheetDialogAddProduct.setContentView(sheetView);
        bottomSheetDialogAddProduct.setCancelable(false);

        btnAddProduct = sheetView.findViewById(R.id.btnBottomSheetAddProduct);
        btnAddImage = sheetView.findViewById(R.id.btnAddImage);


        // click on close bottom sheet
        sheetView.findViewById(R.id.bottomSheetAddProductClose).setOnClickListener(view -> {
            // close bottom sheet dialog
            bottomSheetDialogAddProduct.dismiss();
        });

        // check product name
        TextInputEditText etProductName = sheetView.findViewById(R.id.bottomSheetAddProductName);
        TextInputLayout layoutProductName = sheetView.findViewById(R.id.layout_bottomSheetAddProductName);
        etProductName.setOnFocusChangeListener((view, onFocus) -> {
            if (!onFocus) {
                if (Objects.requireNonNull(etProductName.getText()).toString().isEmpty()) {
                    layoutProductName.setHelperText("Product name cannot be blank");
                }
            } else {
                layoutProductName.setHelperTextEnabled(false);
            }
        });

        // check product description
        TextInputEditText etProductDescription = sheetView.findViewById(R.id.bottomSheetAddProductDescription);
        TextInputLayout layoutProductDescription = sheetView.findViewById(R.id.layout_bottomSheetAddProductDescription);
        etProductDescription.setOnFocusChangeListener((view, onFocus) -> {
            if (!onFocus) {
                if (Objects.requireNonNull(etProductDescription.getText()).toString().isEmpty()) {
                    layoutProductDescription.setHelperText("Product description cannot be empty");
                }
            } else {
                layoutProductDescription.setHelperTextEnabled(false);
            }
        });

        // check product price
        TextInputEditText etProductPrice = sheetView.findViewById(R.id.bottomSheetAddProductPrice);
        TextInputLayout layoutProductPrice = sheetView.findViewById(R.id.layout_bottomSheetAddProductPrice);
        etProductPrice.setOnFocusChangeListener((view, onFocus) -> {
            if (!onFocus) {
                if (Objects.requireNonNull(etProductPrice.getText()).toString().isEmpty()) {
                    layoutProductPrice.setHelperText("Product price cannot be blank");
                }
            } else {
                layoutProductPrice.setHelperTextEnabled(false);
            }
        });

        // check quantity
        TextInputEditText etProductQuantity = sheetView.findViewById(R.id.bottomSheetAddProductQuantity);
        TextInputLayout layoutProductQuantity = sheetView.findViewById(R.id.layout_bottomSheetAddProductQuantity);
        etProductQuantity.setOnFocusChangeListener((view, onFocus) -> {
            if (!onFocus) {
                if (Objects.requireNonNull(etProductQuantity.getText()).toString().isEmpty()) {
                    layoutProductQuantity.setHelperText("Quantity cannot be blank");
                }
            } else {
                layoutProductQuantity.setHelperTextEnabled(false);
            }
        });

        //set category
        AutoCompleteTextView ctvCategory = sheetView.findViewById(R.id.tvCategory);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                categoryList
        );
        ctvCategory.setAdapter(adapter);
        AsyncTask.execute(() -> {
            categoryList.clear();
            db.collection("Categories").get().addOnSuccessListener(queryDocumentSnapshots -> {
                for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    categoryList.add(documentSnapshot.getString("name"));
                }
            });
        });

        // add image
        RecyclerView rvImages = sheetView.findViewById(R.id.rvImages);
        // setup recyclerview:
        simpleGalleryRecyclerAdapter = new SimpleGalleryRecyclerAdapter(imageList, MyStoreActivity.this);
        rvImages.setLayoutManager(new LinearLayoutManager(MyStoreActivity.this, LinearLayoutManager.HORIZONTAL, false));
        rvImages.setAdapter(simpleGalleryRecyclerAdapter);
        btnAddImage.setOnClickListener(view -> {
            rvImages.setVisibility(View.VISIBLE);
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
            intent.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(intent, 1);
            startActivityForResult(Intent.createChooser(intent, "Select one (multiple) images"), 1);
        });

        // click on add button
        btnAddProduct.setOnClickListener(view -> {
            newProductId = db.collection("Products").document().getId();
            uploadImage();
            String category = "Other";
            if (!ctvCategory.equals("Select category"))
                category = String.valueOf(ctvCategory.getText());
            addProduct(Objects.requireNonNull(etProductName.getText()).toString(),
                    Objects.requireNonNull(etProductDescription.getText()).toString(),
                    Integer.parseInt(Objects.requireNonNull(etProductPrice.getText()).toString()), Integer.parseInt(Objects.requireNonNull(etProductQuantity.getText()).toString()), category);
            bottomSheetDialogAddProduct.dismiss();
        });

        bottomSheetDialogAddProduct.show();
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();

    }

    @SuppressLint("SimpleDateFormat")
    private void addProduct(String etProductName, String etProductDescription, int etProductPrice, int etProductQuantity, String category) {
        Map<String, Object> product = new HashMap<>();
        product.put("productName", etProductName);
        product.put("seller", Objects.requireNonNull(fAuth.getCurrentUser()).getUid());
        product.put("description", etProductDescription);
        product.put("category", category);
        product.put("productPrice", etProductPrice);
        product.put("createTime", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
        product.put("rate", 0);
        product.put("likeNumber", 0);
        product.put("quantitySold", 0);
        product.put("quantity", etProductQuantity);
        db.collection("Products").document(newProductId).set(product).addOnSuccessListener(unused -> {
            imageUriList.clear();
            imageList.clear();
            Toast.makeText(MyStoreActivity.this, "Added product successfully", Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        imageList.clear();
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                assert data != null;
                if (data.getClipData() != null) {
                    int count = data.getClipData().getItemCount();

                    int CurrentImageSelect = 0;

                    while (CurrentImageSelect < count) {
                        Uri imageuri = data.getClipData().getItemAt(CurrentImageSelect).getUri();
                        imageList.add(imageuri);
                        CurrentImageSelect = CurrentImageSelect + 1;
                    }

                } else {
                    Uri imageuri = data.getData();
                    imageList.add(imageuri);
                }
                simpleGalleryRecyclerAdapter.notifyDataSetChanged();
            }

        }

    }


    private void uploadImage() {
        for (int i = 0; i < imageList.size(); i++) {
            StorageReference ref = FirebaseStorage.getInstance()
                    .getReference()
                    .child("productImages")
                    .child(newProductId).child(String.valueOf(i));
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageList.get(i));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

                ref.putBytes(byteArrayOutputStream.toByteArray())
                        .addOnSuccessListener(taskSnapshot -> getDownloadUri(ref))
                        .addOnFailureListener(e -> {
                            Toast.makeText(MyStoreActivity.this,
                                    "An error occurred " + e.getMessage(),
                                    Toast.LENGTH_SHORT).show();
                            Log.e(TAG, Objects.requireNonNull(e.getMessage()));
                        });

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Log.e(TAG, String.valueOf(imageUriList.size()));


    }

    private void getDownloadUri(StorageReference ref) {
        ref.getDownloadUrl()
                .addOnSuccessListener(uri -> {
                    imageUriList.add(String.valueOf(uri));
                    Map<String, Object> image = new HashMap<>();
                    image.put("url", imageUriList);
                    db.collection("productImages").document(newProductId).set(image);
                })
                .addOnFailureListener(e -> Toast.makeText(this,
                        "An error occurred " + e.getMessage(), Toast.LENGTH_SHORT).show());

    }

}
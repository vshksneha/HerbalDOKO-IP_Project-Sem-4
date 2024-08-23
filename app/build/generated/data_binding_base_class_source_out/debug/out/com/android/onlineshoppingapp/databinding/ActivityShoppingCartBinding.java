// Generated by view binder compiler. Do not edit!
package com.android.onlineshoppingapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.onlineshoppingapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityShoppingCartBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button btnBuyCart;

  @NonNull
  public final CardView cardControlShoppingCart;

  @NonNull
  public final CheckBox cbSelectAllCart;

  @NonNull
  public final EditText etCouponCart;

  @NonNull
  public final ImageView ivBackCart;

  @NonNull
  public final ImageView ivCheckCouponCart;

  @NonNull
  public final RelativeLayout layoutToolbarCart;

  @NonNull
  public final RecyclerView rvProductCart;

  @NonNull
  public final TextView tvCouponCart;

  @NonNull
  public final TextView tvTotalCart;

  private ActivityShoppingCartBinding(@NonNull RelativeLayout rootView, @NonNull Button btnBuyCart,
      @NonNull CardView cardControlShoppingCart, @NonNull CheckBox cbSelectAllCart,
      @NonNull EditText etCouponCart, @NonNull ImageView ivBackCart,
      @NonNull ImageView ivCheckCouponCart, @NonNull RelativeLayout layoutToolbarCart,
      @NonNull RecyclerView rvProductCart, @NonNull TextView tvCouponCart,
      @NonNull TextView tvTotalCart) {
    this.rootView = rootView;
    this.btnBuyCart = btnBuyCart;
    this.cardControlShoppingCart = cardControlShoppingCart;
    this.cbSelectAllCart = cbSelectAllCart;
    this.etCouponCart = etCouponCart;
    this.ivBackCart = ivBackCart;
    this.ivCheckCouponCart = ivCheckCouponCart;
    this.layoutToolbarCart = layoutToolbarCart;
    this.rvProductCart = rvProductCart;
    this.tvCouponCart = tvCouponCart;
    this.tvTotalCart = tvTotalCart;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityShoppingCartBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityShoppingCartBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_shopping_cart, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityShoppingCartBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnBuyCart;
      Button btnBuyCart = ViewBindings.findChildViewById(rootView, id);
      if (btnBuyCart == null) {
        break missingId;
      }

      id = R.id.cardControlShoppingCart;
      CardView cardControlShoppingCart = ViewBindings.findChildViewById(rootView, id);
      if (cardControlShoppingCart == null) {
        break missingId;
      }

      id = R.id.cbSelectAllCart;
      CheckBox cbSelectAllCart = ViewBindings.findChildViewById(rootView, id);
      if (cbSelectAllCart == null) {
        break missingId;
      }

      id = R.id.etCouponCart;
      EditText etCouponCart = ViewBindings.findChildViewById(rootView, id);
      if (etCouponCart == null) {
        break missingId;
      }

      id = R.id.ivBackCart;
      ImageView ivBackCart = ViewBindings.findChildViewById(rootView, id);
      if (ivBackCart == null) {
        break missingId;
      }

      id = R.id.ivCheckCouponCart;
      ImageView ivCheckCouponCart = ViewBindings.findChildViewById(rootView, id);
      if (ivCheckCouponCart == null) {
        break missingId;
      }

      id = R.id.layoutToolbarCart;
      RelativeLayout layoutToolbarCart = ViewBindings.findChildViewById(rootView, id);
      if (layoutToolbarCart == null) {
        break missingId;
      }

      id = R.id.rvProductCart;
      RecyclerView rvProductCart = ViewBindings.findChildViewById(rootView, id);
      if (rvProductCart == null) {
        break missingId;
      }

      id = R.id.tvCouponCart;
      TextView tvCouponCart = ViewBindings.findChildViewById(rootView, id);
      if (tvCouponCart == null) {
        break missingId;
      }

      id = R.id.tvTotalCart;
      TextView tvTotalCart = ViewBindings.findChildViewById(rootView, id);
      if (tvTotalCart == null) {
        break missingId;
      }

      return new ActivityShoppingCartBinding((RelativeLayout) rootView, btnBuyCart,
          cardControlShoppingCart, cbSelectAllCart, etCouponCart, ivBackCart, ivCheckCouponCart,
          layoutToolbarCart, rvProductCart, tvCouponCart, tvTotalCart);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

// Generated by view binder compiler. Do not edit!
package com.android.onlineshoppingapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.onlineshoppingapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CardProductInCartBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final CheckBox cbProductICart;

  @NonNull
  public final EditText etNumProductICart;

  @NonNull
  public final ImageView ivAddICart;

  @NonNull
  public final ImageView ivDeleteProductICart;

  @NonNull
  public final ImageView ivMinusICart;

  @NonNull
  public final ImageView ivProductImageICart;

  @NonNull
  public final TextView tvProductPriceICart;

  @NonNull
  public final TextView tvProductSellerICart;

  @NonNull
  public final TextView tvProductTitleICart;

  private CardProductInCartBinding(@NonNull LinearLayout rootView, @NonNull CheckBox cbProductICart,
      @NonNull EditText etNumProductICart, @NonNull ImageView ivAddICart,
      @NonNull ImageView ivDeleteProductICart, @NonNull ImageView ivMinusICart,
      @NonNull ImageView ivProductImageICart, @NonNull TextView tvProductPriceICart,
      @NonNull TextView tvProductSellerICart, @NonNull TextView tvProductTitleICart) {
    this.rootView = rootView;
    this.cbProductICart = cbProductICart;
    this.etNumProductICart = etNumProductICart;
    this.ivAddICart = ivAddICart;
    this.ivDeleteProductICart = ivDeleteProductICart;
    this.ivMinusICart = ivMinusICart;
    this.ivProductImageICart = ivProductImageICart;
    this.tvProductPriceICart = tvProductPriceICart;
    this.tvProductSellerICart = tvProductSellerICart;
    this.tvProductTitleICart = tvProductTitleICart;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CardProductInCartBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CardProductInCartBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.card_product_in_cart, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CardProductInCartBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cbProductICart;
      CheckBox cbProductICart = ViewBindings.findChildViewById(rootView, id);
      if (cbProductICart == null) {
        break missingId;
      }

      id = R.id.etNumProductICart;
      EditText etNumProductICart = ViewBindings.findChildViewById(rootView, id);
      if (etNumProductICart == null) {
        break missingId;
      }

      id = R.id.ivAddICart;
      ImageView ivAddICart = ViewBindings.findChildViewById(rootView, id);
      if (ivAddICart == null) {
        break missingId;
      }

      id = R.id.ivDeleteProductICart;
      ImageView ivDeleteProductICart = ViewBindings.findChildViewById(rootView, id);
      if (ivDeleteProductICart == null) {
        break missingId;
      }

      id = R.id.ivMinusICart;
      ImageView ivMinusICart = ViewBindings.findChildViewById(rootView, id);
      if (ivMinusICart == null) {
        break missingId;
      }

      id = R.id.ivProductImageICart;
      ImageView ivProductImageICart = ViewBindings.findChildViewById(rootView, id);
      if (ivProductImageICart == null) {
        break missingId;
      }

      id = R.id.tvProductPriceICart;
      TextView tvProductPriceICart = ViewBindings.findChildViewById(rootView, id);
      if (tvProductPriceICart == null) {
        break missingId;
      }

      id = R.id.tvProductSellerICart;
      TextView tvProductSellerICart = ViewBindings.findChildViewById(rootView, id);
      if (tvProductSellerICart == null) {
        break missingId;
      }

      id = R.id.tvProductTitleICart;
      TextView tvProductTitleICart = ViewBindings.findChildViewById(rootView, id);
      if (tvProductTitleICart == null) {
        break missingId;
      }

      return new CardProductInCartBinding((LinearLayout) rootView, cbProductICart,
          etNumProductICart, ivAddICart, ivDeleteProductICart, ivMinusICart, ivProductImageICart,
          tvProductPriceICart, tvProductSellerICart, tvProductTitleICart);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

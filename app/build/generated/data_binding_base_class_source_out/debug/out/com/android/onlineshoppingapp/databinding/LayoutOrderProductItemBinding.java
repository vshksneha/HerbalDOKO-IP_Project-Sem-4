// Generated by view binder compiler. Do not edit!
package com.android.onlineshoppingapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public final class LayoutOrderProductItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView ivProductImageOrder;

  @NonNull
  public final TextView tvCategoryOrder;

  @NonNull
  public final TextView tvNumberOrder;

  @NonNull
  public final TextView tvProductNameOrder;

  @NonNull
  public final TextView tvProductPriceOrder;

  private LayoutOrderProductItemBinding(@NonNull LinearLayout rootView,
      @NonNull ImageView ivProductImageOrder, @NonNull TextView tvCategoryOrder,
      @NonNull TextView tvNumberOrder, @NonNull TextView tvProductNameOrder,
      @NonNull TextView tvProductPriceOrder) {
    this.rootView = rootView;
    this.ivProductImageOrder = ivProductImageOrder;
    this.tvCategoryOrder = tvCategoryOrder;
    this.tvNumberOrder = tvNumberOrder;
    this.tvProductNameOrder = tvProductNameOrder;
    this.tvProductPriceOrder = tvProductPriceOrder;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutOrderProductItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutOrderProductItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_order_product_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutOrderProductItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ivProductImageOrder;
      ImageView ivProductImageOrder = ViewBindings.findChildViewById(rootView, id);
      if (ivProductImageOrder == null) {
        break missingId;
      }

      id = R.id.tvCategoryOrder;
      TextView tvCategoryOrder = ViewBindings.findChildViewById(rootView, id);
      if (tvCategoryOrder == null) {
        break missingId;
      }

      id = R.id.tvNumberOrder;
      TextView tvNumberOrder = ViewBindings.findChildViewById(rootView, id);
      if (tvNumberOrder == null) {
        break missingId;
      }

      id = R.id.tvProductNameOrder;
      TextView tvProductNameOrder = ViewBindings.findChildViewById(rootView, id);
      if (tvProductNameOrder == null) {
        break missingId;
      }

      id = R.id.tvProductPriceOrder;
      TextView tvProductPriceOrder = ViewBindings.findChildViewById(rootView, id);
      if (tvProductPriceOrder == null) {
        break missingId;
      }

      return new LayoutOrderProductItemBinding((LinearLayout) rootView, ivProductImageOrder,
          tvCategoryOrder, tvNumberOrder, tvProductNameOrder, tvProductPriceOrder);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

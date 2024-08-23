// Generated by view binder compiler. Do not edit!
package com.android.onlineshoppingapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.onlineshoppingapp.R;
import com.google.android.material.card.MaterialCardView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutItemFollowingBinding implements ViewBinding {
  @NonNull
  private final MaterialCardView rootView;

  @NonNull
  public final Button btnUnfollow;

  @NonNull
  public final ImageView ivAvatarShopFollow;

  @NonNull
  public final TextView tvShopNameFollow;

  private LayoutItemFollowingBinding(@NonNull MaterialCardView rootView,
      @NonNull Button btnUnfollow, @NonNull ImageView ivAvatarShopFollow,
      @NonNull TextView tvShopNameFollow) {
    this.rootView = rootView;
    this.btnUnfollow = btnUnfollow;
    this.ivAvatarShopFollow = ivAvatarShopFollow;
    this.tvShopNameFollow = tvShopNameFollow;
  }

  @Override
  @NonNull
  public MaterialCardView getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutItemFollowingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutItemFollowingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_item_following, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutItemFollowingBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnUnfollow;
      Button btnUnfollow = ViewBindings.findChildViewById(rootView, id);
      if (btnUnfollow == null) {
        break missingId;
      }

      id = R.id.ivAvatarShopFollow;
      ImageView ivAvatarShopFollow = ViewBindings.findChildViewById(rootView, id);
      if (ivAvatarShopFollow == null) {
        break missingId;
      }

      id = R.id.tvShopNameFollow;
      TextView tvShopNameFollow = ViewBindings.findChildViewById(rootView, id);
      if (tvShopNameFollow == null) {
        break missingId;
      }

      return new LayoutItemFollowingBinding((MaterialCardView) rootView, btnUnfollow,
          ivAvatarShopFollow, tvShopNameFollow);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

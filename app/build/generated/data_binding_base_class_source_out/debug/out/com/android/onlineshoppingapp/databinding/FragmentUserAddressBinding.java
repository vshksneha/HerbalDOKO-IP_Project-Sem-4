// Generated by view binder compiler. Do not edit!
package com.android.onlineshoppingapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.onlineshoppingapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentUserAddressBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final ImageView ivChangeUserAddress;

  @NonNull
  public final TextView tvAddress1;

  @NonNull
  public final TextView tvAddress2;

  @NonNull
  public final TextView tvDefaultFAddress;

  @NonNull
  public final TextView tvFullNameAddress1;

  @NonNull
  public final TextView tvFullNameAddress2;

  @NonNull
  public final TextView tvPhoneNumberAddress1;

  @NonNull
  public final TextView tvPhoneNumberAddress2;

  private FragmentUserAddressBinding(@NonNull FrameLayout rootView,
      @NonNull ImageView ivChangeUserAddress, @NonNull TextView tvAddress1,
      @NonNull TextView tvAddress2, @NonNull TextView tvDefaultFAddress,
      @NonNull TextView tvFullNameAddress1, @NonNull TextView tvFullNameAddress2,
      @NonNull TextView tvPhoneNumberAddress1, @NonNull TextView tvPhoneNumberAddress2) {
    this.rootView = rootView;
    this.ivChangeUserAddress = ivChangeUserAddress;
    this.tvAddress1 = tvAddress1;
    this.tvAddress2 = tvAddress2;
    this.tvDefaultFAddress = tvDefaultFAddress;
    this.tvFullNameAddress1 = tvFullNameAddress1;
    this.tvFullNameAddress2 = tvFullNameAddress2;
    this.tvPhoneNumberAddress1 = tvPhoneNumberAddress1;
    this.tvPhoneNumberAddress2 = tvPhoneNumberAddress2;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentUserAddressBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentUserAddressBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_user_address, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentUserAddressBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ivChangeUserAddress;
      ImageView ivChangeUserAddress = ViewBindings.findChildViewById(rootView, id);
      if (ivChangeUserAddress == null) {
        break missingId;
      }

      id = R.id.tvAddress1;
      TextView tvAddress1 = ViewBindings.findChildViewById(rootView, id);
      if (tvAddress1 == null) {
        break missingId;
      }

      id = R.id.tvAddress2;
      TextView tvAddress2 = ViewBindings.findChildViewById(rootView, id);
      if (tvAddress2 == null) {
        break missingId;
      }

      id = R.id.tvDefaultFAddress;
      TextView tvDefaultFAddress = ViewBindings.findChildViewById(rootView, id);
      if (tvDefaultFAddress == null) {
        break missingId;
      }

      id = R.id.tvFullNameAddress1;
      TextView tvFullNameAddress1 = ViewBindings.findChildViewById(rootView, id);
      if (tvFullNameAddress1 == null) {
        break missingId;
      }

      id = R.id.tvFullNameAddress2;
      TextView tvFullNameAddress2 = ViewBindings.findChildViewById(rootView, id);
      if (tvFullNameAddress2 == null) {
        break missingId;
      }

      id = R.id.tvPhoneNumberAddress1;
      TextView tvPhoneNumberAddress1 = ViewBindings.findChildViewById(rootView, id);
      if (tvPhoneNumberAddress1 == null) {
        break missingId;
      }

      id = R.id.tvPhoneNumberAddress2;
      TextView tvPhoneNumberAddress2 = ViewBindings.findChildViewById(rootView, id);
      if (tvPhoneNumberAddress2 == null) {
        break missingId;
      }

      return new FragmentUserAddressBinding((FrameLayout) rootView, ivChangeUserAddress, tvAddress1,
          tvAddress2, tvDefaultFAddress, tvFullNameAddress1, tvFullNameAddress2,
          tvPhoneNumberAddress1, tvPhoneNumberAddress2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

// Generated by view binder compiler. Do not edit!
package com.android.onlineshoppingapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.onlineshoppingapp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentChangePasswordBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final Button btnOkFP;

  @NonNull
  public final TextInputEditText editTxtNewPassFP;

  @NonNull
  public final TextInputEditText editTxtNewRePassFP;

  @NonNull
  public final TextInputLayout txtFieldNewPassFP;

  @NonNull
  public final TextInputLayout txtFieldNewRePassFP;

  private FragmentChangePasswordBinding(@NonNull FrameLayout rootView, @NonNull Button btnOkFP,
      @NonNull TextInputEditText editTxtNewPassFP, @NonNull TextInputEditText editTxtNewRePassFP,
      @NonNull TextInputLayout txtFieldNewPassFP, @NonNull TextInputLayout txtFieldNewRePassFP) {
    this.rootView = rootView;
    this.btnOkFP = btnOkFP;
    this.editTxtNewPassFP = editTxtNewPassFP;
    this.editTxtNewRePassFP = editTxtNewRePassFP;
    this.txtFieldNewPassFP = txtFieldNewPassFP;
    this.txtFieldNewRePassFP = txtFieldNewRePassFP;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentChangePasswordBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentChangePasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_change_password, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentChangePasswordBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnOkFP;
      Button btnOkFP = ViewBindings.findChildViewById(rootView, id);
      if (btnOkFP == null) {
        break missingId;
      }

      id = R.id.editTxtNewPassFP;
      TextInputEditText editTxtNewPassFP = ViewBindings.findChildViewById(rootView, id);
      if (editTxtNewPassFP == null) {
        break missingId;
      }

      id = R.id.editTxtNewRePassFP;
      TextInputEditText editTxtNewRePassFP = ViewBindings.findChildViewById(rootView, id);
      if (editTxtNewRePassFP == null) {
        break missingId;
      }

      id = R.id.txtFieldNewPassFP;
      TextInputLayout txtFieldNewPassFP = ViewBindings.findChildViewById(rootView, id);
      if (txtFieldNewPassFP == null) {
        break missingId;
      }

      id = R.id.txtFieldNewRePassFP;
      TextInputLayout txtFieldNewRePassFP = ViewBindings.findChildViewById(rootView, id);
      if (txtFieldNewRePassFP == null) {
        break missingId;
      }

      return new FragmentChangePasswordBinding((FrameLayout) rootView, btnOkFP, editTxtNewPassFP,
          editTxtNewRePassFP, txtFieldNewPassFP, txtFieldNewRePassFP);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

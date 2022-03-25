// Generated by view binder compiler. Do not edit!
package com.techcamino.mft_rider.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.techcamino.mft_rider.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class SuborderViewDesignBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final CardView acceptBtn;

  @NonNull
  public final CardView cardView;

  @NonNull
  public final ImageView imageview;

  @NonNull
  public final PlaceholderBinding placeholder;

  @NonNull
  public final TextView suborderId;

  @NonNull
  public final ImageView suborderImage;

  private SuborderViewDesignBinding(@NonNull CardView rootView, @NonNull CardView acceptBtn,
      @NonNull CardView cardView, @NonNull ImageView imageview,
      @NonNull PlaceholderBinding placeholder, @NonNull TextView suborderId,
      @NonNull ImageView suborderImage) {
    this.rootView = rootView;
    this.acceptBtn = acceptBtn;
    this.cardView = cardView;
    this.imageview = imageview;
    this.placeholder = placeholder;
    this.suborderId = suborderId;
    this.suborderImage = suborderImage;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static SuborderViewDesignBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SuborderViewDesignBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.suborder_view_design, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SuborderViewDesignBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.accept_btn;
      CardView acceptBtn = ViewBindings.findChildViewById(rootView, id);
      if (acceptBtn == null) {
        break missingId;
      }

      id = R.id.cardView;
      CardView cardView = ViewBindings.findChildViewById(rootView, id);
      if (cardView == null) {
        break missingId;
      }

      id = R.id.imageview;
      ImageView imageview = ViewBindings.findChildViewById(rootView, id);
      if (imageview == null) {
        break missingId;
      }

      id = R.id.placeholder;
      View placeholder = ViewBindings.findChildViewById(rootView, id);
      if (placeholder == null) {
        break missingId;
      }
      PlaceholderBinding binding_placeholder = PlaceholderBinding.bind(placeholder);

      id = R.id.suborder_id;
      TextView suborderId = ViewBindings.findChildViewById(rootView, id);
      if (suborderId == null) {
        break missingId;
      }

      id = R.id.suborder_image;
      ImageView suborderImage = ViewBindings.findChildViewById(rootView, id);
      if (suborderImage == null) {
        break missingId;
      }

      return new SuborderViewDesignBinding((CardView) rootView, acceptBtn, cardView, imageview,
          binding_placeholder, suborderId, suborderImage);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
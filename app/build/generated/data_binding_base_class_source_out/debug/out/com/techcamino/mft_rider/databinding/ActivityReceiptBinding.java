// Generated by view binder compiler. Do not edit!
package com.techcamino.mft_rider.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.techcamino.mft_rider.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityReceiptBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView addressType;

  @NonNull
  public final TextView altNum;

  @NonNull
  public final View contextView;

  @NonNull
  public final TextView delCity;

  @NonNull
  public final Button deliveredBtn;

  @NonNull
  public final CardView detail;

  @NonNull
  public final RelativeLayout footerCard;

  @NonNull
  public final TextView helpNumber;

  @NonNull
  public final CardView imageCardView;

  @NonNull
  public final TextView noData;

  @NonNull
  public final TextView recAddress;

  @NonNull
  public final TextView recName;

  @NonNull
  public final TextView recNum;

  @NonNull
  public final NestedScrollView scrollView;

  @NonNull
  public final RecyclerView suborders;

  @NonNull
  public final ToolbarBinding toolbar;

  @NonNull
  public final ImageView uploadedImage;

  private ActivityReceiptBinding(@NonNull ConstraintLayout rootView, @NonNull TextView addressType,
      @NonNull TextView altNum, @NonNull View contextView, @NonNull TextView delCity,
      @NonNull Button deliveredBtn, @NonNull CardView detail, @NonNull RelativeLayout footerCard,
      @NonNull TextView helpNumber, @NonNull CardView imageCardView, @NonNull TextView noData,
      @NonNull TextView recAddress, @NonNull TextView recName, @NonNull TextView recNum,
      @NonNull NestedScrollView scrollView, @NonNull RecyclerView suborders,
      @NonNull ToolbarBinding toolbar, @NonNull ImageView uploadedImage) {
    this.rootView = rootView;
    this.addressType = addressType;
    this.altNum = altNum;
    this.contextView = contextView;
    this.delCity = delCity;
    this.deliveredBtn = deliveredBtn;
    this.detail = detail;
    this.footerCard = footerCard;
    this.helpNumber = helpNumber;
    this.imageCardView = imageCardView;
    this.noData = noData;
    this.recAddress = recAddress;
    this.recName = recName;
    this.recNum = recNum;
    this.scrollView = scrollView;
    this.suborders = suborders;
    this.toolbar = toolbar;
    this.uploadedImage = uploadedImage;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityReceiptBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityReceiptBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_receipt, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityReceiptBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.address_type;
      TextView addressType = ViewBindings.findChildViewById(rootView, id);
      if (addressType == null) {
        break missingId;
      }

      id = R.id.alt_num;
      TextView altNum = ViewBindings.findChildViewById(rootView, id);
      if (altNum == null) {
        break missingId;
      }

      id = R.id.context_view;
      View contextView = ViewBindings.findChildViewById(rootView, id);
      if (contextView == null) {
        break missingId;
      }

      id = R.id.del_city;
      TextView delCity = ViewBindings.findChildViewById(rootView, id);
      if (delCity == null) {
        break missingId;
      }

      id = R.id.delivered_btn;
      Button deliveredBtn = ViewBindings.findChildViewById(rootView, id);
      if (deliveredBtn == null) {
        break missingId;
      }

      id = R.id.detail;
      CardView detail = ViewBindings.findChildViewById(rootView, id);
      if (detail == null) {
        break missingId;
      }

      id = R.id.footer_card;
      RelativeLayout footerCard = ViewBindings.findChildViewById(rootView, id);
      if (footerCard == null) {
        break missingId;
      }

      id = R.id.help_number;
      TextView helpNumber = ViewBindings.findChildViewById(rootView, id);
      if (helpNumber == null) {
        break missingId;
      }

      id = R.id.imageCardView;
      CardView imageCardView = ViewBindings.findChildViewById(rootView, id);
      if (imageCardView == null) {
        break missingId;
      }

      id = R.id.no_data;
      TextView noData = ViewBindings.findChildViewById(rootView, id);
      if (noData == null) {
        break missingId;
      }

      id = R.id.rec_address;
      TextView recAddress = ViewBindings.findChildViewById(rootView, id);
      if (recAddress == null) {
        break missingId;
      }

      id = R.id.rec_name;
      TextView recName = ViewBindings.findChildViewById(rootView, id);
      if (recName == null) {
        break missingId;
      }

      id = R.id.rec_num;
      TextView recNum = ViewBindings.findChildViewById(rootView, id);
      if (recNum == null) {
        break missingId;
      }

      id = R.id.scrollView;
      NestedScrollView scrollView = ViewBindings.findChildViewById(rootView, id);
      if (scrollView == null) {
        break missingId;
      }

      id = R.id.suborders;
      RecyclerView suborders = ViewBindings.findChildViewById(rootView, id);
      if (suborders == null) {
        break missingId;
      }

      id = R.id.toolbar;
      View toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }
      ToolbarBinding binding_toolbar = ToolbarBinding.bind(toolbar);

      id = R.id.uploaded_image;
      ImageView uploadedImage = ViewBindings.findChildViewById(rootView, id);
      if (uploadedImage == null) {
        break missingId;
      }

      return new ActivityReceiptBinding((ConstraintLayout) rootView, addressType, altNum,
          contextView, delCity, deliveredBtn, detail, footerCard, helpNumber, imageCardView, noData,
          recAddress, recName, recNum, scrollView, suborders, binding_toolbar, uploadedImage);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
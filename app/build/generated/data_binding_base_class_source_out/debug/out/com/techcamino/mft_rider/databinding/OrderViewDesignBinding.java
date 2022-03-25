// Generated by view binder compiler. Do not edit!
package com.techcamino.mft_rider.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public final class OrderViewDesignBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final CardView acceptBtn;

  @NonNull
  public final TextView acptText;

  @NonNull
  public final LinearLayout actionRow;

  @NonNull
  public final CardView cardView;

  @NonNull
  public final TextView decText;

  @NonNull
  public final CardView declineBtn;

  @NonNull
  public final TextView delAddress;

  @NonNull
  public final TextView delMethod;

  @NonNull
  public final TextView delTime;

  @NonNull
  public final ImageView imageview;

  @NonNull
  public final CardView kmView;

  @NonNull
  public final TextView orderId;

  @NonNull
  public final EditText phoneNumber;

  @NonNull
  public final TextView tvTitle;

  @NonNull
  public final CardView viewMap;

  @NonNull
  public final TextView viewMapText;

  private OrderViewDesignBinding(@NonNull CardView rootView, @NonNull CardView acceptBtn,
      @NonNull TextView acptText, @NonNull LinearLayout actionRow, @NonNull CardView cardView,
      @NonNull TextView decText, @NonNull CardView declineBtn, @NonNull TextView delAddress,
      @NonNull TextView delMethod, @NonNull TextView delTime, @NonNull ImageView imageview,
      @NonNull CardView kmView, @NonNull TextView orderId, @NonNull EditText phoneNumber,
      @NonNull TextView tvTitle, @NonNull CardView viewMap, @NonNull TextView viewMapText) {
    this.rootView = rootView;
    this.acceptBtn = acceptBtn;
    this.acptText = acptText;
    this.actionRow = actionRow;
    this.cardView = cardView;
    this.decText = decText;
    this.declineBtn = declineBtn;
    this.delAddress = delAddress;
    this.delMethod = delMethod;
    this.delTime = delTime;
    this.imageview = imageview;
    this.kmView = kmView;
    this.orderId = orderId;
    this.phoneNumber = phoneNumber;
    this.tvTitle = tvTitle;
    this.viewMap = viewMap;
    this.viewMapText = viewMapText;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static OrderViewDesignBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static OrderViewDesignBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.order_view_design, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static OrderViewDesignBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.accept_btn;
      CardView acceptBtn = ViewBindings.findChildViewById(rootView, id);
      if (acceptBtn == null) {
        break missingId;
      }

      id = R.id.acpt_text;
      TextView acptText = ViewBindings.findChildViewById(rootView, id);
      if (acptText == null) {
        break missingId;
      }

      id = R.id.action_row;
      LinearLayout actionRow = ViewBindings.findChildViewById(rootView, id);
      if (actionRow == null) {
        break missingId;
      }

      id = R.id.cardView;
      CardView cardView = ViewBindings.findChildViewById(rootView, id);
      if (cardView == null) {
        break missingId;
      }

      id = R.id.dec_text;
      TextView decText = ViewBindings.findChildViewById(rootView, id);
      if (decText == null) {
        break missingId;
      }

      id = R.id.decline_btn;
      CardView declineBtn = ViewBindings.findChildViewById(rootView, id);
      if (declineBtn == null) {
        break missingId;
      }

      id = R.id.del_address;
      TextView delAddress = ViewBindings.findChildViewById(rootView, id);
      if (delAddress == null) {
        break missingId;
      }

      id = R.id.del_method;
      TextView delMethod = ViewBindings.findChildViewById(rootView, id);
      if (delMethod == null) {
        break missingId;
      }

      id = R.id.del_time;
      TextView delTime = ViewBindings.findChildViewById(rootView, id);
      if (delTime == null) {
        break missingId;
      }

      id = R.id.imageview;
      ImageView imageview = ViewBindings.findChildViewById(rootView, id);
      if (imageview == null) {
        break missingId;
      }

      id = R.id.km_view;
      CardView kmView = ViewBindings.findChildViewById(rootView, id);
      if (kmView == null) {
        break missingId;
      }

      id = R.id.order_id;
      TextView orderId = ViewBindings.findChildViewById(rootView, id);
      if (orderId == null) {
        break missingId;
      }

      id = R.id.phone_number;
      EditText phoneNumber = ViewBindings.findChildViewById(rootView, id);
      if (phoneNumber == null) {
        break missingId;
      }

      id = R.id.tv_title;
      TextView tvTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvTitle == null) {
        break missingId;
      }

      id = R.id.view_map;
      CardView viewMap = ViewBindings.findChildViewById(rootView, id);
      if (viewMap == null) {
        break missingId;
      }

      id = R.id.view_map_text;
      TextView viewMapText = ViewBindings.findChildViewById(rootView, id);
      if (viewMapText == null) {
        break missingId;
      }

      return new OrderViewDesignBinding((CardView) rootView, acceptBtn, acptText, actionRow,
          cardView, decText, declineBtn, delAddress, delMethod, delTime, imageview, kmView, orderId,
          phoneNumber, tvTitle, viewMap, viewMapText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
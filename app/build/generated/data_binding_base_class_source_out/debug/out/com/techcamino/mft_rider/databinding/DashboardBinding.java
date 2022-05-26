// Generated by view binder compiler. Do not edit!
package com.techcamino.mft_rider.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.techcamino.mft_rider.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DashboardBinding implements ViewBinding {
  @NonNull
  private final NestedScrollView rootView;

  @NonNull
  public final View contextView;

  @NonNull
  public final TextView noData;

  @NonNull
  public final RecyclerView orderList;

  private DashboardBinding(@NonNull NestedScrollView rootView, @NonNull View contextView,
      @NonNull TextView noData, @NonNull RecyclerView orderList) {
    this.rootView = rootView;
    this.contextView = contextView;
    this.noData = noData;
    this.orderList = orderList;
  }

  @Override
  @NonNull
  public NestedScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static DashboardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DashboardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dashboard, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DashboardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.context_view;
      View contextView = ViewBindings.findChildViewById(rootView, id);
      if (contextView == null) {
        break missingId;
      }

      id = R.id.no_data;
      TextView noData = ViewBindings.findChildViewById(rootView, id);
      if (noData == null) {
        break missingId;
      }

      id = R.id.order_list;
      RecyclerView orderList = ViewBindings.findChildViewById(rootView, id);
      if (orderList == null) {
        break missingId;
      }

      return new DashboardBinding((NestedScrollView) rootView, contextView, noData, orderList);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

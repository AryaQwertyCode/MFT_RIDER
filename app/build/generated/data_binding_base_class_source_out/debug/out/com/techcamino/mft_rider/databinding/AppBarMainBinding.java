// Generated by view binder compiler. Do not edit!
package com.techcamino.mft_rider.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.techcamino.mft_rider.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AppBarMainBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final AppBarLayout appbarlayoutlll;

  @NonNull
  public final ContentMainBinding orderListView;

  @NonNull
  public final RelativeLayout relativeLayout;

  @NonNull
  public final RelativeLayout relativeLayoutone;

  @NonNull
  public final MaterialToolbar toolbar;

  @NonNull
  public final TextView tvTitle;

  private AppBarMainBinding(@NonNull RelativeLayout rootView, @NonNull AppBarLayout appbarlayoutlll,
      @NonNull ContentMainBinding orderListView, @NonNull RelativeLayout relativeLayout,
      @NonNull RelativeLayout relativeLayoutone, @NonNull MaterialToolbar toolbar,
      @NonNull TextView tvTitle) {
    this.rootView = rootView;
    this.appbarlayoutlll = appbarlayoutlll;
    this.orderListView = orderListView;
    this.relativeLayout = relativeLayout;
    this.relativeLayoutone = relativeLayoutone;
    this.toolbar = toolbar;
    this.tvTitle = tvTitle;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AppBarMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AppBarMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.app_bar_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AppBarMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.appbarlayoutlll;
      AppBarLayout appbarlayoutlll = ViewBindings.findChildViewById(rootView, id);
      if (appbarlayoutlll == null) {
        break missingId;
      }

      id = R.id.order_list_view;
      View orderListView = ViewBindings.findChildViewById(rootView, id);
      if (orderListView == null) {
        break missingId;
      }
      ContentMainBinding binding_orderListView = ContentMainBinding.bind(orderListView);

      id = R.id.relative_layout;
      RelativeLayout relativeLayout = ViewBindings.findChildViewById(rootView, id);
      if (relativeLayout == null) {
        break missingId;
      }

      RelativeLayout relativeLayoutone = (RelativeLayout) rootView;

      id = R.id.toolbar;
      MaterialToolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.tv_title;
      TextView tvTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvTitle == null) {
        break missingId;
      }

      return new AppBarMainBinding((RelativeLayout) rootView, appbarlayoutlll,
          binding_orderListView, relativeLayout, relativeLayoutone, toolbar, tvTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

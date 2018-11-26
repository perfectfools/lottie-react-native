package com.airbnb.lottie.model.content;


import androidx.annotation.Nullable;

import com.airbnb.android.react.lottie.LottieDrawable;
import com.airbnb.android.react.lottie.animation.content.Content;
import com.airbnb.android.react.lottie.model.layer.BaseLayer;

public interface ContentModel {
  @Nullable Content toContent(LottieDrawable drawable, BaseLayer layer);
}

package com.airbnb.android.react.lottie.value;

import android.view.animation.Interpolator;

import com.airbnb.android.react.lottie.utils.MiscUtils;

@SuppressWarnings("unused")
public class LottieInterpolatedFloatValue extends LottieInterpolatedValue<Float> {

  public LottieInterpolatedFloatValue(Float startValue, Float endValue) {
    super(startValue, endValue);
  }

  public LottieInterpolatedFloatValue(Float startValue, Float endValue, Interpolator interpolator) {
    super(startValue, endValue, interpolator);
  }

  @Override Float interpolateValue(Float startValue, Float endValue, float progress) {
    return MiscUtils.lerp(startValue, endValue, progress);
  }
}

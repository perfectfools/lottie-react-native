package com.airbnb.lottie.model.animatable;

import com.airbnb.android.react.lottie.animation.keyframe.BaseKeyframeAnimation;

public interface AnimatableValue<K, A> {
  BaseKeyframeAnimation<K, A> createAnimation();
}

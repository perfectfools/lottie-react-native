package com.airbnb.android.react.lottie.model.animatable;

import com.airbnb.android.react.lottie.value.Keyframe;
import com.airbnb.android.react.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.android.react.lottie.animation.keyframe.FloatKeyframeAnimation;

import java.util.List;

public class AnimatableFloatValue extends BaseAnimatableValue<Float, Float> {

  AnimatableFloatValue() {
    super(0f);
  }

  public AnimatableFloatValue(List<Keyframe<Float>> keyframes) {
    super(keyframes);
  }

  @Override public BaseKeyframeAnimation<Float, Float> createAnimation() {
    return new FloatKeyframeAnimation(keyframes);
  }
}

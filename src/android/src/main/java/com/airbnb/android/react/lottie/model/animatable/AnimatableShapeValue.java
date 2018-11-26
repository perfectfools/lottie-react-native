package com.airbnb.android.react.lottie.model.animatable;

import android.graphics.Path;

import com.airbnb.android.react.lottie.value.Keyframe;
import com.airbnb.android.react.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.android.react.lottie.animation.keyframe.ShapeKeyframeAnimation;
import com.airbnb.android.react.lottie.model.content.ShapeData;

import java.util.List;

public class AnimatableShapeValue extends BaseAnimatableValue<ShapeData, Path> {

  public AnimatableShapeValue(List<Keyframe<ShapeData>> keyframes) {
    super(keyframes);
  }

  @Override public BaseKeyframeAnimation<ShapeData, Path> createAnimation() {
    return new ShapeKeyframeAnimation(keyframes);
  }
}

package com.airbnb.android.react.lottie.animation.keyframe;

import com.airbnb.android.react.lottie.value.Keyframe;
import com.airbnb.android.react.lottie.model.DocumentData;

import java.util.List;

public class TextKeyframeAnimation extends KeyframeAnimation<DocumentData> {
  public TextKeyframeAnimation(List<Keyframe<DocumentData>> keyframes) {
    super(keyframes);
  }

  @Override DocumentData getValue(Keyframe<DocumentData> keyframe, float keyframeProgress) {
    return keyframe.startValue;
  }
}

package com.airbnb.android.react.lottie.parser;

import android.util.JsonReader;

import com.airbnb.android.react.lottie.LottieComposition;
import com.airbnb.android.react.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.android.react.lottie.model.animatable.AnimatableTransform;
import com.airbnb.android.react.lottie.model.content.Repeater;

import java.io.IOException;

class RepeaterParser {

  private RepeaterParser() {}

  static Repeater parse(
      JsonReader reader, LottieComposition composition) throws IOException {
    String name = null;
    AnimatableFloatValue copies = null;
    AnimatableFloatValue offset = null;
    AnimatableTransform transform = null;

    while (reader.hasNext()) {
      switch (reader.nextName()) {
        case "nm":
          name = reader.nextString();
          break;
        case "c":
          copies = AnimatableValueParser.parseFloat(reader, composition, false);
          break;
        case "o":
          offset = AnimatableValueParser.parseFloat(reader, composition, false);
          break;
        case "tr":
          transform = AnimatableTransformParser.parse(reader, composition);
          break;
        default:
          reader.skipValue();
      }
    }

    return new Repeater(name, copies, offset, transform);
  }
}

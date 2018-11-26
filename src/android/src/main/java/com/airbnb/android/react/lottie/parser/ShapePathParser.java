package com.airbnb.lottie.parser;

import android.util.JsonReader;

import com.airbnb.android.react.lottie.LottieComposition;
import com.airbnb.android.react.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.android.react.lottie.model.content.ShapePath;

import java.io.IOException;

class ShapePathParser {

  private ShapePathParser() {}

  static ShapePath parse(
      JsonReader reader, LottieComposition composition) throws IOException {
    String name = null;
    int ind = 0;
    AnimatableShapeValue shape = null;

    while (reader.hasNext()) {
      switch (reader.nextName()) {
        case "nm":
          name = reader.nextString();
          break;
        case "ind":
          ind = reader.nextInt();
          break;
        case "ks":
          shape = AnimatableValueParser.parseShapeData(reader, composition);
          break;
        default:
          reader.skipValue();
      }
    }

    return new ShapePath(name, ind, shape);
  }
}

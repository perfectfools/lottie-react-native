package com.airbnb.android.react.lottie;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewCompat;

import android.util.Log;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;


import org.json.JSONObject;

import java.util.Map;

class LottieAnimationViewManager extends SimpleViewManager<LottieAnimationView> {
  private static final String TAG = LottieAnimationViewManager.class.getSimpleName();
  private static final String REACT_CLASS = "LottieAnimationView";
  private static final int VERSION = 1;
  private static final int COMMAND_PLAY = 1;
  private static final int COMMAND_RESET = 2;
  private static final int COMMAND_PAUSE = 3;
  private static final int COMMAND_RESUME = 4;

  private float blur = 0;
  public static final int defaultRadius = 10;
  public static final int defaultSampling = 10;

  @Override public Map<String, Object> getExportedViewConstants() {
    return MapBuilder.<String, Object>builder()
            .put("VERSION", VERSION)
            .build();
  }

  @Override public String getName() {
    return REACT_CLASS;
  }

  @Override public LottieAnimationView createViewInstance(ThemedReactContext context) {
    LottieAnimationView lview = new LottieAnimationView(context, this.blur);

    //lview.setAdjustViewBounds(true);
    //lview.setScaleType(ImageView.ScaleType.CENTER_CROP);

    return lview;
  }

  @Override public Map<String, Integer> getCommandsMap() {
    return MapBuilder.of(
            "play", COMMAND_PLAY,
            "reset", COMMAND_RESET,
            "pause", COMMAND_PAUSE,
            "resume", COMMAND_RESUME
    );
  }

  @Override
  public void receiveCommand(final LottieAnimationView view, int commandId, ReadableArray args) {
    switch (commandId) {
      case COMMAND_PLAY: {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
          @Override public void run() {
            if (ViewCompat.isAttachedToWindow(view)) {
              //view.setProgress(0f);
              view.playAnimation();

            }
          }
        });
      }
      break;
      case COMMAND_RESET: {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
          @Override public void run() {
            if (ViewCompat.isAttachedToWindow(view)) {
              view.cancelAnimation();
              view.setProgress(0f);
            }
          }
        });
      }
      break;
      case COMMAND_PAUSE: {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
          @Override public void run() {
            if (ViewCompat.isAttachedToWindow(view)) {
              view.pauseAnimation();
            }
          }
        });
      }
      break;
      case COMMAND_RESUME: {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
          @Override public void run() {
            if (ViewCompat.isAttachedToWindow(view)) {
              view.resumeAnimation();
            }
          }
        });
      }
      break;
    }
  }

  // TODO: cache strategy

  @ReactProp(name = "sourceName")
  public void setSourceName(LottieAnimationView view, String name) {
    view.setAnimation(name,this.blur);
  }

  @ReactProp(name = "sourceJson")
  public void setSourceJson(LottieAnimationView view, ReadableMap json) {

    try {

      view.setAnimation(new JSONObject(json.toHashMap()),this.blur);
    } catch (Exception e) {
      // TODO: expose this to the user better. maybe an `onError` event?
      Log.e(TAG,"setSourceJsonError", e);
    }
  }

  @ReactProp(name = "resizeMode")
  public void setResizeMode(LottieAnimationView view, String resizeMode) {

    /*if ("cover".equals(resizeMode)) {
      view.setScaleType(ImageView.ScaleType.CENTER_CROP);
    } else if ("contain".equals(resizeMode)) {
      view.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    } else if ("center".equals(resizeMode)) {
      view.setScaleType(ImageView.ScaleType.CENTER);
    }*/
  }

  @ReactProp(name = "progress")
  public void setProgress(LottieAnimationView view, float progress) {
    view.setProgress(progress);
  }

  @ReactProp(name = "blur")
  public void setBlurry(LottieAnimationView view, float blur) {

    view.setBlur(blur);
    this.blur = blur;
  }

  @ReactProp(name = "speed")
  public void setSpeed(LottieAnimationView view, double speed) {
    view.setSpeed((float) speed);
  }

  @ReactProp(name = "loop")
  public void setLoop(LottieAnimationView view, boolean loop) {
    view.loop(loop);
  }

  @ReactProp(name = "imageAssetsFolder")
  public void setImageAssetsFolder(LottieAnimationView view, String imageAssetsFolder) {
    view.setImageAssetsFolder(imageAssetsFolder);
  }
}

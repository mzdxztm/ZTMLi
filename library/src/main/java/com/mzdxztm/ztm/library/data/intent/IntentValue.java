package com.mzdxztm.ztm.library.data.intent;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public interface IntentValue {

    int getIntentValue(String key, int defaultValue);

    long getIntentValue(String key, long defaultValue);

    float getIntentValue(String key, float defaultValue);

    String getIntentValue(String key, String defaultValue);

    Parcelable getIntentValue(String key, Parcelable defaultValue);

    Serializable getIntentValue(String key, Serializable defaultValue);

    ArrayList getIntentValue(String key, ArrayList defaultValue);

}

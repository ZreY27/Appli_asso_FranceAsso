package iut.dam.sae_app_mobile_france_asso;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    private static final String PREF_NAME = "app_preferences";
    private static final String KEY_INTRO_SEEN = "intro_seen";

    public static boolean isIntroSeen(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return prefs.getBoolean(KEY_INTRO_SEEN, false);
    }

    public static void setIntroSeen(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().putBoolean(KEY_INTRO_SEEN, true).apply();
    }
}
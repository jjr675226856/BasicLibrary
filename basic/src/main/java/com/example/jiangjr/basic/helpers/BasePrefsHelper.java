/**
 * 
 */
package com.example.jiangjr.basic.helpers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author Tony Shen
 *
 * 
 */
public class BasePrefsHelper {
	
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    public BasePrefsHelper(Context context, String prefsName) {
        prefs = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return prefs.getBoolean(key, defValue);
    }

    public float getFloat(String key, float defValue) {
        return prefs.getFloat(key, defValue);
    }

    public int getInt(String key, int defValue) {
        return prefs.getInt(key, defValue);
    }

    public long getLong(String key, long defValue) {
        return prefs.getLong(key, defValue);
    }

    public String getString(String key, String defValue) {
        return prefs.getString(key, defValue);

    }


    public void putBoolean(String key, boolean v) {
        ensureEditorAvailability();
        editor.putBoolean(key, v);
        save();
    }

    public void putFloat(String key, float v) {
        ensureEditorAvailability();
        editor.putFloat(key, v);
        save();
    }

    public void putInt(String key, int v) {
        ensureEditorAvailability();
        editor.putInt(key, v);
        save();
    }

    public void putLong(String key, long v) {
        ensureEditorAvailability();
        editor.putLong(key, v);
        save();
    }

    public void putString(String key, String v) {
        ensureEditorAvailability();
        editor.putString(key, v);
        save();
    }


    public void save() {
        if (editor != null) {
            editor.commit();
        }
    }

    private void ensureEditorAvailability() {
        if (editor == null) {
            editor = prefs.edit();
        }
    }
    
    public void remove(String key) {
    	ensureEditorAvailability();
    	editor.remove(key);
    	save();
    }
    
    public void clear() {
    	ensureEditorAvailability();
    	editor.clear();
    	save();
    }
}

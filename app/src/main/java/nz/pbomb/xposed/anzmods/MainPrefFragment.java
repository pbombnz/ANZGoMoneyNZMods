package nz.pbomb.xposed.anzmods;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceFragment;

import common.PREFERENCES;


public class MainPrefFragment extends PreferenceFragment implements OnPreferenceClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences_main);

        findPreference(PREFERENCES.KEYS.MAIN.ANZ).setOnPreferenceClickListener(this);
        findPreference(PREFERENCES.KEYS.MAIN.SEMBLE).setOnPreferenceClickListener(this);
        findPreference(PREFERENCES.KEYS.MAIN.TVNZ).setOnPreferenceClickListener(this);

        findPreference(PREFERENCES.KEYS.MAIN.DEBUG).setOnPreferenceClickListener(this);
        findPreference(PREFERENCES.KEYS.MAIN.HELP).setOnPreferenceClickListener(this);
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        String prefKey = preference.getKey();
        Intent intent = null;

        if(prefKey.equals(PREFERENCES.KEYS.MAIN.ANZ)) {
            intent = new Intent(getActivity().getApplicationContext(), PrefActivity.class);
            intent.putExtra("id", R.xml.preferences_anz);
            intent.putExtra("title", "ANZ GoMoney NZ Tweaks");
            intent.putExtra("preference", preference.getKey());
        } else if(prefKey.equals(PREFERENCES.KEYS.MAIN.SEMBLE)) {
            intent = new Intent(getActivity().getApplicationContext(), PrefActivity.class);
            intent.putExtra("id", R.xml.preferences_semble);
            intent.putExtra("title", "Semble Tweaks");
            intent.putExtra("preference", preference.getKey());
        } else if(prefKey.equals(PREFERENCES.KEYS.MAIN.TVNZ)) {
            intent = new Intent(getActivity().getApplicationContext(), PrefActivity.class);
            intent.putExtra("id", R.xml.preferences_tvnz);
            intent.putExtra("title", "TVNZ OnDemand Tweaks");
            intent.putExtra("preference", preference.getKey());
        } else if(prefKey.equals(PREFERENCES.KEYS.MAIN.DEBUG)) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
            if(checkBoxPreference.isChecked()) {
                getActivity().setTitle(getResources().getString(R.string.app_name) + " (Debug Mode)");
            } else {
                getActivity().setTitle(getResources().getString(R.string.app_name));
            }

            SharedPreferences sharedPref = getActivity().getApplicationContext().getSharedPreferences(PREFERENCES.SHARED_PREFS_FILE_NAME, Context.MODE_WORLD_READABLE);
            SharedPreferences.Editor sharedPrefEditor = sharedPref.edit();
            sharedPrefEditor.putBoolean(PREFERENCES.KEYS.MAIN.DEBUG, checkBoxPreference.isChecked());
            sharedPrefEditor.apply();

            return true;
        }else if(prefKey.equals(PREFERENCES.KEYS.MAIN.HELP)) {
            intent = new Intent(getActivity().getApplicationContext(), HelpActivity.class);
        }
        startActivity(intent);
        return true;
    }
}

package sahil.readytogotravelassignment;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by SAHIL SINGLA on 11-06-2017.
 */

public class PrefernceHandler {
    SharedPreferences preferences;
    SharedPreferences.Editor prefEditor;
    Context context;
    private final String prefName="ReadyToGoPreferences";
    public final String FirstLoginPrefs="FirstTime";
    public PrefernceHandler(Context c)
    {
        context=c;
        preferences=c.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        prefEditor=preferences.edit();
    }
    public void setFirstLogin()
    {
        prefEditor.putBoolean(FirstLoginPrefs,true);
        prefEditor.commit();
    }
    public boolean isFirstLogin()
    {
        return preferences.getBoolean(FirstLoginPrefs,true);
    }
}

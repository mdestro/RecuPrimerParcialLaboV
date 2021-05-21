package com.example.recuprimerparciallabov;

import android.app.Activity;

public class AutoController {
    private Activity _activity;
    private AutoModel auto;

    public Activity get_activity() {
        return _activity;
    }

    public void set_activity(Activity _activity) {
        this._activity = _activity;
    }

    public AutoModel getAuto() {
        return auto;
    }

    public void setAuto(AutoModel auto) {
        this.auto = auto;
    }

    public AutoController(Activity _activity) {
        this._activity = _activity;
    }

    public void Save(){
    //
    }

}

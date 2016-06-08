package br.com.ilhasoft.support.validation.rule;

import android.view.View;

/**
 * Created by john-mac on 5/14/16.
 */
public abstract class Rule<ViewType extends View, ValueType> {

    protected ValueType value;
    protected ViewType view;

    public Rule(ViewType view, ValueType value) {
        this.view = view;
        this.value = value;
    }

    public final boolean validate() {
        boolean valid = isValid(view);
        if(valid) {
            onValidationSucceeded(view);
        } else {
            onValidationFailed(view);
        }
        return valid;
    }

    protected abstract boolean isValid(ViewType view);

    protected void onValidationSucceeded(ViewType view) {}

    protected void onValidationFailed(ViewType view) {}

    public ViewType getView() {
        return view;
    }
}
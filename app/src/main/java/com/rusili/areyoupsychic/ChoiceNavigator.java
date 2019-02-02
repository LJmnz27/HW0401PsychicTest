package com.rusili.areyoupsychic;

import android.support.annotation.NonNull;

public interface ChoiceNavigator {

    void toChoiceFragment(@NonNull String selectedBreed);

    void toResultFragment(boolean guess);
}

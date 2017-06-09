package ggn.home.help.Features.Internal.Base.Contract;

import android.content.Context;

import ggn.home.help.UtilsG_unused.SharedPrefHelper;

/**
 * Android contract for every MVP View
 */
public interface Viewable<T>
{
    SharedPrefHelper getLocalData();

    Context getActivityG();

    /**
     * Every Viewable must be able to access to its attached viewModel
     *
     * @return viewModel
     */
    T getViewModel();


    /**
     * Every Viewable must have a error message system
     */
    void displayError(String message);

    /**
     * Every Viewable must implement one show loading feature
     */
    void showLoading();

    /**
     * Every Viewable must implement one hide loading feature
     */
    void hideLoading();

}

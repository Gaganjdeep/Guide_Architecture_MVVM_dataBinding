package ggn.home.help.Features.Internal.Base;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModel;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.MenuItem;
import android.view.View;

import ggn.home.help.Features.Internal.Base.Contract.Viewable;
import ggn.home.help.UtilsG_unused.SharedPrefHelper;

/**
 * Created by G-Expo on 03 Mar 2017.
 */
public abstract class BaseActivity<T extends ViewModel> extends LifecycleActivity implements Viewable<T>
{
    private T viewModel;

    public void setupToolbar(String title)
    {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        ((TextView) toolbar.findViewById(R.id.toolbar_title)).setText(title);
    }

    @Override
    public T getViewModel()
    {
        if (viewModel == null) {
            viewModel = setViewModel();
        }
        return viewModel;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        subscribeDataAndBind();
        setupToolbar("");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayError(String message)
    {
        if (setParentView() != null) {
            Snackbar.make(setParentView(), message, Snackbar.LENGTH_LONG).show();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showLoading()
    {
        // no-op by default
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hideLoading()
    {
        // no-op by default
    }

    @Override
    public SharedPrefHelper getLocalData()
    {
        return new SharedPrefHelper(getApplicationContext());
    }

    protected abstract int setLayoutId();

    protected View setParentView()
    {
        return findViewById(android.R.id.content);
    }

    /**
     * injectPresenter( @link Presentable);
     * attachView(this);
     */
    protected abstract void subscribeDataAndBind();

    protected abstract T setViewModel();
}

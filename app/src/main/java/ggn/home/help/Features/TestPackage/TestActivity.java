package ggn.home.help.Features.TestPackage;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.view.View;

import ggn.home.help.Features.Internal.Base.BaseActivity;
import ggn.home.help.R;
import ggn.home.help.databinding.ActivityTestBinding;

public class TestActivity extends BaseActivity<TestViewModel> implements TestView
{
    public static <T> void start(Context context, T data)
    {
        Intent starter = new Intent(context, TestActivity.class);
        if (data != null) {
            starter.putExtra("constant here", (Parcelable) (data));
        }
        context.startActivity(starter);

    }

    @Override
    protected int setLayoutId()
    {
        return R.layout.activity_test;
    }

//    @Override
//    protected View setParentView()
//    {
//        return findViewById(R.id.activity_test);
//    }
    ActivityTestBinding viewDataBinding;
    @Override
    protected void subscribeDataAndBind()
    {
        viewDataBinding = DataBindingUtil.setContentView(this, setLayoutId());

        viewDataBinding.saveReview.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                getViewModel().changeValue();
            }
        });

        getViewModel().getLiveData().observe(this, new Observer<TestModel>()
        {
            @Override
            public void onChanged(@Nullable TestModel testModel)
            {
                displayError(testModel.getMessage());
                viewDataBinding.setReview(testModel);
            }
        });
    }

    @Override
    protected TestViewModel setViewModel()
    {
        return ViewModelProviders.of(this).get(TestViewModel.class);
    }

    @Override
    public Context getActivityG()
    {
        return TestActivity.this;
    }


}

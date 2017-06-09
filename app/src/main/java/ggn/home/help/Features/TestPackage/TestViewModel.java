package ggn.home.help.Features.TestPackage;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by G-Expo on 09 Jun 2017.
 */

public class TestViewModel extends ViewModel
{
    MutableLiveData<TestModel> liveData;

    public TestViewModel()
    {
        liveData=new MutableLiveData<>();
        liveData.setValue(new TestModel());
    }

    public LiveData<TestModel> getLiveData()
    {
        return liveData;
    }

    public void changeValue()
    {
        TestModel testModel=liveData.getValue();
        testModel.setMessage("Hiiiii");

        liveData.setValue(testModel);
    }
}

package basic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import util.ListUtils;

/**
 * 基类Activity
 */
public abstract class BasicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //在界面未初始化之前调用
        initWindows();
        if (initArgs(getIntent().getExtras())) {
            int layId = getContentLayoutId();
            setContentView(layId);

            initWidget();
            initData();
        }

    }

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化控件
     */
    protected abstract void initWidget();

    /**
     * 获取布局
     */
    protected abstract int getContentLayoutId();


    protected boolean initArgs(Bundle bundle) {
        return true;
    }

    protected abstract void initWindows();

    @Override
    public boolean onSupportNavigateUp() {
        //当点击界面导航返回时，finish当前界面
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //得到当前Activity下的所有Fragment
        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();
        if (ListUtils.isNotEmpty(fragmentList)) {

        }
    }
}

package com.example.admin.butterknifepractice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.butterknifepractice.utils.ToastUtil;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import butterknife.Unbinder;

public class BAct extends AppCompatActivity {
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvPwd)
    TextView tvPwd;
    @BindView(R.id.etName)
    EditText etName;
    @BindView(R.id.etPwd)
    EditText etPwd;
    @BindView(R.id.btSubmit)
    Button btSubmit;

    @BindString(R.string.name)
    String name;//将strings.xml中的内容绑定到name对象上
    @BindString(R.string.pwd)
    String pwd;//将strings.xml中的内容绑定到pwd对象上

    Unbinder unbinder;
    Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_b);
        mContext = this;
        unbinder = ButterKnife.bind(this);
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    private void initView() {
        tvName.setText(name);
        tvPwd.setText(pwd);
    }

    @OnTextChanged(value = {R.id.etName}, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    public void validName() {
        ToastUtil.showLongToast(mContext, etName.getText().toString());
    }

    @OnTextChanged(value = {R.id.etPwd}, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    public void validPwd() {
        ToastUtil.showLongToast(mContext, etPwd.getText().toString());
    }

    /**
     * 提交的点击事件
     */
    @OnClick(R.id.btSubmit)
    public void onViewClicked() {
        ToastUtil.showLongToast(mContext, "name is " + etName.getText().toString() + ",pwd is " + etPwd.getText().toString());
    }

    public static void launch(Context context) {
        Intent intent = new Intent(context, BAct.class);
        context.startActivity(intent);
    }

}

package es.sources.code.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import code.source.es.sosc.R;

public class LoginOrRegister extends AppCompatActivity {
    private static final int MAX_LENGTH_OF_USER_NAME = 32;
    private static final int MAX_LENGTH_OF_PASSWORD = 16;
    private static final String USER_NAME = "admin@ustc";
    private static final String PASSWORD = "admin";


    private EditText mEtUserName;
    private EditText mEtPassword;
    private Button mBtnLogin;
    private Button mBtnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_register);
        mEtUserName = (EditText)findViewById(R.id.et_user_name);
        mEtPassword = (EditText)findViewById(R.id.et_password);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnReturn =(Button)findViewById(R.id.btn_return);
        setEditText();
        setListener();
    }
    /**
     * @Description ： 为button等组件添加事件监听
     * @author ： zhiman in 2017/10/3 19:14 mail-zhimanma@gmail.com
     */
    private void setListener() {
        //为登录按钮mBtnLogin添加事件监听
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = mEtUserName.getText().toString();
                String password = mEtPassword.getText().toString();
                if(userName.length()<5) {
                    if(userName.length()==0) {
                        mEtUserName.setText("");
                    } else {
                        mEtUserName.setText("");
                        mEtPassword.setText("");
                        mEtUserName.setHint("用户名长度错误,请检查");
                    }
                    mEtUserName.requestFocus();
                }
                else if(password.length()<5) {
                    if(password.length()==0) {
                        mEtPassword.setText("");
                    }else {
                        mEtPassword.setText("");
                        mEtPassword.setHint("密码长度错误,请检查");
                    }
                    mEtPassword.requestFocus();
                }
                else if(checkPassword(password)){
                    mEtPassword.setText("");
                    mEtPassword.setHint("密码须包括大小写字母数字");
                }
                else if(USER_NAME.equals(userName)&&PASSWORD.equals(password)){
                    //密码符合要求则跳转到MainScreen
                    Intent intent = new Intent(LoginOrRegister.this,MainScreen.class);
                    intent.putExtra("flag","LoginSuccess");
                    startActivity(intent);
                }else {
                    mEtUserName.setText("");
                    mEtPassword.setText("");
                    mEtUserName.setHint("邮箱/手机号");
                    mEtPassword.setHint("密码");
                    mEtUserName.requestFocus();
                    Toast.makeText(LoginOrRegister.this,"用户名与密码不匹配，请重新输入",Toast.LENGTH_SHORT).show();
                }
            }
            /**
             * @Description ： 利用正则表达式校验用户名和密码
             * @author ： zhiman in 2017/10/3 20:01 mail-zhimanma@gmail.com
             */
            private boolean checkPassword(String str) {
                String regex = "[A-Z]++[a-z]++[0-9]++";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(str);
                boolean flag = matcher.matches();
                return flag;
            }
        });
    }
    /**
     * @Description ： 设置账户密码的文本框过滤
     * @author ： zhiman in 2017/10/3 11:07 mail-zhimanma@gmail.com
     */
    private void setEditText() {
        //设置用户名最大长度为32位
        mEtUserName.setFilters(new InputFilter[]{new InputFilter.LengthFilter(MAX_LENGTH_OF_USER_NAME)});
        //设置密码最大长度16位
        mEtPassword.setFilters(new InputFilter[]{new InputFilter.LengthFilter(MAX_LENGTH_OF_PASSWORD)});
        //用户名过滤规则
    }
}

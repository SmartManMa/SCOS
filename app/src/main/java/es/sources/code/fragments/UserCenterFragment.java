package es.sources.code.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import code.source.es.sosc.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserCenterFragment extends Fragment {
    private static final int MAX_LENGTH_OF_USER_NAME = 64;
    private static final int MAX_LENGTH_OF_PASSWORD = 32;
    private static final String USER_NAME = "admin@ustc";
    private static final String PASSWORD = "admin";


    private EditText mEtUserName;
    private EditText mEtPassword;
    private Button mBtnLogin;
    private Button mBtnReturn;
    private View mView;

    public UserCenterFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_user_center, container, false);
        mEtUserName = (EditText) mView.findViewById(R.id.et_user_name);
        mEtPassword = (EditText) mView.findViewById(R.id.et_password);
        mBtnLogin = (Button) mView.findViewById(R.id.btn_login);
        mBtnReturn = (Button) mView.findViewById(R.id.btn_return);
        setEditText();
        setListener();
        return mView;
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
                    mEtUserName.setText("");
                    mEtPassword.setText("");
                    mEtUserName.setHint("用户名长度错误,请检查");
                    mEtUserName.requestFocus();
                }
                else if(password.length()<5) {
                    mEtPassword.setText("");
                    mEtPassword.setHint("密码长度错误,请检查");
                    mEtPassword.requestFocus();
                }
                else if(!checkPassword(userName)){
                    mEtUserName.setText("");
                    mEtUserName.setHint("用户名必须包括且只包括大小写字母数字");
                }
                else if(USER_NAME.equals(userName)&&PASSWORD.equals(password)){

                }else {
                    mEtUserName.setText("");
                    mEtPassword.setText("");
                    mEtUserName.setHint("邮箱/手机号");
                    mEtPassword.setHint("密码");
                    mEtUserName.requestFocus();
                    Toast.makeText(getActivity(),"用户名与密码不匹配，请重新输入",Toast.LENGTH_SHORT).show();
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
                //
                // Toast.makeText(getActivity(),"请重新输入-"+flag,Toast.LENGTH_SHORT).show();
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
        mEtUserName.setFilters(new InputFilter[]{new InputFilter.LengthFilter(32)});
        //设置密码最大长度16位
        mEtPassword.setFilters(new InputFilter[]{new InputFilter.LengthFilter(16)});
        //用户名过滤规则
//        InputFilter filter=new InputFilter() {
//            @Override
//            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
//                String speChat = " [ `~!#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？] ";
//                //String speChat = "[ `~!#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
//                Pattern pattern = Pattern.compile(speChat);
//                Matcher matcher = pattern.matcher(source.toString());
//                if(matcher.find())
//                    return "";
//                else
//                    return null;
//            }
//        };

    }

}

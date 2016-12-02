package innovation.taku.com.inovationapp.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.BoolRes;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import innovation.taku.com.inovationapp.R;

/**
 * Created by TAKU on 2016/12/02.
 */
public class PostUserActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.back)
    Button mBack;

    @BindView(R.id.next)
    Button mNext;

    @BindView(R.id.input_layout_name)
    TextInputLayout mLayoutName;

    @BindView(R.id.edit_name)
    EditText mEditName;

    @BindView(R.id.input_layout_address)
    TextInputLayout mLayoutAddress;

    @BindView(R.id.edit_address)
    EditText mEditAddress;

    @BindView(R.id.input_layout_phone_number)
    TextInputLayout mLayoutPhone;

    @BindView(R.id.edit_phone_number)
    EditText mEditPhone;

    @BindView(R.id.input_layout_mail)
    TextInputLayout mLayoutMail;

    @BindView(R.id.edit_mail)
    EditText mEditMail;

    @BindView(R.id.input_layout_other)
    TextInputLayout mLayoutOther;

    @BindView(R.id.edit_other)
    EditText mEditOther;

    private boolean errorName = true;
    private boolean errorAddress = true;
    private boolean errorPhone = true;
    private boolean errorMail = true;
    private boolean errorOther = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_user);
        ButterKnife.bind(this);
        mBack.setOnClickListener(this);
        mNext.setOnClickListener(this);
        mEditName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(textView.getText().toString().trim().length() == 0){
                    errorName = true;
                }
                else {
                    errorName = false;
                }
                setErrorMessage(mLayoutName, (String)getText(R.string.post_error_name), textView.getText().toString().trim().length());
                return false;
            }
        });
        mEditAddress.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(textView.getText().toString().trim().length() == 0){
                    errorAddress = true;
                }
                else {
                    errorAddress = false;
                }
                setErrorMessage(mLayoutAddress, (String)getText(R.string.post_error_address), textView.getText().toString().trim().length());
                return false;
            }
        });
        mEditPhone.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(textView.getText().toString().trim().length() == 0){
                    errorPhone = true;
                }
                else {
                    errorPhone = false;
                }
                setErrorMessage(mLayoutPhone, (String)getText(R.string.post_error_phone), textView.getText().toString().trim().length());
                return false;
            }
        });
        mEditMail.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(textView.getText().toString().trim().length() == 0){
                    errorMail = true;
                }
                else {
                    errorMail = false;
                }
                setErrorMessage(mLayoutMail, (String)getText(R.string.post_error_mail), textView.getText().toString().trim().length());
                return false;
            }
        });
    }

    public void setErrorMessage(TextInputLayout textInputLayout, String errorMessage, int count) {
        if(count == 0) {
            textInputLayout.setError(errorMessage);
        }
        else {
            textInputLayout.setErrorEnabled(false);
        }
    }

    private void alertDialog(String title, String message, final boolean returnActivity) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(returnActivity){
                            Intent intent = new Intent(PostUserActivity.this, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);
                        }
                        else {
                            setErrorMessage(mLayoutName, (String)getText(R.string.post_error_name), mEditName.getText().toString().trim().length());
                            setErrorMessage(mLayoutAddress, (String)getText(R.string.post_error_address), mEditAddress.getText().toString().trim().length());
                            setErrorMessage(mLayoutPhone, (String)getText(R.string.post_error_phone), mEditPhone.getText().toString().trim().length());
                            setErrorMessage(mLayoutMail, (String)getText(R.string.post_error_mail), mEditMail.getText().toString().trim().length());
                        }
                    }
                })
                .show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.back:
                finish();
                break;

            case R.id.next:
                if(errorName || errorAddress || errorPhone || errorMail){
                    alertDialog((String) getText(R.string.dialog_error_title), (String) getText(R.string.dialog_error_message), false);
                }
                else {
                    alertDialog("", (String) getText(R.string.dialog_complete), true);
                }
                break;

            default:
                break;
        }
    }
}

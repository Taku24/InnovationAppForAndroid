package innovation.taku.com.inovationapp.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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
 * Created by TAKU on 2016/11/30.
 */
public class WriteCompanyActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.create_job_content)
    Button mNext;

    @BindView(R.id.back)
    Button mBack;

    @BindView(R.id.input_layout_company_name)
    TextInputLayout mCompanyLayout;

    @BindView(R.id.edit_company_name)
    EditText mEditCompany;

    @BindView(R.id.input_layout_people)
    TextInputLayout mPeopleLayout;

    @BindView(R.id.edit_people)
    EditText mEditPeople;

    @BindView(R.id.input_layout_detail_job)
    TextInputLayout mDetailJobLayout;

    @BindView(R.id.edit_detail_job)
    EditText mEditDetailJob;

    @BindView(R.id.input_layout_area_name)
    TextInputLayout mAreaLayout;

    @BindView(R.id.edit_area_name)
    EditText mEditArea;

    @BindView(R.id.input_layout_phone_number)
    TextInputLayout mPhoneLayout;

    @BindView(R.id.edit_phone_number)
    EditText mEditPhone;

    @BindView(R.id.input_layout_mail)
    TextInputLayout mMailLayout;

    @BindView(R.id.edit_mail)
    EditText mEditMail;

    private boolean errorCompany = true;
    private boolean errorPeople = true;
    private boolean errorDetail = true;
    private boolean errorArea = true;
    private boolean errorPhone = true;
    private boolean errorMail = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_company);
        ButterKnife.bind(this);
        mBack.setOnClickListener(this);
        mNext.setOnClickListener(this);
        mEditCompany.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (textView.getText().toString().trim().length() == 0) {
                    errorCompany = true;
                } else {
                    errorCompany = false;
                }
                setErrorMessage(mCompanyLayout, (String) getText(R.string.error_company), textView.getText().toString().trim().length());
                return false;
            }
        });
        mEditPeople.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (textView.getText().toString().trim().length() == 0) {
                    errorPeople = true;
                } else {
                    errorPeople = false;
                }
                setErrorMessage(mPeopleLayout, (String) getText(R.string.error_detail), textView.getText().toString().trim().length());
                return false;
            }
        });
        mEditDetailJob.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (textView.getText().toString().trim().length() == 0) {
                    errorDetail = true;
                } else {
                    errorDetail = false;
                }
                setErrorMessage(mDetailJobLayout, (String) getText(R.string.error_people), textView.getText().toString().trim().length());
                return false;
            }
        });
        mEditArea.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (textView.getText().toString().trim().length() == 0) {
                    errorArea = true;
                } else {
                    errorArea = false;
                }
                setErrorMessage(mAreaLayout, (String) getText(R.string.error_area), textView.getText().toString().trim().length());
                return false;
            }
        });
        mEditPhone.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (textView.getText().toString().trim().length() == 0) {
                    errorPhone = true;
                } else {
                    errorPhone = false;
                }
                setErrorMessage(mPhoneLayout, (String) getText(R.string.error_phone), textView.getText().toString().trim().length());
                return false;
            }
        });
        mEditMail.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (textView.getText().toString().trim().length() == 0) {
                    errorMail = true;
                } else {
                    errorMail = false;
                }
                setErrorMessage(mMailLayout, (String) getText(R.string.error_mail), textView.getText().toString().trim().length());
                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;

            case R.id.create_job_content:
                if (errorCompany || errorPeople || errorArea || errorPhone || errorMail) {
                    alertDialog((String) getText(R.string.dialog_error_title), (String) getText(R.string.dialog_error_message), false);
                } else {
                    alertDialog("", (String) getText(R.string.dialog_complete), true);
                }
                break;

            default:
                break;
        }
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
                            Intent intent = new Intent(WriteCompanyActivity.this, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);
                        }
                        else {
                            setErrorMessage(mCompanyLayout, (String) getText(R.string.error_company), mEditCompany.getText().toString().trim().length());
                            setErrorMessage(mPeopleLayout, (String) getText(R.string.error_people), mEditPeople.getText().toString().trim().length());
                            setErrorMessage(mDetailJobLayout, (String) getText(R.string.error_detail), mEditDetailJob.getText().toString().trim().length());
                            setErrorMessage(mAreaLayout, (String) getText(R.string.error_area), mEditArea.getText().toString().trim().length());
                            setErrorMessage(mPhoneLayout, (String) getText(R.string.error_phone), mEditPeople.getText().toString().trim().length());
                            setErrorMessage(mMailLayout, (String) getText(R.string.error_mail), mEditMail.getText().toString().trim().length());
                        }
                    }
                })
                .show();
    }

}

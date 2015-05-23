package com.passit.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.passit.R;
import com.passit.ui.activity.MainActivity;
import com.passit.util.Util;


/**
 * To show the Login screen for the Application.
 */
public class LoginFragment extends BaseFragment implements View.OnClickListener {

    private EditText mUserNameET;

    private EditText mPasswordET;

    private Button mSubmitBtn;

    public LoginFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        mUserNameET = (EditText) view.findViewById(R.id.user_name);
        mPasswordET = (EditText) view.findViewById(R.id.password);

        view.findViewById(R.id.submit).setOnClickListener(LoginFragment.this);

        return view;
    }

    @Override
    public void onClick(View v) {
        final int id = v.getId();

        if (id == R.id.submit) {
            if (isValidInputs()) {
                goToMainPage();
            }

//            goToMainPage();
        }
    }

    /**
     * Move to Main screen after success full login.
     */
    private void goToMainPage() {
        Intent intent = new Intent(getActivity(), MainActivity.class);

        startActivity(intent);

        getActivity().finish();
    }

    /**
     * To check whether all the given value is valid or not.
     *
     * @return True -> valid inputs, false -> if not a valid inputs
     */
    private boolean isValidInputs() {

        final String mobileNuber = mUserNameET.getText().toString();
        final String password = mPasswordET.getText().toString();

        // Should have mobile number and should be valid mobile number.
        if (TextUtils.isEmpty(mobileNuber)) {
            mUserNameET.setError(Util.getString(R.string.validate_enter_mobile_number));

            return false;
        } else {
            final int length = mobileNuber.length();

            // Mobile number should not be less than 6 character and not more than 13 characters.
            if (length < 7 || length > 13) {
                mUserNameET.setError(Util.getString(R.string.validate_enter_valid_mobile_number));

                return false;
            }
        }

        // Should enter the password
        if (TextUtils.isEmpty(mobileNuber)) {
            mPasswordET.setError(Util.getString(R.string.validate_enter_password));

            return false;
        }

        // Clean all the error messages if all the fields are valid.
        mUserNameET.setError(null);
        mPasswordET.setError(null);

        return true;
    }


}

package com.example.movieme.Ui.SignUp;

import android.app.Application;
import android.util.Log;
import android.util.Patterns;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.movieme.Base.BaseViewModel;
import com.example.movieme.R;

import java.util.regex.Pattern;

public class ViewModelSignUp extends BaseViewModel {

//    private static final Pattern PASSWORD_PATTERN= Pattern.compile("(?=\\\\S+$)"+".{8,20}");
    private MutableLiveData<Boolean> signUpValidationMLD = new MutableLiveData<>();
    private MutableLiveData<Boolean> progressBarMLD = new MutableLiveData<>();
    private MutableLiveData<String> massageMLD = new MutableLiveData<>();
    private Boolean progressBar ;
    private String email,password;

   

    public ViewModelSignUp(@NonNull Application application) {
        super(application);
    }


    private Boolean emailAndPasswordValidation(){
        if (getEmail().isEmpty()){
            massageMLD.postValue(context.getString(R.string.you_can_not_enter_empty_value));
            return false;
        }
        if (getPassword().isEmpty()){
            massageMLD.postValue(context.getString(R.string.you_can_not_enter_empty_value));
            return false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()) {
            massageMLD.postValue(context.getString(R.string.the_email_not_matching));
            return false;
        }
       if (getPassword().length() < 8 || getPassword().length() >20){
           massageMLD.postValue(context.getString(R.string.password_must_be_less_than));
           return false;
       }
       massageMLD.postValue("");

        return true;
    }


    private String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void getValid(){
        if (emailAndPasswordValidation()){
            signUpValidationMLD.postValue(true);
        }else {
            signUpValidationMLD.postValue(false);
        }
    }

    public MutableLiveData<Boolean> getEmailAndPasswordValidationMLD() {
        return signUpValidationMLD;
    }

    public MutableLiveData<String> getMassageMLD() {
        return massageMLD;
    }
}

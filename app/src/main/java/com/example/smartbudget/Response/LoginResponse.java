package com.example.smartbudget.Response;

public class LoginResponse {
    private boolean _success;
    private String _message;

    public LoginResponse(boolean success, String message){
        _success = success;
        _message = message;
    }

    public boolean getSuccess(){
        return _success;
    }

    public String getMessage(){
        return _message;
    }
}

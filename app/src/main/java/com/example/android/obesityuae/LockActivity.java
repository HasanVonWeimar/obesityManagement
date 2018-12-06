package com.example.android.obesityuae;

import android.app.Dialog;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.auth0.android.Auth0;
import com.auth0.android.authentication.AuthenticationException;
import com.auth0.android.lock.AuthenticationCallback;
import com.auth0.android.lock.LockCallback;
import com.auth0.android.lock.PasswordlessLock;
import com.auth0.android.lock.utils.LockException;
import com.auth0.android.provider.AuthCallback;
import com.auth0.android.provider.WebAuthProvider;
import com.auth0.android.result.Credentials;

import com.auth0.android.lock.Lock;

public class LockActivity extends AppCompatActivity {

    // app/src/main/java/com/auth0/samples/MainActivity.java
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        login();
    }
    private void login() {
        Auth0 auth0 = new Auth0("kyX9rr8wHi9KPcLHsRVmW0Y9sR1mVN2E", "obesitymnguae.eu.auth0.com");

        WebAuthProvider.init(auth0)
                //.withScheme("demo")
                .withAudience(String.format("https://%s/userinfo", getString(R.string.com_auth0_domain)))
                .start(LockActivity.this, new AuthCallback() {
                    @Override
                    public void onFailure(@NonNull Dialog dialog) {
                        // Show error Dialog to user
                    }

                    @Override
                    public void onFailure(AuthenticationException exception) {
                        // Show error to user
                    }

                    @Override
                    public void onSuccess(@NonNull Credentials credentials) {
                        // Store credentials
                        // Navigate to your main activity
                    }
                });
    }
}

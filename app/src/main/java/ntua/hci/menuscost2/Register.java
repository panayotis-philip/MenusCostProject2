package ntua.hci.menuscost2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText edtEmail, edtPass, edtPass2;
    Button btnRegister;
    TextView txtLogin;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtEmail=findViewById(R.id.edtEmail);
        edtPass=findViewById(R.id.edtPassword);
        edtPass2=findViewById(R.id.edtPassword2);
        btnRegister=findViewById(R.id.btnRegister);
        txtLogin=findViewById(R.id.txtLogin);

        progressBar=findViewById(R.id.progressBar);

        firebaseAuth=FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()!= null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));
                finish();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString().trim();
                String password1 = edtPass.getText().toString().trim();
                String password2 = edtPass2.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    edtEmail.setError("Email is required");
                    return;
                }

                if(TextUtils.isEmpty(password1)){
                    edtPass.setError("Password is required");
                    return;
                }

                if(password1.length()<6){
                    edtPass.setError("Password must be >=  characters");
                    return;
                }

                if(!password1.equals(password2)){
                    edtPass2.setError("Passwords must be the same");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);



                firebaseAuth.createUserWithEmailAndPassword(email,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),HomePage.class));
                                finish();
                            }
                            else{
                                Toast.makeText(Register.this, "Error ! "+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                            }
                    }
                });
            }
        });

    }
}
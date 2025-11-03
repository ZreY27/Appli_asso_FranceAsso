package iut.dam.sae_app_mobile_france_asso;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConnexionActivity extends AppCompatActivity {
    private static final String TAG = "EmailPassword";

    private FirebaseAuth mAuth;
    private boolean fromChoixDonation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_connexion);
        mAuth = FirebaseAuth.getInstance();
        fromChoixDonation = getIntent().getBooleanExtra("fromChoixDonation",false);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // [START on_start_check_user]
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }

    private void signIn(String email, String password) {
        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                Toast.makeText(ConnexionActivity.this, "Identifiants invalides.", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(ConnexionActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
        // [END sign_in_with_email]
    }

    private void sendEmailVerification() {
        // Send verification email
        // [START send_email_verification]
        final FirebaseUser user = mAuth.getCurrentUser();
        user.sendEmailVerification()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // Email sent
                    }
                });
        // [END send_email_verification]
    }

    private void reload() { }

    private void updateUI(FirebaseUser user) {
        Toast.makeText(this, "Connexion réussie", Toast.LENGTH_SHORT).show();
        if(fromChoixDonation){
            Intent intent = new Intent(ConnexionActivity.this, ChoixDonation.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        }
        else{
            Intent intentMain = new Intent(ConnexionActivity.this, MainActivity.class);
            startActivity(intentMain);
        }

    }
    public void clickLogin(View view) {
        EditText etMail = findViewById(R.id.etEmail);
        EditText etPassword = findViewById(R.id.etPassword);
        String email = etMail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Tous les champs ne sont pas remplis", Toast.LENGTH_SHORT).show();
        }
        else{
            signIn(email, password);
        }
    }


    public void clickRegister(View view) {
        Intent intent = new Intent(this, InscriptionActivity.class);
        startActivity(intent);
    }

    public void clickBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
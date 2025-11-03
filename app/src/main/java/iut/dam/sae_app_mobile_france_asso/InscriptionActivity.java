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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class InscriptionActivity extends AppCompatActivity {
    private static final String TAG = "EmailPassword";

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_inscription);
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
    // [END on_start_check_user]

    private void createAccount(String email, String password, String name, String firstname) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Utilisateur créé avec succès
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user != null) {
                                // Récupération de l'UID
                                String userId = user.getUid();
                                saveUserData(userId, name, firstname, email);
                            }
                            updateUI(user);
                        } else {
                            // Échec de l'inscription
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                Toast.makeText(InscriptionActivity.this, "Cet email est déjà enregistré !", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(InscriptionActivity.this, "Échec de l'inscription.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }

    private void saveUserData(String userId, String name, String firstname, String email) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // Création d'un objet utilisateur
        Map<String, Object> user = new HashMap<>();
        user.put("name", name);
        user.put("firstname", firstname);
        user.put("email", email);
        user.put("isAdmin", false); // Par défaut, l'utilisateur n'est pas admin
        user.put("idAsso", null);

        // Sauvegarde des données dans Firestore
        db.collection("users").document(userId)
                .set(user)
                .addOnSuccessListener(aVoid -> Log.d("Firestore", "Utilisateur ajouté avec succès"))
                .addOnFailureListener(e -> Log.w("Firestore", "Erreur lors de l'ajout de l'utilisateur", e));
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
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(InscriptionActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
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
        Intent intent = new Intent(this, ConnexionActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Inscription réussie", Toast.LENGTH_SHORT).show();
    }

    public void clickRegister(View view) {
        EditText etNom = findViewById(R.id.etNom);
        String name = etNom.getText().toString().trim();
        EditText etPrenom = findViewById(R.id.etPrenom);
        String firstname = etPrenom.getText().toString().trim();
        EditText etEmail = findViewById(R.id.etEmail);
        String email = etEmail.getText().toString().trim();
        EditText etPassword = findViewById(R.id.etPassword);
        String password = etPassword.getText().toString().trim();
        if(isValid(name)){
            if(isValid(firstname)){
                if(isValidEmail(email)){
                    if(passwordValid(password)){
                        createAccount(email,password, name, firstname);
                    }
                    else{
                        Toast t = Toast.makeText(this, "mot de passe : minimum 8 caractères, un chiffre et un caractère spécial", Toast.LENGTH_LONG);
                        t.show();
                    }
                }
                else{
                    Toast t = Toast.makeText(this, "Email invalide", Toast.LENGTH_SHORT);
                    t.show();
                }
            }
            else{
                Toast t = Toast.makeText(this, "Prénom invalide", Toast.LENGTH_SHORT);
                t.show();
            }
        }
        else{
            Toast t = Toast.makeText(this, "Nom invalide", Toast.LENGTH_SHORT);
            t.show();
        }
    }
    public boolean isValidEmail(String email) {
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailPattern);
    }

    private boolean passwordValid(String password) {
        String passwordPattern = "^(?=.*[0-9])(?=.*[@#$%^&+=!*])(?=\\S+$).{8,}$";
        return password.matches(passwordPattern);
    }

    private boolean isValid(String text) {
        return text.length()>=2 && text.length()<26 && text.matches("[\\p{L}\\s]+");
    }

    public void clickLogin(View view) {
        Intent intent = new Intent(this, ConnexionActivity.class);
        startActivity(intent);
    }

    public void clickBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
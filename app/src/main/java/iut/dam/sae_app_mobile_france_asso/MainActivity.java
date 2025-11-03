package iut.dam.sae_app_mobile_france_asso;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import iut.dam.sae_app_mobile_france_asso.fragment.AboutFragment;
import iut.dam.sae_app_mobile_france_asso.fragment.AssociationListFragment;
import iut.dam.sae_app_mobile_france_asso.fragment.CategoryFragment;
import iut.dam.sae_app_mobile_france_asso.fragment.LegalFragment;
import iut.dam.sae_app_mobile_france_asso.fragment.SettingsFragment;

public class MainActivity extends BaseActivity implements CategoryFragment.CategoryListener {

    private AssociationListFragment associationListFragment;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CategoryFragment categoryFragment = new CategoryFragment();
        categoryFragment.setCategoryListener(this);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.category_container, categoryFragment)
                .commit();

        associationListFragment = new AssociationListFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, associationListFragment)
                .commit();

        getSupportFragmentManager().addOnBackStackChangedListener(() -> {
            boolean showCategories = getSupportFragmentManager().getBackStackEntryCount() == 0;
            findViewById(R.id.category_container).setVisibility(showCategories ? View.VISIBLE : View.GONE);
        });

        drawerLayout = findViewById(R.id.drawer_layout);
        ImageButton btnMenu = findViewById(R.id.btn_menu);
        btnMenu.setOnClickListener(v -> drawerLayout.openDrawer(findViewById(R.id.navigation_view)));

        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    findViewById(R.id.category_container).setVisibility(View.VISIBLE);
                } else if (id == R.id.nav_settings) {
                    showFragment(new SettingsFragment());
                } else if (id == R.id.nav_about) {
                    showFragment(new AboutFragment());
                } else if (id == R.id.nav_legal) {
                    showFragment(new LegalFragment());
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private void showFragment(Fragment fragment) {
        findViewById(R.id.category_container).setVisibility(View.GONE);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onCategorySelected(String category) {
        if (associationListFragment != null) {
            associationListFragment.setSelectedCategory(category);
        }
    }

    public void clickAccount(View view) {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        Intent intent;
        if (currentUser != null) {
            intent = new Intent(this, ProfileActivity.class);
        } else {
            intent = new Intent(this, ConnexionActivity.class);
        }
        startActivity(intent);
    }
}

package iut.dam.sae_app_mobile_france_asso;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class Association extends BaseActivity implements Serializable {

    private String id;
    private String name;
    private String category;
    private String description;
    private String logoUrl;
    private String intitule;

    public Association() {
    }
    public Association(String id, String category, String description, String logoUrl, String name, String intitule) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.logoUrl = logoUrl;
        this.name = name;
        this.intitule = intitule;
    }

    public String getName(){
        return name;
    }

    public String getLogoUrl(){
        return logoUrl;
    }

    public String getCategory(){
        return category;
    }


    public String getId() {
        return id;
    }

    public String getIntitule(){
        return intitule;
    }
}
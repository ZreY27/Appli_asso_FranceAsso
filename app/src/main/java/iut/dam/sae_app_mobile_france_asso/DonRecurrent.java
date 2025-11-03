package iut.dam.sae_app_mobile_france_asso;

public class DonRecurrent {
    private String associationId;
    private String donateurName;
    private String montant;
    private String periodicite;

    public DonRecurrent(String associationId, String donateurName, String montant, String periodicite){
        this.associationId = associationId;
        this.donateurName = donateurName;
        this.montant = montant;
        this.periodicite = periodicite;
    }

    public String getDonateurName(){
        return donateurName;
    }

    public String getPeriodicite(){
        return periodicite;
    }

    public String getMontant(){
        return montant;
    }
}

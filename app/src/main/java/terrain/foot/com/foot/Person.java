package terrain.foot.com.foot;

public class Person {
    private String name;
    private String date;
    private String heure,etat;
    private String profilephoto;
    private String id;
    private String DateDeDemande;
    private String profilephot;
    public Person(String name, String date, String heure, String key,String etat,String id,String datederese, String profilephot) {
        this.date = date;
        this.name = name;
        this.heure = heure;
        this.profilephoto=key;
        this.etat=etat;
        this.id=id;
        this.DateDeDemande=datederese;
        this.profilephot=profilephot;
    }

    public String getDate() {
        return date;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDateDeDemande() {
        return DateDeDemande;
    }
    public void setDateDeDemande(String datederese) {
        this.DateDeDemande = datederese;
    }
    public String getProfilephoto() {
        return profilephoto;
    }
    public void setProfilephoto(String key) {
        this.profilephoto = key;
    }
    public String getEtat() {
        return etat;
    }
    public void setEtat(String etat) {
        this.etat = etat;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getProfilephot() {
        return profilephot;
    }

    public void setProfilephot(String profilephot) {
        this.profilephot = profilephot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String sex) {
        this.heure= heure;
    }
}

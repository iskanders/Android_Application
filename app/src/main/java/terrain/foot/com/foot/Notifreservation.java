package terrain.foot.com.foot;

import android.app.Notification;

public class Notifreservation {
    String date;
    String heure;
    String etat;
    public Notifreservation(String date, String heure, String etat)
    {
        this.date=date;
        this.heure=heure;
        this.etat=etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDate() {
        return date;
    }

    public String getEtat() {
        return etat;
    }

    public String getHeure() {
        return heure;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

}

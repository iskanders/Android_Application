package terrain.foot.com.foot;

import android.net.Uri;

/**
 * Created by user on 26/11/2017.
 */

public class UserInfos {
    private String Douche,name,Mobile,gouvernorat,Ballon;
    private String Boteille;
    public UserInfos(String Douche, String name, String Boteille,String Mobile,String gouvernorat, String Ballon){

        this.Douche=Douche;
        this.name=name;
        this.Boteille=Boteille;
        this.Mobile=Mobile;
        this.gouvernorat=gouvernorat;
this.Ballon=Ballon;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getBallon() {
        return Ballon;
    }

    public void setBallon(String ballon) {
        Ballon = ballon;
    }

    public String getDouche ()
    {
        return(this.Douche);
    }
    public String getName ()
    {
        return(this.name);
    }


    public String getBoteille(){return (this.Boteille);}

    public void setDouche(String Douche){
        this.Douche=Douche;
    }
    public void setName(String name){
        this.name=name;
    }


    public  void setBoteille(String Boteille){this.Boteille=Boteille;}


}

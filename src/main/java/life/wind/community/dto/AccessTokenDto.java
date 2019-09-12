package life.wind.community.dto;

public class AccessTokenDto {
    private String cient_id;
    private String client_secret;
    private String code ;
    private String redirect_uri ;
    private String state ;

    public String getCient_id() {
        return cient_id;
    }

    public void setCient_id(String lient_id) {
        this.cient_id = lient_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

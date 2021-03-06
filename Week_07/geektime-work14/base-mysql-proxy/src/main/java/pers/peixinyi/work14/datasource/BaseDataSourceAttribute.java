package pers.peixinyi.work14.datasource;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-03-05 13:18
 */
public class BaseDataSourceAttribute {
    private String url;
    private String username;
    private String password;

    public BaseDataSourceAttribute(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public BaseDataSourceAttribute() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

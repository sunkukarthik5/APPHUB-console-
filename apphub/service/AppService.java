package apphub.service;

public interface AppService
{
    void showcategories() throws Exception;
    void showapps(int categoryid) throws Exception;
    void openapp(int appid) throws Exception;

    void searchApp(String keyword) throws Exception;
    void addCategory(String name, String emoji) throws Exception;
    void addApplication(int categoryId, String name, String link, String emoji) throws Exception;
}

package apphub.service;

import apphub.db.DBConnection;
import java.sql.*;
import java.awt.Desktop;
import java.net.URI;

public class AppServiceImpl implements AppService
{
    private Connection con;

    public AppServiceImpl() throws Exception
    {
        con = DBConnection.getConnection();
    }

    @Override
    public void showcategories() throws Exception
    {
        String sql = "SELECT c_id, c_name, c_emoji FROM categories";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            System.out.println(
                rs.getInt("c_id") + ". " +
                rs.getString("c_name") + " " +
                rs.getString("c_emoji")
            );
        }
    }

    @Override
    public void showapps(int categoryId) throws Exception
    {
        String sql = "SELECT a_id, a_name, a_emoji FROM applications WHERE c_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, categoryId);

        ResultSet rs = ps.executeQuery();
        boolean found = false;

        while (rs.next())
        {
            found = true;
            System.out.println(
                rs.getInt("a_id") + ". " +
                rs.getString("a_name") + " " +
                rs.getString("a_emoji")
            );
        }

        if (!found)
            System.out.println("❌ No apps found.");
    }

    @Override
    public void openapp(int appId) throws Exception
    {
        String sql = "SELECT a_link FROM applications WHERE a_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, appId);

        ResultSet rs = ps.executeQuery();

        if (rs.next())
        {
            String link = rs.getString("a_link");
            System.out.println("🌐 Opening: " + link);

            if (Desktop.isDesktopSupported())
                Desktop.getDesktop().browse(new URI(link));
        }
        else
        {
            System.out.println("❌ Invalid App ID");
        }
    }

    @Override
    public void searchApp(String keyword) throws Exception
    {
        String sql = "SELECT a_id, a_name, a_emoji FROM applications WHERE a_name LIKE ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, "%" + keyword + "%");

        ResultSet rs = ps.executeQuery();
        boolean found = false;

        while (rs.next())
        {
            found = true;
            System.out.println(
                rs.getInt("a_id") + ". " +
                rs.getString("a_name") + " " +
                rs.getString("a_emoji")
            );
        }

        if (!found)
            System.out.println("❌ No matching applications found.");
    }

    @Override
    public void addCategory(String name, String emoji) throws Exception
    {
        String sql = "INSERT INTO categories (c_name, c_emoji) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, emoji);
        ps.executeUpdate();

        System.out.println("✅ Category added successfully!");
    }

    @Override
    public void addApplication(int categoryId, String name, String link, String emoji) throws Exception
    {
        String sql = "INSERT INTO applications (a_name, a_link, a_emoji, c_id) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, link);
        ps.setString(3, emoji);
        ps.setInt(4, categoryId);
        ps.executeUpdate();

        System.out.println("✅ Application added successfully!");
    }
}

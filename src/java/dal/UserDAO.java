package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;
import model.Profile;

public class UserDAO extends DBContext {

    public Account login(String email_username, String password) {
        String sql = "select * from account where ((email = ? or username = ?) and password = 'password1') ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email_username);
            st.setString(2, email_username);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account a = new Account();
                a.setAccountId(rs.getInt(1));
                a.setUsername(rs.getString(2));
                a.setEmail(rs.getString(3));
                a.setPassword(rs.getString(4));
                a.setRole(rs.getInt(5));
                a.setProfile(getProfileById(rs.getInt(6)));
                return a;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public Account getAccountById(int id) {
        String sql = "Select * from account where account_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account a = new Account();
                a.setAccountId(rs.getInt(1));
                a.setUsername(rs.getString(2));
                a.setEmail(rs.getString(3));
                a.setPassword(rs.getString(4));
                a.setRole(rs.getInt(5));
                a.setProfile(getProfileById(rs.getInt(6)));
                return a;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public Profile getProfileById(int id) {
        String sql = "Select * from profiles where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Profile p = new Profile();
                p.setId(rs.getInt(1));
                p.setFirstName(rs.getString(2));
                p.setLastName(rs.getString(3));
                p.setBirthdate(rs.getDate(4));
                p.setPhone(rs.getString(5));
                p.setGender(rs.getString(6).charAt(0));
                p.setImg(rs.getString(7));
                p.setYearExp(rs.getInt(8));
                return p;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public Profile getLatestProfile() {
        String sql = "select top 1 * from profiles order by id desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Profile p = new Profile();
                p.setId(rs.getInt(1));
                p.setFirstName(rs.getString(2));
                p.setLastName(rs.getString(3));
                p.setBirthdate(rs.getDate(4));
                p.setPhone(rs.getString(5));
                p.setGender(rs.getString(6).charAt(0));
                p.setImg(rs.getString(7));
                p.setYearExp(rs.getInt(8));
                return p;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public Account getLatestAccount() {
        String sql = "select top 1* from account order by account_id desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account a = new Account();
                a.setAccountId(rs.getInt(1));
                a.setUsername(rs.getString(2));
                a.setEmail(rs.getString(3));
                a.setPassword(rs.getString(4));
                a.setRole(rs.getInt(5));
                a.setProfile(getProfileById(rs.getInt(6)));
                return a;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public boolean insertNewProfile(Profile p) {
        String sql = "INSERT INTO profiles (first_name, last_name, birthdate, phone, gender, img, year_exp)\n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, p.getFirstName());
            st.setString(2, p.getLastName());
            st.setDate(3, p.getBirthdate());
            st.setString(4, p.getPhone());
            st.setString(5, "" + p.getGender());
            st.setString(6, p.getImg());
            st.setInt(7, p.getYearExp());
            int rs = st.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public Account register(String username, String email, String password, int role, Profile profile) {
        if (!insertNewProfile(profile)) {
            return null;
        }
        int profile_id = getLatestProfile().getId();
        String sql = "INSERT INTO account (username, email, password, role,profile_id)\n"
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, email);
            st.setString(3, password);
            st.setInt(4, role);
            st.setInt(5, profile_id);
            int rs = st.executeUpdate();
            if (rs > 0) {
                return getLatestAccount();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        Profile p = new Profile("My", "Dieu", Date.valueOf("2004-05-01"), "0922010136",'F' , "img1.png", 5);
        Account a = dao.register("dieumy", "lpdmy1@gmail.com", "123", 1, p);
        System.out.println(a);

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ots.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ots.test.beans.Technician;
import ots.test.beans.Tickets;
import ots.test.beans.Users;
import ots.test.core.ConnectionManager;

/**
 *
 * @author prasun
 */
public class AdminDao {

    public int registration(String userFullName, String email, String password, int roleId) throws Exception {
        int i = 0;
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO ticketsystem.users\n"
                    + "(userFullName,\n"
                    + "email,\n"
                    + "password,\n"
                    + "roleId)\n"
                    + "VALUES\n"
                    + "(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userFullName);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setInt(4, roleId);

            System.out.println("SQL for insert=" + ps);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public int deleteCsrDetails(String email) throws SQLException, Exception {
        Connection con = ConnectionManager.getConnection();
        int i = 0;
        try {
            String sql = "UPDATE ticketsystem.users\n"
                    + "SET\n"
                    + "statusId = 2\n"
                    + "WHERE  email = ? and roleId=2";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public List<Users> getActiveCsr() throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<Users> csrList = new ArrayList<>();
        try {
            String sql = "SELECT userFullName,email FROM ticketsystem.users where roleId=2 and statusId=1";
            con = ConnectionManager.getConnection();
            System.out.println("Connection is " + con);
            PreparedStatement ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                Users users = new Users();
                users.setUserFullName(rs.getString("userFullName"));
                users.setEmail(rs.getString("email"));

                csrList.add(users);

            }
            return csrList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

//    public int addTechnician(String userFullName, String email, String password, int roleId) throws Exception {
//        int i = 0;
//        Connection con = null;
//        try {
//            con = ConnectionManager.getConnection();
//            String sql = "INSERT INTO ticketsystem.users\n"
//                    + "(userFullName,\n"
//                    + "email,\n"
//                    + "password,\n"
//                    + "roleId)\n"
//                    + "VALUES\n"
//                    + "(?,?,?,?)";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, userFullName);
//            ps.setString(2, email);
//            ps.setString(3, password);
//            roleId = 3;
//            ps.setInt(4, roleId);
//
//            System.out.println("SQL for insert=" + ps);
//            i = ps.executeUpdate();
//            return i;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return i;
//        } finally {
//            if (con != null) {
//                con.close();
//            }
//        }
//    }
    public int deleteTechnicianDetails(String email) throws SQLException, Exception {
        Connection con = ConnectionManager.getConnection();
        int i = 0;
        try {
            String sql = "UPDATE ticketsystem.users\n"
                    + "SET\n"
                    + "statusId = 2\n"
                    + "WHERE  email = ? and roleId=3";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public List<Users> getActiveTech() throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<Users> techList = new ArrayList<>();
        try {
            String sql = "SELECT userFullName,email FROM ticketsystem.users where roleId=3 and statusId=1";
            con = ConnectionManager.getConnection();
            System.out.println("Connection is " + con);
            PreparedStatement ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                Users users = new Users();
                users.setUserFullName(rs.getString("userFullName"));
                users.setEmail(rs.getString("email"));
                techList.add(users);
            }
            return techList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public List<Tickets> getActiveTickets() throws SQLException {
        ResultSet rs = null;
        Connection con = null;
        List<Tickets> ticketsList = new ArrayList<>();
        try {
            String sql = "SELECT tickets.tickteId,\n"
                    + "    tickets.type,\n"
                    + "    tickets.description,\n"
                    + "    tickets.assignedTo,\n"
                    + "    tickets.assignedDate,\n"
                    + "    tickets.ticketStatusId,\n"
                    + "    tickets.solvedDate\n"
                    + "FROM ticketsystem.tickets  where ticketStatusId in(1,2,3)";
            con = ConnectionManager.getConnection();
            System.out.println(sql);
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tickets tickets = new Tickets();
                tickets.setTicketId(rs.getInt("tickteId"));
                tickets.setType(rs.getString("type"));
                tickets.setDescription(rs.getString("description"));
                tickets.setAssignedTo(rs.getInt("assignedTo"));
                tickets.setAssignedDate(rs.getDate("assignedDate"));
                tickets.setTicketStatusId(rs.getInt("ticketStatusId"));
                tickets.setSolvedDate(rs.getDate("solvedDate"));
                ticketsList.add(tickets);
            }
            return ticketsList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public List<Tickets> getClosedTickets() throws SQLException {
        ResultSet rs = null;
        Connection con = null;
        List<Tickets> ticketsList = new ArrayList<>();
        try {
            String sql = "SELECT tickets.tickteId,\n"
                    + "    tickets.type,\n"
                    + "    tickets.description,\n"
                    + "    tickets.assignedTo,\n"
                    + "    tickets.assignedDate,\n"
                    + "    tickets.ticketStatusId,\n"
                    + "    tickets.solvedDate\n"
                    + "FROM ticketsystem.tickets  where ticketStatusId= 4";
            con = ConnectionManager.getConnection();
            System.out.println(sql);
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tickets tickets = new Tickets();
                tickets.setTicketId(rs.getInt("tickteId"));
                tickets.setType(rs.getString("type"));
                tickets.setDescription(rs.getString("description"));
                tickets.setAssignedTo(rs.getInt("assignedTo"));
                tickets.setAssignedDate(rs.getDate("assignedDate"));
                tickets.setTicketStatusId(rs.getInt("ticketStatusId"));
                tickets.setSolvedDate(rs.getDate("solvedDate"));
                ticketsList.add(tickets);
            }
            return ticketsList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public static List gettechnicianNameWithoutAssign() throws SQLException {
        ResultSet rs = null;
        Connection con = null;
        List<Technician> techAssign = new ArrayList<Technician>();
        try {
            con = ConnectionManager.getConnection();
            String sql = "select userFullName , userId , roleId from users where roleId = 3 and userId not in (select techId from technicianmapping)";
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Technician tech = null;
            while (rs.next()) {
                tech = new Technician();
                tech.setUserId(rs.getInt("userId"));
                tech.setUserFullName(rs.getString("userFullName"));
                techAssign.add(tech);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return techAssign;
    }

    public static int saveTechnicianMapping(int techId, String techLevel) {
        ResultSet rs = null;
        Connection con = null;
        int i = 0;
        try {
            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO ticketsystem.technicianmapping\n"
                    + "(techId,\n"
                    + "typeId)\n"
                    + "VALUES\n"
                    + "(?,?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, techId);
            ps.setString(2, techLevel);
            i = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return i;
    }
}

package ru.mai.sample.Function;

import ru.mai.sample.entity.Projects;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDBFunctions implements Functions<Projects> {
    String url = "";
    String sql_query;

    @Override
    public Iterable<Projects> findAll(){
        List<Projects> projects = new ArrayList<Projects>();
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            sql_query  = "select * from Projects";
            ResultSet rs = stmt.executeQuery(sql_query);
            while (rs.next()){
                projects.add(new Projects(rs.getInt("proj_id"), rs.getString("proj_name"), rs.getString("proj_duration"), rs.getString("proj_date_start"), rs.getString("proj_date_end")));
            }
            conn.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return projects;
    }

    @Override
    public void save(Projects entries) {
        if (entries.getProjectId() < 0) {
            insert(entries);
        } else {
            update(entries);
        }
    }

    @Override
    public Projects findByIdNumber(int id) {
        Projects projects;
        try {
            sql_query = "select * from Projects where proj_id = ?";
            Connection conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql_query);
            pstmt.setInt(1, id);
            final ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                projects = new Projects(rs.getInt("proj_id"), rs.getString("proj_name"), rs.getString("proj_duration"), rs.getString("proj_date_start"), rs.getString("proj_date_end"));
            } else {
                projects = null;
            }
            conn.close();
        } catch (SQLException e){
            throw new IllegalStateException(e);
        }
        return projects;
    }

    @Override
    public void delete(Projects entries) {
        Connection conn;
        try {
            conn = DriverManager.getConnection(url);
            sql_query = "delete from Projects where proj_id = ?";
            final PreparedStatement pstmt = conn.prepareStatement(sql_query);
            pstmt.setInt(1, entries.getProjectId());
            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Projects proj){
        try {
            Connection conn = DriverManager.getConnection(url);
            sql_query = "update Projects set proj_name = ?, proj_duration = ?, proj_date_start = ?, proj_date_end = ? where proj_id = ?";
            final PreparedStatement pstmt = conn.prepareStatement(sql_query);
            pstmt.setString(1, proj.getProjectName());
            pstmt.setString(2, proj.getProjectDuration());
            pstmt.setString(1, proj.getProjectDateBegin());
            pstmt.setString(1, proj.getProjectDateComplete());
            pstmt.setInt(1, proj.getProjectId());
            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insert(Projects proj){
        try {
            Connection conn = DriverManager.getConnection(url);
            sql_query = "insert into Projects(proj_name, proj_duration, proj_date_start, proj_date_end) values(?,?,?,?);";
            final PreparedStatement pstmt = conn.prepareStatement(sql_query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, proj.getProjectName());
            pstmt.setString(2, proj.getProjectDuration());
            pstmt.setString(3, proj.getProjectDateBegin());
            pstmt.setString(4, proj.getProjectDateComplete());
            pstmt.executeUpdate();
            try (ResultSet genKeys = pstmt.getGeneratedKeys()) {
                if (genKeys.next()){
                    proj.setProjectId(genKeys.getInt(1));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

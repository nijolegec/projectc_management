package org.example.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.domain.Project;

public class ProjectMapper {

    public Project fromResultSet(ResultSet resultSet) throws SQLException {
        return new Project(
            resultSet.getInt("id"),
            resultSet.getString("pavadinimas")
        );
    }
}

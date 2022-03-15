package org.example.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.domain.DepartmentType;
import org.example.domain.Employee;
import org.example.domain.OccupationTypee;

public class EmployeeMapper {

    public Employee fromResultSet(ResultSet resultSet) throws SQLException {
        return new Employee(
            resultSet.getString("asmenskodas"),
            resultSet.getString("vardas"),
            resultSet.getString("pavarde"),
            resultSet.getDate("dirbanuo").toLocalDate(),
            resultSet.getDate("gimimometai").toLocalDate(),
            toOccupation(resultSet.getString("pareigos")),
            toDepartment(resultSet.getString("skyrius_pavadinimas")),
            resultSet.getInt("projektas_id")
        );
    }

    private DepartmentType toDepartment(String department) {
        if (department == null) {
            return null;
        }

        switch (department) {
        case "Testavimo" -> {
            return DepartmentType.QA;
        }
        case "Java" -> {
            return DepartmentType.JAVA;
        }
        case "C#" -> {
            return DepartmentType.C_SHARP;
        }
        default -> {
            return null;
        }
        }
    }

    private OccupationTypee toOccupation(String occupation) {
        if (occupation == null) {
            return null;
        }

        switch (occupation) {
        case "Testuotojas", "Testuotoja" -> {
            return OccupationTypee.QA;
        }
        case "Programuotojas", "Programuotoja" -> {
            return OccupationTypee.DEVELOPER;
        }
        case "Projektų vadovas", "Projektų vadovė" -> {
            return OccupationTypee.PROJECT_MANAGER;
        }
        default -> {
            return null;
        }
        }
    }

}

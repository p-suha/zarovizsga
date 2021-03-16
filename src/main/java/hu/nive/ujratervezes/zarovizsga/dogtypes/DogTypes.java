package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {

    private DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) {

        List<String> results = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select name from dog_types where country = ? order by name")) {
            stmt.setString(1, country.toUpperCase());
            addDogToList(results, stmt);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not connect", sqle);
        }
        return results;
    }

    private void addDogToList(List<String> results, PreparedStatement statement) throws SQLException {

        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                results.add(resultSet.getString("name").toLowerCase());
            }
        }
    }
}

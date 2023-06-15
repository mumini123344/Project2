package Utils;

import data.UserData;
import io.qameta.allure.Step;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBase {

    UserData userData = new UserData();

    @Step
    public DataBase connection() {
        try (Connection conn = Sql.getConnection()) {
            System.out.printf("Connected to database %s "
                    + "successfully.%n", conn.getCatalog());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return this;
    }

    @Step("Insert info into database")
    public DataBase insertData() {
        String table = "INSERT INTO [users].[dbo].[users](firstname,lastname, phone, email, dateOfBirth, password)VALUES(?,?,?,?,?,?)";

        try {
            Connection conn = Sql.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement(table, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, getFirstName());
            preparedStatement.setString(2, getLastName());
            preparedStatement.setString(3, getPhone());
            preparedStatement.setString(4, getEmail());
            preparedStatement.setDate(5, getDateOfBirth());
            preparedStatement.setString(6, getPassword());

            preparedStatement.executeUpdate();


            return this;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Commit")
    public DataBase commitChanges() throws SQLException {
        Sql.getConnection().commit();
        return this;
    }

    @Step("Fill first name")
    public String getFirstName() {
        return userData.firstName;
    }

    @Step("Fill last name")
    public String getLastName() {
        return userData.lastName;
    }

    @Step("Fill phone number")
    public String getPhone() {
        return userData.phone;
    }

    @Step("Fill email address")
    public String getEmail() {
        return userData.email;
    }

    @Step("Fill date of birth")
    public Date getDateOfBirth() {
        return userData.dateOfBirth;
    }

    @Step("Fill password")
    public String getPassword() {
        return userData.password;
    }
}

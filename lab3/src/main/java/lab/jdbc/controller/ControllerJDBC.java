package lab.jdbc.controller;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import lab.jdbc.entity.Item;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ControllerJDBC {

    private Connection connection;

    public ControllerJDBC(@ConfigProperty(name = "quarkus.datasource.jdbc.url") String url,
                          @ConfigProperty(name = "quarkus.datasource.username") String username,
                          @ConfigProperty(name = "quarkus.datasource.password") String password) {
        try {
            System.out.println(url + username + password);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println("Не удалось подключиться к базе. " + e.getMessage());
        }
    }

    public List<Item> getAllItems() {
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM item");

            List<Item> items = new ArrayList<>();
            while (result.next()) {
                Item item = new Item();

                item.setId(result.getLong("id"));
                item.setName(result.getString("name"));
                item.setRare(result.getString("rare"));
                item.setCost(result.getInt("cost"));
                item.setCount(result.getInt("count"));

                items.add(item);
            }
            return items;
        } catch (Exception e) {
            Log.error("Не удалось получить список всех предметов" + e.getMessage());
        }
        return null;
    }

    public boolean addItem(Item item) {
        try {
            String sql = "INSERT INTO item (name, rare, cost, count) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, item.getRare());
            preparedStatement.setInt(3, item.getCost());
            preparedStatement.setInt(4, item.getCount());

            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            Log.error("Не удалось добавить предмет" + e.getMessage());
            return false;
        }
    }

    public boolean updateItem(Item item) {
        try {
            String sql = "UPDATE item SET name = ?, rare = ?, cost = ?, count = ? WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, item.getRare());
            preparedStatement.setInt(3, item.getCost());
            preparedStatement.setInt(4, item.getCount());
            preparedStatement.setLong(5, item.getId());

            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            Log.error("Не удалось обновить предмет" + e.getMessage());
            return false;
        }
    }

    public boolean deleteItem(Long id) {
        try {
            String sql = "DELETE FROM item WHERE id = " + id;
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            Log.error("Не удалось удалить предмет" + e.getMessage());
            return false;
        }
    }
}

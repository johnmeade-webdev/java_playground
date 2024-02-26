package jdbc;

import java.sql.SQLException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        var allCars = getAllCars();
        for (Car car : allCars) {
            System.out.print(car.make);
            System.out.print(' ');
            System.out.print(car.model);
            System.out.print(' ');
            System.out.print(car.color);
            System.out.print(' ');
            System.out.print(car.year);
            System.out.println();
        }
    }

    public static ArrayList<Car> getAllCars() {
        var cars = new ArrayList<Car>();
        var sql = "SELECT * FROM cars";

        try (var conn = DB.connect(); var stmt = conn.createStatement()) {
            var rs = stmt.executeQuery(sql);
            while (rs.next()) {
                var car = new Car(
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getString("color"),
                        rs.getInt("year")
                );
                cars.add(car);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cars;
    }
}

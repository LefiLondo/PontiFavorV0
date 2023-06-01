package com.example.pontifavorv0;
import java.sql.*;

public class Mysql {
    void consulta() {
        try {
            String URLSql = "jdbc:mysql://localhost:3306/pontifavor";
            String Username = "root";
            String Password = "root";
            String select = "select *";
            String from = "from Producto";
            String where = "";
            String columna = "";
            Connection connection = DriverManager.getConnection(URLSql, Username, Password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select + from + where);

            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean UsuarioEncontrado(String user, String password) {
        boolean encontrado = false;
        try {

            String URLSql = "jdbc:mysql://localhost:3306/pontifavor";
            String Username = "root";
            String Password = "root";
            String select = "select *";
            String from = "from usuarios";
            String where = "";
            String columna = "";
            Connection connection = DriverManager.getConnection(URLSql, Username, Password);
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery(select + from + where);
            while (resultado.next()) {
                System.out.println(resultado.getString("usuario") + " " + resultado.getString("contrasena"));
                if (resultado.getString("usuario").equals(user) && resultado.getString("contrasena").equals(password)) {
                    System.out.println("encontrado");
                    encontrado = true;
                }
            }
            connection.close();
            statement.close();
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return encontrado;
    }


    public void registrarse(String Usu, String Contra) {
        String URLSql = "jdbc:mysql://localhost:3306/pontifavor";
        String username = "root";
        String password = "root";

        String insertQuery = "INSERT INTO usuarios (usuario, contrasena) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(URLSql, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            // Establecer los valores de los parámetros
            preparedStatement.setString(1, Usu);
            preparedStatement.setString(2, Contra);

            // Ejecutar la consulta de inserción
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Datos insertados correctamente.");

            } else {
                System.out.println("No se pudo insertar los datos.");
            }
            connection.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}









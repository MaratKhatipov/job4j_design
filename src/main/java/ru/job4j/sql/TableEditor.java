package ru.job4j.sql;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private final Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }


    /**
     * Инициализация соединения
     */
    private void initConnection() throws SQLException, ClassNotFoundException {
        Class.forName(properties.getProperty("driver"));
        connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("login"),
                properties.getProperty("password")
        );
    }

    private void execute(String sql, String tableName) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println(getTableSpace(connection, tableName));
        }
    }

    private void execute(String sql) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    /**
     * createTable() – создает пустую таблицу без столбцов с указанным именем;
     * @param tableName - название таблицы
     */
    public void createTable(String tableName) throws Exception {
        String createTable = "create table if not exists %s (id serial primary key, name text)";
        execute(String.format(createTable, tableName), tableName);
    }

    /**
     * dropTable() – удаляет таблицу по указанному имени;
     * @param tableName  - название таблицы
     */
    public void dropTable(String tableName) throws Exception {
        String dropTable = "drop table if exists %s";
        execute(String.format(dropTable, tableName));
        System.out.printf("Table %s deleted%n", tableName);
    }

    /**
     * addColumn() – добавляет столбец в таблицу;
     * @param tableName  - название таблицы
     * @param columnName - имя столбца
     * @param type - тип добавляемого значения

     */
    public void addColumn(String tableName, String columnName, String type) throws Exception {
        String addColumn = "alter table %s add column %s %s";
        execute(String.format(addColumn, tableName, columnName, type), tableName);
    }

    /**
     * dropColumn() – удаляет столбец из таблицы;
     * @param tableName - название таблицы
     * @param columnName - имя столбца
     */
    public void dropColumn(String tableName, String columnName) throws Exception {
        String dropColumn = "alter table %s drop column %s";
        execute(String.format(dropColumn, tableName, columnName), tableName);
    }

    /**
     * renameColumn() – переименовывает столбец.
     * @param tableName - название таблицы
     * @param columnName - имя столбца
     * @param newColumnName - новое название столбца
     */
    public void renameColumn(String tableName,
                             String columnName,
                             String newColumnName) throws Exception {
        String renameColumn = "alter table %s rename column %s to %s";
        execute(String.format(renameColumn, tableName, columnName, newColumnName), tableName);
    }

    public static String getTableSpace(Connection connection, String tableName) throws SQLException {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statment = connection.createStatement()) {
            var selection = statment.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
            return buffer.toString();
        }
    }

    public static void main(String[] args) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("./src/main/resources/app.properties")) {
            properties.load(fis);
            TableEditor tableEditor = new TableEditor(properties);
            tableEditor.createTable("for_example");
            tableEditor.addColumn("for_example", "money", "int");
            tableEditor.renameColumn("for_example", "money", "ruble");
            tableEditor.dropColumn("for_example", "ruble");
            tableEditor.dropTable("for_example");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}

package database.dbutils;

//import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import database.models.Author;
import database.models.Book;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {


    public static final Logger LOGGER = LoggerFactory.getLogger(DbManager.class);

    private static final String databaseUrl2H2 = "jdbc:h2:./database";
//    String SQLITE = "jdbc:sqlite:database.db";
//    DriverManager.getConnection("jdbc:sqlite:database.db");

    private static final String USER = "admin";

    private static final String PASS = "admin";

    private static Connection connectionSource;

    public DbManager () {
    }

    public static void initDatabase() throws SQLException, IOException {
            createConnectionSource();
            dropTable();
            createTable();
            closeConnectionSource();
        }

        static void  createConnectionSource() throws SQLException {

            connectionSource = DriverManager.getConnection("\"jdbc:h2:./database");

        }

        public static ConnectionSource getConnectionSource() throws SQLException {
            if (connectionSource ==null) {
                createConnectionSource();
            }
            return (ConnectionSource) connectionSource;
        }

        public static void closeConnectionSource() throws IOException, SQLException {
            if (connectionSource!=null) {
                connectionSource.close();
            }
        }

        private static void createTable() throws SQLException {
            TableUtils.createTableIfNotExists((ConnectionSource) connectionSource, Author.class);
            TableUtils.createTableIfNotExists((ConnectionSource) connectionSource, Book.class);
        }

        private static void dropTable() throws SQLException {
            TableUtils.dropTable((ConnectionSource) connectionSource, Author.class, true);
        }
    }




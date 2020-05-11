import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionPool<T> extends ObjectPoolClass<T> {
    private String dsn, usr, pwd;

    public JDBCConnectionPool(String driver, String dsn, String usr, String pwd) {
        super();
        try {
            Class.forName(driver).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.dsn = dsn;
        this.usr = usr;
        this.pwd = pwd;
    }

    @Override
    protected T create() {
        try {
            return (T) DriverManager.getConnection(dsn, usr, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
            return (null);
        }
    }

    @Override
    public boolean validate(T o) {
        return false;
    }

    @Override
    public void expire(T o) {

    }

}

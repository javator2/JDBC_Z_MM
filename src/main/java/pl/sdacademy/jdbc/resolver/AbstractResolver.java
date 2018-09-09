package pl.sdacademy.jdbc.resolver;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public abstract class AbstractResolver<T> {

    public abstract T get(int id);
    public abstract List<T> get();
    public abstract boolean delete(int id) throws SQLException;
    public abstract boolean insert(Map<String, String> parms) throws SQLException;
    public abstract boolean update(int id, Map<String, String> parms) throws SQLException;

}

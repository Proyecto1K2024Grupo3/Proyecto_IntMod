package App.db;

import App.model.Producto;
import App.model.Videojuego;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VideojuegoDAO {

    private static VideojuegoDAO instance;
    private Connection connection;
    private ProductoDAO productoDAO;

    private static final String INSERT_QUERY = "INSERT INTO videojuego (cod_producto, f_lanzamiento) VALUES (?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM videojuego";
    private static final String SELECT_BY_COD_QUERY = "SELECT * FROM videojuego WHERE cod_producto = ?";
    private static final String UPDATE_QUERY = "UPDATE videojuego SET f_lanzamiento = ? WHERE cod_producto = ?";
    private static final String DELETE_QUERY = "DELETE FROM videojuego WHERE cod_producto = ?";
    private static final String TOTAL_VIDEOGAMES_QUERY = "SELECT COUNT(*) FROM videojuego";

    private VideojuegoDAO() {
        this.connection = DBConnection.getConnection();
        this.productoDAO = ProductoDAO.getInstance();
    }

    public static synchronized VideojuegoDAO getInstance() {
        if (instance == null) {
            instance = new VideojuegoDAO();
        }
        return instance;
    }

    public void insertVideojuego(Videojuego videojuego) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setInt(1, videojuego.getCod_producto());
            statement.setDate(2, java.sql.Date.valueOf(videojuego.getF_lanzamiento()));
            statement.executeUpdate();
        }
    }

    public List<Videojuego> getAllVideojuegos() throws SQLException {
        List<Videojuego> videojuegos = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                videojuegos.add(resultSetToVideojuego(resultSet));
            }
        }
        return videojuegos;
    }

    public Videojuego getVideojuegoByCod(int codProducto) throws SQLException {
        Videojuego videojuego = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_COD_QUERY)) {
            statement.setInt(1, codProducto);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                videojuego = resultSetToVideojuego(resultSet);
            }
        }
        return videojuego;
    }

    public void updateVideojuego(Videojuego videojuego) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setDate(1, java.sql.Date.valueOf(videojuego.getF_lanzamiento()));
            statement.setInt(2, videojuego.getCod_producto());
            statement.executeUpdate();
        }
    }

    public void deleteVideojuegoByCod(int codProducto) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, codProducto);
            statement.executeUpdate();
        }
    }

    private Videojuego resultSetToVideojuego(ResultSet resultSet) throws SQLException {
        Producto producto = productoDAO.getProductoByCod(resultSet.getInt("cod_producto"));
        return new Videojuego(
                producto.getCod_producto(),
                producto.getPrecio(),
                producto.getUnidades(),
                producto.getNombre(),
                resultSet.getDate("f_lanzamiento").toString()
        );
    }

    public int totalVideojuegos() throws SQLException {
        int total = 0;
        try (PreparedStatement statement = connection.prepareStatement(TOTAL_VIDEOGAMES_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                total = resultSet.getInt(1);
            }
        }
        return total;
    }
}


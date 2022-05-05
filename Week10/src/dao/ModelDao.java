package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Model;

public class ModelDao {
    
    
        private Connection connection ;
        private final String GET_MODELS_QUERY = "SELECT * FROM models" ;
        private final String GET_MODEL_BY_ID_QUERY = "SELECT * FROM models WHERE id = ?";
        private final String ADD_NEW_MODEL = "INSERT INTO models(id, make) VALUES (?,?)" ;
        private final String DELETE_MAKE = "DELETE FROM models WHERE id = ?";
        
        public ModelDao() {
            connection = DBConnection.getConnection();
        }
        
        public List<Model> getModels() throws SQLException{
            ResultSet rs = connection.prepareStatement(GET_MODELS_QUERY).executeQuery();
            List<Model> models = new ArrayList<Model>();
            
            while (rs.next()) {
                models.add(populateModel(rs.getInt(1), rs.getString(2)));
            }
            return models;
        }
        
        public Model getModelById(int id) throws SQLException {
            PreparedStatement ps = connection.prepareStatement(GET_MODEL_BY_ID_QUERY);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
           return populateModel(rs.getInt(1), rs.getString(2));
            } else {
                return null;
            }
        }

        private Model populateModel(int id, String model) {
            return new Model(id, model);
        }

        public void addModel(int id,String make) throws SQLException {
            PreparedStatement ps = connection.prepareStatement(ADD_NEW_MODEL);
            ps.setLong(1, id);
            ps.setString(2, make);
            ps.executeUpdate();
        }

        public void deleteMake(int id) throws SQLException {
            PreparedStatement ps = connection.prepareStatement(DELETE_MAKE);
            ps.setLong(1,id);
            ps.executeUpdate();
        }

     
}

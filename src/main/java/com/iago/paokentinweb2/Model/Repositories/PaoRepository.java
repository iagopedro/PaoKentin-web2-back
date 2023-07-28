package com.iago.paokentinweb2.Model.Repositories;

import com.iago.paokentinweb2.Model.Entities.Pao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class PaoRepository implements GenericRepository<Pao, Integer> {

    protected PaoRepository() {

    }

    @Override
    public void create(Pao p) {
        String sql = "insert into pao(nome, tempo_preparo) values (?,?)";

        try {
            PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

            pstm.setString(1, p.getNome());
            pstm.setInt(2, p.getTempoPreparo());

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Pao p) {
        String sql = "update pao set nome = ?, tempo_preparo = ? where id = ?";

        try {
            PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

            pstm.setString(1, p.getNome());
            pstm.setInt(2, p.getTempoPreparo());
            pstm.setInt(3, p.getId());

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pao read(Integer id) {
        String sql = "select * from pao where id = ?";

        try {
            PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();

            Pao p = null;

            if (rs.next()) {
                p = new Pao();
                p.setId(id);
                p.setNome(rs.getString("nome"));
                p.setTempoPreparo(rs.getInt("tempoPreparo"));
            }

            return p;
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from pao where id = ?";

        try {
            PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pao> readAll() {
        String sql = "select * from pao";

        List<Pao> paes = new ArrayList<>();

        try {
            PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();

            Pao p = null;

            while (rs.next()) {
                p = new Pao();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setTempoPreparo(rs.getInt("tempoPreparo"));

                paes.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paes;
    }
}

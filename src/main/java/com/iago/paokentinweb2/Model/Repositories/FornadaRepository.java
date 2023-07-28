package com.iago.paokentinweb2.Model.Repositories;

import com.iago.paokentinweb2.Model.Entities.Fornada;
import com.iago.paokentinweb2.Model.Entities.Pao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class FornadaRepository implements GenericRepository<Fornada, Integer> {
    protected FornadaRepository() {

    }

    @Override
    public void create(Fornada f) {
        String sql = "insert into fornada(horarioInicial, pao_id) values (?, ?)";

        try {
            PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

            pstm.setTimestamp(1, new Timestamp(f.getHorarioInicial().getTime()));
            pstm.setInt(2, f.getPao().getId());

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Fornada f) {
        String sql = "update fornada set horarioInicial = ? where id = ?";

        try {
            PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

            pstm.setDate(1, f.getHorarioInicial());
            pstm.setInt(2, f.getId());

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Fornada read(Integer id) {
        String sql = "select * from fornada as f join pao as p on(f.pao_id = p.id) where f.id = ?";

        try {
            PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();

            Fornada f = null;

            while (rs.next()) {
                f = new Fornada();
                f.setId(id);
                f.setHorarioInicial(rs.getDate("horarioInicial"));

                Pao p = new Pao();
                p.setId(rs.getInt("pao_id"));
                p.setNome(rs.getString("nome"));
                p.setTempoPreparo(rs.getInt(("tempoPreparo")));

                f.setPao(p);
            }
            return f;

        } catch (SQLException e) {
            e.printStackTrace();
        }

    return null;
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from fornada where id = ?";

        try {

            PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Fornada> readAll() {
        String sql = "select * from fornada";

        List<Fornada> fornadas = new ArrayList<>();

        try {
            PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();

            Fornada f = null;

            while (rs.next()) {
                f = new Fornada();
                f.setId(rs.getInt("id"));
                f.setHorarioInicial(rs.getDate("horarioInicial"));

                Pao p = new Pao();
                p.setId(rs.getInt("pao_id"));
                p.setNome(rs.getString("nome"));
                p.setTempoPreparo(rs.getInt(("tempoPreparo")));

                f.setPao(p);

                fornadas.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fornadas;
    }
}

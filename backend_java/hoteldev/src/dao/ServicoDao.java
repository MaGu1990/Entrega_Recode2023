package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.Db;
import model.Servico;

public class ServicoDao {

    public void save(Servico servico) {
        String sql = "INSERT INTO servico (tipo_servico, data_agendamento, data_inicio, data_fim) VALUES (?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = Db.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, servico.getTipo_servico());
            pstm.setDate(2, new Date(servico.getData_agendamento().getTime()));
            pstm.setDate(3, new Date(servico.getData_inicio().getTime()));
            pstm.setDate(4, new Date(servico.getData_fim().getTime()));
            pstm.execute();
            System.out.println("Serviço Cadastrado com Sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Servico> getServicos() {
        String sql = "SELECT * FROM servico";
        List<Servico> servicos = new ArrayList<Servico>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = Db.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Servico servico = new Servico();
                servico.setId_servico(rset.getInt("id_servico"));
                servico.setTipo_servico(rset.getString("tipo_servico"));
                servico.setData_agendamento(new java.util.Date(rset.getDate("data_agendamento").getTime()));
                servico.setData_inicio(new java.util.Date(rset.getDate("data_inicio").getTime()));
                servico.setData_fim(new java.util.Date(rset.getDate("data_fim").getTime()));
                servicos.add(servico);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return servicos;
    }

    public void update(Servico servico) {
        String sql = "UPDATE servico SET tipo_servico = ?, data_agendamento = ?, data_inicio = ?, data_fim = ? WHERE id_servico = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = Db.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, servico.getTipo_servico());
            pstm.setDate(2, new Date(servico.getData_agendamento().getTime()));
            pstm.setDate(3, new Date(servico.getData_inicio().getTime()));
            pstm.setDate(4, new Date(servico.getData_fim().getTime()));
            pstm.setInt(5, servico.getId_servico());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }
        
        public void deleteByID(int id) {
            
            String sql = "DELETE FROM servico WHERE id_servicos = ?";
            
            Connection conn = null;
            
            PreparedStatement pstm = null;
            
            try {
                conn = Db.createConnectionToMySQL();
                
                pstm = (PreparedStatement) conn.prepareStatement(sql);
                
                pstm.setInt(1, id);
                
                pstm.execute();
                
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    if(pstm!=null) {
                        pstm.close();
                    }
                    
                    if(conn!=null) {
                        conn.close();
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }
}

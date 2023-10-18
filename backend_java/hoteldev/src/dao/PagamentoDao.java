package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import database.Db;
import model.Pagamento;

public class PagamentoDao {
	public void save(Pagamento pagamento) {
        String sql = "INSERT INTO pagamento (valor, tipo_pagamento, data_pagamento, parcelas) VALUES (?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = Db.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setDouble(1, pagamento.getValor());
            pstm.setString(2, pagamento.getTipo_pagamento());
            pstm.setDate(3,new Date(pagamento.getData_pagamento().getTime()));
            pstm.setInt(4,pagamento.getParcelas());

            pstm.execute();
            System.out.println("Cliente Cadastrado com Sucesso!");
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

    public List<Pagamento> getPagamentos() { // PAGAMENTO OU PAGAMENTOS
        String sql = "SELECT * FROM pagamento";
        List<Pagamento> pagamentos = new ArrayList<Pagamento>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = Db.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Pagamento pagamento = new Pagamento();
                pagamento.setId_pagamento(rset.getInt("id_pagamento"));
                pagamento.setValor(rset.getDouble("valor"));
                pagamento.setTipo_pagamento(rset.getString("tipo_pagamento"));
                pagamento.setData_pagamento(rset.getDate("data_pagamento"));
                pagamento.setParcelas(rset.getInt("parcelas"));
                pagamentos.add(pagamento);
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
        return pagamentos;
    }

    public void update(Pagamento pagamento) {
        String sql = "UPDATE pagamento SET valor = ?, tipo_pagamento = ?, data_pagamento = ?, parcelas = ? WHERE id_pagamento = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = Db.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setDouble(1, pagamento.getValor());
            pstm.setString(2, pagamento.getTipo_pagamento());
            pstm.setDate(3, new Date (pagamento.getData_pagamento().getTime()));
            pstm.setInt(4, pagamento.getParcelas());
            pstm.setInt(5, pagamento.getId_pagamento());

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

    public void deleteByID(int id_pagamento) {
        String sql = "DELETE FROM pagamento WHERE id_pagamento = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = Db.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_pagamento);
            pstm.execute();
            
        } 
        catch (Exception e) {
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
}

	
	


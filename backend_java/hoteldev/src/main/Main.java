package main;

import java.util.Date;
import dao.ClienteDao;
import dao.ServicoDao;
import dao.PagamentoDao;
import model.Servico;
import model.Cliente;
import model.Pagamento;

public class Main {

    public static void main(String[] args) {

        ClienteDao clienteDao = new ClienteDao();
        ServicoDao servicoDao = new ServicoDao();
        PagamentoDao pagamentoDao = new PagamentoDao();

       
        Cliente cliente = new Cliente();
        cliente.setCpf("037-565-881-22");
        cliente.setNome("Jéssika Ramos Lameirão");
        cliente.setTelefone("36274135");
        cliente.setEmail("Jessika.Ramos@gmail.com");

        clienteDao.save(cliente);
        
        for (Cliente c : clienteDao.getClientes()) {
            System.out.println("Cliente: " + c.getNome());
        }
        
        Cliente c1 = new Cliente();
        c1.setCpf("037-565-881-22");
        c1.setNome("Maria Alice Ramos Chaves");
        c1.setTelefone("36274135");
        c1.setEmail("maria.alice@gmail.com");
        
         clienteDao.update(c1);
       
        
         clienteDao.deleteByID(2);
        
         
         
        Servico servico = new Servico();
        servico.setTipo_servico("viajens");
        servico.setData_agendamento(new Date());
        servico.setData_inicio(new Date());
        servico.setData_fim(new Date());
        servicoDao.save(servico);
        
         
        
        for (Servico s : servicoDao.getServicos()) {
            System.out.println("Serviço: " + s.getTipo_servico());
        }
        
        Servico s1 = new Servico();
        s1.setTipo_servico("hospedagem");
        s1.setData_agendamento(new Date());
        s1.setData_inicio(new Date());
        s1.setData_fim(new Date());
        s1.setId_servico(1);
        servicoDao.update(s1);
       
      
        Pagamento pagamento = new Pagamento();
        pagamento.setValor(100.00);
        pagamento.setTipo_pagamento("Pix");
        pagamento.setData_pagamento(new Date());
        pagamento.setParcelas(12);
        pagamentoDao.save(pagamento);
        
       
        
        for (Pagamento p : pagamentoDao.getPagamentos()) {
            System.out.println("Pagamento: (" + p.getId_pagamento() + ") // " + p.getValor());
        }
       
        Pagamento p1 = new Pagamento();
        p1.setValor(1000.00);
        p1.setTipo_pagamento("Cartão");
        p1.setData_pagamento(new Date());
        p1.setParcelas(6);
        pagamentoDao.update(p1);
        
        pagamentoDao.deleteByID(p1.getId_pagamento());
       

    }
}

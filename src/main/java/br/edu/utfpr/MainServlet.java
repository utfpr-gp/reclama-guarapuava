/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr;

import br.edu.utfpr.model.Category;
import br.edu.utfpr.model.Neighborhood;
import br.edu.utfpr.model.Occurrence;
import br.edu.utfpr.model.Problem;
import br.edu.utfpr.model.User;
import br.edu.utfpr.model.UserRole;
import br.edu.utfpr.util.JPAUtil;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ronifabio
 */
@WebServlet(name = "MainServlet", urlPatterns = {"/main"})
public class MainServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();

        Category c1 = new Category("Acessibilidade - calçadas");
        em.persist(c1);
        Category c2 = new Category("Água/Esgoto - Vazamentos de água");
        em.persist(c2);
        Category c3 = new Category("Buracos");
        em.persist(c3);
        Category c4 = new Category("Iluminação - Rede de energia");
        em.persist(c4);
        Category c5 = new Category("Meio Ambiente");
        em.persist(c5);
        Category c6 = new Category("Pichações - Desordem urbana");
        em.persist(c6);
        Category c7 = new Category("Sinalizações - Trânsito");
        em.persist(c7);
        Category c8 = new Category("Segurança - Crimes");
        em.persist(c8);
        Category c9 = new Category("Lixo");
        em.persist(c9);

        //Cadastro inicial de problemas
        Problem p1 = new Problem("Semáforo de Rua Quebrado");
        em.persist(p1);
        Problem p2 = new Problem("Semáforo de Pedestre Quebrado");
        em.persist(p2);
        Problem p3 = new Problem("Lixeira Quebrada");
        em.persist(p3);
        Problem p4 = new Problem("Bueiro Entupido");
        em.persist(p4);
        Problem p5 = new Problem("Bueiro sem Tampa");
        em.persist(p5);
        Problem p6 = new Problem("Buraco na Calçada");
        em.persist(p6);
        Problem p7 = new Problem("Buraco na Rua");
        em.persist(p7);
        Problem p8 = new Problem("Buraco na Ciclovia");
        em.persist(p8);
        Problem p9 = new Problem("Poste de Luz Apagado");
        em.persist(p9);
        Problem p10 = new Problem("Post de Luz sem Lâmpada");
        em.persist(p10);
        Problem p11 = new Problem("Poste de Luz Caído");
        em.persist(p11);
        Problem p12 = new Problem("Falta de Placa: nome de rua");
        em.persist(p12);
        Problem p13 = new Problem("Falta de Placa: sinalização de trânsito");
        em.persist(p13);
        Problem p14 = new Problem("Placa de Sinalização quebrada");
        em.persist(p14);
        Problem p15 = new Problem("Placa de Sinalização pichada");
        em.persist(p15);
        Problem p16 = new Problem("Banco de Praça quebrado");
        em.persist(p16);
        Problem p17 = new Problem("Praia Suja");
        em.persist(p17);
        Problem p18 = new Problem("Terreno Baldio Sujo");
        em.persist(p18);
        Problem p19 = new Problem("Árvore Caída");
        em.persist(p19);
        Problem p20 = new Problem("Faixa de Pedestre sem tinta");
        em.persist(p20);
        Problem p21 = new Problem("Ponto de ônibus quebrado");
        em.persist(p21);
        Problem p45 = new Problem("Ponto de alagamento");
        em.persist(p45);
        Problem p22 = new Problem("Árvore sem poda");
        em.persist(p22);
        Problem p23 = new Problem("Jardim sem poda");
        em.persist(p23);
        Problem p24 = new Problem("Vazamento de água");
        em.persist(p24);
        Problem p25 = new Problem("Vazamento de gás");
        em.persist(p25);
        Problem p26 = new Problem("Lixo sem recolhimento");
        em.persist(p26);
        Problem p27 = new Problem("Lixo hospitalar sem recolhimento");
        em.persist(p27);
        Problem p28 = new Problem("Caçamba de lixo abandonada");
        em.persist(p28);
        Problem p29 = new Problem("Veículo abandonado");
        em.persist(p29);
        Problem p30 = new Problem("Dejetos – Resíduos em Rio – Córrego");
        em.persist(p30);
        Problem p31 = new Problem("Esgoto a céu aberto");
        em.persist(p31);
        Problem p32 = new Problem("Foco de dengue");
        em.persist(p32);
        Problem p33 = new Problem("Falta de acessibilidade");
        em.persist(p33);
        Problem p34 = new Problem("Ponte – Viaduto quebrada");
        em.persist(p34);
        Problem p35 = new Problem("Passarela quebrada");
        em.persist(p35);
        Problem p36 = new Problem("Falta de mureta de proteção");
        em.persist(p36);
        Problem p37 = new Problem("Mureta de proteção quebrada");
        em.persist(p37);
        Problem p38 = new Problem("Estabelecimento sem higiene");
        em.persist(p38);
        Problem p39 = new Problem("Banheiro público sem higiene");
        em.persist(p39);
        Problem p40 = new Problem("Patrimônio público depredado");
        em.persist(p40);
        Problem p42 = new Problem("Máquina zona azul quebrada");
        em.persist(p42);
        Problem p43 = new Problem("Abelhas – Vespas – Formigas");
        em.persist(p43);
        Problem p44 = new Problem("Praça suja");
        em.persist(p44);

        //Cadastro Inicial de Bairros
        Neighborhood n1 = new Neighborhood("Alto Cascavel");
        em.persist(n1);
        Neighborhood n2 = new Neighborhood("Alto da XV");
        em.persist(n2);
        Neighborhood n3 = new Neighborhood("Batel");
        em.persist(n3);
        Neighborhood n4 = new Neighborhood("Bonsucesso");
        em.persist(n4);
        Neighborhood n5 = new Neighborhood("Boqueirão");
        em.persist(n5);
        Neighborhood n6 = new Neighborhood("Cascavel");
        em.persist(n6);
        Neighborhood n7 = new Neighborhood("Conradinho");
        em.persist(n7);
        Neighborhood n8 = new Neighborhood("Dos Estados");
        em.persist(n8);
        Neighborhood n9 = new Neighborhood("Imóvel Morro Alto");
        em.persist(n9);
        Neighborhood n10 = new Neighborhood("Industrial");
        em.persist(n10);
        Neighborhood n11 = new Neighborhood("Jardim das Américas");
        em.persist(n11);
        Neighborhood n12 = new Neighborhood("Morro Alto");
        em.persist(n12);
        Neighborhood n13 = new Neighborhood("Primavera");
        em.persist(n13);
        Neighborhood n14 = new Neighborhood("Santa Cruz");
        em.persist(n14);
        Neighborhood n15 = new Neighborhood("Santana");
        em.persist(n15);
        Neighborhood n16 = new Neighborhood("São Cristovão");
        em.persist(n16);
        Neighborhood n17 = new Neighborhood("Trianon");
        em.persist(n17);
        Neighborhood n18 = new Neighborhood("Vila Carli");
        em.persist(n18);
        Neighborhood n19 = new Neighborhood("Vila Bela");
        em.persist(n19);
        Neighborhood n20 = new Neighborhood("Centro");
        em.persist(n20);

        User admin = new User("admin", "admin@admin.com", "admin", "e10adc3949ba59abbe56e057f20f883e", null);
        em.persist(admin);

        User user1 = new User("Jefferson", "jeff@gmail.com", "jefferson", "e10adc3949ba59abbe56e057f20f883e", null);
        em.persist(user1);

        User user2 = new User("Lucas", "lucas@agmail.com", "lucas", "e10adc3949ba59abbe56e057f20f883e", null);
        em.persist(user2);

        User user3 = new User("luiz", "luiz@gmail.com", "luiz", "e10adc3949ba59abbe56e057f20f883e", null);
        em.persist(user3);

        UserRole adminRole = new UserRole("admin", "ADM");
        em.persist(adminRole);

        UserRole user1Role = new UserRole("jefferson", "USER");
        em.persist(user1Role);

        UserRole user2Role = new UserRole("lucas", "USER");
        em.persist(user2Role);

        UserRole user3Role = new UserRole("luiz", "USER");
        em.persist(user3Role);

        Occurrence o1 = new Occurrence(c1, p44, "Rua 01", n19, "descrição 01", "Status 01", user2);
        em.persist(o1);

        Occurrence o2 = new Occurrence(c2, p12, "Rua 02", n20, "descrição 02", "Status 02", user2);
        em.persist(o2);

        Occurrence o3 = new Occurrence(c3, p25, "Rua 03", n20, "descrição 03", "Status 03", user1);
        em.persist(o3);

        Occurrence o4 = new Occurrence(c4, p13, "Rua 04", n19, "descrição 04", "Status 04", user3);
        em.persist(o4);

        Occurrence o5 = new Occurrence(c5, p4, "Rua 05", n11, "descrição 05", "Status 05", user3);
        em.persist(o5);

        Occurrence o6 = new Occurrence(c6, p8, "Rua 05", n12, "descrição 06", "Status 06", user2);
        em.persist(o6);

        Occurrence o7 = new Occurrence(c7, p23, "Rua 06", n13, "descrição 07", "Status 07", user3);
        em.persist(o7);

        Occurrence o8 = new Occurrence(c8, p35, "Rua 07", n14, "descrição 08", "Status 08", user1);
        em.persist(o8);

        Occurrence o9 = new Occurrence(c9, p22, "Rua 08", n20, "descrição 09", "Status 09", user1);
        em.persist(o9);

        Occurrence o10 = new Occurrence(c1, p31, "Rua 09", n20, "descrição 10", "Status 10", user3);
        em.persist(o10);

        Occurrence o11 = new Occurrence(c2, p15, "Rua 10", n17, "descrição 11", "Status 11", user2);
        em.persist(o1);

        Occurrence o12 = new Occurrence(c3, p10, "Rua 11", n17, "descrição 12", "Status 12", user3);
        em.persist(o12);

        Occurrence o13 = new Occurrence(c4, p5, "Rua 12", n20, "descrição 13", "Status 13", user2);
        em.persist(o13);

        Occurrence o14 = new Occurrence(c5, p4, "Rua 13", n12, "descrição 14", "Status 14", user1);
        em.persist(o14);

        Occurrence o15 = new Occurrence(c6, p3, "Rua 14", n20, "descrição 15", "Status 15", user3);
        em.persist(o15);

        em.getTransaction().commit();

        em.close();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

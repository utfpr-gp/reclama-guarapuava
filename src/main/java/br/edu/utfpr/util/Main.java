/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.util;

/**
 *
 * Gera o schema do banco de dados
 *
 * @author Roni
 */
public class Main {

    public static void main(String[] args) {
        try {
            JPAUtil.generateSchema();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package br.com.hamburgueria.controller;

import br.com.hamburgueria.dao.ProdutoDAO;
import br.com.hamburgueria.model.Produto;
import java.util.List;

public class ProdutoController {

    private ProdutoDAO produtoDAO;

    public ProdutoController() {
        this.produtoDAO = new ProdutoDAO();
    }

    public void salvarProduto(Produto produto) {
        produtoDAO.salvar(produto);
    }
    
    public void atualizarProduto(Produto produto) {
        produtoDAO.atualizar(produto);
    }
    
    public void excluirProduto(int id) {
        produtoDAO.excluir(id);
    }
    
    public Produto buscarProdutoPorId(int id) {
        return produtoDAO.buscarPorId(id);
    }

    public List<Produto> listarTodosProdutos() {
        return produtoDAO.listarTodos();
    }
}
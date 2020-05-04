package com.matheusdias.cursospring;

import com.matheusdias.cursospring.domain.Categoria;
import com.matheusdias.cursospring.domain.Cidade;
import com.matheusdias.cursospring.domain.Cliente;
import com.matheusdias.cursospring.domain.Endereco;
import com.matheusdias.cursospring.domain.Estado;
import com.matheusdias.cursospring.domain.Produto;
import com.matheusdias.cursospring.domain.enums.TipoCliente;
import com.matheusdias.cursospring.repositories.CategoriaRepository;
import com.matheusdias.cursospring.repositories.CidadeRepository;
import com.matheusdias.cursospring.repositories.ClienteRepository;
import com.matheusdias.cursospring.repositories.EnderecoRepository;
import com.matheusdias.cursospring.repositories.EstadoRepository;
import com.matheusdias.cursospring.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursospringApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public static void main(String[] args) {
        SpringApplication.run(CursospringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat1.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategoriaList().addAll(Arrays.asList(cat1));
        p2.getCategoriaList().addAll(Arrays.asList(cat1, cat2));
        p3.getCategoriaList().addAll(Arrays.asList(cat1));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade c1 = new Cidade(null, "Uberlândia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Campinas", est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));

        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

        Cliente cli1 = new Cliente(null, "maria Silva", "maria@gmail.com", "437216788987", TipoCliente.PESSOAFISICA);

        cli1.getTelefones().addAll(Arrays.asList("14679756", "165497634"));

        Endereco e1 = new Endereco(null, "Rua flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
        Endereco e2 = new Endereco(null, "Avenida matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);

        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

        clienteRepository.saveAll(Arrays.asList(cli1));
        enderecoRepository.saveAll(Arrays.asList(e1, e2));

    }
}

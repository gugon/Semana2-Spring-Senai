package br.com.futurodev.apicrudpessoa.controller;

import br.com.futurodev.apicrudpessoa.model.Pessoa;
import br.com.futurodev.apicrudpessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Pessoa> cadastrar(@RequestBody Pessoa pessoa){
        Pessoa people = pessoaRepository.save(pessoa);
        return new ResponseEntity<Pessoa>(people, HttpStatus.CREATED);
    }

    @GetMapping(value = "/", produces = "application/json")
    @ResponseBody // Retorna os dados no corpo da resposta
    public ResponseEntity<List<Pessoa>> listarUsuarios(){
        List<Pessoa> people = pessoaRepository.findAll();
        return new ResponseEntity<List<Pessoa>>(people, HttpStatus.OK);
    }

    @DeleteMapping(value = "/")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idPessoa){
        pessoaRepository.deleteById(idPessoa);
        return new ResponseEntity<String>("Usuário deletado com sucesso!", HttpStatus.OK);
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<Pessoa> atualizar(@RequestBody Pessoa pessoa){
        Pessoa people = pessoaRepository.save(pessoa);
        return new ResponseEntity<Pessoa>(people, HttpStatus.OK);
    }

    @GetMapping(value = "/{idPessoa}", produces = "application/json")
    public ResponseEntity<Pessoa> getUserById(@PathVariable(value = "idPessoa") Long idPessoa){
        Pessoa usu =  pessoaRepository.findById(idPessoa).get();
        return new ResponseEntity<Pessoa>(usu, HttpStatus.OK);
    }

    @GetMapping(value = "/buscarPorNome", produces = "application/json")
    public ResponseEntity<List<Pessoa>> getPessoaById(@RequestParam (name = "nome") String nome){
        List<Pessoa> pessoas = pessoaRepository.getPessoaByName(nome);
        return new ResponseEntity<List<Pessoa>>(pessoas, HttpStatus.OK);
    }
}

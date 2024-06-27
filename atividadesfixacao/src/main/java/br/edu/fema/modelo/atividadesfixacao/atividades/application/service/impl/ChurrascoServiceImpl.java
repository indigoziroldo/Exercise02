package br.edu.fema.modelo.atividadesfixacao.atividades.application.service.impl;

import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.entities.ChurrascoEntity;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.repository.ChurrascoRepository;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.repository.LugarRepository;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.domain.repository.PessoaRepository;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto.ChurrascoDTO;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.dto.ValorPessoaDTO;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.rest.forms.ChurrascoForm;
import br.edu.fema.modelo.atividadesfixacao.atividades.application.service.ChurrascoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChurrascoServiceImpl implements ChurrascoService {


    private final ChurrascoRepository churrascoRepository;
    private final PessoaRepository pessoaRepository;
    private final LugarRepository lugarRepository;

    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
    //public List<ChurrascoEntity> listaChurrasco = this.churrascoRepository.findAll();
    //public List<PessoaEntity> listaPessoa = this.pessoaRepository.findAll();

    @Override
    public List<ChurrascoEntity> buscarTodosChurrascos() {
        return churrascoRepository.findAll();
    }

    @Override
    public List<ChurrascoEntity> buscarTodosChurrascosPorData(String dataBusca) {
        LocalDateTime dataConvertida = (LocalDateTime.parse(dataBusca, formatter));
        return churrascoRepository
                .findByDataInicioGreaterThanEqual(dataConvertida);

    }

    @Override
    public List<ChurrascoEntity> buscarTodosChurrascosEntreDuasDatas(String dataBuscaInicio, String dataBuscaFim) {
        LocalDateTime dataConvertida1 = (LocalDateTime.parse(dataBuscaInicio, formatter));
        LocalDateTime dataConvertida2 = (LocalDateTime.parse(dataBuscaFim, formatter));
        return churrascoRepository
                .findAllByDataInicioBetween(dataConvertida1,dataConvertida2);
    }

    @Override
    public List<ValorPessoaDTO> buscarAlimentosPorValor() {
        return null;
    }

//    @Override
//    public List<ValorPessoaDTO> buscarAlimentosPorValor() {
//        return listaPessoa
//                .stream()
//                .map(p -> {
//                  return new ValorPessoaDTO()
//                           .builder()
//                           .nomePessoa(listaPessoa.forEach(pessoaEntity -> {
//                               pessoaEntity.getNome();
//                           });)
//                          .valorTotal(BigDecimal.ONE)
//                          .alimento(new ArrayList<>())
//                           .build();
//                }).toList();
//    }

    /*
                               C R U D
\,¯\`·-.,_                                   _,. --··,
               `´·,      ¯`-·· ´´´¯¯ ``` ·· ., -··´´¯    \.·´
        .            ,·´                                 ,.- ´              , ·' |
       	             ;   _                 _     ::::\·´              , ·'       |
        .          ;  /#º ;             ;#º`;   ``   ;         , ·'         , ·'
        .         /   `·--´      _      `·-- ´          ;   , ·'        , ·'
        .        ;¯)        ,  ` ´   ,       ( ¯ )      ;  `  -.,_  ' ·,
        .         \           ` ´¯` ´          ¯         ;      ,·'    ,·'
        .          ,' `·-                             _...-;  ,·'    ,·'
        .         ;    ,      ·:::::·                ``´¯¯;  \     \
        .        ;    /                      /    ,         ;   \:.::.\
        .        ;,,,/                     -/    /     =--¯;,·':::,·'
        .           ;                       ' ' '             ;::::'.·,
        .            ;                     /                /,.``· ´
        .             \                   ;                /
        .             ,´  ,                \           ,·'
        .            -,, -·'```···-----······\_     ,·
        .                                    /,,,/
                               C R U D
     */
    // CREATE
    @Transactional
    public void criarChurrasco(ChurrascoForm churrascoForm){
        ChurrascoEntity churrascoCriado = new ChurrascoEntity();
        churrascoCriado.setIdAnfitriao(churrascoForm.getIdAnfitriao());
        churrascoCriado.setDataInicio(LocalDateTime.parse(churrascoForm.getDataInicio()));
        churrascoCriado.setDataFim(LocalDateTime.parse(churrascoForm.getDataFim()));
        this.churrascoRepository.save(churrascoCriado);
    }

//     READ
    public List<ChurrascoDTO> buscarTodosOsChurrascos(){
        List<ChurrascoEntity> listadeChurrascos = this.churrascoRepository.findAll();
        if(listadeChurrascos.isEmpty()) throw new RuntimeException("Lista de churrasco está vazia");
        return ChurrascoDTO.converter(listadeChurrascos);
    }

    // UPDATE
    public void atualizarChurrasco(ChurrascoForm churrascoForm, long id){
        ChurrascoEntity churrascoEncontrado = this.churrascoRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Esse churrasco não existe"));

        churrascoEncontrado.setIdLugar(churrascoForm.getIdLugar());
        churrascoEncontrado.setDataFim(LocalDateTime.parse(churrascoForm.getDataFim()));
        churrascoEncontrado.setDataInicio(LocalDateTime.parse(churrascoForm.getDataInicio()));
        churrascoEncontrado.setIdAnfitriao(churrascoForm.getIdAnfitriao());

        this.churrascoRepository.save(churrascoEncontrado);
    }

    // DELETE
    public void deletarChurrascoPorId(long id){
        churrascoRepository.deleteById(id);
    }

}

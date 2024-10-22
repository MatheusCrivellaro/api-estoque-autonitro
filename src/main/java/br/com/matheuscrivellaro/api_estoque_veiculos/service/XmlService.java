package br.com.matheuscrivellaro.api_estoque_veiculos.service;

import br.com.matheuscrivellaro.api_estoque_veiculos.dto.estoque.*;
import br.com.matheuscrivellaro.api_estoque_veiculos.dto.estoqueXml.CargaVeiculos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class XmlService {

    private final WebClient webClient;

    public XmlService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public CargaVeiculos getCargaVeiculos(String uri) throws JsonProcessingException {
        var response = webClient.get()
                .uri(uri)
                .accept()
                .retrieve()
                .bodyToMono(String.class)
                .block();
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(response, CargaVeiculos.class);
    }

    public List<Veiculo> getVeiculosXml(String uri) throws JsonProcessingException {
        var response = getCargaVeiculos(uri);
        List<Veiculo> listVeiculos = new ArrayList<>();
        response.getVeiculos().getVeiculos().forEach(
                veiculo -> listVeiculos.add(
                        new Veiculo(
                                "",
                                "",
                                veiculo.getCodigoVeiculo(),
                                veiculo.getPlaca(),
                                veiculo.getTipoVeiculo(),
                                veiculo.getUsadoNovo(),
                                veiculo.getMarca(),
                                veiculo.getModelo(),
                                veiculo.getAnoModelo(),
                                veiculo.getAnoFabricacao(),
                                veiculo.getVersao(),
                                veiculo.getCombustivel(),
                                veiculo.getTransmissao(),
                                veiculo.getQtdPortas(),
                                veiculo.getCor(),
                                veiculo.getChassis(),
                                veiculo.getRenavan(),
                                veiculo.getKilometragem(),
                                "",
                                veiculo.getBlindado(),
                                veiculo.getEmDestaque(),
                                "",
                                veiculo.getPreco(),
                                "",
                                veiculo.getObservacao(),
                                mapOpcionais(veiculo),
                                mapFotos(veiculo),
                                "", "", "",
                                veiculo.getCilindrada(),
                                ""
                        )
                )
        );
        return listVeiculos;
    }

    public Fotos mapFotos(br.com.matheuscrivellaro.api_estoque_veiculos.dto.estoqueXml.Veiculo veiculo) {
        var list = veiculo.getFotos().getFotos().stream().map(
                foto -> new Foto(foto.getNomeArquivo(), foto.getUrlArquivo(), foto.getPrincipal())
        ).toList();
        return new Fotos(list);
    }

    public Opcionais mapOpcionais(br.com.matheuscrivellaro.api_estoque_veiculos.dto.estoqueXml.Veiculo veiculo) {
        List<Opcional> opcionais = new ArrayList<>();

        if ("S".equals(veiculo.getFreiosABS())) {
            opcionais.add(new Opcional("001", "Freios ABS"));
        }
        if ("S".equals(veiculo.getRodasLigaLeve())) {
            opcionais.add(new Opcional("002", "Rodas Liga Leve"));
        }
        if ("S".equals(veiculo.getTravaEletrica())) {
            opcionais.add(new Opcional("003", "Trava Elétrica"));
        }
        if ("S".equals(veiculo.getVidrosEletricos())) {
            opcionais.add(new Opcional("004", "Vidros Elétricos"));
        }
        if ("S".equals(veiculo.getAlarme())) {
            opcionais.add(new Opcional("005", "Alarme"));
        }
        if ("S".equals(veiculo.getBancoCouro())) {
            opcionais.add(new Opcional("006", "Banco de Couro"));
        }
        if ("S".equals(veiculo.getDirecaoHidraulica())) {
            opcionais.add(new Opcional("007", "Direção Hidráulica"));
        }
        if ("S".equals(veiculo.getLimpadorTraseiro())) {
            opcionais.add(new Opcional("008", "Limpador Traseiro"));
        }
        if ("S".equals(veiculo.getTetoSolar())) {
            opcionais.add(new Opcional("009", "Teto Solar"));
        }
        if ("S".equals(veiculo.getAirBag())) {
            opcionais.add(new Opcional("010", "Air Bag"));
        }
        if ("S".equals(veiculo.getAirBagMotorista())) {
            opcionais.add(new Opcional("011", "Air Bag Motorista"));
        }
        if ("S".equals(veiculo.getAirBagDuplo())) {
            opcionais.add(new Opcional("012", "Air Bag Duplo"));
        }
        if ("S".equals(veiculo.getArCondicionado())) {
            opcionais.add(new Opcional("013", "Ar Condicionado"));
        }
        if ("S".equals(veiculo.getArQuente())) {
            opcionais.add(new Opcional("014", "Ar Quente"));
        }
        if ("S".equals(veiculo.getDesembacadorTraseiro())) {
            opcionais.add(new Opcional("015", "Desembacador Traseiro"));
        }
        if ("S".equals(veiculo.getGps())) {
            opcionais.add(new Opcional("016", "GPS"));
        }
        if ("S".equals(veiculo.getRetrovisoresEletricos())) {
            opcionais.add(new Opcional("017", "Retrovisores Elétricos"));
        }
        if ("S".equals(veiculo.getSensorEstacionamento())) {
            opcionais.add(new Opcional("018", "Sensor de Estacionamento"));
        }
        if ("S".equals(veiculo.getSensorChuva())) {
            opcionais.add(new Opcional("019", "Sensor de Chuva"));
        }
        if ("S".equals(veiculo.getBluetooth())) {
            opcionais.add(new Opcional("020", "Bluetooth"));
        }
        if ("S".equals(veiculo.getVolanteRegulagemAltura())) {
            opcionais.add(new Opcional("021", "Volante com Regulagem de Altura"));
        }
        if ("S".equals(veiculo.getBancoMotoristaAjusteAltura())) {
            opcionais.add(new Opcional("022", "Banco do Motorista com Ajuste de Altura"));
        }
        if ("S".equals(veiculo.getEncostoCabecaTraseiro())) {
            opcionais.add(new Opcional("023", "Encosto de Cabeça Traseiro"));
        }
        if ("S".equals(veiculo.getSensorLuz())) {
            opcionais.add(new Opcional("024", "Sensor de Luz"));
        }
        if ("S".equals(veiculo.getImobilizadorMotor())) {
            opcionais.add(new Opcional("025", "Imobilizador de Motor"));
        }
        return new Opcionais(opcionais);
    }

}

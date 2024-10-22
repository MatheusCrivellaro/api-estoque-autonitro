package br.com.matheuscrivellaro.api_estoque_veiculos.dto.estoqueXml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Veiculo {
    @JacksonXmlProperty(localName = "CodigoCliente")
    private String codigoCliente;

    @JacksonXmlProperty(localName = "CodigoVeiculo")
    private String codigoVeiculo;

    @JacksonXmlProperty(localName = "UsadoNovo")
    private String usadoNovo;

    @JacksonXmlProperty(localName = "TipoVeiculo")
    private String tipoVeiculo;

    @JacksonXmlProperty(localName = "Categoria")
    private String categoria;

    @JacksonXmlProperty(localName = "Marca")
    private String marca;

    @JacksonXmlProperty(localName = "Modelo")
    private String modelo;

    @JacksonXmlProperty(localName = "Versao")
    private String versao;

    @JacksonXmlProperty(localName = "Procedencia")
    private String procedencia;

    @JacksonXmlProperty(localName = "Cilindrada")
    private String cilindrada;

    @JacksonXmlProperty(localName = "Potencia")
    private String potencia;

    @JacksonXmlProperty(localName = "TipoMotor")
    private String tipoMotor;

    @JacksonXmlProperty(localName = "Freio")
    private String freio;

    @JacksonXmlProperty(localName = "Refrigeracao")
    private String refrigeracao;

    @JacksonXmlProperty(localName = "AnoModelo")
    private String anoModelo;

    @JacksonXmlProperty(localName = "AnoFabricacao")
    private String anoFabricacao;

    @JacksonXmlProperty(localName = "Combustivel")
    private String combustivel;

    @JacksonXmlProperty(localName = "Transmissao")
    private String transmissao;

    @JacksonXmlProperty(localName = "CodigoFIPE")
    private String codigoFIPE;

    @JacksonXmlProperty(localName = "Cor")
    private String cor;

    @JacksonXmlProperty(localName = "SegundaCor")
    private String segundaCor;

    @JacksonXmlProperty(localName = "Preco")
    private String preco;

    @JacksonXmlProperty(localName = "PrecoPromocional")
    private String precoPromocional;

    @JacksonXmlProperty(localName = "Alienado")
    private String alienado;

    @JacksonXmlProperty(localName = "ComDivida")
    private String comDivida;

    @JacksonXmlProperty(localName = "ValorParcelaDivida")
    private String valorParcelaDivida;

    @JacksonXmlProperty(localName = "NumeroParcelasDivida")
    private String numeroParcelasDivida;

    @JacksonXmlProperty(localName = "ValorTotalDivida")
    private String valorTotalDivida;

    @JacksonXmlProperty(localName = "Placa")
    private String placa;

    @JacksonXmlProperty(localName = "Cidade")
    private String cidade;

    @JacksonXmlProperty(localName = "Kilometragem")
    private String kilometragem;

    @JacksonXmlProperty(localName = "QtdDonos")
    private String qtdDonos;

    @JacksonXmlProperty(localName = "QtdPortas")
    private String qtdPortas;

    @JacksonXmlProperty(localName = "AceitaPermutaCarro")
    private String aceitaPermutaCarro;

    @JacksonXmlProperty(localName = "AceitaPermutaOutroBem")
    private String aceitaPermutaOutroBem;

    @JacksonXmlProperty(localName = "ValorPermutaCarro")
    private String valorPermutaCarro;

    @JacksonXmlProperty(localName = "ValorPermutaOutroBem")
    private String valorPermutaOutroBem;

    @JacksonXmlProperty(localName = "RENAVAN")
    private String renavan;

    @JacksonXmlProperty(localName = "Chassis")
    private String chassis;

    @JacksonXmlProperty(localName = "Chassis2")
    private String chassis2;

    @JacksonXmlProperty(localName = "Observacao")
    private String observacao;

    @JacksonXmlProperty(localName = "PossuiRastrador")
    private String possuiRastrador;

    @JacksonXmlProperty(localName = "Importado")
    private String importado;

    @JacksonXmlProperty(localName = "Blindado")
    private String blindado;

    @JacksonXmlProperty(localName = "Sucata")
    private String sucata;

    @JacksonXmlProperty(localName = "ProprioPortadoresDeficiencia")
    private String proprioPortadoresDeficiencia;

    @JacksonXmlProperty(localName = "IPVAPago")
    private String ipvapago;

    @JacksonXmlProperty(localName = "RevisadoConcessionaria")
    private String revisadoConcessionaria;

    @JacksonXmlProperty(localName = "GarantiaFabrica")
    private String garantiaFabrica;

    @JacksonXmlProperty(localName = "Licenciado")
    private String licenciado;

    @JacksonXmlProperty(localName = "VendidoAguardandoFaturamento")
    private String vendidoAguardandoFaturamento;

    @JacksonXmlProperty(localName = "Batido")
    private String batido;

    @JacksonXmlProperty(localName = "EntradaFacilitada")
    private String entradaFacilitada;

    @JacksonXmlProperty(localName = "AirBag")
    private String airBag;

    @JacksonXmlProperty(localName = "AirBagMotorista")
    private String airBagMotorista;

    @JacksonXmlProperty(localName = "AirBagDuplo")
    private String airBagDuplo;

    @JacksonXmlProperty(localName = "ArCondicionado")
    private String arCondicionado;

    @JacksonXmlProperty(localName = "ArQuente")
    private String arQuente;

    @JacksonXmlProperty(localName = "DesembacadorTraseiro")
    private String desembacadorTraseiro;

    @JacksonXmlProperty(localName = "CDPlayer")
    private String cdPlayer;

    @JacksonXmlProperty(localName = "DVDPlayer")
    private String dvdPlayer;

    @JacksonXmlProperty(localName = "Radio")
    private String radio;

    @JacksonXmlProperty(localName = "TocaFitas")
    private String tocaFitas;

    @JacksonXmlProperty(localName = "FreiosABS")
    private String freiosABS;

    @JacksonXmlProperty(localName = "RodasLigaLeve")
    private String rodasLigaLeve;

    @JacksonXmlProperty(localName = "TravaEletrica")
    private String travaEletrica;

    @JacksonXmlProperty(localName = "VidrosEletricos")
    private String vidrosEletricos;

    @JacksonXmlProperty(localName = "Alarme")
    private String alarme;

    @JacksonXmlProperty(localName = "BancoCouro")
    private String bancoCouro;

    @JacksonXmlProperty(localName = "DirecaoHidraulica")
    private String direcaoHidraulica;

    @JacksonXmlProperty(localName = "LimpadorTraseiro")
    private String limpadorTraseiro;

    @JacksonXmlProperty(localName = "TetoSolar")
    private String tetoSolar;

    @JacksonXmlProperty(localName = "AberturaInternaPortaMalas")
    private String aberturaInternaPortaMalas;

    @JacksonXmlProperty(localName = "AirbagCortina")
    private String airbagCortina;

    @JacksonXmlProperty(localName = "AirbagPassageiro")
    private String airbagPassageiro;

    @JacksonXmlProperty(localName = "AlarmeLuzesAcesas")
    private String alarmeLuzesAcesas;

    @JacksonXmlProperty(localName = "BancoMotoristaAjusteAltura")
    private String bancoMotoristaAjusteAltura;

    @JacksonXmlProperty(localName = "BancoTraseiroRetratil")
    private String bancoTraseiroRetratil;

    @JacksonXmlProperty(localName = "BancosDianteirosAquecimento")
    private String bancosDianteirosAquecimento;

    @JacksonXmlProperty(localName = "BancosEletricos")
    private String bancosEletricos;

    @JacksonXmlProperty(localName = "Bluetooth")
    private String bluetooth;

    @JacksonXmlProperty(localName = "BreakLight")
    private String breakLight;

    @JacksonXmlProperty(localName = "CapotaMaritima")
    private String capotaMaritima;

    @JacksonXmlProperty(localName = "CarregadorCD")
    private String carregadorCD;

    @JacksonXmlProperty(localName = "CartaoSD")
    private String cartaoSD;

    @JacksonXmlProperty(localName = "CDPlayerMP3")
    private String cdPlayerMP3;

    @JacksonXmlProperty(localName = "ComputadorBordo")
    private String computadorBordo;

    @JacksonXmlProperty(localName = "ControleEstabilidade")
    private String controleEstabilidade;

    @JacksonXmlProperty(localName = "VolanteRegulagemAltura")
    private String volanteRegulagemAltura;

    @JacksonXmlProperty(localName = "VidrosVerdes")
    private String vidrosVerdes;

    @JacksonXmlProperty(localName = "TravaEletricaCentral")
    private String travaEletricaCentral;

    @JacksonXmlProperty(localName = "TracaoQuatroPorQuatro")
    private String tracaoQuatroPorQuatro;

    @JacksonXmlProperty(localName = "ControleSomVolante")
    private String controleSomVolante;

    @JacksonXmlProperty(localName = "ControleTracao")
    private String controleTracao;

    @JacksonXmlProperty(localName = "DirecaoEletrica")
    private String direcaoEletrica;

    @JacksonXmlProperty(localName = "Disqueteira")
    private String disqueteira;

    @JacksonXmlProperty(localName = "DistribuicaoEletronicaFrenagem")
    private String distribuicaoEletronicaFrenagem;

    @JacksonXmlProperty(localName = "EncostoCabecaTraseiro")
    private String encostoCabecaTraseiro;

    @JacksonXmlProperty(localName = "EntradaAuxiliar")
    private String entradaAuxiliar;

    @JacksonXmlProperty(localName = "EntradaUSB")
    private String entradaUSB;

    @JacksonXmlProperty(localName = "FaroisRegulagemInterna")
    private String faroisRegulagemInterna;

    @JacksonXmlProperty(localName = "FaroisNeblinaDianteiros")
    private String faroisNeblinaDianteiros;

    @JacksonXmlProperty(localName = "FaroisNeblinaTraseiros")
    private String faroisNeblinaTraseiros;

    @JacksonXmlProperty(localName = "FarolNeblina")
    private String farolNeblina;

    @JacksonXmlProperty(localName = "FarolXenonio")
    private String farolXenonio;

    @JacksonXmlProperty(localName = "ImobilizadorMotor")
    private String imobilizadorMotor;

    @JacksonXmlProperty(localName = "GPS")
    private String gps;

    @JacksonXmlProperty(localName = "ParaChoquesCorVeiculo")
    private String paraChoquesCorVeiculo;

    @JacksonXmlProperty(localName = "PilotoAutomatico")
    private String pilotoAutomatico;

    @JacksonXmlProperty(localName = "PortaCopos")
    private String portaCopos;

    @JacksonXmlProperty(localName = "ProtetorCacamba")
    private String protetorCacamba;

    @JacksonXmlProperty(localName = "QuebraMato")
    private String quebraMato;

    @JacksonXmlProperty(localName = "RetrovisorFotocromico")
    private String retrovisorFotocromico;

    @JacksonXmlProperty(localName = "RadioTocaFitas")
    private String radioTocaFitas;

    @JacksonXmlProperty(localName = "RetrovisoresEletricos")
    private String retrovisoresEletricos;

    @JacksonXmlProperty(localName = "SantoAntonio")
    private String santoAntonio;

    @JacksonXmlProperty(localName = "SensorChuva")
    private String sensorChuva;

    @JacksonXmlProperty(localName = "SensorEstacionamento")
    private String sensorEstacionamento;

    @JacksonXmlProperty(localName = "SensorLuz")
    private String sensorLuz;

    @JacksonXmlProperty(localName = "SuporteEstepe")
    private String suporteEstepe;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Fotos")
    private Fotos fotos;

    @JacksonXmlProperty(localName = "EmDestaque")
    private String emDestaque;
}

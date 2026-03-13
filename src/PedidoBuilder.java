import java.util.ArrayList;
import java.util.List;

public class PedidoBuilder {
    private String tipo;
    private String tamanho;
    private String pagamento;
    private List<String> itens= new ArrayList<>();
    private String tipoPao;
    private String tipoMassa;
    private boolean bordaRecheada;
    private String entrega;
    private String enderecoEntrega;
    private String cupom;
    private String observacao;
    private double TrocoPara;

    public PedidoBuilder tipoHamburguer(){
        this.tipo= "HAMBURGUER";
        return this;
    }
    public PedidoBuilder tipoPizza(){
        this.tipo= "PIZZA";
        return this;
    }

    public PedidoBuilder tamanhoP(){
        this.tamanho= "P";
        return this;
    }
    public PedidoBuilder tamanhoM(){
        this.tamanho= "M";
        return this;
    }
    public PedidoBuilder tamanhoG(){
        this.tamanho= "G";
        return this;
    }

    public PedidoBuilder pagarComPix(){
        this.pagamento= "PIX";
        return this;
    }
    public PedidoBuilder pagarComCartao(){
        this.pagamento= "CARTÃO";
        return this;
    }
    public PedidoBuilder pagarComDinheiro(){
        this.pagamento= "DINHEIRO";
        return this;
    }

    public PedidoBuilder comTrocoPara(double valor){
        this.TrocoPara= valor;
        return this;
    }

    public PedidoBuilder entregaDelivery(String endereco){
        this.entrega= "DELIVERY";
        this.enderecoEntrega= endereco;
        return this;
    }
    public PedidoBuilder entregaRetirada(){
        this.entrega= "RETIRADA";
        return this;
    }

    public PedidoBuilder tipoPao(String pao){
        this.tipoPao= pao;
        return this;
    }

    public PedidoBuilder tipoMassa(String massa){
        this.tipoMassa= massa;
        return this;
    }

    public PedidoBuilder comBordaRecheada(){
        this.bordaRecheada= true;
        return this;
    }
    public PedidoBuilder semBordaRecheada(){
        this.bordaRecheada= false;
        return this;
    }

    public PedidoBuilder addItem(String item){
        itens.add(item);
        return this;
    }

    public PedidoBuilder comCupom(String cupom){
        this.cupom= cupom;
        return this;
    }

    public PedidoBuilder comObservacao(String obs){
        this.observacao= obs;
        return this;
    }

    public Pedido build(){
        if (tipo==null || !List.of("HAMBURGUER","PIZZA").contains(tipo)){ throw new IllegalStateException("Tipo deve ser HAMBURGUER ou PIZZA.");}
        if (tamanho==null || !List.of("P","M","G").contains(tamanho)){ throw new IllegalStateException("Tamanho deve ser P, M ou G.");}
        if (pagamento==null || !List.of("PIX","CARTÃO","DINHEIRO").contains(pagamento)){throw new IllegalStateException("Pagamento deve ser PIX, CARTAO ou DINHEIRO.");}
        if (itens.size() < 1) { throw new IllegalStateException("Pedido precisa de pelo menos 1 item.");}
        if (entrega==null || !List.of("DELIVERY", "RETIRADA").contains(entrega)){ throw new IllegalStateException("Informe corretamente o modo de entrega, DELIVERY ou RETIRADA.");}

        if (tipo.equals("HAMBURGUER")){
            if (!List.of("BRIOCHE","TRADICIONAL","INTEGRAL").contains(tipoPao)){ throw new IllegalStateException("O tipo do pão deve ser BRIOCHE, TRADICIONAL ou INTEGRAL.");}
            if (tipoMassa!=null){ throw new IllegalStateException("O tipo da massa é somente para PIZZA.");}
            if (bordaRecheada){ throw new IllegalStateException("Borda recheada é somente para PIZZA.");}
        } else if (tipo.equals("PIZZA")) {
            if (!List.of("FINA","TRADICIONAL","PAN").contains(tipoMassa)){ throw new IllegalStateException("O tipo da massa deve ser FINA, TRADICIONAL ou PAN.");}
            if (tipoPao!=null){ throw new IllegalStateException("O tipo do pão é somente para HAMBURGUER.");}
            if (!List.of(true, false).contains(bordaRecheada)){ throw new IllegalStateException("Deve escolher se deseja borda recheada.");}
        }

        if (entrega.equals("DELIVERY")){
            if (enderecoEntrega.equals("") || enderecoEntrega==null){ throw new IllegalStateException("Deve informar o endereço de entrega.");}
        } else if (entrega.equals("RETIRADA")) {
            if (enderecoEntrega!=null){ throw new IllegalStateException("Endereço não será utilizado, permanecer vazio.");}
        }

        if (!pagamento.equals("DINHEIRO")){
            if (TrocoPara!=0.0){ throw new IllegalStateException("Troco somente para pagamento em dinheiro.");}
        } else if (pagamento.equals("DINHEIRO")) {
            if (TrocoPara<0){ throw new IllegalStateException("Informe o valor para troco corretamente.");}
        }

        return new Pedido(tipo, tamanho, pagamento, itens, tipoPao, tipoMassa, bordaRecheada, entrega, enderecoEntrega, cupom, observacao, TrocoPara);
    }
}

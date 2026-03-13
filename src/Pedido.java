import java.util.List;

public class Pedido {
    private final String tipo;
    private final String tamanho;
    private final String pagamento;
    private final List<String> itens;
    private final String tipoPao;
    private final String tipoMassa;
    private final boolean bordaRecheada;
    private final String entrega;
    private final String enderecoEntrega;
    private final String cupom;
    private final String observacao;
    private final double TrocoPara;

    public Pedido(String tipo, String tamanho, String pagamento, List<String> itens, String tipoPao, String tipoMassa, boolean bordaRecheada, String entrega, String enderecoEntrega, String cupom, String observacao, double trocoPara) {
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.pagamento = pagamento;
        this.itens = itens;
        this.tipoPao = tipoPao;
        this.tipoMassa = tipoMassa;
        this.bordaRecheada = bordaRecheada;
        this.entrega = entrega;
        this.enderecoEntrega = enderecoEntrega;
        this.cupom = cupom;
        this.observacao = observacao;
        TrocoPara = trocoPara;
    }

    public void printResumo(){
        if (tipo.equals("HAMBURGUER")){
        System.out.printf("""
                tipo = %s
                tamanho = %s
                pão = %s
                itens: %s
                pagamento = %s
                troco para = %.2f
                entrega = %s %s
                observação: %s
                cupom = %s
                
                """, tipo, tamanho, tipoPao, itens, pagamento, pagamento.equals("DINHEIRO")?TrocoPara:0.0, entrega, entrega.equals("DELIVERY")?enderecoEntrega:"", observacao!=null?observacao:"", cupom!=null?cupom:"Sem cupom" );
        } else if (tipo.equals("PIZZA")) {
            System.out.printf("""
                    tipo = %s
                    tamanha = %s
                    massa = %s
                    bordaRecheada = %s
                    itens: %s
                    pagamento = %s
                    troco para = %.2f
                    entrega = %s %s
                    observação: %s
                    cupom = %s
                    
                    """, tipo, tamanho, tipoMassa, bordaRecheada?"SIM":"NÃO", itens, pagamento, pagamento.equals("DINHEIRO")?TrocoPara:0, entrega, entrega.equals("DELIVERY")?enderecoEntrega:"", observacao!=null?observacao:"", cupom!=null?cupom:"Sem cupom" );

        }

    }

}

public class Main {
    public static void main(String[] args) {
        PedidoBuilder pedido= new PedidoBuilder();
        pedido.tipoHamburguer();
        pedido.tipoPao("BRIOCHE");
        pedido.tamanhoM();
        pedido.addItem("X-Bacon");
        pedido.pagarComPix();
        pedido.entregaDelivery("Rua B, 860");
        pedido.comObservacao("sem cebola");
        pedido.build();
        pedido.build().printResumo();

        PedidoBuilder pedido2= new PedidoBuilder();
        pedido2.tipoPizza();
        pedido2.tipoMassa("FINA");
        pedido2.tamanhoG();
        pedido2.addItem("Pizza Calabresa");
        pedido2.comBordaRecheada();
        pedido2.pagarComCartao();
        pedido2.entregaRetirada();
        pedido2.comCupom("10OFF");
        pedido2.build();
        pedido2.build().printResumo();

        PedidoBuilder pedido3= new PedidoBuilder();
        pedido3.tipoHamburguer();
        pedido3.tipoPao("BRIOCHE");
        pedido3.tamanhoM();
        pedido3.addItem("X-Bacon");
        pedido3.pagarComDinheiro();
        pedido3.comTrocoPara(100);
        pedido3.entregaDelivery("Rua D, 521");
        pedido3.build();
        pedido3.build().printResumo();

        PedidoBuilder pedido4= new PedidoBuilder();
        pedido4.tipoHamburguer();
        pedido4.tipoPao("BRIOCHE");
        pedido4.comBordaRecheada();
        pedido4.tamanhoM();
        pedido4.addItem("X-Bacon");
        pedido4.pagarComPix();
        pedido4.entregaDelivery("Rua A, 379");
        pedido4.comObservacao("sem salada");
        pedido4.build();
        pedido4.build().printResumo();
    }
}

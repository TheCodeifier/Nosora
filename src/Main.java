interface VerzendService {
    void verzend(String product);
}

class DHLService implements VerzendService {
    @Override
    public void verzend(String product) {
        System.out.println("Verzenden met DHL: " + product);
    }
}

class PostNLService implements VerzendService {
    @Override
    public void verzend(String product) {
        System.out.println("Verzenden met PostNL: " + product);
    }
}

class Webshop {
    private VerzendService verzendService;

    public Webshop(VerzendService verzendService) {
        this.verzendService = verzendService;
    }

    public void verwerkBestelling(String product) {
        System.out.println("Bestelling verwerkt: " + product);
        verzendService.verzend(product);
    }
}

class Main {
    public static void main(String[] args) {
        VerzendService dhl = new DHLService();
        VerzendService postnl = new PostNLService();

        Webshop webshop1 = new Webshop(dhl);
        Webshop webshop2 = new Webshop(postnl);

        webshop1.verwerkBestelling("Laptop");
        webshop2.verwerkBestelling("Boek");
    }
}


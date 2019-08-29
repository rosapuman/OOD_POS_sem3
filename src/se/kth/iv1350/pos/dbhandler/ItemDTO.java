package se.kth.iv1350.pos.dbhandler;

public class ItemDTO
{
    double  price;
    double  vatRate;
    int     quantity;
    String  name;
    int     identifier;

    public ItemDTO(String name, int identifier, double vatRate, double price, int quantity) // Konstruktor sätter värden
    {
        this.price = price;
        this.vatRate = vatRate;
        this.quantity = quantity;
        this.name = name;
        this.identifier = identifier;
    }

    public ItemDTO(ItemDTO item)
    {
        this.price = item.price;
        this.vatRate = item.vatRate;
        this.quantity = item.quantity;
        this.name = item.name;
        this.identifier = item.identifier;
    }

    public String getName() {
        return name;
    }

    public double getPrice(){
        return price;
    }

    public int getIdentifier(){
        return identifier;
    }

    public double getVatRate(){
        return vatRate;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int i)
    {
        quantity = i;
    }
}


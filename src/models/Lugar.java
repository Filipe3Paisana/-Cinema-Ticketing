package models;

public class Lugar {
    int state;
    double price;
    Pessoa Pessoa;

    public Lugar(int state, double price, Pessoa pessoa) {
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Pessoa getPessoa() {
        return this.Pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.Pessoa = pessoa;
    }

}

import java.util.Scanner;

class Pozycja {
    String nazwaTowaru;
    int ileSztuk;
    double cena;

    public Pozycja(String nazwaTowaru, int ileSztuk, double cena) {
        this.nazwaTowaru = nazwaTowaru;
        this.ileSztuk = ileSztuk;
        this.cena = cena;
    }

    public double obliczWartosc() {
        return ileSztuk * cena;
    }

    public double obliczWartoscZrabatem() {
        double wartosc = obliczWartosc();

        if (ileSztuk >= 5 && ileSztuk < 10) {
            return wartosc * 0.95;
        } else if (ileSztuk >= 10 && ileSztuk < 20) {
            return wartosc * 0.90;
        } else if (ileSztuk >= 20) {
            return wartosc * 0.85;
        } else {
            return wartosc;
        }
    }

    @Override
    public String toString() {
        return String.format("%-20s %10.2f zł %4d szt. %10.2f zł",
                nazwaTowaru, cena, ileSztuk, obliczWartosc());
    }
}
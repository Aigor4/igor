public class Program {
    public static void main(String[] args) {
        Zamowienie z = new Zamowienie();
        z.dodajPozycje(new Pozycja("Cukier", 3, 4.00));
        z.dodajPozycje(new Pozycja("Woda", 30, 0.69));
        z.dodajPozycje(new Pozycja("Krem", 1, 40.00));
        z.dodajPozycje(new Pozycja("Chleb", 2, 8.00));
        z.dodajPozycje(new Pozycja("Biblia", 3000, 15.00));
        System.out.println(z);
    }
}
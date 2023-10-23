import java.util.Scanner;

class Zamowienie {
    private Pozycja[] pozycje;
    private int ileDodanych;
    private int maksRozmiar;

    public Zamowienie() {
        this.maksRozmiar = 10;
        this.pozycje = new Pozycja[maksRozmiar];
        this.ileDodanych = 0;
    }


    public void dodajPozycje(Pozycja p) {
        for (int i = 0; i < ileDodanych; i++) {
            if (pozycje[i].nazwaTowaru.equals(p.nazwaTowaru)) {
                pozycje[i].ileSztuk += p.ileSztuk;
                return;
            }
        }

        if (ileDodanych < maksRozmiar) {
            pozycje[ileDodanych] = p;
            ileDodanych++;
        } else {
            System.out.println("Osiągnięto maksymalną liczbę pozycji w zamówieniu.");
        }
    }

    public void usunPozycje(int indeks) {
        if (indeks < 0 || indeks >= ileDodanych) {
            System.out.println("Nieprawidłowy indeks.");
            return;
        }

        for (int i = indeks; i < ileDodanych - 1; i++) {
            pozycje[i] = pozycje[i + 1];
        }
        ileDodanych--;
    }

    public void edytujPozycje(int indeks) {
        if (indeks < 0 || indeks >= ileDodanych) {
            System.out.println("Nieprawidłowy indeks.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj nową nazwę towaru: ");
        pozycje[indeks].nazwaTowaru = scanner.nextLine();
        System.out.print("Podaj nową cenę: ");
        pozycje[indeks].cena = scanner.nextDouble();
        System.out.print("Podaj nową liczbę sztuk: ");
        pozycje[indeks].ileSztuk = scanner.nextInt();
    }

    public double obliczWartosc() {
        double suma = 0;
        double sumaZrabatem = 0;

        for (int i = 0; i < ileDodanych; i++) {
            suma += pozycje[i].obliczWartosc();
            sumaZrabatem += pozycje[i].obliczWartoscZrabatem();
        }

        double rabat = suma - sumaZrabatem;

        System.out.println("Koszt bez rabatu: " + suma + " zł");
        System.out.println("Rabat: " + rabat + " zł");
        System.out.println("Koszt po uwzględnieniu rabatu: " + sumaZrabatem + " zł");

        return sumaZrabatem;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        double rabat = 0;

        for (int i = 0; i < ileDodanych; i++) {
            Pozycja pozycja = pozycje[i];
            double wartosc = pozycja.obliczWartosc();
            double wartoscZRabatem = pozycja.obliczWartoscZrabatem();
            rabat += wartosc - wartoscZRabatem;

            sb.append(pozycja.toString()).append("\n");
            sb.append("Wartość z rabatem: ").append(wartoscZRabatem).append(" zł\n\n");
        }


        sb.append("Łączna wartość zamówienia: ").append(obliczWartosc()).append(" zł\n");
        sb.append("Rabat łącznie: ").append(rabat).append(" zł");

        return sb.toString();
    }
}